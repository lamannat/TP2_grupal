package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;


public class Batalla implements Observable {
    private final Dado dado;
    private final List<Observer> oberservadores;

    public Batalla(Dado unDado){
        this.dado = unDado;
        this.oberservadores = new ArrayList<>();
    }

    public void ejercitoAtacaAEjercito(EjercitoDeBatalla atacante, EjercitoDeBatalla defensor) {

        TiradaDeDados tiradaAtacante = this.dado.tirarDado(atacante.cantidadDeFichas());
        TiradaDeDados tiradaDefensor = this.dado.tirarDado(defensor.cantidadDeFichas());

        while (!tiradaAtacante.tiradaVacia() && !tiradaDefensor.tiradaVacia()) {
            if (tiradaAtacante.primerResultadoMayor(tiradaDefensor))
                defensor.pierdeFicha();
            else
                atacante.pierdeFicha();
        }
        this.notifyObservers();
    }

    @Override
    public void addObserver(Observer observer) {
        oberservadores.add(observer);
    }

    @Override
    public void notifyObservers() {
        oberservadores.forEach(Observer::change);
    }

    @Override
    public void removeObserver(Observer observer) {
        oberservadores.remove(observer);
    }
}
