package models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.*;
import java.util.UUID;

@Getter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "Category")
public class Category {

    @ManyToOne
    @JoinColumn(name = "news_uuid")
    private News news;

    @JsonProperty("uuid")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "uuid", unique = true, nullable = false)
    private UUID uuid;

    @JsonProperty("text")
    @Column(name = "text")
    private String text;
}

