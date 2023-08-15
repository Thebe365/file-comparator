package CsvFileReader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CsvFileReader {

    public static List<String> readFile(String fileName, List<String> ignoreList){

        List<String> columns = new ArrayList<>();
        List<String> records = new ArrayList<>();


        BufferedReader reader = null;
        try {
            reader = Files.newBufferedReader(Paths.get(fileName));
            CSVParser parser = new CSVParser(reader, CSVFormat.DEFAULT
                    .withHeader()
                    .withDelimiter(',')
                    .withSkipHeaderRecord());

            columns = parser.getHeaderNames();

            List<String> newColumns = columns.stream()
                    .filter(item -> !ignoreList.contains(item))
                    .collect(Collectors.toList());


            for(CSVRecord rec: parser){

                String recordBuilder = "";
                for(String column: newColumns){
                    recordBuilder += rec.get(column) + ",";
                }

                recordBuilder = recordBuilder.substring(0, recordBuilder.length() - 1);
                System.out.println(recordBuilder);
                records.add(recordBuilder);
            }
            return records;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void compareFiles(List<String> file1, List<String> file2){

        List<String> report = new ArrayList<>();

        report = file1.stream()
                .filter(item -> !file2.contains(item))
                .collect(Collectors.toList());

        for(String rec: report){
            System.out.println(rec);
        }

        System.out.println("\nRecord count: " + report.size());
    }
}
