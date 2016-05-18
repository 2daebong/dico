package com.helicopter.dico.api.product.controller;

import com.helicopter.dico.common.product.entity.Product;
import com.helicopter.dico.common.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by LeeDaebeom-Mac on 2016. 3. 16..
 */
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public Product findProduct(@RequestParam(value = "productName") String productName){
        return productService.getProduct(productName);
    }

    @RequestMapping(value = "/productList", method = RequestMethod.GET)
    public List<Product> findProductList(){
        return productService.getProductList();
    }

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public Product addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

}