package br.com.performance.config

object Config {
  /**
   * Insere URL padrão para execução dos testes
   */
  val urlApiPrefixo: String = System.getProperty("url.api", "http://fakerestapi.azurewebsites.net:80/"); //Endereço FakeRestApi

  val resourcesPath = ""; //String.format("%s%s", System.getProperty("project.basedir"), "/src/test/resources/bodies/");

}
