package com.mrc.batch.config.scheduler;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class GerarArquivoXmlQuartzJob extends QuartzJobBean {
	@Autowired
	private JobLauncher jobLauncher;
	@Autowired
	private Job job;
	@Autowired
	private JobExplorer jobExplorer;

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		JobParameters jobParameters = new JobParametersBuilder(jobExplorer).getNextJobParameters(job).toJobParameters();
		try {
			jobLauncher.run(job, jobParameters);
			System.out.println("");
		} catch (JobExecutionAlreadyRunningException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JobRestartException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JobInstanceAlreadyCompleteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JobParametersInvalidException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
