# Complexidade de Algoritmos (Notação Big-O)

Repositório de apoio ao trabalho em vídeo da disciplina **Estruturas de Dados 2** (**Unipê — Centro Universitário de João Pessoa**), ministrada pelo professor **Edkallenn (Ed)**.

- **Tema:** Complexidade de Algoritmos (notação Big-O, melhor/médio/pior caso e análise assintótica na prática)
- **Integrantes da dupla:** Oliveiros Neto e Daniel Asaph
- **Linguagem:** Java

---

> **Título:**  
> `Trabalho de Estruturas de Dados 2 - Unipê - Prof. Ed - Complexidade de Algoritmos (Big-O) - Oliveiros Neto e Daniel Asaph`

---

## 📚 Sobre o Conteúdo

O projeto responde à pergunta central da apresentação: **por que alguns algoritmos ficam lentos quando os dados aumentam?**

A notação **Big-O** não mede tempo em segundos (que varia conforme hardware, linguagem ou carga da máquina), mas sim **como o número de operações cresce** conforme o tamanho da entrada (n) aumenta — geralmente analisando o **pior caso** e desconsiderando constantes.

### Classes de Complexidade Abordadas

| Notação | Nome | Exemplo no Repositório | Comportamento para n grande |
| :--- | :--- | :--- | :--- |
| O(1) | Constante | Acesso direto a `vetor[5]` | Sempre o mesmo custo |
| O(\log n) | Logarítmica | Busca Binária (em dados ordenados) | Corta o espaço de busca pela metade a cada passo |
| O(n) | Linear | Busca Linear / laço simples | Crescimento proporcional à entrada |
| O(n \log n)$ | Linearítmica | Merge Sort (Divisão e Conquista) | Muito eficiente para grandes volumes |
| O(n^2) | Quadrática | Laços aninhados / Bubble Sort | Dispara rapidamente com o aumento de n |
| O(2^n) | Exponencial | Árvore de recursão binária completa | Inviável mesmo para entradas pequenas |

---

## 📁 Estrutura do Repositório

```text
ed2-complexidade-algoritmos-big-o/
├── src/
│   ├── ContagemOperacoes.java      # Slides 8 e 9: O(1), O(n) e O(n²) na prática
│   ├── ComparacaoBuscas.java       # Slides 10 e 11: Busca Linear O(n) vs Busca Binária O(log n)
│   ├── OrdenacaoComparacao.java    # Slides 5 e 6: Bubble Sort O(n²) vs Merge Sort O(n log n)
│   └── CrescimentoExponencial.java # Slide 7: O(log n) vs O(2ⁿ)
├── .gitignore
└── README.md
```

---

## ⚙️ Como Compilar e Executar

### Pré-requisitos
- **Java JDK** (versão 8 ou superior) instalado e configurado no `PATH`.

### 1. Clonar o repositório
```bash
git clone https://github.com/daniel-asaph/ed2-complexidade-algoritmos-big-o
cd ed2-complexidade-algoritmos-big-o
```

### 2. Compilar os arquivos
No terminal, dentro da raiz do repositório, compile todos os arquivos `.java` para a pasta `out/`:

```bash
javac -encoding UTF-8 -d out src/*.java
```

*(No Windows PowerShell/CMD, você também pode usar `src\*.java`.)*

### 3. Executar as demonstrações

#### 1) Contagem de operações: O(1), O(n) e O(n^2) (Slides 8 e 9)
```bash
java -cp out ContagemOperacoes
```
Saída esperada:
```text
n          | O(1)     | O(n)         | O(n^2)
-----------+----------+--------------+----------------
10         | 1        | 10           | 100
100        | 1        | 100          | 10000
1000       | 1        | 1000         | 1000000
10000      | 1        | 10000        | 100000000
```

#### 2) Busca Linear vs Busca Binária em 1 milhão de registros (Slides 10 e 11)
```bash
java -cp out ComparacaoBuscas
```
Saída esperada (cenário principal com `alvo = 1_999_998`):
```text
Linear: 1000000 | Binaria: 20
```
Também exibe comparações para **melhor caso**, **caso médio** e **pior caso**.

#### 3) Bubble Sort O(n^2) vs Merge Sort O(n \log n) (Slides 5 e 6)
```bash
java -cp out OrdenacaoComparacao
```

#### 4) Crescimento Logarítmico O(\log n) vs Exponencial O(2^n) (Slide 7)
```bash
java -cp out CrescimentoExponencial
```

