package com.labs.com.labs.common;

import com.google.common.collect.Maps;

import java.util.EnumSet;
import java.util.Map;

/**
 * @author sla.
 */
public enum Messages {

    user_exists(Keys.USER_EXISTS, "The user exists"),
    missing_required_parameters(Keys.MISSING_REQUIRED_PARAMETER, "Missing required parameter.");

    private static final Map<String, Messages> lookup = Maps.newConcurrentMap();

    static {
        EnumSet.allOf(Messages.class).forEach(s -> lookup.put(s.getKey(), s));
    }

    private String key;
    private String description;

    Messages(String key, String description) {
        this.key = key;
        this.description = description;
    }

    public static String getDescription(String key) {
        return lookup.getOrDefault(key, missing_required_parameters).getDescription();
    }

    public String getKey() {
        return key;
    }

    public String getDescription() {
        return description;
    }

    public static class Keys {

        public static final String USER_EXISTS = "users.exists";
        public static final String MISSING_REQUIRED_PARAMETER = "missing.required.parameter";

    }
}
