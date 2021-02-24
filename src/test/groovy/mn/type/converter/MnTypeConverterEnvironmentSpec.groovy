package mn.type.converter

import java.time.LocalDate
import javax.inject.Inject

import io.micronaut.context.ApplicationContext
import mn.type.converter.config.MyConfigurationProperties
import spock.lang.*

class MnTypeConverterEnvironmentSpec extends Specification {

    @AutoCleanup
    @Shared
    ApplicationContext ctx = ApplicationContext.run(
            'myapp'
    )

    @Inject
    MyConfigurationProperties config

    void 'the config properties are read'() {
        when:
        MyConfigurationProperties props = ctx.getBean(MyConfigurationProperties)

        then:
        props.updatedAt == LocalDate.of(1982, 10, 28)
    }

}
