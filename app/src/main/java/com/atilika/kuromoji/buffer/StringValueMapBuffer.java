package com.atilika.kuromoji.buffer;

import com.atilika.kuromoji.io.ByteBufferIO;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class StringValueMapBuffer {
    private static final int INTEGER_BYTES = 4;
    private static final int SHORT_BYTES = 2;
    private ByteBuffer buffer;

    public StringValueMapBuffer(InputStream inputStream) {
        this.buffer = ByteBufferIO.read(inputStream);
    }

    private int calculateSize(TreeMap<Integer, String> treeMap) {
        Iterator<String> it = treeMap.values().iterator();
        int length = 0;
        while (it.hasNext()) {
            length += it.next().getBytes(StandardCharsets.UTF_8).length + 12;
        }
        return length;
    }

    private static int getMetaDataSize() {
        return 4;
    }

    private String getString(int i) {
        return new String(this.buffer.array(), i + 2, this.buffer.getShort(i), StandardCharsets.UTF_8);
    }

    private int putString(int i, String str) {
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        this.buffer.position(i);
        this.buffer.putShort((short) bytes.length);
        this.buffer.put(bytes);
        return i + 2 + bytes.length;
    }

    public String get(int i) {
        return getString(this.buffer.getInt((i * 4) + getMetaDataSize()));
    }

    public void putMap(TreeMap<Integer, String> treeMap) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[calculateSize(treeMap) + getMetaDataSize()]);
        this.buffer = byteBufferWrap;
        byteBufferWrap.putInt(treeMap.size());
        int metaDataSize = getMetaDataSize();
        int size = (treeMap.size() * 4) + metaDataSize;
        for (Integer num : treeMap.keySet()) {
            this.buffer.putInt(metaDataSize, size);
            size = putString(size, treeMap.get(num));
            metaDataSize += 4;
        }
    }

    public void write(OutputStream outputStream) throws IOException {
        ByteBufferIO.write(outputStream, this.buffer);
    }

    public StringValueMapBuffer(TreeMap<Integer, String> treeMap) {
        putMap(treeMap);
    }
}
