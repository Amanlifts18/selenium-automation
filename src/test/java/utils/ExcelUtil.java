package utils;

import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.io.FileInputStream;

public class ExcelUtil {

    public static Object[][] getData() {
        Object[][] data = new Object[3][3];

        try {
            FileInputStream fis = new FileInputStream(
                    new File("src/test/resources/testdata.xlsx"));
            Workbook wb = WorkbookFactory.create(fis);
            Sheet sheet = wb.getSheetAt(0);

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                data[i-1][0] = row.getCell(0).toString();
                data[i-1][1] = row.getCell(1).toString();
                data[i-1][2] = row.getCell(2).toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}
