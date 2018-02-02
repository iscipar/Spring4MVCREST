package api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import api.domain.CustomPerson;
import api.domain.Person;
import api.service.MyPeopleService;

@RestController
@RequestMapping("/people")
public class MyPeopleRestController {

	@Autowired
	MyPeopleService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Person convertOne(@PathVariable("id") String id) {
		return service.convertOne(id);
	}

	@RequestMapping(value = "/custom/{id}", method = RequestMethod.GET)
	public CustomPerson customConvertOne(@PathVariable("id") String id) {
		return service.customConvertOne(id);
	}
}