package com.github.demansh.jamdm.amdm;

import com.github.demansh.jamdm.Author;
import com.github.demansh.jamdm.Search;
import com.github.demansh.jamdm.Song;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class AmDmSearch implements Search {
    private final String query;
    private final String page;

    public AmDmSearch(String query, String page) {
        this.query = query;
        this.page = page;
    }

    public AmDmSearch(String query) {
        this(query, "page1");
    }

    @Override
    public Collection<Song> result() {
        if (query.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        try {
            String url = String.format("https://amdm.ru/search/%s/?q=%s",
                    page,
                    query);
            Document html = Jsoup.connect(url).get();
            Elements htmlElements = html
                    .select("table.items").get(0)
                    .children().get(1)
                    .children();
            ArrayList<Song> result = new ArrayList<>();
            htmlElements.forEach(htmlElement -> {
                Elements authorToSong = htmlElement
                        .children().get(2)
                        .children();
                Author author = new AmDmAuthor(authorToSong.get(0));
                Song song = new AmDmSong(authorToSong.get(1), author);
                result.add(song);
            });
            return result;
        } catch (IOException | IndexOutOfBoundsException e) {
            //todo: add proper error handling -
            // logging facade or throw custom exceptions
            return null;
        }
    }
}
