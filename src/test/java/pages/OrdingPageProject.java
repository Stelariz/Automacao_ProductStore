package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrdingPageProject {
	
	private WebDriver driver;
	
	private WebDriverWait wait;
	
	@FindBy (xpath = "//button[text() = 'Place Order']")
	private WebElement placeOrder;
	
	@FindBy (id = "orderModalLabel")
	private WebElement waitPlaceOrder;
	
	@FindBy (id = "name")
	private WebElement name;
	
	@FindBy (id = "country")
	private WebElement country;
	
	@FindBy (id = "city")
	private WebElement city;
	
	@FindBy (id = "card")
	private WebElement creditCard;
	
	@FindBy (id = "month")
	private WebElement month;
	
	@FindBy (id = "year")
	private WebElement year;
	
	@FindBy (xpath = "//button[text() = 'Purchase']")
	private WebElement purchase;
	
	@FindBy (xpath = "//h2[text() = 'Thank you for your purchase!']")
	private WebElement thankYouMessage;
	
	
	public OrdingPageProject (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait (driver, 30);
	}
	
	public void fazerPedido () {
		placeOrder.click();
	}
	
	public void preencherFormulario (String nome, String pais, String cidade, String cartaoCredito, String mes, String ano) {
		wait.until(ExpectedConditions.visibilityOf(waitPlaceOrder));
		name.sendKeys(nome);
		country.sendKeys(pais);
		city.sendKeys(cidade);
		creditCard.sendKeys((cartaoCredito));
		month.sendKeys(mes);
		year.sendKeys(ano);
	}
	
	public void clicarComprar () {
		purchase.click();
	}
	
	public String mensagemSucesso () {
		wait.until(ExpectedConditions.visibilityOf(thankYouMessage));
		return thankYouMessage.getText();
	}

}
