package com.github.demansh.jamdm;

import java.util.Collection;

public interface Author {
    String pathName();

    String name();

    Collection<Song> songs();
}
