
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Main {

    public static void main(String[] args) throws IOException {

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

        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);

        Scanner input = new Scanner(System.in);

        System.out.print("Input 7 class codes in a comma separated list (e.g. AB123, AB223)");
        courses = new ArrayList<String>(Arrays.asList(input.nextLine().replace(" ","").split(",")));
        //System.out.print(courses);

        Iterator<Row> rowIterator = sheet.iterator();

        //goes through every row and adds all matching course IDs to ArrayLists for each eligible period
        while(rowIterator.hasNext()) {
            Row row = rowIterator.next();

            if(courses.contains(row.getCell(0).toString())) {
                classPeriod x = new classPeriod(row.getCell(0).toString(),row.getCell(1).toString(),(int) Double.parseDouble(row.getCell(4).toString()),row.getCell(8).toString(),row.getCell(10).toString(),(int) Double.parseDouble(row.getCell(11).toString()));

                switch(x.period) {
                    case 1: period1.add(x); break;
                    case 2: period2.add(x); break;
                    case 3: period3.add(x); break;
                    case 4: period4.add(x); break;
                    case 5: period5.add(x); break;
                    case 6: period6.add(x); break;
                    case 7: period7.add(x); break;
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

        for(int k = 0; k<schedules.size(); k++) {
            System.out.println("Schedule " + k);
            System.out.println(schedules.get(k));
        }
    }
}
