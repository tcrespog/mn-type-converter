/*
 * Copyright (c) 2019-2020, Seqera Labs.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 *
 * This Source Code Form is "Incompatible With Secondary Licenses", as
 * defined by the Mozilla Public License, v. 2.0.
 */

package mn.type.converter.config

import groovy.transform.CompileStatic
import io.micronaut.core.convert.ConversionContext
import io.micronaut.core.convert.ConversionService
import io.micronaut.core.convert.TypeConverter

import javax.inject.Singleton
import java.time.DateTimeException
import java.time.LocalDate

@Singleton
@CompileStatic
class MapToLocalDateConverter implements TypeConverter<Map, LocalDate> {
    @Override
    Optional<LocalDate> convert(Map propertyMap, Class<LocalDate> targetType, ConversionContext context) {
        Optional<Integer> day = ConversionService.SHARED.convert(propertyMap.get("day"), Integer.class)
        Optional<Integer> month = ConversionService.SHARED.convert(propertyMap.get("month"), Integer.class)
        Optional<Integer> year = ConversionService.SHARED.convert(propertyMap.get("year"), Integer.class)
        if (day.isPresent() && month.isPresent() && year.isPresent()) {
            try {
                return Optional.of(LocalDate.of(year.get(), month.get(), day.get()))
            } catch (DateTimeException e) {
                context.reject(propertyMap, e)
                return Optional.empty()
            }
        }
        return Optional.empty()
    }
}