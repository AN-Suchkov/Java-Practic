package pr19;


public class Student {
    private String fullName;
    private double averageScore;

    public Student(String fullName, double averageScore){
        setFullName(fullName);
        setAverageScore(averageScore);
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName){
        this.fullName = fullName;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }

    @Override
    public String toString() {
        return "Студент: " + fullName + ", Средний балл: " + averageScore;
    }
}
