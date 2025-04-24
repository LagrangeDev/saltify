package org.ntqqrev.saltify.core.test

import org.ntqqrev.saltify.core.util.UrlSignProvider
import java.nio.file.Path
import kotlin.io.path.Path

val signApiUrl = "https://sign.lagrangecore.org/api/sign/30366"
val urlSignProvider = UrlSignProvider(signApiUrl)
val dataPath = Path("data")
val keystorePath: Path = dataPath.resolve("keystore.json")