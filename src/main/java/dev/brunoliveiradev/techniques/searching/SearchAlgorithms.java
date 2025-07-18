package dev.brunoliveiradev.techniques.searching;

import java.util.*;

// This class contains reusable implementations of tree traversal algorithms
public class SearchAlgorithms {

    // Breadth-First Search (BFS)
    //
    // Traverses the tree level by level, starting from the root.
    // It uses a queue (FIFO) to ensure that all nodes at the current depth
    // are visited before moving to the next level.
    //
    // BFS is useful for:
    // - Finding the shortest path in unweighted graphs.
    // - Level-order processing of tree-like structures.
    // - Exploring nodes closest to the root first.
    //
    // Time Complexity: O(n)
    // Space Complexity: O(w) where w is the max number of nodes at any level.
    public static Node breadthFirstSearch(Node root, int target) {
        if (root == null) return null;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.println("Visiting current value: " + current.value);

            if (current.value == target) {
                System.out.println("Found target value: " + target);
                return current;
            }

            for (Node child : current.children) {
                queue.add(child);
            }
        }

        System.out.println("No target value found");
        return null;
    }

    // Depth-First Search (DFS) using stack (iterative)
    //
    // This avoids stack overflow risk in deep trees.
    // DFS explores as far as possible along one branch before backtracking.
    //
    // Time Complexity: O(n)
    // Space Complexity: O(h) where h is the height of the tree.
    public static Node depthFirstSearchUsingStack(Node root, int target) {
        if (root == null) return null;

        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node current = stack.pop();
            System.out.println("Visiting current value: " + current.value);

            if (current.value == target) {
                System.out.println("Found target value: " + target);
                return current;
            }

            // Add children in reverse to maintain left-to-right order
            List<Node> children = current.children;
            for (int i = children.size() - 1; i >= 0; i--) {
                Node child = children.get(i);
                System.out.println("Adding child value: " + child.value + " to stack");
                stack.push(child);
            }
        }

        System.out.println("No target value found");
        return null;
    }

    // Depth-First Search (DFS) using recursion
    //
    // Elegant but beware of stack overflow on deep trees.
    public static Node depthFirstSearchUsingRecursion(Node root, int target) {
        if (root == null) return null;

        System.out.println("Visiting current value: " + root.value);

        if (root.value == target) {
            System.out.println("Found target value: " + target);
            return root;
        }

        for (Node child : root.children) {
            Node result = depthFirstSearchUsingRecursion(child, target);
            if (result != null) return result;
        }

        return null;
    }
}