package main;

import accounts.AccountService;
import accounts.UserProfile;
import dbService.dataSets.MessageDataSet;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.server.session.JDBCSessionManager;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.*;
import dbService.DBException;
import dbService.DBService;
import dbService.dataSets.UsersDataSet;
import chat.WebSocketChatServlet;

import javax.persistence.EntityManager;
import java.sql.CallableStatement;
import java.sql.Types;
import java.util.logging.Logger;

public class Main {
    private static final Logger log = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws Exception {
        DBService dbService = new DBService();
	    AccountService accountService = new AccountService(dbService);

        //dbService.printConnectInfo();

        //AllRequestsServlet allRequestsServlet = new AllRequestsServlet();

        /*
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(new SignUpServlet(accountService)), "/signup");
        context.addServlet(new ServletHolder(new SignInServlet(accountService)), "/signin");
        context.addServlet(new ServletHolder(new SessionsServlet(accountService)), "/api/v1/sessions");
	    context.addServlet(new ServletHolder(new WebSocketChatServlet()), "/chat");
        context.addServlet(new ServletHolder(new AllRequestsServlet()), "/*");

        ResourceHandler resource_handler = new ResourceHandler();
	    resource_handler.setDirectoriesListed(true);
        resource_handler.setResourceBase("public_html");

        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[]{resource_handler, context});

        Server server = new Server(8080);
        server.setHandler(handlers);

        server.start();
        java.util.logging.Logger.getGlobal().info("Server started");
        server.join(); */

        //insert to db
        Long id = accountService.addNewUser(new UserProfile("todd", "Valio"));
        System.out.println(accountService.getUserProfileByLogin("todd").getPass());
        Long id1 = accountService.addNewUser(new UserProfile("Valio", "Todd"));

        Long id_article = accountService.addArticle(id, '0', "text", new java.util.Date());
        Long id_event =  accountService.addEvent(id, "name", "TOO MUCH TEXT EVENT", "some subj");
        System.out.println(accountService.getArticleText(id_article));

        Long id_article1 = accountService.addArticle(id, '0', "anothertext", new java.util.Date());
        System.out.println(accountService.getArticleText(id_article));
        System.out.println(accountService.getEventText(id_event));

        Long _id_event = accountService.addEvent(id, "name", "TOO", "some subj");
        System.out.println(accountService.getArticleText(id_article1));
        System.out.println(accountService.getEventText(_id_event));
        System.out.println(accountService.getEventText(id_event));
        System.out.println(accountService.getArticleText(id_article));

        Long id_comment = accountService.addComment(id, id_article, id_event, "kekich");
        Long id_comment1 = accountService.addComment(id, id_article, id_event, "lolich");
        System.out.println(accountService.getCommentText(id_comment1));
        System.out.println(accountService.getCommentText(id_comment));
        System.out.println(accountService.getCommentText(id_comment));
        System.out.println(accountService.getCommentText(id_comment1));

        MessageDataSet.BoolType boolType = new MessageDataSet.BoolType();
        Long id_msg = accountService.addMessage(id, false, false, "msg", new java.util.Date());
        Long id_msg1 = accountService.addMessage(id, false, false, "msg666", new java.util.Date());
        accountService.addMessage(id, false, false, "msg13", new java.util.Date());

        System.out.println(accountService.getMessageText(id_msg));
        System.out.println(accountService.getMessageText(id_msg1));

        accountService.addUser(accountService.getUserByLogin("todd"), "Community");
        accountService.addUser(accountService.getUserByLogin("Valio"), "Community");
        Long fromComUser = accountService.getUsers("Community").get(0).getId();
        Long fromComUser1 = accountService.getUsers("Community").get(1).getId();
        System.out.println((fromComUser.equals(id)));
        System.out.println(fromComUser1.equals(id1));

        Long id_friend = accountService.addNewUser(new UserProfile("Volly", "Valio"));
        accountService.addFriend(accountService.getUserByLogin("Volly"), accountService.getUserByLogin("todd"));
        System.out.println(accountService.getFriend(id_friend).equals(id));
        //
        System.out.println(accountService.count_comm());
        System.out.println(accountService.count_msg());
        //
    }
}