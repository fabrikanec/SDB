package dbService.dao;

import dbService.dataSets.FriendDataSet;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.Date;

public class FriendDAO {
    private Session session;

    public FriendDAO(Session session) {
        this.session = session;
    }

    public FriendDataSet getFriend(Long id) throws HibernateException {
        Criteria criteria = session.createCriteria(FriendDataSet.class);
        return ((FriendDataSet) criteria.add(Restrictions.eq("some_user_id", id)).uniqueResult());
    }

    public Long addFriend(Long id, Long friend_id) throws HibernateException {
        return (Long) session.save(new FriendDataSet(id, friend_id));
    }
}