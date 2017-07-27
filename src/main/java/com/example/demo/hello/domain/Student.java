package com.example.demo.hello.domain;

/**
 * DOCUMENT ME!
 *
 * @version  $Revision$, $Date$
 */
public class Student
{
	//~ Instance fields --------------------------
	/**  */
	private long id;

	/**  */
	private String name;

	/**  */
	private String subject;
	//~ Constructors -----------------------------

	/** Creates a new Student object. */
	private Student( ) { }

	/**
	 * Creates a new Student object.
	 *
	 * @param  id
	 * @param  name
	 * @param  subject
	 */
	private Student(Long id, String name, String subject)
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
	public long getId()
	{
		return id;
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
	

	/** @see  java.lang.Object#toString() */
	@Override
	public String toString()
	{
		return "Student{"
		+ "id=" + id + ", name='" + name + '\'' + ", subject='" + subject + '\'' + '}';
	}
	//~ Inner Classes ----------------------------

	/**
	 * DOCUMENT ME!
	 *
	 * @version  $Revision$, $Date$
	 */
	public static class Builder
	{
		/**  */
		private long id;

		/**  */
		private String name;

		/**  */
		private String subject;

		/**
		 * DOCUMENT ME!
		 *
		 * @param   id
		 * @return
		 */
		public Student.Builder addId(long id)
		{
			this.id = id;

			return this;
		}

		/**
		 * DOCUMENT ME!
		 *
		 * @param   name
		 * @return
		 */
		public Student.Builder addName(String name)
		{
			this.name = name;

			return this;
		}

		/**
		 * DOCUMENT ME!
		 *
		 * @param   subject
		 * @return
		 */
		public Student.Builder addSubject(String subject)
		{
			this.subject = subject;

			return this;
		}

		/**
		 * DOCUMENT ME!
		 *
		 * @return
		 */
		public Student build()
		{
			return new Student(id, name, subject);
		}
	}
}
