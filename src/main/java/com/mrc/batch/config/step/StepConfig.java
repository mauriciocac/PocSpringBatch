package com.mrc.batch.config.step;

import java.util.Arrays;
import java.util.List;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.function.FunctionItemProcessor;
import org.springframework.batch.item.support.IteratorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StepConfig {
	@Autowired
	private StepBuilderFactory factory;

	@Bean
	public Step step() {
		return factory.get("step Configurado").<Integer, String>chunk(2).reader(itemReader()).processor(itemProcessor())
				.writer(itemWriter()).build();
	}

	private IteratorItemReader<? extends Integer> itemReader() {
		List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);
		return new IteratorItemReader<>(numeros.iterator());
	}

	private FunctionItemProcessor<? super Integer, ? extends String> itemProcessor() {
		return new FunctionItemProcessor<Integer, String>(item -> item % 2 == 0 ? item + " é Par" : item + " é Impar");
	}

	private ItemWriter<? super String> itemWriter() {
		return item -> item.forEach(System.out::println);
	}
}
