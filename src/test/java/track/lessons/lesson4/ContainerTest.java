package track.lessons.lesson4;

import org.junit.Assert;
import track.container.Container;
import track.container.JsonConfigReader;
import track.container.beans.Car;
import track.container.beans.Engine;
import track.container.beans.Gear;
import track.container.config.ConfigReader;

import java.io.File;

public class ContainerTest {



    @org.junit.Test
    public void getEngine() {
        try {
            ConfigReader reader = new JsonConfigReader();
            Container container = new Container(reader.parseBeans(new File("src/main/resources/config.json")));
            Engine engine1 = (Engine)container.getById("engineBean");
            Engine engine2 = (Engine)container.getByClass("track.container.beans.Engine");
            Assert.assertEquals(engine1.getPower(), 200);
            Assert.assertEquals(engine2.getPower(), 200);
            Assert.assertEquals(engine1.equals(engine1), true);
        } catch (Exception e) {
            Assert.assertFalse(true);
        }
    }

    @org.junit.Test
    public void getGear() {
        try {
            ConfigReader reader = new JsonConfigReader();
            Container container = new Container(reader.parseBeans(new File("src/main/resources/config.json")));
            Gear gear1 = (Gear)container.getById("gearBean");
            Gear gear2 = (Gear) container.getByClass("track.container.beans.Gear");
            Assert.assertEquals(gear1.getCount(), 6);
            Assert.assertEquals(gear2.getCount(), 6);
            Assert.assertEquals(gear1.equals(gear2), true);
        } catch (Exception e) {
            Assert.assertFalse(true);
        }
    }
    @org.junit.Test
    public void getGearEquals() {
        try {
            ConfigReader reader = new JsonConfigReader();
            Container container = new Container(reader.parseBeans(new File("src/main/resources/config.json")));
            Gear gear1 = (Gear)container.getById("gearBean");
            Gear gear2 = (Gear) container.getByClass("track.container.beans.Gear");
            Gear gear3 = (Gear) container.getById("gearBean1");
            Assert.assertEquals(gear1.getCount(), 6);
            Assert.assertEquals(gear2.getCount(), 6);
            Assert.assertEquals(gear1.equals(gear2), true);
            Assert.assertEquals(gear1.equals(gear3), false);
        } catch (Exception e) {
            Assert.assertFalse(true);
        }
    }

    @org.junit.Test
    public void getCar() {
        try {
            ConfigReader reader = new JsonConfigReader();
            Container container = new Container(reader.parseBeans(new File("src/main/resources/config.json")));
            Car car = (Car) container.getById("carBean");
            Engine engine = (Engine) container.getById("engineBean");
            Gear gear = (Gear) container.getById("gearBean");
            Assert.assertEquals(car.getEngine(), engine);
            Assert.assertEquals(car.getGear(), gear);
        } catch (Exception e) {
            Assert.assertFalse(true);
        }
    }



}
