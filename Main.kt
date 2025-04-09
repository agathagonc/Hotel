
// Nome do hotel fixo
const val NOME_HOTEL = "Hotel Sol"
// Lista para simular os quartos: true = ocupado, false = livre
val quartos = MutableList(20) { false }
// Nome do usuário logado (será preenchido após o login)
var nomeUsuario = ""

fun main() {
    autenticar()
    iniciar()
}

fun autenticar() {
    println("Bem-vindo ao $NOME_HOTEL!")
    print("Digite seu nome de usuário: ")
    nomeUsuario = readln()

    print("Digite a senha de acesso: ")
    val senha = readln()

    if (senha == "2678") {
        println("Bem-vindo ao $NOME_HOTEL, $nomeUsuario. É um imenso prazer ter você por aqui!\n")
    } else {
        println("Senha incorreta. Tente novamente.\n")
        autenticar()
    }
}

fun iniciar() {
    mostrarMenu()

    val escolha = readln().toIntOrNull()
    when (escolha) {
        1 -> cadastrarQuartos()
        2 -> cadastrarHospedes()
        3 -> abastecimentoDeAutomoveis()
        4 -> listarQuartos()
        5 -> sairDoHotel()
        else -> erro()
    }
}

fun mostrarMenu() {
    println("\n===== MENU PRINCIPAL =====")
    println("1 - Cadastrar Quartos")
    println("2 - Cadastrar Hóspedes")
    println("3 - Abastecimento de Automóveis")
    println("4 - Listar Quartos")
    println("5 - Sair do Sistema")
    print("Escolha uma opção: ")
}

fun cadastrarQuartos() {
    println("\nCadastro de Quartos")
    println("Digite o número do quarto que deseja ocupar (1 a 20):")
    val numero = readln().toIntOrNull()

    if (numero == null || numero !in 1..20) {
        println("Número de quarto inválido.")
    } else if (quartos[numero - 1]) {
        println("Quarto $numero já está ocupado.")
    } else {
        quartos[numero - 1] = true
        println("Quarto $numero cadastrado com sucesso.")
    }

    voltarAoMenu()
}

fun cadastrarHospedes() {
    println("\nCadastro de Hóspedes")
    print("Digite o nome do hóspede: ")
    val nome = readln()
    println("Hóspede $nome cadastrado com sucesso!")

    voltarAoMenu()
}

fun abastecimentoDeAutomoveis() {
    println("\nAbastecimento de Automóveis")
    println("Abastecendo veículo... pronto!")
    voltarAoMenu()
}

fun listarQuartos() {
    println("\nEstado dos Quartos:")
    for ((index, ocupado) in quartos.withIndex()) {
        val status = if (ocupado) "Ocupado" else "Livre"
        println("Quarto ${index + 1}: $status")
    }
    voltarAoMenu()
}

fun sairDoHotel() {
    println("Muito obrigado e até logo, $nomeUsuario.")
}

fun erro() {
    println("Por favor, informe uma opção válida (1 a 5).")
    iniciar()
}

fun voltarAoMenu() {
    println("\nPressione ENTER para voltar ao menu.")
    readln()
    iniciar()
}
