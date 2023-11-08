import java.util.Queue;
import java.util.LinkedList;

public class NoArvore {

    int info;
    NoArvore direita = null;
    NoArvore esquerda = null;

    void Imp_Cres(NoArvore tree) {
        if (tree != null) {
            Imp_Cres(tree.esquerda);
            System.out.println(tree.info);
            Imp_Cres(tree.direita);
        }
    }

    NoArvore Search(NoArvore tree, int valor) {
        if (tree == null) {
            return null;
        } else if (tree.info == valor) {
            return tree;
        } else if (valor < tree.info) {
            return Search(tree.esquerda, valor);
        } else {
            return Search(tree.direita, valor);
        }
    }

    NoArvore InsereRaiz(NoArvore tree, int valor) {
        tree.info = valor;
        tree.direita = null;
        tree.esquerda = null;

        return tree;
    }

    NoArvore Insere(NoArvore tree, int valor) {
        if (tree == null) {
            tree = new NoArvore();
            tree.info = valor;
            tree.direita = null;
            tree.esquerda = null;
        } else if (valor < tree.info) {
            tree.esquerda = Insere(tree.esquerda, valor);
        } else {
            tree.direita = Insere(tree.direita, valor);
        }
        return tree;
    }

    NoArvore Retira(NoArvore tree, int valor) {
        if (tree == null) {
            System.out.println("Elemento não encontrado " + valor);
            return null;
        } else if (tree.info > valor) {
            tree.esquerda = Retira(tree.esquerda, valor);
        } else if (tree.info < valor) {
            tree.direita = Retira(tree.direita, valor);
        } else {
            if (tree.esquerda == null && tree.direita == null) {
                tree = null;
            } else if (tree.esquerda == null) {
                NoArvore novo = tree;
                tree = tree.direita;
            } else if (tree.direita == null) {
                NoArvore novo = tree;
                tree = tree.esquerda;
            } else {
                NoArvore novo = tree.esquerda;
                while (novo.direita != null) {
                    novo = novo.direita;
                }
                tree.info = novo.info;
                novo.info = valor;
            }
        }
        return tree;
    }

    void Imp_Decres(NoArvore tree) {
        if (tree != null) {
            Imp_Decres(tree.esquerda);
            Imp_Decres(tree.direita);
            System.out.println(tree.info);
        }
    }

    void ImpNivel(NoArvore tree) {
        if (tree == null) {
            return;
        }

        Queue<NoArvore> queue = new LinkedList<>();
        queue.add(tree);

        while (!queue.isEmpty()) {
            NoArvore node = queue.poll();
            System.out.println(node.info);

            if (node.esquerda != null) {
                queue.add(node.esquerda);
            }
            if (node.direita != null) {
                queue.add(node.direita);
            }
        }
    }
}
