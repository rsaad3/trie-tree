package org.trie;


public class TrieTree {
    private final TrieNode root;

    // Create
    public TrieTree() {
        root = new TrieNode();
    }

    // Insert
    public void insert(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            current = current.children.computeIfAbsent(ch, c -> new TrieNode());
        }
        current.isEndOfWord = true;
    }

    public boolean lookup(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            TrieNode node = current.children.get(ch);
            if (node == null) return false;
            current = node;
        }
        return current.isEndOfWord;
    }

    public boolean delete(String word) {
        return deleteHelper(root, word, 0);
    }

    private boolean deleteHelper(TrieNode current, String word, int index) {
        if (index == word.length()) {
            if (!current.isEndOfWord) return false;
            current.isEndOfWord = false;
            return current.children.isEmpty();
        }
        char ch = word.charAt(index);
        TrieNode node = current.children.get(ch);
        if (node == null) return false;
        boolean shouldDeleteCurrentNode = deleteHelper(node, word, index + 1);
        if (shouldDeleteCurrentNode) {
            current.children.remove(ch);
            return current.children.isEmpty() && !current.isEndOfWord;
        }
        return false;
    }

    public boolean update(String oldWord, String newWord) {
        if (!lookup(oldWord)) {
            return false;
        }
        delete(oldWord);
        insert(newWord);
        return true;
    }
}

