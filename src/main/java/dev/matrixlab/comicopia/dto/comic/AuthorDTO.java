package dev.matrixlab.comicopia.dto.comic;

import lombok.Data;

import java.io.Serializable;

@Data
public class AuthorDTO implements Serializable {

    private static final long serialVersionUID = 7293117865500668868L;

    private Integer id;

    private String name;

    private String bio;

    private String avatar;

}
