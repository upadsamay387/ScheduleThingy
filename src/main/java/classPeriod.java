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

    public void setCourseDesc(String courseDesc) {
        this.courseDesc = courseDesc;
    }

    public void setNumberEnrolled(int numberEnrolled) {
        this.numberEnrolled = numberEnrolled;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String toString() {
        return courseID;
    }
}
