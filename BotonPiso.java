public class BotonPiso extends Boton {
 
    // Atributo privado - Encapsulamiento
    private int numeroPiso;
 
    // Constructor con argumentos
    public BotonPiso(int numeroPiso) {
        super(false);              // Llama al constructor de Boton
        this.numeroPiso = numeroPiso;
    }
 
    /**
     * Sobreescritura del método presionar().
     * Polimorfismo: comportamiento específico para BotonPiso.
     */
    @Override
    public void presionar() {
        setPresionado(true);
        System.out.println("[BOTON PISO] Botón del piso " + numeroPiso
                + " presionado. Llamando al ascensor...");
    }
 
    // Getter - Encapsulamiento
    public int getNumeroPiso() {
        return numeroPiso;
    }
 
    @Override
    public String toString() {
        return "BotonPiso [piso=" + numeroPiso + ", presionado=" + estaPresionado() + "]";
    }
}