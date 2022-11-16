package adt.queue;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class QueueUsingStackTest {
    private Queue<Integer> queue;

    @Before
    public void init() {
        queue = new QueueUsingStack(5);

    }

    @Test
    public void isEmpty(){
        Assert.assertTrue(queue.isEmpty());
    }

    @Test
    public void isFull(){
        Assert.assertFalse(queue.isFull());
    }

    @Test
    public void enqueueWithSucess() throws Exception{
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        Assert.assertEquals(new Integer(1), queue.dequeue());

    }


}
