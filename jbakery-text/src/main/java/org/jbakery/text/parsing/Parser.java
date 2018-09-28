package org.jbakery.text.parsing;

import org.jbakery.arguments.Argument;
import org.jbakery.text.parsing.source.ParserSource;

public class Parser
{
	private final ParserSource parserSource;

	public Parser(ParserSource parserSource)
	{
		this.parserSource = Argument.notNull(parserSource, "parserSource");
	}

	public <T> T parse(Class<T> type, String text)
	{
		Argument.notNull(type, "type");
		Argument.notNull(text, "text");

		var result = tryParse(type, text);

		if (result == null)
			throw new ParseException(type, text);

		return result;
	}

	public <T> T tryParse(Class<T> type, String text)
	{
		Argument.notNull(type, "type");
		Argument.notNull(text, "text");

		var parser = parserSource.tryGet(type);

		if (parser == null)
			throw new ParserNotFoundException(type);

		return (T)parser.tryParse(text);
	}
}
