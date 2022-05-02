package MusicLandscape.entities;

import MusicLandscape.Date;
import MusicLandscape.Venue;

public class Event {
    private Artist artist = new Artist();

    public void setArtist(Artist artist) {
        this.artist = (artist == null) ? this.artist : artist;
    }

    public void setAttendees(int attendees) {
        this.attendees = attendees > 0 ? attendees : this.attendees;
    }

    public void setDate(Date date) {
        this.date = date == null ? this.date : new Date(date);
    }

    public void setDescription(String description) {
        this.description = description != null && !description.isEmpty() ? description : this.description;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public Artist getArtist() {
        return artist;
    }

    public int getAttendees() {
        return attendees;
    }

    public Date getDate() {
        return this.date == null ? null : new Date(date);
    }

    public String getDescription() {
        return description;
    }

    public Venue getVenue() {
        return venue;
    }

    private int attendees = 0;
    private Date date;
    private String description = "";
    private Venue venue = null;


}
