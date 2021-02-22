package onroad.simulation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("productTest")
public class ProductControllerTest {

    @RequestMapping("/novo")
    public void novo() {
        System.out.println("caiu!");
    }
}
