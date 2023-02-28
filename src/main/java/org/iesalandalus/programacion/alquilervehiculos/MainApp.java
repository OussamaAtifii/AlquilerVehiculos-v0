package org.iesalandalus.programacion.alquilervehiculos;

import org.iesalandalus.programacion.alquilervehiculos.controlador.Controlador;
import org.iesalandalus.programacion.alquilervehiculos.modelo.Modelo;
import org.iesalandalus.programacion.alquilervehiculos.vista.Vista;

public class MainApp {

	public static void main(String[] args) {
		// Ánimo!!!! 
		Vista vista = new Vista();
		Modelo modelo = new Modelo();
		Controlador controlador;
		
		controlador = new Controlador(modelo, vista);
		controlador.comenzar();
	}
}
