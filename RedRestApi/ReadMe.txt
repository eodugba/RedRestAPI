Purpose:  This is a springboot application was created to demonstrate the use of REST API webservices on a webpage.
          Application displays cities a user has visited on a google map using provided logitude and latitude.
           

Technology:  Java 1.8, Angular 1, Javascript, SpringBoot, Postgres, H2 database,hibernate

Database:  Currently using built in H2 database but was initially built using postgres
           application tables:  City - All cities visited by all users with the longitude and latitude cordinates.
                                       columns: city_id, date_added, date_time_added, lastupdated,latitude,longitude,city_name,state_id, status;
                                       primary key : city_id,state_id
                                       foreign keys:  state_id  (state table)
                                State - All states in the US.
                                        columns: state_id,abbreviation,date_added,date_time_added,lastupdated,state_name;
                                        primary key: state_id,state_name
                                UserData - All User information    
                                           columns: user_id,date_added,date_time_added,first_name_last_name,lastupdated;
                                           primary_key: user_id
                                UserLogin - All user login information
                                            columns:  user_id,password,user_name
                                            primary key: user_name
                                            foreign key: userid (userdata table)
                                visits - All cities visited by user
                                         columns: visit_id,city_id,date_time_added,date_visited,lastupdated,state_id,user_id 
                                         primary key: visit_id
                                         foreign key:  city_id (city table),state_id (state_table), user_id (userdata table);
      
Functionality:  1.  Stand up rest services for all tables within the database.
                    a. Ability to retrieve data for all contents
                    b. Ability to retrieve data for a given primary key
                    c. Ability to modify table data via rest calls.
                    d. Ability to add/delete data via rest calls.
                2.  Create WEBPAGE to display rest call results.
                    a.  Created a page to log a user into the application
                    b.  Displayed a user visit on a map
                    c.  Provided additional detail about visit in a table format
Things to do or Consider:
	1.  The security needs to be better.  Use Spring Security Token based Authentication
	2.  Enhanced WebPage to allow clicking of a location to update a user's city visited data via the REST POST service provided.
	3.  Prevent and remove duplicate visits from being inserted in the visit table
	4.  Share visits and/or compare with other users
	5.	Create alerts to notify users when a friend is close by.
	
	
Build:
     execute mvn clean install package 

Execute
  java -jar target RedRestApi-0.0.1-SNAPSHOT.jar
  
  
 REQUIREMENTS:
 
 A new client wants to build a small API to allow users to pin areas they've visited and potentially share them with other users. The client included a set of sample data in User.csv, City.csv, and State.csv. Please implement a few basic operations on the data provided, including the following.

    Listing the cities in a given state
    Registering a visit to a particular city by a user
    Removing a visit to a city
    Listing cities visited by a user
    Listing states visited by a user.
   

You may use whatever language or tools you wish to complete the exercise. Keep in mind that you may be asked to extend your solution in an on-site interview.

Required endpoints

    List all cities in a state

    GET /state/{state}/cities  :  
    	Bring application up and type the following in a browser:
    		http://localhost:8080/state/AL/cities or http://localhost:8080/state/Alabama/cities
       

    Allow to create rows of data to indicate they have visited a particular city.

    POST /user/{user}/visits

    {
    	"city": "Chicago",
    	"state": "IL"
    }
    **Post with a payload json representation of all fields in the visits table with appropriate values.  

    Allow a user to remove an improperly pinned visit.

    DEL /user/{user}/visit/{visit}
    
    ** Delete with visit_id if known.  Could retrieve all user visit and then use the visit id returned.
  

    Return a list of cities the user has visited

    GET /user/{user}/visits
    
        Bring application up and type the following in a browser:
        
    		http://localhost:8080/user/8/visits

    Return a list of states the user has visited

    GET /user/{user}/visits/states
        Bring application up and type the following in a browser
           http://localhost:8080/user/8/visits/states

Things To Consider

    How should you deal with invalid or improperly formed requests?
    	Built into the http protocol requests that rest uses is a set of status code.  One could trap for desired completion status codes in the 400+ range and 501 to indicate failure points.
    
    How should you handle requests that result in large data sets?  
        1. Put a limit to size of the data returned.  
           a. Use another variable in the url to set limits
           b. Limit it from the server during retrieval.
        2. Study the data and rewrite api's to retrieve the right amount of data not to exceed maximum.
           a. Redesign table structures and relationships.
           b. Eliminate noisy data.  Only return relevant information. ie cities visited in the last month.

Deliverables

    The source code for your solution.
    The database schema you use to implement your solution.
    Any additional documentation you feel is necessary to explain how your application works, or describe your thought process and design decisions.

Bonus Points

    Handle authentication of users prior to allowing changes to their visits
    Make use of the lat/long data for cities in a creative way that provides additional functionality for the client
 

                    
                    

