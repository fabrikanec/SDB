package dbService.dataSets;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "user_message")
public class MessageDataSet implements Serializable { // Serializable Important to Hibernate!
    private static final long serialVersionUID = -8706689714326132798L;

    @Column(name = "user_id")
    private long id;

    @Id
    @Column(name = "message_id", unique = true, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long message_id;

    @Column(name = "receaver_msg_deleted", updatable = false)
    private char receaverMsgDeletedFlag;

    @Column (name = "poster_msg_deleted")
    private char posterMsgDeletedFlag;

    @Column (name = "text")
    private String text;

    @Column (name = "date")
    private Date date;

    //Important to Hibernate!
    @SuppressWarnings("UnusedDeclaration")
    public MessageDataSet() {
    }

    public MessageDataSet(long id, long message_id, char receaverMsgDeletedFlag, char posterMsgDeletedFlag, String text, Date date) {
        this.setId(id);
        this.setMessageId(message_id);
        this.setReceaverMsgDeleted(receaverMsgDeletedFlag);
        this.setPosterMsgDeleted(posterMsgDeletedFlag);
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

    public long getMessageId() {
        return message_id;
    }

    public void setMessageId(long message_id) {
        this.message_id = message_id;
    }

    public char getReceaverMsgDeleated() {
        return receaverMsgDeletedFlag;
    }

    public void setReceaverMsgDeleted(char flag) {
        this.receaverMsgDeletedFlag = flag;
    }

    public char getPosterMsgDeleted() {
        return posterMsgDeletedFlag;
    }

    public void setPosterMsgDeleted(char flag) {
        this.posterMsgDeletedFlag = flag;
    }

    public String getText() { return text; }

    public void setText(String text) { this.text = text; }

    public Date getDate() { return date; }

    public void setDate(Date date) { this.date = date; }

    public String toString() {
        return "UserDataSet{" +
                "id=" + id +
                ", login='" + message_id + '\'' +
                '}';
    }
}