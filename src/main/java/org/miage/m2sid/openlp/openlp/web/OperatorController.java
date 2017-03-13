package org.miage.m2sid.openlp.openlp.web;

import java.util.List;

import org.miage.m2sid.openlp.openlp.domain.Generator;
import org.springframework.boot.autoconfigure.*;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.*;

import reactor.core.publisher.EmitterProcessor;
import reactor.core.publisher.Mono;

@RestController
@EnableAutoConfiguration
public class OperatorController {

	/**
	 * Request from developer is coming, it's text then I take text and thanks
	 * to Open lp natural language library split the request text of user for
	 * example : deploy app2 in e2e
	 * 
	 * 
	 * I want to know if there is a mecanisme already implemented in
	 * reactor.core and webflux for getting ALL flux Example : Developer A
	 * Called API for deploying app2 Developer B started deploying app3 etc..
	 * What I would like to do is, having a get for example /activities that my
	 * bot call, and each time /activities called i want to get all current
	 * activities (activities started and doesn't finished (a list of flux so))
	 * 
	 * @param text
	 * @return
	 */
	@RequestMapping("/getInformation/{text}")
	public @ResponseBody Mono<String> home(@PathVariable(value = "text") String text) {
		Generator g = new Generator(text);
		return Mono.just(g.getSample().toString());

	}
}