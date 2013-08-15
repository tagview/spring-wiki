package br.com.tagview.wiki;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import br.com.tagview.wiki.models.Page;
import br.com.tagview.wiki.models.Wiki;

import com.googlecode.objectify.ObjectifyService;

public class StartupConfiguration implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		ObjectifyService.register(Wiki.class);
		ObjectifyService.register(Page.class);
	}

}
