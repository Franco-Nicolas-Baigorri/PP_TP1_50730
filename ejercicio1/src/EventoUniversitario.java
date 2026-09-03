public class EventoUniversitario {
    private final String id;
    private String titulo;
    private double costoBase;
    private boolean gratuito;
    private static int cantidadEventos;//ATRIBUTO DE LA CLASE

    public EventoUniversitario(String Id,String Titulo,double CostoBase, boolean Gratuito){
        this.id=Id;
        this.titulo=Titulo;
        this.costoBase=CostoBase;
        this.gratuito=Gratuito;
        cantidadEventos++;

    }
    public EventoUniversitario(EventoUniversitario eventocopia){
        this.id= eventocopia.id;
        this.titulo= eventocopia.titulo;
        this.costoBase=eventocopia.costoBase;
        this.gratuito= eventocopia.gratuito;
        cantidadEventos++;//el constructor copia tambien debe incrementarse

    }
    public double calcularCostoEstimado() {
        if (this.gratuito) {
            return 0;
        } else {
            return costoBase;
        }
    }
    //public void asignarSala{}
    public void mostrarDatos(){
        System.out.println("ID:  " +this.id);
        System.out.println("Titulo: " +this.titulo);
        System.out.println("Costo: $" +this.costoBase);
        if(this.gratuito){
            System.out.println("Gratuito: sí");

        }else{
            System.out.println("Gratuito: No");
        }

    }
    public static int getCantidadEventos(){
        return cantidadEventos;
    }
}
