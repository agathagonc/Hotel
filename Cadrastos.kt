class cadastrarHospedes() {
    println("\n===== Cadastro de Hóspedes =====")
    print("Qual o valor padrão da diária? R$ ")
    val diaria = readln().toDoubleOrNull()

    if (diaria == null || diaria <= 0) {
        println("Valor inválido. Tente novamente.")
        return cadastrarHospedes()
    }

    var total = 0.0
    var gratuidades = 0
    var meias = 0

    while (true) {
        print("\nQual o nome do Hóspede? (ou digite PARE para encerrar): ")
        val nome = readln()
        if (nome.uppercase() == "PARE") {
            break
        }

        print("Qual a idade do Hóspede? ")
        val idade = readln().toIntOrNull()

        if (idade == null || idade < 0) {
            println("Idade inválida. Tente novamente.")
            continue
        }

        print("$nome cadastrada(o) com sucesso.")

        when {
            idade < 6 -> {
                println(" $nome possui gratuidade.")
                gratuidades++
            }
            idade > 60 -> {
                println(" $nome paga meia.")
                meias++
                total += diaria / 2
            }
            else -> {
                println()
                total += diaria
            }
        }
    }

    println("\n$nomeUsuario, o valor total das hospedagens é: R$%.2f".format(total))
    println("$gratuidades gratuidade(s); $meias meia(s).")
    voltarAoMenu()
}
{
}