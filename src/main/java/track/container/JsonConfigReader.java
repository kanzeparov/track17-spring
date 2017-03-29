package track.container;

import java.io.File;
import java.io.IOException;
import java.util.List;


import com.fasterxml.jackson.databind.ObjectMapper;
import track.container.beans.Car;
import track.container.beans.Gear;
import track.container.config.Bean;
import track.container.config.ConfigReader;
import track.container.config.InvalidConfigurationException;

/**
 * TODO: Реализовать
 */
public class JsonConfigReader implements ConfigReader {

    @Override
    public List<Bean> parseBeans(File configFile) throws InvalidConfigurationException {
        try {

            //System.out.println(car.toString());
            ObjectMapper mapper = new ObjectMapper();
            //Car car1 = mapper.readValue(new File("src/main/resources/config.json"), Car.class);
            //Engine engine = mapper.readValue(new File("src/main/resources/config.json"), Engine.class);
            Gear gear = mapper.readValue(configFile, Gear.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
