# Getting Started

### About

`jamdm` is a java library to grab data from the amdm.ru site - a storage of
guitar chords.

### How to use

Say you'd like to find chord for the Beatles "Yellow sub-marin":

````java
Search search=new AmDmSearch("Yellow submarine");
Collection<Song> songs=search.result();
System.out.println(songs.iterator().next().text());
```

The output will be a formatted html page with the text and chords.

# For developer

### Build

```shell
mvn clean install
```

### Release

Perform release from scm

```shell
mvn release:clean release:prepare
mvn release:perform
```

### The development workflow

- Develop, develop, develop
- Commit any outstanding changes
- Verify build passes
- Update versions to release version
- Commit release version
- Run deployment
- Update versions to next snapshot version
- Commit new snapshot version
- Develop, develop, develop and rinse and repeat
