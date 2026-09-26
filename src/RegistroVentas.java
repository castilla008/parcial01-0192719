import java.util.Scanner;

public class RegistroVentas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int filas = 4;    // Sucursales
        int columnas = 5; // Productos
        
        int[][] matriz = new int[filas][columnas];
        
        System.out.println("==================================================");
        System.out.println("SISTEMA DE REGISTRO DE VENTAS - SUCURSALES Y PRODUCTOS");
        System.out.println("==================================================");
        
        // 1. Lectura, almacenamiento y validación de la matriz
        for (int i = 0; i < filas; i++) {
            System.out.println("\n--- Registro para la Sucursal " + (i + 1) + " ---");
            for (int j = 0; j < columnas; j++) {
                while (true) {
                    System.out.print("  Ingrese unidades vendidas del Producto " + (j + 1) + ": ");
                    if (scanner.hasNextInt()) {
                        int valor = scanner.nextInt();
                        if (valor >= 0) {
                            matriz[i][j] = valor;
                            break;
                        } else {
                            System.out.println("  [Error] El valor no puede ser negativo. Intente de nuevo.");
                        }
                    } else {
                        System.out.println("  [Error] Por favor, ingrese un número entero válido.");
                        scanner.next(); // Limpiar la entrada incorrecta
                    }
                }
            }
        }
        
        // 2. Cálculo del total de unidades vendidas por cada sucursal (Suma de filas)
        int[] totalesSucursales = new int[filas];
        for (int i = 0; i < filas; i++) {
            int sumaFila = 0;
            for (int j = 0; j < columnas; j++) {
                sumaFila += matriz[i][j];
            }
            totalesSucursales[i] = sumaFila;
        }
        
        // 3. Cálculo del total vendido de cada producto (Suma de columnas)
        int[] totalesProductos = new int[columnas];
        for (int j = 0; j < columnas; j++) {
            int sumaColumna = 0;
            for (int i = 0; i < filas; i++) {
                sumaColumna += matriz[i][j];
            }
            totalesProductos[j] = sumaColumna;
        }
        
        // 4. Identificación de la sucursal con menor venta y el producto con mayor venta (Regla de desempate: primera ocurrencia)
        int minSucursalIdx = 0;
        int minVentas = totalesSucursales[0];
        for (int i = 1; i < filas; i++) {
            if (totalesSucursales[i] < minVentas) {
                minVentas = totalesSucursales[i];
                minSucursalIdx = i;
            }
        }
        
        int maxProductoIdx = 0;
        int maxVentas = totalesProductos[0];
        for (int j = 1; j < columnas; j++) {
            if (totalesProductos[j] > maxVentas) {
                maxVentas = totalesProductos[j];
                maxProductoIdx = j;
            }
        }
        
        // 5. Conteo de registros de la matriz superiores a 30 unidades
        int contadorMayores30 = 0;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (matriz[i][j] > 30) {
                    contadorMayores30++;
                }
            }
        }
        
        // 6. Presentación de la matriz y resultados organizados
        System.out.println("\n" + "=".repeat(50));
        System.out.println("REPORTE DE RESULTADOS");
        System.out.println("==================================================");
        
        // Mostrar la matriz en forma de tabla
        System.out.printf("%-12s", "Sucursal");
        for (int j = 0; j < columnas; j++) {
            System.out.printf("%-10s", "Prod " + (j + 1));
        }
        System.out.println("\n" + "-".repeat(62));
        
        for (int i = 0; i < filas; i++) {
            System.out.printf("%-12s", "Sucursal " + (i + 1));
            for (int j = 0; j < columnas; j++) {
                System.out.printf("%-10d", matriz[i][j]);
            }
            System.out.println();
        }
        
        System.out.println("\n--- Totales por Sucursal ---");
        for (int i = 0; i < filas; i++) {
            System.out.println("• Sucursal " + (i + 1) + ": " + totalesSucursales[i] + " unidades");
        }
        
        System.out.println("\n--- Totales por Producto ---");
        for (int j = 0; j < columnas; j++) {
            System.out.println("• Producto " + (j + 1) + ": " + totalesProductos[j] + " unidades");
        }
        
        System.out.println("\n--- Análisis General ---");
        System.out.println("• Sucursal con menor cantidad total de ventas: Sucursal " + (minSucursalIdx + 1) + " (" + minVentas + " unidades)");
        System.out.println("• Producto con mayor cantidad total de unidades vendidas: Producto " + (maxProductoIdx + 1) + " (" + maxVentas + " unidades)");
        System.out.println("• Registros superiores a 30 unidades: " + contadorMayores30);
        System.out.println("==================================================");
        
        scanner.close();
    }
}