package dbService;

import dbService.dataSets.UsersDataSet;

/**
 * Created by nikitaborodulin on 23/01/16.
 */
public interface DBServiceInterface {
    long addUser(String login, String password) throws DBException;
    UsersDataSet getUser(String login) throws DBException;
}