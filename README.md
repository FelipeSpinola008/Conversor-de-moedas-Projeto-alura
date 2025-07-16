# Conversor de Moedas (Java)
Um simples e eficiente conversor de moedas desenvolvido em Java, utilizando uma API externa para obter taxas de câmbio em tempo real. Este projeto foi criado como parte do curso de Java da Alura com pareceria da Oracle, com foco em boas práticas de programação, separação de responsabilidades e tratamento de exceções.

## Funcionalidades
* Conversão de Moedas: Permite converter valores entre Dólar (USD), Real Brasileiro (BRL), Euro (EUR) e Libra Esterlina (GBP).

* Taxas de Câmbio em Tempo Real: Utiliza a [ExchangeRate-API](https://www.exchangerate-api.com/) para obter as taxas de conversão mais atualizadas.

* Interface de Linha de Comando (CLI): Interação simples e intuitiva via console.

* Tratamento de Erros Robusto: Lida com entradas inválidas do usuário e problemas de comunicação com a API, garantindo que o programa não pare inesperadamente.

## Tecnologias Utilizadas:
* Java 21+

* Gson: Biblioteca Java para serialização/desserialização de objetos Java para/de JSON.

* Java 11 HTTP Client: API nativa do Java para fazer requisições HTTP.

## Estrutura do Projeto
O projeto segue o princípio de Separação de Responsabilidades, com cada classe focada em uma tarefa específica:

````Main.java````: O ponto de entrada da aplicação. Sua única responsabilidade é inicializar as classes necessárias e iniciar o fluxo principal do programa.

```ApiExchangeClient.java```: Responsável por toda a comunicação com a API externa (ExchangeRate-API). Ele constrói a URL, faz a requisição HTTP e desserializa a resposta JSON para um objeto ```ExchangeRate```.

```ExchangeRate.java```: Um ```record Java``` (introduzido no Java 16) utilizado como um contêiner de dados imutável para armazenar as informações da taxa de câmbio recebidas da API (```base_code```, ```target_code```, ```conversion_rate```).

```UserInteraction.java```: Gerencia toda a interação com o usuário. Isso inclui exibir o menu, ler as opções e valores digitados, processar as escolhas e exibir os resultados formatados. Também é responsável por tratar as exceções de entrada do usuário e os erros da API, garantindo que o programa continue executando.

## Como Usar
### Pré-requisitos
* Java Development Kit (JDK) 21 ou superior instalado.

* Uma chave de API da [ExchangeRate-API](https://www.exchangerate-api.com/) . Você precisará substituir ```YOUR_API_KEY``` no arquivo ```ApiExchangeClient.java``` pela sua chave.

## Configuração e Execução

### 1. Faça download do projeto no meu [GitHub](https://github.com/FelipeSpinola008/Conversor-de-moedas-Projeto-alura.git)

### 2. Adicione a biblioteca Gson:

Se você estiver usando um ambiente de desenvolvimento como IntelliJ IDEA ou Eclipse, adicione Gson como uma dependência do projeto.

### 3. Substitua a Chave da API:

Abra o arquivo ```src/main/java/ApiExchangeClient.java```.

Localize a linha que define a URI da API e substitua ```YOUR_API_KEY``` pela sua chave real da ExchangeRate-API.

``` Java
URI code = URI.create("https://v6.exchangerate-api.com/v6/YOUR_API_KEY/pair/" + baseCode + "/" + targetCode);
````
### 4. Compile e Execute:

* **Via IDE (IntelliJ IDEA, Eclipse, VS Code):** Abra o projeto na sua IDE e execute a classe ```Main.java```.
(Ajuste o caminho/para/gson-2.10.1.jar para o local onde você baixou o JAR do Gson.)

## Como o Tratamento de Erros Funciona
O programa foi projetado para ser robusto e não parar inesperadamente. As exceções são tratadas nos seguintes pontos:

* __Entrada de Opção do Menu:__ Se o usuário digitar algo que não seja um número para a opção do menu, o programa exibe uma mensagem de erro e retorna ao menu principal.

* __Entrada de Valor para Conversão:__ Se o usuário digitar algo que não seja um número para o valor a ser convertido, o programa exibe uma mensagem de erro e retorna ao menu principal.

* __Erros da API/Rede:__ Se houver um problema ao consultar a ExchangeRate-API (ex: sem conexão com a internet, chave de API inválida, ou erro na resposta da API), o programa exibe uma mensagem de erro e retorna ao menu principal.

## Autor
Felipe Spinola - [Github](https://github.com/FelipeSpinola008) - [LinkedIn](https://www.linkedin.com/in/felipespinola008/)
