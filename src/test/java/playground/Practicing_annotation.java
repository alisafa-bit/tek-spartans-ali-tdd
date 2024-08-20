package playground;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Practicing_annotation {


    @Test(dataProvider = "addingData")
   public void adding(int numberOne, int numberTwo, int expectedNumber) {
       int result = numberOne + numberTwo;
        Assert.assertEquals(result,expectedNumber);
   }

   @DataProvider(name = "addingData")
   public Integer[][] testData (){
        return new Integer[][]{
                {4, 6, 10},
                {12, 12, 24},
                {2, 4, 6},
                {33,22,55}
        };
   }


}
