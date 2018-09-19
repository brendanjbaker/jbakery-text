package org.jbakery.text.parsing.source;

import java.util.stream.Stream;
import org.jbakery.arguments.Argument;
import org.jbakery.text.parsing.parser.Parser;

public class MultipleParserSource
	implements ParserSource
{
	private final Parser[] parsers;

	public MultipleParserSource(Parser... parsers)
	{
		this.parsers = Argument.notNull(parsers, "parsers");
	}

	@Override
	public Parser tryGet(Class type)
	{
		Argument.notNull(type, "type");

		return Stream
			.of(parsers)
			.filter(parser -> parser.canParse(type))
			.findFirst()
			.orElse(null);
	}
}
