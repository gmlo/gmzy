package top.gmzy.aliyunoss.service.impl;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.CannedAccessControlList;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import top.gmzy.aliyunoss.service.FileService;
import top.gmzy.aliyunoss.util.ConstantPropertiesUtil;
import top.gmzy.common.constants.ResultCodeEnum;
import top.gmzy.common.exception.GmzyException;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * @author wgm
 * @since 2019/6/28
 */
@Service
@Slf4j
public class FileServiceImpl implements FileService {
	
	@Override
	public String uploadFile(MultipartFile file) {

		String endPoint = ConstantPropertiesUtil.END_POINT;
		String accessKeyId = ConstantPropertiesUtil.ACCESS_KEY_ID;
		String accessKeySecret = ConstantPropertiesUtil.ACCESS_KEY_SECRET;
		String bucketName = ConstantPropertiesUtil.BUCKET_NAME;
		String fileHost = ConstantPropertiesUtil.FILE_HOST;

		String uploadUrl = null;

		try {

			// 创建OSSClient实例。
			OSSClient ossClient = new OSSClient(endPoint, accessKeyId, accessKeySecret);
			if(!ossClient.doesBucketExist(bucketName)){
				ossClient.createBucket(bucketName);
				ossClient.setBucketAcl(bucketName, CannedAccessControlList.PublicRead);
			}

			//获取上传文件流
			InputStream inputStream = file.getInputStream();

			//获取原始文件名
			String original = file.getOriginalFilename();
			String fileName = UUID.randomUUID().toString();
			String fileType = original.substring(original.lastIndexOf("."));
			//组装新的文件名
			String newName = fileName + fileType;

			//创建文件上传目录
			String filePath = new DateTime().toString("yyyy/MM/dd");

			//文件上传至服务器的具体位置
			String fileUrl = fileHost + "/" + filePath + "/" + newName;


			// 上传文件流。
			ossClient.putObject(bucketName, fileUrl, inputStream);

			// 关闭OSSClient。
			ossClient.shutdown();

			//组装文件最终的url地址
			uploadUrl = "https://" + bucketName + "." + endPoint + "/" + fileUrl;

		} catch (IOException e) {
			log.error(e.getMessage());;
			throw new GmzyException(ResultCodeEnum.FILE_UPLOAD_ERROR);
		} catch (Exception e) {
			log.info("上传错误============================");
			log.error(e.getMessage());
			throw new GmzyException(ResultCodeEnum.UNKNOWN_REASON);
		}
		return uploadUrl;
	}
}
