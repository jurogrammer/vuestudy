package juro.vuestudy.user;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Predicate;

@Service
public class UserService {
    private static final AtomicLong atomicLong = new AtomicLong();
    private static final Map<Long, User> userMap = new ConcurrentHashMap<>();
    private static final Random random = new Random();

    @PostConstruct
    public void initUser() {
        for (long i = 0; i < 100; i++) {
            LocalDateTime day = LocalDateTime.now().minusDays(random.nextInt(30));
            User user = User.builder()
                    .id(atomicLong.incrementAndGet())
                    .name(getRandomName())
                    .phoneNumber(randomPhoneNumber())
                    .userRole(random.nextBoolean() ? UserRole.ADMIN : UserRole.NORMAL)
                    .createdAt(day)
                    .updatedAt(day)
                    .build();

            userMap.put(user.getId(), user);
        }
    }

    private String getRandomName() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            char a = (char) random.nextInt(68, 80);
            sb.append(a);
        }
        return sb.toString();
    }

    public List<User> userList(UserSearchCriteria criteria) {
        return userMap.values().stream()
                .skip((long) criteria.getPage() * criteria.getSize())
                .filter(user -> criteria.getRole() == null || user.getUserRole() == criteria.getRole())
                .filter(user -> criteria.getQuery() == null || criteria.getSearchType().getKeyExtractor().apply(user).contains(criteria.getQuery()))
                .filter(user -> criteria.getStartAt() == null || user.getCreatedAt().isAfter(criteria.getStartAt()))
                .filter(user -> criteria.getEndAt() == null || user.getCreatedAt().isBefore(criteria.getEndAt()))
                .limit(criteria.getSize())
                .toList();
    }

    private Predicate<UserSearchCriteria> isBlank() {
        return criteria -> (criteria == null) || criteria.getQuery().isBlank();
    }

    public User getUser(Long id) {
        return userMap.get(id);
    }

    public void createUser(User user) {
        long id = atomicLong.incrementAndGet();
        user.setId(id);
        userMap.put(id, user);
    }

    public void updateUser(User user) {
        User originUser = userMap.get(user.getId());
        originUser.setUserRole(user.getUserRole());
        originUser.setName(user.getName());
        originUser.setPhoneNumber(user.getPhoneNumber());
        originUser.setCreatedAt(user.getCreatedAt());
        originUser.setUpdatedAt(LocalDateTime.now());

        userMap.put(originUser.getId(), originUser);
    }

    public void deleteUser(Long id) {
        userMap.remove(id);

    }

    public void deleteAll() {
        userMap.clear();
        atomicLong.set(0L);
    }

    private String randomPhoneNumber() {
        StringBuilder phoneNumber = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            phoneNumber.append(random.nextInt(10));
        }
        return phoneNumber.toString();
    }
}
