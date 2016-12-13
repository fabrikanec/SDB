package main;

import accounts.AccountService;
import accounts.UserProfile;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.*;
import dbService.DBException;
import dbService.DBService;
import dbService.dataSets.UsersDataSet;
import chat.WebSocketChatServlet;

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

        long id = accountService.addNewUser(new UserProfile("Todd", "Valio"));
        System.out.println(accountService.getUserByLogin("Todd").getPass());
        long id_article = accountService.addArticle(id, '0', "text", new java.util.Date());
        long id_event =  accountService.addEvent(id, "name", "TOO MUCH TEXT EVENT", "some subj");
        System.out.println(accountService.getArticleText(id_article));
        long id_article1 = accountService.addArticle(id, '0', "anothertext", new java.util.Date());
        System.out.println(accountService.getArticleText(id_article));
        System.out.println(accountService.getEventText(id_event));
        System.out.println(accountService.getArticleText(id_article1));
        System.out.println(accountService.getArticleText(id_article));

        long id_friend = accountService.addNewUser(new UserProfile("Volly", "Valio"));
        accountService.addFriend(id, id_friend);
        System.out.println(accountService.getFriends(id));
    }
}