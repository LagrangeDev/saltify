package org.ntqqrev.saltify.lagrange.adapter.model

import org.ntqqrev.saltify.api.context.model.Friend
import org.ntqqrev.saltify.lagrange.adapter.LagrangeContext
import org.ntqqrev.saltify.lagrange.adapter.cache.CachedEntity
import org.ntqqrev.saltify.lagrange.operation.system.FetchFriends

class LagrangeFriend(
    override var dataBinding: FetchFriends.Entry,
    override val ctx: LagrangeContext
) : Friend, CachedEntity<FetchFriends.Entry> {
    override val uin: Long
        get() = dataBinding.uin
    override val name: String
        get() = dataBinding.nickname ?: uin.toString()
    override val remark: String?
        get() = dataBinding.remark
    override val signature: String?
        get() = dataBinding.signature
    override val qid: String?
        get() = dataBinding.qid
    override val category: Int
        get() = dataBinding.category

    override fun toString(): String = "${if (remark.isNullOrEmpty()) name else remark} ($uin)"
}