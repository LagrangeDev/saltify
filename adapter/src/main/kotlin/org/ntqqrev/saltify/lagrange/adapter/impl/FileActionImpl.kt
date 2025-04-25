package org.ntqqrev.saltify.lagrange.adapter.impl

import org.ntqqrev.saltify.api.context.action.FileAction
import org.ntqqrev.saltify.api.context.model.group.FileEntry
import org.ntqqrev.saltify.api.context.model.group.FileSystemEntry
import org.ntqqrev.saltify.lagrange.BotContext
import java.io.InputStream

class FileActionImpl(val lagrange: BotContext) : FileAction {
    override suspend fun uploadPrivateFile(userUin: Long, file: InputStream): String {
        TODO("Not yet implemented")
    }

    override suspend fun getPrivateFileDownloadUrl(
        userUin: Long,
        fileId: String,
        fileHash: String
    ): String {
        TODO("Not yet implemented")
    }

    override suspend fun uploadGroupFile(
        groupUin: Long,
        file: InputStream,
        parentFolderId: String
    ): String {
        TODO("Not yet implemented")
    }

    override suspend fun getGroupFiles(
        groupUin: Long,
        parentFolderId: String
    ): List<FileSystemEntry> {
        TODO("Not yet implemented")
    }

    override suspend fun getGroupFileDownloadUrl(groupUin: Long, fileId: String): String {
        TODO("Not yet implemented")
    }

    override suspend fun moveGroupFile(
        groupUin: Long,
        fileId: String,
        fromFolderId: String,
        targetFolderId: String
    ) {
        TODO("Not yet implemented")
    }

    override suspend fun renameGroupFile(
        groupUin: Long,
        fileId: String,
        newName: String
    ): FileEntry {
        TODO("Not yet implemented")
    }

    override suspend fun deleteGroupFile(groupUin: Long, fileId: String): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun createGroupFolder(groupUin: Long, folderName: String): String {
        TODO("Not yet implemented")
    }

    override suspend fun renameGroupFolder(
        groupUin: Long,
        folderId: String,
        newName: String
    ): String {
        TODO("Not yet implemented")
    }

    override suspend fun deleteGroupFolder(groupUin: Long, folderId: String): Boolean {
        TODO("Not yet implemented")
    }
}