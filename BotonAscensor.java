/**
 * Botón interno del ascensor para seleccionar un piso destino.
 * También maneja botones especiales: CERRAR_PUERTA y ABRIR_PUERTA.
 *
 * Relación UML:
 *   - Hereda de Boton (herencia)
 *   - Pertenece a Ascensor en arreglo (agregación)
 */
public class BotonAscensor extends Boton {

    // Atributos privados - Encapsulamiento
    private int    pisoDestino;
    private String tipo;        // "PISO", "CERRAR_PUERTA", "ABRIR_PUERTA"

    // Constructor para botones de piso (tipo normal)
    public BotonAscensor(int pisoDestino) {
        super(false);
        this.pisoDestino = pisoDestino;
        this.tipo        = "PISO";
    }

    // Constructor para botones especiales
    public BotonAscensor(String tipo) {
        super(false);
        this.pisoDestino = -1;   // No aplica para botones especiales
        this.tipo        = tipo;
    }

    /**
     * Sobreescritura del método presionar().
     * Polimorfismo: comportamiento específico según el tipo de botón.
     */
    @Override
    public void presionar() {
        setPresionado(true);
        if (tipo.equals("CERRAR_PUERTA")) {
            System.out.println("[BOTON ASCENSOR] Botón CERRAR PUERTA presionado.");
        } else if (tipo.equals("ABRIR_PUERTA")) {
            System.out.println("[BOTON ASCENSOR] Botón ABRIR PUERTA presionado.");
        } else {
            System.out.println("[BOTON ASCENSOR] Piso " + pisoDestino
                    + " seleccionado desde el interior del ascensor.");
        }
        activarIndicador();   // Enciende la luz y emite sonido
    }

    // Getters - Encapsulamiento
    public int getPisoDestino() {
        return pisoDestino;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        if (tipo.equals("PISO")) {
            return "BotonAscensor [destino=" + pisoDestino + ", presionado=" + estaPresionado() + "]";
        }
        return "BotonAscensor [tipo=" + tipo + ", presionado=" + estaPresionado() + "]";
    }
}