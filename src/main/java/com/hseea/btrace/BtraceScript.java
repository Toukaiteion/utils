package com.hseea.btrace;

import com.sun.btrace.AnyType;
import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.*;

@BTrace
public class BtraceScript {

//    @OnMethod(
//            clazz = "com.sitech.cmap.factory.clusterManager.ClusterManageImplFactory",
//            location = @Location(value = Kind.LINE, line = 341)
//    )
//    public static void func(@ProbeClassName String pcn, @ProbeMethodName String pmn, int line){
//        BTraceUtils.println(pcn + "   "+ pmn + "   "+line);
//        BTraceUtils.println();
//    }
    /*
    * 打印方法的执行时间
    * */
    @OnMethod(clazz = "com.hseea.package", method = "myMethod", location = @Location(Kind.RETURN))
    public static void printMethodRunTime(@ProbeClassName String probeClassName, @Duration long duration){
        BTraceUtils.println(probeClassName + ", duration:" + duration/1000000 + " ms");
    }

    /*
    * 统计执行时间超过100ms的方法
    * */
    @OnMethod(clazz = "/com\\.hseea\\.package\\.controller\\..*/", method = "/.*/", location = @Location(Kind.RETURN))
    public static void printMethodRunTimeOver(@ProbeClassName String probeClassName,@ProbeMethodName String proMethod,
                                              @Duration long duration){
        if (duration > 1000000*100){
            BTraceUtils.println(probeClassName+":"+ proMethod + ", duration:" + duration/1000000 + " ms");
        }

    }

    /*
    * 查询哪些方法调用了system.gc，并打印调用栈
    * */
    @OnMethod(clazz = "java.lang.System", method = "gc")
    public static void onGc(){
        BTraceUtils.println("entered System.gc()");
        BTraceUtils.jstack();
    }

    /*
    * 打印某个方法的入参和返回
    * */
    @OnMethod(clazz = "com.hseea.pack", method = "myMethod", location = @Location(Kind.RETURN))
    public static void printParamAndReturn(@Self Object self, String type, Integer limit, @Return AnyType result){
        BTraceUtils.println("type:"+type+", limit:"+limit);
        BTraceUtils.println("result:"+result);
    }


    @OnMethod(
            clazz = "com.sitech.cmap.factory.clusterManager.ClusterManageImplFactory",
            method = "getClusters", location = @Location(Kind.ENTRY)
    )
    public static void byMethod(@ProbeClassName String pcn, @ProbeMethodName String pmn, AnyType[] anyTypes, @Return Object o){
        BTraceUtils.println(pcn + "   "+ pmn + "   ");
        BTraceUtils.println(anyTypes);
        BTraceUtils.println(o);
        BTraceUtils.println();
    }
}
