import org.apache.commons.mail.*;
public class EmailSender {

    private String sender;
    private String reciever;
    private String password;
    private String hostName;
    private int mailProtocolPort;
    private boolean enableTransportSecurity;

    public EmailSender(String sender, String password, String reciever,  String hostName, int mailProtocolPort, boolean enableTransportSecurity) {        
        this.sender = sender;
        this.password = password;
        this.receiver = receiver;
        this.hostName = hostName;
        this.mailProtocolPort = mailProtocolPort;
        this.enableTransportSecurity = enableTransportSecurity;
    }
    
    public void send(String title, String content) {
        String linkToAtt = "http://met.live.mediaspanonline.com/assets/31069/example-608web_w608.jpg";
        EmailAttachment att = new EmailAttachment();
        att.setName("Example");
        att.setPath(linkToAtt);
        att.setDisposition(EmailAttachment.ATTACHMENT);
        
        Email email = new MultiPartEmail();
        email.setAuthenticator(new DefaultAuthenticator(sender, password));
        email.setSmtpPort(mailProtocolPort);
        email.setStartTLSEnabled(enableTransportSecurity);
        email.setHostName(hostName);
        email.setSSLOnConnect(true);
        
        try {
            email.setFrom(sender);
            email.setSubject(title);
            email.setMsg(content);
            email.addTo(reciever);
            email.send();
        } catch (EmailException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        EmailSender sender = new EmailSender("exampleSender@abv.bg","examplePassword",  "exampleReceived@abv.bg", "exampleHostname.abv.bg", 465, true);
        String title = "Example title";
        String content = "Example content";
        sender.send(title, content);
    }
    
}