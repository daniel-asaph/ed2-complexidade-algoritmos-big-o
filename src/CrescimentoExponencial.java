/**
 * Demonstração do crescimento exponencial O(2ⁿ) em comparação ao logarítmico O(log n).
 *
 * Corresponde ao Slide 7 ("Comparação: Como cada custo cresce"):
 * "Com n = 16: O(log n) = 4 e O(2ⁿ) = 65.536."
 *
 * Disciplina: Estruturas de Dados 2 — Unipê
 * Professor: Edkallenn (Ed)
 * Dupla: Oliveiros Neto e Daniel Asaph
 */
public class CrescimentoExponencial {

    private static long operacoesExponenciais = 0;

    /**
     * Simula uma árvore de recursão binária completa de profundidade n,
     * onde cada chamada gera 2 novas chamadas até atingir o caso base (n == 0).
     * Total de chamadas folha = 2ⁿ.
     */
    static void recursaoExponencial(int n) {
        if (n == 0) {
            operacoesExponenciais++;
            return;
        }
        recursaoExponencial(n - 1);
        recursaoExponencial(n - 1);
    }

    /**
     * Calcula quantos passos são necessários para reduzir n pela metade
     * repetidamente até chegar a 1 — comportamento O(log₂ n).
     */
    static int passosLogaritmicos(int n) {
        int passos = 0;
        while (n > 1) {
            n /= 2;
            passos++;
        }
        return passos;
    }

    public static void main(String[] args) {
        System.out.println("=== Comparação: O(log n) vs O(2^n) (Slide 7) ===");
        System.out.printf("%-6s | %-12s | %-15s%n", "n", "O(log2 n)", "O(2^n)");
        System.out.println("-------+--------------+----------------");

        int[] valores = { 2, 4, 8, 16, 20 };
        for (int n : valores) {
            operacoesExponenciais = 0;
            recursaoExponencial(n);
            int logN = passosLogaritmicos(n);

            System.out.printf("%-6d | %-12d | %-15d%n", n, logN, operacoesExponenciais);
        }
    }
}
