package com.instantviking;

import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class TrieTest {

    @Test
    public void simpleNonExistence() {
        Trie base = new Trie();
        assertThat(base.contains("alfakrøll"), equalTo(false));
    }

    @Test
    public void simpleInsert() {
        Trie base = new Trie();
        base.insert("alfakrøll");
        assertThat(base.contains("alfakrøll"), equalTo(true));
    }

    @Test
    public void insertMany() {
        Trie base = new Trie();
        base.insert("alfakrøll1");
        base.insert("alfakrøll2");
        base.insert("alfakrøll3");
        base.insert("alfakrøll4");
        base.insert("alfakrøll5");
        base.insert("alfakrøll6");
        base.insert("alfakrøll7");

        assertThat(base.contains("alfakrøll1"), equalTo(true));
        assertThat(base.contains("alfakrøll2"), equalTo(true));
        assertThat(base.contains("alfakrøll3"), equalTo(true));
        assertThat(base.contains("alfakrøll4"), equalTo(true));
        assertThat(base.contains("alfakrøll5"), equalTo(true));
        assertThat(base.contains("alfakrøll6"), equalTo(true));
        assertThat(base.contains("alfakrøll7"), equalTo(true));
        assertThat(base.contains("alfakrøll8"), equalTo(false));
    }

    @Test
    public void differentPrefixes() {
        Trie base = new Trie();
        base.insert("abcdefg");
        base.insert("hijklmn");

        assertThat(base.contains("abcdefg"), equalTo(true));
        assertThat(base.contains("hijklmn"), equalTo(true));
        assertThat(base.contains("opqrstu"), equalTo(false));
    }

    @Test
    public void subStrings() {
        Trie base = new Trie();
        base.insert("abcdefg");
        base.insert("abc");

        assertThat(base.contains("abcdefg"), equalTo(true));
        assertThat(base.contains("abc"), equalTo(true));

        assertThat(base.contains("abcd"), equalTo(false));
        assertThat(base.contains("bc"), equalTo(false));

        assertThat(base.includesPrefix("abcd"), equalTo(true));
        assertThat(base.includesPrefix("bc"), equalTo(false));
    }
}
