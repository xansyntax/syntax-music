package com.metrolist.music;

import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.playback.DownloadUtil;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.utils.SyncUtils;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MainActivity$$ExternalSyntheticLambda15 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Function1 f$2;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ Object f$4;
    public final /* synthetic */ Object f$5;
    public final /* synthetic */ Object f$6;
    public final /* synthetic */ int f$7;

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda15(Object obj, Object obj2, Function1 function1, Object obj3, Object obj4, Object obj5, Object obj6, int i, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$2 = function1;
        this.f$3 = obj3;
        this.f$4 = obj4;
        this.f$5 = obj5;
        this.f$6 = obj6;
        this.f$7 = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        int i = this.f$7;
        Object obj3 = this.f$6;
        Object obj4 = this.f$5;
        Object obj5 = this.f$4;
        Object obj6 = this.f$3;
        Object obj7 = this.f$1;
        Object obj8 = this.f$0;
        switch (b) {
            case 0:
                ((Integer) obj2).getClass();
                int i2 = MainActivity.$r8$clinit;
                int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                ((MainActivity) obj8).MetrolistApp((String) obj7, this.f$2, (PlayerConnection) obj6, (MusicDatabase) obj5, (DownloadUtil) obj4, (SyncUtils) obj3, (Composer) obj, iUpdateChangedFlags);
                break;
            default:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags2 = Stack.updateChangedFlags(i | 1);
                CrossfadeKt.AnimatedContentImpl((Transition) obj8, (Modifier) obj7, this.f$2, (Alignment) obj6, (Function1) obj5, (Function1) obj4, (ComposableLambdaImpl) obj3, (Composer) obj, iUpdateChangedFlags2);
                break;
        }
        return unit;
    }
}
