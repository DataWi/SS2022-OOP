package MusicLandscape.entities;

public class TVShow extends Event {
    private String name = null;
    private int viewers;

    public TVShow() {
    }

    public TVShow(TVShow tvs) {
        super(tvs);
        this.name = tvs.getName();
        this.viewers = tvs.getViewers();
    }

    public TVShow(Event e) {
        super(e);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null || name.isBlank() ? this.name : name;
    }

    public int getViewers() {
        return viewers;
    }

    public void setViewers(int viewers) {
        this.viewers = viewers > 0 ? viewers : this.viewers;
    }

    @Override
    public int impact() {
        int result = this.viewers+this.getAttendees();
        return result * 2;
    }

    public String toString() {
        return String.format("%s @ %s on %s\n%s\n(%d attending (%d))", this.getArtist(), this.getName(), this.getDate(), this.getDescription(), this.getViewers() + this.getAttendees(), this.impact());
    }

}
