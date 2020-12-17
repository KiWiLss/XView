package com.kiwilss.xview.ui.click.aop;

//@Aspect
//public class SingleClickAspect {
//    private static final long DEFAULT_TIME_INTERVAL = 5000;
//
//    /**
//     * 定义切点，标记切点为所有被@SingleClick注解的方法
//     * 注意：这里me.baron.test.annotation.SingleClick需要替换成
//     * 你自己项目中SingleClick这个类的全路径哦
//     */
//    @Pointcut("execution(@me.baron.test.annotation.SingleClick * *(..))")
//    public void methodAnnotated() {}
//
//    /**
//     * 定义一个切面方法，包裹切点方法
//     */
//    @Around("methodAnnotated()")
//    public void aroundJoinPoint(ProceedingJoinPoint joinPoint) throws Throwable {
//        // 取出方法的参数
//        View view = null;
//        for (Object arg : joinPoint.getArgs()) {
//            if (arg instanceof View) {
//                view = (View) arg;
//                break;
//            }
//        }
//        if (view == null) {
//            return;
//        }
//        // 取出方法的注解
//        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
//        Method method = methodSignature.getMethod();
//        if (!method.isAnnotationPresent(SingleClick.class)) {
//            return;
//        }
//        SingleClick singleClick = method.getAnnotation(SingleClick.class);
//        // 判断是否快速点击
//        if (!XClickUtil.isFastDoubleClick(view, singleClick.value())) {
//            // 不是快速点击，执行原方法
//            joinPoint.proceed();
//        }
//    }
//}