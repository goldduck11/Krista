package models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

    @Getter
    @Setter
    @AllArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Entity
    @Table(name = "News")
    public class News implements Serializable {
        @JsonProperty("uuid")
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Type(type = "objectid")
        @Column(name = "uuid", unique = true, nullable = false)
        private UUID uuid;

        @JsonProperty("categories")
        @OneToMany(mappedBy = "news", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
        private List<Category> categories;

        @JsonProperty("title")
        @Column(name = "title")
        private String title;

        @JsonProperty("text")
        @Column(name = "text")
        private String text;

        @JsonProperty("date")
        @Column(name = "date")
        private Date date;
    }

