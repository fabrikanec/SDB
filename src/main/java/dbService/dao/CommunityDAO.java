package dbService.dao;

import dbService.dataSets.CommentDataSet;
import dbService.dataSets.CommunityDataSet;
import dbService.dataSets.FriendDataSet;
import dbService.dataSets.UsersDataSet;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.Date;
import java.util.Set;

public class CommunityDAO {
    private Session session;

    public CommunityDAO(Session session) {
        this.session = session;
    }

    public CommunityDataSet getUsers(Long community_id) throws HibernateException {
        Criteria criteria = session.createCriteria(FriendDataSet.class);
        return ((CommunityDataSet) criteria.add(Restrictions.eq("community_id", community_id)).uniqueResult());
    }

    public Long addUser(Long user_id, String communityName) throws HibernateException {
        return (Long) session.save(new CommunityDataSet(user_id, communityName));
    }
    public Long insertCommunity(String name) throws HibernateException {
        return (Long) session.save(new CommunityDataSet(name));
    }
}