package br.edu.huffman;

import br.edu.huffman.compactor.Huffman;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class HuffmanMain {

    private static final Logger logger = LoggerFactory.getLogger(HuffmanMain.class);

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Insira o texto a ser compactado: ");
        String text = in.nextLine().trim();

        logger.info("Preparando para compactar [{}] ", text);

        Huffman huff = new Huffman();

        logger.info("Compactando...");
        String data = huff.encode(text);

    }

}
