import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        //  list to hold all student objects
        ArrayList<Student> students = new ArrayList<>();

        // Define input and output file paths
        String inputs = "students.txt";
        String outputs = "grades.txt";

        System.out.println("Reading from " + inputs + "...");

        // Initialize BufferedReader for  line file reading
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(inputs));
        } catch (IOException e) {

            // If the file cannot found , print error and exit
            System.out.println("Error: could not open " + inputs + ". " + e.getMessage());
            return;
        }

        try {
            String line;
            int lineNum = 0;

            // Read the file line by line
            while ((line = reader.readLine()) != null) {
                lineNum++;


                // Split each line with comma
                //  format: type,name,id,score1,score2,score3,score4,score5,score6
                String[] fields = line.split(",");
                String type = fields[0];
                String name = fields[1];
                String id = fields[2];

                // 2D array holding 2 scores for each of 3 assessments (midterm and final)
                double[][] scores = new double[3][2];
                try {
                    int idx = 3;  // Scores start at index 3 in the fields array
                    for (int i = 0; i < 3; i++) {
                        scores[i][0] = Double.parseDouble(fields[idx++]); // midterm
                        scores[i][1] = Double.parseDouble(fields[idx++]); // final
                    }
                } catch (NumberFormatException e) {
                    // Skip invalid lines
                    System.out.println("Error: invalid score input on line " + lineNum + ". Skipping.");
                    continue;
                }


                // create correct subclass based on student type and add to list
                if (type.equals("U")) {
                    Student st = new Student(name, id, scores);
                    students.add(st);
                    System.out.println("Loaded: " + name + " (" + st.getRole() + ")");
                } else if (type.equals("G")) {
                    GraduateStudent gr = new GraduateStudent(name, id, scores);
                    students.add(gr);
                    System.out.println("Loaded: " + name + " (" + gr.getRole() + ")");
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        // Print the grade report
        System.out.println("\n=== Grade Report ===");
        for (Student s : students) {
            s.printReport();   //each subclass prints its own report
        }


        // Write the grade report to the output file
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(outputs));
            writer.println("=== Grade Report ===");
            for (Student s : students) {
                // Format  student info | average score | letter grade
                writer.printf("%s | Average: %.2f | Grade: %s%n",
                        s.getInfo(), s.calculateGrade(), s.getGradeLabel());
            }
            writer.close();
            System.out.println("\n" + outputs + " saved successfully.");
        } catch (IOException e) {
            System.out.println("Error: could not write to " + outputs + ". " + e.getMessage());
        }
    }
}































