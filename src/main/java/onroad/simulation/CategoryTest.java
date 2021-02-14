package simulation;

import model.bean.Category;
import model.dao.CategoryDAO;

import java.util.ArrayList;
import java.util.List;

public class CategoryTest {

    public static void main(String[] args) {
        saveTest();
        updateTest();
        String toString = categoryToString(findTest(01));
        System.out.println(toString);
        System.out.println(categoriesToString(findAllTest()));
        removeTest(02);
    }

    public static void saveTest(){
        List<Category> categories = new ArrayList<>();
        Category c = new Category("Tecnologias", "Tecnologias para seu conforto");
        Category c1 = new Category("Bebidas", "Bebidas geladas");
        categories.add(c);
        categories.add(c1);

        CategoryDAO ctgDAO = new CategoryDAO();

        for (Category cat : categories ){
            ctgDAO.save(cat);
        }
    }

    public static void updateTest(){
        Category c = new Category(01, "Comidas", "Comidas para janta");

        CategoryDAO ctgDAO = new CategoryDAO();
        ctgDAO.save(c);
    }

    public static Category findTest(Integer id){
        CategoryDAO dao = new CategoryDAO();

        return dao.findById(id);
    }

    public static String categoryToString(Category c){
        if (c != null){
            String text = "";
            text += "\nCategoria\n";
            text += "\nId:" + c.getId();
            text += "\nNome: " + c.getName();
            text += "\nDescrição: " + c.getDescricao();
            return text;
        }
        return null;
    }

    public static String categoriesToString(List<Category> list){
        if (list != null && !list.isEmpty()){
            String text = "";
            for (Category c : list){
                text += "\nCategoria\n";
                text += "\nId:" + c.getId();
                text += "\nNome: " + c.getName();
                text += "\nDescrição: " + c.getDescricao();
                return text;
            }
        }
        return null;
    }

    public static List<Category> findAllTest(){
        CategoryDAO dao = new CategoryDAO();

        return dao.findAll();
    }

    public static void removeTest(Integer id){
        CategoryDAO dao = new CategoryDAO();
        dao.remove(id);
    }

}
