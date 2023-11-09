package models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.awt.Image;
import java.util.Date;
import java.util.UUID;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class News {
    @JsonProperty("uuid")
    private UUID uuid;
    @JsonProperty("category")
    private Category category;
    @JsonProperty("title")
    private String title;
    @JsonProperty("text")
    private String text;
    @JsonProperty("image")
    private Image image;
    @JsonProperty("date")
    private Date date;

    public News(UUID uuid, Category category, String title, String text, Image image, Date date) {
        this.uuid = uuid;
        this.category = category;
        this.title = title;
        this.text = text;
        this.image = image;
        this.date = date;
    }
}
