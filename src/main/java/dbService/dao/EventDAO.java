package dbService.dao;

import dbService.dataSets.ArticleDataSet;
import dbService.dataSets.EventDataSet;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.Date;

public class EventDAO {
    private Session session;

    public EventDAO(Session session) {
        this.session = session;
    }

    public EventDataSet getEvent(long event_id) throws HibernateException {
        Criteria criteria = session.createCriteria(EventDataSet.class);
        return ((EventDataSet) criteria.add(Restrictions.eq("event_id", event_id)).uniqueResult());
    }

    public long insertEvent(long id, String name, String text, String subj) throws HibernateException {
        return (Long) session.save(new EventDataSet(id, name, text, subj));
    }
}
