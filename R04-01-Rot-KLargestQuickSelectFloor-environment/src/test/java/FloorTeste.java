import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import problems.FloorBinarySearchImpl;

public class FloorTeste {
    Integer [] arrayTest1 = {25,38,15,96,4,30,84};
    Integer[] arrayTest2 = {4,6,8,10};
    Integer[] arrayTest3 = {54,22,15,20,87,100,3,7};
    FloorBinarySearchImpl implementation;

    @Before
    public void init(){
       this.implementation = new FloorBinarySearchImpl();
    }

    @Test
    public void floorarrayTest1(){
        Integer n1 = 38;
        Integer n2 = 15;
        Integer n3 = 96;
        Integer n4 = 25;

       Assert.assertEquals(n1, this.implementation.floor(this.arrayTest1,38));
       Assert.assertEquals(n2,this.implementation.floor(this.arrayTest1,17));
       Assert.assertEquals(n3,this.implementation.floor(this.arrayTest1,200));
       Assert.assertEquals(n4,this.implementation.floor(this.arrayTest1,27));
       Assert.assertNull(this.implementation.floor(this.arrayTest1,2));
    }

    @Test
    public void floorArrayTest2(){
        Integer n1 = 6;
        Integer n2 = 8;
        Integer n3 = 10;
        Integer n4 = 4;

        Assert.assertEquals(n1,this.implementation.floor(this.arrayTest2,7));
        Assert.assertEquals(n2,this.implementation.floor(this.arrayTest2,8));
        Assert.assertEquals(n3,this.implementation.floor(this.arrayTest2,11));
        Assert.assertEquals(n4,this.implementation.floor(this.arrayTest2,5));
        Assert.assertNull(this.implementation.floor(this.arrayTest2,2));

    }

    @Test
    public void floorArrayTest3(){
        Integer n1 = 22;
        Integer n2 = 15;
        Integer n3 = 100;
        Integer n4 = 54;

        Assert.assertEquals(n1,this.implementation.floor(this.arrayTest3,34));
        Assert.assertEquals(n2,this.implementation.floor(this.arrayTest3,15));
        Assert.assertEquals(n3,this.implementation.floor(this.arrayTest3,101));
        Assert.assertEquals(n4,this.implementation.floor(this.arrayTest3,57));
        Assert.assertNull(this.implementation.floor(this.arrayTest3,2));


    }

}
