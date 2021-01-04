package io.demansh.jamdm.api.controllers;

import io.demansh.jamdm.api.resources.Songs;
import io.demansh.jamdm.domain.Song;
import io.demansh.jamdm.domain.amdm.AmDmAuthor;
import io.demansh.jamdm.domain.amdm.AmDmSearch;
import io.demansh.jamdm.domain.amdm.AmDmSong;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HtmlController {
    @GetMapping(value = "/song", produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String song(
            @RequestParam String author,
            @RequestParam String song,
            @RequestParam String id) {
        return new AmDmSong(id, song, author).text();
    }
}
