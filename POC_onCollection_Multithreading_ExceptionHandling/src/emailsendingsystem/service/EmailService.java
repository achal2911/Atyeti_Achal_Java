package emailsendingsystem.service;

import emailsendingsystem.exception.EmailSendingFailedException;

import java.util.Random;

public class EmailService
{
    private final Random random = new Random();

    public void sendEmail(String email) throws EmailSendingFailedException {
        if (random.nextInt(5) == 0) {
            throw new EmailSendingFailedException(email);
        }
    }
}
