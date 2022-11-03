import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import problems.FloorBinarySearchImpl;

public class FloorTeste {
    Integer [] arrayTest1 = {25,38,15,964,30,84};
    Integer[] arrayTest2 = {4,6,8,10};
    Integer[] arrayTest3 = {10,15,22,25,37,40,54};
    FloorBinarySearchImpl implementation;

    @Before
    public void init(){
       this.implementation = new FloorBinarySearchImpl();


    }

    @Test
    public void floorarrayTest1(){
       Assert.assertEquals(38, this.implementation.floor(this.arrayTest1,38));
    }

}
