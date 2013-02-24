package DSVITprogrammersTest;

import DSVITprogrammersTest.pages.AdsPage;
import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;

/**
 * Created with IntelliJ IDEA.
 * User: kibromk
 * Date: 2/22/13
 * Time: 1:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class HomePage extends WebPage {

	private static final long serialVersionUID = 1L;


    public HomePage(final PageParameters parameters) {


        add(new BookmarkablePageLink<Void>("ad", AdsPage.class));
        
        
    }
}
