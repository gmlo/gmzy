package top.gmzy.education.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import top.gmzy.education.entity.Teacher;
import top.gmzy.education.query.TeacherQuery;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author gmlo
 * @since 2019-08-02
 */
public interface TeacherService extends IService<Teacher> {

    /**
     * 分页条件查询
     * @param pageParam 分页
     * @param teacherQuery 条件
     */
    void pageQuery(Page<Teacher> pageParam, TeacherQuery teacherQuery);
}
