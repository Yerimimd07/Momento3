/**
 * Clase Boton: superclase de la jerarquía de botones.
 * Aplica: Encapsulamiento, Herencia (es heredada por BotonPiso y BotonAscensor).
 *
 * Relación UML: Superclase → BotonPiso y BotonAscensor (herencia).
 */
public class Boton {

    // Atributo privado - Encapsulamiento
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

    /**
     * Activa el indicador luminoso y sonoro del botón.
     * Se llama automáticamente al presionar.
     */
    public void activarIndicador() {
        System.out.println("[INDICADOR] Luz encendida  - BIP.");
    }

    /**
     * Desactiva el indicador luminoso y sonoro del botón.
     * Se llama cuando la solicitud fue atendida.
     */
    public void desactivarIndicador() {
        System.out.println("[INDICADOR] Luz apagada.");
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