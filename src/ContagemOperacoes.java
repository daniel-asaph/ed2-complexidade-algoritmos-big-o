/**
 * Demonstração prática de contagem de operações para as classes:
 * - O(1)  : Complexidade Constante
 * - O(n)  : Complexidade Linear
 * - O(n²): Complexidade Quadrática
 *
 * Corresponde aos Slides 8 e 9 da apresentação:
 * "Identificando a complexidade" e "Código em Java (1/3): Contando operações".
 *
 * Disciplina: Estruturas de Dados 2 — Unipê
 * Professor: Edkallenn (Ed)
 * Dupla: Oliveiros Neto e Daniel Asaph
 */
public class ContagemOperacoes {

    /**
     * Complexidade O(1) — Constante.
     * Acessa diretamente uma posição específica do vetor pelo índice.
     * Independentemente de o vetor ter 10 ou 10 milhões de elementos,
     * o custo permanece constante (1 operação de acesso).
     */
    static int acessar(int[] v) {
        return v[5]; // O(1)
    }

    /**
     * Complexidade O(n) — Linear.
     * Percorre os n elementos exatamente uma vez com um único laço.
     * Se n dobra, a quantidade de operações também dobra.
     */
    static long percorrer(int n) {
        long c = 0;
        for (int i = 0; i < n; i++) {
            c++; // O(n)
        }
        return c;
    }

    /**
     * Complexidade O(n²) — Quadrática.
     * Dois laços aninhados percorrendo até n: para cada iteração do laço externo,
     * o laço interno executa n vezes (n * n = n² operações).
     */
    static long aninhados(int n) {
        long c = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                c++; // O(n²)
            }
        }
        return c;
    }

    public static void main(String[] args) {
        // Vetor de exemplo para demonstrar o acesso direto O(1)
        int[] vetorExemplo = new int[10_000];
        for (int i = 0; i < vetorExemplo.length; i++) {
            vetorExemplo[i] = i * 10;
        }

        System.out.println("=== Demonstração: Contagem de Operações (Slide 8 e 9) ===");
        System.out.println("Exemplo O(1) - acessar(vetorExemplo) na posição 5: " + acessar(vetorExemplo));
        System.out.println();

        // Tamanhos de entrada exibidos na tabela do Slide 8
        int[] tamanhos = { 10, 100, 1_000, 10_000 };

        System.out.printf("%-10s | %-8s | %-12s | %-15s%n", "n", "O(1)", "O(n)", "O(n^2)");
        System.out.println("-----------+----------+--------------+----------------");

        for (int n : tamanhos) {
            // Para O(1), o acesso direto realiza sempre 1 operação
            acessar(vetorExemplo);
            long opConstante = 1;

            long opLinear = percorrer(n);
            long opQuadratica = aninhados(n);

            System.out.printf("%-10d | %-8d | %-12d | %-15d%n",
                    n, opConstante, opLinear, opQuadratica);
        }
    }
}
