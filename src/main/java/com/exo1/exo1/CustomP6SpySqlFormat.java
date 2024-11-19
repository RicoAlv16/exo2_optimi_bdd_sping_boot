package com.exo1.exo1;

import com.p6spy.engine.spy.appender.MessageFormattingStrategy;

public class CustomP6SpySqlFormat implements MessageFormattingStrategy {

	@Override
	public String formatMessage(
			int connectionId, String now, long elapsed, String category, String prepared, String sql, String url) {
		return !sql.trim().isEmpty()
				? "Time: " + elapsed + " ms | Category: " + category + "\nPrepared: " + prepared + "\nSQL: " + sql + "\n"
				: "";
	}
}
