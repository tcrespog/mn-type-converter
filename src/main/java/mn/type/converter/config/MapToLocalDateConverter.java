package mn.type.converter.config;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;
import javax.inject.Singleton;

import io.micronaut.core.convert.ConversionContext;
import io.micronaut.core.convert.ConversionService;
import io.micronaut.core.convert.TypeConverter;

@Singleton
public class MapToLocalDateConverter implements TypeConverter<Map, LocalDate> {
    @Override
    public Optional<LocalDate> convert(Map propertyMap, Class<LocalDate> targetType, ConversionContext context) {
        Optional<Integer> day = ConversionService.SHARED.convert(propertyMap.get("day"), Integer.class);
        Optional<Integer> month = ConversionService.SHARED.convert(propertyMap.get("month"), Integer.class);
        Optional<Integer> year = ConversionService.SHARED.convert(propertyMap.get("year"), Integer.class);
        if (day.isPresent() && month.isPresent() && year.isPresent()) {
            try {
                return Optional.of(LocalDate.of(year.get(), month.get(), day.get()));
            } catch (DateTimeException e) {
                context.reject(propertyMap, e);
                return Optional.empty();
            }

        }

        return Optional.empty();
    }

}
