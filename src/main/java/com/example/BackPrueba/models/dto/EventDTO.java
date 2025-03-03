package com.example.BackPrueba.models.dto;

public class EventDTO {
        private Long id;
        private String title;
        private String date;
        private String description;
        private String location;

        public EventDTO() {}

        public EventDTO(Long id, String title, String date, String description, String location) {
                this.id = id;
                this.title = title;
                this.date = date;
                this.description = description;
                this.location = location;
        }

        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }

        public String getTitle() { return title; }
        public void setTitle(String title) { this.title = title; }

        public String getDate() { return date; }
        public void setDate(String date) { this.date = date; }

        public String getDescription() { return description; }
        public void setDescription(String description) { this.description = description; }

        public String getLocation() { return location; }
        public void setLocation(String location) { this.location = location; }
}
