package com.example.demo.api;

/**
 * DOCUMENT ME!
 *
 * @version  $Revision$, $Date$
 */
public class NewStudent
{
	//~ Instance fields --------------------------
	/**  */
	private Long id;

	/**  */
	private String name;

	/**  */
	private String subject;
	//~ Constructors -----------------------------
	/** Creates a new NewStudent object. */
	public NewStudent( ) { }

	/**
	 * Creates a new NewStudent object.
	 *
	 * @param  name
	 * @param  subject
	 */
	public NewStudent(Long id, String name, String subject)
	{
		this.id = id;
		this.name = name;
		this.subject = subject;
	}
	//~ Methods ----------------------------------
	/**
	 * DOCUMENT ME!
	 *
	 * @return
	 */
	public Long getId()
	{
		return id;
	}
	
	/**
	 * DOCUMENT ME!
	 *
	 * @param  id
	 */
	public void setId(Long id)
	{
		this.id = id;
	}
	
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
