package io.demansh.jamdm.api.resources;

import io.demansh.jamdm.domain.Song;

import java.util.ArrayList;
import java.util.Collection;

public class Songs {
    Collection<Song> songs;

    public Songs(Collection<Song> songs) {
        this.songs = songs;
    }

    public Songs(Song song) {
        this(listOf(song));
    }

    private static Collection<Song> listOf(Song song) {
        Collection<Song> list = new ArrayList<>();
        list.add(song);
        return list;
    }

    public Collection<Song> content() {
        return songs;
    }
}
