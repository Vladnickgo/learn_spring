package org.example.repository.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Tag {
    private final Integer id;
    private final String name;
}
