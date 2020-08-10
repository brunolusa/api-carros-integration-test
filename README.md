# API Carros - Test

Este projeto têm como objetivo testar de maneira automatizada os end-points expostos pela API Carros.

# Validações
 * HealthCheck - Valida a saúde da aplicação alvo dos testes;
 * ContractTest - Valida se os contratos ainda são válidos antes da execução dos testes funcionais;
 * FunctionalTest - Valida se todos os end-points expostos respondem ao comportamento esperado;
 * AcceptanceTest - Realiza o teste de aceitação da API alvo, percorrendo uma jornada de CRUD.

# Execução
Neste projeto não foi elaborado nenhuma suíte de execução, particularmente, quando tenho um projeto pequeno, gosto de executar as utilizando o parâmetro _test_ do Maven, entendo que facilita a não existência de um arquivo XML, e possibilita o mesmo resultado, segue abaixo:
Para as execuções dos níveis de testes:
* HealthCheck

mvn clean test -Dtest=HealthCheckTest

* ContractTest

mvn clean test -Dtest=\*ContractTest

* FunctionalTest

mvn clean test -Dtest=\*ValidationTest

* AcceptanceTest

mvn clean test -Dtest=ValidacaoAcceptanceTest


# Linguagens e Frameworks
* Testng
* Json Schema Validator
* Java 11
* Maven
* Api Carros It Client

# Pré-requisitos
Você deve possuir a biblioteca _api-carros-it-client_ em seu repositório local.
Para isso, clone o projeto api-carros-it-client, e execute o seguinte comando:
 - mvn clean install
 Link da biblioteca: [API Carros It Client](https://github.com/brunolusa/api-carros-it-client)
 
 
