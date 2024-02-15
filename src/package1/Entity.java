//Tom Haklai 
//20347511

package package1;

public class Entity {
	
	//Instance variables
	private String name;
	private Date born;
	
	//Constructor
	public Entity(String name, Date date) {
		this.name = name;
        this.born = date;
	}
	
	//Returns entity content as string
	public String toString( )
    {
        return (name + ", born on " + born);
    }
	
	
	//Accessors
	public String getName() {
        return name;
    }

    public Date getBorn() {
        return new Date(born);
    }
  
    
    //Mutators
    public void setName(String name) {
        this.name = name;
    }

    public void setBorn(Date born) {
        this.born = born;
    }
    
    //Compare entity contents
    public boolean equals(Entity entity) {
        if (entity != null) {
        	return (name.equals(entity.name) && born.equals(entity.born));
        }
        else {
        	return false;
        }
        
    }
    
    
    public Entity(Entity entity)
    {
        if (entity == null)
        {
             System.out.println("Fatal Error.");
             System.exit(0);
        }

        name = entity.name;
        born = new Date(entity.born);
    }
    

	     

}
