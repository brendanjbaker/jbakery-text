package org.jbakery.text.parsing.source;

import java.util.HashMap;
import java.util.Map;
import org.jbakery.arguments.Argument;
import org.jbakery.text.parsing.parser.Parser;

public class CachingParserSource
	implements ParserSource
{
	private final Map<Class, Parser> parserCache;
	private final ParserSource parserSource;

	public CachingParserSource(ParserSource parserSource)
	{
		this(parserSource, new HashMap<>());
	}

	private CachingParserSource(ParserSource parserSource, Map<Class, Parser> parserCache)
	{
		this.parserCache = Argument.notNull(parserCache, "parserCache");
		this.parserSource = Argument.notNull(parserSource, "parserSource");
	}

	@Override
	public Parser tryGet(Class type)
	{
		Argument.notNull(type, "type");

		return parserCache.computeIfAbsent(type, parserSource::tryGet);
	}
}
