package juro.vuestudy.user;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

class UserServiceTest {

    UserService userService = new UserService();

    @BeforeEach
    public void beforeEach() {
        userService.initUser();
    }

    @AfterEach
    public void afterEach() {
        userService.deleteAll();
    }

    @Test
    void list() {
        UserSearchCriteria criteria = UserSearchCriteria.builder()
                .searchType(SearchType.NAME)
                .query("D")
                .page(0L)
                .size(20L)
                .role(UserRole.ADMIN)
                .startAt(LocalDate.now().minusDays(10L))
                .endAt(LocalDate.now())
                .build();
        List<User> users = userService.userList(criteria);

        Assertions.assertThat(users.size()).isNotEqualTo(0);
    }

    @Test
    void getUser() {
        User user = userService.getUser(1L);

        Assertions.assertThat(user).isNotNull();
    }

    @Test
    void setUser() {
        Long id = 50L;
        User updatedUser = User.builder()
                .id(id)
                .name("hello")
                .build();

        userService.updateUser(updatedUser);
        User user = userService.getUser(id);

        Assertions.assertThat(user.getId()).isEqualTo(id);
        Assertions.assertThat(user.getName()).isEqualTo("hello");
    }

    @Test
    void deleteUser() {
        User user = userService.getUser(1L);
        userService.deleteUser(1L);
        User deletedUser = userService.getUser(1L);

        Assertions.assertThat(user).isNotNull();
        Assertions.assertThat(deletedUser).isNull();
    }
}