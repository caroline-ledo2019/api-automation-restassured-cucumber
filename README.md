# Projeto de Automação de Testes de API - ServeRest

Este projeto foi desenvolvido do zero para demonstrar habilidades avançadas em engenharia de qualidade, arquitetura de software e automação de testes de API utilizando o ecossistema Java.

## Tecnologias Utilizadas
- **Java 21** (JDK 21)
- **Apache Maven** (Gerenciador de dependências e automação de build)
- **RestAssured 5.5.0** (Framework para requisições HTTP e asserções de API)
- **Cucumber 7.18.0 (BDD)** (Abordagem orientada ao comportamento com escrita em Gherkin/Português)
- **JUnit 4** (Motor de execução dos testes estruturado através do Runner)

## Estrutura e Diferenciais do Relatório (Cucumber Reports)
O projeto está configurado para gerar relatórios visuais e interativos em formato HTML ("target/reports/cucumber-report.html"). Os grandes diferenciais técnicos deste projeto incluem:
- **Separação de Logs por Etapa:** A requisição enviada (*Request* com Headers, URI e Métodos) e os dados recebidos da API (*Response Body*) são capturados em tempo de execução e injetados de forma limpa abaixo do passo correspondente ("Quando").
- **Validações de Negócio Automatizadas:** Utilização do *JsonPath* para capturar chaves do JSON e realizar a contagem física automatizada de registros em listas de dados, comparando os resultados com as regras esperadas da API.

## Como Rodar o Projeto
Certifique-se de ter o Java 21 e o Apache Maven configurados na sua máquina. Na raiz do projeto, execute o comando no terminal: mvn clean test

## Como Visualizar o Relatório Visual (HTML)
Após a execução dos testes com sucesso ("BUILD SUCCESS"), um relatório interativo é gerado automaticamente no seu computador. Para visualizá-lo no seu navegador (Google Chrome, Edge, etc.), siga o passo a passo:

1. No menu lateral esquerdo do **VS Code**, navegue até a pasta: "target" ➡️ "reports".
2. Clique com o **botão direito do mouse** em cima do arquivo "cucumber-report.html".
3. No menu que se abrir, selecione a opção **Reveal in File Explorer** (Mostrar no Explorador de Arquivos do Windows).
4. A pasta amarela do seu Windows será aberta destacando o arquivo. Dê **dois cliques** sobre o arquivo "cucumber-report.html".
5. O relatório abrirá em tela cheia no seu navegador padrão, exibindo o gráfico interativo verde com 100% dos testes aprovados e todos os logs técnicos detalhados de cada etapa.
