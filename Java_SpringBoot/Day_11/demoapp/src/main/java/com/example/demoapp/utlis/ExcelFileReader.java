package com.example.demoapp.utlis;

import com.example.demoapp.model.Book;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component // su dung thu vien Apache POI
public class ExcelFileReader implements IFileReader {
    @Override
    public List<Book> readFile(String path) {
        List<Book> books = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(new File(path));
             Workbook workbook = WorkbookFactory.create(fis)) {

            Sheet sheet = workbook.getSheetAt(0); // Lấy sheet đầu tiên

            for (Row row : sheet) {
                if (row.getRowNum() == 0) {
                    continue; // Bỏ qua hàng tiêu đề
                }

                Book book = Book.builder()
                        .id((int) getCellValueAsNumeric(row.getCell(0)))
                        .title(getCellValueAsString(row.getCell(1)))
                        .author(getCellValueAsString(row.getCell(2)))
                        .year((int) getCellValueAsNumeric(row.getCell(3)))
                        .build();

                books.add(book);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return books;
    }
    // Xử lý các loại ô có kiểu dữ liệu là chuỗi/số trả về giá trị dưới dạng chuỗi
    private String getCellValueAsString(Cell cell) {
        if (cell == null) {
            return "";
        }
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return String.valueOf(cell.getNumericCellValue());
            default:
                return "";
        }
    }

    // Xử lý các loại ô có kiểu dữ liệu là số/chuỗi trả về giá trị dưới dạng số
    private double getCellValueAsNumeric(Cell cell) {
        if (cell == null) {
            return 0;
        }
        switch (cell.getCellType()) {
            case NUMERIC:
                return cell.getNumericCellValue();
            case STRING:
                try {
                    return Double.parseDouble(cell.getStringCellValue());
                } catch (NumberFormatException e) {
                    return 0;
                }
            default:
                return 0;
        }
    }
}
