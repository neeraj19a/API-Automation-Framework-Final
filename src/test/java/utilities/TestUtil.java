package utilities;

import io.restassured.http.Headers;
import io.restassured.internal.RestAssuredResponseImpl;
import io.restassured.response.Response;

public class TestUtil extends APIBase {

    public TestUtil(String uri, String method) {
        super(uri, method);
    }

    public static void logInReport(Object object) {
        if (object instanceof RestAssuredResponseImpl) {
            Response obj = (Response) object;

            log.info("API Response" + " \n" + obj.getBody().asString());

            testLevelLog.get().info("<details>" + "<summary>" + "<b>" + "<font color=" + "green>" + "API Response"
                    + "</font>" + "</b >" + "</summary>" + obj.getBody().asString() + "</details>"
                    + " \n");
        } else if (object instanceof Headers) {
            log.info("Headers are here" + " \n" + Headers.class.cast(object) + "\n" + "\n");

            testLevelLog.get().info("<details>" + "<summary>" + "<b>" + "<font color=" + "green>" + "Headers are here"
                    + "</font>" + "</b >" + "</summary>" + Headers.class.cast(object) + "</details>"
                    + " \n");
        }
    }

    public static void logInReport(String string) {
        if (string.contains("Error")) {

            log.error("Errors are here" + " \n" + string);
            testLevelLog.get().fail("<details>" + "<summary>" + "<b>" + "<font color=" + "red>" + "Error Occurred "
                    + "</font>" + "</b >" + "</summary>" + string + "</details>"
                    + " \n");
        } else {
            log.info("Response is Here" + " \n" + string);
            testLevelLog.get().info("<details>" + "<summary>" + "<b>" + "<font color=" + "green>" + " Response is Here "
                    + "</font>" + "</b >" + "</summary>" + string + "</details>"
                    + " \n");
        }
    }

    public static void logInReport(Object object, String method) {
        if (object.toString().contains(method)) {

            log.info("Request is Here" + " \n" + String.class.cast(object));
            testLevelLog.get().info("<details>" + "<summary>" + "<b>" + "<font color=" + "green>" + method + " Request is Here "
                    + "</font>" + "</b >" + "</summary>" + String.class.cast(object) + "</details>"
                    + " \n");

        }
    }

    public static void logTimeInReport(Long time) {

        log.info("API Response Time is " + time);
        testLevelLog.get().info("<summary>" + "<b>" + "<font color=" + "green>" + " API Response Time is  " + time +
                "</font>" + "</b >" + "</summary>"
                + " \n");


    }

}