package playground;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MoreAboutDataTable {


    @Test(dataProvider = "testDataWithObjects")
    public void someTesting(String name, Integer expectedLength){
        Assert.assertEquals(name.length(),expectedLength,"Name length should match");
    }

    @DataProvider
    public Object[][] testDataWithObjects() {
        Object[][] data = {
        {"AliSafa", 7},
        {"Angi", 4},
        {"Virginia", 8}
    };
    return data;
      }
      
    @DataProvider
    public Person[] testWithCustomPOJO(){
        return new Person[]{
                new Person("ali",3),
                new Person("Alen",4)
        };
    }

}
