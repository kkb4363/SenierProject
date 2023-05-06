package com.batch.batch.batch.order;

import com.batch.batch.tools.DateTools;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
@EnableScheduling
public class BatchScheduler {

    private final JobLauncher jobLauncher;
    private final Job job;
    private final DataSource dataSource;

    public BatchScheduler(JobLauncher jobLauncher, Job job, @Qualifier("dataDataSource") DataSource dataSource) {
        this.jobLauncher = jobLauncher;
        this.job = job;
        this.dataSource = dataSource;
    }

    // Docker image(openjdk:17) 기준 한국이 9시간 느림
    @Scheduled(cron = "0 30 1 * * ?")
    public void runOrderJob() throws Exception {
        String day = DateTools.getToday();
        String date = DateTools.getDate();
        boolean off = isOffDay(date);
        if (!day.equals("SATURDAY") && !day.equals("SUNDAY") && !off) {
        //if (!off) {
            JobParameters jobParameters = new JobParametersBuilder()
                    .addString("date", date)
                    //.addString("today", "friday")
                    //.addString("time", String.valueOf(System.currentTimeMillis()))
                    .addString("today", day.toLowerCase())
                    .toJobParameters();
            jobLauncher.run(job, jobParameters);
        }
    }

    private boolean isOffDay(String date) throws SQLException {
        String offQuery = "select exists(select * from store_state where date = ? and off = true)";
        try (Connection connection = dataSource.getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(offQuery)) {
                statement.setString(1, date);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) return resultSet.getBoolean(1);
                }
            }
        }
        return false;
    }
}
