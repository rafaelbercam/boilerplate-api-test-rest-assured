# __Boilerplate REST-assured__

## __Ambiente__
Para executar os testes localmente, estou utilizando o ServeRest

<p align="center">
 <img alt="Logo do ServeRest" src="https://user-images.githubusercontent.com/29241659/115161869-6a017e80-a076-11eb-9bbe-c391eff410db.png" height="120">
</p>

Link do Repo: https://github.com/ServeRest/ServeRest

ServeRest está disponível de forma [online](https://serverest.dev), no [npm](https://www.npmjs.com/package/serverest) e no [docker](https://hub.docker.com/r/paulogoncalvesbh/serverest/).
```
npm install
```
Para iniciar o serviço basta acessar a pasta ServeRest-trunk rodar o comando
```
npx serverest@latest

```

## Pré Requisitos REST-assured

- [Instalar JDK 8+](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Instalar Maven](https://maven.apache.org/install.html)
- [Instalar IntelliJ ou outra IDE](https://www.jetbrains.com/idea/download/)
- [Starting with RestAssured](https://github.com/rest-assured/rest-assured/wiki/GettingStarted)

## Configuração

> variáveis de ambiente e bash_profile - exemplo:

###### java: `export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home`

###### maven: `export PATH=/opt/apache-maven-3.5.4/bin:$PATH`

##### Instalando Java
- Mac, Windows e Linux: https://www.liquidweb.com/kb/how-to-install-java-on-ubuntu-windows-and-macos

##### Instalando Maven
- Mac, Windows e Linux: https://www.baeldung.com/install-maven-on-windows-linux-mac


Crie um _maven_ project ou use um _pom.xml_ existente para fazer o download/instalação das dependências.

## Instalação

Clone project

- Clone este repositório para sua maquina usando http or ssh, por exemplo:

`git clone https://exemplo.com`

- Instale todas as dependências (pom.xml)  usando mvn install e execute os testes:

`cd /<pasta_do_prjeto>`

`mvn install`

## Como configurar os testes

Antes de rodar os testes voce vai precisar:

- Criar um arquivo `config.properties` dentro da pasta *resources* e inserir as variáveis de ambiente.
- Arquivo de Exemplo: `config.properties.example`

The valid values are below:

##### Exemplo:
```
APP_URL=http://localhost:3000
USER=fulano@qa.com
PASSWORD=teste
```
###### NOTA:
Neste boilerplate o arquivo config.properties esta exposto, mas seguindo o guia de boas práticas
você deve adicionar o arquivo `config.properties` no `.gitignore`


## __Instalando Dependências do Projeto__
Rodar o comando
```
mvn install
```
## __Rodar os testes__
Basta rodar o comando
```
mvn test -Dtest=<nome-da-classe>
```

## __Configuração do Projeto__

O projeto esta dividido da seguinte maneira:


    [test]
      [java]
        [br.com.restassrured]
           [commons] -> Classes de configurações e do Request Specification do REST-assured
           [data] -> Classes que retornam objetos para serem parseados nas requisições.
           [requests] -> Classes que retornam métodos que disparam as requisições do REST-assured
           [runner] - Classes que rodam suites de testes específicas usando o `@RunWith` do JUnit4
           [schema] -> Arquivos de Schema no formato JSON para com as validações de contrato com API
           [tests] -> Arquivos de Teste no forma JUnit
        [resources] -> Arquivo de configuração das variáveis de ambiente.

### __data__
São classes que retornam objetos de acordo com os paramentros enviados em uma requisição.

Exemplo:

```java
public class User {

    private String nome;
    private String email;
    private String password;
    private String administrador;

}
```

### __requests__

Em `requests`, retornam a `Response` da requisição do REST-assured.
Dessa foma o tipo retornado do método é do tipo ``Response``

Basta fazer o import do Response.

```java
import io.restassured.response.Response;
```

Exemplo da Classe:

```java
public class LoginRequests extends RequestSpecificationSetup {
    public Response postLogin(){
       DataLogin login = new DataLogin();
       return given()
                    .spec(requestSpecification)
                    .body(login.getLogin(login)).
               when()
                    .post("/login").
               then().extract().response();
    }
}
```

### __schema__

Ficam localizados os arquivos de schema para validação dos testes.


### __test__
Em ``test``, poderão ser colocados os arquivos de teste no formato do JUnit.


Exemplo da classe:

```java
public class Login extends RequestSpecificationSetup {

    private final LoginRequests request = new LoginRequests();
    private static Response response;

    @Test
    public void postLogin(){

        response = request.postLogin();
        assertEquals(HttpStatus.SC_OK,response.statusCode());
        assertEquals(
                "Login realizado com sucesso",
                response.getBody().jsonPath().get("message"));
        
    }
}
```

Note como a resposta da requisição retorna um objeto do tipo `Response`, foi necessário declarar
uma variável do tipo para recebe-la.