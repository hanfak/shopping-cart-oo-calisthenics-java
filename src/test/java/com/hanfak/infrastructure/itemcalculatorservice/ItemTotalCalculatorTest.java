package com.hanfak.infrastructure.itemcalculatorservice;

import com.hanfak.domain.Item;
import com.hanfak.repository.ScannedItemsRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import stubs.ScannedItemsStub;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ItemTotalCalculatorTest {

  @Test
  public void findTotalOfOneItem() {
    ScannedItemsRepository scannedItems = new ScannedItemsStub();
    scannedItems.addItem(ITEM_A);
    when(discountedItemCalculator.calculate(scannedItems)).thenReturn(BigDecimal.valueOf(50L));
    when(nonDiscountedItemCalculator.calculate(scannedItems)).thenReturn(BigDecimal.ZERO);

    Assertions.assertThat(underTest.calculateTotal(scannedItems)).isEqualTo(BigDecimal.valueOf(50L));
  }

  @Test
  public void findTotalOfMultipleItems() {
    ScannedItemsRepository scannedItems = new ScannedItemsStub();
    scannedItems.addItem(ITEM_A);
    scannedItems.addItem(ITEM_B);
    scannedItems.addItem(ITEM_C);
    scannedItems.addItem(ITEM_D);
    when(discountedItemCalculator.calculate(scannedItems)).thenReturn(BigDecimal.valueOf(80L));
    when(nonDiscountedItemCalculator.calculate(scannedItems)).thenReturn(BigDecimal.valueOf(35L));

    Assertions.assertThat(underTest.calculateTotal(scannedItems)).isEqualTo(BigDecimal.valueOf(115L));
  }

  private static final Item ITEM_A = new Item("A", BigDecimal.valueOf(50L));
  private static final Item ITEM_B = new Item("B", BigDecimal.valueOf(30L));
  private static final Item ITEM_C = new Item("C", BigDecimal.valueOf(20L));
  private static final Item ITEM_D = new Item("D", BigDecimal.valueOf(15L));

  private final DiscountedItemCalculator discountedItemCalculator = mock(DiscountedItemCalculator.class);
  private final NonDiscountedItemCalculator nonDiscountedItemCalculator = mock(NonDiscountedItemCalculator.class);
  private final ItemTotalCalculator underTest = new ItemTotalCalculator(discountedItemCalculator, nonDiscountedItemCalculator);
}