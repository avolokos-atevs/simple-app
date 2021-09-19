package com.example.simpleapp.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class SimplePojo {
    private List<String> strings;
}
