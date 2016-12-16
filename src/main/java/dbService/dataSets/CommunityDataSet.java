package dbService.dataSets;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "community")
public class CommunityDataSet implements Serializable { // Serializable Important to Hibernate!
    private static final Long serialVersionUID = -8706689714326132798L;

    @Column(name = "user_id")
    private Long id;

    private Long community_id;

    @Column(name = "community_name")
    private String community_name;

    private Set<Long> users = new HashSet<>();

    //Important to Hibernate!
    @SuppressWarnings("UnusedDeclaration")
    public CommunityDataSet() {
    }

    public CommunityDataSet(String community_name) {
        //this.setId(id);
        //this.setCommunityId(community_id);
        this.setCommunityName(community_name);
    }

    public CommunityDataSet(Long user_id, String community_name) {
        this.setUser(user_id);
        //this.setCommunityId(community_id);
        this.setCommunityName(community_name);

    }

    @SuppressWarnings("UnusedDeclaration")

    public Long getId() { return id; }

    private void setId(Long id) {
        this.id = id;
    }

    @Id
    @Column(name = "community_id", unique = true, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getCommunityId() {
        return community_id;
    }

    private void setCommunityId(Long community_id) {
        this.community_id = community_id;
    }

    public String getCommunityName() { return community_name;}

    public void setCommunityName(String name) { this.community_name = community_name;}

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "users_communities", joinColumns = @JoinColumn(name = "community_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    public Set<Long> getUsers() {
        return users;
    }

    //public void setUsers(Set<Long> users) { this.users = users; }

    public void setUser(Long user) {
        this.users.add(user);
    }

    public String toString() {
        return "CommunityDataSet{" +
                "id=" + id +
                ", community_id='" + community_id + '\'' +
                '}';
    }
}