package kg.alatoo.kettikproject.dto;

import lombok.Data;

@Data
public class GuideDTO {
    private Long id;
    private String name;
    private String specialization;
    private String language;
    private int rating;
}
