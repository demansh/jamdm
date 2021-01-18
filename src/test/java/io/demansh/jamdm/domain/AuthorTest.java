package io.demansh.jamdm.domain;

import io.demansh.jamdm.domain.amdm.AmDmAuthor;
import io.demansh.jamdm.domain.amdm.AmDmSearch;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class AuthorTest {
    private Author testAuthor;

    @Before
    public void setUp() {
        Search search = new AmDmSearch("rage against the machine");
        testAuthor = search.result().iterator().next().author();
    }

    @Test
    public void shouldReturnNotEmptyName() {
        assertFalse(testAuthor.name().isEmpty());
    }

    @Test
    public void shouldReturnNotEmptyPathName() {
        assertFalse(testAuthor.pathName().isEmpty());
    }

    @Test
    public void shouldReturnNotEmptySongs() {
        assertFalse(testAuthor.songs().isEmpty());
    }

    @Test
    public void authorShouldBeFoundByPath() {
        String pathName = testAuthor.pathName();

        Author authorByPath = new AmDmAuthor(pathName);

        assertEquals(pathName, authorByPath.pathName());
        assertEquals(testAuthor.name(), authorByPath.name());
    }
}
