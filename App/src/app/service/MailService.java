package app.service;
import app.persistence.UseMail;

public class MailService {
	private UseMail mail = new UseMail();

	public boolean send(String email,String text){
		return mail.send(email,text);
	}

}
