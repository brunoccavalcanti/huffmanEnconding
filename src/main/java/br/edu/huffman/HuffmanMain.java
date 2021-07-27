package br.edu.huffman;

import br.edu.huffman.compactor.Huffman;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DecimalFormat;
import java.util.Scanner;

public class HuffmanMain {

    private static final Logger logger = LoggerFactory.getLogger(HuffmanMain.class);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DecimalFormat formatador = new DecimalFormat("00.0");

        System.out.println("Insira o texto a ser compactado: ");
        String text = sc.nextLine().trim();

        logger.info("Preparando para compactar [{}] ", text);

        Huffman huff = new Huffman();

        logger.info("Compactando...");
        String data = huff.encode(text);

        int normalSize = text.length() * 8;
        int compressedSize = data.length();
        double rate = 100.0 - (compressedSize * 100.0 / normalSize);

        System.out.println("String compactada: " + data);
        System.out.println("Tamanho padrão da string: " + normalSize + " bits");
        System.out.println("Tamanho compactado: " + compressedSize + " bits");
        System.out.println("O tamanho compactado é " + formatador.format(rate) + "% menor que o original");

    }
}
