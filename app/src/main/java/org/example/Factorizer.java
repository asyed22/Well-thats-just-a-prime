package org.example;

import java.util.ArrayList;

public class Factorizer {
  public ArrayList<Integer> primeFactors(Integer n) {
    ArrayList<Integer> factors = new ArrayList<>();
    if (n <= 1) {
        return factors;
    }
    while (n % 2 == 0) {
        factors.add(2);
        n /= 2;
    }
    for (int i = 3; i * i <= n; i += 2) {
        while (n % i == 0) {
            factors.add(i);
            n /= i;
        }
    }
    if (n > 2) {
        factors.add(n);
    }
    return factors;
}

public boolean isPrime(int n) {
    ArrayList<Integer> factors = primeFactors(n);
    return factors.size() == 1 && factors.get(0) == n;
}

public boolean isComposite(int n) {
    return n > 1 && !isPrime(n);
}

public String reduce(int numerator, int denominator) {
    ArrayList<Integer> numFactors = primeFactors(numerator);
    ArrayList<Integer> denomFactors = primeFactors(denominator);
    for (Integer factor : numFactors) {
        if (denomFactors.contains(factor)) {
            denomFactors.remove(factor);
            numFactors.remove(factor);
        }
    }
    int newNumerator = 1;
    for (Integer factor : numFactors) {
        newNumerator *= factor;
    }
    int newDenominator = 1;
    for (Integer factor : denomFactors) {
        newDenominator *= factor;
    }
    return newNumerator + "/" + newDenominator;
  }
}
