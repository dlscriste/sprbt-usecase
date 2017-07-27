package com.example.demo.hello.controller;

import com.example.demo.hello.domain.Greeting;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;


/**
 * DOCUMENT ME!
 *
 * @version  $Revision$, $Date$
 */
@RestController
public class GreetingController
{
	//~ Static fields/initializers ---------------
	/**  */
	private static final String template = "Hello, %s!";
	//~ Instance fields --------------------------
	/**  */
	private final AtomicLong counter = new AtomicLong();
	//~ Methods ----------------------------------
	/**
	 * DOCUMENT ME!
	 *
	 * @param   name
	 * @return
	 */
	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(
			value = "name",
			defaultValue = "World"
		) String name)
	{
		return new Greeting(counter.incrementAndGet(),
			String.format(template, name));
	}
	
	/**
	 * DOCUMENT ME!
	 *
	 * @return
	 */
	@RequestMapping("/greeting/hello")
	public String greetingHello()
	{
		return "Hello World.";
	}
}
