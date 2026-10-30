public class Student extends Person implements Gradable {
    // 2D array storing scores
    protected double[][] scores;

    // Constructor
    public Student(String name, String studentId, double[][] scores){
        super(name,studentId);
        this.scores= scores;
    }
    // Returns the role label for this student type
    @Override
    public String getRole(){
        return "Undergraduate Student";
    }

    // Calculates base average of all scores in the 2D array
    @Override
    public double calculateGrade() {
        double sum = 0;
        int count = 0;
        for(int i = 0; i< scores.length; i++){
            for(int j =0; j< scores[i].length; j++){
                sum+= scores[i][j];
                count++;
            }

        }
        return sum/ count;
    }
    // Converts the numeric average into a letter grade
    @Override
    public String getGradeLabel(){
        double average = calculateGrade();

        if (average >= 90)
            return "A";
        else if (average < 90 && average >= 75)
            return "B";
        else if (average  < 75 && average >= 60)
            return "C";
        else if (average >= 50 && average < 60)
            return " D";
        else  return "F";
    }
    // Prints  formatted grade report line to the console
    public void printReport(){

        double average = calculateGrade();
        System.out.printf("%s | Average: %.2f | Grade: %s%n", getInfo(),calculateGrade(),getGradeLabel());

    }
}