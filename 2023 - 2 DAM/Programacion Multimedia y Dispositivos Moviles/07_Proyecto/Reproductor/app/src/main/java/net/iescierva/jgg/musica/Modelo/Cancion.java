package net.iescierva.jgg.musica.Modelo;

public class Cancion {
    private String titulo;
    private String disco;
    private String estilo;
    private String artista;
    private String path;

    public Cancion(String titulo, String disco, String estilo, String artista, String path){
        this.titulo = titulo;
        this.disco = disco;
        this.estilo = estilo;
        this.artista = artista;
        this.path = path;
    }

    public String getTitulo() {
        return titulo;
    }
    public String getDisco() {
        return disco;
    }
    public String getArtista() {
        return artista;
    }
    public String getPath() {
        return path;
    }

    public String getEstilo() {return estilo;}
}
