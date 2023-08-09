package net.iescierva.dam22_06.mislugaresjavar.modelo;

public class GeoPunto {

    private double latitud;
    private double longitud;

    static public GeoPunto SIN_POSICION = new GeoPunto(0.0,0.0);

    public GeoPunto(double latitud, double longitud) {
        this.latitud= latitud;
        this.longitud= longitud;
    }
    public GeoPunto(int latitud, int longitud){
        this.latitud = latitud/1000000;
        this.longitud = longitud/1000000;
    }

    public GeoPunto() {
        this(0,0);
    }

    public double distancia(GeoPunto punto) {
        final double RADIO_TIERRA = 6371000; // en metros
        double dLat = Math.toRadians(latitud - punto.latitud);
        double dLon = Math.toRadians(longitud - punto.longitud);
        double lat1 = Math.toRadians(punto.latitud);
        double lat2 = Math.toRadians(latitud);
        double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
                Math.sin(dLon/2) * Math.sin(dLon/2) *
                        Math.cos(lat1) * Math.cos(lat2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        return c * RADIO_TIERRA;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    @Override
    public String toString() {
        return "GeoPunto{" +
                "latitud=" + latitud +
                ", longitud=" + longitud +
                '}';


    }
}