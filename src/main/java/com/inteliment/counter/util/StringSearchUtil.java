package com.inteliment.counter.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.inteliment.counter.model.WordFrequency;

public class StringSearchUtil {

	public static Map<String, Integer> getWordFrequencies(String str) {
		Stream<Map.Entry<String, Integer>> frequencyMapStreem = getWordFrequenciesStreem(str);
		Map<String, Integer> frequencyMap = frequencyMapStreem.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
				(e1, e2) -> e1 + e2, LinkedHashMap::new));
		
		return frequencyMap;
	}
	
	public static Map<String, Integer> getWordFrequencies(String str, Integer limit) {
		Stream<Map.Entry<String, Integer>> frequencyMapStreem = getWordFrequenciesStreem(str);
		Map<String, Integer> frequencyMap = frequencyMapStreem.limit(limit)
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
				(e1, e2) -> e1 + e2, LinkedHashMap::new));
		
		return frequencyMap;
	}
	
	public static List<WordFrequency> queryWordFrequency(String str, List<String> query){
		Map<String, Integer> frequencyMap = getWordFrequencies(str);
		
		List<WordFrequency> wordFrequencyList = new ArrayList<>();
		for(String queryItem : query){
			if(frequencyMap.containsKey(queryItem.toLowerCase())){
				wordFrequencyList.add(new WordFrequency(queryItem, frequencyMap.get(queryItem.toLowerCase())));
			} else {
				wordFrequencyList.add(new WordFrequency(queryItem, 0));
			}
		}

		return wordFrequencyList;		
	}
	
	private static Stream<Map.Entry<String, Integer>>getWordFrequenciesStreem(String str) {

		String[] words = str.replaceAll("\\p{P}", " ").toLowerCase().split("\\s+");
		
		Stream<Map.Entry<String, Integer>> frequencyMap = Arrays.asList(words).stream()
				.filter(e -> e.length() > 0)
				.map(String::toLowerCase)
				.map(String::trim)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(e -> 1)))
				.entrySet().stream()
				.sorted(Map.Entry.<String, Integer>comparingByValue().reversed());
				
		return frequencyMap;
	}
}
