package com.brand.es.storeapp.adapter.out.db.repository;

import com.brand.es.storeapp.adapter.out.db.model.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by JMENDEZ on 11/12/2022.
 */
@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer>
{
}
