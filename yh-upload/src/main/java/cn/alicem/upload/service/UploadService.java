package cn.alicem.upload.service;

import cn.alicem.upload.config.UploadProperties;
import cn.yuehai.common.enums.ExceptionEnum;
import cn.yuehai.common.exception.YhException;
import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.apache.commons.io.FilenameUtils.getExtension;

/**
 * @ClassName UploadService
 * @Description TODO
 * @Author LiHongBin
 * @Date 2020\7\15 0015 16:29
 * @Version 1.0
 **/
@Service
@Slf4j
@EnableConfigurationProperties(UploadProperties.class)
public class UploadService {

    @Autowired
    private UploadProperties prop;

    @Autowired
    private FastFileStorageClient storageClient;

//    private static final List<String> SUFFIXS = Arrays.asList("image/png", "image/jpeg");

    public String uploadImage(MultipartFile file) {
        try {
            //第一步校验文件是否是许可文件
            String contentType = file.getContentType();
            if (!prop.getAllowTypes().contains(contentType)){
                log.info("这个类型我的服务器不识别");
                throw new YhException(ExceptionEnum.INVALID_FILE_TYPE);
//                throw new YhException(ExceptionEnum.INVALID_FILE_TYPE);
            }

            //第二部分校验文件的内容
            BufferedImage bufferedImage = ImageIO.read(file.getInputStream());
            if (bufferedImage==null){
                log.info("文件内容有误");
                throw new YhException(ExceptionEnum.INVALID_FILE_TYPE);
            }

            //上传到FDFS

            // 2、将图片上传到FastDFS
            // 2.1、获取文件后缀名
            String extension = StringUtils.substringAfterLast(file.getOriginalFilename(), ".");
            // 2.2、上传
            StorePath storePath = this.storageClient.uploadFile(
                    file.getInputStream(), file.getSize(), extension, null);
            // 2.3、返回完整路径
            return prop.getBaseUrl()+ storePath.getFullPath();


            //准备目标路径
            /*File dist = new File("F:\\IDEA\\Project\\yuehai\\upload\\"
                ,file.getOriginalFilename());
            //保存文件到本地
            file.transferTo(dist);*/

            //返回路径
//            return "http://image.leyou.com/"+file.getOriginalFilename();
        } catch (IOException e) {
//            e.printStackTrace();
            log.error("上传文件失败",e);
            throw new YhException(ExceptionEnum.UPLOAD_ERROR);
        }



    }
}
