//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class App {
    public static void main(String[] args) {
        EventoUniversitario Evento1= new EventoUniversitario("Ev01","Charla de Java",5000,false);
        EventoUniversitario Evento2= new EventoUniversitario("EV02","Jornada de Programación",0,true);
        EventoUniversitario copiaEvento1= new EventoUniversitario(Evento1);
        EventoUniversitario copiaEvento2= new EventoUniversitario(Evento2);
        System.out.println("EVENTO ORIGINAL 1");
        Evento1.mostrarDatos();

        System.out.println("\nCOPIA DEL EVENTO 1");
        copiaEvento1.mostrarDatos();

        System.out.println("\nEVENTO ORIGINAL 2");
        Evento2.mostrarDatos();

        System.out.println("\nCOPIA DEL EVENTO 2");
        copiaEvento2.mostrarDatos();

        System.out.println(
                "\nCantidad total de eventos: "
                        + EventoUniversitario.getCantidadEventos());

    }

}