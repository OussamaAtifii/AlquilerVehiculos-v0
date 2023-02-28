package org.iesalandalus.programacion.alquilervehiculos.vista;

public enum Opcion {
    INSERTAR_CLIENTE("Insertar cliente"), INSERTAR_TURISMO("Insertar turismo"),
    INSERTAR_ALQUILER("Insertar alquiler"), BUSCAR_CLIENTE("Buscar cliente"), BUSCAR_TURISMO("Buscar turismo"),
    BUSCAR_ALQUILER("Buscar alquiler"), MODIFICAR_CLIENTE("Modificar cliente"), DEVOLVER_ALQUILER("Devolver alquiler"),
    BORRAR_CLIENTE("Borrar cliente"), BORRAR_TURISMO("Borrar turismo"), BORRAR_ALQUILER("Borrar alquiler"),
    LISTAR_CLIENTES("Listar clientes"), LISTAR_TURISMOS("Listar turismos"), LISTAR_ALQUILERES("Listar alquileres"),
    LISTAR_ALQUILERES_CLIENTE("Listar alquileres de cliente"),
    LISTAR_ALQUILERES_TURISMO("Listar alquileres de turismo"), SALIR("Salir");

    String cadenaAMostrar;

    private Opcion(String texto) {
        this.cadenaAMostrar = texto;
    }

    private static boolean esOrdinalValido(int ordinal) {
        Opcion[] opciones = values();
        if (ordinal < 0 || ordinal > opciones.length) {
            return false;
        } else {
            return true;
        }
    }

    public static Opcion get(int ordinal) {
        if (!esOrdinalValido(ordinal)) {
            throw new IllegalArgumentException("El numero del ordinal es invalido.");
        }

        Opcion[] opciones = values();

        return opciones[ordinal];
    }

    @Override
    public String toString() {

        return cadenaAMostrar;

    }

}
