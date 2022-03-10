package fr.ippon.epitech.commandes.notification;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {


    private JmsTemplate jmsTemplate;

    public NotificationService(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }


    public void sendNotificationNewOrder(String nom, String prenom, String email) {
        jmsTemplate.convertAndSend("notification_new_order", formatMessage(new MessageNewOrderIncomming(nom, prenom, email)));
    }

    public void sendNotificationNewOrderUpdate(String number, String numColis) {
        jmsTemplate.convertAndSend("notification_send_order", formatMessage(new MessageOrderSendIncomming(number, numColis)));
    }

    private Object formatMessage(Object message) {
        try {
            return new ObjectMapper().writeValueAsString(message);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Impossible de parser le message");
        }
    }
}
