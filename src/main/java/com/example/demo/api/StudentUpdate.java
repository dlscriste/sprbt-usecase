package com.example.demo.api;

/**
 * DOCUMENT ME!
 *
 * @version  $Revision$, $Date$
 */
public class StudentUpdate
{
	//~ Instance fields --------------------------
	/**  */
	private String name;

	/**  */
	private String subject;
	//~ Constructors -----------------------------

	/** Creates a new StudentUpdate object. */
	public StudentUpdate( ) { }

	/**
	 * Creates a new StudentUpdate object.
	 *
	 * @param  name
	 * @param  subject
	 */
	public StudentUpdate(String name, String subject)
	{
		this.setName(name);
		this.setSubject(subject);
	}
	//~ Methods ----------------------------------

	/**
	 * DOCUMENT ME!
	 *
	 * @return
	 */
	public String getName()
	{
		return name;
	}
	

	/**
	 * DOCUMENT ME!
	 *
	 * @param  name
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	

	/**
	 * DOCUMENT ME!
	 *
	 * @return
	 */
	public String getSubject()
	{
		return subject;
	}
	

	/**
	 * DOCUMENT ME!
	 *
	 * @param  subject
	 */
	public void setSubject(String subject)
	{
		this.subject = subject;
	}
}
