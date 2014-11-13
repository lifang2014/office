package com.common.oa.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
@Lazy(false)
public class TestListener {

	
	private Logger logger = LoggerFactory.getLogger(TestListener.class);
	
	@Scheduled(cron = "${job.test_build.cron}")
	public void build(){
		logger.info("定时任务,执行中....");
	}
	
}
	