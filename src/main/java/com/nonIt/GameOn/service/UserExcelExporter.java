package com.nonIt.GameOn.service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import com.nonIt.GameOn.entity.UserRoleAssignment;
import com.nonIt.GameOn.service.restDto.UserRestDto;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class UserExcelExporter {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<UserRestDto> listUsers;

    //The Exporter will accept a list of your choice
    public UserExcelExporter(List<UserRestDto> listUsers) {
        this.listUsers = listUsers;
        workbook = new XSSFWorkbook();
    }

    private void writeHeaderLine() {
        sheet = workbook.createSheet("Users");

        Row row = sheet.createRow(0);

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);

        //Define how many columns you want to have, with the columns' name
        createCell(row, 0, "ID", style);
        createCell(row, 1, "E-mail", style);
        createCell(row, 2, "Username", style);
        createCell(row, 3, "Roles", style);
        createCell(row, 4, "Active", style);

    }

    private void createCell(Row row, int columnCount, Object valueOfCell, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (valueOfCell instanceof Integer) {
            cell.setCellValue((Integer) valueOfCell);
        } else if (valueOfCell instanceof Long) {
            cell.setCellValue((Long) valueOfCell);
        } else if (valueOfCell instanceof String) {
            cell.setCellValue((String) valueOfCell);
        } else {
            cell.setCellValue((Boolean) valueOfCell);
        }
        cell.setCellStyle(style);
    }

    private void writeDataLines() {
        int rowCount = 1;

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);

        //Create row equivalent to each record in listUsers
        for (UserRestDto userRestDto : listUsers) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;

            createCell(row, columnCount++, userRestDto.getId(), style);
            createCell(row, columnCount++, userRestDto.getEmail(), style);
            createCell(row, columnCount++, userRestDto.getUsername(), style);
            createCell(row, columnCount++, userRestDto.getRoles().stream()
                    .map(UserRoleAssignment::getRole).reduce("", (end, ele)-> end + ele + "\n", String::concat), style);
            createCell(row, columnCount++, userRestDto.isActive(), style);
        }
    }

    public void export(HttpServletResponse response) throws IOException {
        writeHeaderLine();
        writeDataLines();

        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();

        outputStream.close();
    }
}
