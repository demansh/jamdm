package io.demansh.jamdm.domain.amdm;

import io.demansh.jamdm.domain.Author;
import io.demansh.jamdm.domain.Search;
import io.demansh.jamdm.domain.Song;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

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
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
