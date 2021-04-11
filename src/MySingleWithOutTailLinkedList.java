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
            //TODO rethink logic of when to stop after instance of game
            while (temp.getNext() != null && temp.getNext().getData() instanceof Game) {
                temp = temp.getNext();
            }
            //if first rental after all games is null
            // temp.setNext(new Node(rental, null)

            if (temp.getNext() == null) {
                temp.setNext(new Node(rental, null));
            }

            else if ( temp.getNext() != null && temp.getNext().getData().getDueBack() == rental.getDueBack()) {
                if (temp.getNext().getData().getNameOfRenter().compareTo(rental.getNameOfRenter()) > 0) {
                    ///
                    temp.setNext(new Node(rental, temp.getNext()));
                }
                else {
                    temp = temp.getNext();
                    temp.setNext(new Node(rental, temp.getNext()));
                }
            }

            //otherwise, continue until next is null or next dueback
            // is after rental
            else {
                while (temp.getNext() != null && !temp.getNext().getData().dueBack.after(rental.dueBack)) {
                    temp = temp.getNext();
                }
                        Node oldNext = temp.getNext();
                temp.setNext(new Node(rental, oldNext));
                }

            }
        }
            //while temp.getNext is instanceof Game
            //temp = temp.getNext()




            //else loop through remaining list until dueback after or
        // next is null



    public Rental remove(int index) {
    	//  More code goes here.
        Node currentNode = top;
        //start by working one position behind the input param index
        int currentInt = 0;
        //if top is already null
        if (currentNode == null) {
            return null;
        }

        //make sure index is within range
        if (index<0 || index >=size()) {
            throw new IndexOutOfBoundsException();
        }

        //case 1 - index is top
        if (index == 0) {
            top = currentNode.getNext();
        }

        if (currentNode.getNext() == null) {
            top = null;
            return null;
        }
        else {
            while (currentInt < (index - 1)) {
                currentNode = currentNode.getNext();
                currentInt++;
            }
            //if node two positions lower (one position lower than
            // actual index) is null, get rid of index
            // position and set next to null
            if (currentNode.getNext().getNext() == null) {
                currentNode.setNext(null);
            } else {
                Node skipToNode = currentNode.getNext().getNext();
                currentNode.setNext(skipToNode);
            }
        }
        return null;

    }

    public Rental get(int index) {

        //make sure index is within range
        if (index<0 || index >=size()) {
            throw new IndexOutOfBoundsException();
        }

        if (top == null)
            return null;
        
        //  More code goes here.
        else {
            //start count integer
            //current node, increment until equal to index
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

