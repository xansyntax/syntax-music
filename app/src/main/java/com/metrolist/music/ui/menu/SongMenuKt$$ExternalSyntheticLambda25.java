package com.metrolist.music.ui.menu;

import android.content.Context;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.navigation.NavHostController;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.innertube.models.YTItem;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.utils.SyncUtils;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SongMenuKt$$ExternalSyntheticLambda25 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ boolean f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ Object f$4;
    public final /* synthetic */ Object f$5;

    public /* synthetic */ SongMenuKt$$ExternalSyntheticLambda25(Context context, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MusicDatabase musicDatabase, boolean z) {
        this.$r8$classId = (byte) 6;
        this.f$0 = z;
        this.f$2 = musicDatabase;
        this.f$1 = mutableState;
        this.f$3 = mutableState2;
        this.f$4 = mutableState3;
        this.f$5 = context;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0094  */
    /* JADX WARN: Code duplicated, block: B:21:0x0096  */
    /* JADX WARN: Code duplicated, block: B:56:0x014e  */
    /* JADX WARN: Code duplicated, block: B:59:0x0158  */
    /* JADX WARN: Code duplicated, block: B:60:0x015f  */
    /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r1v24 java.lang.Object, still in use, count: 2, list:
          (r1v24 java.lang.Object) from 0x014a: PHI (r1 I:??) = (r1v19 java.lang.Object), (r1v24 java.lang.Object) binds: [B:53:0x0149, B:110:0x014a] A[DONT_GENERATE, DONT_INLINE]
          (r1v24 java.lang.Object) from 0x0139: CHECK_CAST (com.metrolist.music.db.entities.SpeedDialItem) (r1v24 java.lang.Object)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
        	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:93)
        	at jadx.core.dex.visitors.regions.TernaryMod.makeTernaryInsn(TernaryMod.java:132)
        	at jadx.core.dex.visitors.regions.TernaryMod.processRegion(TernaryMod.java:67)
        	at jadx.core.dex.visitors.regions.TernaryMod.enterRegion(TernaryMod.java:50)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:96)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:27)
        	at jadx.core.dex.visitors.regions.TernaryMod.process(TernaryMod.java:36)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.process(IfRegionVisitor.java:44)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.visit(IfRegionVisitor.java:30)
        */
    @Override // kotlin.jvm.functions.Function0
    public final java.lang.Object invoke() {
        /*
            Method dump skipped, instruction units count: 686
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda25.invoke():java.lang.Object");
    }

    public /* synthetic */ SongMenuKt$$ExternalSyntheticLambda25(byte b, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, boolean z) {
        this.$r8$classId = b;
        this.f$0 = z;
        this.f$1 = obj;
        this.f$2 = obj2;
        this.f$3 = obj3;
        this.f$4 = obj4;
        this.f$5 = obj5;
    }

    public /* synthetic */ SongMenuKt$$ExternalSyntheticLambda25(YTItem yTItem, boolean z, PlayerConnection playerConnection, NavHostController navHostController, MutableState mutableState, State state) {
        this.$r8$classId = (byte) 4;
        this.f$1 = yTItem;
        this.f$0 = z;
        this.f$2 = playerConnection;
        this.f$3 = navHostController;
        this.f$4 = mutableState;
        this.f$5 = state;
    }

    public /* synthetic */ SongMenuKt$$ExternalSyntheticLambda25(CoroutineScope coroutineScope, Function0 function0, boolean z, MusicDatabase musicDatabase, Song song, SyncUtils syncUtils) {
        this.$r8$classId = (byte) 2;
        this.f$3 = coroutineScope;
        this.f$5 = function0;
        this.f$0 = z;
        this.f$2 = musicDatabase;
        this.f$1 = song;
        this.f$4 = syncUtils;
    }

    public /* synthetic */ SongMenuKt$$ExternalSyntheticLambda25(boolean z, MusicDatabase musicDatabase, CoroutineScope coroutineScope, State state, SongItem songItem, SyncUtils syncUtils) {
        this.$r8$classId = (byte) 3;
        this.f$0 = z;
        this.f$2 = musicDatabase;
        this.f$3 = coroutineScope;
        this.f$1 = state;
        this.f$5 = songItem;
        this.f$4 = syncUtils;
    }

    public /* synthetic */ SongMenuKt$$ExternalSyntheticLambda25(boolean z, CoroutineScope coroutineScope, State state, State state2, PlayerConnection playerConnection, MusicDatabase musicDatabase) {
        this.$r8$classId = (byte) 5;
        this.f$0 = z;
        this.f$3 = coroutineScope;
        this.f$1 = state;
        this.f$4 = state2;
        this.f$5 = playerConnection;
        this.f$2 = musicDatabase;
    }
}
