package com.inteliment.counter.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inteliment.counter.model.WordFrequency;
import com.inteliment.counter.proxy.ParagraphProxy;
import com.inteliment.counter.util.StringSearchUtil;

/**
 * Search service implementation
 * 
 * @author Tharaka Manawardhana
 */
@Service
public class SearchServiceImpl implements SearchService {

	@Autowired
	private ParagraphProxy paragraphProxy;

	@Override
	public List<WordFrequency> queryWordFrequency(List<String> query) {
		String text = paragraphProxy.retrieveParagraphContent();
		List<WordFrequency> wordFrequencies = StringSearchUtil.queryWordFrequency(text, query);
		return wordFrequencies;
	}

	@Override
	public Map<String, Integer> getTopWords(Integer n) {
		String text = paragraphProxy.retrieveParagraphContent();
		Map<String, Integer> wordFrequencies = StringSearchUtil.getWordFrequencies(text, n);
		return wordFrequencies;
	}

}
