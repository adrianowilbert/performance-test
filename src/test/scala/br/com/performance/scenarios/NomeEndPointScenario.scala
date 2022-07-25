package br.com.performance.scenarios

import br.com.performance.request.{NomeEndPointGETRequest, NomeEndPointPOSTRequest, NomeEndPointPUTRequest}
import io.gatling.core.Predef.scenario

object NomeEndPointScenario {
  val scenarioHelloWorld = scenario("Consulta atividades do EP /api/Activities da FakeRestAPI")
    /**
     * Realiza a chamada da classe request de POST
     */
    .exec(NomeEndPointPOSTRequest.testeHelloWorldPost)
    /**
     * Realiza a chamada da classe request de GET
     */
    .exec(NomeEndPointGETRequest.testeHelloWorldGet)
    /**
     * Realiza a chamada da classe request de PUT
     */
    .exec(NomeEndPointPUTRequest.testeHelloWorldPut)
}
