package org.trie;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class TrieTreeTest {

    private TrieTree trie;

    @BeforeEach
    void setUp() {
        trie = new TrieTree(); // Create new Trie before each test
    }

    @Test
    void testInsertAndLookup() {
        // Insert a word
        trie.insert("apple");

        // Verify lookup for inserted word
        assertTrue(trie.lookup("apple"), "Word 'apple' should be found after insertion");

        // Lookup for partial word should fail
        assertFalse(trie.lookup("app"), "Partial word 'app' should not be found yet");

        // Insert partial word
        trie.insert("app");
        assertTrue(trie.lookup("app"), "Now 'app' should be found");
    }

    @Test
    void testUpdate() {
        trie.insert("app");

        // Ensure original word exists
        assertTrue(trie.lookup("app"), "'app' should exist before update");

        // Update word
        boolean updated = trie.update("app", "application");
        assertTrue(updated, "Update should return true for existing word");

        // Original word should be removed
        assertFalse(trie.lookup("app"), "'app' should be removed after update");

        // New word should exist
        assertTrue(trie.lookup("application"), "'application' should exist after update");
    }

    @Test
    void testUpdateNonExistingWord() {
        // Try updating a word that does not exist
        boolean updated = trie.update("banana", "mango");
        assertFalse(updated, "Update should return false for non-existing word");

        // Ensure new word wasn't added
        assertFalse(trie.lookup("mango"), "'mango' should not exist");
    }

    @Test
    void testDelete() {
        trie.insert("apple");
        trie.insert("app");

        // Both words should exist
        assertTrue(trie.lookup("apple"), "'apple' should exist before delete");
        assertTrue(trie.lookup("app"), "'app' should exist before delete");

        // Delete "apple"
        trie.delete("apple");

        // "apple" should be removed
        assertFalse(trie.lookup("apple"), "'apple' should not exist after delete");

        // "app" should still exist
        assertTrue(trie.lookup("app"), "'app' should still exist after deleting 'apple'");
    }

    @Test
    void testDeleteNonExistingWord() {
        trie.insert("apple");

        // Delete a non-existing word
        boolean deleted = trie.delete("banana");
        assertFalse(deleted, "Delete should return false for non-existing word");

        // Original word should remain
        assertTrue(trie.lookup("apple"), "'apple' should still exist after failed delete");
    }
}
