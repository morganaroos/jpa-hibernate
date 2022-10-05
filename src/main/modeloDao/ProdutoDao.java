package main.modeloDao;

import main.Conection.ConectionFactory;
import main.modelo.Categoria;
import main.modelo.Produto;

import javax.persistence.EntityManager;
import java.util.List;

public class ProdutoDao {

    public Produto save(Produto produto) {

        EntityManager em = new ConectionFactory().getConnection();

        try {
            em.getTransaction().begin();
            if (produto.getId() == null) {
                em.persist(produto);
            } else {
                em.merge(produto);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return produto;
    }

    public Produto findById(Integer id) {

        EntityManager em = new ConectionFactory().getConnection();
        Produto produto = null;

        try {
            produto = em.find(Produto.class, id);
        }catch (Exception e){
            System.err.println(e);
        }finally {
            em.close();
        }

        return produto;
    }

    public List<Produto> findAll() {

        EntityManager em = new ConectionFactory().getConnection();
        List<Produto> produtos = null;

        try {
            produtos = em.createQuery("from Produto p").getResultList();
        }catch (Exception e){
            System.err.println(e);
        }finally {
            em.close();
        }

        return produtos;
    }



}
