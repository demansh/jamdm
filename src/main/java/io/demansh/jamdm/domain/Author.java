package io.demansh.jamdm.domain;

import java.util.Collection;

public interface Author {
    String pathName();

    String name();

    Collection<Song> songs();
}
