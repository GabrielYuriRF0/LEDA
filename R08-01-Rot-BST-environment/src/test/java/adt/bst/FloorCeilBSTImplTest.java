package adt.bst;

import adt.bst.extended.FloorCeilBSTImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class FloorCeilBSTImplTest {
    FloorCeilBSTImpl tree;

    @Before
    public void setUp(){
        tree = new FloorCeilBSTImpl();
    }

    @Test
    public void testFloor(){
        Integer[] array = { 6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40};
        assertEquals((Integer)6,this.tree.floor( array, 6));
        Integer value = -40;
        assertEquals(value,this.tree.floor( array, -40));
        value = 0;
        assertEquals(value,this.tree.floor( array, 1));
        value = 2;
        assertEquals(value, this.tree.floor(array, 4));
        assertNull(tree.floor(array, -50));
        value = 232;
        assertEquals(value, tree.floor(array, 500));
    }

    @Test
    public void testCeil(){
        Integer[] array = { 6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40};
        assertEquals((Integer)6,this.tree.ceil( array, 6));

        Integer value = 23;
        assertEquals(value,this.tree.ceil( array, 23));

        value = 2;
        assertEquals(value,this.tree.ceil( array, 1));

        value = 0;
        assertEquals(value,this.tree.ceil( array, -10));

        value = 5;
        assertEquals(value, this.tree.ceil(array, 4));

        assertNull(tree.ceil(array, 500));

        value = -40;
        assertEquals(value, tree.ceil(array, -41));
    }
}