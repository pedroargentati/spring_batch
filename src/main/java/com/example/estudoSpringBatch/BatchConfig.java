package com.example.estudoSpringBatch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BatchConfig {
	private final JobRepository jobRepository;

	public BatchConfig(JobRepository jobRepository) {
		this.jobRepository = jobRepository;
	}
	
	@Bean
	Job arquivoDelimitadoJob(Step leituraArquivoDelimitadoStep) {
		return new JobBuilder("arquivoDelimitadoJob", jobRepository)
				.start(leituraArquivoDelimitadoStep)
				.incrementer(new RunIdIncrementer())
				.build();
	}
}
