package com.alfred.aspect;

import com.alfred.sys.domain.Billtype;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Alfred
 * @date 2020/3/14 14:07
 */
@Aspect
@Component
@EnableAspectJAutoProxy//切面注解
public class BillTypeCacheAspect {

    /**
     * 缓存对象
     */
    private Map<String,Object> cache = new HashMap<>();

    /**
    * 缓存前缀
     *
    * */
    private static final String BILL_TYPE_CACHE_PREFIX = "billtype:";

    @Pointcut("execution(* com..alfred.sys.service.impl.BilltypeServiceImpl.getById(..))")
    public void pc(){

    }

    @Around(value = "pc()")
    public Object cacheBilType(ProceedingJoinPoint point) throws Throwable {
        Object[] args = point.getArgs();//得到目标方法的参数.3
        //取出id
        Integer arg = (Integer) args[0];
        //从缓存里面取对象
        Object o = cache.get(BILL_TYPE_CACHE_PREFIX + arg);
        if (o != null) {//不为空说明缓存里面有数据
            return o;
        }else {
            //说明缓存里没有,放行执行目标方法查询数据库
            Billtype proceed = (Billtype) point.proceed();
            cache.put(BILL_TYPE_CACHE_PREFIX+proceed.getId(),proceed);
            return proceed;
        }

    }
}
