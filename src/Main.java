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

        System.out.println("\nRemovendo 5 elementos da árvore:");
        for (int i = 0; i < 5; i++) {
            int num = random.nextInt(101);
            System.out.println("Removendo " + num);
            tree = tree.retira(tree, num);
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