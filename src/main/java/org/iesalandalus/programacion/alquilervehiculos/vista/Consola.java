package org.iesalandalus.programacion.alquilervehiculos.vista;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {
    private final static String PATRON_FECHA = "^([0-2][0-9]|3[0-1])(\\/)(0[1-9]|1[0-2])\\2(\\d{4})$";
    private final static DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private Consola() {

    }

    public static void mostrarCabecera(String mensaje) {
        String subrayado = "";
        for (int i = 0; i < mensaje.length(); i++) {
            subrayado = subrayado + "-";
        }

        System.out.println(mensaje);
        System.out.println(subrayado);
    }

    public static void mostrarMenu() {
        Opcion[] opcion = Opcion.values();
        System.out.println("---------------------------------");
        System.out.println("ALQUILER DE TODO TIPO DE TURISMOS");
        System.out.println("---------------------------------\n");

        System.out.println("OPCIONES DISPONIBLES");
        System.out.println("--------------------");

        for (int i = 0; i < opcion.length; i++) {
            System.out.println(i + ".- " + opcion[i].toString());
        }
    }

    private static String leerCadena(String mensaje) {
        System.out.println(mensaje);
        return Entrada.cadena();

    }

    private static Integer leerEntero(String mensaje) {
        System.out.println(mensaje);
        return Entrada.entero();

    }

    private static LocalDate leerFecha(String mensaje) {
        String fecha;

        System.out.println(mensaje);
        fecha = Entrada.cadena();
        while (!fecha.matches(PATRON_FECHA)) {
            System.out.println("Fecha incorrecta, vuelva a introducirla: ");
            fecha = Entrada.cadena();
        }
        return LocalDate.parse(fecha, FORMATO_FECHA);
    }

    public static Opcion elegirOpcion() {
        boolean comprobador = false;
        Opcion opcion = null;
        int ordinal = leerEntero("Introduzca un opcion: ");
        while (comprobador == false) {
            try {
                opcion = Opcion.get(ordinal);
                comprobador = true;
            } catch (Exception e) {
                System.out.println("Vuelva a introducir una opcion correcta: ");
                ordinal = Entrada.entero();
            }
        }
        return opcion;
    }

    public static Cliente leerCliente() {
        String nombre = leerCadena("Introduzca nombre de cliente: ");
        String dni = leerCadena("Introduzca dni del cliente: ");
        String telefono = leerCadena("Introduzca telefono de cliente: ");
        return new Cliente(nombre, dni, telefono);
    }

    public static Cliente leerClienteDni() {
        String dni = leerCadena("Introduzca dni del cliente: ");
        return Cliente.getClienteConDni(dni);
    }

    public static String leerNombre() {
        return leerCadena("Introduzca nombre: ");
    }

    public static String leerTelefono() {
        return leerCadena("Introduzca telefono: ");
    }

    public static Turismo leerTurismo() {
        String marca = leerCadena("Introduzca marca de turismo: ");
        String modelo = leerCadena("Introduzca modelo del turismo: ");
        int cilindrada = leerEntero("Introduzca cilindrada de turismo: ");
        String matricula = leerCadena("Introduzca matricula de turismo: ");

        return new Turismo(marca, modelo, cilindrada, matricula);
    }

    public static Turismo leerTurismoMatricula() {
        String matricula = leerCadena("Introduzca matricula de turismo: ");
        return Turismo.getTurismoConMatricula(matricula);
    }

    public static Alquiler leerAlquiler() {
        Turismo turismo = leerTurismoMatricula();
        Cliente cliente = leerClienteDni();
        LocalDate fechaAlquiler = leerFecha("Introduzca fecha de alquiler: ");

        return new Alquiler(cliente, turismo, fechaAlquiler);
    }

    public static LocalDate leerFechaDevolucion() {
        LocalDate fechaDevolucion = leerFecha("Introduzca fecha de devolución: ");
        return fechaDevolucion;
    }

}
