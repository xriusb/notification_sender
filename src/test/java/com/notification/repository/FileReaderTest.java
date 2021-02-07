package com.notification.repository;

import com.notification.model.Employee;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class FileReaderTest {

    private FileReader testee;

    @Before
    public void setup() {
        String filePath = "/Users/xavier/Projects/notification_sender/src/test/resources/testEmployees.txt";

        testee = new FileReader(filePath);
    }

    @Test
    public void givenEmployeesFile_ThenReturnCorrectObjects() {

        Employee result = testee.getEmployees().iterator().next();

        assertEquals("John", result.getFirstName());
        assertEquals("Doe", result.getLastName());
        assertEquals(LocalDate.parse("1982-10-08"), result.getBirthDate());
        assertEquals("john.doe@foobar.com", result.getEmail());
    }

    @Test
    public void givenEmployeesFile_ThenReturnCorrectNumberOfThem() {

        assertEquals(3, testee.getEmployees().size());
    }
}