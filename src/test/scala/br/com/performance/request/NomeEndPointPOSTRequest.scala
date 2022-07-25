package br.com.performance.request

import io.gatling.core.Predef.{exec, _}
import io.gatling.http.Predef.{http, status}

object NomeEndPointPOSTRequest {

  val testeHelloWorldPost =
    exec(http("Teste de exemplo para POST utilizando FakeRestApi")
      /**
       * Insere o método e a URL
       */
      .post("/api/Activities")
      /**
       * Insere os headers
       */
      .header("content-type", "application/json")
      .header("Authorization", "Bearer ${token}")
      /**
       * Insere os bodies que estão na paras "resources.bodies.input"
       */
      .body(ElFileBody("bodies/input/payloadMetodoNomeEndPoint.json"))
      /**
       * Valida o status code
       */
      .check(status.is(201)))
}