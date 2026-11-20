package com.atilika.kuromoji.trie;

import com.atilika.kuromoji.compile.ProgressLog;
import com.atilika.kuromoji.util.ResourceResolver;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.IntBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class DoubleArrayTrie {
    private static final int BASE_CHECK_INITIAL_SIZE = 2800000;
    private static float BUFFER_GROWTH_PERCENTAGE = 0.25f;
    public static final String DOUBLE_ARRAY_TRIE_FILENAME = "doubleArrayTrie.bin";
    private static final int TAIL_INITIAL_SIZE = 200000;
    private static final int TAIL_OFFSET = 100000000;
    public static final char TERMINATING_CHARACTER = 1;
    private IntBuffer baseBuffer;
    private IntBuffer checkBuffer;
    private boolean compact;
    private int maxBaseCheckIndex;
    private CharBuffer tailBuffer;
    private int tailIndex;

    public DoubleArrayTrie(boolean z) {
        this.tailIndex = TAIL_OFFSET;
        this.maxBaseCheckIndex = 0;
        this.compact = z;
    }

    private void add(int i, int i2, Trie.Node node) {
        if (!node.getChildren().isEmpty() && node.hasSinglePath() && node.getChildren().get(0).getKey() != 1) {
            this.baseBuffer.put(i2, this.tailIndex);
            addToTail(node.getChildren().get(0));
            this.checkBuffer.put(i2, i);
            return;
        }
        int iFindBase = findBase(this.compact ? 0 : i2, node.getChildren());
        this.baseBuffer.put(i2, iFindBase);
        if (i >= 0) {
            this.checkBuffer.put(i2, i);
        }
        for (Trie.Node node2 : node.getChildren()) {
            if (this.compact) {
                add(i2, node2.getKey() + iFindBase, node2);
            } else {
                add(i2, node2.getKey() + i2 + iFindBase, node2);
            }
        }
    }

    private void addToTail(Trie.Node node) {
        while (true) {
            if (this.tailBuffer.capacity() < this.tailIndex - 99999999) {
                CharBuffer charBufferAllocate = CharBuffer.allocate(this.tailBuffer.capacity() + ((int) (this.tailBuffer.capacity() * BUFFER_GROWTH_PERCENTAGE)));
                this.tailBuffer.rewind();
                charBufferAllocate.put(this.tailBuffer);
                this.tailBuffer = charBufferAllocate;
            }
            CharBuffer charBuffer = this.tailBuffer;
            int i = this.tailIndex;
            this.tailIndex = i + 1;
            charBuffer.put(i - TAIL_OFFSET, node.getKey());
            if (node.getChildren().isEmpty()) {
                return;
            } else {
                node = node.getChildren().get(0);
            }
        }
    }

    private void extendBuffers(int i) {
        int iCapacity = i + ((int) (this.baseBuffer.capacity() * BUFFER_GROWTH_PERCENTAGE));
        ProgressLog.println("Buffers extended to " + this.baseBuffer.capacity() + " entries");
        IntBuffer intBufferAllocate = IntBuffer.allocate(iCapacity);
        this.baseBuffer.rewind();
        intBufferAllocate.put(this.baseBuffer);
        this.baseBuffer = intBufferAllocate;
        IntBuffer intBufferAllocate2 = IntBuffer.allocate(iCapacity);
        this.checkBuffer.rewind();
        intBufferAllocate2.put(this.checkBuffer);
        this.checkBuffer = intBufferAllocate2;
    }

    private int findBase(int i, List<Trie.Node> list) {
        boolean z;
        int i2 = this.baseBuffer.get(i);
        if (i2 < 0) {
            return i2;
        }
        do {
            Iterator<Trie.Node> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                int key = it.next().getKey() + i + i2;
                this.maxBaseCheckIndex = Math.max(this.maxBaseCheckIndex, key);
                if (this.baseBuffer.capacity() <= key) {
                    extendBuffers(key);
                }
                if (this.baseBuffer.get(key) != 0) {
                    i2++;
                    z = true;
                    break;
                }
            }
        } while (z);
        for (Trie.Node node : list) {
            this.baseBuffer.put(node.getKey() + i + i2, node.getKey() == 1 ? -1 : 1);
        }
        return i2;
    }

    private int matchTail(int i, int i2, String str) {
        int i3 = i - TAIL_OFFSET;
        int length = str.length();
        for (int i4 = 0; i4 < length; i4++) {
            if (str.charAt(i4) != this.tailBuffer.get(i3 + i4)) {
                return -1;
            }
        }
        if (this.tailBuffer.get(i3 + length) == 1) {
            return i2;
        }
        return 0;
    }

    public static DoubleArrayTrie newInstance(ResourceResolver resourceResolver) {
        return read(resourceResolver.resolve(DOUBLE_ARRAY_TRIE_FILENAME));
    }

    public static DoubleArrayTrie read(InputStream inputStream) throws IOException {
        DoubleArrayTrie doubleArrayTrie = new DoubleArrayTrie();
        DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(inputStream));
        doubleArrayTrie.compact = dataInputStream.readBoolean();
        int i = dataInputStream.readInt();
        int i2 = dataInputStream.readInt();
        ReadableByteChannel readableByteChannelNewChannel = Channels.newChannel(dataInputStream);
        int i3 = i * 4;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i3);
        readableByteChannelNewChannel.read(byteBufferAllocate);
        byteBufferAllocate.rewind();
        doubleArrayTrie.baseBuffer = byteBufferAllocate.asIntBuffer();
        ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(i3);
        readableByteChannelNewChannel.read(byteBufferAllocate2);
        byteBufferAllocate2.rewind();
        doubleArrayTrie.checkBuffer = byteBufferAllocate2.asIntBuffer();
        ByteBuffer byteBufferAllocate3 = ByteBuffer.allocate(i2 * 2);
        readableByteChannelNewChannel.read(byteBufferAllocate3);
        byteBufferAllocate3.rewind();
        doubleArrayTrie.tailBuffer = byteBufferAllocate3.asCharBuffer();
        inputStream.close();
        return doubleArrayTrie;
    }

    private void reportUtilizationRate() {
        int i = 0;
        for (int i2 = 0; i2 < this.maxBaseCheckIndex; i2++) {
            if (this.baseBuffer.get(i2) == 0) {
                i++;
            }
        }
        StringBuilder sb = new StringBuilder("trie memory utilization ratio (");
        sb.append(!this.compact ? "not " : "");
        sb.append("compacted): ");
        int i3 = this.maxBaseCheckIndex;
        sb.append((i3 - i) / i3);
        ProgressLog.println(sb.toString());
    }

    public void build(Trie trie) {
        StringBuilder sb = new StringBuilder("building ");
        sb.append(this.compact ? "compact" : "sparse");
        sb.append(" trie");
        ProgressLog.begin(sb.toString());
        IntBuffer intBufferAllocate = IntBuffer.allocate(BASE_CHECK_INITIAL_SIZE);
        this.baseBuffer = intBufferAllocate;
        intBufferAllocate.put(0, 1);
        this.checkBuffer = IntBuffer.allocate(BASE_CHECK_INITIAL_SIZE);
        this.tailBuffer = CharBuffer.allocate(TAIL_INITIAL_SIZE);
        add(-1, 0, trie.getRoot());
        reportUtilizationRate();
        ProgressLog.end();
    }

    public IntBuffer getBaseBuffer() {
        return this.baseBuffer;
    }

    public IntBuffer getCheckBuffer() {
        return this.checkBuffer;
    }

    public CharBuffer getTailBuffer() {
        return this.tailBuffer;
    }

    public int lookup(String str, int i, int i2) {
        char cCharAt;
        int i3 = i != 0 ? this.baseBuffer.get(i) : 1;
        int length = str.length();
        while (true) {
            boolean z = this.compact;
            if (i2 >= length) {
                if (!z) {
                    i3 += i;
                }
                if (this.checkBuffer.get(i3 + 1) == i) {
                    return i;
                }
                return 0;
            }
            if (z) {
                cCharAt = str.charAt(i2);
            } else {
                i3 += i;
                cCharAt = str.charAt(i2);
            }
            int i4 = cCharAt + i3;
            if (i4 >= this.baseBuffer.limit() || (i3 = this.baseBuffer.get(i4)) == 0 || this.checkBuffer.get(i4) != i) {
                return -1;
            }
            if (i3 >= TAIL_OFFSET) {
                return matchTail(i3, i4, str.substring(i2 + 1));
            }
            i2++;
            i = i4;
        }
    }

    public void write(OutputStream outputStream) throws IOException {
        this.baseBuffer.rewind();
        this.checkBuffer.rewind();
        this.tailBuffer.rewind();
        int iMin = Math.min(this.maxBaseCheckIndex + 64, this.baseBuffer.capacity());
        int iMin2 = Math.min(this.tailIndex - 99999936, this.tailBuffer.capacity());
        DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(outputStream));
        dataOutputStream.writeBoolean(this.compact);
        dataOutputStream.writeInt(iMin);
        dataOutputStream.writeInt(iMin2);
        WritableByteChannel writableByteChannelNewChannel = Channels.newChannel(dataOutputStream);
        int i = iMin * 4;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i);
        byteBufferAllocate.asIntBuffer().put(this.baseBuffer.array(), 0, iMin);
        byteBufferAllocate.rewind();
        writableByteChannelNewChannel.write(byteBufferAllocate);
        ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(i);
        byteBufferAllocate2.asIntBuffer().put(this.checkBuffer.array(), 0, iMin);
        byteBufferAllocate2.rewind();
        writableByteChannelNewChannel.write(byteBufferAllocate2);
        ByteBuffer byteBufferAllocate3 = ByteBuffer.allocate(iMin2 * 2);
        byteBufferAllocate3.asCharBuffer().put(this.tailBuffer.array(), 0, iMin2);
        byteBufferAllocate3.rewind();
        writableByteChannelNewChannel.write(byteBufferAllocate3);
        dataOutputStream.flush();
    }

    public DoubleArrayTrie() {
        this(false);
    }

    public int lookup(String str) {
        return lookup(str, 0, 0);
    }
}
