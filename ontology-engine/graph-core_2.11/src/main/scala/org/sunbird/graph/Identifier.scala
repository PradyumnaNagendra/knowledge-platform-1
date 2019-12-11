package org.sunbird.graph

import java.util.concurrent.atomic.AtomicInteger

import org.sunbird.common.Platform
import org.sunbird.common.exception.ServerException

object Identifier {

    val environmentId: Long = if(Platform.config.hasPath("environment.id")) Platform.config.getLong("environment.id") else 10000000
    val shardId: String = if (Platform.config.hasPath("shard.id")) Platform.config.getString("shard.id") else  "1"
    val aInteger: AtomicInteger = new AtomicInteger(1)

    def getUniqueIdFromTimestamp(): String = {
        val env: Long = environmentId / 10000000
        val uid: Long = System.currentTimeMillis() << 13
        env + "" + uid + "" + shardId + aInteger.getAndIncrement()
    }

    def getIdentifier(graphId: String, id: String): String = {
        if(null == graphId || graphId.isEmpty) throw new ServerException("ERR_INVALID_GRAPH_ID",
            "Graph Id is required to generate an identifier")
        val prefix = if(graphId.length >= 2) graphId.substring(0, 2) else graphId
        prefix + "_" + id
    }
}
