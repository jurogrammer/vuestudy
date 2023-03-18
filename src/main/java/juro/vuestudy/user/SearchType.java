package juro.vuestudy.user;

import lombok.Generated;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.function.Function;

@Getter
@RequiredArgsConstructor
public enum SearchType {
    NAME(User::getName),
    PHONE(User::getPhoneNumber);

    private final Function<User, String> keyExtractor;


}
