package  com.tcsion.java.Project1Backend.dao;

import java.util.List;

import com.tcsion.java.Project1Backend.dto.Feedbacks;

public interface FeedbackDao {

	Boolean add(Feedbacks feedback);
	 public List<String> getFeedback();
	 

}
