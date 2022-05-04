package libreria.servicios;

import java.util.Scanner;
import libreria.entidades.Editorial;
import libreria.persistencia.EditorialDAO;

public class EditorialServicios {

    Scanner entrada = new Scanner(System.in);
    private EditorialDAO editorialdao = new EditorialDAO();

    public void CrearEditorial() throws Exception {

        Editorial editorial = new Editorial();

        try {
            System.out.println("Ingrese el nombre de la editorial");
            String nombre = entrada.next();
            editorial.setNombre(nombre);
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe contener un nombre");
            } else {
                System.out.println("Se guardo exitosamente.");
            }
            editorialdao.Insertar(editorial);
        } catch (Exception e) {
            throw e;
        }
    }

}
