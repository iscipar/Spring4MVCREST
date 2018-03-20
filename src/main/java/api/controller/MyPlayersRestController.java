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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/players")
@Api(value = "players", description = "Players API", produces = "application/json")
public class MyPlayersRestController {

	@Autowired
	MyPlayersService service;

	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation(value = "Get Players", notes = "Returns all players")
	@ApiResponses({ @ApiResponse(code = 200, message = "Exits one player at least") })
	public List<Player> findAll() {
		return service.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "Get one Player", notes = "Returns one player")
	@ApiResponses({ @ApiResponse(code = 200, message = "Exists this player") })
	public Player findOne(
			@ApiParam(defaultValue = "99", value = "The id of the player to return") @PathVariable("id") String id) {
		return service.findOne(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	@ApiOperation(value = "Create Player", notes = "Create a player")
	@ApiResponses({ @ApiResponse(code = 201, message = "Successful create of a player") })
	public void create(
			@ApiParam(defaultValue = "99", value = "The id of the player to create") @PathVariable("id") String id,
			@Valid @RequestBody Player player) {
		service.create(id, player);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ApiOperation(value = "Update Player", notes = "Update a player")
	@ApiResponses({ @ApiResponse(code = 204, message = "Successful update of a player") })
	public void update(
			@ApiParam(defaultValue = "99", value = "The id of the player to update") @PathVariable("id") String id,
			@Valid @RequestBody Player player) {
		service.update(id, player);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ApiOperation(value = "Delete Player", notes = "Delete a player")
	@ApiResponses({ @ApiResponse(code = 204, message = "Successful delete of a player") })
	public void delete(
			@ApiParam(defaultValue = "99", value = "The id of the player to delete") @PathVariable("id") String id) {
		service.delete(id);
	}
}