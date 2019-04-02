package parameter.store.reader

import com.fasterxml.jackson.databind.ObjectMapper
import groovy.transform.Field
import io.micronaut.context.ApplicationContext
import io.micronaut.context.annotation.Property

import javax.inject.Inject

@Property(name = 'shared.parameter') @Field Optional<String> sharedParameter
@Property(name = 'os.version') @Field String osVersion
@Inject @Field ApplicationContext context
@Inject @Field ObjectMapper mapper

String parameterStoreReader() {

    println mapper.writeValueAsString(context.environment.propertySources.collect { source ->
        [(source.name): source.asCollection().collectEntries { [it, source.get(it)] }]
    })

    println "shared.parameter: ${context.environment.getProperty('shared.parameter', String).orElse("not set")}"
    println "os.version: ${osVersion}"

    sharedParameter.orElse("not set")
}