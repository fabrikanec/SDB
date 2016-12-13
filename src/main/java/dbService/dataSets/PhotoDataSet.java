package dbService.dataSets;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;

@Entity
@Table(name = "user_photo")
public class PhotoDataSet implements Serializable { // Serializable Important to Hibernate!
    private static final long serialVersionUID = -8706689714326132798L;

    @Column(name = "user_id")
    private long id;

    @Id
    @Column(name = "photo_id", unique = true, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long photo_id;

    @Column(name = "photo")
    private Blob photo;

    //Important to Hibernate!
    @SuppressWarnings("UnusedDeclaration")
    public PhotoDataSet() {
    }

    public PhotoDataSet(long id, long photo_id) {
        this.setId(id);
        this.setPhotoId(photo_id);
    }


    @SuppressWarnings("UnusedDeclaration")

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPhotoId() { return photo_id; }

    public void setPhotoId(long photo_id) { this.photo_id = photo_id; }

    public Blob getPhoto() { return photo; }

    public void setPhoto(Blob photo) { this.photo = photo; }

    @Override
    public String toString() {
        return "PlayListDataSet{" +
                "id=" + id +
                ", track_id='" + photo_id + '\'' +
                '}';
    }
}