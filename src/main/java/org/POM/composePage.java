package org.POM;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.utilities.BaseUtility;



public class composePage {
	WebDriver driver;
	BaseUtility bu;
	@FindBy(css="input[autocomplete='username']")
	private WebElement userNameField;

	@FindBy(xpath="//span[@jsname='V67aGc'][text()='Next']")
	private WebElement nextBtn;

	@FindBy(css="input[class='whsOnd zHQkBf']")
	private WebElement pwdField;

	@FindBy(xpath="//div[@class='T-I T-I-KE L3'][text()='Compose']")
	private WebElement composeBtn;

	@FindBy(css="div[class='nH Hd']")
	private WebElement composeWindow;

	@FindBy(css="input[class='agP aFw']")
	private WebElement recipientField;

	@FindBy(css="input[id=':co']")
	private WebElement ccField;

	@FindBy(css="input[class='aoT']")
	private WebElement subjectField;

	@FindBy(css="div[class='Am Al editable LW-avf tS-tW']")
	private WebElement mailBody;

	@FindBy(css="div[class='T-I J-J5-Ji aoO v7 T-I-atl L3']")
	private WebElement sendBtn;

	@FindBy(xpath="//span[@class='bAq']")
	private WebElement mailSent;

	@FindBy(css="div[class='TN bzz aHS-bnu']")
	private WebElement sentBox;

	@FindBy(xpath="//td[@class='xY a4W']/div/div/div/span/span[text()='Incubyte']")
	private WebElement sentMail;

	@FindBy(xpath="//h2[text()='Incubyte']")
	private WebElement mailSubject;
	
	@FindBy(xpath="//div[text()='Automation QA test for Incubyte']")
	private WebElement mailBodyText;

	public composePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void gmailLogin(String uName, String pwd) throws InterruptedException{
		userNameField.sendKeys(uName);
		bu = new BaseUtility();
		bu.clickByJS(driver, nextBtn);
		Thread.sleep(7000);
		pwdField.sendKeys(pwd);
		bu.clickByJS(driver, nextBtn);

	}

	public void clickOnCompose(){
		bu = new BaseUtility();
		bu.waitForVisibiltyOfElementLocated(driver, 30, "xpath", "//div[@class='T-I T-I-KE L3'][text()='Compose']");
		Actions act = new Actions(driver);
		act.moveToElement(composeBtn).click().build().perform();

	}

	public void composeWinAppear() {
		bu = new BaseUtility();
		Assert.assertTrue(bu.waitForVisibiltyOf(driver, 10, composeWindow));
	}

	public void enterMailId(String mailId) {
		recipientField.sendKeys(mailId);
		recipientField.sendKeys(Keys.TAB);
	}

	public void enterSubject(String subject) {
		subjectField.click();
		subjectField.sendKeys(subject);
	}

	public void enterMailBody(String body) {
		mailBody.click();
		mailBody.sendKeys(body);
	}

	public void clickOnSend() {
		sendBtn.click();
	}

	public void sentSuccessMsg() {
		bu = new BaseUtility();
		Assert.assertTrue(bu.waitForVisibiltyOf(driver, 10, mailSent));
	}

	public void clickOnSent() {
		sentBox.click();
	}

	public void clickOnSentMail(String expText) {
		bu = new BaseUtility();
		bu.waitForUrlContains(driver, 30, "https://mail.google.com/mail/u/0/#sent");
		String actText= sentMail.getText();
		if(actText.equals(expText)) {
			sentMail.click();
		}
	}
	public void mailSubject(String expSubject) {
		String actSubject= mailSubject.getText();
		Assert.assertEquals(actSubject, expSubject, "Mail is not showing with Subject: Incubyte");
	}
	
	public void mailBodyText(String expBody) {
		String actBody= mailBodyText.getText();
		Assert.assertEquals(actBody, expBody, "Mail body text is not as per requirement");
	}
}