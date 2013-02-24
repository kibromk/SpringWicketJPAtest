package DSVITprogrammersTest.data.dao.interfaces;

import DSVITprogrammersTest.data.dataobjects.DomainObject;

import java.io.Serializable;
import java.util.List;

public interface Dao<T extends DomainObject>
{
	public void delete(T o);

	public T load(Serializable id);

	public T save(T o);

	public List<T> findAll();

	public int countAll();
}

