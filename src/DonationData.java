import java.util.*;

public class DonationData {
    private TreeMap<String, Donation> donacionesTotales;

    public void donationDataInit() {
        donacionesTotales = new TreeMap<>();
    }

    public Donation donationParse(String formatoDonacion) {
        return new Donation(formatoDonacion);
    }

    /**
     * Añade una donación al TreeMap
     * @param donacion
     */
    public void donationDataAdd(Donation donacion) {
        if (!donacionesTotales.containsKey(donacion.getProjectCode())) {
            donacionesTotales.put(donacion.getProjectCode(), donacion);
            System.out.println("\n[+] Se ha añadido el registro de la donación con código: " + donacion.getProjectCode());
        } else {
            System.out.println("\n[!] La donación " + donacion.getProjectCode() + " ya está registrada");
        }
    }

    /**
     * Muestra por pantalla una donación
     * @param codDonacion
     */
    public void donationDataGet(String codDonacion) {
        if (donacionesTotales.containsKey(codDonacion)) {
            System.out.println(donacionesTotales.get(codDonacion));
        } else {
            System.out.println("\n[!] La donación " + codDonacion + " no existe");
        }

    }

    /**
     * Busca una donación y la elimina
     * @param fecha
     * @param documento
     * @param codProyecto
     */
    public void donationDataDel(String fecha, String documento, String codProyecto) {
        Iterator<Map.Entry<String, Donation>> iterador = donacionesTotales.entrySet().iterator();

        while (iterador.hasNext()) {
            Map.Entry<String, Donation> actual = iterador.next();
            Donation donacion = actual.getValue();
            if (donacion.getFecha().equals(fecha) &&
                    donacion.getDocumento().equals(documento) &&
                    donacion.getProjectCode().equals(codProyecto)) {
                iterador.remove();
                System.out.println("\n[+] Se ha eliminado el registro de la donación con código: " + codProyecto);
                return;
            }
        }
        System.out.println("\n[!] La donación " + codProyecto + " no existe");
    }

    /**
     * Muestra un TreeMap completo
     * Usado en forma de traza para comprobar el orden de los registros del TreeMap
     *
     * @param Mapa
     */
    public void imprimirTreeMap(TreeMap<String, Donation> Mapa) {
        for (String key : Mapa.keySet()) {
            System.out.println(key + " -> " + Mapa.get(key));
        }
    }

    public String crearRegistroDon(){
        Scanner sc = new Scanner(System.in);
        String cadena = "";
        System.out.print("Introduce una fecha (dd/mm/aaaa): ");
        cadena += sc.nextLine() + ";";
        System.out.print("Introduce una documento: ");
        cadena += sc.nextLine() + ";";
        System.out.print("Introduce una código ONG: ");
        cadena += sc.nextLine() + ";";
        System.out.print("Introduce una código de proyecto: ");
        cadena += sc.nextLine() + ";";
        System.out.print("Introduce una cantidad: ");
        cadena += sc.nextLine();

        return cadena;
    }

    public static void main(String[] args) {
        DonationData registro = new DonationData();

        registro.donationDataInit();

        //a) Añada 4 donaciones que túquieras.
        System.out.println("\nApartado a)");
        Donation donacion1 = registro.donationParse("15/04/2023;12345678N;ACN;ACN8455;15.50");
        Donation donacion2 = registro.donationParse("20/05/2023;87654321A;XYZ;XYZ1234;25.75");
        Donation donacion3 = registro.donationParse("01/06/2023;11223344B;LMN;LMN5678;50.00");
        Donation donacion4 = registro.donationParse("12/07/2023;55667788C;OPQ;OPQ9012;100.99");

        registro.donationDataAdd(donacion1);
        registro.donationDataAdd(donacion2);
        registro.donationDataAdd(donacion3);
        registro.donationDataAdd(donacion4);

        //b) Añada 2 donaciones más
        System.out.println("\nApartado b)");
        Donation donacion5 = registro.donationParse("08/08/2023;99887766D;RST;RST3456;75.25");
        Donation donacion6 = registro.donationParse("15/09/2023;44556677E;UVW;UVW7890;30.45");

        registro.donationDataAdd(donacion5);
        registro.donationDataAdd(donacion6);

        //c) Añade 1 donación ya existente
        System.out.println("\nApartado c)");

        registro.donationDataAdd(donacion5);


        //d) Elimina 2 donaciones existentes.
        System.out.println("\nApartado d)");

        registro.donationDataDel("01/06/2023", "11223344B", "LMN5678");
        registro.donationDataDel("08/08/2023", "99887766D", "RST3456");

        //e) Elimina 1 donación NO existente
        System.out.println("\nApartado e)");

        registro.donationDataDel("22/10/2023", "22334455F", "XYZ6789");

        System.out.println("\n[++] Ejercicio del menú para iterar por los registros de las donaciones");

        int opcion;

        Scanner sc = new Scanner(System.in);

        NavigableSet<String> indiceClaves = new TreeSet<>(registro.donacionesTotales.keySet());

        String claveActual = "";
        int numeroDonacion = 0;
        do {
            menu();
            opcion = sc.nextInt();

            switch (opcion){
                case 0:
                    System.out.println("\n[!] Saliendo...");
                    break;
                case 1:
                    String primeraDonacion = registro.donacionesTotales.firstKey();
                    System.out.println("Primera donación: " + registro.donacionesTotales.get(primeraDonacion));
                    break;
                case 2:
                    String siguienteClave = indiceClaves.higher(claveActual);
                    if(siguienteClave!=null){
                        claveActual = siguienteClave;
                        numeroDonacion++;
                        System.out.println(numeroDonacion + " - " + registro.donacionesTotales.get(claveActual));
                    } else {
                        System.out.println("\n[!] Estás en el último registro");
                    }
                    break;
                case 3:
                    String anteriorClave = indiceClaves.lower(claveActual);
                    if(anteriorClave!=null){
                        claveActual = anteriorClave;
                        numeroDonacion--;
                        System.out.println(numeroDonacion + " - " + registro.donacionesTotales.get(claveActual));
                    } else {
                        System.out.println("\n[!] Estás en el último registro");

                    }
                    break;
                case 4:
                    if (claveActual != "") {
                        System.out.println("Donación actual:");
                        System.out.println(numeroDonacion + " - " + registro.donacionesTotales.get(claveActual));
                    } else {
                        System.out.println("No hay donación actual.");
                    }
                    break;
                case 5:
                    Donation donElim = registro.donacionesTotales.get(claveActual);
                    registro.donationDataDel(donElim.getFecha(), donElim.getDocumento(),donElim.getProjectCode());

                    //Actualizamos el indice de claves para navegar
                    indiceClaves = new TreeSet<>(registro.donacionesTotales.keySet());

                    //Ajustamos la clave actual a la siguiente si existe
                    // o a la anterior y ajustamos numero de donación
                    if (indiceClaves.higher(claveActual) != null) {
                        claveActual = indiceClaves.higher(claveActual);
                    } else if (indiceClaves.lower(claveActual) != null) {
                        claveActual = indiceClaves.lower(claveActual);
                        numeroDonacion--;
                    } else {
                        claveActual = null;
                        numeroDonacion = 0;
                    }
                    break;
                case 6:
                    String cadenaDon = registro.crearRegistroDon();
                    Donation donationAdd = registro.donationParse(cadenaDon);
                    registro.donationDataAdd(donationAdd);

                    //Actualizamos el indice de claves para navegar
                    indiceClaves = new TreeSet<>(registro.donacionesTotales.keySet());
                    break;
                case 7:
                    for(String key : registro.donacionesTotales.keySet()){
                        System.out.println(registro.donacionesTotales.get(key));
                    }
                    break;
                default:
                    System.out.println("\n[!] Opción no válida, introduce un número del 0 al 7");
                    break;
            }


        } while (opcion != 0);
    }

    public static void menu() {
        System.out.println("\nMenú de Donaciones:");
        System.out.println("0. Salir");
        System.out.println("1. Muestra la primera donación.");
        System.out.println("2. Salta a la siguiente donación.");
        System.out.println("3. Salta a la donación anterior.");
        System.out.println("4. Muestra la donación actual.");
        System.out.println("5. Elimina la donación actual.");
        System.out.println("6. Añade una nueva donación.");
        System.out.println("7. Imprimir todas las donaciones.");
        System.out.print("\nIntroduce una opción: ");
    }
}
