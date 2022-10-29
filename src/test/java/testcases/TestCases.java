package testcases;

import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import org.approvaltests.Approvals;
import org.testng.annotations.Test;
import testdata.Data;
import utilities.APIBase;
import utilities.APIConstant;

import java.util.HashMap;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static utilities.APIVerification.responsecodeValidation;

public class TestCases extends APIBase {


    //Generating API URL
    public static String uri=APIConstant.APIPaths.SEARCH_BREED_BY_NAME;
    public static APIBase apiBase;
    HashMap<String, String> query = new HashMap<>();
    ResponseOptions<Response> response;

    @Test(priority = 1, dataProvider = "validFullName", dataProviderClass = Data.class)
    public void searchBreedByFullName(String searchBreedByName) {
        //Setting up the URI with Required "HTTP Crud Operation" and Query parameter
        apiBase=new APIBase(uri, "GET");
        query.put("q", searchBreedByName);

        //Executing API
        response = apiBase.ExecuteWithQueryParams(query);

        //Validating Response Code
        responsecodeValidation(response, 200);

        //Json Schema Validator
        jsonSchemaValidator(response, "breed.json");

        //Verifying Whole JSON Response using approvaltests library // Sample file: TestCases.searchBreedByFullName.approved.txt
        Approvals.verify(response.body().prettyPrint());

        //Validating API Response and Key Values using Jackson
        assertThat("Response Is Valid", new TestCaseHelper().searchByNameisValid(response, searchBreedByName), equalTo(true));
    }

    @Test(priority = 2, dataProvider = "validPartialName", dataProviderClass = Data.class)
    public void searchBreedBySubValidFullName(String searchBreedByPartialName) {
        //Setting up the URI with Required "HTTP Crud Operation" and Query parameter
        apiBase=new APIBase(uri, "GET");
        query.put("q", searchBreedByPartialName);

        //Executing API
        response = apiBase.ExecuteWithQueryParams(query);

        //Validating Response Code
        responsecodeValidation(response, 200);

        //Json Schema Validator
        jsonSchemaValidator(response, "breed.json");

        assertThat("Response Is Valid", new TestCaseHelper().searchByNameisValid(response, searchBreedByPartialName), equalTo(true));
    }


    @Test(priority = 3, dataProvider = "invalidParameter", dataProviderClass = Data.class)
    public void searchBreedByInvalidParameter(String invalidParameter) {
        //Setting up the URI with Required "HTTP Crud Operation" and Query parameter
        apiBase=new APIBase(uri, "GET");
        query.put("q", invalidParameter);

        //Executing API
        response = apiBase.ExecuteWithQueryParams(query);

        //Validating Response Code
        responsecodeValidation(response, 200);

        //Json Schema Validator
        jsonSchemaValidator(response, "breed.json");

        assertThat("Response Is Valid", new TestCaseHelper().searchByNameWithInvalidParameter(response, invalidParameter), equalTo(true));
    }

    @Test(priority = 4, dataProvider = "specialCharacters", dataProviderClass = Data.class)
    public void searchBreedBySpecialCharacters(String specialCharacters) {
        //Setting up the URI with Required "HTTP Crud Operation" and Query parameter
        apiBase=new APIBase(uri, "GET");
        query.put("q", specialCharacters);

        //Executing API
        response = apiBase.ExecuteWithQueryParams(query);

        //Validating Response Code
        responsecodeValidation(response, 200);

        //Json Schema Validator
        jsonSchemaValidator(response, "breed.json");

        assertThat("Response Is Valid", new TestCaseHelper().searchByNameWithInvalidParameter(response, specialCharacters), equalTo(true));
    }

    @Test(priority = 5)
    public void searchBreedWithoutQueryParamater() {
        //Setting up the URI with Required "HTTP Crud Operation" and Query parameter
        apiBase=new APIBase(uri, "GET");
        query.put("q", "");

        //Executing API
        response = apiBase.ExecuteWithQueryParams(query);

        //Validating Response Code
        responsecodeValidation(response, 200);

        //Json Schema Validator
        jsonSchemaValidator(response, "breed.json");

        assertThat("Response Is Valid", new TestCaseHelper().searchByNameWithInvalidParameter(response, ""), equalTo(true));
    }


}
