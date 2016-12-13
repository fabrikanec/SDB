package dbService.dataSets;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;

@Entity
@Table(name = "user_video")
public class VideoDataSet implements Serializable { // Serializable Important to Hibernate!
    private static final long serialVersionUID = -8706689714326132798L;

    @Column(name = "user_id")
    private long id;

    @Id
    @Column(name = "video_id", unique = true, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long video_id;

    @Column(name = "video")
    private Blob video;

    //Important to Hibernate!
    @SuppressWarnings("UnusedDeclaration")
    public VideoDataSet() {
    }

    public VideoDataSet(long id, long video_id) {
        this.setId(id);
        this.setVideoId(video_id);
    }


    @SuppressWarnings("UnusedDeclaration")

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getVideoId() { return video_id; }

    public void setVideoId(long video_id) { this.video_id = video_id; }

    public Blob getVideo() { return video; }

    public void setVideo(Blob video) { this.video = video; }

    @Override
    public String toString() {
        return "PlayListDataSet{" +
                "id=" + id +
                ", track_id='" + video_id + '\'' +
                '}';
    }
}