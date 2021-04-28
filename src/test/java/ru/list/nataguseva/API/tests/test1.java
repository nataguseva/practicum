package ru.list.nataguseva.API.tests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import lombok.Data;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.list.nataguseva.API.pojos.ResponsePojo;
import ru.list.nataguseva.API.pojos.UserPojo;

import static io.restassured.RestAssured.given;

@Data
public class test1 {
    private static RequestSpecification spec;
    private static int perPage;
    private static ResponsePojo response;
    private static UserPojo[] users;

    public static int getPageCounter() {
        return pageCounter;
    }

    private static int pageCounter;
    static boolean testIsPassed = false;


    @BeforeClass
    public static void initSpec() {
        spec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri("https://reqres.in/api")
                .setBasePath("/users")
                .build();
    }

    @Test

    public void getResponse() {
        pageCounter = 1;
        response = given()
                .spec(spec)
                .param("page", getPageCounter())
                .when()
                .get()
                .then()
                .extract().as(ResponsePojo.class);
        System.out.println(response.getData());


        System.out.println(response.getPerPage());
        users = response.getData();
        for (int i = 0; i < users.length; i++) {
            UserPojo user = new UserPojo(users[i].getLastName(), users[i].getId(), users[i].getAvatar(), users[i].getFirstName(), users[i].getEmail());
            if ("George".equals(user.getFirstName())
                    && "Bluth".equals(user.getLastName())
                    && "george.bluth@reqres.in".equals(user.getEmail())) {
                testIsPassed = true;
            }

        }


        Assert.assertTrue(testIsPassed);
    }


}




