package peterkaras.com;

import org.junit.*;

public class DataBuilderTest
{

    DataBuilder dataBuilder = new DataBuilder();
    @Test
    public void shouldReturnJSON(){
        String result = dataBuilder.build();
        Assert.assertEquals("{'details':{'name':'brian','age':27}}",result);
    }
    @Test
    public void shouldGetProperty(){
        String result = dataBuilder.getProperty("details.name");
        Assert.assertEquals("brian",result);
    }

    @Test
    public void shouldSetProperty(){
        String result = dataBuilder.withProperty("details.name","peter").getProperty("details.name");
        Assert.assertEquals("peter",result);
    }
    @Test
    public void shouldSetPropertyAndReturnJSON(){
        String result = dataBuilder.withProperty("details.name","peter").build();
        Assert.assertEquals("{\"details\":{\"name\":\"peter\",\"age\":27}}",result);
    }
}
