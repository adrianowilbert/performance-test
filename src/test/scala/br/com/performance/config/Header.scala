package br.com.performance.config

object Header {
  /**
   * Insere valores de cabeçalho, podendo ter um específico para cada request
   */
  val header = collection.mutable.Map(
    "Accept" -> "*/*",
    "Content-Type" -> "application/json"
  )

  val header_authorization = Map(
    "Authorization" -> "Bearer ${token}"
  )

}
