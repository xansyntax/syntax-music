package com.metrolist.music.db;

import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MusicDatabase$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Function1 f$0;
    public final /* synthetic */ MusicDatabase f$1;

    public /* synthetic */ MusicDatabase$$ExternalSyntheticLambda0(Function1 function1, MusicDatabase musicDatabase, byte b) {
        this.$r8$classId = b;
        this.f$0 = function1;
        this.f$1 = musicDatabase;
    }

    @Override // java.lang.Runnable
    public final void run() {
        byte b = this.$r8$classId;
        MusicDatabase musicDatabase = this.f$1;
        Function1 function1 = this.f$0;
        switch (b) {
            case 0:
                function1.invoke(musicDatabase);
                break;
            default:
                function1.invoke(musicDatabase);
                break;
        }
    }
}
