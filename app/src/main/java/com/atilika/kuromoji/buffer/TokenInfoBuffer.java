package com.atilika.kuromoji.buffer;

import com.atilika.kuromoji.io.ByteBufferIO;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class TokenInfoBuffer {
    private static final int INTEGER_BYTES = 4;
    private static final int SHORT_BYTES = 2;
    private ByteBuffer buffer;
    private final int entrySize;
    private final int featureCount;
    private final int posInfoCount;
    private final int tokenInfoCount;

    public TokenInfoBuffer(InputStream inputStream) {
        this.buffer = ByteBufferIO.read(inputStream);
        int tokenInfoCount = getTokenInfoCount();
        this.tokenInfoCount = tokenInfoCount;
        int posInfoCount = getPosInfoCount();
        this.posInfoCount = posInfoCount;
        int featureCount = getFeatureCount();
        this.featureCount = featureCount;
        this.entrySize = getEntrySize(tokenInfoCount, posInfoCount, featureCount);
    }

    private int getEntrySize(int i, int i2, int i3) {
        return (i3 * 4) + (i * 2) + i2;
    }

    private int getFeatureCount() {
        return this.buffer.getInt(16);
    }

    private int getPosInfoCount() {
        return this.buffer.getInt(12);
    }

    private int getPosition(int i, int i2) {
        return (i * i2) + 20;
    }

    private int getTokenInfoCount() {
        return this.buffer.getInt(8);
    }

    public boolean isPartOfSpeechFeature(int i) {
        return i < getPosInfoCount();
    }

    public BufferEntry lookupEntry(int i) {
        BufferEntry bufferEntry = new BufferEntry();
        int i2 = this.tokenInfoCount;
        bufferEntry.tokenInfos = new short[i2];
        int i3 = this.posInfoCount;
        bufferEntry.posInfos = new byte[i3];
        int i4 = this.featureCount;
        bufferEntry.featureInfos = new int[i4];
        int position = getPosition(i, getEntrySize(i2, i3, i4));
        for (int i5 = 0; i5 < this.tokenInfoCount; i5++) {
            bufferEntry.tokenInfos[i5] = this.buffer.getShort((i5 * 2) + position);
        }
        for (int i6 = 0; i6 < this.posInfoCount; i6++) {
            bufferEntry.posInfos[i6] = this.buffer.get((this.tokenInfoCount * 2) + position + i6);
        }
        for (int i7 = 0; i7 < this.featureCount; i7++) {
            bufferEntry.featureInfos[i7] = this.buffer.getInt((i7 * 4) + (this.tokenInfoCount * 2) + position + this.posInfoCount);
        }
        return bufferEntry;
    }

    public int lookupFeature(int i, int i2) {
        int position = getPosition(i, this.entrySize);
        ByteBuffer byteBuffer = this.buffer;
        int i3 = (this.tokenInfoCount * 2) + position;
        int i4 = this.posInfoCount;
        return byteBuffer.getInt(((i2 - i4) * 4) + i3 + i4);
    }

    public int lookupPartOfSpeechFeature(int i, int i2) {
        return this.buffer.get((this.tokenInfoCount * 2) + getPosition(i, this.entrySize) + i2) & 255;
    }

    public int lookupTokenInfo(int i, int i2) {
        return this.buffer.getShort((i2 * 2) + getPosition(i, this.entrySize));
    }
}
