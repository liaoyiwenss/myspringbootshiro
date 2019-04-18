package net.wanho.task;

public class HelloTask {

    //只能调一个service，一个service只有一个事务
    public void sayHello(){
        System.out.println("hello quartz");
    }
}
