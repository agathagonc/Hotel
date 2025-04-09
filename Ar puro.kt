package `Ar puro`

fun manutencaoArCondicionado(nomeUsuario: String) {
    var menorValor = Double.MAX_VALUE
    var empresaMaisBarata = ""

    do {
        println("Qual o nome da empresa?")
        val nomeEmpresa = readln()

        println("Qual o valor por aparelho?")
        val valorPorAparelho = readln().toDouble()

        println("Qual a quantidade de aparelhos?")
        val quantidade = readln().toInt()

        println("Qual a porcentagem de desconto?")
        val descontoPercentual = readln().toDouble()

        println("Qual o número mínimo de aparelhos para conseguir o desconto?")
        val quantidadeMinimaDesconto = readln().toInt()

        var total = valorPorAparelho * quantidade

        if (quantidade >= quantidadeMinimaDesconto && descontoPercentual > 0) {
            val desconto = total * (descontoPercentual / 100)
            total -= desconto
        }

        println("O serviço de $nomeEmpresa custará R$ ${"%.2f".format(total)}")

        if (total < menorValor) {
            menorValor = total
            empresaMaisBarata = nomeEmpresa
        }

        println("Deseja informar novos dados, $nomeUsuario? (S/N)")
        val resposta = readln().uppercase()

    } while (resposta == "S")

    println("O orçamento de menor valor é o de $empresaMaisBarata por R$ ${"%.2f".format(menorValor)}")
}
