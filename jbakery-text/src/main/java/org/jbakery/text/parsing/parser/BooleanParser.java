package org.jbakery.text.parsing.parser;

public class BooleanParser
	extends FunctionalParser<Boolean>
{
	public BooleanParser()
	{
		super(Boolean.class, text ->
		{
			switch (text.trim().toLowerCase())
			{
				case "n":
				case "no":
				case "false":
					return false;

				case "y":
				case "yes":
				case "true":
					return true;

				default:
					return null;
			}
		});
	}
}
