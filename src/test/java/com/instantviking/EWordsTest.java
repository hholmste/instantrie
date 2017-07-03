package com.instantviking;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import static org.assertj.core.api.Assertions.assertThat;

/**
 *  something strange is happening in the e-list.
 */
public class EWordsTest {

    @Test
    public void eo_is_not_a_word() {
        Trie t = new Trie();
        InputStream s = EWordsTest.class.getResourceAsStream("/ewords.txt");
        BufferedReader r = new BufferedReader(new InputStreamReader(s));
        r.lines().forEach(t::insert);

        assertThat(t.contains("eo")).isFalse();
    }
}
