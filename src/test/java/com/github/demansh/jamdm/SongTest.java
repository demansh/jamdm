package com.github.demansh.jamdm;

import com.github.demansh.jamdm.amdm.AmDmSong;
import com.github.demansh.jamdm.amdm.AmDmSearch;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SongTest {
    private Song testSong;

    @Before
    public void setUp() {
        Search search = new AmDmSearch("rage against the machine");
        testSong = search.result().iterator().next();
    }

    @Test
    public void shouldReturnNotEmptyText() {
        assertFalse(testSong.text().isEmpty());
    }

    @Test
    public void shouldReturnNotEmptyName() {
        assertFalse(testSong.name().isEmpty());
    }

    @Test
    public void shouldReturnNotEmptyId() {
        assertFalse(testSong.id().isEmpty());
    }

    @Test
    public void shouldReturnNotEmptyAuthor() {
        assertNotNull(testSong.author());
    }

    @Test
    public void shouldReturnNotEmptyPathName() {
        assertFalse(testSong.pathName().isEmpty());
    }

    @Test
    public void songShouldBeFoundByPath() {
        String id = testSong.id();
        String pathName = testSong.pathName();
        Author author = testSong.author();

        Song songByPath = new AmDmSong(id, pathName, author.pathName());

        assertEquals(id, songByPath.id());
        assertEquals(pathName, songByPath.pathName());
        assertEquals(testSong.text(), songByPath.text());
        assertEquals(testSong.pathName(), songByPath.pathName());
    }
}
