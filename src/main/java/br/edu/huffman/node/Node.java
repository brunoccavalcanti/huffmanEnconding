package br.edu.huffman.node;

//Classe usada para representar um nó na árvore
public class Node implements Comparable<Node>{

    private char symbol;
    private int count;

    private Node left;
    private Node right;

    public Node(char symbol) {
        this.symbol = symbol;
    }

    public Node(Node left, Node right) {
        this.symbol = '+';
        this.left = left;
        this.right = right;
    }

    public int getFrequency() {
        return count;
    }

    public void add() {
        count++;
    }

    public char getSymbol() {
        return symbol;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    @Override
    public int compareTo(Node o) {
        return getFrequency() - o.getFrequency();
    }
}
