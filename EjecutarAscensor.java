public class EjecutarAscensor {
    public static void main(String[] args) {
 
        SistemaControl sistema = new SistemaControl(5);
        sistema.mostrarEstado();
        sistema.mostrarPisos();

        sistema.presionarBotonPiso(3, "SUBIR");
        sistema.presionarBotonAscensor(1);

        sistema.mostrarEstado();

        sistema.presionarBotonPiso(4,"BAJAR");
        sistema.presionarBotonAscensor(2);


        sistema.presionarBotonAscensor(-1);

        


        System.out.println("\n>>> ESTADO FINAL DEL SISTEMA <<<");
        sistema.mostrarEstado();
        System.out.println("Sistema finalizado correctamente.");
    }
}   
