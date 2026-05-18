public class BotonAscensor extends Boton {
 
    // Atributo privado - Encapsulamiento
    private int pisoDestino;
 
    // Constructor con argumentos
    public BotonAscensor(int pisoDestino) {
        super(false);              // Llama al constructor de Boton
        this.pisoDestino = pisoDestino;
    }
 
    /**
     * Sobreescritura del método presionar().
     * Polimorfismo: comportamiento específico para BotonAscensor.
     */
    @Override
    public void presionar() {
        setPresionado(true);
        System.out.println("[BOTON ASCENSOR] Piso " + pisoDestino
                + " seleccionado desde el interior del ascensor.");
    }
 
    // Getter - Encapsulamiento
    public int getPisoDestino() {
        return pisoDestino;
    }
 
    @Override
    public String toString() {
        return "BotonAscensor [destino=" + pisoDestino + ", presionado=" + estaPresionado() + "]";
    }
}