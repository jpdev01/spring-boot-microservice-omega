package onroad.backend.controller;

import onroad.backend.entity.Category;
import onroad.backend.entity.Provider;
import onroad.backend.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("category")
public class CategoryController {
    private CategoryService service = new CategoryService();

    @RequestMapping(value = "save", method = RequestMethod.GET)
    public void save(@PathVariable("product") Category category) {
        service.save(category);
    }

}
