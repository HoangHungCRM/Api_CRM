package com.resdii.crm.user.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class ApplicationConfig {
    @Value("${media-server.public-url:}")
    private String mediaServerURL;

    @Value("${media-server.avatar-bucket:}")
    private String mediaAvatarBucket;

    @Value("${media-server.attachments-bucket:}")
    private String mediaAttachmentsBucket;

    @Value("${media-server.qrcode-bucket:}")
    private String mediaQrCodeBucket;

    @Value("${qr-code.profile-url:}")
    private String qrCodeProfileUrl;
}
