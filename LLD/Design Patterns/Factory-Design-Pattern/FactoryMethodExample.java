// ============================================================================
// Product Interface
// ============================================================================

/**
 * Common interface for all notification types.
 */
interface Notification {

    /**
     * Sends the notification.
     */
    void send();
}

// ============================================================================
// Concrete Product - Email Notification
// ============================================================================

/**
 * Represents an Email Notification.
 */
class EmailNotification implements Notification {

    @Override
    public void send() {
        System.out.println("Sending Email Notification 📧");
    }
}

// ============================================================================
// Concrete Product - SMS Notification
// ============================================================================

/**
 * Represents an SMS Notification.
 */
class SMSNotification implements Notification {

    @Override
    public void send() {
        System.out.println("Sending SMS Notification 📱");
    }
}

// ============================================================================
// Concrete Product - Push Notification
// ============================================================================

/**
 * Represents a Push Notification.
 */
class PushNotification implements Notification {

    @Override
    public void send() {
        System.out.println("Sending Push Notification 🔔");
    }
}

// ============================================================================
// Creator (Factory Interface)
// ============================================================================

/**
 * Factory interface responsible for creating Notification objects.
 *
 * Each concrete factory will create only one type of notification.
 */
interface NotificationFactory {

    /**
     * Creates and returns a Notification object.
     *
     * @return Notification object
     */
    Notification createNotification();
}

// ============================================================================
// Concrete Factory - Email
// ============================================================================

/**
 * Creates EmailNotification objects.
 */
class EmailNotificationFactory implements NotificationFactory {

    @Override
    public Notification createNotification() {
        return new EmailNotification();
    }
}

// ============================================================================
// Concrete Factory - SMS
// ============================================================================

/**
 * Creates SMSNotification objects.
 */
class SMSNotificationFactory implements NotificationFactory {

    @Override
    public Notification createNotification() {
        return new SMSNotification();
    }
}

// ============================================================================
// Concrete Factory - Push
// ============================================================================

/**
 * Creates PushNotification objects.
 */
class PushNotificationFactory implements NotificationFactory {

    @Override
    public Notification createNotification() {
        return new PushNotification();
    }
}

// ============================================================================
// Client
// ============================================================================

/**
 * Demonstrates the Factory Method Design Pattern.
 */
public class FactoryMethodExample {

    public static void main(String[] args) {

        // Create an Email Notification using Email Factory.
        NotificationFactory emailFactory = new EmailNotificationFactory();
        Notification email = emailFactory.createNotification();
        email.send();

        // Create an SMS Notification using SMS Factory.
        NotificationFactory smsFactory = new SMSNotificationFactory();
        Notification sms = smsFactory.createNotification();
        sms.send();

        // Create a Push Notification using Push Factory.
        NotificationFactory pushFactory = new PushNotificationFactory();
        Notification push = pushFactory.createNotification();
        push.send();
    }
}