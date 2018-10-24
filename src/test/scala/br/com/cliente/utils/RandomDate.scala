package br.com.cliente.utils

import scala.util.Random

object RandomDate {

    def gerarData(): String = {
        var valor = ano() + "-" + mes() + "-" + dia()
        return valor
    }

    def dia(): String = {
        var valor = 0
        while (valor == 0) {
            valor = new Random().nextInt(29)
        }
        if (valor < 10)
            return "0" + String.valueOf(valor)
        else return String.valueOf(valor)
    }

    def mes(): String = {
        var valor = 0
        while (valor == 0)
            valor = new Random().nextInt(13)
        if(valor < 10)
            return "0" + String.valueOf(valor)
        else return String.valueOf(valor)
    }

    def ano(): String = {
        var valor = new Random().nextInt(40)
        valor += 1950
        return String.valueOf(valor);
    }

}
