public class Ascensor {
 
    // Atributos privados - Encapsulamiento
    private int             pisoActual;
    private PuertaAscensor  puerta;       
    private BotonAscensor[] botones;      

    // Constructor con argumentos
    public Ascensor(int totalPisos) {
        this.pisoActual = 1;
        // Composición: la puerta nace junto con el ascensor
        this.puerta  = new PuertaAscensor("Cabina central");
        // Arreglo: un botón interno por cada piso
        this.botones = new BotonAscensor[totalPisos];
        for (int i = 0; i < totalPisos; i++) {
            botones[i] = new BotonAscensor(i + 1);
        }
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
 
    // Getters y Setters 
    public int getPisoActual() {
        return pisoActual;
    }
 
    public void setPisoActual(int pisoActual) {
        this.pisoActual = pisoActual;
    }
 
    public PuertaAscensor getPuerta() {
        return puerta;
    }
 
    public BotonAscensor[] getBotones() {
        return botones;
    }
 
    @Override
    public String toString() {
        return "Ascensor [pisoActual=" + pisoActual + ", " + puerta + "]";
    }
}
 