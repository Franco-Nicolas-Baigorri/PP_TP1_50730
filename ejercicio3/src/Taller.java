public class Taller extends Actividad {

    private boolean requiereNotebook;

    public Taller(
            int id,
            String titulo,
            int cupoMaximo,
            boolean requiereNotebook) {

        super(id, titulo, cupoMaximo);

        this.requiereNotebook = requiereNotebook;
    }

    public Taller(Taller otro) {
        super(otro);

        this.requiereNotebook = otro.requiereNotebook;
    }

    @Override
    public double calcularCostoMateriales() {
        if (requiereNotebook) {
            return 5000;
        } else {
            return 2000;
        }
    }

    @Override
    public String getTipo() {
        return "Taller";
    }

    @Override
    public Actividad copiar() {
        return new Taller(this);
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();

        if (requiereNotebook) {
            System.out.println("  Requiere notebook: Sí");
        } else {
            System.out.println("  Requiere notebook: No");
        }
    }

    public boolean isRequiereNotebook() {
        return requiereNotebook;
    }
}