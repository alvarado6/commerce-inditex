package com.inditex.robert.commerce.entity;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Price {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private LocalDateTime startDate;
  private LocalDateTime endDate;
  private Integer priceList;
  private double price;
  private String curr;
  private Integer priority;
  private Integer productId;

  @ManyToOne
  @JoinColumn(name = "brand_id", nullable = false)
  private Brand brand;
}
