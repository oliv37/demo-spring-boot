package fr.tnframework.core.service;

import fr.tnframework.core.model.LineDTO;

import java.util.Arrays;
import java.util.List;

public class LineService {

    public List<LineDTO> getLines() {
        return Arrays.asList(
          new LineDTO("RERA"), new LineDTO("RERB")
        );
    }
}
