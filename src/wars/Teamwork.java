package wars; 


/**
 * Details of your team
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Teamwork
{
    private String[] details = new String[12];
    
    public Teamwork()
    {   // in each line replace the contents of the String 
        // with the details of your team member
        // Please list the member details alphabetically by surname 
        // i.e. the surname of member1 should come alphabetically 
        // before the surname of member 2...etc
        details[0] = "65";
        
        details[1] = "Adam";
        details[2] = "Samson";
        details[3] = "22018521";

        details[4] = "Fabiyi";
        details[5] = "Samson";
        details[6] = "22065067";

        details[7] = "Stoica";
        details[8] = "Mihai Lucian";
        details[9] = "22060092";


        details[10] = "Toledo";
        details[11] = "Darrel";
        details[12] = "22087552";

	
	   // only if applicable
        details[13] = "surname of member5";
        details[14] = "first name of member5";
        details[15] = "SRN of member5";


    }
    
    public String[] getTeamDetails()
    {
        return details;
    }
    
    public void displayDetails()
    {
        for(String temp:details)
        {
            System.out.println(temp.toString());
        }
    }
}
        
