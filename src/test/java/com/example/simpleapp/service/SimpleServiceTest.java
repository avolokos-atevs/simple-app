package com.example.simpleapp.service;

import com.example.simpleapp.domain.SimplePojo;
import com.example.simpleapp.exceptions.EmptyStorageException;
import com.example.simpleapp.exceptions.StringNotFoundException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@SpringBootTest
class SimpleServiceTest {

    @Autowired
    private SimpleService simpleService;

    private List<String> strings = new ArrayList<>();

    @BeforeEach
    void setUp() {
        strings.add("1");
        strings.add("2");
        strings.add("3");
    }

    @AfterEach
    void tearDown() {
        strings.clear();
    }

    @Test
    void whenAddStringArrayToMemory_thenUpdateStringsList() {
        List<String> testStrings = List.of("1", "2", "3", "4");
        SimplePojo objects = new SimplePojo();
        objects.setStrings(testStrings);

        simpleService.addStringArrayToMemory(objects);
        List<String> result = simpleService.getAll();

        assertFalse(result.isEmpty());
        assertEquals(testStrings.size(), result.size());
    }

    @Test
    void whenGetCount_thenReturnListSize() {
        simpleService.setStrings(strings);

        int result = simpleService.getCount();

        assertEquals(strings.size(), result);
    }

    @Test
    void whenGetCountInEmptyList_thenThrowEmptyStorageException() {
        assertThrows(EmptyStorageException.class, () -> simpleService.getCount());
    }

    @Test
    void whenGetListByString_thenReturnListOfStrings() {
        simpleService.setStrings(strings);

        List<String> result = simpleService.getListByString("1");

        assertEquals(List.of("1"), result);

    }

    @Test
    void whenGetListByWrongString_thenStringNotFoundException() {
        assertThrows(StringNotFoundException.class, () -> simpleService.getListByString("1"));
    }

    @Test
    void whenGetAll_thenReturnElementsInListOfStrings() {
        simpleService.setStrings(strings);

        List<String> result = simpleService.getAll();

        assertFalse(result.isEmpty());
        assertEquals(strings.size(), result.size());
    }

    @Test
    void whenGetAllInEmptyList_thenThrowEmptyStorageException() {
        assertThrows(EmptyStorageException.class, () -> simpleService.getAll());
    }
}