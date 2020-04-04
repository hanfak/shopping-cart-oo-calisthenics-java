package com.hanfak.usecase;

import com.hanfak.domain.Item;
import org.junit.Test;
import com.hanfak.repository.DiscountedItemRepository;
import stubs.ScannedItemsStub;

import java.math.BigDecimal;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class NonDiscountedItemCalculatorTest {

  @Test
  public void findTotalWithOneItemAndNoDiscountedItemsAvailable() {
    ScannedItemsRepository scannedItems = new ScannedItemsStub();
    scannedItems.addItem(ITEM_C);

    BigDecimal actualTotal = underTest.calculate(scannedItems);

    assertThat(actualTotal).isEqualTo(BigDecimal.valueOf(20L));
  }

  @Test
  public void findTotalWithMutlipleItemsAndNoDiscountedItemsAvailable() {
    ScannedItemsRepository scannedItems = new ScannedItemsStub();
    scannedItems.addItem(ITEM_C);
    scannedItems.addItem(ITEM_D);

    BigDecimal actualTotal = underTest.calculate(scannedItems);

    assertThat(actualTotal).isEqualTo(BigDecimal.valueOf(35L));
  }

  @Test
  public void findTotalWithOneDiscountedItemsAvailable() {
    when(discountedItemRepository.findAllDiscountedItems())
            .thenReturn(singletonList(new Item("A", BigDecimal.valueOf(50L))));
    ScannedItemsRepository scannedItems = new ScannedItemsStub();
    scannedItems.addItem(ITEM_A);

    BigDecimal actualTotal = underTest.calculate(scannedItems);

    assertThat(actualTotal).isEqualTo(BigDecimal.ZERO);
  }

  @Test
  public void findTotalWithMultipleDiscountedItemsAvailable() {
    when(discountedItemRepository.findAllDiscountedItems()).thenReturn(discountedItems);
    ScannedItemsRepository scannedItems = new ScannedItemsStub();
    scannedItems.addItem(ITEM_A);
    scannedItems.addItem(ITEM_B);
    scannedItems.addItem(ITEM_C);
    scannedItems.addItem(ITEM_D);

    BigDecimal actualTotal = underTest.calculate(scannedItems);

    assertThat(actualTotal).isEqualTo(BigDecimal.valueOf(35L));
  }

  private static final Item ITEM_A = new Item("A", BigDecimal.valueOf(50L));
  private static final Item ITEM_B = new Item("B", BigDecimal.valueOf(30L));
  private static final Item ITEM_C = new Item("C", BigDecimal.valueOf(20L));
  private static final Item ITEM_D = new Item("D", BigDecimal.valueOf(15L));
  private final List<Item> discountedItems = asList(new Item("A", BigDecimal.valueOf(50L)),
          new Item("B", BigDecimal.valueOf(30L)));

  private final DiscountedItemRepository discountedItemRepository = mock(DiscountedItemRepository.class);
  private final NonDiscountedItemCalculator underTest = new NonDiscountedItemCalculator(discountedItemRepository);
}