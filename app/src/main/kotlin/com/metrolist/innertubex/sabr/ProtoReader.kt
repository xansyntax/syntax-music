package com.metrolist.innertubex.sabr

class ProtoReader(private val bytes: ByteArray) {
    private var pos = 0

    val hasRemaining: Boolean
        get() = pos < bytes.size

    fun varint(): Long {
        var result = 0L
        var shift = 0
        for (i in 0 until 10) {
            if (pos >= bytes.size) throw IllegalStateException("Truncated protobuf varint")
            val b = bytes[pos++]
            if (shift == 63 && ((b.toInt() and 127) > 1 || (b.toInt() and 128) != 0)) {
                throw IllegalStateException("Protobuf varint overflows 64 bits")
            }
            result = result or ((b.toLong() and 127) shl shift)
            if ((b.toInt() and 128) == 0) return result
            shift += 7
        }
        throw IllegalStateException("Protobuf varint is too long")
    }

    fun tag(): ProtoTag {
        val v = varint()
        val field = (v ushr 3)
        if (field < 1 || field >= 536870912 || (field in 19000L..19999L)) {
            throw IllegalStateException("Invalid protobuf field number $field")
        }
        return ProtoTag(field.toInt(), (v and 7).toInt())
    }

    fun bytes(): ByteArray {
        val len = varint()
        if (len < 0 || len > Int.MAX_VALUE) throw IllegalStateException("Invalid protobuf length $len")
        val end = pos + len.toInt()
        if (end < pos || end > bytes.size) throw IllegalStateException("Truncated protobuf field")
        val sub = bytes.copyOfRange(pos, end)
        pos = end
        return sub
    }

    fun skip(tag: ProtoTag) {
        when (tag.wireType) {
            0 -> varint()
            1 -> advance(8)
            2 -> {
                val len = varint()
                if (len < 0 || len > Int.MAX_VALUE) throw IllegalStateException("Invalid protobuf length $len")
                advance(len.toInt())
            }
            5 -> advance(4)
            else -> throw IllegalStateException("Unsupported protobuf wire type ${tag.wireType}")
        }
    }

    private fun advance(count: Int) {
        val end = pos + count
        if (end < pos || end > bytes.size) throw IllegalStateException("Truncated protobuf field")
        pos = end
    }
}
