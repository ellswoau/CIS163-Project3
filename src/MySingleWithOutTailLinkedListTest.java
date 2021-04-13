import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import static org.junit.jupiter.api.Assertions.*;


public class MySingleWithOutTailLinkedListTest {



    @Test
    //This test primarily tests the sort by name case when the date
    // and rental type are identical for multiple rentals. This test
    // method has three game rentals with the same date and two
    // consoles with the same date
    public void testDateEqualsSort() {
        ListModel testList = new ListModel();

        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        GregorianCalendar g1 = new GregorianCalendar();
        GregorianCalendar g2 = new GregorianCalendar();
        GregorianCalendar g3 = new GregorianCalendar();
        GregorianCalendar g4 = new GregorianCalendar();
        GregorianCalendar g5 = new GregorianCalendar();

        try {
            Date d1 = df.parse("03/15/2021");
            g1.setTime(d1);
            Date d2 = df.parse("03/16/2021");
            g2.setTime(d2);
            Date d3 = df.parse("03/17/2021");
            g3.setTime(d3);
            Date d4 = df.parse("03/21/2021");
            g4.setTime(d4);
            Date d5 = df.parse("03/28/2021");
            g5.setTime(d5);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        Game game1001 = new Game("Austin", g1, g2, null, "Call Of Duty",
                null);
        Game game1002 = new Game("Kit", g1, g3, null, "Fortnite",
                null);
        Game game1003 = new Game("Jake", g1, g3, null, "WoW",
                null);
        Game game1004 = new Game("Mark", g1, g3, null, "Pinball",
                null);
        Console console1001 = new Console("Zach", g1, g5,
                null, ConsoleTypes.PlayStation4);
        Console console1002 = new Console("Aazad", g1, g5,
                null, ConsoleTypes.NintendoSwitch);

        testList.add(game1001);
        testList.add(game1002);
        testList.add(game1004);
        testList.add(game1003);
        testList.add(console1001);
        testList.add(console1002);



        testList.setDisplay(ScreenDisplay.CurrentRentals);

        assertEquals("Austin", testList.getValueAt(0,0));
        assertEquals("Jake", testList.getValueAt(1,0));
        assertEquals("Kit", testList.getValueAt(2,0));
        assertEquals("Mark", testList.getValueAt(3,0));
        assertEquals("Aazad", testList.getValueAt(4,0));
        assertEquals("Zach", testList.getValueAt(5,0));
    }

    @Test
    // among the other various parts of the code that works, this
    // method makes sure that rentals are properly handled when
    // console rentals are added to the list first. Test adds four
    // consoles and four games. Multiple rentals have the same return
    // date and are also sorted by name.
    public void testAddingConsolesFirst() {
        ListModel testList = new ListModel();

        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        GregorianCalendar g1 = new GregorianCalendar();
        GregorianCalendar g2 = new GregorianCalendar();
        GregorianCalendar g3 = new GregorianCalendar();
        GregorianCalendar g4 = new GregorianCalendar();
        GregorianCalendar g5 = new GregorianCalendar();

        try {
            Date d1 = df.parse("03/15/2021");
            g1.setTime(d1);
            Date d2 = df.parse("03/16/2021");
            g2.setTime(d2);
            Date d3 = df.parse("03/17/2021");
            g3.setTime(d3);
            Date d4 = df.parse("03/21/2021");
            g4.setTime(d4);
            Date d5 = df.parse("03/28/2021");
            g5.setTime(d5);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        Game game1001 = new Game("Austin", g1, g2, null, "Call Of Duty",
                null);
        Game game1002 = new Game("Bobby", g1, g2, null, "Fortnite",
                null);
        Game game1003 = new Game("Catherine", g1, g4, null, "WoW",
                null);
        Game game1004 = new Game("Devon", g1, g4, null, "Pinball",
                null);
        Console console1001 = new Console("Evan", g1, g3,
                null, ConsoleTypes.PlayStation4);
        Console console1002 = new Console("Fred", g1, g3,
                null, ConsoleTypes.NintendoSwitch);
        Console console1003 = new Console("Greg", g1, g1,
                null, ConsoleTypes.NintendoSwitch);
        Console console1004 = new Console("Harry", g1, g5,
                null, ConsoleTypes.NintendoSwitch);

        testList.add(console1001);
        testList.add(console1002);
        testList.add(console1003);
        testList.add(console1004);
        testList.add(game1001);
        testList.add(game1002);
        testList.add(game1004);
        testList.add(game1003);

        testList.setDisplay(ScreenDisplay.CurrentRentals);

        //"Austin" comes before "Aazad" because games are listed first in screen
        assertEquals("Austin", testList.getValueAt(0,0));
        assertEquals("Bobby", testList.getValueAt(1,0));
        assertEquals("Catherine", testList.getValueAt(2,0));
        assertEquals("Devon", testList.getValueAt(3,0));
        assertEquals("Greg", testList.getValueAt(4,0));
        assertEquals("Evan", testList.getValueAt(5,0));
        assertEquals("Fred", testList.getValueAt(6,0));
        assertEquals("Harry", testList.getValueAt(7,0));
    }

    @Test
    //This test simply adds 8 games, then removes one from the top,
    // one from the middle, and one from the bottom, then checks the
    // positions
    public void testRemoveMethod() {
        ListModel testList = new ListModel();

        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        GregorianCalendar g1 = new GregorianCalendar();
        GregorianCalendar g2 = new GregorianCalendar();
        GregorianCalendar g3 = new GregorianCalendar();
        GregorianCalendar g4 = new GregorianCalendar();
        GregorianCalendar g5 = new GregorianCalendar();

        try {
            Date d1 = df.parse("03/15/2021");
            g1.setTime(d1);
            Date d2 = df.parse("03/16/2021");
            g2.setTime(d2);
            Date d3 = df.parse("03/17/2021");
            g3.setTime(d3);
            Date d4 = df.parse("03/21/2021");
            g4.setTime(d4);
            Date d5 = df.parse("03/28/2021");
            g5.setTime(d5);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        Game game1001 = new Game("Isaac", g1, g2, null, "Call Of Duty",
                null);
        Game game1002 = new Game("Jacob", g1, g3, null, "Fortnite",
                null);
        Game game1003 = new Game("Karen", g1, g3, null, "WoW",
                null);
        Game game1004 = new Game("Larry", g1, g2, null, "Pinball",
                null);
        Console console1001 = new Console("Mark", g1, g5,
                null, ConsoleTypes.PlayStation4);
        Console console1002 = new Console("Nancy", g1, g5,
                null, ConsoleTypes.NintendoSwitch);
        Console console1003 = new Console("Opel", g1, g1,
                null, ConsoleTypes.NintendoSwitch);
        Console console1004 = new Console("Perry", g1, g5,
                null, ConsoleTypes.NintendoSwitch);

        testList.add(game1001);
        testList.add(game1002);
        testList.add(game1004);
        testList.add(game1003);
        testList.add(console1001);
        testList.add(console1002);
        testList.add(console1003);
        testList.add(console1004);
        testList.listOfRentals.remove(0);
        testList.listOfRentals.remove(3);
        testList.listOfRentals.remove(5);

        testList.setDisplay(ScreenDisplay.CurrentRentals);

        //"Austin" comes before "Aazad" because games are listed first in screen
        assertEquals("Larry", testList.getValueAt(0,0));
        assertEquals("Jacob", testList.getValueAt(1,0));
        assertEquals("Karen", testList.getValueAt(2,0));
        assertEquals("Mark", testList.getValueAt(3,0));
        assertEquals("Nancy", testList.getValueAt(4,0));
    }

    @Test
    //This just tests the get method
    public void testGetMethod() {
        ListModel testList = new ListModel();

        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        GregorianCalendar g1 = new GregorianCalendar();
        GregorianCalendar g2 = new GregorianCalendar();
        GregorianCalendar g3 = new GregorianCalendar();
        GregorianCalendar g4 = new GregorianCalendar();
        GregorianCalendar g5 = new GregorianCalendar();

        try {
            Date d1 = df.parse("03/15/2021");
            g1.setTime(d1);
            Date d2 = df.parse("03/16/2021");
            g2.setTime(d2);
            Date d3 = df.parse("03/17/2021");
            g3.setTime(d3);
            Date d4 = df.parse("03/21/2021");
            g4.setTime(d4);
            Date d5 = df.parse("03/28/2021");
            g5.setTime(d5);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        Game game1001 = new Game("give", g1, g3, null, "WoW",
                null);
        Game game1002 = new Game("Never", g1, g1, null, "Call Of Duty",
                null);
        Game game1003 = new Game("up", g1, g5, null, "Pinball",
                null);
        Game game1004 = new Game("gonna", g1, g2, null, "Fortnite",
                null);
        Game game1005 = new Game("you", g1, g4, null, "Pinball",
                null);
        Console console1001 = new Console("let", g1, g3,
                null, ConsoleTypes.NintendoSwitch);
        Console console1002 = new Console("you", g1, g4,
                null, ConsoleTypes.NintendoSwitch);
        Console console1003 = new Console("Never", g1, g1,
                null, ConsoleTypes.PlayStation4);
        Console console1004 = new Console("gonna", g1, g2,
                null, ConsoleTypes.NintendoSwitch);
        Console console1005 = new Console("down!", g1, g5,
                null, ConsoleTypes.NintendoSwitch);

        testList.add(game1001);
        testList.add(game1002);
        testList.add(game1003);
        testList.add(game1004);
        testList.add(game1005);
        testList.add(console1001);
        testList.add(console1002);
        testList.add(console1003);
        testList.add(console1004);
        testList.add(console1005);

        String allRentersNames = "";
        for (int i = 0; i < testList.listOfRentals.size(); i++) {
            allRentersNames += testList.listOfRentals.get(i).getNameOfRenter() + " ";
        }

        //You've been rick rolled
        assertEquals("Never gonna give you up Never gonna let you " +
                        "down! ",
                allRentersNames);

    }

}

