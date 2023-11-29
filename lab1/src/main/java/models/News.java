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

    @AllArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Entity
    @Table(name = "News")
    public class News implements Serializable {
        @JsonProperty("uuid")
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Type(type = "uuid")
        @Column(name = "uuid", unique = true, nullable = false)
        private UUID uuid;

        @Type(type = "categories")
        @JsonProperty("categories")
        @OneToMany(mappedBy = "news", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
        private List<Category> categories;

        @Type(type = "title")
        @JsonProperty("title")
        @Column(name = "title")
        private String title;

        @Type(type = "news")
        @JsonProperty("text")
        @Column(name = "text")
        private String text;

        @Type(type = "date")
        @JsonProperty("date")
        @Column(name = "date")
        private Date date;

        public UUID getUuid() {
            return uuid;
        }

        public void setCategories(List<Category> categories) {
            this.categories = categories;
        }

        public List<Category> getCategories() {
            return categories;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public Date getDate() {
            return date;
        }
    }

