//Gerar senha aleatória: O RoboPremium pode gerar senhas aleatórias de acordo com as especificações do usuário, como comprimento e complexidade. Ele pode incluir letras maiúsculas, minúsculas, números e caracteres especiais para criar senhas seguras.


import interfaces.AcaoPersonalizada         // Importação da interface AcaoPersonalizada para implementar a funcionalidade de geração de senhas aleatórias, permitindo que o RoboPremium execute essa ação personalizada.
import kotlin.random.Random                 // Importação da classe Random para gerar números aleatórios, utilizada na criação de senhas aleatórias

class AcaoGeradorSenha : AcaoPersonalizada {
    
    // Constantes para facilitar manutenção
    companion object {
        private const val TAMANHO_MINIMO = 4
        private const val TAMANHO_MAXIMO = 32
        private const val CHARSET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"
        private val random = Random
    }

    // Mensagem de ajuda como constante
    private val ajuda = """
        Ações disponíveis:
        - senha <tamanho> : gera uma senha aleatória com 4 a 32 caracteres
        - ajuda : mostra esta mensagem
    """.trimIndent()

    override fun executar(comando: String): String {
        val partes = comando.trim().split(Regex("\\s+")).filter { it.isNotEmpty() }
        
        // Comando vazio
        if (partes.isEmpty()) {
            return "Você precisa pedir uma ação! Exemplo: 'senha 12'"
        }

        // Dispatch das ações
        return when (partes[0].lowercase()) {
            "senha" -> gerarSenha(partes.getOrNull(1))
            "ajuda" -> ajuda
            else -> "Ação desconhecida. Digite 'agir ajuda' para ver as opções."
        }
    }

    /**
     * Gera uma senha aleatória com o tamanho solicitado
     * @param tamanhoStr tamanho como string (pode ser null)
     * @return mensagem com a senha ou erro de validação
     */
    private fun gerarSenha(tamanhoStr: String?): String {
        val tamanho = tamanhoStr?.toIntOrNull()
        
        // Validação do tamanho
        if (tamanho == null || !tamanhoEmIntervalo(tamanho)) {
            return "Tamanho inválido. Use um número entre $TAMANHO_MINIMO e $TAMANHO_MAXIMO (ex: 'senha 8')"
        }
        
        return "Senha gerada: ${criarSenhaAleatoria(tamanho)}"
    }

    /**
     * Verifica se o tamanho está dentro do intervalo permitido
     */
    private fun tamanhoEmIntervalo(tamanho: Int): Boolean {
        return tamanho in TAMANHO_MINIMO..TAMANHO_MAXIMO
    }

    /**
     * Cria uma string aleatória com os caracteres permitidos
     */
    private fun criarSenhaAleatoria(tamanho: Int): String {
        return buildString(tamanho) {
            repeat(tamanho) {
                append(CHARSET.random(random))
            }
        }
    }
}