package com.mrc.batch.config.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing
@Configuration
public class JobConfig {
	@Autowired
	private JobBuilderFactory jobFactory;

	@Bean
	public Job job(Step step) {
		System.out.println("JOB CONFIGURADO");
		return jobFactory.get("Job Configurado").start(step).incrementer(new RunIdIncrementer()).build();
	}

}
