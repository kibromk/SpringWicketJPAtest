package DSVITprogrammersTest;

import DSVITprogrammersTest.data.dao.interfaces.AdsDao;
import DSVITprogrammersTest.data.dataobjects.Ad;

/**
 * Created with IntelliJ IDEA.
 * User: kibromk
 * Date: 2/22/13
 * Time: 1:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class DataInitialiser {
	
	private static String[] Titles = {" "};

	
	public void setAdsDao(AdsDao adsDao) {
		this.adsDao = adsDao;
	}

	private AdsDao adsDao;

	public void dataInit()
	{
		for(int i = 0; i < 2; i++)
		{
			Ad ad = new Ad();
			ad.setTitle(Titles[(int) (Math.random() * Titles.length)]);

			adsDao.save(ad);
		}
	}

}
