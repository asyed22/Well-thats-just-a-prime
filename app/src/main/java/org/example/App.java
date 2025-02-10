package org.example;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
  public static void main(String[] args) {
      Factorizer factorizer = new Factorizer();
      Scanner scanner = new Scanner(System.in);

      System.out.println("Enter a number to check if it is prime or composite, or type 'exit' to quit:");
      while (true) {
          System.out.print("Number: ");
          String input = scanner.nextLine();

          if (input.equalsIgnoreCase("exit")) {
              System.out.println("Exiting program. Goodbye!");
              break;
          }

          try {
              int number = Integer.parseInt(input);
              if (factorizer.isPrime(number)) {
                  System.out.println(number + " is a prime number.");
              } else if (factorizer.isComposite(number)) {
                  System.out.println(number + " is a composite number.");
              } else {
                  System.out.println(number + " is neither prime nor composite.");
              }

              ArrayList<Integer> factors = factorizer.primeFactors(number);
              System.out.println("Prime factors of " + number + ": " + factors);

              System.out.print("Enter a numerator and denominator to simplify a fraction (separated by space): ");
              String fractionInput = scanner.nextLine();
              String[] parts = fractionInput.split(" ");
              if (parts.length == 2) {
                  int numerator = Integer.parseInt(parts[0]);
                  int denominator = Integer.parseInt(parts[1]);
                  System.out.println("Simplified fraction: " + factorizer.reduce(numerator, denominator));
              }

          } catch (NumberFormatException e) {
              System.out.println("Invalid input. Please enter a valid integer.");
          }
      }
      scanner.close();
  }
}