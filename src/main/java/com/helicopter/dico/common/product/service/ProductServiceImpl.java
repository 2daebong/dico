package com.helicopter.dico.common.product.service;

import com.helicopter.dico.common.product.entity.Product;
import com.helicopter.dico.common.product.repository.ProductRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by LeeDaebeom-Mac on 2016. 3. 16..
 */
@Service
public class ProductServiceImpl implements ProductService {

    private final static Log LOG = LogFactory.getLog(ProductServiceImpl.class);

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product getProduct(String productName){
        return productRepository.findByProductName(productName);
    }

    @Override
    public Product getProduct(Long productNo) {
        return productRepository.findOne(productNo);
    }

    @Override
    public List<Product> getProductList() {
        return productRepository.findAll();
    }

    @Override
    public Product addProduct(Product product) {
        product.setRegistYmdt(new Date());

        return productRepository.save(product);
    }

    @Override
    public void updateProduct(Product product) {
        product.setUpdateYmdt(new Date());

        productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long productNo) {
        Product targetProduct = productRepository.findOne(productNo);
        if(targetProduct != null) {
            productRepository.delete(targetProduct);
        } else {
            LOG.error("존재하지 않는 Product No");
        }
    }
}
