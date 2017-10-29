import static org.junit.Assert.assertTrue;

import lab.schedule.ScheduleLog;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-context.xml")
@ActiveProfiles("cron")
public class QuartzCronJobTest {

  @Before
  public void setUp() throws Exception {
    ScheduleLog.clear();
  }

  // If all 3 tests in a raw are executed they will not pass
  @Test
  @DirtiesContext
  public void testCronJob() {
    try {
      Thread.sleep(5000);
      assertTrue(ScheduleLog.getStringValue().contains("I'm printing job..."));
      System.out.println("1: " + ScheduleLog.getStringValue());
      int logLength = ScheduleLog.getStringValue().length();
      Thread.sleep(4000);
      System.out.println("2: " + ScheduleLog.getStringValue());
      assertTrue(ScheduleLog.getStringValue().length() > logLength);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  @After
  public void tearDown() throws Exception {
    ScheduleLog.clear();
  }
}