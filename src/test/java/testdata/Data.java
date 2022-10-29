package testdata;

import org.testng.annotations.DataProvider;

public class Data {

    @DataProvider(name = "validFullName")
    public Object[][] validFullName() {
        return new Object[][]{{"Abyssinian"}};
    }

    @DataProvider(name = "validPartialName")
    public Object[][] validPartialName() {
        return new Object[][]{{"Abyss"}};
    }

    @DataProvider(name = "invalidParameter")
    public Object[][] invalidParameter() {
        return new Object[][]{{"23467890"}, {"AS!@#$%^"}, {"  65AS"}, {" dfggdf545 "}, {"AbyssinianAbyssinian"}};
    }

    @DataProvider(name = "specialCharacters")
    public Object[][] specialCharacters() {
        return new Object[][]{{"*"}};
    }

}
