/**
 *
 */
package com.example.demo.hello.domain;

/** @author  crida */
public class Greeting
{
	//~ Instance fields --------------------------
	/**  */
	private final String content;

	/**  */
	private final long id;
	//~ Constructors -----------------------------
	/**
	 * Creates a new Greeting object.
	 *
	 * @param  id
	 * @param  content
	 */
	public Greeting(long id, String content)
	{
		this.id = id;
		this.content = content;
	}
	//~ Methods ----------------------------------
	/**
	 * DOCUMENT ME!
	 *
	 * @return
	 */
	public long getId()
	{
		return id;
	}
	
	/**
	 * DOCUMENT ME!
	 *
	 * @return
	 */
	public String getContent()
	{
		return content;
	}
}
