package dbService.dataSets;

import com.sun.javafx.beans.IDProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "friend")
public class FriendDataSet implements Serializable { // Serializable Important to Hibernate!
    private static final Long serialVersionUID = -8706689714326132798L;

    @Column(name = "user_id")
    private Long id;

    @Column(name = "friend_id")
    private Long friend_id;

    @Id
    @Column(name = "syntetic_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long syntetic_id;

    //Important to Hibernate!
    @SuppressWarnings("UnusedDeclaration")
    public FriendDataSet() {
    }

    public FriendDataSet(Long id, Long friend_id) {
        this.setId(id);
        this.setFriendId(friend_id);

    }


    @SuppressWarnings("UnusedDeclaration")

    private void setId(Long id) { this.id = id; }

    //@ManyToMany(fetch = FetchType.LAZY, mappedBy = "genres")
    public Long getFriend() { return friend_id; }

    private void setFriendId(Long friend_id) { this.friend_id = friend_id; }

    public String toString() {
        return "FriendDataSet{" +
                "id=" + id +
                ", friend_id='" + friend_id + '\'' +
                '}';
    }
}