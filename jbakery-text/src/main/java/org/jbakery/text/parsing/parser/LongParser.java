package org.jbakery.text.parsing.parser;

public class LongParser
	extends FunctionalParser<Long>
{
	public LongParser()
	{
		super(Long.class, Long::parseLong);
	}
}
