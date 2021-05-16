package com.inditex.robert.commerce.service;

import com.inditex.robert.commerce.entity.Brand;
import com.inditex.robert.commerce.entity.Price;
import com.inditex.robert.commerce.repository.BrandRepository;
import com.inditex.robert.commerce.repository.PriceRepository;
import com.inditex.robert.commerce.util.dtos.price.PriceResponseDTO;
import com.inditex.robert.commerce.util.exceptions.CommerceExceptions;
import com.inditex.robert.commerce.util.exceptions.NotFoundExceptions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class PriceService {

  private static final String PATTERN_DATE = "yyyy-MM-dd HH:mm:ss";
  private final PriceRepository priceRepository;
  private final BrandRepository brandRepository;

  @Autowired
  public PriceService(
      final PriceRepository priceRepository, final BrandRepository brandRepository) {
    this.priceRepository = priceRepository;
    this.brandRepository = brandRepository;
  }

  public PriceResponseDTO findPrice(String applicationDate, Integer productId, Integer brandId)
      throws CommerceExceptions {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PATTERN_DATE);
    LocalDateTime dateTime = LocalDateTime.parse(applicationDate, formatter);

    Optional<Brand> brand = brandRepository.findById(brandId);
    if (priceRepository.findByProductId(productId).isEmpty())
      throw new NotFoundExceptions("404-NF", "PRODUCTO NO EXISTE");
    if (!brand.isPresent()) throw new NotFoundExceptions("404-NF", "Cadena NO EXISTE");
    return new ModelMapper()
        .map(processPrices(dateTime, productId, brand.get()), PriceResponseDTO.class);
  }

  private Price processPrices(LocalDateTime applicationDate, Integer productId, Brand brand) {
    List<Price> prices = priceRepository.findByProductIdAndBrand(productId, brand);
    return prices.stream()
        .filter(
            price ->
                applicationDate.isAfter(price.getStartDate())
                    && applicationDate.isBefore(price.getEndDate()))
        .max(Comparator.comparing(Price::getPriority))
        .orElse(null);
  }
}
