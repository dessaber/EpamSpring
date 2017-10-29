package lab.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ScheduledTask {

  @Scheduled(fixedDelay = 5000)
  void doSomething() {
    log.info("Appending log message into ScheduleLog ...");
    ScheduleLog.append("I'm printing job...\n");
  }
}
