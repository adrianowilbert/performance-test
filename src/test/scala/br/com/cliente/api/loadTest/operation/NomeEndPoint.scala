package br.com.cliente.api.loadTest.operation

import io.gatling.core.Predef.{exec, _}
import io.gatling.http.Predef.{http, status}

object nomeEndPoint {

  val testeHelloWorld =
    exec(actionBuilder = http("Teste de exemplo utilizando FakeRestApi")
      .get("/api/Activities")
     //TODO .headers(Header.--elemento dentro da pasta header com as configurações)
      .check(status.is(200)))

}
