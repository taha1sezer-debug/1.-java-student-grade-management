public abstract class Person {
    // Name and ID are accessible to subclasses by protected key word
  protected String name;
  protected String studentId;

  // Constructor
  public Person(String name, String studentId){
      this.name = name;
      this.studentId = studentId;
  }
    // Subclasses must define their own role
  public abstract String getRole();

    // Return a formatted string combining role name and ID
  public String getInfo() {
      return getRole() + "--" + name + " (ID: " +studentId + ")";
  }
}