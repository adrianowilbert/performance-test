package br.com.performance.simulations

import br.com.performance.config.Http
import br.com.performance.scenarios.NomeEndPointScenario.scenarioHelloWorld
import io.gatling.core.Predef._

import scala.concurrent.duration._

class NomeRotaStressSimulation extends Simulation {

  /**
   * Insere 10 users no período de 30 seg.
   */

  setUp(scenarioHelloWorld.inject(
    rampUsers(10) over (30 seconds)))
    .protocols(Http.httpProtocol)

}