package JSR160JMXRemoting.mbean;

public class Speaker implements SpeakerMBean {
    @Override
    public String sayHello() {
        return "Hello!!";
    }
}
