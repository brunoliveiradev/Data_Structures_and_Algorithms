# Prefix Sum Technique

The **Prefix Sum** technique is a common approach used to quickly answer queries about cumulative sums within an array.
It involves creating a prefix sum array that allows for efficient computation of subarray sums. This method is
particularly useful when you have to deal with multiple range queries on an array, such as calculating the sum of
elements between given indices.

## How It Works:

1. Create a **Prefix Sum Array**:
    - This array stores cumulative sums from the start of the original array up to each index.
    - The element at `prefix[i]` will contain the sum of all elements of the input array from index `0` to `i`.

2. Compute the sum of any subarray using the prefix sum array:
    - The sum of elements between indices `i` and `j` of the original array can be computed as:
      ```
      sum(i, j) = prefix[j] - prefix[i - 1]
      ```
    - If `i` is `0`, the sum is simply `prefix[j]`.

## When to Use Prefix Sum

- **Frequent Range Queries**: When you need to quickly calculate the sum of elements within multiple subarrays of the
  original array.
- **Static Arrays**: The technique is most useful when the array does not change frequently, as modifications would
  require recalculating the prefix sum array.
- **Accumulating Values**: When solving problems that involve accumulation, such as counting prefix sums, differences,
  or specific conditions on subarrays.

## Types of Problems Solved with Prefix Sum

1. **Subarray Sum Queries**: Efficiently find the sum of elements within any given range in an array.
2. **Counting Subarrays with Given Sum**: Find the number of subarrays that add up to a particular sum.
3. **Cumulative Data Analysis**: Analyze cumulative data in scenarios like rainfall, temperature, stock prices, etc.

## Classic Examples

### 1. Constructing a Prefix Sum Array

```java
public static int[] buildPrefixSum(int[] nums) {
    int[] prefix = new int[nums.length];
    prefix[0] = nums[0];

    for (int i = 1; i < nums.length; i++) {
        prefix[i] = prefix[i - 1] + nums[i];
    }

    return prefix;
}
```

* Usage: This builds the prefix sum array for any integer array nums.

### 2. Sum of Subarray in Constant Time

```java
public static int sumRange(int[] prefix, int i, int j) {
    if (i == 0) return prefix[j];
    return prefix[j] - prefix[i - 1];
}
```

* Edge Cases: Handle the case when `i` is `0` to avoid out-of-bounds issues.

### 3. Answer Queries Efficiently Using Prefix Sums

```java
public boolean[] answerQueries(int[] nums, int[][] queries, int limit) {
    boolean[] answer = new boolean[queries.length];
    int[] prefix = buildPrefixSum(nums);

    for (int i = 0; i < queries.length; i++) {
        int x = queries[i][0], y = queries[i][1];

        int current = sumRange(prefix, x, y);

        answer[i] = current < limit;
    }

    return answer;
}
```

* Use Case: For a given list of queries, determine if the sum of elements between the indices specified in each query is
  less than a certain limit.

### 4. Counting Ways to Split Array Using Prefix Sum

```java
public int waysToSplitArray(int[] nums) {
    int answer = 0;
    long leftSum = 0;
    long totalSum = 0;

    // Calculate total sum of the array
    for (int num : nums) {
        totalSum += num;
    }

    // Iterate through possible split points
    for (int i = 0; i < nums.length - 1; i++) {
        leftSum += nums[i];
        long rightSum = totalSum - leftSum;

        if (leftSum >= rightSum) {
            answer++;
        }
    }

    return answer;
}
```

* Space Optimization: Uses a single running sum for leftSum without explicitly creating a prefix sum array, thus
  reducing space complexity to O(1).

### Complexity

* Time Complexity:
    * Constructing the prefix sum array: O(n).
    * Querying the sum of any subarray: O(1) per query.

* Space Complexity: O(n) - Requires additional space for the prefix sum array.

#### Advantages

* Efficient Range Queries: Allows for rapid subarray sum calculations after a linear time preprocessing step.
* Simple Logic: Provides a straightforward way to precompute cumulative data and quickly answer sum-related queries.
* Improved Performance: Drastically reduces the time complexity for multiple range queries compared to a brute-force
  approach.