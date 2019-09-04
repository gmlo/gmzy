package top.gmzy.aliyunoss.controller;

import top.gmzy.aliyunoss.service.FileService;
import top.gmzy.aliyunoss.util.ConstantPropertiesUtil;
import top.gmzy.common.vo.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author wgm
 * @since 2019/6/28
 */
@Api(description = "阿里云文件管理")
@CrossOrigin
@RestController
@RequestMapping("/admin/oss/file")
public class FileController {

	@Autowired
	private FileService fileService;

	@ApiOperation(value = "文件上传")
	@PostMapping("upload")
	public R uploadFile(
			@ApiParam(name = "file", value = "文件", required = true)
			@RequestParam("file") MultipartFile file,

			@ApiParam(name="host", value="文件上传路径", required = false)
			@RequestParam(value = "host", required = false) String host){

		if(!StringUtils.isEmpty(host)){
			ConstantPropertiesUtil.FILE_HOST = host;
		}

		String uploadUrl = fileService.uploadFile(file);

		return R.ok().message("文件上传成功").data("url", uploadUrl);
	}
}
