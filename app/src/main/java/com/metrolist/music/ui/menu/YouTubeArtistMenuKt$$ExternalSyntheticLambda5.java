package com.metrolist.music.ui.menu;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import com.metrolist.innertube.models.WatchEndpoint;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.playback.queues.YouTubeQueue;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class YouTubeArtistMenuKt$$ExternalSyntheticLambda5 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ PlayerConnection f$0;
    public final /* synthetic */ WatchEndpoint f$1;
    public final /* synthetic */ Function0 f$2;

    public /* synthetic */ YouTubeArtistMenuKt$$ExternalSyntheticLambda5(PlayerConnection playerConnection, WatchEndpoint watchEndpoint, Function0 function0, byte b) {
        this.$r8$classId = b;
        this.f$0 = playerConnection;
        this.f$1 = watchEndpoint;
        this.f$2 = function0;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Function0 function0 = this.f$2;
        WatchEndpoint watchEndpoint = this.f$1;
        PlayerConnection playerConnection = this.f$0;
        Composer composer = (Composer) obj;
        int iIntValue = ((Integer) obj2).intValue();
        switch (b) {
            case 0:
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    playerConnection.playQueue(new YouTubeQueue(watchEndpoint, null, 2, null));
                    function0.invoke();
                }
                break;
            case 1:
                GapComposer gapComposer2 = (GapComposer) composer;
                if (!gapComposer2.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    playerConnection.playQueue(new YouTubeQueue(watchEndpoint, null, 2, null));
                    function0.invoke();
                }
                break;
            case 2:
                GapComposer gapComposer3 = (GapComposer) composer;
                if (!gapComposer3.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    gapComposer3.skipToGroupEnd();
                } else {
                    playerConnection.playQueue(new YouTubeQueue(watchEndpoint, null, 2, null));
                    function0.invoke();
                }
                break;
            default:
                GapComposer gapComposer4 = (GapComposer) composer;
                if (!gapComposer4.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    gapComposer4.skipToGroupEnd();
                } else {
                    playerConnection.playQueue(new YouTubeQueue(watchEndpoint, null, 2, null));
                    function0.invoke();
                }
                break;
        }
        return unit;
    }
}
