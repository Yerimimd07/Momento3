public class EjecutarAscensor {
    public static void main(String[] args) {
 
        SistemaControl sistema = new SistemaControl(5);
        sistema.mostrarEstado();
        sistema.mostrarPisos();

        sistema.presionarBotonPiso(3);   // Polimorfismo: BotonPiso.presionar()
        sistema.procesarSolicitudes();
        sistema.mostrarEstado();
 
        sistema.presionarBotonAscensor(5); // Polimorfismo: BotonAscensor.presionar()
        sistema.procesarSolicitudes();
        sistema.mostrarEstado();
 
        sistema.presionarBotonPiso(2);
        sistema.presionarBotonPiso(4);
        sistema.presionarBotonAscensor(1);
        sistema.mostrarEstado();
        sistema.procesarSolicitudes();
        sistema.mostrarEstado();


        sistema.presionarBotonPiso(10);

        System.out.println("\n>>> ESTADO FINAL DEL SISTEMA <<<");
        sistema.mostrarEstado();
        System.out.println("Sistema finalizado correctamente.");
    }
}   
