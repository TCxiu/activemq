package com.xiu.mq.task;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.xiu.mq.model.TransactionMessage;
import com.xiu.mq.service.impl.TransactionMessageServiceImpl;
import com.xiu.mq.utils.UUIDUtils;

@Component
public class TransactionMessageTask {
	@Autowired
	private TransactionMessageServiceImpl messageService;
    /**
     *  Seconds (秒)         ：可以用数字0－59 表示，
     *  Minutes(分)          ：可以用数字0－59 表示，
     *  Hours(时)             ：可以用数字0-23表示,
     *  Day-of-Month(天) ：可以用数字1-31 中的任一一个值，但要注意一些特别的月份
     *  Month(月)            ：可以用0-11 或用字符串  “JAN, FEB, MAR, APR, MAY, JUN, JUL, AUG, SEP, OCT, NOV and DEC” 表示
     *  Day-of-Week(每周)：可以用数字1-7表示（1 ＝ 星期日）或用字符口串“SUN, MON, TUE, WED, THU, FRI and SAT”表示
     *  “/”：为特别单位，表示为“每”如“0/15”表示每隔15分钟执行一次,“0”表示为从“0”分开始, “3/20”表示表示每隔20分钟执行一次，“3”表示从第3分钟开始执行
     *  “?”：表示每月的某一天，或第周的某一天
     *  “L”：用于每月，或每周，表示为每月的最后一天，或每个月的最后星期几如“6L”表示“每月的最后一个星期五”
     *  “W”：表示为最近工作日，如“15W”放在每月（day-of-month）字段上表示为“到本月15日最近的工作日”
     *  “#”：是用来指定“的”每月第n个工作日,例 在每周（day-of-week）这个字段中内容为"6#3" or "FRI#3" 则表示“每月第三个星期五”
     */
    @Scheduled(cron = "5/1 * * * * ?")
    public void cronJob() {
    	TransactionMessage transactionMessage = new TransactionMessage();
    	transactionMessage.setId(UUIDUtils.getUUID());
    	transactionMessage.setVersion(1);
    	transactionMessage.setCreater("Tc李"+Thread.currentThread().getId());
    	transactionMessage.setCreateTime(new Date());
    	transactionMessage.setEditor("Tc李"+Thread.currentThread().getId());
    	transactionMessage.setEditTime(new Date());
    	transactionMessage.setMeaasgeId(UUIDUtils.getUUID());
    	transactionMessage.setMessageBody(Thread.currentThread().getName()+"测试");
    	transactionMessage.setMessageDateType("string");
    	transactionMessage.setConsumerQueue("test");
    	transactionMessage.setMessageSendTimes(new Date());
    	transactionMessage.setAreadlyDead(false);
    	transactionMessage.setStatus("未发送");
    	transactionMessage.setRemark("备注");
    	transactionMessage.setField1("扩展字段一");
    	transactionMessage.setField2("扩展字段三");
    	transactionMessage.setField3("扩展字段四");
        messageService.save("transactionMessageRecord", transactionMessage);
    }
}
