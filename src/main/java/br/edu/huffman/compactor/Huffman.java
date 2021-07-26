package br.edu.huffman.compactor;

import br.edu.huffman.node.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Huffman {

    private static final Logger logger = LoggerFactory.getLogger(Huffman.class);

    private Node root;

    // Método principal que encripta o texto
    public String encode(String text) {

        logger.info("Separando o texto [{}] em caracteres", text);
        char[] letters = getChars(text);
        logger.info("texto splitado {}", letters);

        root = createTree(countFrequencies(letters));



        return null;
    }

    private Node createTree(PriorityQueue<Node> nodes) {
        logger.info("Criando árvore binária");
        while(true) {
            // 1. Pega os dois menores nós e retira da lista
            Node node1 = nodes.poll();
            Node node2 = nodes.poll();

            // 2. Agrupa os dois
            Node parent = new Node(node1, node2);

            // 3. Se a query estivar vazia, este nó é a raíz
            if(nodes.isEmpty()){
                logger.info("A query está vazia, este nó é a raiz");
                return parent;
            }

            // 4. Se não, insere de volta o grupo na árvore
            nodes.add(parent);
        }
    }

    //Método usado para separar a string num array de caracteres
    private char[] getChars(String text) {
        char[] letters = new char[text.length()];
        text.getChars(0, text.length(), letters, 0);
        return letters;
    }

    //Método usado pra para contar as frequências de cada caracter, usando a classe priorityQueue para ordenar a lista
    private PriorityQueue<Node> countFrequencies(char[] letters) {
        logger.info("Contando a frequência das letras");
        Map<Character, Node> count = new HashMap<>();
        for (char ch : letters) {
            if (!count.containsKey(ch)) {
                count.put(ch, new Node(ch));
            }
            count.get(ch).add();
        }
        return new PriorityQueue<>(count.values());
    }

}
