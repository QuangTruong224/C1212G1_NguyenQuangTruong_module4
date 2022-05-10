package com.repository.impl;

import com.model.Product;
import com.repository.BaseRepository;
import com.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {

    @Override
    public List<Product> findAll() {
        TypedQuery<Product> productTypedQuery = BaseRepository.entityManager.createQuery("select s from Product s", Product.class);
        return productTypedQuery.getResultList();
    }

    @Override
    public void save(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();

        entityTransaction.begin();
        BaseRepository.entityManager.persist(product);
        entityTransaction.commit();
    }

    @Override
    public Product findById(int id) {
        return BaseRepository.entityManager.find(Product.class,id);
    }

    @Override
    public void update(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();

        entityTransaction.begin();
        BaseRepository.entityManager.merge(product);
        entityTransaction.commit();
    }

    @Override
    public void remove(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.remove(product);
        entityTransaction.commit();
    }

    @Override
    public Product searchById(int id) {
        return BaseRepository.entityManager.find(Product.class,id);
    }

    @Override
    public List<Product> searchByName(String name) {
//        List<Product> productList1=new ArrayList<>();
//        for (int i = 0; i < productList.size(); i++) {
//            if(productList.get(i).getName().toLowerCase().contains(name)){
//                productList1.add(productList.get(i));
//            }
//        }
//        return productList1;
        TypedQuery<Product> productTypedQuery = BaseRepository.entityManager.createQuery(("select s from Product as s where s.nameProduct like : name"), Product.class);
        productTypedQuery.setParameter("name","%"+name+"%");
        return productTypedQuery.getResultList();
    }
}
