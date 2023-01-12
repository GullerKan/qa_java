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
public class LionTestMock extends TestCase {

    @Mock
    Feline feline;
    @Mock
    Lion lion;

    @Test
    public  void lionGetKittens() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(lion.getKittens()).thenReturn(1);
        int expectedKittens = 1;
        Assert.assertEquals("Должно быть 1",expectedKittens, lion.getKittens());
    }

    @Test
    public  void lionGetFood () throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(lion.getFood()).thenReturn(
                List.of("Травоядный"));
        List<String> expectedAnimalKind = List.of("Хищник");
        Assert.assertNotEquals("Виды животных совпадают в ОР и ФР",expectedAnimalKind, lion.getFood());
    }

    @Test
    public  void lionClassException() {
        try {
            new Lion("", feline);
        } catch (Exception exception) {
            Assert.assertEquals("Некорректный Exception","Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
        }
    }

}