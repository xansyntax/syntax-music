package com.atilika.kuromoji.io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class StringArrayIO {
    public static String[] readArray(InputStream inputStream) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        int i = dataInputStream.readInt();
        String[] strArr = new String[i];
        for (int i2 = 0; i2 < i; i2++) {
            strArr[i2] = dataInputStream.readUTF();
        }
        return strArr;
    }

    public static String[][] readArray2D(InputStream inputStream) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        int i = dataInputStream.readInt();
        String[][] strArr = new String[i][];
        for (int i2 = 0; i2 < i; i2++) {
            strArr[i2] = readArray(dataInputStream);
        }
        return strArr;
    }

    public static String[][] readSparseArray2D(InputStream inputStream) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        String[][] strArr = new String[dataInputStream.readInt()][];
        while (true) {
            int i = dataInputStream.readInt();
            if (i < 0) {
                return strArr;
            }
            strArr[i] = readArray(dataInputStream);
        }
    }

    public static void writeArray(OutputStream outputStream, String[] strArr) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeInt(strArr.length);
        for (String str : strArr) {
            dataOutputStream.writeUTF(str);
        }
    }

    public static void writeArray2D(OutputStream outputStream, String[][] strArr) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeInt(strArr.length);
        for (String[] strArr2 : strArr) {
            writeArray(dataOutputStream, strArr2);
        }
    }

    public static void writeSparseArray2D(OutputStream outputStream, String[][] strArr) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        int length = strArr.length;
        dataOutputStream.writeInt(length);
        for (int i = 0; i < length; i++) {
            String[] strArr2 = strArr[i];
            if (strArr2 != null) {
                dataOutputStream.writeInt(i);
                writeArray(dataOutputStream, strArr2);
            }
        }
        dataOutputStream.writeInt(-1);
    }
}
