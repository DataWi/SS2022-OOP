package MusicLandscape.entities;

public class Artist {
    private String name = "unknown";

    public Artist(Artist a) {
        this.name = a.name;
    }

    public Artist() {
    }

    public Artist(String name) {
        setName(name);
    }

    public void setName(String name) {
        this.name = name != null && !name.isEmpty() ? name : this.name;
//        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return String.format("%s", name);
    }

}
