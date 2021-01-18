package io.demansh.jamdm.domain;

import io.demansh.jamdm.domain.amdm.AmDmSearch;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.assertFalse;

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
}
