package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.testng.Assert;

import com.rediff.qa.base.TestBase;
import com.rediff.qa.pages.HomePage;
import com.rediff.qa.pages.LoginPage;

@RunWith(Cucumber.class)
public class LoginPageTest extends TestBase {

	HomePage HP;
	LoginPage LP;
	
    @Given("^the browser is launched$")
    public void the_browser_is_launched() throws Throwable {
    	Initialize();
    }

    @When("^user opens the rediff url$")
    public void user_opens_the_rediff_url() throws Throwable {
    	HP = new HomePage();
    	LP = HP.validateLoginPage();
    }

    @Then("^user should be able to get the correct title of login page$")
    public void user_should_be_able_to_get_the_correct_title_of_login_page() throws Throwable {
    	Assert.assertEquals(LP.validateLoginPageTitle(),"Rediffmail","Login Page title is not matched");
    	driver.close();
    }
    
    @And("^user enters username (.+) and password (.+)$")
    public void user_enters_username_and_password(String username, String password) throws Throwable {
    	LP.validatelogin(username, password);
    }
    
    @Then("^user should be logged into rediffmail$")
    public void user_should_be_logged_into_rediffmail() throws Throwable {
    	Assert.assertTrue(LP.validateLoggedInUser());
		HP=LP.validateNavigateRediffToHome();
		driver.close();
    }

    

}