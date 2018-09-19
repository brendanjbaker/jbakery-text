package org.jbakery.text.parsing;

public class ParserNotFoundException
	extends RuntimeException
{
	public ParserNotFoundException(Class type)
	{
		super(String.format("Could not find parser for type \"%s\".", type));
	}
}
