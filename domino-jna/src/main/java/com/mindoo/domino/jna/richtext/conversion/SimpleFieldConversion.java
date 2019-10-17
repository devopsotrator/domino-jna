package com.mindoo.domino.jna.richtext.conversion;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Simple subclass of {@link AbstractFieldConversion} that uses a from/to
 * map to find/replace matches
 * 
 * @author Karsten Lehmann
 */
public class SimpleFieldConversion extends AbstractFieldConversion {
	private Map<Pattern,String> m_fromPatternToString;
	
	/**
	 * Creates a new instance
	 * 
	 * @param fromTo from/to map of search string and replacement
	 * @param ignoreCase true to ignore the case when searching
	 */
	public SimpleFieldConversion(Map<String,String> fromTo, boolean ignoreCase) {
		m_fromPatternToString = new HashMap<Pattern,String>();
		for (Entry<String,String> currEntry : fromTo.entrySet()) {
			String currFrom = currEntry.getKey();
			String currTo = currEntry.getValue();
			
			String currFromPattern = Pattern.quote(currFrom);
			Pattern pattern = ignoreCase ? Pattern.compile(currFromPattern, Pattern.CASE_INSENSITIVE) : Pattern.compile(currFromPattern);
			m_fromPatternToString.put(pattern, currTo);
		}
	}

	private boolean containsMatch(String txt) {
		for (Pattern currPattern : m_fromPatternToString.keySet()) {
			if (currPattern.matcher(txt).find()) {
				return true;
			}
		}
		return false;
	}

	private String replaceAllMatches(String txt) {
		String currTxt = txt;
		
		StringBuffer sb = new StringBuffer();
		
		for (Entry<Pattern,String> currEntry : m_fromPatternToString.entrySet()) {
			Pattern currPattern = currEntry.getKey();
			String currTo = currEntry.getValue();
			
			Matcher m = currPattern.matcher(currTxt);
			while (m.find()) {
				m.appendReplacement(sb, currTo);
			}
			m.appendTail(sb);
			currTxt = sb.toString();
			sb.setLength(0);
		}
		return currTxt;
	}

	@Override
	protected boolean fieldFormulaContainsMatch(FormulaType type, String formula) {
		return containsMatch(formula);
	}

	@Override
	protected String replaceAllMatchesInFieldFormula(FormulaType type, String formula) {
		return replaceAllMatches(formula);
	}

	@Override
	protected boolean fieldNameContainsMatch(String fieldName) {
		return containsMatch(fieldName);
	}

	@Override
	protected String replaceAllMatchesInFieldName(String fieldName) {
		return replaceAllMatches(fieldName);
	}

	@Override
	protected boolean fieldDescriptionContainsMatch(String fieldDesc) {
		return containsMatch(fieldDesc);
	}

	@Override
	protected String replaceAllMatchesInFieldDescription(String fieldDesc) {
		return replaceAllMatches(fieldDesc);
	}

}
