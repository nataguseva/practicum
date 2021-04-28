package ru.list.nataguseva.API.tests.testSuit;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.list.nataguseva.API.pojos.ResponsePojo;
import ru.list.nataguseva.API.pojos.UserPojo;
import ru.list.nataguseva.UI.helpers.ConfProperties;

import static io.restassured.RestAssured.given;

public class Test2 {
    private static RequestSpecification spec;
    private static ResponsePojo response;
    private static UserPojo[] users;
    private final static int pageAndUserCounter = 2;
    static boolean testIsPassed = false;
    private static String actualEmail;

    private final static String expectedFirstName = ConfProperties.getProperty("user" + getPageAndUserCounter() + ".firstName");
    private final static String expectedLastName = ConfProperties.getProperty("user" + getPageAndUserCounter() + ".lastName");
    private final static String expectedEmail = ConfProperties.getProperty("user" + getPageAndUserCounter() + ".email");

    public static int getPageAndUserCounter() {
        return pageAndUserCounter;
    }

    @BeforeClass
    public static void initSpec() {
        spec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(ConfProperties.getProperty("baseURI"))
                .setBasePath(ConfProperties.getProperty("endpoint"))
                .addParam("page", getPageAndUserCounter())
                .build();
    }

    @Test
    public void getResponse() {
        response = given()
                .spec(spec)
                .when()
                .get()
                .then()
                .statusCode(200)
                .extract().as(ResponsePojo.class);

        users = response.getData();
        for (UserPojo userPojo : users) {
            UserPojo user = new UserPojo(userPojo.getLastName(), userPojo.getId(), userPojo.getAvatar(), userPojo.getFirstName(), userPojo.getEmail());
            if (
                    (expectedFirstName.equals(user.getFirstName()))
                            && (expectedLastName.equals(user.getLastName()))
            ) {
                actualEmail = user.getEmail();
                testIsPassed = expectedEmail.equals(actualEmail);
            }
        }
        if (!testIsPassed) {
            System.out.println(
                    "Expected email for "
                            + expectedFirstName
                            + " "
                            + expectedLastName
                            + " is "
                            + expectedEmail
                            + "\n"
                            + "Actual email is "
                            + actualEmail
            );
        }
        Assert.assertTrue(testIsPassed);
    }
}