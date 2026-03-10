# 🛒 Automação de Testes - Product Store (Selenium & Cucumber)

Este projeto consiste na automação de testes de ponta a ponta (E2E) para o e-commerce **Product Store**, validando fluxos críticos de negócio, desde o gerenciamento de conta até a finalização da jornada de compra.

## 🛠️ Stack Técnica e Padrões

* **Linguagem:** Java 11+
* **Framework de Teste:** JUnit
* **Automação Web:** Selenium WebDriver
* **BDD (Behavior Driven Development):** Cucumber (Gherkin)
* **Gerenciador de Dependências:** Maven
* **Design Pattern:** Page Object Model (POM)

---

## 🧪 Detalhamento dos Testes (Cenários)

Abaixo, os fluxos cobertos nesta automação, detalhados por funcionalidade:

### 👤 1. Gestão de Identidade (Sign Up & Login)
* **Cadastro de Usuário:** Valida a criação de novas contas e o tratamento de usuários já existentes (Alerts).
* **Login com Sucesso:** Verifica o acesso e a exibição da saudação personalizada no menu.
* **Login Inválido:** Testa o comportamento do sistema com credenciais incorretas ou campos vazios.

### 🔍 2. Navegação e Catálogo
* **Filtro por Categorias:** Garante a exibição correta de produtos ao filtrar por *Laptops*, *Phones* ou *Monitors*.
* **Detalhes do Produto:** Valida se as informações (Preço/Descrição) carregam corretamente ao selecionar um item.

### 💳 3. Carrinho e Checkout (Fluxo Principal)
* **Adição ao Carrinho:** Valida o fluxo de adicionar um item e a confirmação do navegador.
* **Gerenciamento do Carrinho:** Testa a exclusão de itens e o cálculo do total da compra.
* **Finalização de Pedido:** Preenchimento completo do checkout e validação do recibo final com o modal "Thank you for your purchase!".

---

## 📊 Relatórios e Evidências

O projeto está configurado para gerar evidências detalhadas de execução para facilitar a análise de falhas:

### **Cucumber HTML Reports**
Após a execução dos testes, um relatório visual é gerado automaticamente pelo Maven.
* **Caminho do arquivo:** `target/cucumber-reports/index.html`
* **Conteúdo:** Status de cada Step (Pass/Fail), tempo de execução e screenshots de erros (se configurado no `Hooks`).

### **Evidências de Log**
* Logs do console detalhando o início e fim de cada cenário.
* Captura de mensagens de `Alert` nativas do navegador durante os fluxos de erro.

---

## 🚀 Como Executar o Projeto

Siga os passos abaixo para rodar os testes localmente:

### **1. Pré-requisitos**
* **Java JDK 11** ou superior instalado.
* **Maven** configurado nas variáveis de ambiente.
* **Google Chrome** instalado.

### **2. Clonar e Instalar**
```bash
# Clone o repositório
git clone [https://github.com/Stelariz/Automacao_ProductStore.git](https://github.com/Stelariz/Automacao_ProductStore.git)

# Acesse a pasta
cd Automacao_ProductStore

# Instale as dependências do Maven
mvn clean install
