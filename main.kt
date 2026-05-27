//


fun main() {
    val robo = RoboPremium(AcaoGeradorSenha())
    
    println("=== ROBÔ MARCIANO PREMIUM ===")
    println("Fale comigo (digite 'FIM' para encerrar):")
    println()
    println("Exemplos:")
    println("  - Olá, tudo bem?")
    println("  - QUAL É O SEU NOME?")
    println("  - eu quero ajuda")
    println("  - some 10 20")
    println("  - agir senha 12")
    println("  - (deixe vazio para testar)")
    println()

    while (true) {
        print("> ")
        val entrada = readlnOrNull() ?: break
        
        if (entrada.equals("FIM", ignoreCase = true)) {
            println("Até mais!")
            break
        }
        
        val resposta = robo.responda(entrada)
        println(resposta)
        println()
    }
}