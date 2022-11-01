package firstSpring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class MainApp {
    public static void main(String[] args) {
        //ApplicationContext context = new ClassPathXmlApplicationContext("file:D:\\java-practice\\untitled\\src\\main\\java\\bean.xml");
        ApplicationContext context = new ClassPathXmlApplicationContext("src/Bean.xml");
        HelloWorld obj = context.getBean("helloWorld",HelloWorld.class);
        obj.getMessage();
    }
}