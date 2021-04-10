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

        // else if rental instance of game and is due after top
        else if (rental instanceof Game && !top.getData().dueBack.after(rental.dueBack)) {
            // while temp.getnext isn't null and not after rental
            while (temp.getNext() != null && !temp.getNext().getData().dueBack.after(rental.dueBack)) {
                temp = temp.getNext();
            }
            // if next null
            if (temp.getNext() == null) {
                temp.setNext(new Node(rental, null));
            }

            //if next not null
            else {
                Node oldNext = temp.getNext();
                temp.setNext(new Node(rental, oldNext));
            }
        }



        // Rental is a console
        else if (rental instanceof Console) {
            while (temp.getNext().getData() instanceof Game || !temp.getData().dueBack.after(rental.dueBack)) {
                temp = temp.getNext();
            }
            //if next null
            // temp.setNext(new Node(rental, null)
            if (temp.getNext() == null) {
                temp.setNext(new Node(rental, null));
            }
            //if next not null
            else {
                Node oldNext = temp.getNext();
                temp.setNext(new Node(rental, oldNext));
            }
        }
            //while temp.getNext is instanceof Game
            //temp = temp.getNext()




            //else loop through remaining list until dueback after or
        // next is null

    }

    public Rental remove(int index) {
    	//  More code goes here.
        Node currentNode = top;
        int currentInt = -1;
        if (currentNode.getNext() == null) {
            top = null;
        }
        else {
            while (currentInt != (index - 1)) {
                currentNode = currentNode.getNext();
                index++;
            }
            if (currentNode.getNext().getNext() == null) {
                currentNode.getNext().setNext(null);
            } else {
                Node skipToNode = currentNode.getNext().getNext();
                currentNode.setNext(skipToNode);
            }
        }
        return null;

    }

    public Rental get(int index) {

        if (top == null)
            return null;
        
        //  More code goes here.
        else {
            //start count integer
            //current node, increment until equal to index
            // TODO: make sure index is within size bounds
            int countNode = 0;
            Node currentNode = top;
            while (countNode != index) {
                currentNode = currentNode.getNext();
                countNode++;
            }
            return currentNode.getData();
        }


        // This is a placeholder to return something so that the
        // code will compile; this should be changed

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

