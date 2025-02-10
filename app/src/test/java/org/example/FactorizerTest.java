package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;

class FactorizerTest {

  @Test
  void itReturnsAnEmptyListForZero() {
      Factorizer factorizer = new Factorizer();
      assertEquals(new ArrayList<>(), factorizer.primeFactors(0));
  }

  @Test
  void itReturnsAnEmptyListForOne() {
      Factorizer factorizer = new Factorizer();
      assertEquals(new ArrayList<>(), factorizer.primeFactors(1));
  }

  @Test
  void testIsPrime() {
      Factorizer factorizer = new Factorizer();
      assertTrue(factorizer.isPrime(37));
      assertTrue(factorizer.isPrime(2));
      assertFalse(factorizer.isPrime(100));
      assertFalse(factorizer.isPrime(1));
  }

  @Test
  void testIsComposite() {
      Factorizer factorizer = new Factorizer();
      assertTrue(factorizer.isComposite(100)); 
      assertTrue(factorizer.isComposite(28));
      assertFalse(factorizer.isComposite(37));
      assertFalse(factorizer.isComposite(1));
  }

  @Test
  void testReduce() {
      Factorizer factorizer = new Factorizer();
      assertEquals("6/13", factorizer.reduce(12, 26));
      assertEquals("1/3", factorizer.reduce(20, 60));
      assertEquals("1/8", factorizer.reduce(8, 64));
  }

  @Test
  void testPrimeFactors() {
      Factorizer factorizer = new Factorizer();
      assertEquals(Arrays.asList(2, 2, 7), factorizer.primeFactors(28));
      assertEquals(Arrays.asList(2, 2, 5, 5), factorizer.primeFactors(100));
      assertEquals(Arrays.asList(37), factorizer.primeFactors(37));
  }
}