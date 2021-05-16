package com.inditex.robert.commerce.repository;

import com.inditex.robert.commerce.entity.Brand;
import com.inditex.robert.commerce.entity.Price;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PriceRepository extends CrudRepository<Price, Long> {

  List<Price> findByProductId(Integer productId);

  List<Price> findByProductIdAndBrand(Integer ProductId, Brand brand);
}
