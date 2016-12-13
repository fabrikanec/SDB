package dbService;

import dbService.dao.ArticleDAO;
import dbService.dao.EventDAO;
import dbService.dao.FriendDAO;
import dbService.dao.UsersDAO;
import dbService.dataSets.ArticleDataSet;
import dbService.dataSets.EventDataSet;
import dbService.dataSets.FriendDataSet;
import dbService.dataSets.UsersDataSet;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.annotations.ListBinder;
import org.hibernate.internal.SessionFactoryImpl;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;


public class DBService implements DBServiceInterface {
    private static final String hibernate_show_sql = "true";
    private static final String hibernate_hbm2ddl_auto = "create";

    private final SessionFactory sessionFactory;

    public DBService() {
        Configuration configuration = getH2Configuration();
        sessionFactory = createSessionFactory(configuration);
    }

    @SuppressWarnings("UnusedDeclaration")
    private Configuration getPostgresqlConfiguration() {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(UsersDataSet.class);

        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        configuration.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        configuration.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/cezar");
        configuration.setProperty("hibernate.connection.username", "cezar");
        configuration.setProperty("hibernate.connection.password", "666");
        configuration.setProperty("hibernate.show_sql", hibernate_show_sql);
        configuration.setProperty("hibernate.hbm2ddl.auto", hibernate_hbm2ddl_auto);
        return configuration;
    }

    private Configuration getH2Configuration() {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(UsersDataSet.class);
        configuration.addAnnotatedClass(ArticleDataSet.class);
        configuration.addAnnotatedClass(FriendDataSet.class);
        configuration.addAnnotatedClass(EventDataSet.class);
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        configuration.setProperty("hibernate.connection.driver_class", "org.h2.Driver");
        configuration.setProperty("hibernate.connection.url", "jdbc:h2:./h2db");
        configuration.setProperty("hibernate.connection.username", "tully");
        configuration.setProperty("hibernate.connection.password", "tully");
        configuration.setProperty("hibernate.show_sql", hibernate_show_sql);
        configuration.setProperty("hibernate.hbm2ddl.auto", hibernate_hbm2ddl_auto);
        return configuration;
    }


    public UsersDataSet getUser(long id) throws DBException {
        try {
            Session session = sessionFactory.openSession();
            UsersDAO dao = new UsersDAO(session);
            UsersDataSet dataSet = dao.get(id);
            session.close();
            return dataSet;
        } catch (HibernateException e) {
            throw new DBException(e);
        }
    }

    public UsersDataSet getUser(String login) throws DBException {
        try {
            Session session = sessionFactory.openSession();
            UsersDAO dao = new UsersDAO(session);
            UsersDataSet dataSet = dao.get(login);
            session.close();
            return dataSet;
        } catch (HibernateException e) {
            throw new DBException(e);
        }
    }

    public long addUser(String login, String password) throws DBException {
        try {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            UsersDAO dao = new UsersDAO(session);
            long id = dao.insertUser(login, password);
            transaction.commit();
            session.close();
            return id;
        } catch (HibernateException e) {
            throw new DBException(e);
        }
    }

    public long addArticle(long id, char secure, String text, Date date) throws DBException {
        try {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            ArticleDAO dao = new ArticleDAO(session);
            long article_id = dao.insertArticle(id, secure, text, date);
            transaction.commit();
            session.close();
            return article_id;
        } catch (HibernateException e) {
            throw new DBException(e);
        }
    }
    public ArticleDataSet getArticle(long article_id) throws DBException {
        try {
            Session session = sessionFactory.openSession();
            ArticleDAO dao = new ArticleDAO(session);
            ArticleDataSet dataSet = dao.getArticle(article_id);
            session.close();
            return dataSet;
        } catch (HibernateException e) {
            throw new DBException(e);
        }
    }

    public long addEvent(long id, String name, String text, String subj) throws DBException {
        try {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            EventDAO dao = new EventDAO(session);
            long event_id = dao.insertEvent(id, name, text, subj);
            transaction.commit();
            session.close();
            return event_id;
        } catch (HibernateException e) {
            throw new DBException(e);
        }
    }
    public EventDataSet getEvent(long event_id) throws DBException {
        try {
            Session session = sessionFactory.openSession();
            EventDAO dao = new EventDAO(session);
            EventDataSet dataSet = dao.getEvent(event_id);
            session.close();
            return dataSet;
        } catch (HibernateException e) {
            throw new DBException(e);
        }
    }

    public long addFriend(long id, long friend_id) throws DBException {
        try {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            FriendDAO dao = new FriendDAO(session);
            long _friend_id = dao.addFriend(id, friend_id);
            transaction.commit();
            session.close();
            return _friend_id;
        } catch (HibernateException e) {
            throw new DBException(e);
        }
    }

    public FriendDataSet getFriends(long id) throws DBException {
        try {
            Session session = sessionFactory.openSession();
            FriendDAO dao = new FriendDAO(session);
            FriendDataSet dataSet = dao.getFriends(id);
            session.close();
            return dataSet;
        } catch (HibernateException e) {
            throw new DBException(e);
        }
    }

    public void printConnectInfo() {
        try {
            SessionFactoryImpl sessionFactoryImpl = (SessionFactoryImpl) sessionFactory;
            Connection connection = sessionFactoryImpl.getConnectionProvider().getConnection();
            System.out.println("DB name: " + connection.getMetaData().getDatabaseProductName());
            System.out.println("DB version: " + connection.getMetaData().getDatabaseProductVersion());
            System.out.println("Driver: " + connection.getMetaData().getDriverName());
            System.out.println("Autocommit: " + connection.getAutoCommit());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static SessionFactory createSessionFactory(Configuration configuration) {
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = builder.build();
        return configuration.buildSessionFactory(serviceRegistry);
    }
}