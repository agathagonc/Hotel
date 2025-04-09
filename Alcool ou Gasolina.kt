package `Álcool ou Gasolina`


fun abastecimentoVeiculo(nomeUsuario: String) {
    println("Qual o valor do álcool no posto Wayne Oil?")
    val alcoolWayne = readln().toDouble()

    println("Qual o valor da gasolina no posto Wayne Oil?")
    val gasolinaWayne = readln().toDouble()

    println("Qual o valor do álcool no posto Stark Petrol?")
    val alcoolStark = readln().toDouble()

    println("Qual o valor da gasolina no posto Stark Petrol?")
    val gasolinaStark = readln().toDouble()

    val tanque = 42

    fun melhorOpcao(alcool: Double, gasolina: Double): String {
        return if (alcool < gasolina * 0.7) "álcool" else "gasolina"
    }

    val opcaoWayne = melhorOpcao(alcoolWayne, gasolinaWayne)
    val valorWayne = if (opcaoWayne == "álcool") alcoolWayne * tanque else gasolinaWayne * tanque

    val opcaoStark = melhorOpcao(alcoolStark, gasolinaStark)
    val valorStark = if (opcaoStark == "álcool") alcoolStark * tanque else gasolinaStark * tanque

    val maisBarato = if (valorWayne < valorStark) {
        "abastecer com $opcaoWayne no posto Wayne Oil"
    } else {
        "abastecer com $opcaoStark no posto Stark Petrol"
    }

    println("$nomeUsuario, é mais barato $maisBarato.")
}
