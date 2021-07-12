package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Pais {

    private final String nombre;
    private List<Pais> limitrofes;
    private String color;
    public int ejercitos;

    public Pais(String nombre) {
        this.nombre = nombre;
        this.limitrofes = new ArrayList<>();
        this.ejercitos = 1;
    }

    public void agregarPaisLimitrofe(Pais pais){
        //Delegar responsabilidad a clase Limitrofes
        this.limitrofes.add(pais);

    }
    //color corresponde a clase Ejercito
    public void setColor(String color){
        this.color = color;
    }

    //ejercitos corresponde a clase Ejercito
    public void agregarEjercitos(int cantidad){
        this.ejercitos += cantidad;
    }

    public int ejercitosParaAtaque(){
        int ejercitos;
        if(this.ejercitos >= 4){
            ejercitos = 3;
        }
        else{
            ejercitos = this.ejercitos-1;
        }

        return ejercitos;
    }

    public int ejercitosParaDefensa(){
        int ejercitos;
        if(this.ejercitos >= 3){
            ejercitos = 3;
        }
        else{
            ejercitos = this.ejercitos;
        }

        return ejercitos;
    }

    public void pierdeEjercito(){
        this.ejercitos -= 1;
    }

    //Atacar pais corresponde a la clase Batalla
    public void atacarPais(Pais pais, Dado dado){

        List<Integer> dadosAtaque, dadosDefensa;

        if (this.ejercitos <= 1) return;

        dadosAtaque = dado.tirarDados(ejercitosParaAtaque());
        dadosDefensa = dado.tirarDados(pais.ejercitosParaDefensa());

        for (int i = 0; i < dadosAtaque.size() && i < dadosDefensa.size(); i++){

            if(dadosAtaque.get(i) > dadosDefensa.get(i)){
                pais.pierdeEjercito();
            }
            else{
                pierdeEjercito();
            }
        }

        if(pais.ejercitos == 0){
            pais.setColor(this.color);
            pais.agregarEjercitos(1);
            pierdeEjercito();
        }

    }
}
