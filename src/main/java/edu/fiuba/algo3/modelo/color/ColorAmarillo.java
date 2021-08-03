package edu.fiuba.algo3.modelo.color;

public class ColorAmarillo extends Color{

    public ColorAmarillo()
    {
        this.codigo = "#d4ca1c"; /* #ee7733 */
        this.nombre = "Amarillo";
    }

    @Override
    public String getColorText(){
        return "#000000";
    }

}