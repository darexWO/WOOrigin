package rs.invado.wo.dao.uz;

// Generated Jan 1, 2013 5:03:17 PM by Hibernate Tools 3.4.0.CR1


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import rs.invado.wo.domain.uz.UzZaliheJskl;
import rs.invado.wo.domain.uz.UzZaliheJsklId;

/**
 * Home object for domain model class UzZaliheJskl.
 * @see rs.invado.wo.domain.uz.UzZaliheJskl
 * @author Hibernate Tools
 */
@Repository     @Transactional
//
public class UzZaliheJsklHome {

	private static final Log log = LogFactory.getLog(UzZaliheJsklHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(UzZaliheJskl transientInstance) {
		log.debug("persisting UzZaliheJskl instance");
		try {
			entityManager.persist(transientInstance);  entityManager.flush();
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(UzZaliheJskl persistentInstance) {
		log.debug("removing UzZaliheJskl instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public UzZaliheJskl merge(UzZaliheJskl detachedInstance) {
		log.debug("merging UzZaliheJskl instance");
		try {
			UzZaliheJskl result = entityManager.merge(detachedInstance);
            entityManager.flush();
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public UzZaliheJskl findById(UzZaliheJsklId id) {
		log.debug("getting UzZaliheJskl instance with id: " + id);
		try {
			UzZaliheJskl instance = entityManager.find(UzZaliheJskl.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
