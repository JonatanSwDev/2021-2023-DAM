package Ferreteria_DB4o;

import java.io.File;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

import javax.annotation.processing.SupportedSourceVersion;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Predicate;

public class DB4o {

    static String DBferreteria = "DBferreteria.db4o";
    static ObjectContainer db = Db4oEmbedded.openFile(DBferreteria);
    // static ObjectContainer db =
    // Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), DBferreteria);
    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion = -1;
        do {
            System.out.println("\nElige la opcion:");
            System.out.println("================");
            System.out.println(" 1.- Añadir Cliente");
            System.out.println(" 2.- Mostrar Clientes");
            System.out.println(" 3.- Modificar Cliente");
            System.out.println();
            System.out.println(" 4.- Añadir Artículo nuevo");
            System.out.println(" 5.- Mostrar Artículos");
            System.out.println(" 6.- Modificar Artículo");
            System.out.println(" 7.- Reponer Artículo");
            System.out.println();
            System.out.println(" 8.- Hacer Venta");
            System.out.println(" 9.- Anular Venta");
            System.out.println(
                    "10.- Mostrar todos los artículos de los que haya que pedir unidades al almacen por tener pocas unidades en la ferretería");
            System.out.println(
                    "11.- Mostrar los nombres de los artículos vendidos entre 2 fechas que se piden por teclado");
            System.out.println("12.- Localiza a todos los clientes que han hecho una compra en los tres últimos meses");
            System.out.println(
                    "13.- Muestra las localidades de los clientes y los nombres de los clientes que han realizado una factura por un importe superior a 50€");
            System.out.println();
            System.out.println("0.- Salir");
            System.out.println("Opcion= ??");
            opcion = teclado.nextInt();
            String basura = teclado.nextLine();

            switch (opcion) {
                case 0:
                    System.out.println("HASTA LUEGO");
                    break;
                case 1:
                    anadirCliente();
                    break;
                case 2:
                    mostrarClientes();
                    break;
                case 3:
                    modificarCliente();
                    break;
                case 4:
                    anadirArticulo();
                    break;
                case 5:
                    mostrarArticulos();
                    break;
                case 6:
                    modificarArticulo();
                    break;
                case 7:
                    reponerArticulo();
                    break;
                case 8:
                    hacerVenta();
                    break;
                case 9:
                    anularVenta();
                    break;
                case 10:
                    articulosAreponer();
                    break;
                case 11:
                    ventasRealizadas();
                    break;
                case 12:
                    ultimosClientes();
                    break;
                case 13:
                    ventasMasde50();
                    break;

                default:
                    ;
                    break;

            } // fin switch
        } while (opcion != 0);// fin while

        db.close(); // cerrar base de datos

    } // final del MAIN()

    private static void ventasMasde50() {
        // TODO Auto-generated method stub
        // Mostrará localidades de los clientes y los nombres de los clientes que han
        // realizado una factura por un importe superior a 50€.
        ObjectSet<Venta> result = db.queryByExample(new Venta(null, null, 0, 0));
        if (result.size() == 0) {
            System.out.println("No se han encontrado ventas");
        } else {
            Venta venta = null;
            while (result.hasNext()) {
                venta = result.next();
                if((venta.getPvp_unidad()*venta.getUnidades_vendidas()) >= 50){
                    System.out.println("\nLocalidad: " + venta.getCliente().getLocalidad()+
                                        ", Nombre: " + venta.getCliente().getNombre());
                }
            }
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        
    }

    private static void ultimosClientes() {
        // TODO Auto-generated method stub
        // Mostrará los nombres de clientes que han comprado en los 3 últimos meses a
        // partir de la fecha de tresMeses.
        String tresMeses = String.valueOf(LocalDate.now().minusMonths(3));
        ObjectSet<Venta> result = db.queryByExample(new Venta(null, null, 0, 0));
        if (result.size() == 0) {
            System.out.println("No se han encontrado ventas");
        } else {
            Venta venta = null;
            while (result.hasNext()) {
                venta = result.next();
                String fechaVenta = String.valueOf(venta.getFecha_venta());
                if(fechaVenta.compareToIgnoreCase(tresMeses) >= 0){
                    Cliente cliente = venta.getCliente();
                    cliente.mostrarDatos();
                }
            }
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static void ventasRealizadas() {
        System.out.print("Introduce la fecha minima(yyyy-mm-dd): ");
        String fechaMin = teclado.nextLine();
        if(!fechaMin.matches("([0-9]{4}-[0-9]{1,2}-[0-9]{1,2})")){
            System.out.println("Fecha invalida");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            return;
        }

        System.out.print("Introduce la fecha maxima(yyyy-mm-dd): ");
        String fechaMax = teclado.nextLine();

        if(!fechaMax.matches("([0-9]{4}-[0-9]{1,2}-[0-9]{1,2})")){
            System.out.println("Fecha invalida");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            return;
        }

        ObjectSet<Venta> result = db.queryByExample(new Venta(null, null, 0, 0));
        if (result.size() == 0) {
            System.out.println("No se han encontrado ventas");
        } else {
            Venta venta = null;
            while (result.hasNext()) {
                venta = result.next();
                String fecha = String.valueOf(venta.getFecha_venta());
                if(fecha.compareToIgnoreCase(fechaMax) <= 0 &&fecha.compareToIgnoreCase(fechaMin) >= 0){ 
                    System.out.println("Fecha Venta: " + String.valueOf(venta.getFecha_venta()) +
                                    ", Cliente : " + venta.getCliente().getDni() +
                                    ", Articulo : " + venta.getArticulo().getCod_articulo() +
                                    ", Cantidad: " + venta.getUnidades_vendidas() +
                                    ", PvP: " + venta.getPvp_unidad());
                }
            }
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
    }

    private static void articulosAreponer() {
        // TODO Auto-generated method stub
        // Mostrará todos los artículos cuyo stock_actual es inferior al stock_minmo
        ObjectSet<Articulo> result = db.queryByExample(new Articulo(null, null, 0));
        if (result.size() == 0) {
            System.out.println("\nNo se han encontrado articulos");
        } else {
            Articulo articulo = null;
            while (result.hasNext()) {
                articulo = result.next();
                if(articulo.getStock_minimo() > articulo.getStock_actual()){
                    articulo.mostrarDatos();
                }
            }
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
    }

    private static void anularVenta() {
        // TODO Auto-generated method stub
        // Pedirá un dni de cliente y una fecha_venta, mostrará esa venta si la hay y
        // procederá a borrarla. Habrá que volver a sumar las unidades devueltas en el
        // stock_actual
        ObjectSet<Venta> resultVentas = db.queryByExample(new Venta(null, null, 0, 0));
        if(resultVentas.size() == 0){
            System.out.println("No hay ventas realizadas");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            return;
        }
        while(resultVentas.hasNext()){
            Venta venta = resultVentas.next();
            System.out.println("Fecha Venta: " + venta.getFecha_venta() +
            ", Cliente : " + venta.getCliente().getDni() +
            ", Articulo : " + venta.getArticulo().getCod_articulo() +
            ", Cantidad: " + venta.getUnidades_vendidas() +
            ", PvP: " + venta.getPvp_unidad());
        }
        System.out.print("Introduce el DNI del cliente: ");
        String dni = teclado.nextLine();
        //Comprobar DNI
        ObjectSet<Cliente> result = db.queryByExample(new Cliente(null, dni, null));
        if (result.size() == 0) {
            System.out.println("Cliente no encontrado");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return;
        }
            Cliente cliente = result.next();

        //Comprobar formato de fecha
        System.out.print("Introduce la fecha de venta (yyyy-mm-dd): ");
        String fecha = teclado.nextLine();
        if(!fecha.matches("([0-9]{4}-[0-9]{1,2}-[0-9]{1,2})")){
            System.out.println("La fecha no es correcta");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return;
        }

        ObjectSet<Venta> resultVenta = db.queryByExample(new Venta(cliente, null, 0, 0));
        while(resultVenta.hasNext()){
            Venta venta = resultVenta.next();
            if(venta.getFecha_venta().equals(LocalDate.parse(fecha))){
                int reponer = venta.getUnidades_vendidas();
                Articulo art = venta.getArticulo();
                reponer += art.getStock_actual();
                art.setStock_actual(reponer);
                db.store(art);
                db.delete(venta);
                db.commit();
                
                System.out.println("Venta anulada con exito");
            } else {
                System.out.println("No hay ventas a anular");
            }

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    private static void hacerVenta() {
        // A partir de la fecha de tresMeses, pide dni de cliente, pide artículo y nº unidades
        // quese venden. Hay que descontar el numero de unidades del stock.
        try {
            ObjectSet<Cliente> result = db.queryByExample(new Cliente(null, null, null));
            if (result.size() == 0) {
                System.out.println("No se han encontrado clientes");
                return;
            }
            System.out.println("\n\tNúmero de registros encontrados: " + result.size());
            ArrayList<Cliente> clientes = new ArrayList<Cliente>();
            Cliente cliente = null;
            int i = 0;
            while (result.hasNext()) {
                cliente = result.next();
                System.out.print(i + " - ");
                cliente.mostrarDatos();
                clientes.add(cliente);
                i++;
            }
            System.out.println("Selecciona un cliente: ");
            int numero = Integer.parseInt(teclado.nextLine());
            if (numero >= 0 && numero < clientes.size()) {
                cliente = clientes.get(numero);
            }


            mostrarArticulos();
            System.out.print("\nIntroduce el codigo del articulo: ");
            String cod_articulo = teclado.nextLine();

            Articulo articulo;
            ObjectSet<Articulo> result_Art = db.queryByExample(new Articulo(null, cod_articulo, 0));
            if (result_Art.size() == 0) {
                System.out.println("No se han encontrado articulos, volviendo...");
                Thread.sleep(2000);
                return;
            } else {
                articulo = result_Art.next();
            }

            System.out.print("Introduce la cantidad a comprar: ");
            int cantidad = Integer.parseInt(teclado.nextLine());
            if (cantidad <= 0 || cantidad > articulo.getStock_actual()) {
                System.out.println("Stock invalido, volviendo...");
                Thread.sleep(2000);
                return;
            }

            System.out.print("Introduce el PvP por unidad: ");
            int pvp = Integer.parseInt(teclado.nextLine());
            if (pvp <= 0) {
                System.out.println("El precio debe ser mayor de 0, volviendo...");
                Thread.sleep(2000);
                return;
            }

            Venta venta = new Venta(cliente, articulo, cantidad, pvp);
            System.out.println(venta.getPvp_unidad());
            db.store(venta);
            cantidad = articulo.getStock_actual() - cantidad;
            articulo.setStock_actual(cantidad);
            db.store(articulo);
            db.commit();
            //
            System.out.println("Venta generada correctamente");
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Ha ocurrido un error");
        }
    }

    private static void reponerArticulo() {
        mostrarArticulos();
        try {
            System.out.print("\nIntroduce el codigo del articulo: ");
            String cod_articulo = teclado.nextLine();

            Articulo articulo;
            ObjectSet<Articulo> result = db.queryByExample(new Articulo(null, cod_articulo, 0));
            if (result.size() == 0) {
                System.out.println("No se han encontrado articulos");
                return;
            } else {
                articulo = result.next();
            }
            System.out.print("Introduce la cantidad a reponer: ");
            int cantidad = Integer.parseInt(teclado.nextLine());

            if (cantidad < 0) {
                System.out.println("Introduce una cantidad positiva");
            } else if (cantidad > 0) {
                articulo.comprarArticulo(cantidad);
            }

            db.store(articulo);
            db.commit();
            System.out.println("Stock añadido");
            Thread.sleep(2000);

        } catch (Exception e) {
            System.out.println("Ha ocurrido un error");
        }
    }

    private static void modificarArticulo() {
        ObjectSet<Articulo> result = db.queryByExample(new Articulo(null, null, 0));
        if (result.size() == 0) {
            System.out.println("No se han encontrado articulos");
        } else {
            System.out.println("\n\tNúmero de registros encontrados: " + result.size());
            ArrayList<Articulo> articulos = new ArrayList<Articulo>();
            Articulo articulo = null;
            int i = 0;
            while (result.hasNext()) {
                articulo = result.next();
                System.out.print(i + " - ");
                articulo.mostrarDatos();
                articulos.add(articulo);
                i++;
            }
            System.out.println("Selecciona un articulo: ");
            try {
                int numero = Integer.parseInt(teclado.nextLine());
                if (numero >= 0 && numero < articulos.size()) {
                    articulo = articulos.get(numero);
                    System.out.print("Introduce la nueva descripcion (dejar en blanco para cancelar): ");
                    String descripcion = teclado.nextLine();
                    if (!descripcion.isEmpty()) {
                        articulo.setDescripcion(descripcion);
                    }

                    System.out.print("Introduce el nuevo codigo para el articulo (dejar en blanco para cancelar): ");
                    String cod = teclado.nextLine();
                    if (!cod.isEmpty()) {
                        articulo.setCod_articulo(cod);
                    }

                    System.out.print("Introduce el nuevo stock actual (dejar en blanco para cancelar): ");
                    String stock = teclado.nextLine();
                    if (!stock.isEmpty()) {
                        articulo.setStock_actual(Integer.parseInt(stock));
                    }

                    System.out.print("Introduce el nuevo stock minimo (dejar en blanco para cancelar): ");
                    String stock_min = teclado.nextLine();
                    if (!stock_min.isEmpty()) {
                        articulo.setStock_minimo(Integer.parseInt(stock_min));
                    }
                    db.store(articulo);
                    db.commit();
                    System.out.println("Articulo creado con exito");
                    Thread.sleep(2000);
                } else {
                    System.out.println("Ningun articulo seleccionado");
                    Thread.sleep(2000);
                    return;
                }

            } catch (Exception e) {
                System.out.println("Ha ocurrido un error");
            }
        }
    }

    private static void mostrarArticulos() {
        ObjectSet<Articulo> result = db.queryByExample(new Articulo(null, null, 0));
        if (result.size() == 0) {
            System.out.println("No se han encontrado articulos");
        } else {
            System.out.println("\n\tNúmero de registros encontrados: " + result.size());
            Articulo articulo = null;
            while (result.hasNext()) {
                articulo = result.next();
                articulo.mostrarDatos();
            }
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }

    }

    private static void anadirArticulo() {
        System.out.print("Introduce la descripcion del articulo: ");
        String descripcion = teclado.nextLine();

        System.out.print("Introduce el codigo del articulo: ");
        String cod_articulo = teclado.nextLine();

        System.out.print("Introduce el stock para el articulo: ");
        try {
            int stock = Integer.parseInt(teclado.nextLine());

            ObjectSet<Articulo> result = db.queryByExample(new Articulo(null, cod_articulo, 0));
            if (result.size() == 0) {
                db.store(new Articulo(descripcion, cod_articulo, stock));
                db.commit();
                System.out.println("Articulo creado con exito");
            } else {
                System.out.println("\n Ya existe un articulo con ese codigo");
            }
        } catch (Exception e) {
            System.out.println("El valor introducido no es un numero\nVolviendo...");
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
    }

    private static void modificarCliente() {
        ObjectSet<Cliente> result = db.queryByExample(new Cliente(null, null, null));
        if (result.size() == 0) {
            System.out.println("No se han encontrado clientes");
        } else {
            System.out.println("\n\tNúmero de registros encontrados: " + result.size());
            ArrayList<Cliente> clientes = new ArrayList<Cliente>();
            Cliente cliente = null;
            int i = 0;
            while (result.hasNext()) {
                cliente = result.next();
                System.out.print(i + " - ");
                cliente.mostrarDatos();
                clientes.add(cliente);
                i++;
            }
            System.out.println("Selecciona un cliente: ");
            try {
                int numero = Integer.parseInt(teclado.nextLine());
                if (numero >= 0 && numero < clientes.size()) {
                    cliente = clientes.get(numero);
                    System.out.print("Introduce el nuevo nombre (dejar en blanco para cancelar): ");
                    String nombre = teclado.nextLine();
                    if (!nombre.isEmpty()) {
                        cliente.setNombre(nombre);
                    }

                    System.out.print("Introduce el nuevo DNI (dejar en blanco para cancelar): ");
                    String dni = teclado.nextLine();
                    if (!dni.isEmpty()) {
                        cliente.setDni(dni);
                    }

                    System.out.print("Introduce la nueva localidad (dejar en blanco para cancelar): ");
                    String localidad = teclado.nextLine();
                    if (!localidad.isEmpty()) {
                        cliente.setLocalidad(localidad);
                    }

                    System.out.print("¿Cliente activo? (S/N): ");
                    String activo = teclado.nextLine().toUpperCase();
                    if (activo.equals("S")) {
                        cliente.setCliente_activo(true);
                    } else if (activo.equals("N")) {
                        cliente.setCliente_activo(false);
                    } else {
                        System.out.println("Ningun cambio efectuado");
                    }

                    db.store(cliente);
                    db.commit();
                    System.out.println("Cliente creado con exito");
                    Thread.sleep(2000);
                } else {
                    System.out.println("Ningun cliente seleccionado");
                    Thread.sleep(2000);
                    return;
                }
            } catch (Exception e) {
                System.out.println("Se ha producido un error");
            }
        }
    }

    private static void mostrarClientes() {
        ObjectSet<Cliente> result = db.queryByExample(new Cliente(null, null, null));
        if (result.size() == 0) {
            System.out.println("No se han encontrado clientes");
        } else {
            System.out.println("\n\tNúmero de registros encontrados: " + result.size());
            Cliente cliente = null;
            while (result.hasNext()) {
                cliente = result.next();
                cliente.mostrarDatos();
            }
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
    }

    private static void anadirCliente() {
        System.out.print("Introduce el nombre del cliente: ");
        String nombre = teclado.nextLine();

        System.out.print("Introduce el dni del cliente: ");
        String dni = teclado.nextLine();

        System.out.print("Introduce la localidad del cliente: ");
        String localidad = teclado.nextLine();

        ObjectSet<Cliente> result = db.queryByExample(new Cliente(null, dni, null));
        if (result.size() == 0) {
            db.store(new Cliente(nombre, dni, localidad));
            db.commit();
            System.out.println("Cliente creado con exito");
        } else {
            System.out.println("\n Ya existe un Cliente con ese DNI");
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
    }
} // final de la clase
