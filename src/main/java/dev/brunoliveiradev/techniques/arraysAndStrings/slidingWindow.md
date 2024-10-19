# Sliding Window Technique

The **Sliding Window** technique is a common approach to solving problems related to arrays and strings. It helps in
tracking a subset (or window) of elements in a sequence and dynamically adjusting its size by moving pointers (left and
right). This technique is useful for problems like finding the maximum sum of subarrays, counting valid subarrays, or
determining the longest sequence that satisfies a condition.

## How It Works:

- You maintain a **window** defined by two pointers: **left** and **right**.
- The window represents a subarray or substring that satisfies certain conditions.
- **Expand** the window by moving the `right` pointer to include more elements.
- **Shrink** the window by moving the `left` pointer to maintain the required conditions.
- **Update** your result (e.g., maximum length, sum, or count) during each step of the expansion or shrinkage.

## When to Use Sliding Window

- **Subarrays/substrings**: Problems that involve finding subarrays or substrings meeting a specific criterion (e.g.,
  sum, product, unique elements).
- **Contiguous sequences**: When elements in the array or string need to be contiguous.
- **Optimal/efficient solutions**: When a brute-force approach involves nested loops, and a linear time solution is
  desired.

## Types of Problems Solved with Sliding Window

1. **Fixed Window Size**: Find the maximum/minimum sum or average for subarrays of fixed size `k`.
2. **Variable Window Size**: Find the longest subarray/substring that meets a specific condition (e.g., sum ≤ `k`, at
   most `x` zeros).
3. **Counting Subarrays**: Count the number of subarrays meeting specific criteria, such as a product being less than
   `k`.

## Classic Examples:

### 1. Find the Length of the Longest Subarray with Sum ≤ k

```java
public static int findMaxLength(int[] nums, int k) {
    int left = 0, currSum = 0, maxLength = 0;

    for (int right = 0; right < nums.length; right++) {
        currSum += nums[right]; // Add the current element to the window sum.

        // If the current sum exceeds k, shrink the window from the left.
        while (currSum > k) {
            currSum -= nums[left]; // Remove the left element from the window sum.
            left++;
        }

        // Update the maximum window size.
        maxLength = Math.max(maxLength, right - left + 1);
    }

    return maxLength;
}
```

* Edge Cases: Empty array (nums.length == 0), large k, negative numbers in nums.

### 2. Find the Length of the Longest Substring with At Most One ‘0’

```java
public static int findLength(String s) {
    int left = 0, zeroCount = 0, maxLength = 0;

    for (int right = 0; right < s.length(); right++) {
        if (s.charAt(right) == '0') {
            zeroCount++; // Count the number of '0's in the current window.
        }

        // If there are more than one '0's, shrink the window from the left.
        while (zeroCount > 1) {
            if (s.charAt(left) == '0') {
                zeroCount--;
            }
            left++;
        }

        // Update the maximum window size.
        maxLength = Math.max(maxLength, right - left + 1);
    }

    return maxLength;
}
```

* Edge Cases: Empty string, string with only ‘0’s or no ‘0’s.

### 3. Count Subarrays Where the Product is Less Than k

```java
public static int numSubarrayProductLessThanK(int[] nums, int k) {
    if (k <= 1) return 0;

    int count = 0, left = 0;
    long currProduct = 1;

    for (int right = 0; right < nums.length; right++) {
        currProduct *= nums[right]; // Multiply the current element into the window product.

        // If the current product exceeds or equals k, shrink the window from the left.
        while (currProduct >= k) {
            currProduct /= nums[left]; // Divide the left element out of the window product.
            left++;
        }

        // Count the valid subarrays ending at the current right index.
        count += right - left + 1;
    }

    return count;
}
```

* Edge Cases: k <= 1, negative values in nums, single-element arrays.

### 4. Find the Maximum Sum of a Subarray with Fixed Length k

```java
public static int findBestSubarray(int[] nums, int k) {
    int currSum = 0;

    // Build the sum of the first window of size k.
    for (int i = 0; i < k; i++) {
        currSum += nums[i];
    }

    int maxSum = currSum;

    // Slide the window across the array and update the sum.
    for (int i = k; i < nums.length; i++) {
        currSum += nums[i] - nums[i - k]; // Add the new element and remove the old one from the sum.
        maxSum = Math.max(maxSum, currSum); // Update the maximum sum.
    }

    return maxSum;
}
```

* Edge Cases: k > nums.length, negative numbers in nums.

### Complexity:

* **Time Complexity**: O(n), where n is the length of the sequence. Each element is processed at most twice (once when
  the right
  pointer moves forward and once when the left pointer moves forward).
* **Space Complexity**: O(1), since only a few extra variables are used to maintain the window.

### Advantages:

* **Efficiency**: Allows solving problems in linear time by avoiding nested loops.
* **Simplicity**: Provides a straightforward way to handle sequences and maintain dynamic windows satisfying given
  constraints.
* **Versatility**: Applicable to a wide range of problems involving contiguous sequences.

### Conclusion:

The Sliding Window technique is essential for optimizing problems involving subarrays or substrings in arrays and
strings. By dynamically adjusting the window size based on conditions, you can efficiently find optimal solutions in
scenarios where brute-force methods are impractical.
