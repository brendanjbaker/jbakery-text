package org.jbakery.text.parsing;

public class ParseException
	extends RuntimeException
{
	public ParseException(Class type, String text)
	{
		super(String.format("Could not parse \"%s\" into type \"%s\".", text, type));
	}
}
