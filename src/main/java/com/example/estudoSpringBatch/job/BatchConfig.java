package com.example.estudoSpringBatch.job;

import java.util.List;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class BatchConfig {
    private final JobRepository jobRepository;
    private final PlatformTransactionManager transactionManager;

    public BatchConfig(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        this.jobRepository = jobRepository;
        this.transactionManager = transactionManager;
    }

    @Bean
    Step imprimeOlaStep(ItemReader<String> itemReader, ItemWriter<String> itemWriter) {
        return new StepBuilder("imprimeOlaStep", jobRepository)
                .<String, String>chunk(1, transactionManager)
                .reader(itemReader)
                .writer(itemWriter)
                .build();
    }

    @Bean
    @StepScope
    ItemReader<String> itemReader(@Value("#{jobParameters['nome']}") String nome) {
        String data = String.format("Olá, %s!", nome);
        return new ListItemReader<>(List.of(data));
    }

    @Bean
    ItemWriter<String> itemWriter() {
        return items -> items.forEach(System.out::println);
    }
}
