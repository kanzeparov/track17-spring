package track.container;

import track.container.beans.Car;
import track.container.beans.Engine;
import track.container.beans.Gear;
import track.container.config.Bean;
import track.container.config.ConfigReader;

import java.io.File;
import java.util.List;

/**
 *
 */
public class Main {

    public static void main(String[] args) throws Exception {
        ConfigReader reader = new JsonConfigReader();
        List<Bean> beans = reader.parseBeans(new File("src/main/resources/config.json"));
        Container container = new Container(beans);
        Car car = (Car) container.getById("carBean");
        Engine engine = (Engine) container.getById("engineBean");
        Gear gear = (Gear) container.getByClass("track.container.beans.Gear");
        Gear gear1 = (Gear) container.getById("gearBean1");
        System.out.println(engine);
        System.out.println(car);
        System.out.println(gear);
        System.out.println(gear1);



        /*
        ПРИМЕР ИСПОЛЬЗОВАНИЯ
         */

//        // При чтении нужно обработать исключение
//        ConfigReader configReader = new JsonConfigReader();
//        Container container = new Container(beans);
//
//        Car car = (Car) container.getByClass("track.container.beans.Car");
//        car = (Car) container.getById("carBean");


    }
}