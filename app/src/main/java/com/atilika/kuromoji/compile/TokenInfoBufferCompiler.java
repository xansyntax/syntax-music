package com.atilika.kuromoji.compile;

import com.atilika.kuromoji.buffer.BufferEntry;
import com.atilika.kuromoji.io.ByteBufferIO;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class TokenInfoBufferCompiler implements Compiler {
    private static final int INTEGER_BYTES = 4;
    private static final int SHORT_BYTES = 2;
    private ByteBuffer buffer;
    private OutputStream output;

    public TokenInfoBufferCompiler(OutputStream outputStream, List<BufferEntry> list) {
        this.output = outputStream;
        putEntries(list);
    }

    private int calculateEntriesSize(List<BufferEntry> list) {
        if (list.isEmpty()) {
            return 0;
        }
        BufferEntry bufferEntry = list.get(0);
        return list.size() * ((bufferEntry.features.size() * 4) + bufferEntry.posInfo.size() + (bufferEntry.tokenInfo.size() * 2) + 2);
    }

    @Override // com.atilika.kuromoji.compile.Compiler
    public void compile() throws IOException {
        ByteBufferIO.write(this.output, this.buffer);
        this.output.close();
    }

    public void putEntries(List<BufferEntry> list) {
        int iCalculateEntriesSize = calculateEntriesSize(list) * 2;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(iCalculateEntriesSize + 16);
        this.buffer = byteBufferAllocate;
        byteBufferAllocate.putInt(iCalculateEntriesSize);
        this.buffer.putInt(list.size());
        BufferEntry bufferEntry = list.get(0);
        this.buffer.putInt(bufferEntry.tokenInfo.size());
        this.buffer.putInt(bufferEntry.posInfo.size());
        this.buffer.putInt(bufferEntry.features.size());
        for (BufferEntry bufferEntry2 : list) {
            Iterator<Short> it = bufferEntry2.tokenInfo.iterator();
            while (it.hasNext()) {
                this.buffer.putShort(it.next().shortValue());
            }
            Iterator<Byte> it2 = bufferEntry2.posInfo.iterator();
            while (it2.hasNext()) {
                this.buffer.put(it2.next().byteValue());
            }
            Iterator<Integer> it3 = bufferEntry2.features.iterator();
            while (it3.hasNext()) {
                this.buffer.putInt(it3.next().intValue());
            }
        }
    }
}
