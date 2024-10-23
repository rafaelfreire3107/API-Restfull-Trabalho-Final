package br.com.serratec.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Configuration
public class MailConfig {
		
	@Autowired
	private JavaMailSender javaMailSender;
	
	public void sendEmail(String para, String assunto, String texto) {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setFrom("delmir.silva@aluno.senai.br");
		mail.setTo(para);
		mail.setSubject(assunto);
		mail.setText("Dados de cadastro do cliente:\n" + texto 
				+ "\n\n\nTurma 20 - Serratec-2024" + "\n\nGrupo 2 - Delmir Augusto, Denilson Santos, Larissa Teodoro, Luis Caetano, Rafael Freire");
		javaMailSender.send(mail);
	}
}
