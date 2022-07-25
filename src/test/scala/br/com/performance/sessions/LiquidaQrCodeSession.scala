package br.com.performance.sessions

import br.com.performance.sessions.LiquidaQrCodeSession.geraCpfComIdDinamico
import br.com.performance.utils.RandomCpf
import io.gatling.core.Predef._

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.UUID

object LiquidaQrCodeSession {

  /**
   * Gera um CPF utilizando a classe utils de geração de CPF.
   */

  var cpf = RandomCpf.gerarCpf()
  println(cpf)

  /**
   * Gera um ID utilizando a classe JAVA randomUUID e formatando do modo específico para a chamada.
   */

  var id = UUID.randomUUID.toString.replace("-", "")
  println(id)

  /**
   * Gera uma data válida utilizando a classe utils de data e formatando do modo específico para a chamada.
   */

  var date = LocalDateTime.now.format(
    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).replace(" ", "T");
  println(date)

  /**
   * Monta uma session única com cpf
   */

  val geraCpfDinamico =
    exec(sessionCpf => {
      sessionCpf.set("cpf", cpf)
    })

  /**
   * Monta uma session com cpf e id juntos
   */

  val geraCpfComIdDinamico =
    exec(sessionCpf => {
      sessionCpf.set("cpf", cpf)
    })
      .exec(sessionId => {
        sessionId.set("id", id)
      })

  /**
   * Monta a session de data utilizando a session de cpf e id juntos
   */

  val geraCpfComIdComDataDinamico =
    exec(geraCpfComIdDinamico)
      .exec(sessionDate => {
        sessionDate.set("date", date)
      })
}
