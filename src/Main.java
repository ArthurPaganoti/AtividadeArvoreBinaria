import java.util.Random;

public class Main {

    public static void main(String[] args) {
        NoArvore tree = null;
        Random random = new Random();

        System.out.println("Inserindo 20 números na árvore:");
        for (int i = 0; i < 20; i++) {
            int num = random.nextInt(101);
            System.out.println("Inserindo " + num);
            if (tree == null) {
                tree = new NoArvore();
                tree = tree.InsereRaiz(tree, num);
            } else {
                tree = tree.Insere(tree, num);
            }
        }

        System.out.println("\nImpressão em Pré-ordem:");
        tree.Imp_Cres(tree);

        System.out.println("\nImpressão em In-ordem:");
        tree.Imp_Cres(tree);

        System.out.println("\nImpressão em Pós-ordem:");
        tree.Imp_Decres(tree);

        System.out.println("\nImpressão em Nível:");
        tree.ImpNivel(tree);

        for (int i = 0; i < 5; i++) {
            // Gerar um valor aleatório presente na árvore
            int valor = random.nextInt(101); // Gere um número entre 0 e 100 para buscar

            // Enquanto o valor gerado não estiver na árvore, gere outro valor
            while (tree.Search(tree, valor) == null) {
                valor = random.nextInt(101);
            }

            // Remova o elemento
            tree = tree.retira(tree, valor);
            System.out.println("\nRemovendo 5 elementos da árvore:" + valor);
        }

        System.out.println("\nImpressão em Pré-ordem após remoção:");
        tree.Imp_Cres(tree);

        System.out.println("\nImpressão em In-ordem após remoção:");
        tree.Imp_Cres(tree);

        System.out.println("\nImpressão em Pós-ordem após remoção:");
        tree.Imp_Decres(tree);

        System.out.println("\nImpressão em Nível após remoção:");
        tree.ImpNivel(tree);
    }
}