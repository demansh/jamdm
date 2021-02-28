package com.github.demansh.jamdm;

import com.github.demansh.jamdm.amdm.AmDmSearch;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SearchTest {
    @Test
    public void shouldReturnNotEmptyResult_withoutExplicitPage() {
        Search search = new AmDmSearch("rage against the machine");

        Collection<Song> songs = search.result();

        assertFalse(songs.isEmpty());
    }

    @Test
    public void shouldReturnNotEmptyResult_withPage() {
        Search search = new AmDmSearch("rage against the machine", "page2");

        Collection<Song> songs = search.result();

        assertFalse(songs.isEmpty());
    }

    @Test
    public void shouldReturnEmptyList_withEmptyQuery() {
        Search search = new AmDmSearch("", "page2");

        Collection<Song> songs = search.result();

        assertTrue(songs.isEmpty());
    }
}
