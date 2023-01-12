package com.example;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FelineTest {
    Feline feline;
    @Before
    public void start(){
        this.feline = new Feline();
    }
    @Test
    public void predatorEatsContains() throws Exception {
       assertTrue(feline.eatMeat().contains("Рыба"));
    }

    @Test
    public void getFamily()  {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void getKittensWithoutParams()  {
        assertEquals(1, feline.getKittens());
    }

    @Test
    public void getKittensWithParamsReturnsValue()  {
        assertEquals(2, feline.getKittens(2));
    }

}