
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Main {

    public static void run() throws IOException {

        ArrayList<String> courses = new ArrayList<String>();
        ArrayList<Schedule> schedules = new ArrayList<Schedule>();
        ArrayList<classPeriod> period1 = new ArrayList<classPeriod>();
        ArrayList<classPeriod> period2 = new ArrayList<classPeriod>();
        ArrayList<classPeriod> period3 = new ArrayList<classPeriod>();
        ArrayList<classPeriod> period4 = new ArrayList<classPeriod>();
        ArrayList<classPeriod> period5 = new ArrayList<classPeriod>();
        ArrayList<classPeriod> period6 = new ArrayList<classPeriod>();
        ArrayList<classPeriod> period7 = new ArrayList<classPeriod>();

        File classList = new File("classList.xlsx");
        FileInputStream fis = new FileInputStream(classList);

        courses = FXController.courses;

        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);

        Iterator<Row> rowIterator = sheet.iterator();

        //goes through every row and adds all matching course IDs to ArrayLists for each eligible period
        while(rowIterator.hasNext()) {
            Row row = rowIterator.next();

            if(courses.contains(row.getCell(0).toString())) {

                classPeriod x = new classPeriod(row.getCell(0).toString(),row.getCell(1).toString(),(int) Double.parseDouble(row.getCell(4).toString()),row.getCell(8).toString(),row.getCell(10).toString(),(int) Double.parseDouble(row.getCell(11).toString()));
                int courseIndex = courses.indexOf(row.getCell(0).toString());
                String teacherName = FXController.teacherNames[courseIndex];
                int override = 0;
                if(FXController.periodOverride[courseIndex])
                    override = courseIndex + 1;

                if(teacherName.equals("") || teacherName.equals(x.teacher))
                if(override == 0 || x.period == override)
                    switch (x.period) {
                        case 1:
                            period1.add(x);
                            break;
                        case 2:
                            period2.add(x);
                            break;
                        case 3:
                            period3.add(x);
                            break;
                        case 4:
                            period4.add(x);
                            break;
                        case 5:
                            period5.add(x);
                            break;
                        case 6:
                            period6.add(x);
                            break;
                        case 7:
                            period7.add(x);
                            break;
                    }
            }
        }

        //creates all possible schedules
        for(int p1 = 0; p1<period1.size(); p1++)
            for(int p2 = 0; p2<period2.size(); p2++)
                for(int p3 = 0; p3<period3.size(); p3++)
                    for(int p4 = 0; p4<period4.size(); p4++)
                        for(int p5 = 0; p5<period5.size(); p5++)
                            for(int p6 = 0; p6<period6.size(); p6++)
                                for(int p7 = 0; p7<period7.size(); p7++) {
                                    Schedule schedule = new Schedule(period1.get(p1),period2.get(p2),period3.get(p3),period4.get(p4),period5.get(p5),period6.get(p6),period7.get(p7));
                                    if(schedule.isCorrect())
                                        schedules.add(schedule);
                                }

        if(schedules.size() == 0)
            System.out.println("No valid schedules found");
        else {
            ArrayList<String> teacherList = new ArrayList<String>();
            ArrayList<Integer> teacherNums = new ArrayList<Integer>();

            for(int k = 0; k<schedules.size(); k++) {
                System.out.println("Schedule " + (k+1));
                System.out.println(schedules.get(k));

                String[] teacherNames = {schedules.get(k).period1.teacher,schedules.get(k).period2.teacher,schedules.get(k).period3.teacher,schedules.get(k).period4.teacher,schedules.get(k).period5.teacher,schedules.get(k).period6.teacher,schedules.get(k).period7.teacher};

                for(int j = 0; j<7; j++) {
                    if (!teacherList.contains(teacherNames[j])) {
                        teacherList.add(teacherNames[j]);
                        teacherNums.add(1);
                    } else {
                        int z = teacherNums.get(teacherList.indexOf(teacherNames[j])) + 1;
                        teacherNums.set(teacherList.indexOf(teacherNames[j]), z);
                    }
                }
            }

            System.out.println("Teacher chances: ");
            for(int k = 0; k<teacherList.size(); k++) {
                System.out.println(teacherList.get(k) + ": " + calculateChances(teacherNums.get(k),schedules.size()));
            }




        }
    }

    public static String calculateChances(int numerator, int denominator) {
        double result = 100.0*numerator;
        result = result/denominator;
        return "" + result + "%";
    }
}
