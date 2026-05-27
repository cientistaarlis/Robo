// Classe que representa um robô marciano e contém a função de resposta
//Em kotlin, a palavra-chave "open" é usada para permitir que uma classe seja herdada por outras classes. Por padrão, as classes em Kotlin são "final", o que significa que não podem ser herdadas. Ao marcar a classe "RoboMatematico" como "open", estamos permitindo que outras classes possam herdar dela e estender suas funcionalidades.

open class RoboMatematico : RoboMarciano() {    //Herança em Kotlin
    private fun processarOperacao(frase: String): String? {               //Funcao para processar operações matemáticas simples
        val partes = frase.trim().split(Regex("\\s+"))
        if (partes.size != 3) return null               //operacao numero1 numero2
        
        val operacao = partes[0].lowercase()        //operacao em minusculo para facilitar a comparação
        val a = partes[1].toDoubleOrNull()          //conversão de string para double
        val b = partes[2].toDoubleOrNull()
        
       if (a == null || b == null) return null

        val resultado = when (operacao) {                   // Operações matemáticas simples: adição, subtração, multiplicação e divisão
            "some" -> a + b
            "subtraia" -> a - b
            "multiplique" -> a * b
            "divida" -> {
                if (b == 0.0) return "Erro: divisão por zero!"
                a / b
            }
            else -> return null
        }
        
        val resFormatado = if (resultado == resultado.toInt().toDouble())  //Formatar sem casas decimais e exibir como inteiro se o resultado for um número inteiro, caso contrário exibir com casas decimais
            resultado.toInt().toString() 
        else 
            resultado.toString()
            
        return "Essa eu sei, resultado: $resFormatado"
    }

    override fun responda(frase: String): String {          //Reescrevo a função responda para processar operações matemáticas antes de chamar a implementação da classe pai (RoboMarciano)
        val resultadoOp = processarOperacao(frase)
        if (resultadoOp != null) {
            return resultadoOp
        }
        return super.responda(frase)                        // Se a frase não for uma operação matemática, chamo a implementação da classe pai para processar outras respostas
    }
}