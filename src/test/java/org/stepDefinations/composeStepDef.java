package org.stepDefinations;

import java.util.Properties;

import org.POM.composePage;
import org.applicationHooks.AppHooks;
import org.openqa.selenium.WebDriver;
import org.utilities.BaseUtility;
import org.utilities.configReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class composeStepDef {
	public configReader cr;
	public Properties prop;
	public BaseUtility bu;
	public WebDriver driver;
	@Given("User is on the Gmail login page")
	public void user_is_on_the_gmail_login_page() {
		cr= AppHooks.cr;
		prop =AppHooks.prop;
		bu = AppHooks.bu;
		driver = AppHooks.driver;
	}

	@When("User log in with valid credentials")
	public void user_log_in_with_valid_credentials() throws InterruptedException{
		composePage cp = new composePage(driver);
		cp.gmailLogin(prop.getProperty("userName"), prop.getProperty("password"));
	}

	@When("User click on the Compose button")
	public void user_click_on_the_Compose_button(){
		composePage cp = new composePage(driver);
		cp.clickOnCompose();
	}

	@When("User wait for the compose window to appear")
	public void user_wait_for_the_compose_window_to_appear() {
		composePage cp = new composePage(driver);
		cp.composeWinAppear();
	}

	@When("User enter the recipient email address {string}")
	public void user_enter_the_recipient_email_address(String mailId){
		composePage cp = new composePage(driver);
		cp.enterMailId(mailId);
	}

	@When("User enter the subject as {string}")
	public void user_enter_the_subject_as(String subject) {
		composePage cp = new composePage(driver);
		cp.enterSubject(subject);
	}

	@When("User enter the body as {string}")
	public void user_enter_the_body_as(String body) {
		composePage cp = new composePage(driver);
		cp.enterMailBody(body);
	}
	
	@When("User click on the Send button")
	public void user_click_on_the_send_button() {
		composePage cp = new composePage(driver);
		cp.clickOnSend();
	}

	@Then("the email should be sent successfully")
	public void the_email_should_be_sent_successfully() {
		composePage cp = new composePage(driver);
		cp.sentSuccessMsg();
	}

	@When("User navigate to the Sent folder")
	public void user_navigate_to_the_Sent_folder() {
		composePage cp = new composePage(driver);
		cp.clickOnSent();
	}

	@When("User click on {string} subject email")
	public void user_click_on_subject_email(String expText) {
		composePage cp = new composePage(driver);
		cp.clickOnSentMail(expText);
	}

	@Then("User should see a sent email with subject {string}")
	public void user_should_see_a_sent_email_with_subject(String expSubject) {
		composePage cp = new composePage(driver);
		cp.mailSubject(expSubject);
	}

	@Then("User should see the body {string}")
	public void user_should_see_the_body(String expBody) {
		composePage cp = new composePage(driver);
		cp.mailBodyText(expBody);
	}
}
