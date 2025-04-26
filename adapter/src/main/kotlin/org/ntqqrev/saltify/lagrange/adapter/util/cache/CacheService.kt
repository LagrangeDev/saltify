package org.ntqqrev.saltify.lagrange.adapter.util.cache

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import org.ntqqrev.saltify.lagrange.adapter.LagrangeContext

class CacheService<T : CachedEntity<D>, K, D>(
    val ctx: LagrangeContext,
    val fetchData: suspend () -> Map<K, D>,
    val entityFactory: (D) -> T,
) {
    val updateMutex = Mutex()
    var currentTask: Deferred<Unit>? = null

    var currentCache = emptyMap<K, T>()

    suspend fun get(key: K, cacheFirst: Boolean = true): T? {
        if (key !in currentCache || !cacheFirst) {
            updatePreventRepeated()
        }
        return currentCache[key]
    }

    suspend fun getAll(cacheFirst: Boolean = true): Iterable<T> {
        if (currentCache.isEmpty() || !cacheFirst) {
            updatePreventRepeated()
        }
        return currentCache.values
    }

    suspend fun updatePreventRepeated() {
        return updateMutex.withLock {
            currentTask?.let {
                if (it.isActive) {
                    return@withLock it
                }
            }

            val newTask = CoroutineScope(ctx.env.parentCoroutineContext).async {
                val data = fetchData()
                val cacheSnapshot = currentCache
                currentCache = data.mapValues { (k, v) ->
                    cacheSnapshot[k]?.apply {
                        dataBinding = v
                    } ?: entityFactory(v)
                }
            }

            currentTask = newTask
            return@withLock newTask
        }.await()
    }
}