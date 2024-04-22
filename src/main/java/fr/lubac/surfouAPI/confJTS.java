package fr.lubac.surfouAPI;

import org.n52.jackson.datatype.jts.JtsModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class confJTS {
//register the JTS module with Jackson : allow to serialize/deserialize GeoJso
	@Bean
	public JtsModule jtsModule()
	{
	    return new JtsModule();
	}
}
