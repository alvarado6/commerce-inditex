package com.inditex.robert.commerce.provider;

import com.inditex.robert.commerce.util.dtos.price.PriceResponseDTO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class PriceResponseProvider {
  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

  public PriceResponseDTO providerFirtsPriceResponseDTO() {
    return PriceResponseDTO.builder()
        .productId(35455)
        .priceList(1)
        .startDate(LocalDateTime.parse("2020-06-14 00:00:00", formatter))
        .endDate(LocalDateTime.parse("2020-12-31 23:59:59", formatter))
        .price(35.5)
        .build();
  }

  public PriceResponseDTO providerSecondPriceResponseDTO() {
    return PriceResponseDTO.builder()
            .productId(35455)
            .priceList(2)
            .startDate(LocalDateTime.parse("2020-06-14 15:00:00", formatter))
            .endDate(LocalDateTime.parse("2020-06-14 18:30:00", formatter))
            .price(25.45)
            .build();
  }

  public PriceResponseDTO providerThirdPriceResponseDTO() {
    return PriceResponseDTO.builder()
            .productId(35455)
            .priceList(1)
            .startDate(LocalDateTime.parse("2020-06-14 00:00:00", formatter))
            .endDate(LocalDateTime.parse("2020-12-31 12:59:59", formatter))
            .price(35.5)
            .build();
  }

  public PriceResponseDTO providerFourthPriceResponseDTO() {
    return PriceResponseDTO.builder()
            .productId(35455)
            .priceList(3)
            .startDate(LocalDateTime.parse("2020-06-15 00:00:00", formatter))
            .endDate(LocalDateTime.parse("2020-06-15 11:00:00", formatter))
            .price(30.5)
            .build();
  }

  public PriceResponseDTO providerFifthPriceResponseDTO() {
    return PriceResponseDTO.builder()
            .productId(35455)
            .priceList(4)
            .startDate(LocalDateTime.parse("2020-06-15 16:00:00", formatter))
            .endDate(LocalDateTime.parse("2020-12-31 23:59:59", formatter))
            .price(38.95)
            .build();
  }
}
