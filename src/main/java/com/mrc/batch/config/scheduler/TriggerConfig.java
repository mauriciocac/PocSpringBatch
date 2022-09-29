package com.mrc.batch.config.scheduler;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TriggerConfig {
	@Bean
	public Trigger primeiroHorario() {
		System.out.println("PRIMEIRO HORARIO EXECUTADO");
		CronScheduleBuilder schedule = CronScheduleBuilder.cronSchedule("00 58 11 1/1 * ? *");
		return TriggerBuilder.newTrigger().forJob(jobDetail()).withSchedule(schedule).build();
	}

	@Bean
	public JobDetail jobDetail() {
		return JobBuilder.newJob(GerarArquivoXmlQuartzJob.class).storeDurably().build();
	}
}
