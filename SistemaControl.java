/**
 * Sistema de control del ascensor.
 * Coordina el ascensor, los pisos, las puertas y las solicitudes.
 *
 * Relación UML:
 * - ASOCIACIÓN con Ascensor (lo controla)
 * - ASOCIACIÓN con Piso[] (administra todos los pisos)
 * - Usa int[] para la cola de solicitudes (arreglo, sin ArrayList)
 */
public class SistemaControl {

    // Atributos privados - Encapsulamiento
    private Ascensor ascensor;
    private Piso[] pisos; // ARREGLO de pisos
    private int[] solicitudes; // ARREGLO de solicitudes pendientes
    private int totalSolicitudes;

    // Constructor con argumentos
    public SistemaControl(int totalPisos) {
        this.ascensor = new Ascensor(totalPisos);
        this.pisos = new Piso[totalPisos];
        this.solicitudes = new int[totalPisos];
        this.totalSolicitudes = 0;

        for (int i = 0; i < totalPisos; i++) {
            pisos[i] = new Piso(i + 1, totalPisos); // totalPisos define qué botones crear
        }

        System.out.println("================================================");
        System.out.println("   SISTEMA DE CONTROL DE ASCENSOR INICIADO");
        System.out.println("   Total de pisos: " + totalPisos);
        System.out.println("================================================\n");
    }

    // -------------------------------------------------------
    // BOTONES - Polimorfismo en acción
    // -------------------------------------------------------

    /**
     * Presiona el botón de un piso según la dirección indicada.
     * Valida que esa dirección exista en ese piso.
     * Polimorfismo: BotonPiso.presionar() sobreescribe Boton.presionar().
     */
    public void presionarBotonPiso(int numeroPiso, String direccion) {
        if (numeroPiso < 1 || numeroPiso > pisos.length) {
            System.out.println("[SISTEMA] El piso " + numeroPiso + " no existe.");
            return;
        }

        BotonPiso boton = pisos[numeroPiso - 1].getBoton(direccion);

        if (boton == null) {
            System.out.println("[SISTEMA] El piso " + numeroPiso
                    + " no tiene botón de dirección " + direccion + ".");
            System.out.println("[SISTEMA] Recuerda: piso 1 solo tiene SUBIR, "
                    + "piso " + pisos.length + " solo tiene BAJAR.");
            return;
        }

        boton.presionar(); // Polimorfismo: BotonPiso sobreescribe Boton
        registrarSolicitud(numeroPiso);
    }

    // -------------------------------------------------------
    // CONTROL MANUAL DE PUERTAS
    // -------------------------------------------------------

    /**
     * Activa el botón ABRIR PUERTA: abre las puertas y espera
     * hasta que alguien presione el botón CERRAR o pasen 10 segundos.
     */
    public void abrirPuertaManual(int numeroPiso) {
        if (ascensor.getPisoActual() != numeroPiso) {
            System.out.println("[SISTEMA] No se puede abrir la puerta del piso " + numeroPiso
                    + ". El ascensor está en el piso " + ascensor.getPisoActual() + ".");
            return;
        }
        ascensor.getBotonAbrir().presionar();
        abrirPuertas(numeroPiso);
        System.out.println("[SISTEMA] Puertas abiertas manualmente en piso " + numeroPiso + ".");
        pausa();
        System.out.println("[SISTEMA] Cerrando puertas automaticamente...");
        cerrarPuertas(numeroPiso);
        ascensor.getBotonAbrir().desactivarIndicador();
        ascensor.getBotonAbrir().setPresionado(false);
    }

    /**
     * Activa el botón CERRAR PUERTA: cierra las puertas inmediatamente
     * sin esperar el tiempo normal de pausa.
     */
    public void cerrarPuertaManual(int numeroPiso) {
        if (ascensor.getPisoActual() != numeroPiso) {
            System.out.println("[SISTEMA] No se puede cerrar la puerta del piso " + numeroPiso
                    + ". El ascensor está en el piso " + ascensor.getPisoActual() + ".");
            return;
        }
        ascensor.getBotonCerrar().presionar();
        System.out.println("[SISTEMA] Cerrando puertas inmediatamente en piso " + numeroPiso + "...");
        cerrarPuertas(numeroPiso);
        ascensor.getBotonCerrar().desactivarIndicador();
        ascensor.getBotonCerrar().setPresionado(false);
    }

    /**
     * Presiona un botón interno del ascensor (selecciona destino).
     * Polimorfismo: BotonAscensor.presionar() sobreescribe Boton.presionar().
     */
    public void presionarBotonAscensor(int pisoDestino) {
        if (pisoDestino < 1 || pisoDestino > ascensor.getBotones().length) {
            System.out.println("[SISTEMA] El destino " + pisoDestino + " no existe.");
            return;
        }
        BotonAscensor boton = ascensor.getBotones()[pisoDestino - 1];
        boton.presionar(); // Polimorfismo: BotonAscensor sobreescribe Boton
        registrarSolicitud(pisoDestino);
    }

    // -------------------------------------------------------
    // SOLICITUDES
    // -------------------------------------------------------

    public void registrarSolicitud(int piso) {
        for (int i = 0; i < totalSolicitudes; i++) {
            if (solicitudes[i] == piso) {
                System.out.println("[SISTEMA] Piso " + piso + " ya estaba en la cola.");
                return;
            }
        }
        solicitudes[totalSolicitudes] = piso;
        totalSolicitudes++;
        System.out.println("[SISTEMA] Solicitud registrada: piso " + piso + ".");
    }

    private void eliminarPrimeraSolicitud() {
        for (int i = 0; i < totalSolicitudes - 1; i++) {
            solicitudes[i] = solicitudes[i + 1];
        }
        totalSolicitudes--;
    }

    public void procesarSolicitudes() {
        if (totalSolicitudes == 0) {
            System.out.println("[SISTEMA] No hay solicitudes pendientes.");
            return;
        }
        System.out.println("\n[SISTEMA] Procesando " + totalSolicitudes + " solicitud(es)...");
        while (totalSolicitudes > 0) {
            int destino = solicitudes[0];
            moverAscensor(destino);
            eliminarPrimeraSolicitud();
        }
        System.out.println("[SISTEMA] Todas las solicitudes atendidas.\n");
    }

    // -------------------------------------------------------
    // MOVIMIENTO
    // -------------------------------------------------------

    public void moverAscensor(int pisoDestino) {
        int pisoActual = ascensor.getPisoActual();
        System.out.println("\n[SISTEMA] Moviendo ascensor al piso " + pisoDestino + "...");
        System.out.println("[SISTEMA] Posición actual: piso " + pisoActual);

        if (pisoActual == pisoDestino) {
            System.out.println("[SISTEMA] El ascensor ya está en el piso " + pisoDestino + ".");
            abrirPuertas(pisoDestino);
            System.out.println("[SISTEMA] Puertas abiertas... esperando pasajeros...");
            pausa();
            System.out.println("[SISTEMA] Cerrando puertas...");
            cerrarPuertas(pisoDestino);
            return;
        }

        cerrarPuertas(pisoActual);

        while (ascensor.getPisoActual() != pisoDestino) {
            if (ascensor.getPisoActual() < pisoDestino) {
                ascensor.subir();
            } else {
                ascensor.bajar();
            }
        }

        abrirPuertas(pisoDestino);
        System.out.println("[SISTEMA] Puertas abiertas... esperando pasajeros...");
        pausa();
        System.out.println("[SISTEMA] Cerrando puertas...");
        cerrarPuertas(pisoDestino);
        System.out.println("[SISTEMA] Ascensor llegó al piso " + pisoDestino + ". Solicitud atendida.");
        // Apagar indicador del botón de piso si existe
        BotonPiso boton = pisos[pisoDestino - 1].getBoton("SUBIR");
        if (boton == null)
            boton = pisos[pisoDestino - 1].getBoton("BAJAR");
        if (boton != null)
            boton.desactivarIndicador();
        System.out.println("[SISTEMA] Viaje al piso " + pisoDestino + " completado.\n");
    }

    // -------------------------------------------------------
    // PUERTAS - Polimorfismo en acción
    // -------------------------------------------------------

    private void abrirPuertas(int numeroPiso) {
        ascensor.getPuerta().abrir(); // PuertaAscensor sobreescribe Puerta
        pisos[numeroPiso - 1].getPuerta().abrir(); // PuertaPiso sobreescribe Puerta
    }

    private void cerrarPuertas(int numeroPiso) {
        ascensor.getPuerta().cerrar(); // PuertaAscensor sobreescribe Puerta
        pisos[numeroPiso - 1].getPuerta().cerrar(); // PuertaPiso sobreescribe Puerta
    }

    // -------------------------------------------------------
    // ESTADO
    // -------------------------------------------------------

    public void mostrarEstado() {
        System.out.println("\n========== ESTADO DEL SISTEMA ==========");
        System.out.println("Ascensor en piso  : " + ascensor.getPisoActual());
        System.out.println("Puerta ascensor   : " + (ascensor.getPuerta().estaAbierta() ? "ABIERTA" : "CERRADA"));
        System.out.print("Solicitudes cola  : [");
        for (int i = 0; i < totalSolicitudes; i++) {
            System.out.print(solicitudes[i]);
            if (i < totalSolicitudes - 1)
                System.out.print(", ");
        }
        System.out.println("]");
        System.out.println("=========================================\n");
    }

    public void mostrarPisos() {
        System.out.println("---------- ESTADO DE LOS PISOS ----------");
        for (int i = 0; i < pisos.length; i++) {
            System.out.println(pisos[i]);
        }
        System.out.println("-----------------------------------------\n");
    }

    // Getters
    public Ascensor getAscensor() {
        return ascensor;
    }

    public Piso[] getPisos() {
        return pisos;
    }

    private void pausa() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("[SISTEMA] Pausa interrumpida.");
        }
    }
}