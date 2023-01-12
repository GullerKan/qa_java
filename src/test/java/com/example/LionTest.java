package com.example;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.MockitoAnnotations;

import java.util.List;



@RunWith(Parameterized.class)
public class LionTest extends TestCase {
    private  String sex;
    private boolean hasMane;
    private int kittensCount;
    public LionTest(String sex, boolean hasMane, int kittensCount) throws Exception {
        this.sex = sex;
        this.hasMane = hasMane;
        this.kittensCount = kittensCount;
    }
    Feline feline = new Feline();
    Lion lion;
    @Parameterized.Parameters
    public  static Object [][] lionConfig () {
        return new Object[][] {
                {"Самец", true, 1},
                {"Самка",false, 1},
                {"", true, 1},
                {"Самка", true, 0},
        };
    }
    @Before
    public void init() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.lion = new Lion(sex, feline);
    }


    @Test
    public  void lionDoesHaveManeWithParameters() throws Exception {
        boolean isHasMane = hasMane;
        Assert.assertEquals("Только Самец или Самка",isHasMane,lion.doesHaveMane());

    }

    @Test
    public void lionGetKittensWithParameters() throws  Exception{
        int lionCount = kittensCount;
       Assert.assertEquals("Должно быть 1", lionCount, lion.getKittens());
    }
    @Test
    public  void lionGetFood () throws Exception {
        Assert.assertEquals("",List.of("Животные", "Птицы", "Рыба"), lion.getFood());
    }

}