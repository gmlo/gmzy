package top.gmzy.statistics.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.gmzy.common.vo.R;
import top.gmzy.statistics.service.DailyService;

@CrossOrigin
@RestController
@RequestMapping("/admin/statistics/daily")
public class DailyAdminController {

    @Autowired
    private DailyService dailyService;

    @GetMapping("{day}")
    public R createStatisticsByDate(@PathVariable String day) {
        dailyService.createStatisticsByDay(day);
        return R.ok();
    }
}