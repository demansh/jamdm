package io.demansh.jamdm.domain.amdm;

import io.demansh.jamdm.domain.Author;
import io.demansh.jamdm.domain.Song;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class AmDmAuthor implements Author {
    private final String pathName;
    private final String name;
    private final String url;

    public AmDmAuthor(String pathName, String name) {
        this.pathName = pathName;
        this.name = name;
        url = String.format("https://amdm.ru/akkordi/%s", pathName);
    }

    public AmDmAuthor(String pathName) {
        this(pathName, "");
    }

    public AmDmAuthor(Element htmlElement) {
        this(htmlElement.attr("href").split("/")[4],
                htmlElement.text());
    }

    @Override
    public String pathName() {
        return pathName;
    }

    @Override
    public String name() {
        if (name.isEmpty()) {
            try {
                Document html = Jsoup.connect(url).get();
                return html.select("div.artist-profile__info h1").text();
            } catch (IOException e) {
                e.printStackTrace();
                return "";
            }
        } else {
            return name;
        }
    }

    @Override
    public Collection<Song> songs() {
        try {
            Document html = Jsoup.connect(url).get();
            Elements htmlElements = html.select("table.tablesorter")
                    .get(0).children()
                    .get(1).children();
            ArrayList<Song> result = new ArrayList<>();
            htmlElements.forEach(htmlElement -> {
                        Element songElement = htmlElement
                                .children().get(0).children().get(0);
                        result.add(new AmDmSong(songElement, this));
                    }
            );
            return result;
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
