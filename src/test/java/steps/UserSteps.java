package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.junit.Assert;
import pages.UserPage;
import pages.BasePage;

public class UserSteps {
    private UserPage userPage = new UserPage();
    private Response response;

    @Before
    public void setup() {
        try {
            BasePage.initializeDriver();
            System.out.println("WebDriver initialized successfully");
        } catch (Exception e) {
            System.out.println("Error during setup: " + e.getMessage());
            throw e;
        }
    }

    @After
    public void tearDown() {
        try {
            BasePage.quitDriver();
            System.out.println("WebDriver closed successfully");
        } catch (Exception e) {
            System.out.println("Error during teardown: " + e.getMessage());
        }
    }

    @Given("user list is retrieved from first page")
    public void getUserList() {
        response = userPage.getUsers(1);
    }

    @Then("list should be retrieved successfully")
    public void verifyUserList() {
        Assert.assertEquals(200, response.getStatusCode());
        Assert.assertNotNull(response.jsonPath().getList("data"));
    }

    @Given("a new user is created")
    public void createUser() {
        response = userPage.createUser("John Doe", "Software Engineer");
    }

    @Then("user should be created successfully")
    public void verifyUserCreation() {
        Assert.assertEquals(201, response.getStatusCode());
        Assert.assertNotNull(response.jsonPath().getString("id"));
    }

    @Given("a user is updated")
    public void updateUser() {
        response = userPage.updateUser(1, "John Smith", "Senior Software Engineer");
    }

    @Then("user should be updated successfully")
    public void verifyUserUpdate() {
        Assert.assertEquals(200, response.getStatusCode());
        Assert.assertNotNull(response.jsonPath().getString("updatedAt"));
    }

    @Given("a user is deleted")
    public void deleteUser() {
        response = userPage.deleteUser(1);
    }

    @Then("user should be deleted successfully")
    public void verifyUserDeletion() {
        Assert.assertEquals(204, response.getStatusCode());
    }
}