package org.jbakery.text.parsing.parser;

public interface Parser<T>
{
	<T> boolean canParse(Class<T> type);
	T tryParse(String text);
}
