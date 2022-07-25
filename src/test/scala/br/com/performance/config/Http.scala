package br.com.performance.config

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object Http {
  /**
   * Insere as configurações para a valor de HTTP utilizado nas requests
   */
  val httpProtocol = http
    .baseURL(Config.urlApiPrefixo)
    .proxy(Proxy("cache.performance.com.br", 3000))
    .disableFollowRedirect
    .inferHtmlResources()
    .acceptHeader("application/json, text/plain, */*")
}