package com.inteliment.counter.service;

import java.util.List;
import java.util.Map;

import com.inteliment.counter.model.WordFrequency;

/**
 * Search service abstraction.
 * 
 * @author Tharaka Manawardhana
 */
public interface SearchService {
	/**
	 * Counts the given words in a list from the default resource
	 * 
	 * @param query
	 *            list of words to be queried
	 * @return list of WordFrequency objects for given query
	 */
	List<WordFrequency> queryWordFrequency(List<String> query);

	/**
	 * Gets top words from the default resource
	 * 
	 * @param n
	 *            limit of the result
	 * @return n number of words and their frequency for the top words
	 */
	Map<String, Integer> getTopWords(Integer n);
}
