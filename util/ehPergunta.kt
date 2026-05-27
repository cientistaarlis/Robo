// Função para verificar se uma frase é uma pergunta (termina com "?")

package util

fun ehPergunta(frase: String): Boolean {
    return frase.trim().endsWith("?")           // Remove espaços em branco no início e no final da frase e verifica se termina com "?"
}