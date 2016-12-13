package accounts;


import dbService.DBException;
import dbService.DBService;
import dbService.DBService;
import dbService.DBServiceInterface;
import dbService.dataSets.ArticleDataSet;
import dbService.dataSets.EventDataSet;
import dbService.dataSets.FriendDataSet;
import dbService.dataSets.UsersDataSet;

import java.util.*;


public class AccountService {
    //private final Map<String, UserProfile> loginToProfile;
    private final Map<String, UserProfile> sessionIdToProfile;
    private DBServiceInterface dbService;

    public AccountService(DBServiceInterface dbService) {
       // loginToProfile = new HashMap<>();
        sessionIdToProfile = new HashMap<>();
        this.dbService = dbService;
    }

    /** Session Logic */
    public void addSession(String sessionId, UserProfile userProfile) {
        sessionIdToProfile.put(sessionId, userProfile);
    }

    public void deleteSession(String sessionId) {
        sessionIdToProfile.remove(sessionId);
    }


    /** UsersDataSet Logic */
    public long addNewUser(UserProfile userProfile) throws DBException {
        //loginToProfile.put(userProfile.getLogin(), userProfile);
        return dbService.addUser(userProfile.getLogin(), userProfile.getPass());
    }

    public UserProfile getUserByLogin(String login) throws DBException {
        UsersDataSet dataSet = dbService.getUser(login);
        if (dataSet != null) {
            return new UserProfile(dataSet.getLogin(), dataSet.getPassword());
        } else {
            return null;
        }
    }

    public UserProfile getUserBySessionId(String sessionId) {
        return sessionIdToProfile.get(sessionId);
    }


    /** ArticleDataSet Logic */
    public long addArticle(long id, char secure, String text, Date date) throws DBException {
        return  dbService.addArticle(id,secure, text, date);
    }

    public String getArticleText(long article_id) throws DBException {
        ArticleDataSet dataSet = dbService.getArticle(article_id);
        if (dataSet != null) {
            return dataSet.getText();
        } else {
            return null;
        }
    }

    /** EventDataSet Logic */
    public long addEvent(long id, String name, String text, String subj) throws DBException {
        return  dbService.addEvent(id, name, text, subj);
    }

    public String getEventText(long event_id) throws DBException {
        EventDataSet dataSet = dbService.getEvent(event_id);
        if (dataSet != null) {
            return dataSet.getText();
        } else {
            return null;
        }
    }

    /** FriendDataSet Logic */
    public long addFriend(long id, long friend_id) throws DBException {
        return dbService.addFriend(id, friend_id);
    }

    public Long getFriends(long id) throws DBException {
        FriendDataSet dataSet = dbService.getFriends(id);
        if (dataSet != null) {
            return dataSet.getFriends();
        } else {
            return null;
        }
    }
}