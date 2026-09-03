import java.util.ArrayList;
import java.util.List;

public class EventoUniversitario {

    private final String id;
    private String titulo;
    private double costoBase;
    private boolean gratuito;

    private static int cantidadEventos;

    private Sala sala;
    private List<Actividad> actividades;

    public EventoUniversitario(
            String id,
            String titulo,
            double costoBase,
            boolean gratuito) {

        this.id = id;
        this.titulo = titulo;
        this.costoBase = costoBase;
        this.gratuito = gratuito;
        this.actividades = new ArrayList<>();

        cantidadEventos++;
    }

    public EventoUniversitario(EventoUniversitario otro) {
        this(
                otro.id,
                otro.titulo,
                otro.costoBase,
                otro.gratuito
        );

        // La sala puede compartirse entre eventos.
        this.sala = otro.sala;

        // Cada evento conserva sus propias actividades.
        for (Actividad actividad : otro.actividades) {
            this.actividades.add(new Actividad(actividad));
        }

        // No incrementamos otra vez:
        // el constructor principal ya lo hizo.
    }

    public double calcularCostoEstimado() {
        if (gratuito) {
            return 0;
        } else {
            return costoBase;
        }
    }

    public void asignarSala(Sala sala) {
        if (sala == null) {
            throw new IllegalArgumentException(
                    "La sala no puede ser null."
            );
        }

        this.sala = sala;
    }

    public void crearActividad(int id, String titulo, int cupo) {
        for (Actividad actividad : actividades) {
            if (actividad.getId() == id) {
                throw new IllegalArgumentException(
                        "Ya existe una actividad con ese ID en el evento."
                );
            }
        }

        Actividad nuevaActividad = new Actividad(id, titulo, cupo);

        actividades.add(nuevaActividad);
    }

    public void mostrarDatos() {
        System.out.println("----------------------------------------");
        System.out.println("Evento: " + titulo);
        System.out.println("ID: " + id);
        System.out.println("Costo base: $" + costoBase);
        System.out.println(
                "Costo estimado: $" + calcularCostoEstimado()
        );

        if (gratuito) {
            System.out.println("Gratuito: Sí");
        } else {
            System.out.println("Gratuito: No");
        }

        if (sala == null) {
            System.out.println("Sala: Sin asignar");
        } else {
            System.out.println(
                    "Sala: " + sala.getNombre()
                            + " | ID: " + sala.getId()
            );
        }

        System.out.println("Cantidad de actividades: " + actividades.size());

        if (actividades.isEmpty()) {
            System.out.println("No hay actividades registradas.");
        } else {
            for (Actividad actividad : actividades) {
                System.out.println();
                actividad.mostrarDatos();
            }
        }
    }

    public List<Actividad> getActividades() {
        return List.copyOf(actividades);
    }

    public static int getCantidadEventos() {
        return cantidadEventos;
    }
}
