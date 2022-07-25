package br.com.performance.request

import io.gatling.core.Predef.{exec, _}
import io.gatling.http.Predef.{http, jsonPath, status}

object NomeEndPointPUTRequest {

  val testeHelloWorldPut =
    exec(http("Teste de exemplo para POST utilizando FakeRestApi")
      /**
       * Insere o método e a URL
       */
      .post("/api/Activities/${cpf}")
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
      .check(status.is(200))
      /**
       * Extrai o valor de id do response
       */
      .check(jsonPath("$.id").saveAs("id")))

}