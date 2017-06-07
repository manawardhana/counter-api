package com.inteliment.counter.util;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.inteliment.counter.CounterApiApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CounterApiApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = { "management.port=0" })
public class StringSearchUtilTest {
	
	private static String sampleString;
	private static Map<String, Integer> frequency;
	
	@BeforeClass
	public static void init(){
		sampleString = "apple orange  apple mango mango";
		frequency = new HashMap<String, Integer>();
		frequency.put("apple", 2);
		frequency.put("orange", 1);
		frequency.put("mango", 2);
	}
	
	@Test
	public void shouldReturnWordFrequencyWhenStringIsGiven(){
		Map<String, Integer> frequencyResult = StringSearchUtil.getWordFrequencies(sampleString);
		assertEquals(frequencyResult, frequency);		
	}
}
