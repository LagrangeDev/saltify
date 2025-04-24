package org.ntqqrev.saltify.lagrange.test

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Dispatchers
import org.ntqqrev.saltify.lagrange.util.UrlSignProvider
import java.nio.file.Path
import kotlin.io.path.Path

val signApiUrl = "https://sign.lagrangecore.org/api/sign/30366"
val urlSignProvider = UrlSignProvider(signApiUrl)
val dataPath = Path("data")
val keystorePath: Path = dataPath.resolve("keystore.json")

val testContext = Dispatchers.IO + CoroutineName("CoreTest")