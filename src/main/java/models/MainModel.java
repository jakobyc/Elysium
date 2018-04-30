package main.java.models;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainModel 
{
	public void run(String root, String html, String header, String footer, String output)
	{
		if ((root != null && !root.isEmpty()) && (output != null && !output.isEmpty()))
		{
			File rootDirectory = new File(root);
			
			if (rootDirectory.isDirectory())
			{
				File htmlFile = new File(root + html);
				File headerFile = new File(root + header);
				File footerFile = new File(root + footer);
				
				String htmlText = getContent(htmlFile);
				String headerText = getContent(headerFile);
				String footerText = getContent(footerFile);
				
				// Generate header and footer:
				htmlText = htmlText.replaceFirst("@header", headerText);
				htmlText = htmlText.replaceFirst("@footer", footerText);
				
				// Create final HTML document:
				File outputFile = new File(root + output);
				createFile(outputFile, htmlText);
			}
		}
	}
	
	// Read content of a file:
	private String getContent(File file)
	{
		String content = "";
		if (file != null && file.exists() && file.isFile())
		{
			try (FileInputStream stream = new FileInputStream(file))
			{
				int ascii;
				while ((ascii = stream.read()) != -1)
				{
					content += (char)ascii;
				}
			}
			catch(IOException e)
			{
				
			}
		}
		return content;
	}
	
	// Create a file at a specific path:
	private void createFile(File file, String content)
	{
		try (FileOutputStream stream = new FileOutputStream(file))
		{
			stream.write(content.getBytes());
		}
		catch(IOException e)
		{
			
		}
	}
}
