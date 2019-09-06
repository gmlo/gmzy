package top.gmzy.common.exception;

import top.gmzy.common.constants.ResultCodeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import top.gmzy.common.constants.ResultCodeEnum;

/**
 * 自定义全局异常类
 * @author wgm
 */
@Data
@ApiModel(value = "自定义全局异常类")
public class GmzyException extends RuntimeException {

	@ApiModelProperty(value = "状态码")
	private Integer code;

	/**
	 * 接受状态码和消息
	 * @param code
	 * @param message
	 */
	public GmzyException(Integer code, String message) {
		super(message);
		this.code=code;
	}

	/**
	 * 接收枚举类型
	 * @param resultCodeEnum
	 */
	public GmzyException(ResultCodeEnum resultCodeEnum) {
		super(resultCodeEnum.getMessage());
		this.code = resultCodeEnum.getCode();
	}

	/**
	 * 重写toString()方法
	 * @return
	 */
	@Override
	public String toString() {
		return "GmzyException{" +
				"code=" + code +
				", message=" + this.getMessage() +
				'}';
	}
}