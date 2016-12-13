package dbService.dataSets;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "user_comment")
public class CommentDataSet implements Serializable { // Serializable Important to Hibernate!
    private static final long serialVersionUID = -8706689714326132798L;

    @Column(name = "user_id")
    private long id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id", unique = true, updatable = false)
    private long comment_id;

    @Column(name = "article_id", updatable = false)
    private long article_id;

    @Column (name = "event_id")
    private long event_id;

    @Column (name = "text")
    private String text;


    //Important to Hibernate!
    @SuppressWarnings("UnusedDeclaration")
    public CommentDataSet() {
    }

    public CommentDataSet(long id, long comment_id, long article_id, long event_id, String text) {
        this.setId(id);
        this.setCommentId(comment_id);
        this.setArticleId(article_id);
        this.setEventId(event_id);
        this.setText(text);
    }


    @SuppressWarnings("UnusedDeclaration")

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCommentId() {
        return comment_id;
    }

    public void setCommentId(long comment_id) {
        this.comment_id = comment_id;
    }

    public long getArticleId() {
        return article_id;
    }

    public void setArticleId(long article_id) { this.article_id = article_id; }

    public long getEventId() {
        return event_id;
    }

    public void setEventId(long event_id) {
        this.event_id = event_id;
    }

    public String getText() { return text; }

    public void setText(String text) { this.text = text; }



    @Override
    public String toString() {
        return "UserDataSet{" +
                "id=" + id +
                ", login='" + comment_id + '\'' +
                '}';
    }
}