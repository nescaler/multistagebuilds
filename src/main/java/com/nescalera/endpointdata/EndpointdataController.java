package com.nescalera.endpointdata;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

// time, date, Timezone, hostname, ip
@RestController
public class EndpointdataController {

    @GetMapping("/system-data")
    public String getSystemInfo() {
        return getCalendarData() + " " + getHostData();
    }

    private String getCalendarData() {
        Calendar currentDate = Calendar.getInstance();
        return new SimpleDateFormat("'Time:' HH:mm:ss 'Date:' yyyy-MM-dd  'Timezone:' z").format(currentDate.getTime());
    }

    private String getHostData() {
        try {
            InetAddress ip = InetAddress.getLocalHost();
            return "Hostname: " + ip.getHostName() + " / IP address :" + ip.getHostAddress();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return "unknown";
    }
}
