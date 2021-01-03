package io.demansh.jamdm;

import static org.junit.Assert.assertTrue;

import io.demansh.jamdm.domain.Author;
import io.demansh.jamdm.domain.Search;
import io.demansh.jamdm.domain.Song;
import io.demansh.jamdm.domain.amdm.AmDmAuthor;
import io.demansh.jamdm.domain.amdm.AmDmSearch;
import io.demansh.jamdm.domain.amdm.AmDmSong;
import org.junit.Test;

public class AppTest {
    @Test
    public void shouldAnswerWithTrue() {
        Search search = new AmDmSearch("rage against the machine");

        Author author = new AmDmAuthor("rage_against_the_machine");

        Song song = new AmDmSong("72636", "bombtrack", "rage_against_the_machine");
        System.out.println(song.text());
    }
}
