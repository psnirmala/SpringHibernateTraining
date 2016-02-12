package com.genpact.training.sender;

import java.util.Properties;

import javax.jms.JMSException;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class TopicSenderTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Properties env=new Properties();
		env.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
		env.setProperty(Context.PROVIDER_URL, "jnp://localhost:1099");
		
		try {
			Context context=new InitialContext(env);
			TopicConnectionFactory factory=(TopicConnectionFactory) context.lookup("java:/XAConnectionFactory");
			TopicConnection connection=factory.createTopicConnection();
			TopicSession session=connection.createTopicSession(false, TopicSession.AUTO_ACKNOWLEDGE);
			Topic topic=(Topic)context.lookup("topic/trainingTopic");
			TopicPublisher publisher=session.createPublisher(topic);
			TextMessage message=session.createTextMessage();
			for(int i=1;i<=10;i++){
			message.setText("This is a test message "+i);
			publisher.publish(message);
			}
			System.out.println("messages sent");
			connection.close();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
