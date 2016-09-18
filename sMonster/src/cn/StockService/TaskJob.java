package cn.StockService;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component("taskJob")  
public class TaskJob {  
    @Scheduled(cron = "*/5 * * * * ?")  
    public void job1() {  
        System.out.println("任务进行中。。。");  
    }  
}  
