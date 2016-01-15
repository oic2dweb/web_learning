package app.persistence;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.smtp.SMTPTransport;

public class UseMail {
	public boolean send(String email,String text){
		boolean flg = false;

		try{
			//Propertiesクラスを使い、mailの設定を行う
			Properties pro = new Properties();

			//ホスト(今回はgmailを使用)
			pro.put("mail.smtp.host", "smtp.gmail.com");

			//認証するかどうか
			pro.put("mail.smpt.auth", "true");
			//pro.put("mail.smpt.auth", "false");

			//ポート番号の指定
			pro.put("mail.smtp.port", "587");
			//pro.put("mail.smtp.port", "25");

			//STARTTLSの暗号化をするかどうか
			pro.put("mail.smtp.starttls.enable", "true");

			//mailの設定したオブジェクトを渡してセッションを取得する
			Session session = Session.getInstance(pro);

			//セッションオブジェクトを渡して、メールの中身を設定する為のオブジェクトを作成
			Message msg = new MimeMessage(session);

			//送信者のメールアドレスをセット
			msg.setFrom(new InternetAddress("weblearningsystem@gmail.com"));

			//宛先のメールアドレスをセット
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email,false));

			//タイトルの設定
			msg.setSubject("WEBラーニングシステムからのメール");

			//本文設定
			msg.setText(text);

			//送信日時の設定
			msg.setSentDate(new Date());

			//使用するプロトコルの設定(今回はSMTPを使用)
			SMTPTransport t = (SMTPTransport)session.getTransport("smtp");

			//利用するメールサービスのホスト名、GMailアカウント名、GMailアカウントのパスワードを設定
			try{
				t.connect("smtp.gmail.com","WebLearningSystem","oic2dweb");
				t.sendMessage(msg, msg.getAllRecipients());
				flg = true;
			}catch(Exception e){
				flg=false;
			}finally{
			t.close();
			}
		}catch(Exception e){
		}
		return flg;
	}
}
