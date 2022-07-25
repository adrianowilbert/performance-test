package br.com.performance.simulations

import br.com.performance.config.Http
import br.com.performance.scenarios.NomeEndPointScenario.scenarioHelloWorld
import io.gatling.core.Predef._

import scala.concurrent.duration._

class NomeRotaCargaSimulation extends Simulation {

  /**
   * Divide 100 mil users inserindo 10 users a cada 5 seg,
   * depois aguarda 10 seg e insere mais 10 users no tempo máx de 10 horas.
   */

  setUp(scenarioHelloWorld.inject(
    splitUsers(100000) into(rampUsers(10) over(5 seconds)) separatedBy(10 seconds))
    .protocols(Http.httpProtocol))
    .maxDuration(7 hours)

}