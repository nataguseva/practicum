package ru.list.nataguseva.API.tests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.list.nataguseva.API.pojos.*;
import ru.list.nataguseva.UI.helpers.ConfProperties;


import static io.restassured.RestAssured.given;

public class test1 {
    private static RequestSpecification spec;
    private static ResponsePojo response;
    private static UserPojo[] users;

    public static int getPageAndUserCounter() {
        return pageAndUserCounter;
    }

    private static int pageAndUserCounter = 1;
    static boolean testIsPassed = false;


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
        for (int i = 0; i < users.length; i++) {
            UserPojo user = new UserPojo(users[i].getLastName(), users[i].getId(), users[i].getAvatar(), users[i].getFirstName(), users[i].getEmail());
            if (
                    ((ConfProperties.getProperty("user" + getPageAndUserCounter() + ".firstName")).equals(user.getFirstName()))
                    && ((ConfProperties.getProperty("user" + getPageAndUserCounter() + ".lastName")).equals(user.getLastName()))
                    && ((ConfProperties.getProperty("user" + getPageAndUserCounter() + ".email")).equals(user.getEmail()))
            ) {
                testIsPassed = true;
            }

        }


        Assert.assertTrue(testIsPassed);


    }


}




