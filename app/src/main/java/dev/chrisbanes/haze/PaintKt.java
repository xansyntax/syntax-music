package dev.chrisbanes.haze;

import androidx.collection.MutableScatterSet;
import androidx.compose.ui.graphics.AndroidPaint;
import androidx.compose.ui.graphics.ColorKt;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import okhttp3.ConnectionPool;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class PaintKt {
    public static final ConnectionPool PaintPool = new ConnectionPool((byte) 18);

    /* JADX WARN: Code duplicated, block: B:16:0x004d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:17:0x004f A[LOOP:0: B:7:0x0019->B:17:0x004f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:25:0x0052 A[SYNTHETIC] */
    public static final AndroidPaint getOrCreate(ConnectionPool connectionPool) {
        connectionPool.getClass();
        MutableScatterSet mutableScatterSet = (MutableScatterSet) connectionPool.delegate;
        Object obj = null;
        if (mutableScatterSet.isNotEmpty()) {
            Object[] objArr = mutableScatterSet.elements;
            long[] jArr = mutableScatterSet.metadata;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i = 0;
                loop0: while (true) {
                    long j = jArr[i];
                    if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i2 = 8 - ((~(i - length)) >>> 31);
                        for (int i3 = 0; i3 < i2; i3++) {
                            if ((255 & j) < 128) {
                                obj = objArr[(i << 3) + i3];
                                mutableScatterSet.remove(obj);
                                break loop0;
                            }
                            j >>= 8;
                        }
                        if (i2 == 8) {
                            if (i != length) {
                                i++;
                            }
                        }
                    } else if (i != length) {
                        i++;
                    }
                }
            }
            PathKt$$ExternalSyntheticBUOutline0.m$1("The ScatterSet is empty");
            return null;
        }
        AndroidPaint androidPaint = (AndroidPaint) obj;
        return androidPaint == null ? ColorKt.Paint() : androidPaint;
    }
}
