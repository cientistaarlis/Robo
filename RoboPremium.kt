// Classe que representa um robô premium, que herda as funcionalidades do RoboMatematico e adiciona a capacidade de executar ações personalizadas


//Importação da classe AcaoPersonalizada para permitir a execução de ações personalizadas no RoboPremium
import interfaces.AcaoPersonalizada

class RoboPremium(private val acao: AcaoPersonalizada) : RoboMatematico() {
    override fun responda(frase: String): String {
        val f = frase.trim()
        val comandoRegex = Regex("^agir\\s+(.*)$", RegexOption.IGNORE_CASE)     // Expressão regular para identificar comandos que começam com "agir","AGIR","Agir"
        val match = comandoRegex.find(f)                                        //Encontrar uma correspondência do comando "agir" na frase, ignorando maiúsculas e minúsculas, e extrair o parâmetro que segue o comando. 
        
        if (match != null) {                                        
            val parametro = match.groupValues[1].trim()         //Tenta encontrar uma ocorrência do comando "agir" na frase e extrai o parâmetro que segue o comando
            val resultadoAcao = acao.executar(parametro)        //Chama metodo da interface AcaoPersonalizada para executar a ação personalizada com o parâmetro extraído do comando  
            return "É pra já!\n$resultadoAcao"
        }
        
        return super.responda(frase)     //se a frase não for um comando de ação personalizada, chama a implementação da classe pai (RoboMatematico) para processar normalmente
    }
}