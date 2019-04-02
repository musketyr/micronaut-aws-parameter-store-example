package parameter.store.reader

import io.micronaut.function.client.FunctionClient
import io.reactivex.Single

import javax.inject.Named

@FunctionClient
interface ParameterStoreReaderClient {

    @Named("parameter-store-reader")
    Single<String> parameterStoreReader()
}
