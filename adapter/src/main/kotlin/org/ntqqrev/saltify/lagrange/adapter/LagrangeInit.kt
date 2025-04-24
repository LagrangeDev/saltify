package org.ntqqrev.saltify.lagrange.adapter

import kotlinx.serialization.Serializable
import org.ntqqrev.saltify.api.Config

@Serializable
class LagrangeInit {
    @Config("签名 API URL")
    val signApiUrl: String = "https://sign.lagrangecore.org/api/sign/30366"
}