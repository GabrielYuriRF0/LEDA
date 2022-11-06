import orderStatistic.QuickSelect;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class QuickSelectTest {
    private QuickSelect implementation;
    private Integer[] arrayTest1 = {25,38,15,96,4,30,84};
    private Integer[] arrayVazio = {};

    @Before
    public void init(){
        this.implementation = new QuickSelect<Integer>();
    }

    @Test
    public void testesBases(){
        Assert.assertEquals(4,this.implementation.quickSelect(this.arrayTest1,1));
        Assert.assertEquals(15,this.implementation.quickSelect(this.arrayTest1,2));
        Assert.assertEquals(25,this.implementation.quickSelect(this.arrayTest1,3));
        Assert.assertEquals(30,this.implementation.quickSelect(this.arrayTest1,4));
        Assert.assertEquals(96,this.implementation.quickSelect(this.arrayTest1,7));

    }

    @Test
    public void arrayVazio(){
        Assert.assertNull(this.implementation.quickSelect(this.arrayVazio,0));

    }

    @Test
    public void arrayNulo(){
        Assert.assertNull(this.implementation.quickSelect(null,5));
    }

    @Test
    public void kInvalido(){
        Assert.assertNull(this.implementation.quickSelect(this.arrayTest1,this.arrayTest1.length+1));
    }


}
