package main.java.conf;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="settings")
public class Settings 
{
	@XmlElement(name="root")
	public String Root;
}
