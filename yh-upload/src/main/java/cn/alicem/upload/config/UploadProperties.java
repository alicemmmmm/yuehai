package cn.alicem.upload.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * @ClassName UploadProperties
 * @Description TODO
 * @Author LiHongBin
 * @Date 2020\7\16 0016 15:32
 * @Version 1.0
 **/
@Data
@ConfigurationProperties(prefix = "yh.upload")
public class UploadProperties {
    private String baseUrl;
    private List<String> allowTypes;
}
