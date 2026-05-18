public class BotonPiso extends Boton {
 
    // Atributos privados - Encapsulamiento
    private int    numeroPiso;
    private String direccion;   // "SUBIR" o "BAJAR"
 
    // Constructor con argumentos
    public BotonPiso(int numeroPiso, String direccion) {
        super(false);
        this.numeroPiso = numeroPiso;
        this.direccion  = direccion;
    }
 
    /**
     * Sobreescritura del método presionar().
     * Comportamiento específico para BotonPiso.
     */
    @Override
    public void presionar() {
        setPresionado(true);
        System.out.println("[BOTON PISO] Botón " + direccion
                + " del piso " + numeroPiso + " presionado. Llamando al ascensor...");
    }
 
    // Getters - Encapsulamiento
    public int getNumeroPiso() {
        return numeroPiso;
    }
 
    public String getDireccion() {
        return direccion;
    }
 
    @Override
    public String toString() {
        return "BotonPiso [piso=" + numeroPiso + ", direccion=" + direccion
                + ", presionado=" + estaPresionado() + "]";
    }
}