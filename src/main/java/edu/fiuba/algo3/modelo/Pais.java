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

    private int tirarDado(){
        int randomNum = ThreadLocalRandom.current().nextInt(1, 6 + 1);
        return randomNum;
    }

    private List<Integer> tirarDados(int cantidad){

        List<Integer> resultados = new ArrayList<>();

        for(int i = 0; i < cantidad; i++){
            int tmp = tirarDado();
            resultados.add(tmp);
        }
        Collections.sort(resultados, Collections.reverseOrder());
        return resultados;
    }

    public Pais(String nombre) {
        this.nombre = nombre;
        this.limitrofes = new ArrayList<>();
        this.ejercitos = 1;
    }

    public void agregarPaisLimitrofe(Pais pais){
        this.limitrofes.add(pais);

    }

    public void setColor(String color){
        this.color = color;
    }

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


    public void atacarPais(Pais pais){

        List<Integer> dadosAtaque, dadosDefensa;

        if (this.ejercitos <= 1) return;

        dadosAtaque = tirarDados(ejercitosParaAtaque());
        dadosDefensa = tirarDados(pais.ejercitosParaDefensa());

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
