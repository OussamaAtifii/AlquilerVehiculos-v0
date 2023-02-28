package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

public class Turismo {
    private static final String ER_MARCA = "^[A-Za-z]{3,20}[\\-|\\s+]?([A-Za-z]{3,20})?$";
    private static final String ER_MATRICULA = "^[0-9]{4}[B-Z]{3}$";
    private String marca;
    private String modelo;
    private int cilindrada;
    private String matricula;

    // Constructor con parámetros
    public Turismo(String marca, String modelo, int cilindrada, String matricula) {
        setMarca(marca);
        setModelo(modelo);
        setCilindrada(cilindrada);
        setMatricula(matricula);
    }

    // Constructor copia
    public Turismo(Turismo turismo) {
        if (turismo == null) {
            throw new NullPointerException("ERROR: No es posible copiar un turismo nulo.");
        }
        setMarca(turismo.getMarca());
        setModelo(turismo.getModelo());
        setCilindrada(turismo.getCilindrada());
        setMatricula(turismo.getMatricula());
    }

    // Método devuelve turismo con matricula indicada
    public static Turismo getTurismoConMatricula(String matricula) {
        return new Turismo("Ford", "Mondeo", 3000, matricula); // Devolver turismo con matricula obtenida
    }

    // Get y Set de marca
    public String getMarca() {
        return marca;
    }

    private void setMarca(String marca) {
    	if(marca == null) {
    		throw new NullPointerException("ERROR: La marca no puede ser nula.");
    	}
    	if(!marca.matches(ER_MARCA)) {
    		throw new IllegalArgumentException("ERROR: La marca no tiene un formato válido.");
    	}
        this.marca = marca;
    }

    // Get y Set de modelo
    public String getModelo() {
        return modelo;
    }

    private void setModelo(String modelo) {
        if (modelo == null) { // Validar modelo no nulo
            throw new NullPointerException("ERROR: El modelo no puede ser nulo.");
        }
        if (modelo.trim().isEmpty()) { // Validar modelo no esta blanco
            throw new IllegalArgumentException("ERROR: El modelo no puede estar en blanco.");
        }
        this.modelo = modelo;
    }

    // Get y Set de cilindrada
    public int getCilindrada() {
        return cilindrada;
    }

    private void setCilindrada(int cilindrada) {
        if (cilindrada <= 0 || cilindrada > 5000) { // Validar cilindrada entre 1 y 5000
            throw new IllegalArgumentException("ERROR: La cilindrada no es correcta.");
        }
        this.cilindrada = cilindrada;
    }

    // Get y Set de matricula
    public String getMatricula() {
        return matricula;
    }

    private void setMatricula(String matricula) {
        if (matricula == null) { // Validar matricula no nula
            throw new NullPointerException("ERROR: La matrícula no puede ser nula.");
        }
        if (!matricula.matches(ER_MATRICULA)) { // Validar formato de la matricula
            throw new IllegalArgumentException("ERROR: La matrícula no tiene un formato válido.");
        }
        this.matricula = matricula;
    }

    // Método hashCode
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
        return result;
    }

    /*
    Método equals, un turismo es igual a otro si la matricula es la misma
    */ 
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Turismo other = (Turismo) obj;
        if (matricula == null) {
            if (other.matricula != null)
                return false;
        } else if (!matricula.equals(other.matricula))
            return false;
        return true;
    }

    // Método toString
    @Override
    public String toString() {
        return marca + " " + modelo + " (" + cilindrada + "CV) - " + matricula;
    }

}
