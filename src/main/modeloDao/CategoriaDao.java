package main.modeloDao;

import main.Conection.ConectionFactory;
import main.modelo.Categoria;

import javax.persistence.EntityManager;
import java.util.List;

public class CategoriaDao {

    public Categoria save(Categoria categoria) {

        EntityManager em = new ConectionFactory().getConnection();

        try {
            em.getTransaction().begin();
            if (categoria.getId() == null) {
                em.persist(categoria);
            } else {
                em.merge(categoria);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return categoria;
    }

    public Categoria findById(Integer id) {

        EntityManager em = new ConectionFactory().getConnection();
        Categoria categoria = null;

        try {
            categoria = em.find(Categoria.class, id);
        }catch (Exception e){
            System.err.println(e);
        }finally {
            em.close();
        }

        return categoria;
    }

    public List<Categoria> findAll() {

        EntityManager em = new ConectionFactory().getConnection();
        List<Categoria> categorias = null;

        try {
            categorias = em.createQuery("from Categoria c").getResultList();
        }catch (Exception e){
            System.err.println(e);
        }finally {
            em.close();
        }

        return categorias;
    }

    public Categoria remove(Integer id){

        EntityManager em = new ConectionFactory().getConnection();
        Categoria  categoria = null;

        try{

            categoria = em.find(Categoria.class, id);

            em.getTransaction().begin();
            em.remove(categoria);
            em.getTransaction().commit();

        }catch (Exception e){
            System.err.println(e);
            em.getTransaction().rollback();
        }finally {
            em.close();
        }

        return categoria;
    }

}
