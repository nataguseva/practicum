package ru.list.nataguseva.API;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.list.nataguseva.API.pojos.PagePojo;
import ru.list.nataguseva.API.pojos.UserPojoFull;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;

public class RestTest<test1IsPassed> {
    private static RequestSpecification spec;
    private static int perPage;
    private static PagePojo page1;
    private static PagePojo page2;
    private static UserPojoFull[] users;
    private static int pageCounter;
    static boolean test1IsPassed;
    static boolean test2IsPassed;
    public static int getNextPageCounter (int pageCounter) {
        return pageCounter + 1;
    }

    @BeforeClass
    public static void initSpec() {
        spec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri("https://reqres.in/api")
                .setBasePath("/users")
                .build();
    }

    @Test
    public void getPage() {
        pageCounter = 1;
        page1 = given()
                .spec(spec)
                .param("page", pageCounter)
                .when()
                .get()
                .then()
                .extract().as(PagePojo.class);
        System.out.println(page1.getData());


        System.out.println(page1.getPerPage());
       /** users = page1.getData();
        for (int i = 0; i < pageCounter; i++) {
            boolean test1IsPassed = false;
            UserPojoFull user = new UserPojoFull(users[i].getLastName(), users[i].getId(), users[i].getAvatar(), users[i].getFirstName(), users[i].getEmail());
            if ("George".equals(user.getFirstName())
                    && "Bluth".equals(user.getLastName())
                    && "george.bluth@reqres.in".equals(user.getEmail())) {
                test1IsPassed = true;
                }
            else {
                continue;
            }
        }
        getNextPageCounter(pageCounter);



        Assert.assertTrue(test1IsPassed);
        System.out.println(users.length);
        System.out.println(users[1]);
*/
    }


}




