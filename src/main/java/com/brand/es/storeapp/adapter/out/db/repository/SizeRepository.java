package com.brand.es.storeapp.adapter.out.db.repository;

import com.brand.es.storeapp.adapter.out.db.model.SizeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by JMENDEZ on 11/12/2022.
 */
@Repository
public interface SizeRepository extends JpaRepository<SizeEntity, Integer>
{
}
