package com.genpact.training.sender;

import java.util.Properties;

import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class SenderTest {

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
			QueueSender sender=session.createSender(queue);
			TextMessage message=session.createTextMessage();
			for(int i=1;i<=10;i++){
			message.setText("This is a test message "+i);
			sender.send(message);
			}
			System.out.println("message sent");
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
