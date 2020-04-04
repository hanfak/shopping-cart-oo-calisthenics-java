package com.hanfak.domain;

import lombok.Value;

import java.math.BigDecimal;

@Value public class Item {
  String name;
  BigDecimal price;
}
