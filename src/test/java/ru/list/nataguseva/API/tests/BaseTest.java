package ru.list.nataguseva.API.tests;

import io.restassured.specification.RequestSpecification;
import lombok.Data;
import org.junit.Assert;
import ru.list.nataguseva.API.pojos.ResponsePojo;
import ru.list.nataguseva.API.pojos.UserPojo;
import ru.list.nataguseva.UI.helpers.ConfProperties;

import static io.restassured.RestAssured.given;

@Data
public class BaseTest {

    public static String actualEmail;

    private static RequestSpecification spec;

    private final static int PAGE_AND_USER_COUNTER = 1;

    private final static String EXPECTED_FIRST_NAME = ConfProperties.getProperty("user" + PAGE_AND_USER_COUNTER + ".firstName");

    private final static String EXPECTED_LAST_NAME = ConfProperties.getProperty("user" + PAGE_AND_USER_COUNTER + ".lastName");

    private final static String EXPECTED_EMAIL = ConfProperties.getProperty("user" + PAGE_AND_USER_COUNTER + ".email");


    public void getResponse() {
        ResponsePojo response = given()
                .spec(spec)
                .when()
                .get()
                .then()
                .statusCode(200)
                .extract().as(ResponsePojo.class);

        UserPojo[] users = response.getData();
        for (UserPojo user : users) {
            if (
                    (EXPECTED_FIRST_NAME.equals(user.getFirstName()))
                            && (EXPECTED_LAST_NAME.equals(user.getLastName()))
            ) {
                actualEmail = user.getEmail();
                Assert.assertEquals(actualEmail, EXPECTED_EMAIL);
            }
        }
    }

}
