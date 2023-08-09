package net.iescierva.dam22_06.mislugaresjavar.modelo;

public class GeoPuntoAlt extends GeoPunto{
    private double altura;

    public GeoPuntoAlt(){}
    public GeoPuntoAlt(double altura){
        if (altura <= -20000 || altura >= 10000){
            throw new RuntimeException("La altura debe estar entre -20000 y 10000");
        } else {
            this.altura = altura;
        }

    }

}
