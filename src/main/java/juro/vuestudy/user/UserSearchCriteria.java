package juro.vuestudy.user;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class UserSearchCriteria {
    private int page;
    private int size;
    private SearchType searchType;
    private String query;
    private UserRole role;
    private LocalDateTime startAt;
    private LocalDateTime endAt;
}
