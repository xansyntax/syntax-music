package com.atilika.kuromoji.dict;

import com.atilika.kuromoji.io.ByteBufferIO;
import com.atilika.kuromoji.util.ResourceResolver;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.nio.ShortBuffer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class ConnectionCosts {
    public static final String CONNECTION_COSTS_FILENAME = "connectionCosts.bin";
    private ShortBuffer costs;
    private int size;

    public ConnectionCosts(int i, ShortBuffer shortBuffer) {
        this.size = i;
        this.costs = shortBuffer;
    }

    public static ConnectionCosts newInstance(ResourceResolver resourceResolver) {
        return read(resourceResolver.resolve(CONNECTION_COSTS_FILENAME));
    }

    private static ConnectionCosts read(InputStream inputStream) {
        DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(inputStream));
        return new ConnectionCosts(dataInputStream.readInt(), ByteBufferIO.read(dataInputStream).asShortBuffer());
    }

    public int get(int i, int i2) {
        return this.costs.get((i * this.size) + i2);
    }
}
