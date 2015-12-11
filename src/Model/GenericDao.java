package Model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * Document: GenericDao
 *
 * @author : Leonardo Baiser <lpbaiser@gmail.com>
 * @since : Dec 9, 2015, 8:55:59 PM
 */
public class GenericDao<T> {

    public static EntityManager em = Persistence.createEntityManagerFactory("UP").createEntityManager();

    private Class clazz;

    public GenericDao(Class clazz) {
        this.clazz = clazz;
    }

    public void inserir(T e) {
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();

    }

    public void atualizar(T e) {
        em.getTransaction().begin();
        em.merge(e);
        em.getTransaction().commit();
    }

    public void remover(T e) {
        if (e != null) {
            em.getTransaction().begin();
            em.remove(e);
            em.getTransaction().commit();
        }
    }

    public T obter(int id) {
        em.clear();
        return (T) em.find(clazz, id);
    }

    public T obter(String id) {
        em.clear();
        return (T) em.find(clazz, id);
    }

    public List<T> list() {
        return em.createQuery("SELECT e FROM " + clazz.getSimpleName() + " e").getResultList();
    }

}
