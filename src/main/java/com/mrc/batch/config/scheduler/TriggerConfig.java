package com.mrc.batch.config.scheduler;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mrc.batch.util.Util;

@Configuration
public class TriggerConfig {
	@Bean
	public Trigger primeiroHorario() {
		String min = Util.getMin().toString();
		String hour = Util.getHour().toString();
		System.out.println("PRIMEIRO HORARIO EXECUTADO " + hour + ":" + min);

		CronScheduleBuilder schedule = CronScheduleBuilder
				.cronSchedule("00 30 12 1/1 * ? *".replace("30", min).replace("12", hour));
		return TriggerBuilder.newTrigger().forJob(jobDetail()).withSchedule(schedule).build();
	}

	@Bean
	public JobDetail jobDetail() {
		return JobBuilder.newJob(GerarArquivoXmlQuartzJob.class).storeDurably().build();
	}
}
