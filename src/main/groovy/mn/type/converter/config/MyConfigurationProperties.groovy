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

import java.time.LocalDate

import groovy.transform.CompileStatic
import io.micronaut.context.annotation.ConfigurationProperties

@CompileStatic
@ConfigurationProperties(MyConfigurationProperties.PREFIX)
class MyConfigurationProperties {
    public static final String PREFIX = "myapp"
    protected LocalDate updatedAt

    LocalDate getUpdatedAt() {
        return this.updatedAt
    }
}
