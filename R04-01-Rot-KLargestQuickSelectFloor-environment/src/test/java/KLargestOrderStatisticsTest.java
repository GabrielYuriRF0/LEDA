import orderStatistic.KLargest;
import orderStatistic.KLargestOrderStatisticsImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class KLargestOrderStatisticsTest {
    private Integer[] arrayTest1 = {25,38,15,96,4,30,84};
    private Integer[] arrayVazio = {};
    private KLargest<Integer> implementation;

    @Before
    public void init(){
        this.implementation = new KLargestOrderStatisticsImpl<Integer>();
    }

    @Test
    public void testesBases(){
        Integer[] result1 = {96};
        Integer[] result2 = {84,96};
        Integer[] result3 = {38,84,96};
        Integer[] result4 = {30,38,84,96};
        Integer[] result5 = {4,15,25,30,38,84,96};

        Assert.assertArrayEquals(result1,this.implementation.getKLargest(this.arrayTest1,1));
        Assert.assertArrayEquals(result2,this.implementation.getKLargest(this.arrayTest1,2));
        Assert.assertArrayEquals(result3,this.implementation.getKLargest(this.arrayTest1,3));
        Assert.assertArrayEquals(result4,this.implementation.getKLargest(this.arrayTest1,4));
        Assert.assertArrayEquals(result5,this.implementation.getKLargest(this.arrayTest1,this.arrayTest1.length));

    }

    @Test
    public void kInvalido(){
        Assert.assertArrayEquals(this.arrayVazio,this.implementation.getKLargest(this.arrayTest1,this.arrayTest1.length+1));
        Assert.assertArrayEquals(this.arrayVazio,this.implementation.getKLargest(this.arrayTest1,0));
        Assert.assertArrayEquals(this.arrayVazio,this.implementation.getKLargest(this.arrayTest1,-1));
    }

    @Test
    public void arrayNulo(){
        Assert.assertArrayEquals(this.arrayVazio,this.implementation.getKLargest(null,this.arrayTest1.length));
    }

    @Test
    public void arrayVazio(){
        Integer[] arrayVazioLocal = {};
        Assert.assertArrayEquals(arrayVazioLocal,this.implementation.getKLargest(this.arrayVazio,this.arrayVazio.length));
    }

}
