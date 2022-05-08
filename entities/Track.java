package MusicLandscape.entities;

public class Track {
    private int duration;
    private Artist performer;
    private String title;
    private Artist writer;
    private int year;

    public int getDuration() {
        return duration;
    }

    public Artist getPerformer() {
        return performer;
    }

    public String getTitle() {
        if (title == null) title = "unknown title";
        return title;
    }

    public Artist getWriter() {
        return writer;
    }

    public Track() {
        this.duration = 0;
        this.writer = new Artist();
        this.performer = new Artist();
        this.year = 1900;
    }

    public Track(Track t) {
        this.duration = t.duration;
        this.performer = new Artist(t.performer) ;
        this.title = t.title;
        this.writer = new Artist(t.writer);
        this.year = t.year;
    }

    public Track(String title) {
        this();
        this.title = title != null && !title.isEmpty() ? title : this.title;
    }

    public int getYear() {
        return year;
    }

    public void setDuration(int duration) {
        if (duration > 0) this.duration = duration;

    }

    public void setPerformer(Artist performer) {
        if (performer != null) this.performer = performer;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setWriter(Artist writer) {
        if (writer != null) this.writer = writer;
    }

    public void setYear(int year) {
        if (year > 1899 && year < 3000) this.year = year;
    }

    public boolean writerIsKnown() {
        if (this.writer == null) return false;
        else return this.writer.getName() != null;
    }

    public String getString() {
        String writerName = this.writerIsKnown() ? writer.getName() : "unknown";
        String performerName = this.performer != null && this.performer.getName() != null ? performer.getName() : "unknown";
        String titleName = this.getTitle() != null && !this.getTitle().equals("unknown title") ? this.getTitle() : "unknown";
        int minutes = this.getDuration() / 60;
        int seconds = this.getDuration() % 60;

        return createString(titleName, writerName, performerName, minutes, seconds);
    }

    private String formatString(String str) {
        return String.format("%10.10s", str);
    }

    private String formatString(int num) {
        return String.format("%02d", num);
    }

    public String toString() {
        return getString();
    }

    private String createString(String title, String writer, String performer, int min, int sec) {
        String space = " ";
        return formatString(title)
                + space + "by"
                + space + formatString(writer)
                + space + "performed by"
                + space + formatString(performer)
                + space + "(" + formatString(min) + ":" + formatString(sec) + ")";
    }


}
