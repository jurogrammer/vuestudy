package juro.vuestudy.user;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class UserSearchCriteria {
    private Long page;
    private Long size;
    private SearchType searchType;
    private String query;
    private UserRole role;
    private LocalDateTime startAt;
    private LocalDateTime endAt;
}
