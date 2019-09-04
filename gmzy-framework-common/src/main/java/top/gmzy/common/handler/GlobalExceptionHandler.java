package top.gmzy.common.handler;

import top.gmzy.common.constants.ResultCodeEnum;
import top.gmzy.common.exception.GmzyException;
import top.gmzy.common.util.ExceptionUtil;
import top.gmzy.common.vo.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.json.JsonParseException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import top.gmzy.common.constants.ResultCodeEnum;
import top.gmzy.common.vo.R;

/**
 * 统一异常处理器
 * @Author wgm
 * @Create 2019-08-03 22:35:55
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 异常处理方法
     * @param e
     * @return
     */
    @ExceptionHandler
    @ResponseBody
    public R error(Exception e) {
        //e.printStackTrace();  //控制台输出异常堆栈信息
        log.error(e.getMessage());//日志打印异常信息
        return R.error();
    }

    @ExceptionHandler(BadSqlGrammarException.class)
    @ResponseBody
    public R error(BadSqlGrammarException e){
        log.error(e.getMessage());
        return R.setResult(ResultCodeEnum.BAD_SQL_GRAMMAR);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public R error(JsonParseException e){
        log.error(e.getMessage());
        return R.setResult(ResultCodeEnum.JSON_PARSE_ERROR);
    }

    /**
     * 自定义异常处理
     * @param e
     * @return
     @ExceptionHandler(GmzyException.class)
     @ResponseBody
     */
    public R error(GmzyException e){
        //log.error(e.getMessage());
        log.error(ExceptionUtil.getMessage(e));
        return R.error()
                .code(e.getCode())
                .message(e.getMessage());
    }
}
