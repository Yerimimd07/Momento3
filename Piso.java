public class Piso {
 
    // Atributos privados - Encapsulamiento
    private int numero;
    private PuertaPiso puerta;    // COMPOSICIÓN
    private BotonPiso  boton;     // COMPOSICIÓN
 
    // Constructor con argumentos
    public Piso(int numero) {
        this.numero = numero;
        // Composición: se crean aquí dentro, junto con el Piso
        this.puerta = new PuertaPiso(numero);
        this.boton  = new BotonPiso(numero);
    }
 
    // Getters - Encapsulamiento
    public int getNumero() {
        return numero;
    }
 
    public PuertaPiso getPuerta() {
        return puerta;
    }
 
    public BotonPiso getBoton() {
        return boton;
    }
 
    @Override
    public String toString() {
        return "Piso " + numero + " | " + puerta + " | " + boton;
    }
}