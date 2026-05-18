public class Puerta {
 
    // Atributo privado - Encapsulamiento
    private boolean abierta;
 
    // Constructor con argumento
    public Puerta(boolean abierta) {
        this.abierta = abierta;
    }
 
    /**
     * Métodos que las subclases sobreescriben con @Override.
     * Aquí aplica Polimorfismo: cada subclase responde diferente.
     */
    public void abrir() {
        this.abierta = true;
        System.out.println("[PUERTA] Puerta abierta (comportamiento base).");
    }
 
    public void cerrar() {
        this.abierta = false;
        System.out.println("[PUERTA] Puerta cerrada (comportamiento base).");
    }
 
    // Getter y Setter - Encapsulamiento
    public boolean estaAbierta() {
        return abierta;
    }
 
    public void setAbierta(boolean abierta) {
        this.abierta = abierta;
    }
 
    @Override
    public String toString() {
        return "Puerta [abierta=" + abierta + "]";
    }
}