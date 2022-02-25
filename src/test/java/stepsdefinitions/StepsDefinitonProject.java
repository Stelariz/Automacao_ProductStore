package stepsdefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import pages.CartPageProject;
import pages.ContactPageProject;
import pages.HomePageProject;
import pages.InventaryPageProject;
import pages.OrdingPageProject;

public class StepsDefinitonProject {
	
	WebDriver driver = Hooks.driver;
	
	@Dado ("que o cliente esteja no site")
	public void que_o_cliente_esteja_no_site () {
		HomePageProject homePage = new HomePageProject (driver);
		driver.get("https://demoblaze.com/index.html");
		assertEquals("https://demoblaze.com/index.html", homePage.enderecopagina());
		
	}
	
    @E ("acessa o formulario do contato")
    public void acessa_o_formulario_do_contato () {
    	ContactPageProject contactPage = new ContactPageProject (driver);
    	contactPage.contact();
    	assertEquals("New message", contactPage.confirmacaoJanela());
    }
    
    @E ("preenche o formulario com {string}, {string} e {string}")
    public void preenche_o_formulario_com (String email, String nome, String mensagem) {
    	ContactPageProject contactPage = new ContactPageProject (driver);
    	contactPage.preenchimentoDados(email, nome, mensagem);
    }
    
    @Quando ("clicar no botao de enviar a mensagem")
    public void clicar_no_botao_de_enviar_a_mensagem () {
    	ContactPageProject contactPage = new ContactPageProject (driver);
    	contactPage.enviarMensagem();;
    }
    
    @Entao ("a mensagem sera enviada")
    public void a_mensagem_sera_enviada () {
    	ContactPageProject contactPage = new ContactPageProject (driver);
    	assertEquals("Thanks for the message!!", contactPage.alerta());
    }
    
    @E ("possua um produto {string} no carrinho")
    public void possua_um_produto_produto_no_carrinho (String produto) {
    	InventaryPageProject inventaryPage = new InventaryPageProject (driver);
    	inventaryPage.computadores();
    	inventaryPage.clicarNext();
    	inventaryPage.acessarProdutos(produto);
    	inventaryPage.adicionarProdutoNoCarrinho();
    	assertEquals("Product added", inventaryPage.alertaConfirmacao());
    	inventaryPage.clicarCarrinho();
    }
    
    @Quando ("clica no botao de remover o produto {string} do carrinho")
    public void clica_no_botao_de_remover_o_produto_do_carrinho (String produto) {
    	CartPageProject cartPage = new CartPageProject (driver);
    	cartPage.deletarProdutos(produto);
    	
    }
    
    @Entao ("o produto {string} e removido")
    public void o_item_e_removido (String produto) {
    	CartPageProject cartPage = new CartPageProject (driver);
    	assertTrue(cartPage.confirmarDelecao(produto));
    }
    
    @E ("clicar em fazer pedido")
    public void clicar_em_fazer_pedido () {
    	OrdingPageProject ordingPage = new OrdingPageProject (driver);
    	ordingPage.fazerPedido();
    }
    
    @Quando ("preencher o formulario com {string}, {string}, {string}, {string}, {string} e {string}")
    public void preencher_o_formulario_com (String nome, String pais, String cidade, String cartao_de_credito, String mes, String ano) {
    	OrdingPageProject ordingPage = new OrdingPageProject (driver);
    	ordingPage.preencherFormulario(nome, pais, cidade, cartao_de_credito, mes, ano);
    }
    
    @E ("clicar em comprar")
    public void clicar_em_comprar () {
    	OrdingPageProject ordingPage = new OrdingPageProject (driver);
    	ordingPage.clicarComprar();
    }
    
    @Entao ("a compra sera efetivada")
    public void a_compra_sera_efetivada () {
    	OrdingPageProject ordingPage = new OrdingPageProject (driver);
    	assertEquals("Thank you for your purchase!", ordingPage.mensagemSucesso());
    	
    }

}
