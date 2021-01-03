package io.demansh.jamdm.domain.amdm;

import io.demansh.jamdm.domain.Author;
import io.demansh.jamdm.domain.Song;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.Optional;

public class AmDmSong implements Song {
    private final String id;
    private final String pathName;
    private final String authorPathName;
    private final String name;
    private final Optional<Author> author;
    private final String url;

    private AmDmSong(
            String id,
            String pathName,
            String authorPathName,
            String name,
            Author author) {
        this.id = id;
        this.pathName = pathName;
        this.authorPathName = authorPathName;
        this.name = name;
        this.author = Optional.ofNullable(author);
        url = String.format("https://amdm.ru/akkordi/%s/%s/%s",
                authorPathName,
                id,
                pathName);
    }

    public AmDmSong(String id, String pathName, String authorPathName) {
        this(id, pathName, authorPathName, "", null);
    }

    public AmDmSong(Element htmlElement, Author author) {
        this(htmlElement.attr("href").split("/")[5],
                htmlElement.attr("href").split("/")[6],
                htmlElement.attr("href").split("/")[4],
                htmlElement.text(),
                author);
    }

    @Override
    public String id() {
        return id;
    }

    @Override
    public String pathName() {
        return pathName;
    }

    @Override
    public Author author() {
        return author.orElse(new AmDmAuthor(authorPathName));
    }

    @Override
    public String name() {
        if (name.isEmpty()) {
            try {
                Document html = Jsoup.connect(url).get();
                return html.select("[itemprop=name]").text();
            } catch (IOException e) {
                e.printStackTrace();
                return "";
            }
        } else {
            return name;
        }
    }

    @Override
    public String text() {
        try {
            Document html = Jsoup.connect(url).get();
            return html.select("pre").get(0).toString();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
