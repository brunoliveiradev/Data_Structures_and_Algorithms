# Two Pointers Technique

The **Two Pointers** technique is an efficient approach used to solve problems where you need to process sequential
data, such as arrays or strings, in an optimized manner. It involves the use of two pointers that can start from
different positions and move in different directions.
The Two Pointers technique is widely used because it allows solving problems in linear time, avoiding more costly
approaches like O(n²).

## How It Works:

- Typically, you use two pointers named **left** and **right**.
- Depending on the problem, these pointers can start at the extremes (one at the beginning and the other at the end) or
  both at the start.
- The idea is to move one or both pointers in each step, usually with the goal of reducing or expanding the "window"
  they represent until a condition is satisfied.

## Types of Problems Solved with Two Pointers:

1. **Palindrome Check**: Compare the first and last characters of a string, moving the pointers towards the center.
2. **Two Sum Problem**: Given a sorted array, find two numbers that sum to a target value by moving the pointers (one
   starting at the beginning and the other at the end) until the correct sum is found.
3. **Merging Two Lists**: Move pointers along two lists to compare or merge them.

## Classic Example:

Checking if a string is a palindrome:

```java
public static boolean isPalindrome(String s) {
    int left = 0;
    int right = s.length() - 1;

    while (left < right) {
        if (s.charAt(left) != s.charAt(right)) {
            return false; // Not a palindrome if characters don't match.
        }
        left++;  // Move left pointer to the right.
        right--; // Move right pointer to the left.
    }
    return true; // It's a palindrome if all characters match.
}
```

## Complexity:

* **Time**: Usually O(n), where n is the length of the sequence. This is because, in an ideal scenario, each pointer
  moves at most n times.
* **Space**: O(1), since we generally only use a few extra variables, like the two pointers.

## Advantages:

* Simplicity and efficiency, especially in problems where comparing or operating on pairs of elements in a sequence is
  required.
* Reduces the need for nested loops, making solutions more efficient.
