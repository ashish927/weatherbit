package helper

import org.springframework.beans.factory.annotation.Value

import java.text.SimpleDateFormat

class DateHelper {


     Date getTimeThreeDaysAgo(){
        Calendar calendar = Calendar.getInstance()
        calendar.setTime(new Date())
        calendar.add(Calendar.DATE, -3)
        return calendar.getTime()
    }

    static String getYesterdaysDate(){
        Calendar calendar = Calendar.getInstance()
        calendar.setTime(new Date())
        calendar.add(Calendar.DATE, -1);
        return new SimpleDateFormat("yyyy-MM-dd HH:mm").format(calendar.getTime())
    }

    static String getTodaysDate(){
        Calendar calendar = Calendar.getInstance()
        calendar.setTime(new Date())
        return new SimpleDateFormat("YYYYMMdd").format(calendar.getTime())
    }

    static String getDate(Integer dateOffset){
        Calendar calendar = Calendar.getInstance()
        calendar.setTime(new Date())
        calendar.add(Calendar.DATE, dateOffset)
        return new SimpleDateFormat("yyyy-MM-dd HH:mm").format(calendar.getTime())
    }
}
