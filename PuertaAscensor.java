public class PuertaAscensor extends Puerta {
 
    // Atributo privado - Encapsulamiento
    private String ubicacion;
 
    // Constructor con argumentos
    public PuertaAscensor(String ubicacion) {
        super(false);              // Llama al constructor de Puerta; inicia cerrada
        this.ubicacion = ubicacion;
    }
 
    /**
     * Sobreescritura de abrir().
     * Polimorfismo: comportamiento específico para PuertaAscensor.
     */
    @Override
    public void abrir() {
        if (!estaAbierta()) {
            setAbierta(true);
            System.out.println("[PUERTA ASCENSOR] Puerta interna abierta. (" + ubicacion + ")");
        } else {
            System.out.println("[PUERTA ASCENSOR] La puerta interna ya está abierta.");
        }
    }
 
    /**
     * Sobreescritura de cerrar().
     */
    @Override
    public void cerrar() {
        if (estaAbierta()) {
            setAbierta(false);
            System.out.println("[PUERTA ASCENSOR] Puerta interna cerrada.");
        } else {
            System.out.println("[PUERTA ASCENSOR] La puerta interna ya está cerrada.");
        }
    }
 
    // Getter - Encapsulamiento
    public String getUbicacion() {
        return ubicacion;
    }
 
    @Override
    public String toString() {
        return "PuertaAscensor [ubicacion=" + ubicacion + ", abierta=" + estaAbierta() + "]";
    }
}