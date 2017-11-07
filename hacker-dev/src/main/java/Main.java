/*
    link: https://www.hackerrank.com/contests/hourrank-23/challenges/halloween-sale/submissions
    point: 100/100
*/

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

public class Main {

    private static final int DEFAULT_NO_THREADS=10;
    private static final String DEFAULT_SCHEMA="default";
    public static void main(String[] args) throws Exception {
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        //register the MBean
        SystemConfig mBean = new SystemConfig(DEFAULT_NO_THREADS, DEFAULT_SCHEMA);
        ObjectName name = new ObjectName("com.journaldev.jmx:type=SystemConfig2");
        mbs.registerMBean(mBean, name);
        do{
            Thread.sleep(3000);
            int count = (int) mbs.getAttribute(name, "ThreadCount");
            System.out.println("count: " + count);
            if (count <= 0)
                break;
        }while(true);
    }
}