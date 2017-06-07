package com.inteliment.counter.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.inteliment.counter.util.WordFrequencyJsonSerializer;

/**
 * POJO to represent single word's frequency
 * JSON serialization has been customized as per the requirement
 * 
 * @see WordFrequencyJsonSerializer
 * @author tharaka
 *
 */
@JsonSerialize(using = WordFrequencyJsonSerializer.class)
public class WordFrequency {

	private String word;
	private Integer count;

	public WordFrequency() {
	}

	public WordFrequency(String word, Integer count) {
		this.word = word;
		this.count = count;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
}
