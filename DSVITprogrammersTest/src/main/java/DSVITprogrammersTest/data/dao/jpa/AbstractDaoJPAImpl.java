package DSVITprogrammersTest.data.dao.jpa;

import DSVITprogrammersTest.data.dao.interfaces.Dao;
import DSVITprogrammersTest.data.dataobjects.DomainObject;
import org.springframework.orm.jpa.support.JpaDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;


public abstract class AbstractDaoJPAImpl<T extends DomainObject> extends JpaDaoSupport implements Dao<T> {
	
	private Class<T> domainClass;
	

	public AbstractDaoJPAImpl(Class<T> domainClass) {
		this.domainClass = domainClass;
	}
	
	@Transactional
	public void delete(T object)
	{ 
		getJpaTemplate().remove(object);
	}
	@Transactional
	public T load(Serializable id)
	{
		return (T) getJpaTemplate().find(domainClass, id);
	}
	
	@Transactional
	public T save(T object)
	{
		return getJpaTemplate().merge(object);
	}
	
}

