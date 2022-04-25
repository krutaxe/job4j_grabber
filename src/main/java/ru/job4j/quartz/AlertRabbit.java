package ru.job4j.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static org.quartz.JobBuilder.*;
import static org.quartz.TriggerBuilder.*;
import static org.quartz.SimpleScheduleBuilder.*;

public class AlertRabbit {
    public static void main(String[] args) {
        try (InputStream in = AlertRabbit.class.getClassLoader()
                .getResourceAsStream("rabbit.properties")) {
            Properties cfg = new Properties();
            cfg.load(in);
            Class.forName(cfg.getProperty("driver"));
            try (Connection cnn = DriverManager.getConnection(
               cfg.getProperty("url"),
               cfg.getProperty("username"),
               cfg.getProperty("password"))) {
                Scheduler scheduler = StdSchedulerFactory
                        .getDefaultScheduler();
                scheduler.start();
                JobDataMap data = new JobDataMap();
                data.put("cnn", cnn);
                JobDetail job = newJob(Rabbit.class)
                        .usingJobData(data)
                        .build();
                SimpleScheduleBuilder times = simpleSchedule()
                        .withIntervalInSeconds(Integer.parseInt(cfg
                                .getProperty("rabbit.interval")))
                        .repeatForever();
                Trigger trigger = newTrigger()
                        .startNow()
                        .withSchedule(times)
                        .build();
                scheduler.scheduleJob(job, trigger);
                Thread.sleep(10000);
                scheduler.shutdown();
            } catch (SQLException | SchedulerException | InterruptedException e) {
                e.printStackTrace();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static class Rabbit implements Job {
        @Override
        public void execute(JobExecutionContext context)  {
            Connection connection = (Connection) context.getJobDetail()
                    .getJobDataMap().get("connect");
            try (PreparedStatement statement = connection.prepareStatement(
                    "insert into rabbit (create_date) values (?)")) {
                statement.setTimestamp(1, Timestamp.valueOf(LocalDateTime.now()));
                statement.execute();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}