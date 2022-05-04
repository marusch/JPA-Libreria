package libreria.servicios;

import java.util.Scanner;
import libreria.persistencia.LibroDAO;

public class MenuServicios {

    Scanner entrada = new Scanner(System.in);

    LibroServicios libroServicios = new LibroServicios();
    AutorServicios autorServicios = new AutorServicios();
    EditorialServicios editorialServicios = new EditorialServicios();

    public void Menu() throws Exception {

        try {
            System.out.println("-----MENU-----\n"
                    + "1) Crear libro.\n"
                    + "2) Crear un autor.\n"
                    + "3) Crear una editorial.\n"
                    + "4) Busqueda de un Autor por nombre.\n"
                    + "5) Busqueda de un libro por ISBN.\n"
                    + "6) Busqueda de un libro por Título.\n"
                    + "7) Busqueda de un libro/s por nombre de Autor.\n"
                    + "8) Busqueda de un libro/s por nombre de Editorial.\n"
                    + "9) Salir.");

            System.out.println("Seleccione una opcion: ");
            String respuesta = entrada.next();

            OpcionSeleccionada(respuesta);
        } catch (Exception e) {
            //System.out.println(e.getMessage());
            throw new Exception("Debe ingresar una opcion valida");
        }
    }

    public void OpcionSeleccionada(String respuesta) throws Exception {

        try {

            switch (respuesta) {

                case "1":
                    libroServicios.CrearLibro();
                    
                    Menu();
                    break;
                case "2":
                    autorServicios.CrearAutor();
                    Menu();
                    break;
                case "3":
                    editorialServicios.CrearEditorial();
                    Menu();
                    break;
                case "4":
                    autorServicios.MostrarAutorPorNombre();
                    Menu();
                    break;
                case "5":
                    System.out.println("Ingrese el isbn del libro que desea buscar");
                    Long isbnBuscado = entrada.nextLong();
                    libroServicios.MostrarLibroPorISBN(isbnBuscado);
                    Menu();
                    break;

                case "6":
                    System.out.println("Ingrese el titulo del libro a buscar:");
                    String tituloBuscado = entrada.next();
                    libroServicios.MostrarLibroPorTitulo(tituloBuscado);
                    Menu();
                    break;

                case "7":
                    System.out.println("Busqueda de un libro/s por nombre de Autor. nombre:");
                    String nombreBuscado = entrada.next();
                    libroServicios.MostrarLibroPorAutor(nombreBuscado);
                    Menu();
                    break;
                case "8":
                    System.out.println("Busqueda de un libro/s por nombre de Editorial. Nombre:");
                    String editorialBuscado = entrada.next();
                    libroServicios.MostrarLibroPorEditorial(editorialBuscado);
                    Menu();
                    break;
                case "9":
                    System.out.println("Consulta finalizada.");
                    break;
                default:
                    System.out.println("Ingrese una opcion valida");
                    Menu();
            }

        } catch (Exception e) {
            throw new Exception();
        }
    }

}
