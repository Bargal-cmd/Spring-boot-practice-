package com.pratice.service;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class CronPratice {
@ Scheduled(cron = "9 * * * * *")
	public void Test()
	{
		System.out.println("Running ....."+new Date());
	}
}
