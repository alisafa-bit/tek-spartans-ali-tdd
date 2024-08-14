package playground;

import org.testng.Assert;

public class CopyFromSayed {
    public static String generateFullName(String firstName, String lastName){
        return firstName.toUpperCase() + ", " + firstName.toUpperCase();
    }
    public void testFullName(){
        String firstName = "ali";
        String lastName = "safa";
        String fullName = generateFullName(firstName,lastName);
        Assert.assertEquals(fullName,"ali safa");
    }
}
