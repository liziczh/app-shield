package com.liziczh.archetype.service.service.impl;

import java.io.File;
import java.util.Date;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.liziczh.archetype.api.service.MailService;

import lombok.extern.slf4j.Slf4j;

/**
 * 邮件服务
 * @author zhehao.chen
 */
@Slf4j
@Component
public class MailServiceImpl implements MailService {
	@Value("${spring.mail.username}")
	private String from;
	@Autowired
	private JavaMailSender mailSender;

	@Override
	public void sendTextMail(String subject, String content, String[] to, String[] cc, String[] bcc) {
		try {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom(from);
			message.setTo(to);
			message.setSubject(subject);
			message.setText(content);
			message.setCc(cc);
			message.setBcc(bcc);
			message.setSentDate(new Date());
			mailSender.send(message);
		} catch (Exception e) {
			log.error("邮件发送失败：{}", e.getMessage());
		}
	}
	@Override
	public void sendHTMLMail(String subject, String content, String[] to, String[] cc, String[] bcc) {
		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setFrom(from);
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(content);
			helper.setCc(cc);
			helper.setBcc(bcc);
			helper.setSentDate(new Date());
			mailSender.send(message);
		} catch (Exception e) {
			log.error("邮件发送失败：{}", e.getMessage());
		}
	}
	@Override
	public void sendMimeMail(String subject, String content, String[] to, String[] cc, String[] bcc, Map<String, String> image, Map<String, String> attachment) {
		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setFrom(from);
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(content);
			helper.setCc(cc);
			helper.setBcc(bcc);
			helper.setSentDate(new Date());
			// 添加行内图片
			for (Map.Entry<String, String> entry : image.entrySet()) {
				helper.addInline(entry.getKey(), new File(entry.getValue()));
			}
			// 添加附件
			for (Map.Entry<String, String> entry : attachment.entrySet()) {
				helper.addAttachment(entry.getKey(), new File(entry.getValue()));
			}
			mailSender.send(message);
		} catch (Exception e) {
			log.error("邮件发送失败：{}", e.getMessage());
		}
	}
}
