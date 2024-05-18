import java.util.Date;

public class Donation {

    private String fecha;
    private String documento;
    private String ONG;
    private String projectCode;
    private String cantidad;

    public Donation(String formatoDonacion){
        fecha = formatoDonacion.split(";")[0];
        documento = formatoDonacion.split(";")[1];
        ONG = formatoDonacion.split(";")[2];
        projectCode = formatoDonacion.split(";")[3];
        cantidad = formatoDonacion.split(";")[4];
    }

    public static void main(String[] args) {
        Donation donacion = new Donation("15/04/2023;12345678N;ACN;ACN8455;15.50");
        System.out.println("La fecha de la donacion es " + donacion.getFecha());
        System.out.println(donacion);
    }

    @Override
    public String toString() {
        return "Donación " +
                "Fecha:'" + fecha + '\'' +
                ", Documento:'" + documento + '\'' +
                ", ONG:'" + ONG + '\'' +
                ", Código de proyecto:'" + projectCode + '\'' +
                ", Cantidad = " + cantidad + "€";
    }

    public String getFecha() {
        return fecha;
    }

    public String getDocumento() {
        return documento;
    }

    public String getONG() {
        return ONG;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public String getCantidad() {
        return cantidad;
    }
}
