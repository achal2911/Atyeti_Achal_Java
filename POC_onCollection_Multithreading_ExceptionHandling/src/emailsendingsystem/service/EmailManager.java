package emailsendingsystem.service;

import emailsendingsystem.exception.EmailSendingFailedException;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class EmailManager {
    private final BlockingQueue<String> emailQueue = new LinkedBlockingQueue<>(100);
    private final EmailService emailService = new EmailService();

    public void startSystem() {
        Thread producer = new Thread(this::produceEmails);
        Thread consumer = new Thread(this::consumeEmails);

        producer.start();
        consumer.start();
    }

    //adding email addresses to queue
    private void produceEmails() {
        int count = 1;
        while (true) {
            String email = "user" + count + "@gmail.com";
            try {
                emailQueue.put(email);
                System.out.println("Added email: " + email);
                count++;
                Thread.sleep(10000);
            } catch (InterruptedException ignored) {
            }
        }
    }

    //sending email from queue
    private void consumeEmails() {
        while (true) {
            try {
                String email = emailQueue.take();
                emailService.sendEmail(email);
                System.out.println("Email sent to: " + email);
            } catch (EmailSendingFailedException e) {
                System.out.println("Failed to send email to: " + e.getMessage());
                try {
                    emailQueue.put(e.getMessage());//trying to resend email
                } catch (InterruptedException ignored) {
                }
            } catch (InterruptedException ignored) {
            }
        }
    }

}
