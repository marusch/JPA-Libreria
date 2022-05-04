package libreria.persistencia;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import libreria.entidades.Autor;

public class AutorDAO {

    private final EntityManager em = Persistence
            .createEntityManagerFactory("LibreriaPU")
            .createEntityManager();

    public void Insertar(Autor autor) throws Exception {

        try {
            em.getTransaction().begin();
            em.persist(autor);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception("Error al cargar autor");
        }

    }

    public void Actualizar(Autor autor) throws Exception {

        try {

            em.getTransaction().begin();
            em.merge(autor);
            em.getTransaction().commit();

        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception("Error al actualizar autor");
        }

    }

    public void Eliminar(Autor autor) throws Exception {

        try {

            em.getTransaction().begin();
            em.remove(autor);
            em.getTransaction().commit();

        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception("Error al eliminar autor");
        }

    }

    public List<Autor> ObtenerPorNombre(String nombre) throws Exception {

        try {
            List<Autor> autores = em.createQuery("SELECT a FROM Autor a WHERE a.nombre LIKE :name", Autor.class)
                    .setParameter("name", nombre)
                    .getResultList();
            return autores;
        } catch (Exception e) {
            throw new Exception("Error al buscar autor por nombre");
        }

    }

}
