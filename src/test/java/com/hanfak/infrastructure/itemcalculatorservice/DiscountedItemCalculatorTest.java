package com.hanfak.infrastructure.itemcalculatorservice;

import com.hanfak.domain.Item;
import com.hanfak.repository.DiscountedItemRepository;
import com.hanfak.repository.ScannedItemsRepository;
import org.junit.Test;
import stubs.DiscountedItemsStub;
import stubs.ScannedItemsStub;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class DiscountedItemCalculatorTest {

  @Test
  public void findTotalOfDiscountAppliedOnlyOneAItemsScanned() {
    ScannedItemsRepository scannedItems = new ScannedItemsStub();
    scannedItems.addItem(ITEM_A);

    BigDecimal actualTotal = underTest.calculate(scannedItems);

    assertThat(actualTotal).isEqualTo(BigDecimal.valueOf(50L));
  }

  @Test
  public void findTotalOfDiscountAppliedWithThreeAItemsScanned() {
    ScannedItemsRepository scannedItems = new ScannedItemsStub();
    scannedItems.addItem(ITEM_A);
    scannedItems.addItem(ITEM_A);
    scannedItems.addItem(ITEM_A);

    BigDecimal actualTotal = underTest.calculate(scannedItems);

    assertThat(actualTotal).isEqualTo(BigDecimal.valueOf(130L));
  }

  @Test
  public void findTotalOfDiscountAppliedOnlyOneBItemsScanned() {
    ScannedItemsRepository scannedItems = new ScannedItemsStub();
    scannedItems.addItem(ITEM_B);

    BigDecimal actualTotal = underTest.calculate(scannedItems);

    assertThat(actualTotal).isEqualTo(BigDecimal.valueOf(30L));
  }

  @Test
  public void findTotalOfDiscountAppliedWithTwoBItemsScanned() {
    ScannedItemsRepository scannedItems = new ScannedItemsStub();
    scannedItems.addItem(ITEM_B);
    scannedItems.addItem(ITEM_B);

    BigDecimal actualTotal = underTest.calculate(scannedItems);

    assertThat(actualTotal).isEqualTo(BigDecimal.valueOf(45L));
  }

  @Test
  public void findTotalOfCombinationOfDiscountedAAndBItems() {
    ScannedItemsRepository scannedItems = new ScannedItemsStub();
    scannedItems.addItem(ITEM_A);
    scannedItems.addItem(ITEM_A);
    scannedItems.addItem(ITEM_A);
    scannedItems.addItem(ITEM_B);
    scannedItems.addItem(ITEM_B);

    BigDecimal actualTotal = underTest.calculate(scannedItems);

    assertThat(actualTotal).isEqualTo(BigDecimal.valueOf(175L));
  }

  @Test
  public void findTotalOfCombinationOfDiscountedAAndNoDiscountAppliedToBItems() {
    ScannedItemsRepository scannedItems = new ScannedItemsStub();
    scannedItems.addItem(ITEM_A);
    scannedItems.addItem(ITEM_A);
    scannedItems.addItem(ITEM_A);
    scannedItems.addItem(ITEM_B);

    BigDecimal actualTotal = underTest.calculate(scannedItems);

    assertThat(actualTotal).isEqualTo(BigDecimal.valueOf(160L));
  }

  @Test
  public void findTotalOfCombinationOfDiscountedBAndNoDiscountAppliedToAItems() {
    ScannedItemsRepository scannedItems = new ScannedItemsStub();
    scannedItems.addItem(ITEM_A);
    scannedItems.addItem(ITEM_A);
    scannedItems.addItem(ITEM_B);
    scannedItems.addItem(ITEM_B);

    BigDecimal actualTotal = underTest.calculate(scannedItems);

    assertThat(actualTotal).isEqualTo(BigDecimal.valueOf(145L));
  }

  @Test
  public void findTotalOfCombinationOfDiscountedItemsWhereNoDiscountApplied() {
    ScannedItemsRepository scannedItems = new ScannedItemsStub();
    scannedItems.addItem(ITEM_A);
    scannedItems.addItem(ITEM_A);
    scannedItems.addItem(ITEM_B);

    BigDecimal actualTotal = underTest.calculate(scannedItems);

    assertThat(actualTotal).isEqualTo(BigDecimal.valueOf(130L));
  }

  @Test
  public void findTotalOfCombinationOfDiscountedItemsWhereDiscountIsBothAppliedAndNotApplied() {
    ScannedItemsRepository scannedItems = new ScannedItemsStub();
    scannedItems.addItem(ITEM_A);
    scannedItems.addItem(ITEM_A);
    scannedItems.addItem(ITEM_A);
    scannedItems.addItem(ITEM_A);
    scannedItems.addItem(ITEM_B);
    scannedItems.addItem(ITEM_B);
    scannedItems.addItem(ITEM_B);

    BigDecimal actualTotal = underTest.calculate(scannedItems);

    assertThat(actualTotal).isEqualTo(BigDecimal.valueOf(255L));
  }

  private static final Item ITEM_A = new Item("A", BigDecimal.valueOf(50L));
  private static final Item ITEM_B = new Item("B", BigDecimal.valueOf(30L));

  private final DiscountedItemRepository discountedItemRepository = new DiscountedItemsStub();
  private final DiscountedItemCalculator underTest = new DiscountedItemCalculator(discountedItemRepository);
}