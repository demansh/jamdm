package io.demansh.jamdm.domain;

public interface Song {
    String id();

    String pathName();

    Author author();

    String name();

    String text();
}
