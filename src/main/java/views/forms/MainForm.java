package main.java.views.forms;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

import main.java.presenters.MainPresenter;
import main.java.views.IBaseView;

public class MainForm
{
	private IBaseView baseView;
	private MainPresenter presenter;

	
	// Components:
	private JPanel viewPanel;
	private JPanel filePanel;
	private JLabel rootLabel;
	private JLabel htmlLabel;
	private JLabel headerLabel;
	private JLabel footerLabel;
	private JLabel outputLabel;
	private JTextField root;
	private JTextField htmlFile;
	private JTextField headerFile;
	private JTextField footerFile;
	private JTextField outputFile;
	private JButton startBtn;

	
	public MainForm(IBaseView baseView)
	{
		this.baseView = baseView;
		this.viewPanel = baseView.getViewPanel();
	}
	
	public void initialize()
	{
		filePanel = new JPanel();
		filePanel.setLayout(new GridLayout(12, 1));
		viewPanel.add(filePanel);
		
		Dimension dim = new Dimension(200, 25);
		
		rootLabel = new JLabel("Root directory:");
		root = new JTextField();
		root.setPreferredSize(dim);
		
		htmlLabel = new JLabel("HTML file:");
		htmlFile = new JTextField();
		htmlFile.setPreferredSize(dim);
		
		headerLabel = new JLabel("Header file:");
		headerFile = new JTextField();
		headerFile.setPreferredSize(dim);
		
		footerLabel = new JLabel("Footer file:");
		footerFile = new JTextField();
		footerFile.setPreferredSize(dim);

		outputLabel = new JLabel("Output file:");
		outputFile = new JTextField();
		outputFile.setPreferredSize(dim);
		
		startBtn = new JButton("Run");
		
		filePanel.add(rootLabel);
		filePanel.add(root);
		
		filePanel.add(htmlLabel);
		filePanel.add(htmlFile);
		
		filePanel.add(headerLabel);
		filePanel.add(headerFile);
		
		filePanel.add(footerLabel);
		filePanel.add(footerFile);
		
		filePanel.add(outputLabel);
		filePanel.add(outputFile);
		
		filePanel.add(new JLabel(""));
		filePanel.add(startBtn);
		
		baseView.repaint();
	}
	
	public void addActionListeners()
	{
		startBtn.addActionListener(e -> { presenter.run(root.getText(),
														htmlFile.getText(), 
														headerFile.getText(), 
														footerFile.getText(), 
														outputFile.getText()); });
	}
	
	public void dispose()
	{
		viewPanel.removeAll();
		
		for (ActionListener listener : startBtn.getActionListeners())
		{
			startBtn.removeActionListener(listener);
		}
	}
	
	public void setPresenter(MainPresenter presenter)
	{
		this.presenter = presenter;
	}
	
	public void setStatus(String message)
	{
		baseView.setStatus(message);
	}
}
