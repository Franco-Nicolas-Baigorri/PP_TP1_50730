import java.util.ArrayList;
import java.util.List;

public abstract class Actividad {

    private int id;
    private String titulo;
    private int cupoMaximo;

    public static final int CUPO_MINIMO = 1;

    private List<Inscripcion> inscripciones;

    public Actividad(int id, String titulo, int cupoMaximo) {
        if (cupoMaximo < CUPO_MINIMO) {
            throw new IllegalArgumentException(
                    "El cupo debe ser al menos " + CUPO_MINIMO
            );
        }

        this.id = id;
        this.titulo = titulo;
        this.cupoMaximo = cupoMaximo;
        this.inscripciones = new ArrayList<>();
    }

    // Constructor utilizado por las subclases para copiar datos.
    protected Actividad(Actividad otra) {
        this(otra.id, otra.titulo, otra.cupoMaximo);

        for (Inscripcion inscripcion : otra.inscripciones) {
            inscripciones.add(new Inscripcion(inscripcion, this));
        }
    }

    public Inscripcion inscribir(Estudiante estudiante) {
        if (estudiante == null) {
            throw new IllegalArgumentException(
                    "El estudiante no puede ser null."
            );
        }

        for (Inscripcion inscripcion : inscripciones) {
            if (inscripcion.getEstudiante().getLegajo()
                    .equals(estudiante.getLegajo())) {

                throw new IllegalArgumentException(
                        "El estudiante ya está inscripto en esta actividad."
                );
            }
        }

        if (inscripciones.size() >= cupoMaximo) {
            throw new IllegalStateException(
                    "No quedan lugares disponibles en " + titulo
            );
        }

        Inscripcion nuevaInscripcion =
                new Inscripcion(estudiante, this);

        inscripciones.add(nuevaInscripcion);

        return nuevaInscripcion;
    }

    public void mostrarInscripciones() {
        if (inscripciones.isEmpty()) {
            System.out.println("    No hay estudiantes inscriptos.");
        } else {
            for (Inscripcion inscripcion : inscripciones) {
                inscripcion.mostrarDatos();
            }
        }
    }

    // No puede redefinirse en Charla ni en Taller.
    public final void mostrarIdentificacion() {
        System.out.println(
                "  " + getTipo()
                        + " | ID: " + id
                        + " | Título: " + titulo
        );
    }

    public void mostrarDatos() {
        mostrarIdentificacion();

        System.out.println("  Cupo máximo: " + cupoMaximo);
        System.out.println("  Inscriptos: " + inscripciones.size());

        System.out.printf(
                "  Costo de materiales: $%.2f%n",
                calcularCostoMateriales()
        );

        mostrarInscripciones();
    }

    // Cada subclase debe implementar estos métodos.
    public abstract double calcularCostoMateriales();

    public abstract String getTipo();

    // Método auxiliar para conservar el constructor de copia del evento.
    public abstract Actividad copiar();

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getCupoMaximo() {
        return cupoMaximo;
    }

    public List<Inscripcion> getInscripciones() {
        return List.copyOf(inscripciones);
    }
}
