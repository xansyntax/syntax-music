package com.metrolist.music.ui.player;

import android.database.SQLException;
import androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.focus.FocusRequester;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Timeline;
import androidx.media3.exoplayer.ExoPlayerImpl;
import androidx.room.coroutines.ConnectionPoolImpl;
import androidx.sqlite.SQLite;
import com.metrolist.music.playback.PlayerConnection;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ThumbnailKt$$ExternalSyntheticLambda1 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ boolean f$1;

    public /* synthetic */ ThumbnailKt$$ExternalSyntheticLambda1(Object obj, boolean z, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = z;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        MediaItem currentMediaItem;
        MediaItem mediaItemAt;
        int nextWindowIndex;
        int previousWindowIndex;
        MutableSharedFlow stylusHandwritingTrigger;
        byte b = this.$r8$classId;
        MediaItem mediaItemAt2 = null;
        Unit unit = Unit.INSTANCE;
        Object obj = this.f$0;
        boolean z = this.f$1;
        switch (b) {
            case 0:
                ExoPlayerImpl playerSafe = ((PlayerConnection) obj).getPlayerSafe();
                Timeline currentTimeline = playerSafe.getCurrentTimeline();
                currentTimeline.getClass();
                int currentMediaItemIndex = playerSafe.getCurrentMediaItemIndex();
                playerSafe.verifyApplicationThread();
                boolean z2 = playerSafe.shuffleModeEnabled;
                try {
                    currentMediaItem = playerSafe.getCurrentMediaItem();
                    break;
                } catch (Exception unused) {
                    currentMediaItem = null;
                }
                if (z && !currentTimeline.isEmpty() && (previousWindowIndex = currentTimeline.getPreviousWindowIndex(currentMediaItemIndex, z2, 0)) != -1) {
                    try {
                        mediaItemAt = playerSafe.getMediaItemAt(previousWindowIndex);
                    } catch (Exception unused2) {
                        mediaItemAt = null;
                    }
                    break;
                } else {
                    mediaItemAt = null;
                }
                if (z && !currentTimeline.isEmpty() && (nextWindowIndex = currentTimeline.getNextWindowIndex(currentMediaItemIndex, z2, 0)) != -1) {
                    try {
                        mediaItemAt2 = playerSafe.getMediaItemAt(nextWindowIndex);
                        break;
                    } catch (Exception unused3) {
                    }
                }
                ArrayList arrayListFilterNotNull = ArraysKt.filterNotNull(new MediaItem[]{mediaItemAt, currentMediaItem, mediaItemAt2});
                return new MediaItemsData(arrayListFilterNotNull.indexOf(currentMediaItem), arrayListFilterNotNull);
            case 1:
                AndroidLegacyPlatformTextInputServiceAdapter androidLegacyPlatformTextInputServiceAdapter = (AndroidLegacyPlatformTextInputServiceAdapter) obj;
                if (z && (stylusHandwritingTrigger = androidLegacyPlatformTextInputServiceAdapter.getStylusHandwritingTrigger()) != null) {
                    ((SharedFlowImpl) stylusHandwritingTrigger).tryEmit(unit);
                }
                return unit;
            case 2:
                FocusRequester focusRequester = (FocusRequester) obj;
                if (z) {
                    FocusRequester.m415requestFocus3ESFkO8$default(focusRequester);
                }
                return unit;
            case 3:
                ConnectionPoolImpl connectionPoolImpl = (ConnectionPoolImpl) obj;
                String str = z ? "reader" : "writer";
                StringBuilder sb = new StringBuilder();
                sb.append("Timed out attempting to acquire a " + str + " connection.");
                sb.append("\n\nWriter pool:\n");
                connectionPoolImpl.writers.dump(sb);
                sb.append("Reader pool:");
                sb.append('\n');
                connectionPoolImpl.readers.dump(sb);
                try {
                    SQLite.throwSQLiteException(5, sb.toString());
                    throw null;
                } catch (SQLException e) {
                    e.printStackTrace();
                    return unit;
                }
            default:
                MutableState mutableState = (MutableState) obj;
                if (z) {
                    mutableState.setValue(Boolean.TRUE);
                }
                return unit;
        }
    }

    public /* synthetic */ ThumbnailKt$$ExternalSyntheticLambda1(boolean z, Object obj, byte b) {
        this.$r8$classId = b;
        this.f$1 = z;
        this.f$0 = obj;
    }
}
