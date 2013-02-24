package DSVITprogrammersTest.pages;

import DSVITprogrammersTest.data.dao.interfaces.AdsDao;
import DSVITprogrammersTest.data.dataobjects.Ad;
import org.apache.wicket.PageParameters;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import java.util.List;

public class AdsPage extends WebPage {

  @SpringBean
    private AdsDao adsDao;

    public AdsPage(final PageParameters pp)
    {
        Form<Ad> AdsForm = new Form<Ad>("adsForm", new CompoundPropertyModel<Ad>(new Ad()));
        AdsForm.add(new TextArea<String>("title").setRequired(true));


        final WebMarkupContainer wmc = new WebMarkupContainer("listContainer");

        wmc.add(new ListView<Ad>("list", new PropertyModel<List<Ad>>(this, "adsDao.findAll")){

            private static final long serialVersionUID = 1L;

            @Override
            protected void populateItem(ListItem<Ad> item) {
                Ad ad = item.getModelObject();
                item.add(new Label("adsName", ad.getTitle()));

            }

        });
        wmc.setOutputMarkupId(true);
        add(wmc);

        AdsForm.add(new AjaxSubmitLink("submit"){
            private static final long serialVersionUID = 1L;

            @Override
            protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
                Ad ad = (Ad) form.getModelObject();
                Ad newAd = new Ad();

                newAd.setTitle(ad.getTitle());
                adsDao.save(newAd);
                target.addComponent(wmc);



            }
        });


        add(AdsForm);



    }
}
