package dbService.dataSets;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "user_message")
public class ArticleDataSet implements Serializable { // Serializable Important to Hibernate!
    private static final long serialVersionUID = -8706689714326132798L;

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "article_id", unique = true, updatable = false)
    private long article_id;

    @Column(name = "secure")
    private char secure;

    @Column (name = "text")
    private String text;

    @Column (name = "date")
    private Date date;

    //Important to Hibernate!
    @SuppressWarnings("UnusedDeclaration")
    public ArticleDataSet() {
    }

    public ArticleDataSet(long id, long article_id, char secure, String text, Date date) {
        this.setId(id);
        this.setArticleId(article_id);
        this.setSecure(secure);
        this.setText(text);
        this.setDate(date);
    }


    @SuppressWarnings("UnusedDeclaration")

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getArticleId() {
        return article_id;
    }

    public void setArticleId(long article_id) {
        this.article_id = article_id;
    }

    public char getSecure() { return secure; }

    public void setSecure(char flag) { this.secure = flag; }

    public String getText() { return text; }

    public void setText(String text) { this.text = text; }

    public Date getDate() { return date; }

    public void setDate(Date date) { this.date = date; }

    public String toString() {
        return "UserDataSet{" +
                "id=" + id +
                ", login='" + article_id + '\'' +
                '}';
    }
}