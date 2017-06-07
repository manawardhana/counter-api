package com.inteliment.counter.config;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.client.RestTemplate;

/**
 * Misc bean definitions
 * 
 * @author Tharaka Manawardhana
 * 
 */
@Configuration
public class CounterApiConfig {
	@Autowired
	private ResourceLoader resourceLoader;

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.basicAuthorization("optus", "candidate").build();
	}

	/**
	 * Retrieves the static paragraph content
	 * 
	 * @return static text file content
	 */
	@Bean(value = "sampleParagraph")
	public String paragraph() {
		Resource resource = resourceLoader.getResource("classpath:paragraph.txt");
		StringBuffer fileContetStringBuffer = new StringBuffer();
		try (InputStream in = new FileInputStream(resource.getFile())) {
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			String line = null;
			while ((line = reader.readLine()) != null) {
				fileContetStringBuffer.append(line);
			}
			return fileContetStringBuffer.toString();
		} catch (IOException x) {
			System.err.println(x);
		}
		return null;
	}
}
