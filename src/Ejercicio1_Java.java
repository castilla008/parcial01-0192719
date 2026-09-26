import java.util.Scanner;

public class Ejercicio1_Java {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        // creacion del arreglo
        int[] paquetesHoras = new int[10];

        // constantes
        final int longitudPaquetes = paquetesHoras.length;

        // solicitud de datos
        for (int i = 0; i < longitudPaquetes; i++) {

            int paquetes;

            do {
                System.out.print("Ingrese la cantidad de paquetes recibidos en la hora "
                        + (i + 1) + ": ");
                paquetes = sc.nextInt();

                if (paquetes < 0) {
                    System.out.println("Dato invalido, vuelva a intentarlo");
                }

            } while (paquetes < 0);

            paquetesHoras[i] = paquetes;

            System.out.println("---------------------");
        }

        // Suma de todos los paquetes
        int suma = 0;

        for (int paquetes : paquetesHoras) {
            suma += paquetes;
        }

        System.out.println("Total de paquetes procesados: " + suma);
        System.out.println("-------------------");

        // promedio de paquetes por hora
        float promedio = suma / (float) longitudPaquetes;

        System.out.println("El promedio de los paquetes por hora es: " + promedio);
        System.out.println("-------------------");

        // hora con menos paquetes
        int horaMenos = 0;

        for (int i = 0; i < longitudPaquetes; i++) {
            if (paquetesHoras[i] < paquetesHoras[horaMenos]) {
                horaMenos = i;
            }
        }

        System.out.println("La hora con menor numero de paquetes es: "
                + (horaMenos + 1)
                + " con "
                + paquetesHoras[horaMenos]
                + " paquetes.");

        System.out.println("--------------------");

        // horas con produccion inferior al promedio
        int inferiores = 0;

        for (int i = 0; i < longitudPaquetes; i++) {
            if (paquetesHoras[i] < promedio) {
                inferiores++;
            }
        }

        System.out.println("Cantidad de horas con produccion inferior al promedio: "
                + inferiores);

        System.out.println("--------------------");

        // racha mas larga inferior al promedio
        int rachaActual = 0;
        int rachaMayor = 0;

        for (int i = 0; i < longitudPaquetes; i++) {

            if (paquetesHoras[i] < promedio) {
                rachaActual++;

                if (rachaActual > rachaMayor) {
                    rachaMayor = rachaActual;
                }

            } else {
                rachaActual = 0;
            }
        }

        System.out.println("La racha mas larga de horas inferiores al promedio es: "
                + rachaMayor);

        System.out.println("--------------------");

        // listado final
        System.out.println("LISTADO FINAL");

        for (int i = 0; i < longitudPaquetes; i++) {
            System.out.println("Hora " + (i + 1) + ": "
                    + paquetesHoras[i] + " paquetes");
        }

        sc.close();
    }
}