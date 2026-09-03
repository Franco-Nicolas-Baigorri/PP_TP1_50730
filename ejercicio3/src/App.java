import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {

        // a. Registrar estudiantes.
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
                        3000,
                        true
                );

        // c. Asignar salas.
        Sala sala1 = new Sala(1, "Aula Magna");
        Sala sala2 = new Sala(2, "Laboratorio de Informática");

        evento1.asignarSala(sala1);
        evento2.asignarSala(sala2);

        // d. Crear actividades de diferentes tipos.

        // En una Charla se utiliza el disertante.
        // El parámetro de notebook se ignora.
        evento1.crearActividad(
                1,
                "Introducción a Java",
                30,
                "Charla",
                "Laura Gómez",
                false
        );

        // En un Taller se utiliza requiereNotebook.
        // El parámetro de disertante se ignora.
        evento1.crearActividad(
                2,
                "Programación orientada a objetos",
                20,
                "Taller",
                "",
                true
        );

        evento1.crearActividad(
                3,
                "Diseño de diagramas UML",
                20,
                "Taller",
                "",
                false
        );

        evento2.crearActividad(
                4,
                "Seguridad en Internet",
                25,
                "Charla",
                "Martín Pérez",
                false
        );

        evento2.crearActividad(
                5,
                "Análisis de redes",
                15,
                "Taller",
                "",
                true
        );

        // e. Inscribir estudiantes.
        Actividad charlaJava =
                evento1.getActividades().get(0);

        Actividad tallerPoo =
                evento1.getActividades().get(1);

        Actividad tallerUml =
                evento1.getActividades().get(2);

        Actividad charlaSeguridad =
                evento2.getActividades().get(0);

        Actividad tallerRedes =
                evento2.getActividades().get(1);

        charlaJava.inscribir(estudiantes.get(0));
        charlaJava.inscribir(estudiantes.get(1));

        tallerPoo.inscribir(estudiantes.get(0));
        tallerPoo.inscribir(estudiantes.get(2));

        tallerUml.inscribir(estudiantes.get(1));

        charlaSeguridad.inscribir(estudiantes.get(1));
        charlaSeguridad.inscribir(estudiantes.get(2));

        tallerRedes.inscribir(estudiantes.get(0));

        // f. Mostrar el resumen de cada evento.
        System.out.println("RESUMEN DE EVENTOS\n");

        evento1.mostrarDatos();

        System.out.println();

        evento2.mostrarDatos();

        // Recorrido mediante referencias de tipo Actividad.
        System.out.println("\nIDENTIFICACIÓN DE LAS ACTIVIDADES");

        for (Actividad actividad : evento1.getActividades()) {
            actividad.mostrarIdentificacion();
        }

        for (Actividad actividad : evento2.getActividades()) {
            actividad.mostrarIdentificacion();
        }

        // g. Mostrar el total de eventos.
        System.out.println(
                "\nCantidad total de eventos: "
                        + EventoUniversitario.getCantidadEventos()
        );
    }
}