/**
 * Comparação prática entre Busca Linear O(n) e Busca Binária O(log n)
 * em um vetor ordenado com 1 milhão de registros.
 *
 * Corresponde aos Slides 4, 8, 10 e 11 da apresentação:
 * - Estratégia A: Busca Linear (pior caso: 1.000.000 de comparações)
 * - Estratégia B: Busca Binária (pior caso: ~20 comparações)
 *
 * Também demonstra o comportamento nos cenários de melhor, médio e pior caso.
 *
 * Disciplina: Estruturas de Dados 2 — Unipê
 * Professor: Edkallenn (Ed)
 * Dupla: Oliveiros Neto e Daniel Asaph
 */
public class ComparacaoBuscas {

    /**
     * Estratégia A: Busca Linear — O(n).
     * Verifica os elementos um por um, do início ao fim.
     * Não exige que o vetor esteja ordenado, mas no pior caso percorre todos os n elementos.
     *
     * @param v    vetor de inteiros
     * @param alvo valor procurado
     * @return quantidade de comparações realizadas até encontrar (ou percorrer tudo)
     */
    static int buscaLinear(int[] v, int alvo) {
        int compA = 0;
        for (int i = 0; i < v.length; i++) {
            compA++;
            if (v[i] == alvo) {
                break;
            }
        }
        return compA;
    }

    /**
     * Estratégia B: Busca Binária — O(log n).
     * Pré-requisito obrigatório: o vetor precisa estar ordenado.
     * A cada passo, calcula o índice do meio e descarta metade do intervalo restante.
     *
     * @param v    vetor ordenado de inteiros
     * @param alvo valor procurado
     * @return quantidade de comparações realizadas
     */
    static int buscaBinaria(int[] v, int alvo) {
        int compB = 0;
        int ini = 0;
        int fim = v.length - 1;

        while (ini <= fim) {
            compB++;
            // Calcula o ponto médio evitando overflow para vetores muito grandes
            int meio = ini + (fim - ini) / 2;

            if (v[meio] == alvo) {
                break; // Elemento encontrado
            } else if (v[meio] < alvo) {
                ini = meio + 1; // Descarta a metade esquerda
            } else {
                fim = meio - 1; // Descarta a metade direita
            }
        }
        return compB;
    }

    public static void main(String[] args) {
        // Cenário principal dos Slides 10 e 11: 1 milhão de registros ordenados
        int[] v = new int[1_000_000];
        for (int i = 0; i < v.length; i++) {
            v[i] = i * 2; // Dados ordenados: 0, 2, 4, ..., 1_999_998
        }

        // Alvo no último elemento -> pior caso da Busca Linear (1.000.000 de comparações)
        int alvo = 1_999_998;

        int compA = buscaLinear(v, alvo);
        int compB = buscaBinaria(v, alvo);

        System.out.println("=== Cenário Principal (Slides 10 e 11): 1.000.000 de registros ===");
        System.out.println("Alvo: " + alvo + " (último elemento - pior caso)");
        System.out.println("Linear: " + compA + " | Binaria: " + compB);
        System.out.println();

        // Análise complementar: Melhor caso, Caso médio e Pior caso
        System.out.println("=== Análise de Casos (Melhor, Médio e Pior) ===");
        int[] alvosTeste = {
            v[0],               // Melhor caso da linear (1ª posição)
            v[v.length / 2],    // Melhor caso aproximado da binária (meio) / médio da linear
            v[v.length - 1],    // Pior caso (último elemento)
            -1                  // Elemento inexistente (pior caso absoluto em ambas)
        };
        String[] descricoes = {
            "Primeiro elemento (v[0])",
            "Elemento central (v[500_000])",
            "Último elemento (v[999_999])",
            "Elemento inexistente (-1)"
        };

        for (int i = 0; i < alvosTeste.length; i++) {
            int lin = buscaLinear(v, alvosTeste[i]);
            int bin = buscaBinaria(v, alvosTeste[i]);
            System.out.printf("%-30s -> Linear: %7d comp. | Binária: %2d comp.%n",
                    descricoes[i], lin, bin);
        }
    }
}
