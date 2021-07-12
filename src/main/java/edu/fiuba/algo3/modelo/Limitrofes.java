package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class Limitrofes {

    private List<Pais> paisesLimitrofes;

    public Limitrofes() {
        paisesLimitrofes = new ArrayList<>();
    }

    public void agregarPaisLimitrofe(Pais pais) {
        paisesLimitrofes.add(pais);
    }

    public boolean esLimitrofe(Pais pais) {
        for (Pais limitrofe : this.paisesLimitrofes)
            if (limitrofe == pais)
                return true;
        return false;
    }

}
