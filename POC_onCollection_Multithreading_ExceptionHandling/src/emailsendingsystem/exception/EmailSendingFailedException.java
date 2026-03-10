package emailsendingsystem.exception;

public class EmailSendingFailedException extends RuntimeException{
    public EmailSendingFailedException(String msg)
    {
        super(msg);
    }
}
