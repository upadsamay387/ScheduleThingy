
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
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
        ArrayList<schedule> schedules = new ArrayList<schedule>();
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
                classPeriod x = new classPeriod(row.getCell(0).toString(),row.getCell(1).toString(),Integer.parseInt(row.getCell(4).toString()),row.getCell(8).toString(),row.getCell(10).toString(),Integer.parseInt(row.getCell(11).toString()));

                switch(x.period) {
                    case 1: period1.add(x); break;
                    case 2: period1.add(x); break;
                    case 3: period1.add(x); break;
                    case 4: period1.add(x); break;
                    case 5: period1.add(x); break;
                    case 6: period1.add(x); break;
                    case 7: period1.add(x); break;
                }
            }
        }


    }



}
