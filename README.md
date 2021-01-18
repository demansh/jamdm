# Getting Started

### About
`jamdm` is a java library to grab data from the amdm.ru site - a storage of
guitar chords.

### Build
```shell
mvn clean install
```

### How to use
Say you'd like to find chord for the Beatles "Yellow sub-marin":
```java
        Search search = new AmDmSearch("Yellow submarine");
        Collection<Song> songs = search.result();
        System.out.println(songs.iterator().next().text());
```
The output will be a formatted html page with the text and chords.
