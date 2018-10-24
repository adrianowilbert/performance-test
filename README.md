# load-test #
Projeto de teste de carga na linguagem Scala para estudos.
Logo o `README` irá contér mais informações que o necessário, trazendo dicas e explicações.

| **WILBERT** | [Adriano Wilbert](https://github.com/adrianowilbert) _(adrianowilbert@gmail.com.br)_

### Projeto

Este projeto utiliza as seguintes tecnologias:

  IDE - [IntelliJ](https://www.jetbrains.com/idea/).

  Framework - [gatling](http://gatling.io/). 
  
  Linguagem - [Scala](https://www.scala-lang.org/).
  
  Contêineres - [Docker](https://www.docker.com/).

### API

Projeto utliza a API de código aberto: http://fakerestapi.azurewebsites.net/swagger/ui/index

O objetivo é testar se as requisições estão funcionando corretamente, e não a API em si.
Logo os testes não podem extrapolar um valor muito alto de requisições, a fim de não onerar a API.

### Comandos de execução

clean test -Dgatling.simulationClass=br.com.cliente.api.loadTest.simulation.NomeRota -f pom.xml

### VAL & VAR

"`val` significa imutável e `var` significa mutável."

Parafraseando, "val significa valor e var significa variável".

- Um val é semelhante a uma variável final em Java. Uma vez inicializado, um val nunca pode ser reatribuído.

- Um var , por outro lado, é semelhante a uma variável não final em Java. Um var pode ser reatribuído ao longo de sua vida útil.

### POST

Exemplo de request de criação guardando elemento do response para usar em outras requisições:

```shell
  val <criaElemento> = --nome método
    exec(http(<"nomeDaRequisicao">) --nome da requisição
      .post(<"enderecoDaApi">) --url
      .headers(<"cabecalhoDaRequisição">) --elementos tais como o token e o content-type
      .body(ElFileBody(<"nomeDoResponseDoJson">.json)) --nome indicativo daquilo que está sendo inserido no request
      .check(status.is(<status>)) --apresenta o status esperado 201, 400, 404 ou 500
      .check(jsonPath($.<"valorDoResponse">).saveAs(<"valorDoResponse">))) 
      --basicamente o nome caminho (primeiro) e o nome elemento (segundo) são iguais
      --o item fica setado para ser usado em um teste posterior
```

Exemplo de request com a utilização de Map na montagem do body e utilizando CSV

```shell
  val <criaElemento> = --nome método
    feed(csv(<"nomeDoCsv">.csv)) --busca elementos no arquivo CSV
    .exec(http(<"nomeDaRequisicao">) --nome da requisição
      .post(<"enderecoDaApi">) --url
      .headers(<"cabecalhoDaRequisição">) --elementos tais como o token e o content-type
      .body(ElFileBody(<"nomeDoResponseDoJson">.json)) --nome indicativo daquilo que está sendo inserido no request
        Map(<"elemento1"> -> ${<"elemento1">}, <"elemento2"> -> ${<"elemento2"}))).asJSON --esta linha monta o objeto json
      .check(status.is(<status>)) --apresenta o status esperado 201, 400, 404 ou 500
    )
```

### GET

Exemplo de request de busca guardando elementos do response para usar em outras requisções:

```shell
  var <buscaElemento> = --nome método
    exec(http(<"nomeDaRequisição">) --nome da requisição
      .get(<enderecoDaApi?elemento1=${<"elemento1>"}&elemento2=${<"elemento2>"}>) --url montada com valores setados em um teste anterior
      .headers(<"cabecalhoDaRequisição">) --elementos tais como o token e o content-type
      .check(status.is(<status>)) --apresenta o status esperado tais como 200, 400, 404 ou 500
      .check(jsonPath($..<"valorDoResponse1">).saveAs(<"valorDoResponse1">))
      .check(jsonPath($..<"valorDoResponse2">).saveAs(<"valorDoResponse2">))
      .check(jsonPath($..<"valorDoResponse3">).saveAs(<"valorDoResponse3">))
      .check(jsonPath($..<"valorDoResponse4">).saveAs(<"valorDoResponse4">))) 
      --basicamente o nome dos caminhos (primeiros) e o nome dos elementos (segundos) são iguais
      --os itens ficam setados para serem usados em um teste posterior`
```

      
Exemplo de auxiliares de execução

```shell
var <buscaElemento> =
repeat(times = 5) {--elemento de repetição
    exec(...........)
      .get(.........)
      .header(......)
      .check(.......)
      .pause(duration = 3) --elemento de duração da pausa
}
```

#### Comandos Docker

- Comandos para usar no terminal:
    - `docker-compose up` executa o arquivo de composição para rodar os testes
    - `Ctrl+c` pausa os teste
    - `docker-compose dow` limpa o recipiente e finaliza os testes
    
    #### docker-compose
    
    Para executar os testes em uma estrutura de containes para acompanhar os testes em tempo real no Grafana.
    ```shell
    cd src\load-test\docker
    docker-compose up -d
    ```
    
    Para interromper os testes
    ```shell
    Ctrl+C
    ```
    
    Para limpar os recepientes e finalizar os testes
    ```shell
    docker-compose down
    ```
    
    Acompanhar a execução do gatling.
    ```shell
    cd src\load-test\docker
    docker-compose logs -f gatling
    ```
    
    Para e reconfigurar o gatling.
    ```shell
    docker-compose stop gatling
    docker-compose start gatling
    ```
    
    Gerar os reports após a execução (quando não for habilitado reports ao fim de cada simulação)
    ```shell
    docker-compose.exe -f docker-compose-reports.yml run --rm reports
    ```
    
    Remover todos os containers
    ```shell
    docker-compose.exe down --remove-orphans
    ```
    
- Endereço para acompanhar os testes:
    - [Grafana LocalHost](http://localhost:8081).
