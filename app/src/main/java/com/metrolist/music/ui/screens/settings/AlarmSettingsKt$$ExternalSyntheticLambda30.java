package com.metrolist.music.ui.screens.settings;

import android.content.Context;
import android.widget.Toast;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import com.metrolist.innertube.models.PlaylistItem;
import com.metrolist.innertube.models.YTItem;
import com.metrolist.music.App$Companion$forgetAccount$2;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.RecognitionHistory;
import com.metrolist.music.ui.component.MenuState;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda34;
import com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda22;
import com.metrolist.music.ui.screens.search.OnlineSearchScreenKt$$ExternalSyntheticLambda12;
import com.metrolist.music.utils.DataStoreKt$get$2;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.InterruptibleKt$runInterruptible$2;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AlarmSettingsKt$$ExternalSyntheticLambda30 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;

    public /* synthetic */ AlarmSettingsKt$$ExternalSyntheticLambda30(MenuState menuState, PlaylistItem playlistItem, List list, CoroutineScope coroutineScope) {
        this.$r8$classId = (byte) 3;
        this.f$1 = menuState;
        this.f$2 = playlistItem;
        this.f$0 = list;
        this.f$3 = coroutineScope;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Object obj = this.f$2;
        Object obj2 = this.f$1;
        Object obj3 = this.f$3;
        Object obj4 = this.f$0;
        switch (b) {
            case 0:
                Context context = (Context) obj2;
                String str = (String) obj;
                MutableState mutableState = (MutableState) obj3;
                if (!((List) obj4).isEmpty()) {
                    mutableState.setValue(Boolean.TRUE);
                } else {
                    Toast.makeText(context, str, 0).show();
                }
                break;
            case 1:
                MenuState menuState = (MenuState) obj4;
                menuState.show(new ComposableLambdaImpl(true, 1814160758, new SongMenuKt$$ExternalSyntheticLambda34((SnapshotStateList) obj2, menuState, (Function0) obj, (MutableState) obj3, (byte) 16)));
                break;
            case 2:
                MenuState menuState2 = (MenuState) obj2;
                menuState2.show(new ComposableLambdaImpl(true, 1100537894, new QueueKt$$ExternalSyntheticLambda22((List) obj4, menuState2, (Function0) obj, (SnapshotStateList) obj3)));
                break;
            case 3:
                MenuState menuState3 = (MenuState) obj2;
                menuState3.show(new ComposableLambdaImpl(true, -1781400872, new SongMenuKt$$ExternalSyntheticLambda34((PlaylistItem) obj, (List) obj4, (CoroutineScope) obj3, menuState3, (byte) 17)));
                break;
            case 4:
                DefaultScheduler defaultScheduler = Dispatchers.Default;
                AwaitKt.launch$default((CoroutineScope) obj4, DefaultIoScheduler.INSTANCE, null, new InterruptibleKt$runInterruptible$2((MusicDatabase) obj2, (RecognitionHistory) obj, null, (byte) 4), 2);
                ((MutableState) obj3).setValue(null);
                break;
            case 5:
                MenuState menuState4 = (MenuState) obj4;
                menuState4.show(new ComposableLambdaImpl(true, 286159686, new OnlineSearchScreenKt$$ExternalSyntheticLambda12((YTItem) obj2, menuState4, (Function0) obj, (CoroutineScope) obj3, (byte) 2)));
                break;
            case 6:
                DefaultScheduler defaultScheduler2 = Dispatchers.Default;
                AwaitKt.launch$default((CoroutineScope) obj4, DefaultIoScheduler.INSTANCE, null, new DataStoreKt$get$2((byte) 18, obj2, obj, (Continuation) null, false), 2);
                ((MutableState) obj3).setValue(Boolean.FALSE);
                break;
            default:
                ((MutableState) obj3).setValue("");
                ((MutableState) obj2).setValue("");
                ((MutableState) obj).setValue("");
                DefaultScheduler defaultScheduler3 = Dispatchers.Default;
                AwaitKt.launch$default((CoroutineScope) obj4, DefaultIoScheduler.INSTANCE, null, new App$Companion$forgetAccount$2(2, null, (byte) 18), 2);
                break;
        }
        return unit;
    }

    public /* synthetic */ AlarmSettingsKt$$ExternalSyntheticLambda30(Object obj, Object obj2, Object obj3, Object obj4, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$2 = obj3;
        this.f$3 = obj4;
    }

    public /* synthetic */ AlarmSettingsKt$$ExternalSyntheticLambda30(List list, SnapshotStateList snapshotStateList, Function0 function0, MenuState menuState) {
        this.$r8$classId = (byte) 2;
        this.f$1 = menuState;
        this.f$0 = list;
        this.f$2 = function0;
        this.f$3 = snapshotStateList;
    }

    public /* synthetic */ AlarmSettingsKt$$ExternalSyntheticLambda30(CoroutineScope coroutineScope, MutableState mutableState, MutableState mutableState2, MutableState mutableState3) {
        this.$r8$classId = (byte) 7;
        this.f$0 = coroutineScope;
        this.f$3 = mutableState;
        this.f$1 = mutableState2;
        this.f$2 = mutableState3;
    }
}
