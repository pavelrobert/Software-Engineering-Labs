package isp.lab3;
import isp.lab3.exercise1.Tree;
import org.junit.Test;

import static org.junit.Assert.*;


public class TreeTest {

    @Test
    public void testGrowth(){
        Tree tree = new Tree();
        tree.grow(-12);
        assertEquals(15, tree.height);
    }
    public void testToString(){
        Tree tree = new Tree();
        String expected = "The height is:15";
        String actual = tree.toString();
        assertEquals(expected, actual);
    }
}
