// Classe que representa um robô marciano e contém a função de resposta

// Função responda principal que responde a uma frase de acordo com as regras especificadas 

import interfaces.AcaoPersonalizada         // Importação da interface AcaoPersonalizada para permitir que o RoboMarciano 

//Importação de funções utilitárias 
//Essas funções são usadas para determinar a resposta do robô com base nas regras estabelecidas.
import util.ehPergunta
import util.temPalavraMaiuscula
import util.contemPalavraEu
import util.estaVazia

open class RoboMarciano {                               // Classe aberta para permitir herança
    open fun responda(frase: String): String {          // Função aberta para permitir sobreposição 
        val f = frase.trim()                            // Metodo trim para remover espaços em branco no início e no final da frase

        if (ehPergunta(f) && temPalavraMaiuscula(f)) {
            return "Relaxa, eu sei o que estou fazendo!"
        }
        if (ehPergunta(f)) {
            return "Certamente"
        }
        if (temPalavraMaiuscula(f)) {
            return "Opa! Calma aí!"
        }
        if (contemPalavraEu(f)) {
            return "A responsabilidade é sua"
        }
        if (estaVazia(f)) {
            return "Não me incomode"
        }
        return "Tudo bem, como quiser"
    }
}