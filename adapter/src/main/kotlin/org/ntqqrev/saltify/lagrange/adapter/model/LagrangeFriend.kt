package org.ntqqrev.saltify.lagrange.adapter.model

import org.ntqqrev.saltify.api.context.model.Friend
import org.ntqqrev.saltify.lagrange.adapter.LagrangeContext
import org.ntqqrev.saltify.lagrange.adapter.cache.CachedEntity

class LagrangeFriend(
    override var dataBinding: Binding,
    override val ctx: LagrangeContext
) : Friend, CachedEntity<LagrangeFriend.Binding> {
    override val uin: Long
        get() = dataBinding.uin
    override val name: String
        get() = dataBinding.name
    override val remark: String?
        get() = dataBinding.remark
    override val signature: String?
        get() = dataBinding.signature
    override val qid: String?
        get() = dataBinding.qid
    override val category: Int
        get() = dataBinding.category

    class Binding(
        var uin: Long,
        var name: String,
        var remark: String?,
        var signature: String?,
        var qid: String?,
        var category: Int
    )

    override fun toString(): String = "${if (remark.isNullOrEmpty()) name else remark} ($uin)"
}