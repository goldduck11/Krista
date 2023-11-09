package models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.UUID;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Category {
    @JsonProperty("uuid")
    private UUID uuid;
    @JsonProperty("name")
    private String name;

    public Category(UUID uuid, String name) {
        this.uuid = uuid;
        this.name = name;
    }
}
