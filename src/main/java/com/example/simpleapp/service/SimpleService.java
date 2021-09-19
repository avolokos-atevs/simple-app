package com.example.simpleapp.service;

import com.example.simpleapp.domain.SimplePojo;
import com.example.simpleapp.exceptions.EmptyStorageException;
import com.example.simpleapp.exceptions.StringNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class SimpleService {
    private List<String> strings = new ArrayList<>();

    public void addStringArrayToMemory(SimplePojo objects) {
        log.info("Started: addStringArrayToMemory() with elements " + objects.getStrings());
        strings.addAll(objects.getStrings());
        log.info("Finished: addStringArrayToMemory() with elements " + objects.getStrings());
    }

    public Integer getCount() {
        if (strings.isEmpty()) {
            throw new EmptyStorageException("Array is empty, add something first!");
        }
        return strings.size();
    }

    public List<String> getListByString(String searchString) {
        if (!strings.contains(searchString)) {
            throw new StringNotFoundException("Array doesn't contains this element!");
        }
        return strings.stream().filter(s -> s.equals(searchString)).collect(Collectors.toList());
    }

    public List<String> getAll() {
        if (strings.isEmpty()) {
            throw new EmptyStorageException("Array is empty, add something first!");
        }
        return strings;
    }

    public void setStrings(List<String> strings) {
        this.strings = strings;
    }
}
