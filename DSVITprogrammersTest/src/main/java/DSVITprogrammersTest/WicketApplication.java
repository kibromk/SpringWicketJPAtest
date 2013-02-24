package DSVITprogrammersTest;

import DSVITprogrammersTest.pages.AdsPage;
import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;

/**
 * Created with IntelliJ IDEA.
 * User: kibromk
 * Date: 2/22/13
 * Time: 1:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class WicketApplication extends WebApplication
{    
	/**
	 * Constructor
	 */
	public WicketApplication()
	{
	}
	
	protected SpringComponentInjector getSpringInjector()
	{
		return new SpringComponentInjector(this);
	}

	@Override
	protected void init() {
		super.init();

		mountBookmarkablePage("ad", AdsPage.class);
		
		addComponentInstantiationListener(getSpringInjector());

	}

	@Override
	public Class<? extends Page> getHomePage() {
		return HomePage.class;
	}

}
