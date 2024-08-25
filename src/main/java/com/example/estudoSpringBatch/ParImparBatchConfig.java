package com.example.estudoSpringBatch;

import java.util.Arrays;
import java.util.List;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.function.FunctionItemProcessor;
import org.springframework.batch.item.support.IteratorItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class ParImparBatchConfig {
/*
    private final JobRepository jobRepository;
    private final PlatformTransactionManager transactionManager;

    public ParImparBatchConfig(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        this.jobRepository = jobRepository;
        this.transactionManager = transactionManager;
    }

    @Bean
    Job imprimeParImparJob(Step imprimeParImparStep) {
    	return new JobBuilder("imprimeParImparJob", jobRepository)
    			.start(imprimeParImparStep)
    			.incrementer(new RunIdIncrementer())
    			.build();
    }
	
    @Bean
    Step imprimeParImparStep() {
        return new StepBuilder("imprimeParImparStep", jobRepository)
                .<Integer, String>chunk(1, transactionManager)
                .reader(contaAteDecReader())
                .processor(parOuImparProcessor())
                .writer(imprimeWriter())
                .build();
    }
    
	public IteratorItemReader<Integer> contaAteDecReader() {
		List<Integer> numerosDeUmAteDez = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		return new IteratorItemReader<>(numerosDeUmAteDez);
    }
	
	public FunctionItemProcessor<Integer, String> parOuImparProcessor() {
		return new FunctionItemProcessor<Integer, String>
			(item -> item % 2 == 0 
				? String.format("Item %s é Par !", item)
				: String.format("Item %s é Ímpar !", item));
	}
	
	public ItemWriter<String> imprimeWriter() {
		return itens -> itens.forEach(System.out::println);
	}
	*/
}
