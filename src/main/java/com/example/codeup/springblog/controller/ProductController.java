package com.example.codeup.springblog.controller;

import com.example.codeup.springblog.model.Product;
import com.example.codeup.springblog.repositories.PostRepository;
import com.example.codeup.springblog.repositories.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {
    private final ProductRepository productDao;


    public ProductController(ProductRepository productDao) {
        this.productDao = productDao;

    }

    @GetMapping("/products")
    public String showAllProducts(Model model) {
        List<Product> productList = productDao.findAll();
        model.addAttribute("products", productList);
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
    @GetMapping("/products/create")
    public String showCreateForm(Model model) {
        model.addAttribute("product", new Product());
        return "products/create";
    }

    @PostMapping("/products/create")
    public String submitProduct(@ModelAttribute Product product){
//        Product product = new Product(name, priceInCents);
        productDao.save(product);
        return "redirect:/products";
    }


    @GetMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable long id) {
        productDao.deleteById(id);
        return "redirect:/products";
    }


    @GetMapping("/products/test/{id}")
    public String getProduct(@PathVariable long id) {
        Product p = productDao.findById(id).get();
        System.out.println(p);
        return "redirect:/products";
    }

    @GetMapping("/derived/1")
    @ResponseBody
    public List<Product> getProductsAfterId() {
        return productDao.getProductsByIdAfter(6L);
    }

    @GetMapping("/derived/2")
    @ResponseBody
    public List<Product> getBirdProducts() {
        return productDao.getProductByNameEndsWithIgnoreCase("bird");
    }

    @GetMapping("/derived/3")
    @ResponseBody
    public Product getProductByPrice() {
        return productDao.getFirstByPriceInCents(55);
    }

    @GetMapping("/test/jpql")
    @ResponseBody
    public List<String> getProductFirstName() {
        return productDao.getProductNamesNative();
    }


}
