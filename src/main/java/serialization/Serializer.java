package main.java.serialization;

import java.io.File;
import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Result;


public class Serializer 
{
	@SuppressWarnings("unchecked")
	public static <T> T deserialize(Class<T> type, String xml)
	{
		try 
		{
			JAXBContext context = JAXBContext.newInstance(type);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			
			StringReader reader = new StringReader(xml);
			return (T) unmarshaller.unmarshal(reader);
		}
		catch (Exception e)
		{
			
		}
		
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T deserialize(Class<T> type, File file)
	{
		try 
		{
			JAXBContext context = JAXBContext.newInstance(type);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			
			return (T) unmarshaller.unmarshal(file);
		}
		catch (Exception e)
		{
			
		}
		
		return null;
	}
	
	public static <T> String serialize(T object)
	{
		try 
		{
			JAXBContext context = JAXBContext.newInstance(object.getClass());
			Marshaller marshaller = context.createMarshaller();
			
			Result result = null;
			marshaller.marshal(object, result);
			
			return result.toString();
		}
		catch (Exception e)
		{
			
		}
		
		return "";
	}
	
	public static <T> void serialize(T object, File file)
	{
		try 
		{
			JAXBContext context = JAXBContext.newInstance(object.getClass());
			Marshaller marshaller = context.createMarshaller();
			
			marshaller.marshal(object, file);
		}
		catch (Exception e)
		{
			
		}
	}
}
