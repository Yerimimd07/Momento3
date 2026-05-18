public class PuertaPiso extends Puerta {
 
    // Atributo privado - Encapsulamiento
    private int numeroPiso;
 
    // Constructor con argumentos
    public PuertaPiso(int numeroPiso) {
        super(false);              // Llama al constructor de Puerta; inicia cerrada
        this.numeroPiso = numeroPiso;
    }
 
    /**
     * Sobreescritura de abrir().
     * Polimorfismo: comportamiento específico para PuertaPiso.
     */
    @Override
    public void abrir() {
        if (!estaAbierta()) {
            setAbierta(true);
            System.out.println("[PUERTA PISO " + numeroPiso + "] Puerta externa abierta.");
        } else {
            System.out.println("[PUERTA PISO " + numeroPiso + "] La puerta externa ya está abierta.");
        }
    }
 
    /**
     * Sobreescritura de cerrar().
     */
    @Override
    public void cerrar() {
        if (estaAbierta()) {
            setAbierta(false);
            System.out.println("[PUERTA PISO " + numeroPiso + "] Puerta externa cerrada.");
        } else {
            System.out.println("[PUERTA PISO " + numeroPiso + "] La puerta externa ya está cerrada.");
        }
    }
 
    // Getter - Encapsulamiento
    public int getNumeroPiso() {
        return numeroPiso;
    }
 
    @Override
    public String toString() {
        return "PuertaPiso [piso=" + numeroPiso + ", abierta=" + estaAbierta() + "]";
    }
}