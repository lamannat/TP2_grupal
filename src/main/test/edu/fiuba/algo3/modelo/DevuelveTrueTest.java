package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DevuelveTrueTest {
    @Test
    public void TesteoDevuelveTrue(){
        DevuelveTrue x = new DevuelveTrue();
        boolean y = x.devuelveTrue();
        assertEquals(y, true);
    }

}