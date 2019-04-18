package net.wanho.exceptionResolver;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GlobalExceptionResolver implements HandlerExceptionResolver {


//    private static final Logger logger = Logger.getLogger(GlobalExceptionResolver.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                         Object handler, Exception e) {

//        logger.info("进入全局异常处理器.....");
//        logger.debug("测试handler的类型"+handler.getClass());
        e.printStackTrace();
//        logger.error("系统发生异常,e");
        ModelAndView modelAndView =new ModelAndView();
        modelAndView.addObject("message","您的电脑有问题，请稍后再试！！");
        modelAndView.setViewName("error/exception");
        return modelAndView;
    }
}
