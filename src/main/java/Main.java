package main.java;

import main.java.presenters.MainPresenter;
import main.java.views.IBaseView;
import main.java.views.forms.*;

public class Main 
{
	public static void main(String[] args)
	{	
		IBaseView form = new BaseForm("Elysium");
		
		@SuppressWarnings("unused")
		MainPresenter presenter = new MainPresenter(new MainForm(form));
	}
}
