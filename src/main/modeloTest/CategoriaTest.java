package main.modeloTest;

import main.modelo.Categoria;
import main.modeloDao.CategoriaDao;

public class CategoriaTest {

    public static void main(String[] args) {

        Categoria categoria = new Categoria();
        categoria.setDescricao("Bebidas");

        CategoriaDao dao = new CategoriaDao();

        categoria = dao.save(categoria);


    }
}
