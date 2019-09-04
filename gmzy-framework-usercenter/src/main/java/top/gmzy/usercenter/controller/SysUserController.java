package top.gmzy.usercenter.controller;

import top.gmzy.common.vo.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import top.gmzy.usercenter.entity.Sysuser;


/**
 * @author wgm
 */
@Api(description="系统用户管理")
@CrossOrigin
@RestController
@RequestMapping("/admin/sysuser")
public class SysUserController {

	@PostMapping("login")
	@ApiOperation(value = "用户登录")
	public R login(
			@ApiParam(name = "sysuser", value = "系统用户对象", required = true)
			@RequestBody Sysuser sysuser){

		return R.ok().data("token", "admin");
	}

	@GetMapping("info")
	@ApiOperation(value = "获取用户信息")
	public R info(
			@ApiParam(name = "token", value = "令牌", required = true)
			@RequestParam String token){
		return R.ok()
				.data("roles", "admin")
				.data("name", "admin")
				.data("avatar","https://guli-file.oss-cn-beijing.aliyuncs.com/avatar/default.jpg");
	}

	@PostMapping("logout")
	@ApiOperation(value = "用户登出")
	public R logout(){
		return R.ok();
	}
}


