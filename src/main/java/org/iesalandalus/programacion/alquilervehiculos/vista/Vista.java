package org.iesalandalus.programacion.alquilervehiculos.vista;


import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.alquilervehiculos.controlador.Controlador;


public class Vista {
    Controlador controlador;

    public void setControlador(Controlador controlador) {
        if (controlador == null) {
            throw new NullPointerException("ERROR: El controlador no puede ser nulo.");
        }
        this.controlador = controlador;
    }

    public void comenzar() {
        Opcion opcion;

        do {
            Consola.mostrarMenu();
            opcion = Consola.elegirOpcion();
            ejecutar(opcion);
        } while (opcion != Opcion.SALIR);
    }

    public void terminar() {
        System.out.println("Vista finalizada");
    }

    private void ejecutar(Opcion opcion) {
        switch (opcion) {
            case SALIR:
                terminar();
                break;
            case INSERTAR_CLIENTE:
                insertarCliente();
                break;
            case INSERTAR_TURISMO:
                insertarTurismo();
                break;
            case INSERTAR_ALQUILER:
                insertarAlquiler();
                break;
            case BUSCAR_CLIENTE:
                buscarCliente();
                break;
            case BUSCAR_TURISMO:
                buscarTurismo();
                break;
            case BUSCAR_ALQUILER:
                buscarAlquiler();
                break;
            case MODIFICAR_CLIENTE:
                modificarCliente();
                break;
            case DEVOLVER_ALQUILER:
                devolverAlquiler();
                break;
            case BORRAR_CLIENTE:
                borrarCliente();
                break;
            case BORRAR_TURISMO:
                borrarTurismo();
                break;
            case BORRAR_ALQUILER:
                borrarAlquiler();
                break;
            case LISTAR_CLIENTES:
                listarClientes();
                break;
            case LISTAR_TURISMOS:
                listarTurismos();
                break;
            case LISTAR_ALQUILERES:
                listarAlquileres();
                break;
            case LISTAR_ALQUILERES_CLIENTE:
                listarAlquileresCliente();
                break;
            case LISTAR_ALQUILERES_TURISMO:
                listarAlquileresTurismo();
                break;
        }
    }

    private void insertarCliente() {
        Consola.mostrarCabecera("Insertar cliente");
        try {
            controlador.insertar(Consola.leerCliente());
        } catch (OperationNotSupportedException | NullPointerException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void insertarTurismo() {
        Consola.mostrarCabecera("Insertar turismo");
        try {
            controlador.insertar(Consola.leerTurismo());
        } catch (OperationNotSupportedException | NullPointerException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void insertarAlquiler() {
        Consola.mostrarCabecera("Insertar alquiler");
        try {
            controlador.insertar(Consola.leerAlquiler());
        } catch (OperationNotSupportedException | NullPointerException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void buscarCliente() {
        Consola.mostrarCabecera("Buscar cliente");
        try {
            System.out.println(controlador.buscar(Consola.leerClienteDni()));
        } catch (NullPointerException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

    private void buscarTurismo() {
        Consola.mostrarCabecera("Buscar turismo");
        try {
            System.out.println(controlador.buscar(Consola.leerTurismoMatricula()));
        } catch (NullPointerException | IllegalArgumentException e) {
            System.out.println(e.getMessage()); 
        }
    }

    private void buscarAlquiler() {
        Consola.mostrarCabecera("Buscar alquiler");
        try {
            System.out.println(controlador.buscar(Consola.leerAlquiler()));
        } catch (NullPointerException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void modificarCliente() {
        Consola.mostrarCabecera("Modificar cliente");
        try {
            controlador.modificar(Consola.leerClienteDni(), Consola.leerNombre(), Consola.leerTelefono());
        } catch (OperationNotSupportedException | NullPointerException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void devolverAlquiler() {
        Consola.mostrarCabecera("Devolver alquiler");
        try {
            controlador.devolver(Consola.leerAlquiler(), Consola.leerFechaDevolucion());
        } catch (OperationNotSupportedException | NullPointerException  | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void borrarCliente() {
        Consola.mostrarCabecera("Borrar cliente");
        try {
            controlador.borrar(Consola.leerClienteDni());
        } catch (OperationNotSupportedException | NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    private void borrarTurismo() {
        Consola.mostrarCabecera("Borrar turismo");
        try {
            controlador.borrar(Consola.leerTurismoMatricula());
        } catch (OperationNotSupportedException | NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    private void borrarAlquiler() {
        Consola.mostrarCabecera("Borrar alquiler");
        try {
            controlador.borrar(Consola.leerAlquiler());
        } catch (OperationNotSupportedException | NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    private void listarClientes() {
        Consola.mostrarCabecera("Listar clientes");
        try {
            controlador.getClientes();
        } catch (NullPointerException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

    private void listarTurismos() {
        Consola.mostrarCabecera("Listar turismos");
        try {
            controlador.getTurismos();
        } catch (NullPointerException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void listarAlquileres() {
        Consola.mostrarCabecera("Listar alquileres");
        try {
            controlador.getAlquileres();
        } catch (NullPointerException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void listarAlquileresCliente() {
        Consola.mostrarCabecera("Listar alquileres de cliente");
        try { 
            controlador.getAlquileres(Consola.leerClienteDni());
        } catch (NullPointerException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        
    }

    private void listarAlquileresTurismo() {
        Consola.mostrarCabecera("Listar alquileres de turismo");
        try {
            controlador.getAlquileres(Consola.leerTurismoMatricula());
        } catch (NullPointerException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

}
