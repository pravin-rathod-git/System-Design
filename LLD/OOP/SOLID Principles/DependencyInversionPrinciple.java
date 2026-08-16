/*

Dependency Inversion Principle (DIP)

The Dependency Inversion Principle (DIP) is the “D” in SOLID. It states that:

High-level modules should not depend on low-level modules. Both should depend on abstractions.

It also states that:

Abstractions should not depend on details. Details should depend on abstractions.

Key Idea

Instead of a high-level class directly depending on a specific implementation, it should depend on an interface or abstraction.

This makes the system:

Loosely coupled
Easier to maintain
Easier to test
Easier to extend
Flexible when implementations change


                MessageService
               /      |       \
              /       |        \
      EmailService  SMSService  WhatsAppService
              \       |        /
               \      |       /
                Notification


                
 High-Level Class
       ↓
   Interface
      ↑
Low-Level Class               



*/


interface MessageService {
    void send(String message);
}

class EmailService implements MessageService {

    @Override
    public void send(String message) {
        System.out.println("Email: " + message);
    }
}

class SMSService implements MessageService {

    @Override
    public void send(String message) {
        System.out.println("SMS: " + message);
    }
}

class Notification {

    private MessageService messageService;

    public Notification(MessageService messageService) {
        this.messageService = messageService;
    }

    public void notifyUser(String message) {
        messageService.send(message);
    }
}

public class DependencyInversionPrinciple {

    public static void main(String[] args) {

        // Using Email Service
        MessageService email = new EmailService();
        Notification emailNotification = new Notification(email);
        emailNotification.notifyUser("Welcome to our application!");

        System.out.println();

        // Using SMS Service
        MessageService sms = new SMSService();
        Notification smsNotification = new Notification(sms);
        smsNotification.notifyUser("Your OTP is 123456");
    }
}
