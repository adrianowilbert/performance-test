package br.com.cliente.api.loadTest.simulation

import br.com.cliente.api.loadTest.operation.nomeEndPoint
import br.com.cliente.http.Http
import io.gatling.core.Predef._

import scala.concurrent.duration._

class NomeRota extends Simulation {

  val scenarioHelloWorld = scenario("Consulta atividades do EP /api/Activities da FakeRestAPI")
    .exec(nomeEndPoint.testeHelloWorld)

  setUp(scenarioHelloWorld.inject(rampUsers(10) over (30 seconds))).protocols(Http.httpProtocol)

}