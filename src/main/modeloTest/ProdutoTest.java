package main.modeloTest;

import main.modelo.Categoria;
import main.modelo.Produto;
import main.modeloDao.ProdutoDao;

public class ProdutoTest {

    public static void main(String[] args) {

        ProdutoDao dao = new ProdutoDao();

        for (Produto produto : dao.findAll()) {

            System.out.println("Descrição: " + produto.getDescricao());
            System.out.println("QTD: " + produto.getQtd());
            System.out.println("Valor: " + produto.getValor());
            System.out.println("Categoria: " + produto.getCategoria().getDescricao());

        }

    }

}
