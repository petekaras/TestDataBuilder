package peterkaras.com;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;

/**
 * Created by peter on 7/7/16.
 * Build json data with a fluid API
 */
public class DataBuilder {

    private String json = "{'details':{'name':'brian','age':27}}";

    public String build(){
        return json;
    }

    public DataBuilder withProperty(final String property,final String value){
        json = JsonPath.parse(json).set(property,value).jsonString();
        return this;

    }

    public String getProperty(final String property){
        Object document = Configuration.defaultConfiguration().jsonProvider().parse(json);
        return JsonPath.read(document,property);
    }
}
