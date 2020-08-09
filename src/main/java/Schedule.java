import java.util.ArrayList;

public class Schedule {

    classPeriod period1;
    classPeriod period2;
    classPeriod period3;
    classPeriod period4;
    classPeriod period5;
    classPeriod period6;
    classPeriod period7;

    public Schedule(classPeriod period1, classPeriod period2, classPeriod period3, classPeriod period4, classPeriod period5, classPeriod period6, classPeriod period7) {
        this.period1 = period1;
        this.period2 = period2;
        this.period3 = period3;
        this.period4 = period4;
        this.period5 = period5;
        this.period6 = period6;
        this.period7 = period7;
    }

    public classPeriod getPeriod1() {
        return period1;
    }

    public classPeriod getPeriod2() {
        return period2;
    }

    public classPeriod getPeriod3() {
        return period3;
    }

    public classPeriod getPeriod4() {
        return period4;
    }

    public classPeriod getPeriod5() {
        return period5;
    }

    public classPeriod getPeriod6() {
        return period6;
    }

    public classPeriod getPeriod7() {
        return period7;
    }

    public boolean isCorrect() {
        ArrayList<String> x = new ArrayList<String>();
        classPeriod[] prd = {period1,period2,period3,period4,period5,period6,period7};

        for(int k = 0; 0<prd.length; k++) {
            String testCase = prd[k].courseID;
            if(x.contains(testCase))
                return false;
            x.add(testCase);
        }
        return true;
    }

    public String toString() {
        classPeriod[] prd = {period1,period2,period3,period4,period5,period6,period7};
        String output = "\n";

        for(int k = 0; k<prd.length; k++) {
            output = output + "Period " + prd[k].period + ": " + prd[k].courseID + " " + prd[k].courseDesc + " with " + prd[k].teacher + " Room " + prd[k].room + " (" + prd[k].numberEnrolled + " students)" + "\n";
        }

        return output;
    }
}
