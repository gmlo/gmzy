package top.gmzy.education.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.gmzy.education.entity.Course;
import top.gmzy.education.mapper.CourseMapper;
import top.gmzy.education.service.CourseService;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author gmlo
 * @since 2019-08-02
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {

}
