import java.util.*;

public class Queue<Item>
{
    private Node first;
    private Node last;
    private int count;

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() { return first == null; }

    public int size() { return count; }

    public void enquene(Item item) {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else oldlast.next = last;
        count++;
    }

    public Item dequeue() {
        Item item = first.item;
        first = first.next;
        if (isEmpty()) last = null;
        count--;
        return item;
    }

    public static void main(String[] args) {
        Queue<String> q = new Queue<String>();
        Scanner input = new Scanner(System.in);
        System.out.println("Please input (Ctrl-D to exit):");
        do {
            String item = input.next();
            if (!item.equals("-"))
                q.enquene(item);
            else if (!q.isEmpty())
               System.out.print(q.dequeue() + " ");
        } while (input.hasNext());
        System.out.println("\n" + "(" + q.size() + " left on Queue): ");
        while (q.count>0) System.out.print(q.count + ":" + q.dequeue() + " ");
    }
}