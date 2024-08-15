package com.example.demoapp.utlis;

import com.example.demoapp.model.Book;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

@Component // su dung thu vien OpenCSV
public class CSVFileReader implements IFileReader{
    @Override
    public List<Book> readFile(String path) {

        try (Reader reader = new FileReader(path)) {
            CsvToBean<Book> csvToBean = new CsvToBeanBuilder<Book>(reader)
                    .withType(Book.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            return csvToBean.parse();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return List.of(); // Trả về danh sách rỗng nếu có lỗi xảy ra
    }
}
