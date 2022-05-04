package libreria.persistencia;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import libreria.entidades.Libro;

public class LibroDAO {

    private final EntityManager em = Persistence
            .createEntityManagerFactory("LibreriaPU")
            .createEntityManager();

    public Libro Insertar(Libro libro) throws Exception {

        try {
            em.getTransaction().begin();
            em.persist(libro);
            em.getTransaction().commit();
            
            return libro;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception("Error al cargar libro");
        }

    }

    public void Actualizar(Libro libro) throws Exception {

        try {

            em.getTransaction().begin();
            em.merge(libro);
            em.getTransaction().commit();

        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception("Error al actualizar libro");
        }

    }

    public void Eliminar(Libro libro) throws Exception {

        try {

            em.getTransaction().begin();
            em.remove(libro);
            em.getTransaction().commit();

        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception("Error al eliminar libro");
        }

    }

    public Libro ObtenerPorIsbn(Long isbn) throws Exception {

        try {
            Libro libro = em.find(Libro.class, isbn);
            return libro;
        } catch (Exception e) {
            throw new Exception("Error al buscar libro por isbn");
        }
    }

    public List<Libro> ObtenerTodos() throws Exception {

        try {

            List<Libro> libros = em.createQuery("SELECT a FROM Libro a", Libro.class)
                    .getResultList();
            return libros;

        } catch (Exception e) {
            throw new Exception("Error al buscar libros");
        }

    }

    public List<Libro> ObtenerPorTitulo(String titulo) throws Exception {

        try {

            List<Libro> libros = em.createQuery("SELECT a FROM Libro a WHERE a.titulo LIKE :t", Libro.class)
                    .setParameter("t", titulo)
                    .getResultList();
            return libros;

        } catch (Exception e) {
            throw new Exception("Error al buscar libro por titulo");
        }

    }

    public List<Libro> ObtenerPorAutor(String autor) throws Exception {

        try {

            List<Libro> libros = em.createQuery("SELECT a FROM Libro a WHERE a.autor.nombreAut LIKE :autor", Libro.class)
                    .setParameter("autor", autor)
                    .getResultList();
            return libros;

        } catch (Exception e) {
            throw new Exception("Error al buscar libro por autor");
        }

    }

    public List<Libro> ObtenerPorEditorial(String editorial) throws Exception {

        try {

            List<Libro> libros = em.createQuery("SELECT a FROM Libro a WHERE a.editorial.nombreEd LIKE :editorial", Libro.class)
                    .setParameter("editorial", editorial)
                    .getResultList();
            return libros;

        } catch (Exception e) {
            throw new Exception("Error al buscar libro por editorial");
        }

    }

}
