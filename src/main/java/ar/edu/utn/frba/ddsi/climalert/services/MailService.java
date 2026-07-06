package ar.edu.utn.frba.ddsi.climalert.services;

import ar.edu.utn.frba.ddsi.climalert.domain.WeatherInfo;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {
    private final JavaMailSender mailSender;
    private static final String[] DESTINATARIOS = {
            "admin@clima.com",
            "emergencias@clima.com",
            "meteorologia@clima.com"
    };

    public MailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendAlert(WeatherInfo w) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(DESTINATARIOS);
        message.setSubject("Alerta climática - " + w.getName());
        message.setText(
                "Se detectaron condiciones climáticas críticas.\n\n" +
                        "Ubicación: " + w.getName() + "\n" +
                        "Temperatura: " + w.getTemp() + "°C\n" +
                        "Humedad: " + w.getHumidity() + "%\n" +
                        "Fecha: " + w.getDate()
        );
        mailSender.send(message);
    }
}
