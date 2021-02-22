package onroad.simulation;


//import onroad.dao.impl.CategoryDAOImpl;
//import onroad.dao.impl.ProductDAOImpl;
//import onroad.dao.impl.ProviderDAOImpl;
//import onroad.backend.entity.Category;
//import onroad.backend.entity.Product;
//import onroad.backend.entity.Provider;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;

public class ProductTest {
//
//    private static ProductDAOImpl dao = new ProductDAOImpl();
//    private static CategoryDAOImpl catgDao = new CategoryDAOImpl();
//
//    public static void main(String[] args) {
//        saveTest();
//        updateTest();
//        System.out.println(toString(findTest()));
//        System.out.println(allToString(findAllTest()));
//    }
//
//    public static void saveTest(){
//        List<Product> produtos = new ArrayList<Product>();
//
//        List<Category> categories = new ArrayList<>();
//        categories.add(generateCategory());
//
//        Provider provider = generateProvider();
//
//        Date date = new Date();
//
//        produtos.add(generateProduct(categories, provider, date));
//
//        for (Product product : produtos){
//            dao.save(product);
//        }
//    }
//
//    public static void updateTest(){
//        List<Category> categories = new ArrayList<>();
//        categories.add(generateCategory());
//
//        Provider provider = generateProvider();
//
//        Date date = new Date();
//
//        Product p = generateProduct(categories, provider, date);
//        dao.save(p);
//    }
//
//    public static Product findTest(){
//        return dao.findById(01);
//    }
//
//    public static List<Product> findAllTest(){
//        return dao.findAll();
//    }
//
//    public static String toString(Product p){
//        String txt = "";
//        if (p != null){
//            txt += "------------------";
//            txt += "\nProduto";
//            txt += "\nId: " + p.getId();
//            txt += "\nNome: " + p.getName();
//            txt += "\nDescrição: " + p.getDescription();
//
//            if (p.getCategories() != null){
//                txt += categoriesToString(p.getCategories());
//            }
//
//            txt += "\nValor: " + p.getFinalValue();
//            txt += "\nQuantidade: " + p.getQtde();
//            txt += "\n-------------\n";
//        }
//        return txt;
//    }
//
//    public static String allToString(List<Product> products){
//        String txt = "";
//        if (products != null && !products.isEmpty()){
//            for (Product p : products){
//                txt += toString(p);
//            }
//        }
//        return txt;
//    }
//
//    public static String categoriesToString(List<Category> categories)
//    {
//        String txt = "\nCategorias:";
//        if (categories != null && !categories.isEmpty())
//        {
//            for (Category category : categories)
//            {
//                txt = "\nNome: " + category.getName();
//                txt = "\nDescrição: " + category.getDescription();
//            }
//        }
//
//        return txt;
//    }
//
//    public static Provider generateProvider()
//    {
//        Provider provider = new Provider("Monnari", "Monnari Jeans");
//        ProviderDAOImpl dao = new ProviderDAOImpl();
//        dao.save(provider);
//
//        return provider;
//    }
//
//    public static Category generateCategory()
//    {
//        if (catgDao.findById(01) == null)
//        {
//            catgDao.save(new Category("Roupas", "Roupas com desconto"));
//        }
//        return catgDao.findById(01);
//    }
//
//    public static Product generateProduct(List<Category> categories, Provider provider, Date date)
//    {
//        return new Product("Produto 1", 120.00f, 30.00f, "Produto de teste", 01, "red", "f", date, "summer", "P", "32", "1212", categories, provider);
//
//    }

}
