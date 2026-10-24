package com.acme.catchup.platform.news.infrastructure.persistence.jpa.converters;

import jakarta.persistence.AttributeConverter;
import com.acme.catchup.platform.news.domain.model.valueobjects.NewsApiKey;
import jakarta.persistence.Converter;

@Converter
public class NewsApiKeyAttributeConvert implements AttributeConverter<NewsApiKey, String> {
    @Override
    public String convertToDatabaseColumn(NewsApiKey attribute) {
        return attribute == null ? null : attribute.value();
    }

    @Override
    public NewsApiKey convertToEntityAttribute(String dbData) {
        return dbData != null ? new NewsApiKey(dbData) : null;
    }
}
