package com.inditex.robert.commerce.controller;

import com.inditex.robert.commerce.provider.PriceResponseProvider;
import com.inditex.robert.commerce.service.PriceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PriceRestController.class)
class PriceRestControllerTest extends PriceResponseProvider {

  private static final String APPLICATION_DATE_FIRST = "2020-06-14 10:00:00";
  private static final String APPLICATION_DATE_SECOND = "2020-06-14 16:00:00";
  private static final String APPLICATION_DATE_THIRD = "2020-06-14 21:00:00";
  private static final String APPLICATION_DATE_FOURTH = "2020-06-15 10:00:00";
  private static final String APPLICATION_DATE_FIFTH = "2020-06-16 21:00:00";
  private static final Integer PRODUCT_ID = 35455;
  private static final Integer BRAND_ID = 1;

  @MockBean PriceService priceService;
  @Autowired private MockMvc mvc;

  @Test
  public void shouldReturnTheAppliedPriceForTheFirstDate() throws Exception {
    when(priceService.findPrice(APPLICATION_DATE_FIRST, PRODUCT_ID, BRAND_ID))
        .thenReturn(providerFirtsPriceResponseDTO());

    mvc.perform(
            MockMvcRequestBuilders.get(
                    "/commerce/v1/price/"
                        .concat(APPLICATION_DATE_FIRST)
                        .concat("/")
                        .concat(String.valueOf(PRODUCT_ID))
                        .concat("/")
                        .concat(String.valueOf(BRAND_ID)))
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.data.priceList").value(1));
    verify(priceService).findPrice(APPLICATION_DATE_FIRST, PRODUCT_ID, BRAND_ID);
  }

  @Test
  public void shouldReturnTheAppliedPriceForTheSecondDate() throws Exception {
    when(priceService.findPrice(APPLICATION_DATE_SECOND, PRODUCT_ID, BRAND_ID))
        .thenReturn(providerSecondPriceResponseDTO());

    mvc.perform(
            MockMvcRequestBuilders.get(
                    "/commerce/v1/price/"
                        .concat(APPLICATION_DATE_SECOND)
                        .concat("/")
                        .concat(String.valueOf(PRODUCT_ID))
                        .concat("/")
                        .concat(String.valueOf(BRAND_ID)))
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.data.priceList").value(2));
    verify(priceService).findPrice(APPLICATION_DATE_SECOND, PRODUCT_ID, BRAND_ID);
  }

  @Test
  public void shouldReturnTheAppliedPriceForTheThirdDate() throws Exception {
    when(priceService.findPrice(APPLICATION_DATE_THIRD, PRODUCT_ID, BRAND_ID))
        .thenReturn(providerThirdPriceResponseDTO());

    mvc.perform(
            MockMvcRequestBuilders.get(
                    "/commerce/v1/price/"
                        .concat(APPLICATION_DATE_THIRD)
                        .concat("/")
                        .concat(String.valueOf(PRODUCT_ID))
                        .concat("/")
                        .concat(String.valueOf(BRAND_ID)))
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.data.priceList").value(1));
    verify(priceService).findPrice(APPLICATION_DATE_THIRD, PRODUCT_ID, BRAND_ID);
  }

  @Test
  public void shouldReturnTheAppliedPriceForTheFourthDate() throws Exception {
    when(priceService.findPrice(APPLICATION_DATE_FOURTH, PRODUCT_ID, BRAND_ID))
        .thenReturn(providerFourthPriceResponseDTO());

    mvc.perform(
            MockMvcRequestBuilders.get(
                    "/commerce/v1/price/"
                        .concat(APPLICATION_DATE_FOURTH)
                        .concat("/")
                        .concat(String.valueOf(PRODUCT_ID))
                        .concat("/")
                        .concat(String.valueOf(BRAND_ID)))
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.data.priceList").value(3));
    verify(priceService).findPrice(APPLICATION_DATE_FOURTH, PRODUCT_ID, BRAND_ID);
  }

  @Test
  public void shouldReturnTheAppliedPriceForTheFifthDate() throws Exception {
    when(priceService.findPrice(APPLICATION_DATE_FIFTH, PRODUCT_ID, BRAND_ID))
        .thenReturn(providerFifthPriceResponseDTO());

    mvc.perform(
            MockMvcRequestBuilders.get(
                    "/commerce/v1/price/"
                        .concat(APPLICATION_DATE_FIFTH)
                        .concat("/")
                        .concat(String.valueOf(PRODUCT_ID))
                        .concat("/")
                        .concat(String.valueOf(BRAND_ID)))
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.data.priceList").value(4));
    verify(priceService).findPrice(APPLICATION_DATE_FIFTH, PRODUCT_ID, BRAND_ID);
  }
}
