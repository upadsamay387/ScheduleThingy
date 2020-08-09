import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.IOException;
import java.util.ArrayList;


public class FXController {

    static ArrayList<String> courses = new ArrayList<String>();
    static String[] teacherNames = new String[7];
    static boolean[] periodOverride = new boolean[7];

    @FXML
    private Font x1;

    @FXML
    private Color x2;

    @FXML
    private TextField firstClass;

    @FXML
    private TextField secondClass;

    @FXML
    private TextField thirdClass;

    @FXML
    private TextField fourthClass;

    @FXML
    private TextField fifthClass;

    @FXML
    private TextField sixthClass;

    @FXML
    private TextField seventhClass;

    @FXML
    private CheckBox firstPeriodCheck;

    @FXML
    private CheckBox secondPeriodCheck;

    @FXML
    private CheckBox thirdPeriodCheck;

    @FXML
    private CheckBox fourthPeriodCheck;

    @FXML
    private CheckBox fifthPeriodCheck;

    @FXML
    private CheckBox sixthPeriodCheck;

    @FXML
    private CheckBox seventhPeriodCheck;

    @FXML
    private TextField firstName1;

    @FXML
    private TextField secondName1;

    @FXML
    private TextField thirdName1;

    @FXML
    private TextField fourthName1;

    @FXML
    private TextField fifthName1;

    @FXML
    private TextField sixthName1;

    @FXML
    private TextField seventhName1;

    @FXML
    private TextField firstName2;

    @FXML
    private TextField secondName2;

    @FXML
    private TextField thirdName2;

    @FXML
    private TextField fourthName2;

    @FXML
    private TextField fifthName2;

    @FXML
    private TextField sixthName2;

    @FXML
    private TextField seventhName2;

    @FXML
    private Button submitButton;

    @FXML
    private Font x3;

    @FXML
    private Color x4;

    @FXML
    void submitInfo(MouseEvent event) throws IOException {
        TextField[] coursesField = {firstClass, secondClass, thirdClass, fourthClass, fifthClass, sixthClass, seventhClass};
        TextField[] lastNamesField = {firstName1, secondName1, thirdName1, fourthName1, fifthName1, sixthName1, seventhName1};
        TextField[] firstNamesField = {firstName2, secondName2, thirdName2, fourthName2, fifthName2, sixthName2, seventhName2};
        CheckBox[] periodOverrideField = {firstPeriodCheck, secondPeriodCheck, thirdPeriodCheck, fourthPeriodCheck, fifthPeriodCheck, sixthPeriodCheck, seventhPeriodCheck};

        courses = new ArrayList<String>();

        for(int k = 0; k<7; k++) {
            courses.add(coursesField[k].getText());
            //System.out.println(courses.get(k));
            periodOverride[k] = periodOverrideField[k].isSelected();

            teacherNames[k] = lastNamesField[k].getText().toUpperCase() + ", " + firstNamesField[k].getText().toUpperCase();
            if(teacherNames[k].trim().equals(","))
                teacherNames[k] = "";
            //System.out.println(teacherNames[k]);
        }

        Main.run();
    }

}
