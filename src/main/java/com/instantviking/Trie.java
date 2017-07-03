package com.instantviking;

import java.util.HashMap;
import java.util.Map;

/**
 * Imperative Trie-implementation for strings, inserts change the Trie in-place.
 *
 * Very much not built for thread-safety.
 */
public class Trie {

    // if a key is present, then the prefix exists
    private final Map<Character, Trie> tries = new HashMap<>();
    // if a trie is a terminator, it means that a word ended here
    private boolean terminator = false;

    public void insert(String word) {
        if (word == null || word.length() == 0) {
            this.terminator = true;
            return;
        }

        Character prefix = word.charAt(0);
        String suffix = word.substring(1);

        Trie suffixTrie;
        if (!tries.containsKey(prefix)) {
            suffixTrie = new Trie();
            tries.put(prefix, suffixTrie);
        } else {
            suffixTrie = tries.get(prefix);
        }

        suffixTrie.insert(suffix);
    }

    public boolean contains(String word) {
        if (word != null && word.length() == 0) {
            return terminator;
        }

        Character prefix = word.charAt(0);
        String suffix = word.substring(1);

        if (tries.containsKey(prefix)) {
            return tries.get(prefix).contains(suffix);
        }
        return false;
    }

    /**
     * same as 'contains', but isn't concerned with whether the prefix is an entire word
     */
    public boolean includesPrefix(String word) {
        if (word != null && word.length() == 0) {
            return true;
        }

        Character prefix = word.charAt(0);
        String suffix = word.substring(1);

        if (tries.containsKey(prefix)) {
            return tries.get(prefix).includesPrefix(suffix);
        }
        return false;
    }
}
