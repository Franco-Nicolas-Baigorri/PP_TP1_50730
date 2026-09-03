import java.time.LocalDate;

public class Inscripcion {

    private LocalDate fecha;
    private String estado;
    private Estudiante estudiante;
    private Actividad actividad;

    public Inscripcion(Estudiante estudiante, Actividad actividad) {
        this.estudiante = estudiante;
        this.actividad = actividad;
        this.fecha = LocalDate.now();
        this.estado = "Confirmada";
    }

    // Permite copiar una inscripción para una actividad nueva.
    public Inscripcion(Inscripcion otra, Actividad nuevaActividad) {
        this.estudiante = otra.estudiante;
        this.actividad = nuevaActividad;
        this.fecha = otra.fecha;
        this.estado = otra.estado;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getEstado() {
        return estado;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void mostrarDatos() {
        System.out.println(
                "    Estudiante: " + estudiante.getNombre()
                        + " | Legajo: " + estudiante.getLegajo()
                        + " | Fecha: " + fecha
                        + " | Estado: " + estado
        );
    }
}