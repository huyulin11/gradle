package com.ytgrading.annotation;

import java.lang.annotation.*;

@Target({ ElementType.PARAMETER, ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
/** 在寄生类中，除了agv方法，其它方法执行的前提就是agvId不能为空或者小于零，详细规则在AgvCheckAopAction类中定义 */
public @interface AgvChecker {
}
