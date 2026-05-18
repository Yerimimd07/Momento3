public class Ascensor {
 
    // Atributos privados - Encapsulamiento
    private int             pisoActual;
    private PuertaAscensor  puerta;            // COMPOSICIÓN
    private BotonAscensor[] botones;           // ARREGLO botones de piso
    private BotonAscensor   botonCerrar;       // Botón especial: cerrar puerta
    private BotonAscensor   botonAbrir;     // Botón especial: abrir puerta
 
    // Constructor con argumentos
    public Ascensor(int totalPisos) {
        this.pisoActual    = 1;
        this.puerta        = new PuertaAscensor("Cabina central");
 
        // Botones de piso - uno por cada piso
        this.botones       = new BotonAscensor[totalPisos];
        for (int i = 0; i < totalPisos; i++) {
            botones[i] = new BotonAscensor(i + 1);
        }
 
        // Botones especiales dentro del ascensor
        this.botonCerrar   = new BotonAscensor("CERRAR_PUERTA");
        this.botonAbrir = new BotonAscensor("ABRIR_PUERTA");
 
        System.out.println("[ASCENSOR] Iniciado en piso 1. Pisos disponibles: " + totalPisos);
    }
 
    // Métodos de movimiento
    public void subir() {
        pisoActual++;
        System.out.println("[ASCENSOR] Subiendo... piso actual: " + pisoActual);
    }
 
    public void bajar() {
        pisoActual--;
        System.out.println("[ASCENSOR] Bajando... piso actual: " + pisoActual);
    }
 
    // Getters y Setters - Encapsulamiento
    public int getPisoActual() {
        return pisoActual;
    }
 
    public void setPisoActual(int pisoActual) {
        this.pisoActual = pisoActual;
    }
 
    public PuertaAscensor getPuerta() {
        return puerta;
    }
 
    public BotonAscensor[] getBotones()      { return botones; }
    public BotonAscensor   getBotonCerrar()  { return botonCerrar; }
    public BotonAscensor   getBotonAbrir(){ return botonAbrir; }
 
    @Override
    public String toString() {
        return "Ascensor [pisoActual=" + pisoActual + ", " + puerta + "]";
    }
}