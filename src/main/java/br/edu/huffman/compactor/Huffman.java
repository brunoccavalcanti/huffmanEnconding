package br.edu.huffman.compactor;

import br.edu.huffman.node.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Huffman {

    private static final Logger logger = LoggerFactory.getLogger(Huffman.class);

    // Método principal que encripta o texto
    public String encode(String text) {

        logger.info("Separando o texto [{}] em caracteres", text);
        char[] letters = getChars(text);
        logger.info("texto splitado {}", letters);

        logger.info("Contando a frequência das letras");
        PriorityQueue<Node> frequency = countFrequencies(letters);
        frequency.forEach(e -> {
            System.out.println(e.getSymbol() + " " + e.getFrequency());
        });

        return null;
    }

    //Método usado para separar a string num array de caracteres
    private char[] getChars(String text) {
        char[] letters = new char[text.length()];
        text.getChars(0, text.length(), letters, 0);
        return letters;
    }

    private PriorityQueue<Node> countFrequencies(char[] letters) {
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
