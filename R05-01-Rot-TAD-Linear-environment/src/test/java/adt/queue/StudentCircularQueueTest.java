package adt.queue;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudentCircularQueueTest {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    @Before
    public void init()throws QueueOverflowException{
        this.queue1 = new QueueUsingStack<>(5);
        this.queue2 = new QueueUsingStack<>(2);
        this.queue2.enqueue(new Integer(2));
        this.queue2.enqueue(new Integer(4));

    }
    private void fillQueue() throws QueueOverflowException{
        queue1.enqueue(1);
        queue1.enqueue(2);
        queue1.enqueue(3);
        queue1.enqueue(4);
        queue1.enqueue(5);

    }

    @Test
    public void isEmpty(){
        Assert.assertTrue(queue1.isEmpty());
        Assert.assertFalse(queue2.isEmpty());
    }

    @Test
    public void isFull(){
        Assert.assertFalse(queue1.isFull());
        Assert.assertTrue(queue2.isFull());
    }

    @Test
    public void headWithSucess1() throws QueueOverflowException{
        fillQueue();
        Assert.assertEquals(new Integer(1), queue1.head());
        Assert.assertEquals(new Integer(2),queue2.head());

    }
    @Test
    public void headWithSucess2() throws Exception{
        fillQueue();
        queue1.dequeue();
        queue2.dequeue();
        Assert.assertEquals(new Integer(2), queue1.head());
        Assert.assertEquals(new Integer(4), queue2.head());

    }

    @Test
    public void dequeueWithSucess1()  throws Exception{
        fillQueue();
        Assert.assertEquals(new Integer(1),queue1.dequeue());
        Assert.assertEquals(new Integer(2),queue1.dequeue());
        Assert.assertEquals(new Integer(3),queue1.dequeue());
        Assert.assertEquals(new Integer(4),queue1.dequeue());
        Assert.assertEquals(new Integer(5),queue1.dequeue());
        Assert.assertTrue(queue1.isEmpty());
        Assert.assertFalse(queue1.isFull());


    }
    @Test
    public void dequeueWithSucess2() throws Exception{
        Assert.assertEquals(new Integer(2),queue2.dequeue());
        Assert.assertEquals(new Integer(4),queue2.dequeue());
        Assert.assertTrue(queue2.isEmpty());
        Assert.assertFalse(queue2.isFull());
    }

    @Test
    public void dequeueWithError() throws QueueUnderflowException{
        queue2.dequeue();
    }

    @Test
    public void enqueueWithError() throws Exception{
        fillQueue();
        try{
           queue1.enqueue(new Integer(6));

        }
        catch (Exception e){
            Assert.assertEquals("Fila cheia", e.getMessage());
        }

    }

}
