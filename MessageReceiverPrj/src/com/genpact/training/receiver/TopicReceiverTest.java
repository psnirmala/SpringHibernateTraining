package com.genpact.training.receiver;

import java.util.Properties;

import javax.jms.JMSException;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class TopicReceiverTest {

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
			TopicSubscriber subscriber=session.createSubscriber(topic);
			subscriber.setMessageListener(new MyMessageListener());
			System.out.println("waiting for messages");
			connection.start();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
