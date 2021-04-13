import java.io.Serializable;
import java.util.Random;

/***********************************************************************
 Linked list class used to replace an array in the GUI Rental Store.

 @author Austin Ellsworth
 @version 04/13/2021
 **********************************************************************/
public class MySingleWithOutTailLinkedList implements Serializable {
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
    public void clear() {
        Random rand = new Random();
        while (size() > 0) {
            int number = rand.nextInt(size());
            remove(number);
        }
    }

    /*******************************************************************
     * Method that adds a rental unit to the linked list in specific
     * order. Games insert before consoles, and each rental type is
     * also sorted within that rental type by the rental due dates.
     * If a rental is to be inserted next to another rental of the
     * same type and date, the two objects are sorted by name.
     * @param rental the unit begin rented
     * @return none
     ******************************************************************/
    public void add(Rental rental) {
        Node temp = top;

        // if top is null, set top to rental
        if (top == null) {
            top = new Node(rental, null);
        }

        // rental is a Game, and rental might have to go on top
        else if (rental instanceof Game && (top.getData().dueBack
                .after(rental.dueBack) || top.getData().dueBack
                .equals(rental.dueBack))) {
            if (top.getData().getDueBack() != rental.getDueBack()) {
                top = new Node(rental, top);
            }
            else {
                if (top.getData().getNameOfRenter().compareTo(rental
                        .getNameOfRenter()) > 0) {
                    top = new Node(rental, temp);
                }
                else {
                    temp.setNext(new Node(rental, top.getNext()));
                }
            }
        }

        // rental not going on top
        else if (rental instanceof Game && !top.getData().dueBack.after(rental.dueBack)) {

            // iterate down linked list until getNext meets a condition
            while (temp.getNext() != null &&
                    !temp.getNext().getData().dueBack.after(rental.dueBack) &&
                    !temp.getNext().getData().dueBack.equals(rental.dueBack) &&
                    !(temp.getNext().getData() instanceof Console)) {
                temp = temp.getNext();
            }

            // if getnext null, set rental next
            if (temp.getNext() == null) {
                temp.setNext(new Node(rental, null));
            }

            // if getnext is console type, insert new game rental before
            else if (temp.getNext().getData() instanceof Console) {
                temp.setNext(new Node(rental, temp.getNext()));
            }

            // if getnext due date equals rentals due date, sort by name
            else if (temp.getNext().getData().dueBack.equals(rental.dueBack)) {
                if (temp.getNext().getData().getNameOfRenter()
                        .compareTo(rental.getNameOfRenter()) > 0) {
                    temp.setNext(new Node(rental, temp.getNext()));
                }
                else {
                    temp = temp.getNext();
                    temp.setNext(new Node(rental, temp.getNext()));
                }
            }

            // if getnext is due after rental, set next to rental
            else if (temp.getNext().getData().dueBack.after(rental.dueBack)) {
                temp.setNext(new Node(rental, temp.getNext()));
            }
        }

        // Rental is a console
        else if (rental instanceof Console) {
            while (temp.getNext() != null &&
                    temp.getNext().getData() instanceof Game) {
                temp = temp.getNext();
            }
            // if first rental after all games is null
            if (temp.getNext() == null) {
                temp.setNext(new Node(rental, null));
            }

            // continue until next is null or next due is after rental
            else {
                while (temp.getNext() != null &&
                        !temp.getNext().getData().dueBack.after(rental.dueBack) &&
                        !temp.getNext().getData().dueBack.equals(rental.dueBack)) {
                    temp = temp.getNext();
                }

                // if getnext is null
                if (temp.getNext() == null) {
                    temp.setNext(new Node(rental, null));
                }

                // if getnext has same due date as rental, sort by name
                else if (temp.getNext().getData().dueBack
                        .equals(rental.dueBack)) {
                    if (temp.getNext().getData().getNameOfRenter()
                            .compareTo(rental.getNameOfRenter()) > 0) {
                        temp.setNext(new Node(rental, temp.getNext()));
                    } else {
                        temp = temp.getNext();
                        temp.setNext(new Node(rental, temp.getNext()));
                    }
                }

                // if getnext is due after rental, set rental next
                else if (temp.getNext().getData().dueBack.after(rental.dueBack)) {
                    temp.setNext(new Node(rental, temp.getNext()));
                }
            }
        }
    }

    /*******************************************************************
     * Method that moves down linked list and uses an integer to count
     * the current position. When the current position matches the
     * index paramter, the rental unit is removed from the list and
     * returned.
     * @param index the position of the rental object to be removed
     * @return Rental the rental object that has been removed
     ******************************************************************/
    public Rental remove(int index) {
        Node currentNode = top;
        Rental temp = null;
        int currentInt = 0;

        // if top is already null
        if (top == null) {
            return null;
        }

        // make sure index is within range
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }

        // index is top
        if (index == 0) {
            temp = top.getData();
            top = currentNode.getNext();
            return temp;
        }

        // cant remember why i did this if statement, try removing later
        if (currentNode.getNext() == null) {
            top = null;
            return null;
        } else {
            while (currentInt < (index - 1)) {
                currentNode = currentNode.getNext();
                currentInt++;
            }

            // if node two positions lower (one position lower than
            // actual index) is null, get rid of index
            // position and set next to null
            if (currentNode.getNext().getNext() == null) {
                temp = currentNode.getNext().getData();
                currentNode.setNext(null);
                return temp;
            } else {
                temp = currentNode.getNext().getData();
                currentNode.setNext(currentNode.getNext().getNext());
                return temp;

            }
        }

    }

    /*******************************************************************
     * Method that moves down linked list and uses an integer to count
     * the current position. When the current position matches the
     * index parameter, the rental unit is returned.
     * @param index the unit begin rented
     * @return Rental the rental object at the specified index
     ******************************************************************/

    public Rental get(int index) {

        // make sure index is within range
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }

        // start count integer, increment until equal to index
        if (top == null)
            return null;
        else {
            int countNode = 0;
            Node currentNode = top;
            while (countNode != index) {
                currentNode = currentNode.getNext();
                countNode++;
            }
            return currentNode.getData();
        }
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

