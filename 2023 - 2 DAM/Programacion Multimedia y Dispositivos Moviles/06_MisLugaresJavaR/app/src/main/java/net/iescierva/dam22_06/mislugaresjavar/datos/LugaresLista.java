package net.iescierva.dam22_06.mislugaresjavar.datos;

import net.iescierva.dam22_06.mislugaresjavar.modelo.Lugar;
import net.iescierva.dam22_06.mislugaresjavar.modelo.TipoLugar;

import java.util.ArrayList;
import java.util.List;

public class LugaresLista implements RepositorioLugares {
    protected List<Lugar> listaLugares;

    public LugaresLista() {
        listaLugares = new ArrayList<>();
        addEjemplos();
    }

    public Lugar get_element(int id) {
        return listaLugares.get(id);
    }

    public void add(Lugar lugar) {
        listaLugares.add(lugar);
    }

    public int add_blank() {
        Lugar lugar = new Lugar();
        listaLugares.add(lugar);
        return listaLugares.size()-1;
    }

    public void delete(int id) {
        listaLugares.remove(id);
    }

    public int size() {
        return listaLugares.size();
    }

    public void update_element(int id, Lugar lugar) {
        listaLugares.set(id, lugar);
    }

    public void addEjemplos() {
        add(new Lugar("Escuela Politécnica Superior de Gandía",
                "C/ Paranimf, 1 46730 Gandia (SPAIN)",
                38.995656,-0.166093, "",
                TipoLugar.EDUCACION, 962849300,
                "http://www.epsg.upv.es",
                "Uno de los mejores lugares para formarse.", 3));
        add(new Lugar("Al de siempre",
                "P.Industrial Junto Molí Nou - 46722, Benifla (Valencia)",
                38.925857, -0.190642,"",
                TipoLugar.BAR, 636472405,
                "",
                "No te pierdas el arroz en calabaza.", 3));
        add(new Lugar("androidcurso.com", "ciberespacio",
                0.0, 0.0,"",
                TipoLugar.EDUCACION, 962849300,
                "http://androidcurso.com",
                "Amplia tus conocimientos sobre Android.", 5));
        add(new Lugar("Barranco del Infierno",
                "Vía Verde del río Serpis. Villalonga (Valencia)",
                38.867180,-0.295058,"",
                TipoLugar.NATURALEZA, 0,
                "http://sosegaos.blogspot.com.es/2009/02/lorcha-villalonga-via-"+
                        "verde-del-rio.html","Espectacular ruta para bici o andar", 4));
        add(new Lugar("La Vital",
                "Avda. de La Vital, 0 46701 Gandia (Valencia)",
                38.9705949, -0.1720092,"",
                TipoLugar.COMPRAS, 962881070,
                "http://www.lavital.es/",
                "El típico centro comercial", 2));
        add(new Lugar("Escuela Politécnica Superior de Gandía2",
                "C/ Paranimf, 12 46730 Gandia (SPAIN)",
                38.995656,-0.166093, "",
                TipoLugar.EDUCACION, 962849300,
                "http://www.epsg.upv.es",
                "Uno de los mejores lugares para formarse.", 3));
        add(new Lugar("Al de siempre",
                "P.Industrial Junto Molí Nou - 46722, Benifla (Valencia)",
                38.925857, -0.190642,"",
                TipoLugar.BAR, 636472405,
                "",
                "No te pierdas el arroz en calabaza.", 3));
        add(new Lugar("androidcurso.com", "ciberespacio",
                0.0, 0.0,"",
                TipoLugar.EDUCACION, 962849300,
                "http://androidcurso.com",
                "Amplia tus conocimientos sobre Android.", 5));
        add(new Lugar("Barranco del Infierno",
                "Vía Verde del río Serpis. Villalonga (Valencia)",
                38.867180,-0.295058,"",
                TipoLugar.NATURALEZA, 0,
                "http://sosegaos.blogspot.com.es/2009/02/lorcha-villalonga-via-"+
                        "verde-del-rio.html","Espectacular ruta para bici o andar", 4));
        add(new Lugar("La Vital",
                "Avda. de La Vital, 0 46701 Gandia (Valencia)",
                38.9705949, -0.1720092,"",
                TipoLugar.COMPRAS, 962881070,
                "http://www.lavital.es/",
                "El típico centro comercial", 2));
        add(new Lugar("Escuela Politécnica Superior de Gandía",
                "C/ Paranimf, 1 46730 Gandia (SPAIN)",
                38.995656,-0.166093, "",
                TipoLugar.EDUCACION, 962849300,
                "http://www.epsg.upv.es",
                "Uno de los mejores lugares para formarse.", 3));
        add(new Lugar("Al de siempre",
                "P.Industrial Junto Molí Nou - 46722, Benifla (Valencia)",
                38.925857, -0.190642,"",
                TipoLugar.BAR, 636472405,
                "",
                "No te pierdas el arroz en calabaza.", 3));
        add(new Lugar("androidcurso.com", "ciberespacio",
                0.0, 0.0,"",
                TipoLugar.EDUCACION, 962849300,
                "http://androidcurso.com",
                "Amplia tus conocimientos sobre Android.", 5));
        add(new Lugar("Barranco del Infierno",
                "Vía Verde del río Serpis. Villalonga (Valencia)",
                38.867180,-0.295058,"",
                TipoLugar.NATURALEZA, 0,
                "http://sosegaos.blogspot.com.es/2009/02/lorcha-villalonga-via-"+
                        "verde-del-rio.html","Espectacular ruta para bici o andar", 4));
        add(new Lugar("La Vital",
                "Avda. de La Vital, 0 46701 Gandia (Valencia)",
                38.9705949, -0.1720092,"",
                TipoLugar.COMPRAS, 962881070,
                "http://www.lavital.es/",
                "El típico centro comercial", 2));
        add(new Lugar("Escuela Politécnica Superior de Gandía",
                "C/ Paranimf, 1 46730 Gandia (SPAIN)",
                38.995656,-0.166093, "",
                TipoLugar.EDUCACION, 962849300,
                "http://www.epsg.upv.es",
                "Uno de los mejores lugares para formarse.", 3));
        add(new Lugar("Al de siempre",
                "P.Industrial Junto Molí Nou - 46722, Benifla (Valencia)",
                38.925857, -0.190642,"",
                TipoLugar.BAR, 636472405,
                "",
                "No te pierdas el arroz en calabaza.", 3));
        add(new Lugar("androidcurso.com", "ciberespacio",
                0.0, 0.0,"",
                TipoLugar.EDUCACION, 962849300,
                "http://androidcurso.com",
                "Amplia tus conocimientos sobre Android.", 5));
        add(new Lugar("Barranco del Infierno",
                "Vía Verde del río Serpis. Villalonga (Valencia)",
                38.867180,-0.295058,"",
                TipoLugar.NATURALEZA, 0,
                "http://sosegaos.blogspot.com.es/2009/02/lorcha-villalonga-via-"+
                        "verde-del-rio.html","Espectacular ruta para bici o andar", 4));
        add(new Lugar("La Vital",
                "Avda. de La Vital, 0 46701 Gandia (Valencia)",
                38.9705949, -0.1720092,"",
                TipoLugar.COMPRAS, 962881070,
                "http://www.lavital.es/",
                "El típico centro comercial", 2));

    }
}
