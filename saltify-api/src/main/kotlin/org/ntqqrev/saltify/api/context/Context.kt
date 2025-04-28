package org.ntqqrev.saltify.api.context

import org.ntqqrev.saltify.api.context.action.*

/**
 * The context object, which represents the bot itself.
 */
interface Context : ContextAction, MessageAction, UserAction, GroupAction, RequestAction, FileAction {
    /**
     * The uin of the bot.
     */
    val uin: Long

    /**
     * The state of the context.
     */
    val state: State

    enum class State {
        /**
         * The context is newly created and not yet started.
         */
        NEWLY_CREATED,

        /**
         * The context is started and running.
         */
        RUNNING,

        /**
         * The context encountered an error and is unexpectedly terminated.
         */
        ERROR_TERMINATED,

        /**
         * The context is stopped and not running.
         * Note that a Context instance is not reusable after it is stopped.
         * A new Context instance is created whenever a new bot is started.
         */
        DISPOSED,
    }
}