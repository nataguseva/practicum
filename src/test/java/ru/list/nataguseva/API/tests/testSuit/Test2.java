package ru.list.nataguseva.API.tests.testSuit;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.list.nataguseva.API.pojos.ResponsePojo;
import ru.list.nataguseva.API.pojos.UserPojo;
import ru.list.nataguseva.API.tests.BaseTest;
import ru.list.nataguseva.UI.helpers.ConfProperties;

import static io.restassured.RestAssured.given;

public class Test2 extends BaseTest {

    private static RequestSpecification spec;

    private final static int PAGE_AND_USER_COUNTER = 2;

    private final static String EXPECTED_FIRST_NAME = ConfProperties.getProperty("user" + PAGE_AND_USER_COUNTER + ".firstName");

    private final static String EXPECTED_LAST_NAME = ConfProperties.getProperty("user" + PAGE_AND_USER_COUNTER + ".lastName");

    private final static String EXPECTED_EMAIL = ConfProperties.getProperty("user" + PAGE_AND_USER_COUNTER + ".email");


    @BeforeClass

    public static void initSpec() {
        spec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(ConfProperties.getProperty("baseURI"))
                .setBasePath(ConfProperties.getProperty("endpoint"))
                .addParam("page", PAGE_AND_USER_COUNTER)
                .build();
    }


    @Test
    public void checkEmail() {
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
