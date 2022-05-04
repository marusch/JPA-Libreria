package libreria.principal;

import libreria.servicios.MenuServicios;

public class Principal {

    public static void main(String[] args) {
        MenuServicios servicios = new MenuServicios();

        try {
            servicios.Menu();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
