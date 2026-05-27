# 🤖 Robô Marciano Premium

Atividade referente à disciplina DESENVOLVIMENTO DE APLICAÇÕES MÓVEIS I de Pós Graduação do **IFSudesteMG**, desenvolvida em **Kotlin**.

O projeto simula um robô com respostas progressivamente mais inteligentes, aplicando conceitos de **herança**, **polimorfismo** e **interfaces**.

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
├── teste/                      # Testes e experimentos
├── AcaoGeradorSenha.kt         # Implementação da ação personalizada
├── RoboMarciano.kt             # Versão base do robô
├── RoboMatematico.kt           # Versão com operações matemáticas
├── RoboPremium.kt              # Versão com ação personalizada
├── main.kt                     # Ponto de entrada do programa
└── robo.jar                    # Artefato compilado pronto para execução
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

Herda o `RoboMarciano` e reconhece operações no formato `<operacao> <numero1> <numero2>`:

| Comando | Exemplo | Resposta |
|---|---|---|
| `some` | `some 10 5` | `"Essa eu sei, resultado: 15"` |
| `subtraia` | `subtraia 10 5` | `"Essa eu sei, resultado: 5"` |
| `multiplique` | `multiplique 3 4` | `"Essa eu sei, resultado: 12"` |
| `divida` | `divida 10 2` | `"Essa eu sei, resultado: 5"` |

> Tentativa de divisão por zero retorna `"Erro: divisão por zero!"`

### RoboPremium — ação personalizada

Herda o `RoboMatematico` e permite que o usuário defina uma ação customizada via interface `AcaoPersonalizada`. Quando o comando `agir` é usado, o robô responde `"É pra já!"` e executa a ação.

```
agir <comando>
```

A ação implementada é o **gerador de senhas**:

| Comando | Exemplo | Resultado |
|---|---|---|
| `agir senha <tamanho>` | `agir senha 12` | `"É pra já!\nSenha gerada: xK3mP9qRtL2w"` |
| `agir ajuda` | `agir ajuda` | Lista de comandos disponíveis |

> O tamanho da senha deve estar entre 4 e 32 caracteres.

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
