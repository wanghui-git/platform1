package com.leesin.activitydemo.Api;

public interface MailService {

    /**
     * 发送普通文本邮件
     * @param to 收件人
     * @param subject 主题
     * @param content 内容
     */
    void SendMail(String to, String subject, String content);

    /**
     *  网页版邮件
     * @param to 收件人
     * @param subject 主题
     * @param content 内容（可以包含<html>等标签）
     */
    void sendHtmlMail(String to, String subject, String content);

    /**
     * 带附件文本格式邮件
     * @param to 收件人
     * @param subject 主题
     * @param content 内容
     * @param filePath 附件路径
     */
    void sendAttachmentsMail(String to, String subject, String content, String filePath);

    /**
     * 发送带图片的邮件
     * @param to 收件人
     * @param subject 主题
     * @param content 文本
     * @param rscPath 图片路径
     * @param rscId 图片ID，用于在<img>标签中使用，从而显示图片
     */
    void sendInlineResourceMail(String to, String subject, String content, String rscPath, String rscId);


}
