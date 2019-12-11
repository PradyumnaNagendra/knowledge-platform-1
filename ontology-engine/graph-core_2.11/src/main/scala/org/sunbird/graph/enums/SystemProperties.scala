package org.sunbird.graph.enums

sealed trait SystemProperties

case object IL_SYS_NODE_TYPE extends SystemProperties
case object IL_FUNC_OBJECT_TYPE extends SystemProperties
case object IL_UNIQUE_ID extends SystemProperties
case object IL_SEQUENCE_INDEX extends SystemProperties


