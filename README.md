# 🤖 Robô Marciano Premium

Projeto desenvolvido em **Kotlin** que simula um robô com respostas progressivamente mais inteligentes, aplicando conceitos de **herança**, **polimorfismo** e **interfaces**.

---

## 📋 Descrição

O projeto é composto por três versões do robô Marciano, cada uma herdando as capacidades da anterior e adicionando novas funcionalidades.

```
RoboMarciano
    └── RoboMatematico
            └── RoboPremium
```

---

## 🗂️ Estrutura do projeto

```
├── interfaces/
│   └── Acaopersonalizada.kt    # Interface para ações personalizadas
├── util/
│   ├── contemPalavraEu.kt      # Verifica a palavra "eu" na frase
│   ├── ehPergunta.kt           # Verifica se a frase é uma pergunta
│   ├── estaVazia.kt            # Verifica se a frase está vazia
│   └── temPalavraMaiuscula.kt  # Verifica palavras em maiúsculas
├── AcaoGeradorSenha.kt         # Implementação da ação personalizada
├── RoboMarciano.kt             # Versão base do robô
├── RoboMatematico.kt           # Versão com operações matemáticas
├── RoboPremium.kt              # Versão com ação personalizada
└── main.kt                     # Ponto de entrada do programa
```

---

## 🤖 Versões do robô

### RoboMarciano — versão base

Responde a frases com base em 6 regras, verificadas nessa ordem:

| Condição | Resposta |
|---|---|
| Pergunta + palavra em maiúsculas | `"Relaxa, eu sei o que estou fazendo!"` |
| Pergunta (termina com `?`) | `"Certamente"` |
| Palavra totalmente em maiúsculas | `"Opa! Calma aí!"` |
| Contém a palavra `eu` | `"A responsabilidade é sua"` |
| Frase vazia | `"Não me incomode"` |
| Qualquer outra coisa | `"Tudo bem, como quiser"` |

### RoboMatematico — operações matemáticas

Herda o `RoboMarciano` e passa a reconhecer operações matemáticas no formato:

```
<operacao> <numero1> <numero2>
```

| Comando | Exemplo | Resposta |
|---|---|---|
| `some` | `some 10 5` | `"Essa eu sei, resultado: 15"` |
| `subtraia` | `subtraia 10 5` | `"Essa eu sei, resultado: 5"` |
| `multiplique` | `multiplique 3 4` | `"Essa eu sei, resultado: 12"` |
| `divida` | `divida 10 2` | `"Essa eu sei, resultado: 5"` |

> Tentativa de divisão por zero retorna `"Erro: divisão por zero!"`

### RoboPremium — ação personalizada

Herda o `RoboMatematico` e permite que o usuário defina uma ação customizada via interface `AcaoPersonalizada`. Quando a palavra `agir` é usada, o robô responde `"É pra já!"` e executa a ação.

```
agir <comando>
```

A ação padrão implementada é o **gerador de senhas**:

| Comando | Exemplo | Resposta |
|---|---|---|
| `agir senha <tamanho>` | `agir senha 12` | `"É pra já!\nSenha gerada: xK3mP9qRtL2w"` |
| `agir ajuda` | `agir ajuda` | Lista de comandos disponíveis |

---

## ▶️ Como executar

### Pré-requisitos

- [JDK 8+](https://www.oracle.com/java/technologies/downloads/)
- [Kotlin](https://kotlinlang.org/docs/command-line.html) instalado, ou use o [IntelliJ IDEA](https://www.jetbrains.com/idea/)

### Pelo IntelliJ IDEA

1. Clone o repositório:
```bash
git clone https://github.com/seu-usuario/robo-marciano.git
```
2. Abra o projeto no IntelliJ IDEA
3. Execute o arquivo `main.kt`

### Pela linha de comando

```bash
# Compile todos os arquivos
kotlinc interfaces/Acaopersonalizada.kt util/*.kt *.kt -include-runtime -d robo.jar

# Execute
java -jar robo.jar
```

---

## 💬 Exemplos de uso

```
=== ROBÔ MARCIANO PREMIUM ===
Fale comigo (digite 'FIM' para encerrar):

> Olá, tudo bem?
Certamente

> QUAL É O SEU NOME?
Relaxa, eu sei o que estou fazendo!

> eu quero ajuda
A responsabilidade é sua

> some 15 7
Essa eu sei, resultado: 22

> agir senha 16
É pra já!
Senha gerada: Tz8mKqR3pL5xNw2v

> FIM
Até mais!
```

---

## 🧩 Conceitos aplicados

- **Herança** — `RoboMatematico` e `RoboPremium` estendem as classes anteriores sem modificá-las
- **Polimorfismo** — `override fun responda()` redefine o comportamento em cada nível
- **Interface** — `AcaoPersonalizada` desacopla a lógica da ação do robô
- **Funções utilitárias** — lógica de verificação isolada no pacote `util`
- **Expressões regulares** — detecção do comando `agir` via `Regex` no `RoboPremium`

---

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.
