package libreria.servicios;

import java.util.List;
import java.util.Scanner;
import libreria.entidades.Autor;
import libreria.entidades.Editorial;
import libreria.entidades.Libro;
import libreria.persistencia.LibroDAO;

public class LibroServicios {

    Scanner entrada = new Scanner(System.in);
    private LibroDAO librodao = new LibroDAO();

    public void CrearLibro() throws Exception {

        Libro libro = new Libro();
        Editorial editorial = new Editorial();
        Autor autor = new Autor();

        /*  try {
            System.out.println("Ingrese el titulo del libro");
            String titulo = entrada.next();

            System.out.println("Ingrese el autor del libro");
            String nombreAut = entrada.next();

            System.out.println("Ingrese el año de publicación del libro");
            Integer anio = entrada.nextInt();

            System.out.println("Ingrese el nombre de la editorial del libro");
            String nombreEd = entrada.next();

            System.out.println("Ingrese el ISBN del libro");
            Long isbn = entrada.nextLong();

            System.out.println("Ingrese el total de ejemplares del libro");
            Integer ejemplares = entrada.nextInt();

            System.out.println("Ingrese los ejemplares prestados");
            Integer ejemplaresPrestados = entrada.nextInt();

            Integer ejemplaresRestantes = ejemplares - ejemplaresPrestados;
            

            autor.setNombre(nombreAut);
            autor.setAlta(true);
            editorial.setNombre(nombreEd);
            editorial.setAlta(true);
            libro.setEditorial(editorial);
            libro.setTitulo(titulo);
            libro.setAutor(autor);
            libro.setAnio(anio);
            libro.setIsbn(isbn);
            libro.setEjemplares(ejemplares);
            libro.setEjemplaresPrestados(ejemplaresPrestados);
            libro.setEjemplaresRestantes(ejemplaresRestantes);
            libro.setAlta(true);
          
            librodao.Insertar(libro);
         
            System.out.println("Se guardo el libro en la base de datos");
        } catch (Exception e) {
            throw new Exception("No se pudo crear el libro");
        }*/
        try {
            System.out.println("Ingrese el isbn");
            Long isbn = entrada.nextLong();
            libro.setIsbn(isbn);
            if (isbn == null || isbn.toString().trim().isEmpty()) {
                throw new Exception("El isbn es obligatorio");
            }

            System.out.println("Ingrese el titulo");
            String titulo = entrada.next();
            libro.setTitulo(titulo);
            if (titulo == null || titulo.toString().trim().isEmpty()) {
                throw new Exception("El titulo es obligatorio");
            }

            System.out.println("Ingrese el año");
            Integer anio = entrada.nextInt();
            libro.setAnio(anio);
            if (anio == null || anio.toString().trim().isEmpty()) {
                throw new Exception("El año es obligatorio");
            }

            System.out.println("Ingrese ejemplares");
            Integer ejemplares = entrada.nextInt();
            libro.setEjemplares(ejemplares);
            if (ejemplares == null || ejemplares.toString().trim().isEmpty()) {
                throw new Exception("Los ejemplares son obligatorio");
            }

            System.out.println("Ingrese ejemplares prestados");
            Integer ejemplaresPrestados = entrada.nextInt();
            libro.setEjemplaresPrestados(ejemplaresPrestados);
            if (ejemplaresPrestados == null || ejemplaresPrestados.toString().trim().isEmpty()) {
                throw new Exception("Los ejemplares prestados son obligatorio");
            }

            System.out.println("Ingrese ejemplares restantes");
            Integer ejemplaresRestantes = entrada.nextInt();
            libro.setEjemplaresRestantes(ejemplaresRestantes);
            if (ejemplaresRestantes == null || ejemplaresRestantes.toString().trim().isEmpty()) {
                throw new Exception("Los ejemplares restantes son obligatorio");
            }

            System.out.println("Ingrese el autor");
            String nombreAut = entrada.next();
            autor.setNombre(nombreAut);
            autor.setAlta(true);
            libro.setAutor(autor);
            if (nombreAut == null) {
                throw new Exception("El autor es obligatorio");
            }

            System.out.println("Ingrese la editorial");
            String nombreEd = entrada.next();
            editorial.setNombre(nombreEd);
            editorial.setAlta(true);
            libro.setEditorial(editorial);
            if (nombreEd == null) {
                throw new Exception("La editorial es obligatorio");
            }

            librodao.Insertar(libro);

        } catch (Exception e) {
            throw new Exception("Error al crear el libro");
        }
    }

    public void MostrarLibroPorISBN(Long isbn) throws Exception {

        try {
            Libro libro = librodao.ObtenerPorIsbn(isbn);

            if (libro == null || isbn == null) {
                System.out.println("El libro no existe");
            } else {
                System.out.printf("%-20s%-35s%-20s%-20s%-20s%-20s%-20s%-20s%-20s \n", "ISBN", "Titulo", "Autor",
                        "Editorial", "Año", "Ejemplares", "Ejemplares Prestados", "Ejemplares restados", "Alta");

                System.out.printf("%-20s%-35s%-20s%-20s%-20s%-20s%-20s%-30s%-20s\n", libro.getIsbn(),
                        libro.getTitulo(), libro.getAutor().getNombre(),
                        libro.getEditorial().getNombre(), libro.getAnio(), libro.getEjemplares(),
                        libro.getEjemplaresPrestados(), libro.getEjemplaresRestantes(), libro.isAlta());
            }

        } catch (Exception e) {
            throw new Exception("Error al buscar libro por isbn");
        }

    }

    public void MostrarLibroPorTitulo(String titulo) throws Exception {

        try {
            List<Libro> libro = librodao.ObtenerPorTitulo(titulo);

            if (libro == null || titulo == null) {
                System.out.println("El libro no existe");
            } else {
                System.out.printf("%-20s%-35s%-20s%-20s%-20s%-20s%-20s%-20s%-20s \n", "ISBN", "Titulo", "Autor",
                        "Editorial", "Año", "Ejemplares", "Ejemplares Prestados", "Ejemplares restados", "Alta");

                for (Libro libro1 : libro) {
                    System.out.printf("%-20s%-35s%-20s%-20s%-20s%-20s%-20s%-30s%-20s\n", libro1.getIsbn(),
                            libro1.getTitulo(), libro1.getAutor().getNombre(),
                            libro1.getEditorial().getNombre(), libro1.getAnio(), libro1.getEjemplares(),
                            libro1.getEjemplaresPrestados(), libro1.getEjemplaresRestantes(), libro1.isAlta());
                }
            }

        } catch (Exception e) {
            throw new Exception("Error al buscar libro por titulo");
        }

    }

    public void MostrarLibroPorAutor(String autor) throws Exception {

        try {
            List<Libro> libro = librodao.ObtenerPorAutor(autor);

            if (libro == null || autor == null) {
                System.out.println("El libro no existe");
            } else {
                System.out.printf("%-20s%-35s%-20s%-20s%-20s%-20s%-20s%-20s%-20s \n", "ISBN", "Titulo", "Autor",
                        "Editorial", "Año", "Ejemplares", "Ejemplares Prestados", "Ejemplares restados", "Alta");

                for (Libro libro1 : libro) {
                    System.out.printf("%-20s%-35s%-20s%-20s%-20s%-20s%-20s%-30s%-20s\n", libro1.getIsbn(),
                            libro1.getTitulo(), libro1.getAutor().getNombre(),
                            libro1.getEditorial().getNombre(), libro1.getAnio(), libro1.getEjemplares(),
                            libro1.getEjemplaresPrestados(), libro1.getEjemplaresRestantes(), libro1.isAlta());
                }
            }

        } catch (Exception e) {
            throw new Exception("Error al buscar libro por autor");
        }

    }
    
    public void MostrarLibroPorEditorial(String editorial) throws Exception {

        try {
            List<Libro> libro = librodao.ObtenerPorEditorial(editorial);

            if (libro == null || editorial == null) {
                System.out.println("El libro no existe");
            } else {
                System.out.printf("%-20s%-35s%-20s%-20s%-20s%-20s%-20s%-20s%-20s \n", "ISBN", "Titulo", "Autor",
                        "Editorial", "Año", "Ejemplares", "Ejemplares Prestados", "Ejemplares restados", "Alta");

                for (Libro libro1 : libro) {
                    System.out.printf("%-20s%-35s%-20s%-20s%-20s%-20s%-20s%-40s%-20s\n", libro1.getIsbn(),
                            libro1.getTitulo(), libro1.getAutor().getNombre(),
                            libro1.getEditorial().getNombre(), libro1.getAnio(), libro1.getEjemplares(),
                            libro1.getEjemplaresPrestados(), libro1.getEjemplaresRestantes(), libro1.isAlta());
                }
            }

        } catch (Exception e) {
            throw new Exception("Error al buscar libro por editorial");
        }

    }
    
}
