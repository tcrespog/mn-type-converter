package mn.type.converter

import javax.inject.Inject

import io.micronaut.test.extensions.spock.annotation.MicronautTest
import mn.type.converter.config.MyConfigurationProperties
import spock.lang.*

@MicronautTest
class MnTypeConverterSpec extends Specification {

    @Inject
    MyConfigurationProperties config

    void 'the config properties are read'() {
        expect:
        config.updatedAt
    }

}
