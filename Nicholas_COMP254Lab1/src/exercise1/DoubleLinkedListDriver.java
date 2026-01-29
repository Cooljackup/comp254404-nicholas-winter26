// COMP254-404 - Lab 1 - Nicholas Bonneville
// Lab 1 - Exercise 1

package exercise1;

public class DoubleLinkedListDriver {
    public static void main(String[] args) {

        // Instance variables.
        DoublyLinkedList<String> L = new DoublyLinkedList<>();
        DoublyLinkedList<String> M = new DoublyLinkedList<>();

        // Adds to both lists.
        L.addLast("A");
        L.addLast("B");
        M.addLast("C");
        M.addLast("D");

        // Prints lists before concatenation.
        System.out.println("Before:");
        System.out.println("L: " + L);
        System.out.println("M: " + M);

        // Prints lists after concatenation.
        L.concatenate(M);
        System.out.println("\nAfter:");
        System.out.println("L: " + L);
        System.out.println("M: " + M);
    }
}