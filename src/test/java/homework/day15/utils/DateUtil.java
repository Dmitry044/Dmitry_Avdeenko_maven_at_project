package homework.day15.utils;

import org.apache.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    public static final Logger LOGGER = Logger.getLogger(DateUtil.class.getName());

    public String setDay(int day) {
        SimpleDateFormat needFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar myCalendar = Calendar.getInstance();
        myCalendar.setTime(new Date());
        myCalendar.add(Calendar.DAY_OF_MONTH, day);
        LOGGER.trace("Set date: in " + day + "days");
        return needFormat.format(myCalendar.getTime());
    }
}
