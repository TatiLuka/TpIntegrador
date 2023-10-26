package TercerIntegrador;
import java.util.Scanner;

public class TercerIntegrador {

	class Libro {
	    String titulo;
	    String autor;
	    int numPaginas;

	    public Libro(String titulo, String autor, int numPaginas) {
	        titulo = titulo;
	        autor = autor;
	        numPaginas = numPaginas;
	    }
	}

	public class Biblioteca {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        int capacidad = 100; 
	        Libro[] biblioteca = new Libro[capacidad];
	        int totalLibros = 0;

	        boolean continuar = true;

	        while (continuar) {
	            mostrarMenu();
	            int opcion = obtenerOpcion(scanner);

	            switch (opcion) {
	                case 1:
	                    mostrarListaDeLibros(biblioteca, totalLibros);
	                    break;
	                case 2:
	                    buscarLibroPorTitulo(scanner, biblioteca, totalLibros);
	                    break;
	                case 3:
	                    continuar = false;
	                    break;
	                default:
	                    System.out.println("Opcion no valida. Intentelo de nuevo.");
	                    break;
	            }
	        }

	        System.out.println("Gracias, nos vemos");
	    }

	    public static void mostrarMenu() {
	        System.out.println("Menu de la Biblioteca:");
	        System.out.println("1. Mostrar lista de libros");
	        System.out.println("2. Buscar un libro por titulo");
	        System.out.println("3. Salir");
	    }

	    public static int obtenerOpcion(Scanner scanner) {
	        System.out.print("Selecciona una opcion (1-3): ");
	        return scanner.nextInt();
	    }

	    public static void mostrarListaDeLibros(Libro[] biblioteca, int totalLibros) {
	        if (totalLibros == 0) {
	            System.out.println("La biblioteca esta vacia.");
	        } else {
	            System.out.println("Lista de libros en la biblioteca:");
	            for (int i = 0; i < totalLibros; i++) {
	                System.out.println("Titulo: " + biblioteca[i].titulo);
	                System.out.println("Autor: " + biblioteca[i].autor);
	                System.out.println("Numero de paginas: " + biblioteca[i].numPaginas);
	                System.out.println();
	            }
	        }
	    }

	    public static void buscarLibroPorTitulo(Scanner scanner, Libro[] biblioteca, int totalLibros) {
	        System.out.print("Ingresa el título del libro que deseas buscar: ");
	        scanner.nextLine(); 
	        String tituloBuscado = scanner.nextLine();

	        boolean encontrado = false;

	        for (int i = 0; i < totalLibros; i++) {
	            if (biblioteca[i].titulo.equalsIgnoreCase(tituloBuscado)) {
	                System.out.println("Libro encontrado:");
	                System.out.println("Titulo: " + biblioteca[i].titulo);
	                System.out.println("Autor: " + biblioteca[i].autor);
	                System.out.println("Numero de paginas: " + biblioteca[i].numPaginas);
	                System.out.println();
	                encontrado = true;
	            }
	        }

	        if (!encontrado) {
	            System.out.println("Libro no encontrado.");
	        }
	    }
	}
}
