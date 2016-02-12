package com.genpact.training.receiver;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class MyMessageListener implements MessageListener {

	@Override
	public void onMessage(Message msg) {
		// TODO Auto-generated method stub
		if(msg instanceof TextMessage){
			TextMessage txtMsg=(TextMessage)msg;
			try {
				System.out.println("Received Message: "+txtMsg.getText());
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
