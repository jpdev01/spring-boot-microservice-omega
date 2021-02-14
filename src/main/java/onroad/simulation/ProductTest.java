package simulation;

import model.bean.Category;
import model.bean.Product;
import model.dao.CategoryDAO;
import model.dao.ProductDAO;

import java.util.ArrayList;
import java.util.List;

public class ProductTest {

    private static ProductDAO dao = new ProductDAO();
    private static CategoryDAO catgDao = new CategoryDAO();

    public static void main(String[] args) {
        saveTest();
        updateTest();
        System.out.println(toString(findTest()));
        System.out.println(allToString(findAllTest()));
    }

    public static void saveTest(){
        List<Product> produtos = new ArrayList<Product>();

        List<Category> categories = new ArrayList<>();

        if (catgDao.findById(01) == null)
        {
            catgDao.save(new Category("Roupas", "Roupas com desconto"));
        }
        categories.add(catgDao.findById(01));

        produtos.add(new Product("Produto 1", 120.00, "Produto de teste", 01, categories));

        for (Product product : produtos){
            dao.save(product);
        }
    }

    public static void updateTest(){
        List<Category> categories = new ArrayList<>();
        categories.add(catgDao.findById(01));

        Product p = new Product (01, "Produto 1 alterado", 100.00, "Alteração", 01, categories);
        dao.save(p);
    }

    public static Product findTest(){
        return dao.findById(01);
    }

    public static List<Product> findAllTest(){
        return dao.findAll();
    }

    public static String toString(Product p){
        String txt = "";
        if (p != null){
            txt += "------------------";
            txt += "\nProduto";
            txt += "\nId: " + p.getId();
            txt += "\nNome: " + p.getName();
            txt += "\nDescrição: " + p.getDescription();

            if (p.getCategories() != null){
                txt += categoriesToString(p.getCategories());
            }

            txt += "\nValor: " + p.getValue();
            txt += "\nQuantidade: " + p.getQtde();
            txt += "\n-------------\n";
        }
        return txt;
    }

    public static String allToString(List<Product> products){
        String txt = "";
        if (products != null && !products.isEmpty()){
            for (Product p : products){
                txt += toString(p);
            }
        }
        return txt;
    }

    public static String categoriesToString(List<Category> categories)
    {
        String txt = "\nCategorias:";
        if (categories != null && !categories.isEmpty())
        {
            for (Category category : categories)
            {
                txt = "\nNome: " + category.getName();
                txt = "\nDescrição: " + category.getDescricao();
            }
        }

        return txt;
    }

}
