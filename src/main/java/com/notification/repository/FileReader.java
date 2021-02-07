package com.notification.repository;

import com.notification.model.Employee;
import lombok.AllArgsConstructor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@AllArgsConstructor
public class FileReader implements EmployeeRepository {

    private final String filePath;

    @Override
    public List<Employee> getEmployees() {
        List<Employee> employees = null;
        try (Stream<String> fileStream = Files.lines(Paths.get(filePath))) {

            employees = fileStream
                    .filter(line -> !line.startsWith("last_name"))
                    .map(employee -> {
                        String[] names = employee.split(", ");
                        LocalDate birthDate = LocalDate.parse(names[2], DateTimeFormatter.ofPattern("yyyy/MM/dd"));
                        return new Employee(names[1], names[0], birthDate, names[3]);
                    }).collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return employees;
    }
}
