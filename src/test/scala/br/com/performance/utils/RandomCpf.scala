package br.com.performance.utils

object RandomCpf {

  /**
   * Responsável por gerar um cpf válido.
   */
  
  def gerarCpf(): String = {
        var prefixo: Array[Int] = new Array[Int](9)
        var a = 0
        for (a <- 0 to 8) {
          prefixo(a) = scala.util.Random.nextInt(9)
        }
    return digitoVerificador(prefixo)
  }

  def digitoVerificador(pre: Array[Int]): String = {
    var primeiroDigito = getPrimeiroDigito(pre)
    var comPrim: Array[Int] = new Array[Int](10)
    for (i <- 0 until pre.length) {
      comPrim(i) = pre(i)
    }
    comPrim(9) = primeiroDigito
    var segundoDigito = getSegundoDigito(primeiroDigito, comPrim)
    var cpf: String = ""

    for (i <- 0 until comPrim.length) {
      cpf += comPrim(i).toString()
    }
    cpf += segundoDigito.toString()
    return cpf
  }

  def getPrimeiroDigito(pre: Array[Int]): Int = {
    var somaProduto: Int = 0
    var tabela1: Array[Int] = Array(10, 9, 8, 7, 6, 5, 4, 3, 2)
    for (i <- 0 until pre.length) {
      somaProduto += tabela1(i) * pre(i)
    }
    var quociente: Int = (somaProduto / 11).floor.toInt
    var resto: Int = somaProduto % 11
    
    if (resto < 2) {
      return 0
    } else {
      return 11 - resto
    }
  }

  def getSegundoDigito(primeiroDigito: Int, pre: Array[Int]): Int = {
    var somaProduto: Int = 0
    var tabela1: Array[Int] = Array(11, 10, 9, 8, 7, 6, 5, 4, 3, 2)
    for (i <- 0 until pre.length) {
      somaProduto += tabela1(i) * pre(i)
    }
    var quociente: Int = (somaProduto / 11).floor.toInt
    var resto: Int = somaProduto % 11

    if (resto < 2) {
      return 0
    } else {
      return 11 - resto
    }
  }
}
