package com.codegym.update_music.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class MusicDto {

    private int id;
    @NotEmpty(message = "Không được phép để trống")
    @Size(max = 800,message = "Không vượt quá 800 ký tự")
    @Pattern(regexp = "^([\\w]*[\\s]*[\\w]*)+$",message = "Không chứa các kí tự đặc biệt như @ ; , . = - + , ….")
    private String name;

    @NotEmpty(message = "Không được phép để trống")
    @Size(max = 300 ,message = "Không vượt quá 300 ký tự"  )
    @Pattern(regexp = "^([\\w]*[\\s]*[\\w]*)+$",message = "Không chứa các kí tự đặc biệt như @ ; , . = - + , ….")
    private String artist;

    @NotEmpty(message = "Không được phép để trống")
    @Size(max = 1000 ,message = "Không vượt quá 1000 ký tự"  )
    @Pattern(regexp = "^([\\w]*[\\s]*[\\w]*[,]*)+$",message = "Kí hiệu chỉ là dấu phẩy")
    private String kindOfMusic;
    private String file;

    public MusicDto() {
    }


    public MusicDto(int id, String name, String artist, String kindOfMusic, String file) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.kindOfMusic = kindOfMusic;
        this.file = file;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getKindOfMusic() {
        return kindOfMusic;
    }

    public void setKindOfMusic(String kindOfMusic) {
        this.kindOfMusic = kindOfMusic;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }


}
