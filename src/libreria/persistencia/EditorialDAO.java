
package libreria.persistencia;


import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import libreria.entidades.Editorial;

public class EditorialDAO {
    
    private final EntityManager em = Persistence
            .createEntityManagerFactory("LibreriaPU")
            .createEntityManager();
    
    public void Insertar(Editorial editorial) throws Exception {

        try {
            em.getTransaction().begin();
            em.persist(editorial);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception("Error al cargar editorial");
        }

    }
    
    public void Actualizar(Editorial editorial) throws Exception {
        
        try {
            
            em.getTransaction().begin();
            em.merge(editorial);
            em.getTransaction().commit();
            
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception("Error al actualizar editorial");
        }
        
    }
    
     public void Eliminar(Editorial editorial) throws Exception {
        
        try {
            
            em.getTransaction().begin();
            em.remove(editorial);
            em.getTransaction().commit();
            
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception("Error al eliminar editorial");
        }
        
    }
    
}
