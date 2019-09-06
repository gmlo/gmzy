package top.gmzy.ucenter.controller.admin;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.gmzy.common.vo.R;
import top.gmzy.ucenter.service.MemberService;

@CrossOrigin
@RestController
@RequestMapping("/admin/ucenter/member")
public class MemberAdminController {

	@Autowired
	private MemberService memberService;

	@ApiOperation(value = "今日注册数")
	@GetMapping(value = "count-register/{day}")
	public R registerCount(
			@ApiParam(name = "day", value = "统计日期")
			@PathVariable String day){
		Integer count = memberService.countRegisterByDay(day);
		return R.ok().data("countRegister", count);
	}
}