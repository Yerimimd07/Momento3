public class Piso {
 
    // Atributos privados - Encapsulamiento
    private int         numero;
    private PuertaPiso  puerta;          // COMPOSICIÓN
    private BotonPiso[] botones;         // ARREGLO: 1 o 2 botones según el piso
 
    // Constructor con argumentos
    public Piso(int numero, int totalPisos) {
        this.numero = numero;
        this.puerta = new PuertaPiso(numero);
 
        // Lógica de botones según posición del piso
        if (numero == 1) {
            // Primer piso: solo puede subir
            botones    = new BotonPiso[1];
            botones[0] = new BotonPiso(numero, "SUBIR");
 
        } else if (numero == totalPisos) {
            // Último piso: solo puede bajar
            botones    = new BotonPiso[1];
            botones[0] = new BotonPiso(numero, "BAJAR");
 
        } else {
            // Pisos intermedios: puede subir y bajar
            botones    = new BotonPiso[2];
            botones[0] = new BotonPiso(numero, "SUBIR");
            botones[1] = new BotonPiso(numero, "BAJAR");
        }
    }
 
    /**
     * Devuelve el botón según la dirección solicitada.
     * Retorna null si esa dirección no existe en este piso.
     */
    public BotonPiso getBoton(String direccion) {
        for (int i = 0; i < botones.length; i++) {
            if (botones[i].getDireccion().equals(direccion)) {
                return botones[i];
            }
        }
        return null; // No existe ese botón en este piso
    }
 
    // Getters - Encapsulamiento
    public int getNumero() {
        return numero;
    }
 
    public PuertaPiso getPuerta() {
        return puerta;
    }
 
    public BotonPiso[] getBotones() {
        return botones;
    }
 
    @Override
    public String toString() {
        String puertaEstado = puerta.estaAbierta() ? "ABIERTA" : "CERRADA";
        String botonesList  = "";
        for (int i = 0; i < botones.length; i++) {
            botonesList += botones[i].getDireccion();
            if (i < botones.length - 1) botonesList += " / ";
        }
        return "Piso " + numero + " | Puerta: " + puertaEstado + " | Botones: " + botonesList;
    }
}
 