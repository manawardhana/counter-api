package com.inteliment.counter.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inteliment.counter.model.WordFrequency;
import com.inteliment.counter.service.SearchService;

/**
 * Counter API Implementation
 * 
 * @author tharaka
 *
 */
@Controller
@RequestMapping("/counter-api")
public class CounterApiController {

	@Autowired
	private SearchService searchService;
	
    @RequestMapping(value="search", method=RequestMethod.POST)
    public @ResponseBody Map<String, List<WordFrequency>> getWordFrequency(@RequestBody Map<String, List<String>> requestBody) {
        List<WordFrequency> wordFrequencies = searchService.queryWordFrequency(requestBody.get("searchText"));
        Map<String, List<WordFrequency>> response = new HashMap<>();
        response.put("counts", wordFrequencies);
        return response;
    }

    @RequestMapping(value = "/top/{limit}", method=RequestMethod.GET)
    public void topWordsAsCSV(@PathVariable("limit") Integer limit, HttpServletResponse response) {  
    	Map<String, Integer> topWords = searchService.getTopWords(limit);
    	StringBuffer csvContent = new StringBuffer();

    	for(Entry<String, Integer> e : topWords.entrySet()){
    		csvContent.append(e.getKey() + "," + e.getValue() + "\n");
    	}
    	
        response.setContentType("application/csv");
        response.setHeader("Content-Disposition", "attachment; filename=" + "top" + limit + "words");
    	response.setContentType("text/plain; charset=utf-8");
        
    	try {
			response.getWriter().print(csvContent.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
