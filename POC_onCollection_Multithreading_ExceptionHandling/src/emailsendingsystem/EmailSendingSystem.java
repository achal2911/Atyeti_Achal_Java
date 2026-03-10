package emailsendingsystem;

import emailsendingsystem.service.EmailManager;

public class EmailSendingSystem
{
    public static void main(String[] args)
    {
        EmailManager manager=new EmailManager();
        manager.startSystem();

    }
}
