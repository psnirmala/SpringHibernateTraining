package com.genpact.training.receiver;

import java.util.Properties;

import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ReceiverTest {

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
			QueueConnectionFactory factory=(QueueConnectionFactory) context.lookup("java:/XAConnectionFactory");
			QueueConnection connection=factory.createQueueConnection();
			QueueSession session=connection.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);
			Queue queue=(Queue)context.lookup("queue/trainingQueue");
			QueueReceiver receiver=session.createReceiver(queue);
			MyMessageListener  listener=new MyMessageListener();
			receiver.setMessageListener(listener);
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
