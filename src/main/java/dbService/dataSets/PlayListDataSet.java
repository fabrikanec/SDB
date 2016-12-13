package dbService.dataSets;

import com.sun.javafx.collections.TrackableObservableList;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;

@Entity
@Table(name = "user_playlist")
public class PlayListDataSet implements Serializable { // Serializable Important to Hibernate!
    private static final long serialVersionUID = -8706689714326132798L;

    @Column(name = "user_id")
    private long id;

    @Id
    @Column(name = "track_id", unique = true, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long track_id;

    @Column(name = "track")
    private Blob track;

    @Column(name = "trackalbum")
    private TrackAlbum trackAlbum;
    //Important to Hibernate!
    @SuppressWarnings("UnusedDeclaration")
    public PlayListDataSet() {
    }

    public PlayListDataSet(long id, long track_id) {
        this.setId(id);
        this.setTrackId(track_id);
        this.setTrackAlbum(trackAlbum);
    }


    @SuppressWarnings("UnusedDeclaration")

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTrackId() { return track_id; }

    public void setTrackId(long mus_id) { this.track_id = mus_id; }

    public Blob getTrack() { return track; }

    public void setTrack(Blob track) { this.track = track; }

    public TrackAlbum getTrackAlbum() { return trackAlbum; }

    public void setTrackAlbum(TrackAlbum trackAlbum) { this.trackAlbum = trackAlbum; }

    @Override
    public String toString() {
        return "PlayListDataSet{" +
                "id=" + id +
                ", track_id='" + track_id + '\'' +
                '}';
    }
    private class TrackAlbum {
        private String description;
        private Blob image;

        public TrackAlbum(String description, Blob image) {
            this.description = description;
            this.image = image;
        }
    }
}