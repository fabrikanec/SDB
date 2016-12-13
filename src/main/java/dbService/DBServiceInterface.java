package dbService;

import dbService.dataSets.ArticleDataSet;
import dbService.dataSets.EventDataSet;
import dbService.dataSets.FriendDataSet;
import dbService.dataSets.UsersDataSet;

import java.util.Date;

/**
 * Created by nikitaborodulin on 23/01/16.
 */
public interface DBServiceInterface {
    long addUser(String login, String password) throws DBException;
    UsersDataSet getUser(String login) throws DBException;
    long addArticle(long id, char secure, String text, Date date) throws DBException;
    ArticleDataSet getArticle(long article_id) throws DBException;
    long addFriend(long id, long friend_id) throws DBException;
    FriendDataSet getFriends(long id) throws DBException;
    long addEvent(long id, String name, String text, String subj) throws DBException;
    EventDataSet getEvent(long id) throws DBException;
}