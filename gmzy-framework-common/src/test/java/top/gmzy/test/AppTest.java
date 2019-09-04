package top.gmzy.test;

import top.gmzy.common.constants.ResultCodeEnum;
import top.gmzy.common.exception.GmzyException;

public class AppTest {

    public static void main(String[] args) {
        throw new GmzyException(ResultCodeEnum.PARAM_ERROR);
    }
}
