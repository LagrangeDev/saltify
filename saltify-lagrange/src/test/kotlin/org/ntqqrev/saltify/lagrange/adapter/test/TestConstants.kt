package org.ntqqrev.saltify.lagrange.adapter.test

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Dispatchers
import org.ntqqrev.saltify.api.Environment
import kotlin.io.path.Path

val testEnv = object : Environment {
    override val parentCoroutineContext = Dispatchers.IO + CoroutineName("AdapterTest")
    override val rootDataPath = Path("data")
}