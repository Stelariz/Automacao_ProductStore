package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactPageProject {
	
	private WebDriver driver;
	
	private WebDriverWait wait;
	
	@FindBy (linkText = "Contact")
	private WebElement clickContact;
	
	@FindBy (xpath = "//h5[text() = 'New message']")
	private WebElement newMessage;
	
	@FindBy (id = "recipient-email")
	private WebElement emailRecipient;
	
	@FindBy (id = "recipient-name")
	private WebElement nameRecipient;
	
	@FindBy (id = "message-text")
	private WebElement messageText;
		
	@FindBy (xpath = "//button[text() = 'Send message']")
	private WebElement sendButton;
	
	
	public ContactPageProject (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait (driver, 30);
	}
	
	public void contact () {
		clickContact.click();
	}
	
	public String confirmacaoJanela () {
		return wait.until(ExpectedConditions.visibilityOf(newMessage)).getText();
	}
	
	public void preenchimentoDados (String e_mail, String nome, String mensagem) {
		emailRecipient.sendKeys(e_mail);
		nameRecipient.sendKeys(nome);
		messageText.sendKeys(mensagem);
	}
	
	public void enviarMensagem () {
		sendButton.click();
	}
	
	public String alerta () {
		Alert alerta = wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert();
		return alerta.getText();
	}

}
