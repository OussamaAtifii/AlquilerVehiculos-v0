package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;

public class Alquileres {
    private static List<Alquiler> coleccionAlquileres;

    public Alquileres() {
        coleccionAlquileres = new ArrayList<>();
    }

    public List<Alquiler> get() {
        return new ArrayList<>(coleccionAlquileres);
    }

    public List<Alquiler> get(Cliente cliente) {
        List<Alquiler> alquileresCliente = new ArrayList<>();

        for (Alquiler alquiler : coleccionAlquileres) {
            if (alquiler.getCliente().equals(cliente)) {
                alquileresCliente.add(alquiler);
            }
        }
        return alquileresCliente;
    }

    public List<Alquiler> get(Turismo turismo) {
        List<Alquiler> alquileresTurismo = new ArrayList<>();

        for (Alquiler alquiler : coleccionAlquileres) {
            if (alquiler.getTurismo().equals(turismo)) {
                alquileresTurismo.add(alquiler);
            }
        }
        return alquileresTurismo;
    }

    public int getCantidad() {
        return coleccionAlquileres.size();
    }

    public void insertar(Alquiler alquiler) throws OperationNotSupportedException {
        if (alquiler == null) {
            throw new NullPointerException("ERROR: No se puede insertar un alquiler nulo.");
        }

        comprobarAlquiler(alquiler.getCliente(), alquiler.getTurismo(), alquiler.getFechaAlquiler());
        coleccionAlquileres.add(alquiler);
    }

    public void devolver(Alquiler alquiler, LocalDate fechaDevolucion) throws OperationNotSupportedException {
        if (alquiler == null) {
            throw new NullPointerException("ERROR: No se puede devolver un alquiler nulo.");
        }
        if (fechaDevolucion == null) {
            throw new NullPointerException("ERROR: La fecha de devolución no puede ser nula.");
        }
        if (!coleccionAlquileres.contains(alquiler)) {
            throw new OperationNotSupportedException("ERROR: No existe ningún alquiler igual.");
        }
        alquiler.devolver(fechaDevolucion);
    
    }

    public Alquiler buscar(Alquiler alquiler) {
        int i;
        if (alquiler == null) {
            throw new NullPointerException("ERROR: No se puede buscar un alquiler nulo.");
        }
        if (coleccionAlquileres.contains(alquiler)) {
            i = coleccionAlquileres.indexOf(alquiler);
            alquiler = coleccionAlquileres.get(i);
            return alquiler;
        } else {
            return null; 
        }
    }

    public void borrar(Alquiler alquiler) throws OperationNotSupportedException {
        if (alquiler == null) {
            throw new NullPointerException("ERROR: No se puede borrar un alquiler nulo.");
        }
        if(!coleccionAlquileres.contains(alquiler)) {
            throw new OperationNotSupportedException("ERROR: No existe ningún alquiler igual.");
        }
        coleccionAlquileres.remove(alquiler);
    }
    
    private void comprobarAlquiler(Cliente cliente, Turismo turismo, LocalDate fechaAlquiler) throws OperationNotSupportedException {
        
        if (cliente == null) {
            throw new NullPointerException("ERROR: El cliente no puede ser nulo.");
        }
        if (turismo == null) {
            throw new NullPointerException("ERROR: El turismo no puede ser nulo.");
        }

        for (Alquiler alquiler : get(cliente)) {
            if(alquiler.getFechaDevolucion() == null){
                throw new OperationNotSupportedException("ERROR: El cliente tiene otro alquiler sin devolver.");
            } else {
                if (alquiler.getFechaDevolucion().isAfter(fechaAlquiler)) {
                    throw new OperationNotSupportedException("ERROR: El cliente tiene un alquiler posterior.");
                }
            }   
        }

        for (Alquiler alquiler : get(turismo)) {
            if (alquiler.getFechaDevolucion() == null) {
                throw new OperationNotSupportedException("ERROR: El turismo está actualmente alquilado.");
            } else {
                if (alquiler.getFechaDevolucion().isAfter(fechaAlquiler)) {
                    throw new OperationNotSupportedException("ERROR: El turismo tiene un alquiler posterior.");
                } 
            }
        }
    }
    
}
