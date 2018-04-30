package main.java.presenters;

import main.java.models.MainModel;
import main.java.views.forms.MainForm;

public class MainPresenter 
{
	private MainForm view;
	private MainModel model;
	
	public MainPresenter(MainForm view)
	{
		this.model = new MainModel();
		
		attachView(view);
	}
	
	public void attachView(MainForm view)
	{
		this.view = view;
		
		view.initialize();
		view.setPresenter(this);
		view.addActionListeners();
	}
	
	public void run(String root, String html, String header, String footer, String output)
	{
		view.setStatus("Generating HTML documents...");
		model.run(root, html, header, footer, output);
		view.setStatus(String.format("HTML documents saved at %s", output));
	}
}
