package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DevuelveTrueTest {
    @Test
    public void TesteoDevuelveTrue(){
        DevuelveTrue x = new DevuelveTrue();
        boolean y = x.devuelveTrue();
        assertEquals(y, true);
    }

    @Test
    public void lanzarExcepcion() {

        LinkedList mockedList = mock(LinkedList.class);

        when(mockedList.get(1)).thenThrow(new RuntimeException());

        assertThrows(RuntimeException.class, () -> {
            mockedList.get(1);
        });
    }

}