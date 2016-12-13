package dbService.dataSets;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;

@Entity
@Table(name = "user_playlist")
public class PlayListDataSet implements Serializable { // Serializable Important to Hibernate!
    private static final long serialVersionUID = -8706689714326132798L;

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "track_id", unique = true, updatable = false)
    private long track_id;

    @Column(name = "track")
    private Blob track;

    //Important to Hibernate!
    @SuppressWarnings("UnusedDeclaration")
    public PlayListDataSet() {
    }

    public PlayListDataSet(long id, long track_id) {
        this.setId(id);
        this.setTrackId(track_id);
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

    @Override
    public String toString() {
        return "PlayListDataSet{" +
                "id=" + id +
                ", track_id='" + track_id + '\'' +
                '}';
    }
}