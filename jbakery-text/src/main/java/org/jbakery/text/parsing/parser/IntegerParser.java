package org.jbakery.text.parsing.parser;

public class IntegerParser
	extends FunctionalParser<Integer>
{
	public IntegerParser()
	{
		super(Integer.class, Integer::parseInt);
	}
}
