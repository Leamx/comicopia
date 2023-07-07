package dev.matrixlab.comicopia.dto.comic;

import lombok.Data;

import java.io.Serializable;

@Data
public class CategoryDTO implements Serializable {

    private static final long serialVersionUID = -8943014728554008L;

    private Integer id;

    private String name;

    private String description;

}
