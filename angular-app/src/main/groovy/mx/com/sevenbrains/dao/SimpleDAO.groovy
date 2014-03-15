package mx.com.sevenbrains.dao

import org.hibernate.SessionFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.orm.hibernate4.support.HibernateDaoSupport
import org.springframework.stereotype.Repository

/**
 * Created by lordluzbel on 28/02/14.
 */
@Repository
class SimpleDAO extends HibernateDaoSupport {
    @Autowired
    @Qualifier("sessionFactory")
    @Override
    def initDao(SessionFactory sessionFactory) {
        this.setSessionFactory(sessionFactory)
    }

    def save(Object o) {
        hibernateTemplate.save(o);
    }

    def update(Object o){
        hibernateTemplate.update(o)
    }

    def delete(Object o){
        hibernateTemplate.delete(o)
    }
}
