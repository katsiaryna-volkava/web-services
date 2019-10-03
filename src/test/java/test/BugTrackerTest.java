package test;


import application.ApplicationModel;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.swing.*;

public class BugTrackerTest {

    ApplicationModel myApplication = new ApplicationModel(
            "Application for testing purposes",
            12345,
            "KVapp",
            "Katsiaryna Volkava");

    @BeforeTest
    public void initTest(){
        RestAssured.baseURI = "http://52.202.21.1:8080";
    }

    @Test
    public void checkAppCreation() {
        Response response = RestAssured.given().body(myApplication).when().post("/v1/application").andReturn();
        System.out.println(response.asString());
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void checkAppModification() {
        myApplication.setDescription("changed description");
        Response response = RestAssured.given().body(myApplication).when().put("/v1/application").andReturn();
        System.out.println(response.asString());
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void checkAppDeletion() {
        String appId = Integer.toString(myApplication.getId());
        Response response = RestAssured.when().delete("/v1/application/".concat(appId));
        System.out.println(response.asString());
        Assert.assertEquals(response.getStatusCode(), 200);
    }


    public void checkTheCorrectAppIsReturned() {

    }

}
