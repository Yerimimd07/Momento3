public class EjecutarAscensor {
    public static void main(String[] args) {

        SistemaControl sistema = new SistemaControl(5);
        sistema.mostrarEstado();
        sistema.mostrarPisos();

        // Ascensor en piso 1, alguien del piso 3 llama, luego pide ir al piso 5
        System.out.println(">>> Persona en piso 3 llama al ascensor <<<");
        sistema.presionarBotonPiso(3, "SUBIR"); // llama desde piso 3
        sistema.procesarSolicitudes(); // ascensor va al piso 3

        System.out.println(">>> Desde adentro presiona botonPiso 5 <<<");
        sistema.abrirPuertaManual(3);
        sistema.presionarBotonAscensor(5); // dentro del ascensor pide piso 5
        sistema.procesarSolicitudes(); // ascensor va al piso 5

        System.out.println("\n>>> ESTADO FINAL DEL SISTEMA <<<");
        sistema.mostrarEstado();
        System.out.println("Sistema finalizado correctamente.");
    }
}
