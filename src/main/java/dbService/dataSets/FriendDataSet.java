package dbService.dataSets;

import com.sun.javafx.beans.IDProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "friends")
public class FriendDataSet implements Serializable { // Serializable Important to Hibernate!
    private static final long serialVersionUID = -8706689714326132798L;

    @Column(name = "some_user_id")
    private long id;

    @Id
    @Column(name = "friend_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long friend_id;

    //Important to Hibernate!
    @SuppressWarnings("UnusedDeclaration")
    public FriendDataSet() {
    }

    public FriendDataSet(long id, long friend_id) {
        this.setId(id);
        this.setFriendId(friend_id);

    }


    @SuppressWarnings("UnusedDeclaration")

    public void setId(long id) { this.id = id; }

    //@ManyToMany(fetch = FetchType.LAZY, mappedBy = "users")
    public long getFriends() { return friend_id; }

    public void setFriendId(long friend_id) { this.friend_id = friend_id; }

    public String toString() {
        return "UserDataSet{" +
                "id=" + id +
                ", login='" + friend_id + '\'' +
                '}';
    }
}