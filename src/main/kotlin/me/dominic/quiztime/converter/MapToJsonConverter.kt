package me.dominic.quiztime.converter

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import jakarta.persistence.AttributeConverter
import jakarta.persistence.Converter

@Converter
class MapToJsonConverter : AttributeConverter<Map<String, Boolean>, String> {

    private val objectMapper = jacksonObjectMapper()

    override fun convertToDatabaseColumn(attribute: Map<String, Boolean>?): String? {
        return objectMapper.writeValueAsString(attribute)
    }

    override fun convertToEntityAttribute(dbData: String?): Map<String, Boolean>? {
        return if (dbData != null) {
            objectMapper.readValue(dbData, Map::class.java) as Map<String, Boolean>
        } else {
            emptyMap()
        }
    }
}
