package cn.tedu.ems.test;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;

//@Component
public class MessageSendTask {
	
	Logger logger = LogManager.getLogger(MessageSendTask.class);
	
	@Scheduled(cron="0/10 * * * * ? ")
	public void send() {
		logger.info("发送！！！");
	}
}
