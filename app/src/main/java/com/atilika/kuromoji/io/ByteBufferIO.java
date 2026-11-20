package com.atilika.kuromoji.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class ByteBufferIO {
    public static ByteBuffer read(InputStream inputStream) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(inputStream));
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(dataInputStream.readInt());
        Channels.newChannel(dataInputStream).read(byteBufferAllocate);
        byteBufferAllocate.rewind();
        return byteBufferAllocate;
    }

    public static void write(OutputStream outputStream, ByteBuffer byteBuffer) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(outputStream));
        dataOutputStream.writeInt(byteBuffer.position());
        byteBuffer.flip();
        Channels.newChannel(dataOutputStream).write(byteBuffer);
        dataOutputStream.flush();
    }
}
