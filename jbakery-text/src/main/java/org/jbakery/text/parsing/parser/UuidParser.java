package org.jbakery.text.parsing.parser;

import java.util.UUID;
import java.util.function.Function;

public class UuidParser
	extends FunctionalParser<UUID>
{
	public UuidParser(Class type, Function<String, UUID> parseFunction)
	{
		super(UUID.class, text ->
		{
			// Shortest format is 32 characters:
			// "AAAAAAAABBBBCCCCDDDDEEEEEEEEEEEE"

			if (text.length() < 32)
				return null;

			// Longest format is 38 characters:
			// "{AAAAAAAA-BBBB-CCCC-DDDD-EEEEEEEEEEEE}"

			if (text.length() > 38)
				return null;

			// We might have a UUID at this point. There is no built-in "try parse" mechanism, so just
			// try/catch an attempt.

			try
			{
				return UUID.fromString(text);
			}
			catch (Exception e)
			{
				return null;
			}
		});
	}
}
