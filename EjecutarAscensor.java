public class EjecutarAscensor {
    public static void main(String[] args) {
 
        SistemaControl sistema = new SistemaControl(5);
        sistema.mostrarEstado();
        sistema.mostrarPisos();


        System.out.println("\n>>> ESTADO FINAL DEL SISTEMA <<<");
        sistema.mostrarEstado();
        System.out.println("Sistema finalizado correctamente.");
    }
}   
