package top.gmzy.aliyunoss.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author wgm
 * @since 2019/6/28
 */
public interface FileService {

	/**
	 * 上传文件
	 * @param file 文件
	 * @return URL 地址
	 */
	String uploadFile(MultipartFile file);
}
