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

    @RequestMapping("/getInformation/{text}")
    public @ResponseBody  Mono<String> home(@PathVariable(value="text") String text) {
Generator g= new Generator(text);
		
		String[] val= g.getSample().toString().split(" ");
		for(String s : val){
			String[] s2=s.split("_");
			if(s2[1].equals("VB"))
				System.out.println(s);
			
		}
		
		
		// A Flux is a data publisher
				EmitterProcessor<String> stream = EmitterProcessor.<String>create().connect();

				// Filter values passing through the Flux, observe and capture the result once.
				Mono<List<String>> promise = stream.filter(s -> s.startsWith("Hello"))
				                                   .doOnNext(s -> System.out.println("yollo"+1+2+""+s))
				                                   .collectList()
				                                   .subscribe();

				// Publish a value
				stream.onNext("Hello World!");
				stream.onNext("Goodbye World!");
				stream.onComplete();

				promise.block();
		
		//System.out.println(g.sample.toString()); 
		
        return Mono.just(g.getSample().toString());
    
    }
    
    @RequestMapping("/never")
    public @ResponseBody  Mono<String> never() {
    	return Mono.never();
    }
   
}