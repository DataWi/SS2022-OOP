package MusicLandscape.entities;

public class Artist {
    private String name = null;

    public Artist(Artist a) {
        this.name = a.name;
    }

    public Artist() {
        setName("unknown");
    }

    public Artist(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name == null || name.isBlank() ? this.name : name;
    }

    public String getName() {
        return this.name;
    }

}
