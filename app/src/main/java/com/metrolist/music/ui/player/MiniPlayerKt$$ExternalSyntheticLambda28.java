package com.metrolist.music.ui.player;

import androidx.compose.material3.CardKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.DerivedSnapshotState$$ExternalSyntheticLambda0;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import com.metrolist.innertube.models.PodcastItem;
import com.metrolist.music.listentogether.ListenTogetherManager;
import com.metrolist.music.playback.CastConnectionHandler;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.ui.screens.podcast.OnlinePodcastScreenKt;
import io.ktor.http.MimesKt$$ExternalSyntheticLambda0;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MiniPlayerKt$$ExternalSyntheticLambda28 implements Function2 {
    public final /* synthetic */ byte $r8$classId = 0;
    public final /* synthetic */ int f$0;
    public final /* synthetic */ boolean f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ Object f$4;

    public /* synthetic */ MiniPlayerKt$$ExternalSyntheticLambda28(int i, boolean z, CastConnectionHandler castConnectionHandler, PlayerConnection playerConnection, ListenTogetherManager listenTogetherManager, int i2) {
        this.f$0 = i;
        this.f$1 = z;
        this.f$2 = castConnectionHandler;
        this.f$3 = playerConnection;
        this.f$4 = listenTogetherManager;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Object obj3 = this.f$4;
        Object obj4 = this.f$3;
        Object obj5 = this.f$2;
        switch (b) {
            case 0:
                ((Integer) obj2).getClass();
                QueueKt.LegacyPlayPauseButton(this.f$0, this.f$1, (CastConnectionHandler) obj5, (PlayerConnection) obj4, (ListenTogetherManager) obj3, (Composer) obj, Stack.updateChangedFlags(36865));
                break;
            case 1:
                ((Integer) obj2).getClass();
                OnlinePodcastScreenKt.PodcastHeader((PodcastItem) obj5, this.f$0, this.f$1, (Function0) obj4, (Function0) obj3, (Composer) obj, Stack.updateChangedFlags(1));
                break;
            default:
                SnapshotStateList snapshotStateList = (SnapshotStateList) obj5;
                String str = (String) obj4;
                MimesKt$$ExternalSyntheticLambda0 mimesKt$$ExternalSyntheticLambda0 = (MimesKt$$ExternalSyntheticLambda0) obj3;
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(1 & iIntValue, (iIntValue & 3) != 2)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    boolean zChanged = gapComposer.changed(snapshotStateList);
                    int i = this.f$0;
                    boolean zChanged2 = zChanged | gapComposer.changed(i) | gapComposer.changed(str) | gapComposer.changed(mimesKt$$ExternalSyntheticLambda0);
                    Object objRememberedValue = gapComposer.rememberedValue();
                    if (zChanged2 || objRememberedValue == Composer.Companion.Empty) {
                        objRememberedValue = new DerivedSnapshotState$$ExternalSyntheticLambda0(snapshotStateList, i, str, mimesKt$$ExternalSyntheticLambda0);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    CardKt.Checkbox(this.f$1, (Function1) objRememberedValue, null, false, null, gapComposer, 0);
                }
                break;
        }
        return unit;
    }

    public /* synthetic */ MiniPlayerKt$$ExternalSyntheticLambda28(PodcastItem podcastItem, int i, boolean z, Function0 function0, Function0 function1, int i2) {
        this.f$2 = podcastItem;
        this.f$0 = i;
        this.f$1 = z;
        this.f$3 = function0;
        this.f$4 = function1;
    }

    public /* synthetic */ MiniPlayerKt$$ExternalSyntheticLambda28(boolean z, SnapshotStateList snapshotStateList, int i, String str, MimesKt$$ExternalSyntheticLambda0 mimesKt$$ExternalSyntheticLambda0) {
        this.f$1 = z;
        this.f$2 = snapshotStateList;
        this.f$0 = i;
        this.f$3 = str;
        this.f$4 = mimesKt$$ExternalSyntheticLambda0;
    }
}
