// Função para verificar se uma frase contém uma palavra totalmente em maiúsculas

package util

fun temPalavraMaiuscula(frase: String): Boolean {
    val palavras = frase.split(Regex("\\s+"))                                               // Frase joga em uma lista de palavras, usando espaço como separador
    for (palavra in palavras) {                                                             // Varre todas as palavras da frase(lista)
        val limpa = palavra.trim('.', ',', '!', '?', ';', ':')                              // Remove pontuação comum das palavras para verificar apenas as letras   
        if (limpa.isNotEmpty() && limpa.all { it.isUpperCase() && it.isLetter() }) {        // Verifica se a palavra limpa é totalmente em maiúsculas e contém apenas letras
            return true
        }
    }
    return false
}
