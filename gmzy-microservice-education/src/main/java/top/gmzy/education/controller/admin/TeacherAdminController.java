package top.gmzy.education.controller.admin;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import top.gmzy.common.constants.ResultCodeEnum;
import top.gmzy.common.exception.GmzyException;
import top.gmzy.common.vo.R;
import top.gmzy.education.entity.Teacher;
import top.gmzy.education.query.TeacherQuery;
import top.gmzy.education.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师管理
 * </p>
 *
 * @author gmlo
 * @since 2019-08-02
 */
@Api(value = "讲师管理")
@CrossOrigin
@RestController
@RequestMapping("/admin/edu/teacher")
public class TeacherAdminController {

    @Autowired
    private TeacherService teacherService;

    @ApiOperation(value = "所有讲师列表")
    @GetMapping
    public R list(){
        List<Teacher> teacherList = teacherService.list(null);
        return R.ok()
                .message("查询讲师列表成功")
                .data("teacherList", teacherList);
    }

    @ApiOperation(value = "根据ID删除讲师")
    @DeleteMapping("{id}")
    public R removeById(
            @ApiParam(name = "id", value = "讲师ID", required = true)
            @PathVariable String id){
        boolean remove = teacherService.removeById(id);
        return remove
                ? R.ok().message("删除讲师成功")
                : R.error().message("删除讲师失败");
    }

    @ApiOperation(value = "分页条件查询讲师列表")
    @GetMapping("{page}/{limit}")
    public R pageQuery(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,
            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit,
            @ApiParam(name = "teacherQuery", value = "查询对象", required = false)
                    TeacherQuery teacherQuery){

        if(page <= 0 || limit <= 0){
            //throw new GmloException(21003, "参数不正确1");
            throw new GmzyException(ResultCodeEnum.PARAM_ERROR);
        }

        Page<Teacher> pageParam = new Page<>(page, limit);
        teacherService.pageQuery(pageParam, teacherQuery);
        List<Teacher> records = pageParam.getRecords();
        long total = pageParam.getTotal();

        return  R.ok().message("查询成功")
                .data("total", total).data("rows", records);
    }

    @ApiOperation(value = "新增讲师")
    @PostMapping
    public R save(
            @ApiParam(name = "teacher", value = "讲师对象", required = true)
            @RequestBody Teacher teacher){
        boolean save = teacherService.save(teacher);
        return save ? R.ok().message("新增成功")
                    : R.error().message("新增失败");
    }

    @ApiOperation(value = "根据ID查询讲师")
    @GetMapping("{id}")
    public R getById(
            @ApiParam(name = "id", value = "讲师ID", required = true)
            @PathVariable String id){

        Teacher teacher = teacherService.getById(id);
        return R.ok().message("查询成功")
                .data("item", teacher);
    }

    @ApiOperation(value = "根据ID修改讲师")
    @PutMapping("{id}")
    public R updateById(
            @ApiParam(name = "id", value = "讲师ID", required = true)
            @PathVariable String id,
            @ApiParam(name = "teacher", value = "讲师对象", required = true)
            @RequestBody Teacher teacher){

        teacher.setId(id);
        boolean update = teacherService.updateById(teacher);
        return update ? R.ok().message("修改成功")
                : R.error().message("修改失败");
    }


}