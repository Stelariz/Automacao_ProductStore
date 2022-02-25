package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InventaryPageProject {

	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(xpath = "//a[text () = 'Laptops']")
	private WebElement laptops;
	
	@FindBy (xpath = "//img[@src = 'imgs/sony_vaio_5.jpg']")
	private WebElement waitCondition1;
	
	@FindBy (xpath = "//img[@src = 'imgs/apple_cinema.jpg']")
	private WebElement waitCondition2;

	@FindBy(xpath = "//button[text() = 'Next']")
	private WebElement buttonNext;

	@FindBy(xpath = "//*[@class = 'card-title']//a")
	private List<WebElement> produtos;

	@FindBy(xpath = "//a[text() = 'Add to cart']")
	private WebElement addButton;
	
	@FindBy (id = "cartur")
	private WebElement cartButton;
	

	public InventaryPageProject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait (driver, 30);
	}

	public void computadores() {
		laptops.click();
		wait.until(ExpectedConditions.visibilityOf(waitCondition1));
	}

	public void clicarNext() {
		buttonNext.click();
		wait.until(ExpectedConditions.visibilityOf(waitCondition2));
	}

	public boolean acessarProdutos(String produto) {
		
		for (int i = 0; i < produtos.size(); i++) {
			if (produtos.get(i).getText().contains(produto)) {
				produtos.get(i).click();
				return true;
			}
		}
		return false;
	}

	public void adicionarProdutoNoCarrinho() {
		wait.until(ExpectedConditions.visibilityOf(addButton));
		addButton.click();

	}

	public String alertaConfirmacao() {
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alerta = driver.switchTo().alert();
		String conteudoAlerta = alerta.getText();
		alerta.accept();
		return conteudoAlerta;
	}
	
	public void clicarCarrinho () {
		wait.until(ExpectedConditions.visibilityOf(cartButton));
		cartButton.click();
	}

}
