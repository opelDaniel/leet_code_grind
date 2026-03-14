package medium;

import java.util.ArrayList;
import java.util.List;

public class Daily1415 {

    List<String> results = new ArrayList<>();

    public String getHappyString(int n, int k) {
        long possibleCombinations = (long) (3 * Math.pow(2, n - 1));

        if (possibleCombinations >= k) {
            backtrack(n, new StringBuilder());
            return results.get(k - 1);
        }
        return "";
    }

    private void backtrack(int n, StringBuilder current) {
        if (current.length() >= n) {
            results.add(current.toString());
            return;
        }
        for (char c : new char[]{'a', 'b', 'c'}) {
            if (current.isEmpty() || current.charAt(current.length() - 1) != c) {
                current.append(c);
                backtrack(n, current);
                current.deleteCharAt(current.length() - 1);
            }
        }
    }

    private long factorial(long number) {
        if (number == 0) {
            return 1;
        }
        return number * factorial(number - 1);
    }

    private int sumDigits(int number) {
        var stringNumber = String.valueOf(number);
        if (stringNumber.length() == 1) {
            return number;
        }
        return Character.getNumericValue(stringNumber.charAt(0)) + sumDigits(Integer.parseInt(stringNumber.substring(1)));
    }

    private String reverse(String string) {
        if (string.isBlank()) {
            return "";
        }

        return string.charAt(string.length() - 1) + reverse(string.substring(0, string.length() - 1));
    }

    private boolean isPalindrome(String string) {
        if (string.isEmpty() || string.length() == 1) {
            return true;
        }

        return (string.charAt(0) == string.charAt(string.length() - 1)) && isPalindrome(string.substring(1, string.length() - 1));
    }

    private long fib(long n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 1;

        return fib(n - 1) + fib(n - 2);
    }

    private long pow(long n, int power) {
        if (power == 0) return 1;
        if (power == 1) return n;

        if (power % 2 == 0) {
            var result = pow(n, power / 2);
            return result * result;
        } else {
            return n * pow(n, power - 1);
        }
    }

    private int binarySearch(int searched, int[] numbers, int left, int right) {
        var mid = (left + right) / 2;

        if (numbers[mid] == searched) {
            return mid;
        }
        if (left > right) {
            return -1;
        }

        return searched > numbers[mid] ? binarySearch(searched, numbers, mid +1, right) : binarySearch(searched, numbers, left, mid -1);
    }
}
