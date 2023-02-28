package org.iesalandalus.programacion.alquilervehiculos.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.Alquileres;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.Clientes;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.Turismos;

public class Modelo {
    private Clientes clientes;
    private Turismos turismos;
    private Alquileres alquileres;

    public void comenzar() {
        clientes = new Clientes();
        turismos = new Turismos();
        alquileres = new Alquileres();
    }

    public Modelo() {

    }

    public void terminar() {
        System.out.println("El modelo a terminado con éxito.");
    }

    public void insertar(Cliente cliente) throws OperationNotSupportedException {
        clientes.insertar(new Cliente(cliente));
    }

    public void insertar(Turismo turismo) throws OperationNotSupportedException {
        turismos.insertar(new Turismo(turismo));
    }

    public void insertar(Alquiler alquiler) throws OperationNotSupportedException {
        if (alquiler == null) {
            throw new NullPointerException("ERROR: No se puede realizar un alquiler nulo.");
        }

        Cliente cliente = clientes.buscar(alquiler.getCliente());
        Turismo turismo = turismos.buscar(alquiler.getTurismo());

        if (cliente == null) {
            throw new OperationNotSupportedException("ERROR: No existe el cliente del alquiler.");
        }
        if (turismo == null) {
            throw new OperationNotSupportedException("ERROR: No existe el turismo del alquiler.");
        }
        
        alquileres.insertar(new Alquiler(cliente, turismo, alquiler.getFechaAlquiler()));

    }

    public Cliente buscar(Cliente cliente) {
        Cliente clienteBuscar = clientes.buscar(cliente);
        if (clienteBuscar != null) {
            return new Cliente(clienteBuscar.getNombre(), clienteBuscar.getDni(), clienteBuscar.getTelefono());
        } else {
            return null;
        }
    }

    public Turismo buscar(Turismo turismo) {
        Turismo turismoBuscar = turismos.buscar(turismo);
        if ( turismoBuscar != null) {
            return new Turismo(turismoBuscar.getMarca(), turismoBuscar.getModelo(), turismoBuscar.getCilindrada(),turismoBuscar.getMatricula());
        } else {
            return null;
        }
    }

    public Alquiler buscar(Alquiler alquiler) {
        Alquiler alquilerDevolver;
        alquilerDevolver = alquileres.buscar(alquiler);
        if (alquilerDevolver != null) {
            return new Alquiler(alquilerDevolver.getCliente(), alquilerDevolver.getTurismo(), alquilerDevolver.getFechaAlquiler());
        } else {
            return null;
        }
    }

    public void modificar(Cliente cliente, String nombre, String telefono) throws OperationNotSupportedException {
        clientes.modificar(cliente, nombre, telefono);
    }

    public void devolver(Alquiler alquiler, LocalDate fechaDevolucion) throws OperationNotSupportedException {
        Alquiler alquilerADevolver;
        alquilerADevolver = alquileres.buscar(alquiler);
        if (alquilerADevolver == null) {
            throw new OperationNotSupportedException("ERROR: No existe el alquiler a devolver.");
        }
        alquilerADevolver.devolver(fechaDevolucion);
    }

    public void borrar(Cliente cliente) throws OperationNotSupportedException {
        for (Alquiler alquiler : alquileres.get(cliente)) {
            alquileres.borrar(alquiler);
        }
        clientes.borrar(cliente);
    }

    public void borrar(Turismo turismo) throws OperationNotSupportedException {
        for (Alquiler alquiler : alquileres.get(turismo)) {
            alquileres.borrar(alquiler);
        }
        turismos.borrar(turismo);
    }

    public void borrar(Alquiler alquiler) throws OperationNotSupportedException {
        alquileres.borrar(alquiler);
    }

    public List<Cliente> getClientes() {
        List<Cliente> prueba = new ArrayList<>();
        for (Cliente cliente : clientes.get()) {
            prueba.add(new Cliente(cliente.getNombre(), cliente.getDni(), cliente.getTelefono()));
            System.out.println(cliente);
        }
        return prueba;
    }

    public List<Turismo> getTurismos() {
        List<Turismo> prueba = new ArrayList<>();
        for (Turismo turismo : turismos.get()) {
            prueba.add(new Turismo(turismo.getMarca(), turismo.getModelo(), turismo.getCilindrada(),turismo.getMatricula()));
            System.out.println(turismo);
        }
        return prueba;
    }

    public List<Alquiler> getAlquileres() {
        List<Alquiler> prueba = new ArrayList<>();
        for (Alquiler alquiler : alquileres.get()) {
            prueba.add(new Alquiler(alquiler.getCliente(), alquiler.getTurismo(), alquiler.getFechaAlquiler()));
            System.out.println(alquiler);
        }
        return prueba;
    }

    public List<Alquiler> getAlquileres(Cliente cliente) {
        List<Alquiler> prueba = new ArrayList<>();
        for (Alquiler alquiler : alquileres.get(cliente)) {
            prueba.add(new Alquiler(alquiler.getCliente(), alquiler.getTurismo(), alquiler.getFechaAlquiler()));
            System.out.println(alquiler);
        }
        return prueba;
    }

    public List<Alquiler> getAlquileres(Turismo turismo) {
        List<Alquiler> prueba = new ArrayList<>();
        for (Alquiler alquiler : alquileres.get(turismo)) {
            prueba.add(new Alquiler(alquiler.getCliente(), alquiler.getTurismo(), alquiler.getFechaAlquiler()));
            System.out.println(alquiler);
        }
        return prueba;
    }

}
