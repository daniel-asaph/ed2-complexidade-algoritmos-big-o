import java.util.Arrays;

/**
 * Comparação prática entre um algoritmo de ordenação quadrático e um de divisão e conquista:
 * - Bubble Sort : O(n²)      — Slide 5
 * - Merge Sort  : O(n log n) — Slide 6
 *
 * Mede o número de comparações e o tempo de execução para diferentes tamanhos de entrada.
 *
 * Disciplina: Estruturas de Dados 2 — Unipê
 * Professor: Edkallenn (Ed)
 * Dupla: Oliveiros Neto e Daniel Asaph
 */
public class OrdenacaoComparacao {

    private static long comparacoesBubble = 0;
    private static long comparacoesMerge = 0;

    /**
     * Bubble Sort — O(n²) no pior caso e no caso médio.
     * Utiliza dois laços aninhados para comparar e trocar elementos adjacentes.
     */
    static void bubbleSort(int[] v) {
        comparacoesBubble = 0;
        int n = v.length;
        for (int i = 0; i < n - 1; i++) {
            boolean trocou = false;
            for (int j = 0; j < n - 1 - i; j++) {
                comparacoesBubble++;
                if (v[j] > v[j + 1]) {
                    int temp = v[j];
                    v[j] = v[j + 1];
                    v[j + 1] = temp;
                    trocou = true;
                }
            }
            // Otimização: se não houve troca na passagem, o vetor já está ordenado (melhor caso O(n))
            if (!trocou) {
                break;
            }
        }
    }

    /**
     * Merge Sort — O(n log n) em todos os casos (melhor, médio e pior).
     * Estratégia de Divisão e Conquista (Slide 6):
     * 1. Dividir: parte os dados ao meio repetidamente;
     * 2. Ordenar: ordena recursivamente cada parte menor;
     * 3. Combinar: junta as metades ordenadas no método intercalar().
     */
    static void mergeSort(int[] v, int inicio, int fim) {
        if (inicio < fim) {
            int meio = inicio + (fim - inicio) / 2;

            // 1 e 2: Divide e ordena recursivamente cada metade
            mergeSort(v, inicio, meio);
            mergeSort(v, meio + 1, fim);

            // 3: Combina as duas metades já ordenadas
            intercalar(v, inicio, meio, fim);
        }
    }

    private static void intercalar(int[] v, int inicio, int meio, int fim) {
        int n1 = meio - inicio + 1;
        int n2 = fim - meio;

        int[] esquerda = new int[n1];
        int[] direita = new int[n2];

        System.arraycopy(v, inicio, esquerda, 0, n1);
        System.arraycopy(v, meio + 1, direita, 0, n2);

        int i = 0, j = 0, k = inicio;
        while (i < n1 && j < n2) {
            comparacoesMerge++;
            if (esquerda[i] <= direita[j]) {
                v[k++] = esquerda[i++];
            } else {
                v[k++] = direita[j++];
            }
        }

        while (i < n1) {
            v[k++] = esquerda[i++];
        }
        while (j < n2) {
            v[k++] = direita[j++];
        }
    }

    /**
     * Gera um vetor em ordem decrescente (pior caso para o Bubble Sort).
     */
    static int[] gerarVetorDecrescente(int n) {
        int[] v = new int[n];
        for (int i = 0; i < n; i++) {
            v[i] = n - i;
        }
        return v;
    }

    public static void main(String[] args) {
        int[] tamanhos = { 100, 1_000, 10_000, 30_000 };

        System.out.println("=== Comparação de Ordenação: Bubble Sort O(n²) vs Merge Sort O(n log n) ===");
        System.out.println("Cenário: vetor inicialmente em ordem decrescente (pior caso)\n");
        System.out.printf("%-8s | %-16s | %-12s | %-16s | %-12s%n",
                "n", "Bubble (comp.)", "Bubble (ms)", "Merge (comp.)", "Merge (ms)");
        System.out.println("---------+------------------+--------------+------------------+-------------");

        for (int n : tamanhos) {
            int[] base = gerarVetorDecrescente(n);

            int[] vBubble = Arrays.copyOf(base, base.length);
            long t1 = System.nanoTime();
            bubbleSort(vBubble);
            double msBubble = (System.nanoTime() - t1) / 1_000_000.0;

            int[] vMerge = Arrays.copyOf(base, base.length);
            comparacoesMerge = 0;
            long t2 = System.nanoTime();
            mergeSort(vMerge, 0, vMerge.length - 1);
            double msMerge = (System.nanoTime() - t2) / 1_000_000.0;

            System.out.printf("%-8d | %-16d | %-12.3f | %-16d | %-12.3f%n",
                    n, comparacoesBubble, msBubble, comparacoesMerge, msMerge);
        }
    }
}
