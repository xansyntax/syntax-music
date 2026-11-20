package com.atilika.kuromoji.io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.Channels;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class IntegerArrayIO {
    private static final int INT_BYTES = 4;

    public static int[] readArray(InputStream inputStream) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        int i = dataInputStream.readInt();
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i * 4);
        Channels.newChannel(dataInputStream).read(byteBufferAllocate);
        byteBufferAllocate.rewind();
        int[] iArr = new int[i];
        byteBufferAllocate.asIntBuffer().get(iArr);
        return iArr;
    }

    public static int[][] readArray2D(InputStream inputStream) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        int i = dataInputStream.readInt();
        int[][] iArr = new int[i][];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = readArray(dataInputStream);
        }
        return iArr;
    }

    public static int[][] readSparseArray2D(InputStream inputStream) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        int[][] iArr = new int[dataInputStream.readInt()][];
        while (true) {
            int i = dataInputStream.readInt();
            if (i < 0) {
                return iArr;
            }
            iArr[i] = readArray(dataInputStream);
        }
    }

    public static void writeArray(OutputStream outputStream, int[] iArr) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        int length = iArr.length;
        dataOutputStream.writeInt(length);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(length * 4);
        IntBuffer intBufferAsIntBuffer = byteBufferAllocate.asIntBuffer();
        byteBufferAllocate.rewind();
        intBufferAsIntBuffer.put(iArr);
        Channels.newChannel(dataOutputStream).write(byteBufferAllocate);
    }

    public static void writeArray2D(OutputStream outputStream, int[][] iArr) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeInt(iArr.length);
        for (int[] iArr2 : iArr) {
            writeArray(dataOutputStream, iArr2);
        }
    }

    public static void writeSparseArray2D(OutputStream outputStream, int[][] iArr) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        int length = iArr.length;
        dataOutputStream.writeInt(length);
        for (int i = 0; i < length; i++) {
            int[] iArr2 = iArr[i];
            if (iArr2 != null) {
                dataOutputStream.writeInt(i);
                writeArray(dataOutputStream, iArr2);
            }
        }
        dataOutputStream.writeInt(-1);
    }
}
