# Stoom
Sprint Boot + Crud + Mysql + Geocoding + JUnit Tests using MockMvc and Mockito

# Run Script
  
  Location:
  
  /stoom/src/main/resources/script_v1.sql
  
# Run Api 

  mvn clean ;
  mvn install ;
  mvn spring-boot:run;
  
# Api routes 
  
  localhost:888/api/v1/location/{id}  - (get)
  //		   /api/v1/location       - (get)
  //		   /api/v1/location       - (post)
  //		   /api/v1/location/{id}  - (put)
  //	       /api/v1/location/{id}  - (delete)
  //           /api/v2/location       - (get)