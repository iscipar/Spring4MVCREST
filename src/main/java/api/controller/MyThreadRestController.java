package api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import api.service.MyThreadService;

@RestController
@RequestMapping("/thread")
public class MyThreadRestController {

	@Autowired
	MyThreadService service;

	@RequestMapping(value = "/performparalleltask", method = RequestMethod.GET)
	public void performParallelTask() throws InterruptedException {
		service.performParallelTask();
	}
}