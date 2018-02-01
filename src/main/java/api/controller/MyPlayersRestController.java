package api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import api.domain.Player;
import api.service.MyPlayersService;

@RestController
@RequestMapping("/players")
public class MyPlayersRestController {

	@Autowired
	MyPlayersService service;

	@RequestMapping(method = RequestMethod.GET)
	public List<Player> findAll() {
		return service.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Player findOne(@PathVariable("id") String id) {
		return service.findOne(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public void create(@PathVariable("id") String id, @Valid @RequestBody Player player) {
		service.create(id, player);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void update(@PathVariable("id") String id, @Valid @RequestBody Player player) {
		service.update(id, player);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") String id) {
		service.delete(id);
	}
}