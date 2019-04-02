package parameter.store.reader

import io.micronaut.context.ApplicationContext
import io.micronaut.test.annotation.MicronautTest
import io.micronaut.runtime.server.EmbeddedServer
import spock.lang.Specification
import javax.inject.Inject

@MicronautTest
class ParameterStoreReaderFunctionSpec extends Specification {

    @Inject
    ParameterStoreReaderClient client


    void "test parameter-store-reader function"() {
        expect:
        client.parameterStoreReader().blockingGet() == "parameter-store-reader"
    }
}
