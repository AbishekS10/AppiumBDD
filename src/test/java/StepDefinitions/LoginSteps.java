package StepDefinitions;

import Base.BaseTest;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends BaseTest {

    private AppiumDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;

    public LoginSteps() {
         System.out.println("Initializing LoginSteps..");
         setup();
         homePage = new HomePage(driver);

    }

    @Given("user to launch calculator app")
    public void user_to_launch_calculator_app() {


         homePage.verifyUserin_HomePage();



    }

    @When("user perform addition with value {string} and {string}")
    public void user_perform_addition(String a, String b){
       homePage.clickvalue_sum(a,b);

    }

    @And("user to check equals")
    public void user_check_equalsbutton()
    {
       homePage.clickequals();
    }

    @Then("user should get Addition output as {string}")
    public void user_additionOutput_Check(String c){
      homePage.Checkoutput(c);
       tearDown();
    }


}
