package net.iescierva.jgg.musica.Data;

import android.media.MediaMetadataRetriever;
import android.os.Environment;
import net.iescierva.jgg.musica.Modelo.Cancion;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ListaCanciones implements RepositorioCanciones{
    protected List<Cancion> listaCanciones;

    public ListaCanciones() {
        listaCanciones = new ArrayList<>();
        File[] dir = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/Music").listFiles();
        assert dir != null;
        addEjemplos(dir);
    }

    //////SECCION INTERFAZ//////
    public int size() {
        return listaCanciones.size();
    }
    public void update(int id, Cancion cancion) {
        listaCanciones.set(id, cancion);
    }
    public Cancion get(int id) {return listaCanciones.get(id);}

    @Override
    public void ordenarLista(Boolean random) {
        if (random){
            Collections.shuffle(listaCanciones);
        } else {
            listaCanciones.sort((o1, o2) -> {
                int artistCompare = o1.getArtista().compareTo(o2.getArtista());
                if (artistCompare == 0) {
                    return o1.getTitulo().compareTo(o2.getTitulo());
                }
                return artistCompare;
            });
        }
    }


    //////SECCION METODOS DE CLASE//////
    private void addEjemplos(File[] dir) {
        for(File file : dir) {
            if (!file.getName().equals(".thumbnails")) {
                if (file.isDirectory()) {
                    addEjemplos(Objects.requireNonNull(file.listFiles()));
                } else {
                    try {
                        MediaMetadataRetriever mmr = new MediaMetadataRetriever();
                        mmr.setDataSource(file.getPath());
                        String titulo = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE);
                        if (titulo == null){ titulo = file.getName(); }
                        String artista = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ARTIST);
                        if (artista == null){ artista = "N/A"; }
                        String album = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ALBUM);
                        if (album == null){ album = "N/A"; }
                        String estilo = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_GENRE);
                        if (estilo == null){ estilo = "N/A"; }
                        listaCanciones.add(new Cancion(titulo, album, estilo,artista, file.getAbsolutePath()));
                        mmr.release();
                        mmr.close();
                    } catch (Exception ignored) {

                    }
                }
            }
        }
        listaCanciones.sort((o1, o2) -> {
            int artistCompare = o1.getArtista().compareTo(o2.getArtista());
            if (artistCompare == 0) {
                return o1.getTitulo().compareTo(o2.getTitulo());
            }
            return artistCompare;
        });
    }
}
