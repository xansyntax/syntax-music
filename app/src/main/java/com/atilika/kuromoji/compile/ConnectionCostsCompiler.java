package com.atilika.kuromoji.compile;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ShortBuffer;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class ConnectionCostsCompiler implements Compiler {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int SHORT_BYTES = 2;
    private int bufferSize;
    private int cardinality;
    private ShortBuffer costs;
    private OutputStream output;

    public ConnectionCostsCompiler(OutputStream outputStream) {
        this.output = outputStream;
    }

    @Override // com.atilika.kuromoji.compile.Compiler
    public void compile() throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(this.output));
        dataOutputStream.writeInt(this.cardinality);
        dataOutputStream.writeInt(this.bufferSize * 2);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(this.costs.array().length * 2);
        for (short s : this.costs.array()) {
            byteBufferAllocate.putShort(s);
        }
        WritableByteChannel writableByteChannelNewChannel = Channels.newChannel(dataOutputStream);
        byteBufferAllocate.flip();
        writableByteChannelNewChannel.write(byteBufferAllocate);
        dataOutputStream.close();
    }

    public int getCardinality() {
        return this.cardinality;
    }

    public ShortBuffer getCosts() {
        return this.costs;
    }

    public void putCost(short s, short s2, short s3) {
        this.costs.put((s * this.cardinality) + s2, s3);
    }

    public void readCosts(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String[] strArrSplit = bufferedReader.readLine().split("\\s+");
        int i = Integer.parseInt(strArrSplit[0]);
        int i2 = Integer.parseInt(strArrSplit[1]);
        this.cardinality = i2;
        int i3 = i * i2;
        this.bufferSize = i3;
        this.costs = ShortBuffer.allocate(i3);
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                return;
            }
            String[] strArrSplit2 = line.split("\\s+");
            putCost(Short.parseShort(strArrSplit2[0]), Short.parseShort(strArrSplit2[1]), Short.parseShort(strArrSplit2[2]));
        }
    }
}
