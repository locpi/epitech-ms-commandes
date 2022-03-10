package fr.ippon.epitech.commandes;

import fr.ippon.epitech.commandes.notification.NotificationService;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/orders")
@RestController
public class OrderRestController {

    private NotificationService notificationService;

    public OrderRestController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping
    public OrderVM createOrder(@RequestBody OrderVM body) {
        notificationService.sendNotificationNewOrder(body.getNom(), body.getPrenom(), body.getEmail());
        return body;
    }

    @PatchMapping("/send")
    public OrderVM sendOrder(@RequestBody OrderVM body) {
        notificationService.sendNotificationNewOrderUpdate(body.getNumber(), "FRA-TEST");
        return body;
    }

}
