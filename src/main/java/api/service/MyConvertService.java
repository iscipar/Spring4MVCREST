package api.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import api.domain.CustomPerson;
import api.domain.Person;
import api.domain.Player;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.impl.DefaultMapperFactory;

@Service
public class MyConvertService {

	private MapperFactory personMapperFactory;
	private MapperFacade personMapper;
	
	private MapperFactory customPersonMapperFactory;
	private MapperFacade customPersonMapper;

	public MyConvertService() {
		createPersonMapper();
		createCustomPersonMapper();
	}
	
	private void createPersonMapper() {
		this.personMapperFactory = new DefaultMapperFactory.Builder().build();
		this.personMapperFactory.classMap(Player.class, Person.class)
			.field("nationality", "country")
			.byDefault()
			.register();
		this.personMapper = this.personMapperFactory.getMapperFacade();
	}
	
	private void createCustomPersonMapper() {
		this.customPersonMapperFactory = new DefaultMapperFactory.Builder().build();
		this.customPersonMapperFactory.classMap(Player.class, CustomPerson.class)
			.customize(new CustomMapper<Player, CustomPerson>() {
				@Override
				public void mapAtoB(Player player, CustomPerson customPerson, MappingContext mappingContext) {
					customPerson.setName(player.getName());
					customPerson.setCountry(player.getNationality());
					customPerson.setEmail(player.getEmail());
					customPerson.setGender("Male");
					customPerson.setCurrentDate(new Date());
				}
			})
			.register();
		this.customPersonMapper = this.customPersonMapperFactory.getMapperFacade();
	}

	public Person convertOne(Player player) {
		return this.personMapper.map(player, Person.class);
	}
	
	public CustomPerson customConvertOne(Player player) {
		return this.customPersonMapper.map(player, CustomPerson.class);
	}
}