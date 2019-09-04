package top.gmzy.education.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.gmzy.education.entity.Video;
import top.gmzy.education.mapper.VideoMapper;
import top.gmzy.education.service.VideoService;

/**
 * <p>
 * 课程视频 服务实现类
 * </p>
 *
 * @author gmlo
 * @since 2019-08-02
 */
@Service
public class VideoServiceImpl extends ServiceImpl<VideoMapper, Video> implements VideoService {

}
