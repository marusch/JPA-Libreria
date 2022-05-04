package libreria.servicios;

import java.util.List;
import java.util.Scanner;
import libreria.entidades.Autor;
import libreria.persistencia.AutorDAO;

public class AutorServicios {

    Scanner entrada = new Scanner(System.in);
    private AutorDAO autordao = new AutorDAO();

    public void CrearAutor() throws Exception {

        Autor autor = new Autor();

        try {
            System.out.println("Ingrese el nombre del autor");
            String nombre = entrada.next();
            autor.setNombre(nombre);
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe contener un nombre");
            } else {
                System.out.println("Se guardo exitosamente.");
            }
            autordao.Insertar(autor);
        } catch (Exception e) {
            throw e;
        }
    }

    public void MostrarAutorPorNombre() throws Exception {

        try {
            System.out.println("Ingrese el nombre del autor que desea buscar");
            String nombre = entrada.next();
            List<Autor> autor = autordao.ObtenerPorNombre(nombre);

            if (autor.isEmpty()) {
                throw new Exception("La lista de autores esta vacia");
            } else if (nombre.trim().isEmpty()) {
                System.out.println("El nombre no es correcto");
            } else {
                System.out.printf("%-10s%-20s%-10s\n", "Id", "Nombre", "Alta");
                for (Autor autor1 : autor) {
                    System.out.printf("%-10s%-20s%-10s\n", autor1.getId(), autor1.getNombre(), autor1.isAlta());
                }
            }
        } catch (Exception e) {
            throw new Exception("No se encontro un autor con ese nombre");
        }

    }

}
