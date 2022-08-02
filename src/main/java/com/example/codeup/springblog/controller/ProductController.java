package com.example.codeup.springblog.controller;

import com.example.codeup.springblog.repositories.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {
    private final ProductRepository productDao;

public ProductController(ProductRepository productDao) {
            this.productDao = productDao;
        }

        @GetMapping("/products")
        public String index(Model model){
            model.addAttribute("product",productDao.findAll());
            return "products/index";
        }



//    @GetMapping("/products")
//    public String showAllProducts(Model model){
//       List<Product> productList = new ArrayList<>(Arrays.asList(
//               new Product("Hammer",1000),
//               new Product("Broom", 2000),
//               new Product("Mop", 500)
//       ));
//       model.addAttribute("product",productList);
//return "products/index";
//    }
}
