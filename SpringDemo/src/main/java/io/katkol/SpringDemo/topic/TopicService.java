package io.katkol.SpringDemo.topic;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	//A mutable arraylist is needed here to allow array operations like adding elements
	//deleting elements etc.
	private List<Topic> topics  = new ArrayList<>(Arrays.asList(
			new Topic("A123", "Computers", "Computer progmramming"),
			new Topic("B234", "Physics", "Physics with labs"),
			new Topic("C345", "German", "German Language course")
			)); 
	public List<Topic> getAllTopics() {
		return topics;
	}
	
	public Topic getTopic(String id) {
		return topics.stream().filter(t->t.getId().equals(id)).findFirst().get();
	}
	
	public void addTopic(Topic topic) {
		topics.add(topic);
	}
	
	public void updateTopic(String id, Topic topic) {
		for(int i=0; i<topics.size(); i++) {
			Topic t = topics.get(i);
			if(t.getId().equals(id)) {
				topics.set(i, topic);
			}
		}
	}
	public void deleteTopic(String id) {
		topics.removeIf(t->t.getId().equals(id));
	}
}
