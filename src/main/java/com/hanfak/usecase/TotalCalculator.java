package com.hanfak.usecase;

import com.hanfak.repository.ScannedItemsRepository;

import java.math.BigDecimal;

public interface TotalCalculator {
  BigDecimal calculateTotal(ScannedItemsRepository scannedItems);
}
