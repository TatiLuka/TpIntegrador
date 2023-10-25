package TpIntegrador;

import java.util.Scanner;
import java.util.InputMismatchException;

public class TpIntegrador {

    public static void main(String[] args) {
        // Declaración de una matriz bidimensional para representar los asientos ocupados en el cine.
        boolean[][] asientosOcupados = new boolean[3][4];

        // Creación de un objeto Scanner para la entrada del usuario.
        Scanner scanner = new Scanner(System.in);

        // Mensaje de bienvenida.
        System.out.println("¡Bienvenido al boletero del microcine!");

        // Inicialización de la variable para rastrear los ingresos totales.
        int ingresosTotales = 0;

        // Inicio del bucle principal.
        while (true) {
            try {
                // Solicitar al usuario que ingrese la fila (A, B o C) o 'q' para salir.
                System.out.print("Ingrese la fila (A, B o C) o 'q' para salir: ");
                String fila1 = scanner.next().toUpperCase();

                // Verificar si el usuario desea salir y, en ese caso, salir del bucle principal.
                if (fila1.equals("Q")) {
                    break;
                }

                // Verificar si la fila ingresada es válida (A, B o C).
                if (!fila1.equals("A") && !fila1.equals("B") && !fila1.equals("C")) {
                    throw new InputMismatchException("Fila no válida. Por favor, ingrese A, B o C.");
                }

                // Solicitar al usuario que ingrese el número de asiento (1-4) y verificar su validez.
                System.out.print("Ingrese el número de asiento (1-4): ");
                int numeroAsiento = scanner.nextInt() - 1;

                if (numeroAsiento < 0 || numeroAsiento > 3) {
                    throw new InputMismatchException("Número de asiento no válido. Debe ser entre 1 y 4.");
                }

                // Mapear la fila ingresada ('A', 'B' o 'C') a un índice de fila (0, 1 o 2) para trabajar con la matriz asientosOcupados.
                int fila2;
                switch (fila1) {
                    case "A":
                        fila2 = 0;
                        break;
                    case "B":
                        fila2 = 1;
                        break;
                    case "C":
                        fila2 = 2;
                        break;
                    default:
                        fila2 = -1; // Valor por defecto en caso de entrada inválida.
                }

                // Verificar si el asiento seleccionado está ocupado.
                while (asientosOcupados[fila2][numeroAsiento]) {
                    System.out.println("El asiento está ocupado. Por favor, elija otro.");

                    // Solicitar nuevamente al usuario que ingrese la fila y el número de asiento.
                    System.out.print("Ingrese la fila (A, B o C) o 'q' para salir: ");
                    fila1 = scanner.next().toUpperCase();

                    if (fila1.equals("Q")) {
                        break;
                    }

                    System.out.print("Ingrese el número de asiento (1-4): ");
                    numeroAsiento = scanner.nextInt() - 1;

                    // Mapear nuevamente la fila ingresada.
                    switch (fila1) {
                        case "A":
                            fila2 = 0;
                            break;
                        case "B":
                            fila2 = 1;
                            break;
                        case "C":
                            fila2 = 2;
                            break;
                        default:
                            System.out.println("Fila no válida. Por favor, ingrese A, B o C.");
                            continue; // Continuar el bucle mientras la entrada sea inválida.
                    }
                }

                // Marcar el asiento como ocupado en la matriz asientosOcupados.
                asientosOcupados[fila2][numeroAsiento] = true;

                // Calcular el costo del asiento en función de la fila seleccionada.
                int costo;
                switch (fila1) {
                    case "A":
                        costo = 500;
                        break;
                    case "B":
                        costo = 700;
                        break;
                    case "C":
                        costo = 1000;
                        break;
                    default:
                        costo = 0; // Valor por defecto en caso de entrada inválida.
                }

                // Actualizar los ingresos totales.
                ingresosTotales += costo;

                // Mostrar un mensaje de confirmación de reserva y el costo del asiento.
                System.out.println("¡Asiento reservado con éxito!");
                System.out.println("El costo del asiento es: $" + costo);

                // Verificar si la fila está llena y mostrar un mensaje si es el caso.
                boolean filaLlena = true;
                for (int i = 0; i < 4; i++) {
                    if (!asientosOcupados[fila2][i]) {
                        filaLlena = false;
                        break;
                    }
                }
                if (filaLlena) {
                    System.out.println("La fila " + fila1 + " está llena.");
                }

                // Verificar si la sala está llena y mostrar un mensaje si es el caso.
                boolean salaLlena = true;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 4; j++) {
                        if (!asientosOcupados[i][j]) {
                            salaLlena = false;
                            break;
                        }
                    }
                }
                if (salaLlena) {
                    System.out.println("¡Sala llena!");
                }
            } catch (InputMismatchException e) {
                scanner.nextLine(); // Limpiar el búfer del scanner.
                System.out.println("Error: Dato no válido");
            }
        }

        // Mostrar los ingresos totales y un mensaje de despedida.
        System.out.println("Ingresos totales: $" + ingresosTotales);
        System.out.println("Gracias por utilizar el boletero del microcine.");
    }
}
