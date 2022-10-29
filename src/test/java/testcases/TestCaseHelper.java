package testcases;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import org.junit.Assert;
import pojo.Breed;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;

public class TestCaseHelper {

    /**
     * This function validates the breedname in response and other key values in JSON Response
     *
     * @param response
     * @param breedname
     * @return flag
     */
    public boolean searchByNameisValid(ResponseOptions<Response> response, String breedname) {
        //Using JackSon ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        boolean flag = false;
        try {
            List<Breed> breed = Arrays.asList(mapper.readValue(response.getBody().asString(), Breed[].class));

            for (int i = 0; i < breed.size(); i++) {


                Assert.assertTrue("Breed Name", breed.get(i).getName().contains(breedname));
                //Using Assertions of Hamcrest
                assertThat("Breed Id", breed.get(i).getId(), notNullValue());
                assertThat("Breed Description()", breed.get(i).getDescription(), notNullValue());
                /*we can extend more assertions depending on how many keys are mandatory to check in Response
                OR
                 we can use Library "approvaltests" and store sample JSON Response and compare all long JSON Response*/
                flag = true;
            }
        } catch (JsonProcessingException e) {
            flag = false;
            e.printStackTrace();
        }

        return flag;
    }

    /**
     * This function validates the Response is Blank if  query parameters are invalid
     *
     * @param response
     * @param breedname
     * @return flag
     */
    public boolean searchByNameWithInvalidParameter(ResponseOptions<Response> response, String breedname) {
        //Using JackSon ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        boolean flag = false;
        try {
            List<Breed> breed = Arrays.asList(mapper.readValue(response.getBody().asString(), Breed[].class));
            assertThat("Breed Size", breed.size(), equalTo(0));
            flag = true;

        } catch (JsonProcessingException e) {
            flag = false;
            e.printStackTrace();
        }

        return flag;
    }

}
