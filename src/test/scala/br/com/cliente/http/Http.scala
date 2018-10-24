package br.com.cliente.http

import br.com.cliente.utils._
import io.gatling.core.Predef._
import io.gatling.http.Predef._

object Http {
  val httpProtocol = http
    .baseURL(Config.urlApiPrefixo)
    .disableFollowRedirect
    .inferHtmlResources()
    .acceptHeader("application/json, text/plain, */*")
}