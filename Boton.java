public class Boton {
 
    // Atributo privado 
    private boolean presionado;
 
    // Constructor con argumento
    public Boton(boolean presionado) {
        this.presionado = presionado;
    }
 
    /**
     * Método que las subclases sobreescriben con @Override.
     * Aquí aplica Polimorfismo: cada subclase responde diferente.
     */
    public void presionar() {
        this.presionado = true;
        System.out.println("[BOTON] Botón presionado.");
    }
 
    // Getter y Setter - Encapsulamiento
    public boolean estaPresionado() {
        return presionado;
    }
 
    public void setPresionado(boolean presionado) {
        this.presionado = presionado;
    }
 
    @Override
    public String toString() {
        return "Boton [presionado=" + presionado + "]";
    }
}