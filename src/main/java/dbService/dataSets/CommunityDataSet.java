package dbService.dataSets;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "communities")
public class CommunityDataSet implements Serializable { // Serializable Important to Hibernate!
    private static final long serialVersionUID = -8706689714326132798L;

    @Column(name = "user_id")
    private long id;

    @Id
    @Column(name = "community_id", unique = true, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long community_id;

    @Column(name = "community_name")
    private String community_name;

    //Important to Hibernate!
    @SuppressWarnings("UnusedDeclaration")
    public CommunityDataSet() {
    }

    public CommunityDataSet(long id, long community_id, String community_name) {
        this.setId(id);
        this.setCommunityId(community_id);
        this.setCommunityName(community_name);
    }


    @SuppressWarnings("UnusedDeclaration")

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCommunityId() {
        return community_id;
    }

    public void setCommunityId(long community_id) {
        this.community_id = community_id;
    }

    public String getCommunityName() { return community_name;}

    public void setCommunityName(String name) { this.community_name = community_name;}

    public String toString() {
        return "UserDataSet{" +
                "id=" + id +
                ", login='" + community_id + '\'' +
                '}';
    }
}