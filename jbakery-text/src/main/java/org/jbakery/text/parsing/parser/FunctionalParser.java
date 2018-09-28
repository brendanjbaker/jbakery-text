package org.jbakery.text.parsing.parser;

import java.util.function.Function;
import org.jbakery.arguments.Argument;

public class FunctionalParser<T>
	implements Parser<T>
{
	private final Class type;
	private final Function<String, T> parseFunction;

	public FunctionalParser(Class type, Function<String, T> parseFunction)
	{
		this.type = Argument.notNull(type, "type");
		this.parseFunction = Argument.notNull(parseFunction, "parseFunction");
	}

	@Override
	public <T> boolean canParse(Class<T> type)
	{
		Argument.notNull(type, "type");

		return this.type == type;
	}

	@Override
	public T tryParse(String text)
	{
		Argument.notNull(text, "text");

		return parseFunction.apply(text);
	}
}
