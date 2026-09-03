public class Charla extends Actividad {

    private String disertante;

    public Charla(
            int id,
            String titulo,
            int cupoMaximo,
            String disertante) {

        super(id, titulo, cupoMaximo);

        this.disertante = disertante;
    }

    public Charla(Charla otra) {
        super(otra);

        this.disertante = otra.disertante;
    }

    @Override
    public double calcularCostoMateriales() {
        return 0;
    }

    @Override
    public String getTipo() {
        return "Charla";
    }

    @Override
    public Actividad copiar() {
        return new Charla(this);
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();

        System.out.println("  Disertante: " + disertante);
    }

    public String getDisertante() {
        return disertante;
    }
}
