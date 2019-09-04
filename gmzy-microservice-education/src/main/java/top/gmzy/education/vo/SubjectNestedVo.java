package top.gmzy.education.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author helen
 * @since 2019/6/29
 */
@Data
public class SubjectNestedVo {

	private String id;
	private String title;
	private List<SubjectVo> children = new ArrayList<>();
}
