import java.util.*;

public class Stack<Item>
{
    private Node first; //栈顶
    private int count; //元素数量

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return count;
    }

    public void push(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        count++;
    }

    public Item pop() {
        Item item = first.item;
        first = first.next;
        count--;
        return item;
    }

    //测试用例
    public static void main(String[] args) {
        Stack<String> s = new Stack<String>();
        Scanner input = new Scanner(System.in);
        System.out.println("Please input (Ctrl-D to exit):");
        do {
            String item = input.next();
            if (!item.equals("-"))
                s.push(item);
            else if (!s.isEmpty())
               System.out.print(s.pop() + " ");
        } while (input.hasNext());
        System.out.println("\n" + "(" + s.size() + " left on stack): ");
        while (s.count>0) System.out.print(s.count + ":" + s.pop() + " ");
    }
}