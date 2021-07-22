package com.example.jsonex2.service;

import com.example.jsonex2.model.entity.Part;

import java.io.IOException;
import java.util.Set;

public interface PartService {

    void seedParts() throws IOException;

    Set<Part> findRandomParts();
}
