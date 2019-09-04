package top.gmzy.education.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.gmzy.education.entity.Subject;
import top.gmzy.education.vo.SubjectNestedVo;
import top.gmzy.education.vo.SubjectVo2;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author gmlo
 * @since 2019-08-02
 */
public interface SubjectService extends IService<Subject> {

    /**
     * 批量导入课程分类
     * @param file
     * @return
     * @throws Exception
     */
    List<String> batchImport(MultipartFile file) throws Exception;

    /**
     * 获取课程嵌套分类
     * @return
     */
    List<SubjectNestedVo> nestedList();

    /**
     * 获取课程嵌套分类2
     * @return
     */
    List<SubjectVo2> nestedList2();
}
