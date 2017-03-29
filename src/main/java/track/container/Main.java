package track.container;

import com.fasterxml.jackson.databind.ObjectMapper;
import track.container.beans.Car;
import track.container.beans.Engine;
import track.container.beans.Gear;
import track.container.config.Bean;
import track.container.config.ConfigReader;
import track.container.config.InvalidConfigurationException;
import track.lections.lection4.Person;

import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

/**
 *
 */
public class Main {

    public static void main(String[] args) throws Exception{

        //System.out.println(car.toString());
        ObjectMapper mapper = new ObjectMapper();
        //Car car1 = mapper.readValue(new File("src/main/resources/config.json"), Car.class);
        //Engine engine = mapper.readValue(new File("src/main/resources/config.json"), Engine.class);
        Gear gear = mapper.readValue(new File("src/main/resources/config.json"), Gear.class);
        System.out.println();



        /*

        ПРИМЕР ИСПОЛЬЗОВАНИЯ

         */

//        // При чтении нужно обработать исключение
//        ConfigReader reader = new JsonReader();
//        List<Bean> beans = reader.parseBeans("config.json");
//        Container container = new Container(beans);
//
//        Car car = (Car) container.getByClass("track.container.beans.Car");
//        car = (Car) container.getById("carBean");


    }
}
