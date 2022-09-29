package com.mrc.batch.config.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StepConfig {
	@Autowired
	private StepBuilderFactory factory;

	@Bean
	public Step step() {
		return factory.get("step Configurado").tasklet(new Tasklet() {

			@Override
			public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
				System.out.println("STEP EXECUTADO");
				return RepeatStatus.FINISHED;
			}
		}).build();
	}
}
