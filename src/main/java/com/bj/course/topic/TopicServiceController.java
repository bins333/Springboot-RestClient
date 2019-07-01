package com.bj.course.topic;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TopicServiceController {

	@Autowired
	RestTemplate restTemplate;

	@RequestMapping(value = "/template/topics")
	public Topic[] getTopics() {

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Topic> entity = new HttpEntity<Topic>(headers);

		return restTemplate.exchange("http://localhost:8080/topics", HttpMethod.GET, entity, Topic[].class).getBody();

	}

	@RequestMapping(value = "/template/topics", method = RequestMethod.POST)
	public Topic createTopics(@RequestBody Topic topic) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Topic> entity = new HttpEntity<Topic>(topic, headers);

		return restTemplate.exchange("http://localhost:8080/topics", HttpMethod.POST, entity, Topic.class).getBody();
	}

	@RequestMapping(value = "/template/products/{id}", method = RequestMethod.PUT)
	public Topic updateProduct(@PathVariable("id") String id, @RequestBody Topic product) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Topic> entity = new HttpEntity<Topic>(product, headers);

		return restTemplate.exchange("http://localhost:8080/topics/" + id, HttpMethod.PUT, entity, Topic.class)
				.getBody();
	}

	@RequestMapping(value = "/template/products/{id}", method = RequestMethod.DELETE)
	public String deleteProduct(@PathVariable("id") String id) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Topic> entity = new HttpEntity<Topic>(headers);

		return restTemplate.exchange("http://localhost:8080/topics/" + id, HttpMethod.DELETE, entity, String.class)
				.getBody();
	}

}
