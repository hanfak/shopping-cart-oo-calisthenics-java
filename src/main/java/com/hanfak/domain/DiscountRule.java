package com.hanfak.domain;

import lombok.Value;

@Value
public class DiscountRule {
  String itemName;
  int amountOfItemsToApplyDiscount;
  long discountAmount;
}