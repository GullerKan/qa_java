package com.example;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CatTest extends TestCase {
    @Mock
    Feline feline;
    @Mock
    Cat cat;

    @Test
    public void сatGetSound()  {
        Cat cat = new Cat(feline);
        String catSound = cat.getSound();
        Assert.assertEquals("Ожидается <Мяу>","Мяу", catSound);
    }
    // Проверка getSound класса Cat со стабом
    @Test
    public  void сatGetSoundWithMock() {
        Mockito.when(cat.getSound()).thenReturn("Мур");
        Assert.assertEquals("Ожидается <Мяу>","Мяу", cat.getSound());
    }

    @Test
    public  void catGetFood () throws Exception {
        Feline feline = new Feline();
        Cat cat = new Cat(feline);
        List<String> expectedCatFood = List.of("Животные", "Птицы", "Рыба");
        Assert.assertEquals("Котики кушают мяско",expectedCatFood, cat.getFood());
    }
    // Проверка getFood класса Cat со стабом
    @Test
    public  void catGetFoodMock() throws Exception {
        Cat cat = new Cat(feline);
        Mockito.when(feline.eatMeat()).thenReturn(
                List.of("Животные", "Птицы", "Рыба"));
        List<String> expectedCatFood = List.of("Животные", "Птицы", "Рыба");
        Assert.assertEquals("Котики кушают мяско",expectedCatFood, cat.getFood());
    }

}