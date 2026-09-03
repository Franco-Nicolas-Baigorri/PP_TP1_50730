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

        this.sala = otro.sala;

        for (Actividad actividad : otro.actividades) {
            actividades.add(actividad.copiar());
        }
    }

    public double calcularCostoEstimado() {
        if (gratuito) {
            return 0;
        }

        double subtotal = costoBase;

        for (Actividad actividad : actividades) {
            subtotal += actividad.calcularCostoMateriales();
        }

        return subtotal * 1.21;
    }

    public void asignarSala(Sala sala) {
        if (sala == null) {
            throw new IllegalArgumentException(
                    "La sala no puede ser null."
            );
        }

        this.sala = sala;
    }

    // Versión con valores predeterminados para los datos específicos.
    public void crearActividad(
            int id,
            String titulo,
            int cupo,
            String tipo) {

        crearActividad(
                id,
                titulo,
                cupo,
                tipo,
                "Sin informar",
                false
        );
    }

    // Versión que permite configurar los datos de Charla y Taller.
    public void crearActividad(
            int id,
            String titulo,
            int cupo,
            String tipo,
            String disertante,
            boolean requiereNotebook) {

        for (Actividad actividad : actividades) {
            if (actividad.getId() == id) {
                throw new IllegalArgumentException(
                        "Ya existe una actividad con ese ID en el evento."
                );
            }
        }

        if (tipo == null) {
            throw new IllegalArgumentException(
                    "Debe indicar el tipo de actividad."
            );
        }

        Actividad nuevaActividad;

        if (tipo.trim().equalsIgnoreCase("Charla")) {
            nuevaActividad =
                    new Charla(id, titulo, cupo, disertante);

        } else if (tipo.trim().equalsIgnoreCase("Taller")) {
            nuevaActividad =
                    new Taller(id, titulo, cupo, requiereNotebook);

        } else {
            throw new IllegalArgumentException(
                    "Tipo no válido. Debe ser Charla o Taller."
            );
        }

        actividades.add(nuevaActividad);
    }

    public void mostrarDatos() {
        System.out.println("----------------------------------------");
        System.out.println("Evento: " + titulo);
        System.out.println("ID: " + id);

        System.out.printf("Costo base: $%.2f%n", costoBase);

        System.out.printf(
                "Costo total estimado: $%.2f%n",
                calcularCostoEstimado()
        );

        if (gratuito) {
            System.out.println("Gratuito: Sí");
        } else {
            System.out.println("Gratuito: No");
            System.out.println("El total incluye el 21% de impuestos.");
        }

        if (sala == null) {
            System.out.println("Sala: Sin asignar");
        } else {
            System.out.println(
                    "Sala: " + sala.getNombre()
                            + " | ID: " + sala.getId()
            );
        }

        System.out.println(
                "Cantidad de actividades: " + actividades.size()
        );

        if (actividades.isEmpty()) {
            System.out.println("No hay actividades registradas.");
        } else {
            for (Actividad actividad : actividades) {
                System.out.println();

                // Llamada polimórfica: puede ser una Charla o un Taller.
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
