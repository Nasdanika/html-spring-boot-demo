package org.nasdanika.html.springbootdemo;

import org.json.JSONArray;
import org.json.JSONObject;
import org.nasdanika.html.Tag;
import org.nasdanika.html.app.Application;
import org.nasdanika.html.app.impl.BootstrapContainerApplication;
import org.nasdanika.html.bootstrap.Color;
import org.nasdanika.html.bootstrap.Theme;
import org.nasdanika.html.fontawesome.FontAwesomeFactory;
import org.nasdanika.html.jstree.JsTreeContextMenuItem;
import org.nasdanika.html.jstree.JsTreeFactory;
import org.nasdanika.html.jstree.JsTreeNode;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@RequestMapping("/")
	public String home() throws Exception {
		try (Application app = new BootstrapContainerApplication(Theme.Litera) {
			
			{
				container.border(Color.DANGER);
				header.border(Color.DANGER).background(Color.PRIMARY);
				navigationBar.border(Color.DANGER);
				navigationPanel.border(Color.DANGER).widthAuto();
				footer.border(Color.DANGER);
				content.border(Color.DANGER);
			}
			
		}) {
			Tag treeContainer = app.getHTMLPage().getFactory().div();
			app.header("Header")
				.navigationBar("Navigation bar")
				.navigationPanel("Navigation panel")
				.content("Content")
				.footer("Footer");
			
			return app.toString();
		}
	}

}
