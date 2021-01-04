package io.demansh.jamdm.api.controllers;

import io.demansh.jamdm.api.resources.Songs;
import io.demansh.jamdm.domain.Song;
import io.demansh.jamdm.domain.amdm.AmDmAuthor;
import io.demansh.jamdm.domain.amdm.AmDmSearch;
import io.demansh.jamdm.domain.amdm.AmDmSong;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class SearchController {
    @GetMapping("search")
    Songs search(
            @RequestParam(defaultValue = "") String q,
            @RequestParam(defaultValue = "") String author,
            @RequestParam(defaultValue = "") String song,
            @RequestParam(defaultValue = "") String id,
            @RequestParam(defaultValue = "page1") String page) {
        if (!q.isEmpty()) {
            return new Songs(new AmDmSearch(q, page).result());
        }
        if (!author.isEmpty() && !song.isEmpty() && !id.isEmpty()) {
            return new Songs(new AmDmSong(id, song, author));
        }
        if (!author.isEmpty()) {
            return new Songs(new AmDmAuthor(author).songs());
        }
        throw new RuntimeException("invalid parameters");
    }
}
