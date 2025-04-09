
package eventos

import kotlin.math.ceil

fun gerenciarEvento(nomeUsuario: String) {
    println("\n===== Parte 1: Quantidade de Convidados =====")
    print("Qual o número de convidados para o seu evento? ")
    val convidados = readln().toIntOrNull()

    if (convidados == null || convidados < 0 || convidados > 350) {
        println("Quantidade de convidados inválida ou superior à capacidade máxima.")
        return
    }

    val auditório: String
    var cadeirasExtras = 0

    if (convidados <= 150) {
        auditório = "Auditório Laranja"
    } else if (convidados <= 220) {
        cadeirasExtras = convidados - 150
        auditório = "Auditório Laranja"
    } else {
        auditório = "Auditório Colorado"
    }

    if (auditório == "Auditório Laranja" && cadeirasExtras > 0) {
        println("Use o $auditório (inclua mais $cadeirasExtras cadeiras)")
    } else {
        println("Use o $auditório")
    }

    println("Agora vamos ver a agenda do evento.")

    println("\n===== Parte 2: Agenda =====")
    print("Qual o dia do evento? (ex: segunda, sabado): ")
    val dia = readln()
    print("Qual a hora do evento? (somente a hora, ex: 13): ")
    val hora = readln().toIntOrNull()

    val disponivel = when (dia) {
        "sabado", "domingo" -> hora != null && hora in 7..15
        else -> hora != null && hora in 7..23
    }

    if (!disponivel) {
        println("Auditório indisponível para este horário.")
        return
    }

    print("Qual o nome da empresa? ")
    val empresa = readln()
    println("Auditório reservado para $empresa. ${dia.replaceFirstChar { it.uppercase() }} às ${hora}hs.")

    println("\n===== Parte 3: Staff =====")
    print("Qual a duração do evento em horas? ")
    val duracao = readln().toIntOrNull() ?: 0

    val garçonsPorConvidado = ceil(convidados / 12.0).toInt()
    val garçonsExtras = ceil(duracao / 2.0).toInt()
    val totalGarçons = garçonsPorConvidado + garçonsExtras
    val custoGarçons = totalGarçons * duracao * 10.5

    println("São necessários $totalGarçons garçons.")
    println("Custo: R$%.2f".format(custoGarçons))
    println("Agora vamos calcular o buffet do hotel para o evento.")

    println("\n===== Parte 4: Buffet =====")
    val litrosCafe = convidados * 0.2
    val litrosAgua = convidados * 0.5
    val salgados = convidados * 7

    val custoCafe = litrosCafe * 0.80
    val custoAgua = litrosAgua * 0.40
    val custoSalgados = ceil(salgados / 100.0) * 34
    val custoBuffet = custoCafe + custoAgua + custoSalgados

    println("O evento precisará de %.1f litros de café, %.1f litros de água, %d salgados."
        .format(litrosCafe, litrosAgua, salgados))

    println("\n===== Parte 5: Conferência =====")
    println("Evento no $auditório.")
    println("Nome da Empresa: $empresa.")
    println("Data: ${dia.replaceFirstChar { it.uppercase() }}, ${hora}h às ${hora + duracao}h.")
    println("Duração do evento: ${duracao}h.")
    println("Quantidade de garçons: $totalGarçons.")
    println("Quantidade de Convidados: $convidados")
    println("Custo dos garçons: R$%.2f".format(custoGarçons))
    println("Custo do Buffet: R$%.2f".format(custoBuffet))
    println("Valor total do Evento: R$%.2f".format(custoGarçons + custoBuffet))

    print("\nGostaria de efetuar a reserva? (S/N) ")
    val confirmacao = readln()
    if (confirmacao.uppercase() == "S") {
        println("$nomeUsuario, reserva efetuada com sucesso.")
    } else {
        println("Reserva não efetuada.")
    }

    println("\nPressione ENTER para voltar ao menu.")
    readln()
}
