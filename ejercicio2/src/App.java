import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {

        // a. Construir una lista de estudiantes.
        List<Estudiante> estudiantes = new ArrayList<>();

        estudiantes.add(new Estudiante("50730", "Franco"));
        estudiantes.add(new Estudiante("50731", "Ana"));
        estudiantes.add(new Estudiante("50732", "Lucas"));

        // b. Construir eventos.
        EventoUniversitario evento1 =
                new EventoUniversitario(
                        "EV01",
                        "Jornada de Programación",
                        5000,
                        false
                );

        EventoUniversitario evento2 =
                new EventoUniversitario(
                        "EV02",
                        "Encuentro de Ciberseguridad",
                        0,
                        true
                );

        // c. Crear salas y asignarlas a los eventos.
        Sala sala1 = new Sala(1, "Aula Magna");
        Sala sala2 = new Sala(2, "Laboratorio de Informática");

        evento1.asignarSala(sala1);
        evento2.asignarSala(sala2);

        // d. Crear actividades propias de cada evento.
        evento1.crearActividad(
                1,
                "Introducción a Java",
                30
        );

        evento1.crearActividad(
                2,
                "Taller de programación orientada a objetos",
                20
        );

        evento2.crearActividad(
                3,
                "Introducción a la seguridad informática",
                25
        );

        // Obtener referencias a las actividades creadas.
        Actividad actividadJava =
                evento1.getActividades().get(0);

        Actividad actividadPoo =
                evento1.getActividades().get(1);

        Actividad actividadSeguridad =
                evento2.getActividades().get(0);

        // e. Inscribir estudiantes en cada actividad.
        actividadJava.inscribir(estudiantes.get(0));
        actividadJava.inscribir(estudiantes.get(1));

        actividadPoo.inscribir(estudiantes.get(0));
        actividadPoo.inscribir(estudiantes.get(2));

        actividadSeguridad.inscribir(estudiantes.get(1));
        actividadSeguridad.inscribir(estudiantes.get(2));

        // f. Mostrar el resumen de cada evento.
        System.out.println("RESUMEN DE EVENTOS\n");

        evento1.mostrarDatos();

        System.out.println();

        evento2.mostrarDatos();

        // g. Mostrar el total de eventos creados.
        System.out.println(
                "\nCantidad total de eventos: "
                        + EventoUniversitario.getCantidadEventos()
        );
    }
}