import java.io.Serializable;
import java.util.Random;

public class MySingleWithOutTailLinkedList implements Serializable
{
    private Node top;

    public MySingleWithOutTailLinkedList() {
        top = null;
    }

    // This method has been provided and you are not permitted to modify
    public int size() {
        if (top == null)
            return 0;

        int total = 0;
        Node temp = top;
        while (temp != null) {
            total++;
            temp = temp.getNext();
        }
        
        return total;
    }

    // This method has been provided and you are not permitted to modify
    public void clear () {
        Random rand = new Random();
        while (size() > 0) {
            int number = rand.nextInt(size());
            remove(number);
        }
    }

    /********************************************************************************************
     *
     *    Your task is to complete this method.
     *
     *
     *
     * @param rental the unit begin rented
     */
    public void add(Rental rental) {
        Node temp = top;

        // No list
        if (top == null) {
            top = new Node(rental, null);
        }

        // Rental is a Game, and Rental goes on top
        else if (rental instanceof Game && top.getData().dueBack.after(rental.dueBack)) {
            top = new Node(rental, top);
        }

        //  More code goes here.

    }

    public Rental remove(int index) {
    	//  More code goes here.

        return null;
    }

    public Rental get(int index) {

        if (top == null)
            return null;
        
        //  More code goes here.

        // This is a placeholder to return something so that the
        // code will compile; this should be changed
        return top.getData();
    }

    public void display() {
        Node temp = top;
        while (temp != null) {
            System.out.println(temp.getData());
            temp = temp.getNext();
        }
    }

    @Override
    public String toString() {
        return "LL {" +
                "top=" + top +
                ", size=" + size() +
                '}';
    }
}

