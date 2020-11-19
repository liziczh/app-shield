package com.liziczh.archetype.api.service;

import java.util.Map;

public interface MailService {
	/**
	 * 发送文本邮件
	 * @param subject 主题
	 * @param content 内容
	 * @param to 收件人
	 * @param cc 抄送
	 * @param bcc 密送
	 */
	void sendTextMail(String subject, String content, String[] to, String[] cc, String[] bcc);
	/**
	 * 发送HTML邮件
	 * @param subject 主题
	 * @param content 内容
	 * @param to 收件人
	 * @param cc 抄送
	 * @param bcc 密送
	 */
	void sendHTMLMail(String subject, String content, String[] to, String[] cc, String[] bcc);
	/**
	 * 发送MIME邮件
	 * @param subject 主题
	 * @param content 内容
	 * @param to 收件人
	 * @param cc 抄送
	 * @param bcc 密送
	 * @param image 图片
	 * @param attachment 附件
	 */
	void sendMimeMail(String subject, String content, String[] to, String[] cc, String[] bcc, Map<String, String> image, Map<String, String> attachment);
}
