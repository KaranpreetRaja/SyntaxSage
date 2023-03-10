package CustomComponents;
import java.util.ArrayList;

public class Enrollment {
	private Account account;
	private Course course;
	private int lessonsCompleted;
	private boolean completed;
	
	
	public Enrollment(Account acc, Course course){
		this.account = acc;
		this.course = course;
		this.lessonsCompleted = 0;
		this.completed = false;
	}


	public Account getAccount() {
		return account;
	}


	public void setAccount(Account account) {
		this.account = account;
	}


	public Course getCourse() {
		return course;
	}


	public void setCourse(Course course) {
		this.course = course;
	}


	public boolean isCompleted() {
		return completed;
	}


	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
}
