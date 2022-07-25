package br.com.performance.request

import io.gatling.core.Predef.{exec, _}
import io.gatling.http.Predef.{http, status}

object NomeEndPointGETRequest {

  val testeHelloWorldGet =
    exec(http("Teste de exemplo para GET utilizando FakeRestApi")
      /**
       * Insere o método e a URL
       */
      .get("/api/Activities")
      /**
       * Insere os headers
       */
      .header("content-type", "application/json")
      .header("Authorization", "Bearer ${token}")
      /**
       * Valida o status code
       */
      .check(status.is(200)))
}