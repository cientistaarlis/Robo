//Caso alguém fale alguma coisa que use a palavra "eu" (com ou sem maiúsculas), ele responde 

//Função para verificar se uma frase contém a palavra "eu", "EU", "Eu", etc.

package util

fun contemPalavraEu(frase: String): Boolean {
    val palavras = frase.split(Regex("\\s+"))                       //Lista de palavras, separando por espaços
    for (palavra in palavras) {
        val limpa = palavra.trim('.', ',', '!', '?', ';', ':')      //Remove pontuação comum ao redor da palavra
        if (limpa.equals("eu", ignoreCase = true)) {                //Verifica se a palavra limpa é "eu", ignorando maiúsculas/minúsculas     
            return true
        }
    }
    return false
}