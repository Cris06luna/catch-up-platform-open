package com.acme.catchup.platform.news.domain.model.valueobjects;

import java.util.regex.Pattern;

public record SourceId(String Value) {
    private static final int MAX_LENGTH = 256;
    private static final Pattern ALLOWED_PATTERN = Pattern.compile("^[a-zA-Z0-9]+$");
    private static final String NOT_BLANK_MESSAGE_KEY = "favourite.source.error.sourceId.notBlank";
    private static final String SIZE_MESSAGE_KEY = "favourite.source.error.sourceId.size";
    private static final String PATTERN_MESSAGE_KEY = "favourite.source.error.sourceId.pattern";

    public SourceId {
        if (Value == null || Value.isBlank()) {
            throw new IllegalArgumentException(NOT_BLANK_MESSAGE_KEY);
        }
        if (Value.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(SIZE_MESSAGE_KEY);
        }
        if (!ALLOWED_PATTERN.matcher(Value).matches()) {
            throw new IllegalArgumentException(PATTERN_MESSAGE_KEY);
        }
    }

    public String value() {
        return Value;
    }
}
