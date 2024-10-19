# Strings Overview

### **Characteristics:**

- Immutable in most languages (e.g., Java, Go).
- Once created, their values cannot be changed.

**Advantages:**

- Simplifies reasoning about code since strings cannot be altered.
- Thread-safe due to immutability.

**Disadvantages:**

- Operations that appear to modify a string actually create a new string, which can be less efficient.

### Common Terms

- **Concatenation:** Combining two or more strings end-to-end.
- **Substring:** A contiguous sequence of characters within a string.
- **Prefix:** A substring that starts at the beginning of the string.
- **Suffix:** A substring that ends at the end of the string.
- **Immutable:** Cannot be changed after creation.

-----------------------

### String vs StringBuilder (Java)

**String:**

- Immutable.
- Operations like concatenation create new strings.
- Suitable for fixed or small number of modifications.

**StringBuilder:**

- Mutable.
- Efficient for multiple modifications.
- Use `append()` for concatenation.

-----------------------

## Big(O) Complexity - Strings (Immutable in Both Java and Go)

A string is an array of characters, so the time complexities of basic string operations will closely resemble that of
array operations.

| **Operation**          | **Big-O** |
|------------------------|-----------|
| Access (Random access) | O(1)      |
| Search                 | O(n)      |
| Insert                 | O(n)      |
| Remove                 | O(n)      |

### Operations Involving Another String

Here we assume the other string is of length m.

| **Operation**                                   | **Big-O** | **Note**                                                                                                        |
|-------------------------------------------------|-----------|-----------------------------------------------------------------------------------------------------------------|
| Find substring                                  | O(n \* m) | This is the most naive case. There are more efficient algorithms for string searching such as the KMP algorithm |
| Concatenating strings                           | O(n + m)  |                                                                                                                 |
| Slice                                           | O(m)      |                                                                                                                 |
| Split (by token)                                | O(n + m)  |                                                                                                                 |
| Strip (remove leading and trailing whitespaces) | O(n)      |                                                                                                                 |

-----------------------

## Techniques

- **[Sliding Window](slidingWindow.md):** Useful for substring problems, ensuring each character is visited at most
  twice.
- **[Two Pointers](twoPointers.md):** Can be used for problems involving substrings or palindromes.
- **[Prefix Sum](prefixSum.md):** Useful for range sum queries.
- **[Couting Characters](Counting.java):** Counting the number of characters in a string can be useful for solving
  problems.
- **String of unique characters:** A neat trick to count the characters in a string of unique characters is to use a
  26-bit bitmask to indicate which lower case latin characters are inside the string.
- **Anagrams:** Anagrams are words or phrases that contain the same characters. To check if two strings are anagrams,
  you can count the frequency of characters in each string and compare them.
- **[Palindrome](../../arraysAndStrings/twoPointers/PalindromeCheck.java):** A palindrome is a word, phrase, number, or
  other sequence of characters that reads the same forward
  and backward. To check if a string is a palindrome, you can compare the characters from the start and end of the
  string.
- **Fast and Slow Pointers:** Useful for finding cycles or middle of the string.
- **Traversing from the Right:** Sometimes useful to traverse from the right instead of the left.
- **Sorting the String:** Sorting can simplify problems, especially if the string is already sorted or partially sorted.
- **Precomputation:** Useful for summation or multiplication of a substring.
- **Index as a Hash Key:** Using the string itself as a hash table for O(1) space solutions.
- **Traversing the String More Than Once:** Traversing twice/thrice can help solve problems while keeping time
  complexity to O(n).

### Corner Cases

- Empty string
- String with 1 or 2 characters
- String with repeated characters
- Duplicated values in the string

### Things to Look Out For

- Clarify if there are duplicate characters in the string. Would the presence of duplicate characters affect the answer?
  Does it make the question simpler or harder?
- When using an index to iterate through string characters, be careful not to **go out of bounds**.
- Be mindful about slicing or concatenating strings in your code. Typically, **slicing and concatenating strings would
  take O(n) time**.
    - Use start and end indices to demarcate a substring/range where possible.