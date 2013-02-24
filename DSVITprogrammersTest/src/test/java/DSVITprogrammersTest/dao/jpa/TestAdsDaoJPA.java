package DSVITprogrammersTest.dao.jpa;


import DSVITprogrammersTest.data.dao.interfaces.AdsDao;
import DSVITprogrammersTest.data.dataobjects.Ad;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kibromk
 * Date: 2/22/13
 * Time: 1:35 PM
 * To change this template use File | Settings | File Templates.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class TestAdsDaoJPA {

	@Autowired
	private AdsDao adsDao;

	protected Ad ad;

	@Before
	public void startTransaction()
	{
		ad = new Ad();
		ad.setTitle("new Title");
		ad = adsDao.save(ad);
	}


	/**
	 * Test method for {@link DSVITprogrammersTest.data.dao.jpa.AdsDaoJPAImp#findAll()}.
	 */
	@Test
	@Transactional
	@Rollback
	public void testFindAll() {
		List<Ad> adses = new ArrayList<Ad>();
		adses.add(ad);
		Assert.assertEquals(adses, adsDao.findAll());
	}

	/**
	 * Test method for {DSVITprogrammersTest.data.dao.jpa.AdsDaoJPAImp#countAll()}.
	 */
	@Test @Transactional
	@Rollback
	public void testCountAll() {
		Assert.assertEquals(1, adsDao.countAll());
	}

	/**
	 * Test method for {DSVITprogrammersTest.data.dao.jpa.AbstractDaoJPAImpl#delete(DSVITprogrammersTest.data.dataobjects.DomainObject)}.
	 */
	@Test @Transactional
	@Rollback
	public void testDelete() {
		adsDao.delete(ad);
		Assert.assertEquals(0, adsDao.countAll());
	}

	/**
	 * Test method for {DSVITprogrammersTest.data.dao.jpa.AbstractDaoJPAImpl#load(java.io.Serializable)}.
	 */
	@Test @Transactional
	@Rollback
	public void testLoad() {
		Ad ad2 = adsDao.load(ad.getId());
		Assert.assertEquals(ad, ad2);
	}

	/**
	 * Test method for {DSVITprogrammersTest.data.dao.jpa.AbstractDaoJPAImpl#save(DSVITprogrammersTest.data.dataobjects.DomainObject)}.
	 */
	@Test @Transactional
	@Rollback
	public void testSave() {

	}

}
