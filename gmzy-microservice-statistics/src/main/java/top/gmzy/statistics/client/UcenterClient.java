package top.gmzy.statistics.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import top.gmzy.common.vo.R;

@Component
@FeignClient("gmzy-ucenter")
public interface UcenterClient {

    /**
     * 一定要写成 @PathVariable("day")，圆括号中的"day"不能少
     * @param day
     * @return
     */
    @GetMapping(value = "/admin/ucenter/member/count-register/{day}")
    public R registerCount(@PathVariable("day") String day);

}
