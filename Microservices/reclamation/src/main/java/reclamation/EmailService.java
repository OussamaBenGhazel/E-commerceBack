package reclamation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendReclamationConfirmation(String to, String description) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Confirmation de réclamation");
        message.setText("Bonjour,\n\nVotre réclamation a été envoyée avec succès.\n\nDescription : "
                + description + "\n\nCordialement,\nL'équipe support.");

        mailSender.send(message);
    }
}
