package io.katkol.SpringDemo.topic;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {

	@Autowired
	private TopicService topicService;
	
	//GET request
	//as get is default method, any request on localhost:8080/topics without method specification
	//executes this method 
	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		return topicService.getAllTopics();
	}
	
	//PathVariable annotation is used to pass the value of the id_number to variable id
	@RequestMapping("/topics/{id_number}")
	public Topic getTopic(@PathVariable("id_number") String id) {
		return topicService.getTopic(id);
	}
	
	//POST request
	//Any POST request on the URL localhost:8080/topics executes this method
	//@RequestBody annotation is used to tell Spring MVC to convert the payload of the request to
	//Topic object and pass it to this function
	@RequestMapping(method=RequestMethod.POST, value="/topics")
	public void addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
	}
	
	//PUT request
	//Any PUT request on the URL localhost:8080/topics/{id} updates the topic information corresponding to id
	//@RequestBody annotation is used to tell Spring MVC to convert the payload of the request to
	//Topic object and pass it to this function
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{id}")
	public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
		topicService.updateTopic(id, topic);
	}

	//DELETE request
	//Any DELETE request on the URL localhost:8080/topics/{id} deletes the topic information corresponding to id
	//@RequestBody annotation is used to tell Spring MVC to convert the payload of the request to
	//Topic object and pass it to this function
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}")
	public void deleteTopic(@PathVariable String id) {
		topicService.deleteTopic(id);
	}
	
}
