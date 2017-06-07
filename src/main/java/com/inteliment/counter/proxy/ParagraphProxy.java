package com.inteliment.counter.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Retrieves the text content via default URL
 * 
 * @author Tharaka Manawardhana
 */
@Component
public class ParagraphProxy {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private Environment environment;

	@Value("${search-api.default-paragraph-path}")
	private String defaultParagraphPath;

	public String retrieveParagraphContent() {
		String port = environment.getProperty("local.server.port");
		String preparedDefaultParagraphPath = defaultParagraphPath.replace("{port}", port);

		ResponseEntity<String> paragraphResponse = restTemplate.getForEntity(preparedDefaultParagraphPath,
				String.class);
		return paragraphResponse.getBody();
	}
}