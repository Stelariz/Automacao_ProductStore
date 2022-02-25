package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPageProject {

	private WebDriver driver;
	
	private WebDriverWait wait;

	@FindBy(xpath = "//tr[@class = 'success']")
	private List<WebElement> produtosCarrinho;
	
	@FindBy (xpath = "//tr[@class = 'success']//a")
	private List<WebElement> link;

	public CartPageProject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait (driver, 30);
	}

	public boolean deletarProdutos(String produto) {
		
		boolean foundElement = false;

		for (int i = 0; i < produtosCarrinho.size(); i++) {
			if (produtosCarrinho.get(i).getText().contains(produto)) {
				WebElement deletarLink = link.get(i);
				deletarLink.click();
				wait.until(ExpectedConditions.invisibilityOf(deletarLink));
				foundElement = true;
				break;
			}
		}
		return foundElement;
	}
	
	public boolean confirmarDelecao(String produto) {
		
		for (int i = 0; i < produtosCarrinho.size(); i++) {
			if (produtosCarrinho.get(i).getText().contains(produto)) {
				return false;
			}
		}
		return true;
	}

}
