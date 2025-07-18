package dev.brunoliveiradev.techniques.searching;

import java.util.ArrayList;
import java.util.List;

// Node represents a node in a tree structure.
// In practical terms, this could model anything hierarchical, such as a file system,
// organizational structure, or any tree-like data.
public class Node {
    public int value;
    public List<Node> children;

    public Node(int value) {
        this.value = value;
        this.children = new ArrayList<>();
    }

    public void addChild(Node child) {
        this.children.add(child);
    }
}