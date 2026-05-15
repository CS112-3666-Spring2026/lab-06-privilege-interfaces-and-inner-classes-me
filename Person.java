public class Person implements Comparable<Person>
{
	/***** TODO: (Part 2) create helper inner class for Identity*****/
	public class Identity {
			
		private String pronouns;
		private String background;

		public Identity(String pronouns, String background)
		{
			this.setPronouns(pronouns);
			this.setBackground(background);
		}

		public Identity()
		{
			this("Unknown", DEFAULT_STORY);
		}

		public Identity(Identity original)
		{
			if(original == null)
			{
				throw new IllegalArgumentException("Cannot copy null object in Identity copy constructor");
			}

			this.setPronouns(original.pronouns);
			this.setBackground(original.background);
		}

		public void setPronouns(String pronouns)
		{
			this.pronouns = pronouns;
		}

		public void setBackground(String background)
		{
			this.background = background;
		}

		public String getPronouns()
		{
			return this.pronouns;
		}

		public String getBackground()
		{
			return this.background;
		}

		@Override
		public String toString()
		{
			return "My pronouns are " + this.pronouns + ". " + this.background;
		}

		@Override
		public boolean equals(Object other)
		{
			if(other == null || !(other instanceof Person.Identity))
			{
				return false;
			}

			Identity otherIdentity = (Identity) other;

			return this.pronouns.equals(otherIdentity.pronouns)
				&& this.background.equals(otherIdentity.background);
		}
	}

	// CONSTANT VARIABLES
	public static final String DEFAULT_NAME = "Jamie Doe";
	public static final String DEFAULT_STORY = "Unknown";
	public static final String DEFAULT_PRONOUNS = "Unknown";
	public static final int DEFAULT_PRIVILEGE = 100;

	// INSTANCE VARIABLES
	private String name;
	private Identity story;
	private int privilege;

	// CONSTRUCTORS	
	public Person(String name, String story, int privilege) {
		this.setAll(name, DEFAULT_PRONOUNS, story, privilege);
	}

	public Person(String name, String pronouns, String background, int privilege) {
		this.setAll(name, pronouns, background, privilege);
	}
		
	public Person() {
		this(DEFAULT_NAME, DEFAULT_PRONOUNS, DEFAULT_STORY, DEFAULT_PRIVILEGE);
	}
	
	public Person(Person original) {
		if(original == null) {
			throw new IllegalArgumentException("Cannot copy null obect in Person copy constructor");
		} else {
			this.setAll(original.name, original.story.getPronouns(), original.story.getBackground(), original.privilege);
		}
	}

	// MUTATORS/SETTERS
	public void setName(String name) {
		this.name = name;
	}

	public void setStory(String background) {
		if(this.story == null)
		{
			this.story = new Identity();
		}

		this.story.setBackground(background);
	}

	public void setPronouns(String pronouns)
	{
		if(this.story == null)
		{
			this.story = new Identity();
		}

		this.story.setPronouns(pronouns);
	}

	public void setBackground(String background)
	{
		this.setStory(background);
	}

	public void setIdentity(String pronouns, String background)
	{
		this.story = new Identity(pronouns, background);
	}

	public void setPrivilege(int privilege) {
		this.privilege = privilege;
	}

	public void setAll(String name, String pronouns, String background, int privilege)
	{
		this.setPrivilege(privilege);
		this.setName(name);
		this.setIdentity(pronouns, background);
	}

	// ACCESSORS / GETTERS
	public String getName() {
		return this.name;
	}
		
	public String getStory() {
		return this.story.getBackground();
	}

	public String getPronouns()
	{
		return this.story.getPronouns();
	}

	public String getBackground()
	{
		return this.story.getBackground();
	}

	public int getPrivilege() {
		return this.privilege;
	}

	// OTHER REQUIRED METHODS
	@Override
	public String toString()
	{
		return "My name is "+ this.name + " and "+ this.story + "\n"
				+ "According to this calculator I ended up with "+ this.privilege + " estimated privilege points";
	}
	
	@Override
	public boolean equals(Object other) 
	{
		if(other == null || (!(other instanceof Person))) {
		    return false;
		}
		
		Person otherPerson = (Person) other;
		return this.name.equals(otherPerson.name) && this.story.equals(otherPerson.story) &&
			this.privilege == otherPerson.privilege;	
	}

	// INTERFACE METHODS
	/* TODO: (Part 1) override compareTo method to implement Comparable interface*/
	@Override
	public int compareTo(Person other)
	{
		if(other == null)
		{
			throw new IllegalArgumentException("Cannot compare to null Person object");
		}

		return Integer.compare(this.privilege, other.privilege);
	}
}