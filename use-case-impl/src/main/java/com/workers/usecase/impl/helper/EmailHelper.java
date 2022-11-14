package com.workers.usecase.impl.helper;

import org.springframework.util.StringUtils;

public class EmailHelper {

    public static final boolean checkEmailIsValid(String email) {
        return StringUtils.hasText(email);
    }
}
