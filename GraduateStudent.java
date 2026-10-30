public class GraduateStudent extends Student {

    // Constructor
    public GraduateStudent(String name ,String studentId,double [][] scores){
        super(name, studentId,scores);
    }
    @Override

    // Return role label used in reports and console output
    public String getRole(){
        return "Graduate Student";
    }

    @Override
    // Calculate  final grade using a weighted average for each assessment
    public double calculateGrade(){
        double weightedSum = 0;
        for(int i = 0; i< scores.length; i++){
          double weightedScore = scores[i][0] * 0.4 + scores[i][1] * 0.6;
          weightedSum+= weightedScore;
        }
        // Divide total weighted sum by number of assessments to get the final average
        return weightedSum / scores.length;
    }




}