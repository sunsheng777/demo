package com.sunsheng.modules.quartz;//package com.sunsheng.modules.quartz;
//
//import org.quartz.*;
//import org.quartz.impl.StdSchedulerFactory;
//
//public class TestScheduler {
//    public static void main(String[] args) throws Exception {
//        //1.调度器（Scheduler） ，从工厂中获取实例
//        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
//        //2.任务实例（JobDetail）
//        JobDetail jobDetail = JobBuilder.newJob(TestJob.class)//加载任务栏，与TestJob绑定
//                .withIdentity("job1", "group1")//任务唯一实例，任务组名称
//                .usingJobData("count",0)
//                .build();
//        //3.触发器（Trigger）
//        Trigger trigger = TriggerBuilder.newTrigger()
//                .withIdentity("trigger1", "group1")//触发器名称，触发器组名称
//                .startNow()
//                .withSchedule(
//                        SimpleScheduleBuilder
//                                .simpleSchedule()
//                                .repeatSecondlyForever(1)
//                ).build();
//        scheduler.scheduleJob(jobDetail,trigger);
//        scheduler.start();
//    }
//}
