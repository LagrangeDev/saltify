package org.ntqqrev.saltify.api

import kotlinx.io.files.Path
import kotlin.coroutines.CoroutineContext

interface Environment {
    /**
     * The parent coroutine context of this environment.
     */
    val parentCoroutineContext: CoroutineContext

    /**
     * The path to the root data directory.
     */
    val rootDataPath: Path
}