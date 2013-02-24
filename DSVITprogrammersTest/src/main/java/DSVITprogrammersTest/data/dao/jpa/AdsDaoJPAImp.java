package DSVITprogrammersTest.data.dao.jpa;

import DSVITprogrammersTest.data.dao.interfaces.AdsDao;
import DSVITprogrammersTest.data.dataobjects.Ad;
import org.springframework.orm.jpa.JpaCallback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kibromk
 * Date: 2/22/13
 * Time: 1:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class AdsDaoJPAImp extends AbstractDaoJPAImpl<Ad> implements AdsDao {

	public AdsDaoJPAImp() {
		super(Ad.class);
	}

	@Transactional
	public List<Ad> findAll() {
		return getJpaTemplate().execute(new JpaCallback<List<Ad>>() {
			public List<Ad> doInJpa(EntityManager em) throws PersistenceException {
				TypedQuery<Ad> query = em.createQuery("select e from Ad e", Ad.class);
				return query.getResultList();
			}
		});
	}

	@Transactional
	public int countAll() {
		return getJpaTemplate().execute(new JpaCallback<Integer>() {

			public Integer doInJpa(EntityManager em) throws PersistenceException {
				TypedQuery<Long> query = em.createQuery("select count (e) from Ad e", Long.class);
				return (query.getSingleResult()).intValue();
			}
		});

	}
}
