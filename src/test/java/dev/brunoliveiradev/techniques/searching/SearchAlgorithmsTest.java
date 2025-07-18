package dev.brunoliveiradev.techniques.searching;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchAlgorithmsTest {

    private Node root;
    private Node targetNode;

    @BeforeEach
    void setUp() {
        // Criando uma árvore para testar
        //       1
        //     / | \
        //    2  3  4
        //   /   |   \
        //  5    6    7
        //      / \
        //     8   9

        root = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);

        root.addChild(node2);
        root.addChild(node3);
        root.addChild(node4);

        node2.addChild(node5);
        node3.addChild(node6);
        node4.addChild(node7);

        node6.addChild(node8);
        node6.addChild(node9);

        targetNode = node9;
    }

    @Test
    void breadthFirstSearchShouldFindExistingValue() {
        Node result = SearchAlgorithms.breadthFirstSearch(root, 9);
        assertEquals(9, result.value);
    }

    @Test
    void breadthFirstSearchShouldReturnNullForNonExistingValue() {
        Node result = SearchAlgorithms.breadthFirstSearch(root, 99);
        assertNull(result);
    }

    @Test
    void breadthFirstSearchShouldReturnNullForNullRoot() {
        Node result = SearchAlgorithms.breadthFirstSearch(null, 9);
        assertNull(result);
    }

    @Test
    void breadthFirstSearchShouldFindRootValue() {
        Node result = SearchAlgorithms.breadthFirstSearch(root, 1);
        assertEquals(1, result.value);
        assertSame(root, result);
    }

    @Test
    void depthFirstSearchUsingStackShouldFindExistingValue() {
        Node result = SearchAlgorithms.depthFirstSearchUsingStack(root, 9);
        assertEquals(9, result.value);
    }

    @Test
    void depthFirstSearchUsingStackShouldReturnNullForNonExistingValue() {
        Node result = SearchAlgorithms.depthFirstSearchUsingStack(root, 99);
        assertNull(result);
    }

    @Test
    void depthFirstSearchUsingStackShouldReturnNullForNullRoot() {
        Node result = SearchAlgorithms.depthFirstSearchUsingStack(null, 9);
        assertNull(result);
    }

    @Test
    void depthFirstSearchUsingStackShouldFindRootValue() {
        Node result = SearchAlgorithms.depthFirstSearchUsingStack(root, 1);
        assertEquals(1, result.value);
        assertSame(root, result);
    }

}