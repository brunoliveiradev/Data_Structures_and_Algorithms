# Arrays Overview

## Advantages

* Store multiple elements of the same type with one single variable name
* Accessing elements is fast as long as you have the index, as opposed to _**linked lists**_ where you have to traverse
  from the head.

## Disadvantages

* Slow addition/removal of elements in the middle due to shifting.
* Fixed size in certain languages, cannot alter size after initialization.
* Insertion that exceeds the array size requires allocation of a new array and copying elements.
* The act of creating a new array and transferring elements overtakes O(n) time.

## Common terms

* **Subarray**: A contiguous sequence of elements within an array.
    - **Example**: given an array `[2, 3, 6, 1, 5, 4]`, `[3, 6, 1]` is a subarray while `[3, 1, 5]` is not a subarray.
* **Subsequence**: A sequence that can be derived from another sequence by deleting some or no elements without changing
  the order of the remaining elements.
    - **Example**: given an array `[2, 3, 6, 1, 5, 4]`, `[3, 1, 5]` is a subsequence but `[3, 5, 1]` is not a
      subsequence.
* **Prefix**: A subarray that starts at the beginning of the array.
* **Suffix**: A subarray that ends at the end of the array.
* **Sliding Window**: A subarray that runs over a range of elements in the array.
* **Two-pointer**: A technique that uses two pointers to solve problems that deal with arrays or linked lists.
* **Resizable Array**: An array that can increase or decrease in size.
* **Dynamic Array**: An array that can increase or decrease in size.

-----------------------

## Array vs ArrayList

**Array:**

* **Fixed-size**, stores multiples elements of the same data type, both primitive and reference types
* Declaration with square brackets: `int[] numbers`
* Access elements using 0-based index (`numbers[0]`)
* Determine length using `lenght` **attribute**: `numbers.length`
* **Limitations**: fixed size, same data type for all elements.

**ArrayList (Dynamic Array):**

* **Resizable**, stores reference types (wrapper classes for primitives)
* Part of **Java Collections Framework**: `java.util` package
* Access elements using `get()` method with index: `numbers.get(0)`;
* Determine size using `size()` method: `numbers.size();`
* **Suppress limitations of regular array**: boxing/unboxing, resizing performances, flexibility.

-----------------------

## Big(O)

### Arrays (List in Java) vs. Slices (Go)

| **Operation**              | **Java Array/List** | **Go Slice**       |
|----------------------------|---------------------|--------------------|
| Appending to end           | *O(1) (Amortized)*  | *O(1) (Amortized)* |
| Popping from end           | O(1)                | O(1)               |
| Insertion, not from end    | O(n)                | O(n)               |
| Deletion, not from end     | O(n)                | O(n)               |
| Modifying an element       | O(1)                | O(1)               |
| Random access              | O(1)                | O(1)               |
| Checking if element exists | O(n)                | O(n)               |

### Arrays vs. Linked Lists vs. Dynamic Arrays

| **Operation**              | **Array** | **Linked List** | **Dynamic Array** |
|----------------------------|-----------|-----------------|-------------------|
| Appending to end           | O(1)      | O(1)            | O(1) (Amortized)  |
| Popping from end           | O(1)      | O(n)            | O(1)              |
| Insertion, not from end    | O(n)      | O(1)            | O(n)              |
| Deletion, not from end     | O(n)      | O(1)            | O(n)              |
| Modifying an element       | O(1)      | O(n)            | O(1)              |
| Random access              | O(1)      | O(n)            | O(1)              |
| Checking if element exists | O(n)      | O(n)            | O(n)              |

-----------------------

# Techniques

Note that because both arrays and strings are sequences (a string is an array of characters), most of the techniques
here will apply to string problems.

* **[Two Pointers](../techniques/twoPointers.md)**: General version of sliding window, can be on different arrays.
* **Sliding Window:** Useful for subarray/substring problems, ensuring each value is visited at most twice.
* **Prefix Sum**: Useful for range sum queries.
* **Fast and Slow Pointers**: Useful for finding cycles or middle of the linked list.
* **Traversing from the Right**: Sometimes useful to traverse from the right instead of the left.
* **Sorting the Array**: Sorting can simplify problems, especially if the array is already sorted or partially sorted.
* **Precomputation**: Useful for summation or multiplication of a subarray.
* **Index as a Hash Key**: Using the array itself as a hash table for O(1) space solutions.
* **Traversing the Array More Than Once**: Traversing twice/thrice can help solve problems while keeping time complexity
  to O(n).

## Corner cases

* Empty sequence
* Sequence with 1 or 2 elements
* Sequence with repeated elements
* Duplicated values in the sequence

-----------------------

## Things to look out

* Clarify if there are duplicate values in the array. Would the presence of duplicate values affect the answer? Does it
  make the question simpler or harder?
* When using an index to iterate through array elements, be careful not to **go out of bounds**.
* Be mindful about slicing or concatenating arrays in your code. Typically, **slicing and concatenating arrays would
  take O(n) time**.
  - Use start and end indices to demarcate a subarray/range where possible.