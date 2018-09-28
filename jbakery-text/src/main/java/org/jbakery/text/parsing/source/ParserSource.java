package org.jbakery.text.parsing.source;

import org.jbakery.text.parsing.parser.Parser;

public interface ParserSource
{
	Parser tryGet(Class type);
}
