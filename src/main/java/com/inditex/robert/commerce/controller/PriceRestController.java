package com.inditex.robert.commerce.controller;

import com.inditex.robert.commerce.service.PriceService;
import com.inditex.robert.commerce.util.dtos.price.PriceResponseDTO;
import com.inditex.robert.commerce.util.exceptions.CommerceExceptions;
import com.inditex.robert.commerce.util.respoonse.CommerceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/commerce/v1")
public class PriceRestController {

  private final PriceService priceService;

  @Autowired
  public PriceRestController(final PriceService priceService) {
    this.priceService = priceService;
  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping("/price/{applicationDate}/{productId}/{brandId}")
  public CommerceResponse<PriceResponseDTO> getPriceByProductIdAndBrandId(
      @PathVariable String applicationDate,
      @PathVariable Integer productId,
      @PathVariable Integer brandId)
      throws CommerceExceptions {
    return new CommerceResponse<>(
        "Success",
        String.valueOf(HttpStatus.OK),
        "OK",
        priceService.findPrice(applicationDate, productId, brandId));
  }
}
