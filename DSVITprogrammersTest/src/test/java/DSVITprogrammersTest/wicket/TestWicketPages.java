package DSVITprogrammersTest.wicket;

import DSVITprogrammersTest.data.dao.interfaces.AdsDao;
import DSVITprogrammersTest.pages.AdsPage;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import org.apache.wicket.spring.test.ApplicationContextMock;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import DSVITprogrammersTest.HomePage;
import DSVITprogrammersTest.WicketApplication;

/**
 * Created with IntelliJ IDEA.
 * User: kibromk
 * Date: 2/22/13
 * Time: 1:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestWicketPages {
	
	protected WicketTester tester;
	
	@Before
	public void setup()
	{
		final ApplicationContextMock acm = new ApplicationContextMock();
		
		AdsDao adsDao = Mockito.mock(AdsDao.class);
		
		acm.putBean("adsDao", adsDao);
		
		tester = new WicketTester(new WicketApplication(){
			/* (non-Javadoc)
			 * @see DSVITprogrammersTest.WicketApplication#getGuiceInjector()
			 */
			@Override
			protected SpringComponentInjector getSpringInjector() {
				return  new SpringComponentInjector(this, acm, true);
			}
		});
	}
	
	@Test
	public void testStartPage()
	{
		tester.startPage(HomePage.class);
	}
	
	@Test
	public void testEventPage()
	{
		tester.startPage(AdsPage.class);
	}

}
