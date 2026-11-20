package org.slf4j.helpers;

import java.util.concurrent.ConcurrentHashMap;
import okio.Path;
import org.slf4j.ILoggerFactory;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class SubstituteServiceProvider {
    public final /* synthetic */ byte $r8$classId;
    public final ILoggerFactory loggerFactory;

    public SubstituteServiceProvider(byte b) {
        this.$r8$classId = b;
        switch (b) {
            case 1:
                this.loggerFactory = new Path.Companion((byte) 19);
                new ConcurrentHashMap();
                break;
            default:
                this.loggerFactory = new SubstituteLoggerFactory();
                new ConcurrentHashMap();
                new BasicMDCAdapter$1();
                break;
        }
    }
}
