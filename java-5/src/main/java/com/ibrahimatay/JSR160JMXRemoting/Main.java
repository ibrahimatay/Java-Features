package com.ibrahimatay.JSR160JMXRemoting;

import com.ibrahimatay.JSR160JMXRemoting.mbean.Speaker;
import com.ibrahimatay.JSR160JMXRemoting.mbean.SpeakerMBean;
import com.ibrahimatay.JSR160JMXRemoting.mxbean.Message;
import com.ibrahimatay.JSR160JMXRemoting.mxbean.MessageQueue;

import javax.management.*;
import java.lang.management.ManagementFactory;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * To JMX connection between different servers add the following params to your jvm:
 *
 *  -Dcom.sun.management.jmxremote.port=8090 \
 *  -Dcom.sun.management.jmxremote.authenticate=false \
 *  -Dcom.sun.management.jmxremote.ssl=false \
 *
 *  for example:
 *   java -Dcom.sun.management.jmxremote.port=8090 \
 *        -Dcom.sun.management.jmxremote.authenticate=false \
 *        -Dcom.sun.management.jmxremote.ssl=false \
 *        -jar *-SNAPSHOT.jar
 */

public class Main  {
    public static void main(String[] args) throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException {
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        ObjectName speakerName = new ObjectName("com.ibrahimatay:type=Speaker");
        SpeakerMBean bean = new Speaker();
        mbs.registerMBean(bean, speakerName);


        ObjectName messageName = new ObjectName("com.ibrahimatay:type=Message");
        Queue<Message> messages = new ArrayBlockingQueue<Message>(10);
        messages.add(new Message("Message 1"));
        messages.add(new Message("Message 2"));
        messages.add(new Message("Message 3"));
        messages.add(new Message("Message 4"));
        MessageQueue messageQueue = new MessageQueue(messages);

        mbs.registerMBean(messageQueue, messageName);

        System.out.println("Started");
        while (true) {

        }
    }
}