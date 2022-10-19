package com.hseea;

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
