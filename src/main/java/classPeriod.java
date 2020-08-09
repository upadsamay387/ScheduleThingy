public class classPeriod {

    String courseID;
    String courseDesc;
    int numberEnrolled;
    String teacher;
    String room;
    int period;

    public classPeriod(String courseID, String courseDesc, int numberEnrolled, String teacher, String room, int period) {
        this.courseID = courseID;
        this.courseDesc = courseDesc;
        this.numberEnrolled = numberEnrolled;
        this.teacher = teacher;
        this.room = room;
        this.period = period;
    }

    public String toString() {
        return courseID;
    }
}
