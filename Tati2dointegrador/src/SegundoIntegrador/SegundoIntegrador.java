package SegundoIntegrador;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SegundoIntegrador {

	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        boolean continuar = true;

	        while (continuar) {
	            mostrarMenu();
	            int opcion = obtenerOpcion(scanner);

	            switch (opcion) {
	                case 1:
	                    realizarOperacion(scanner, "suma");
	                    break;
	                case 2:
	                    realizarOperacion(scanner, "resta");
	                    break;
	                case 3:
	                    realizarOperacion(scanner, "multiplicacion");
	                    break;
	                case 4:
	                    realizarOperacion(scanner, "division");
	                    break;
	                default:
	                    System.out.println("Opcion no valida. Intente de nuevo.");
	                    break;
	            }

	            continuar = preguntarSiContinuar(scanner);
	        }

	        System.out.println("Gracias, nos vemos");
	    }

	    public static void mostrarMenu() {
	        System.out.println("Menu de Operaciones:");
	        System.out.println("1. Suma");
	        System.out.println("2. Resta");
	        System.out.println("3. Multiplicacion");
	        System.out.println("4. Division");
	    }

	    public static int obtenerOpcion(Scanner scanner) {
	        System.out.print("Seleccione una opcion (1-4): ");
	        return scanner.nextInt();
	    }

	    public static void realizarOperacion(Scanner scanner, String operacion) {
	        try {
	            System.out.print("Ingrese el primer numero: ");
	            double numero1 = scanner.nextDouble();
	            System.out.print("Ingrese el segundo numero: ");
	            double numero2 = scanner.nextDouble();

	            double resultado = 0;

	            if (operacion.equals("suma")) {
	                resultado = numero1 + numero2;
	            } else if (operacion.equals("resta")) {
	                resultado = numero1 - numero2;
	            } else if (operacion.equals("multiplicacion")) {
	                resultado = numero1 * numero2;
	            } else if (operacion.equals("division")) {
	                if (numero2 == 0) {
	                    System.out.println("Error: Division por cero.");
	                    return;
	                }
	                resultado = numero1 / numero2;
	            }

	            System.out.println("Resultado de " + operacion + ": " + resultado);
	        } catch (InputMismatchException e) {
	            System.out.println("Error: Entrada no valida. Debes ingresar numeros.");
	            scanner.nextLine(); 
	        }
	    }

	    public static boolean preguntarSiContinuar(Scanner scanner) {
	        System.out.print("¿Deseas realizar otra operación? (Sí/No): ");
	        String respuesta = scanner.next().toLowerCase();
	        return respuesta.equals("si") || respuesta.equals("No");
	    }
	}