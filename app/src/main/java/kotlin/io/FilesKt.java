package kotlin.io;

import dagger.hilt.EntryPoints;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import kotlin.text.CharsKt;
import kotlin.text.Charsets;
import kotlin.text.HexFormatKt;
import kotlin.text.RegexKt;
import kotlin.text.StringsKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: loaded from: classes.dex */
public abstract class FilesKt extends HexFormatKt {
    public static void copyTo$default(File file, File file2) throws IOException {
        file.getClass();
        if (!file.exists()) {
            throw new NoSuchFileException(file, null, "The source file doesn't exist.");
        }
        if (file2.exists() && !file2.delete()) {
            throw new NoSuchFileException(file, file2, "Tried to overwrite the destination, but failed to delete it.");
        }
        if (file.isDirectory()) {
            if (!file2.mkdirs()) {
                throw new FileSystemException(file, file2, "Failed to create target directory.");
            }
            return;
        }
        File parentFile = file2.getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            try {
                EntryPoints.copyTo(fileInputStream, fileOutputStream);
                fileOutputStream.close();
                fileInputStream.close();
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CharsKt.closeFinally(fileOutputStream, th);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            try {
                throw th3;
            } catch (Throwable th4) {
                CharsKt.closeFinally(fileInputStream, th3);
                throw th4;
            }
        }
    }

    public static String readText$default(File file) throws IOException {
        Charset charset = Charsets.UTF_8;
        charset.getClass();
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), charset);
        try {
            String text = RegexKt.readText(inputStreamReader);
            inputStreamReader.close();
            return text;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CharsKt.closeFinally(inputStreamReader, th);
                throw th2;
            }
        }
    }

    public static File resolve(File file, String str) {
        File file2 = new File(str);
        String path = file2.getPath();
        path.getClass();
        if (HexFormatKt.getRootLength$FilesKt__FilePathComponentsKt(path) > 0) {
            return file2;
        }
        String string = file.toString();
        string.getClass();
        if (string.length() != 0) {
            char c = File.separatorChar;
            if (!StringsKt.endsWith$default(string, c)) {
                return new File(string + c + file2);
            }
        }
        return new File(string + file2);
    }

    public static void writeText$default(File file, String str) throws IOException {
        Charset charset = Charsets.UTF_8;
        str.getClass();
        charset.getClass();
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            writeTextImpl(fileOutputStream, str, charset);
            fileOutputStream.close();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CharsKt.closeFinally(fileOutputStream, th);
                throw th2;
            }
        }
    }

    public static final void writeTextImpl(FileOutputStream fileOutputStream, String str, Charset charset) throws IOException {
        str.getClass();
        if (str.length() < 16384) {
            byte[] bytes = str.getBytes(charset);
            bytes.getClass();
            fileOutputStream.write(bytes);
            return;
        }
        CharsetEncoder charsetEncoderNewEncoder = charset.newEncoder();
        CodingErrorAction codingErrorAction = CodingErrorAction.REPLACE;
        CharsetEncoder charsetEncoderOnUnmappableCharacter = charsetEncoderNewEncoder.onMalformedInput(codingErrorAction).onUnmappableCharacter(codingErrorAction);
        CharBuffer charBufferAllocate = CharBuffer.allocate(8192);
        charsetEncoderOnUnmappableCharacter.getClass();
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8192 * ((int) Math.ceil(charsetEncoderOnUnmappableCharacter.maxBytesPerChar())));
        byteBufferAllocate.getClass();
        int i = 0;
        int i2 = 0;
        while (i < str.length()) {
            int iMin = Math.min(8192 - i2, str.length() - i);
            int i3 = i + iMin;
            char[] cArrArray = charBufferAllocate.array();
            cArrArray.getClass();
            str.getChars(i, i3, cArrArray, i2);
            charBufferAllocate.limit(iMin + i2);
            i2 = 1;
            if (!charsetEncoderOnUnmappableCharacter.encode(charBufferAllocate, byteBufferAllocate, i3 == str.length()).isUnderflow()) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Check failed.");
                return;
            }
            fileOutputStream.write(byteBufferAllocate.array(), 0, byteBufferAllocate.position());
            if (charBufferAllocate.position() != charBufferAllocate.limit()) {
                charBufferAllocate.put(0, charBufferAllocate.get());
            } else {
                i2 = 0;
            }
            charBufferAllocate.clear();
            byteBufferAllocate.clear();
            i = i3;
        }
    }
}
