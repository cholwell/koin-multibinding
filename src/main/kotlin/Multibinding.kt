package cholwell.dev.koin_multibinding

import org.koin.core.definition.Definition
import org.koin.core.module.Module
import org.koin.core.parameter.parametersOf
import org.koin.core.qualifier.Qualifier
import org.koin.core.scope.Scope

fun <T> Module.set(qualifier: Qualifier) = single(qualifier) {
    mutableSetOf<T>()
}

fun <T> Scope.getSet(qualifier: Qualifier) = get<MutableSet<T>>(qualifier)

fun <T> Module.intoSet(
    setQualifier: Qualifier, valueQualifier: Qualifier, definition: Definition<T>
) {
    single(valueQualifier, true) {
        getSet<T>(setQualifier).add(definition(this, parametersOf()))
        definition
    }
}
