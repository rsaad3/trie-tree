package org.trie;

public class Main {
    public static void main(String[] args) {


        TrieTree trie = new TrieTree();

        System.out.println("Insert 'apple'");
        trie.insert("apple");

        System.out.println("Lookup 'apple': " + trie.lookup("apple"));
        System.out.println("Lookup 'app': " + trie.lookup("app"));

        System.out.println("Insert 'app'");
        trie.insert("app");

        System.out.println("Lookup 'app': " + trie.lookup("app"));

        System.out.println("Update 'app' to 'application'");
        trie.update("app", "application");
        System.out.println("Lookup 'application': " + trie.lookup("application"));
        System.out.println("Lookup 'app': " + trie.lookup("app"));

        System.out.println("Delete 'apple'");
        trie.delete("apple");
        System.out.println("Lookup 'apple': " + trie.lookup("apple"));

    }
}