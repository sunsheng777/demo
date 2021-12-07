package com.sunsheng.modules.quartz;//package com.sunsheng.modules.quartz;
//
//import org.quartz.Job;
//import org.quartz.JobExecutionContext;
//import org.quartz.JobExecutionException;
//import org.quartz.PersistJobDataAfterExecution;
//
//@PersistJobDataAfterExecution
//public class TestJob  implements Job {
//    private Integer count;
//
//    public void setCount(Integer count) {
//        this.count = count;
//    }
//
//    @Override
//    public void execute(JobExecutionContext context) throws JobExecutionException {
//        ++count;
//        System.out.println("计数器"+count);
//        context.getJobDetail().getJobDataMap().put("count",count);
////        System.out.println(new Date());
//        System.out.println("------------------");
//    }
//}
