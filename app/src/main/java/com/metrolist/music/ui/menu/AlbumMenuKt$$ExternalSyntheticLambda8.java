package com.metrolist.music.ui.menu;

import android.content.Intent;
import android.net.Uri;
import androidx.activity.result.ActivityResult;
import androidx.compose.foundation.lazy.LazyListIntervalContent;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda21;
import com.metrolist.music.ui.screens.settings.AiSettingsKt;
import com.metrolist.music.ui.screens.settings.AlarmSettingsKt$AlarmEditorDialog$lambda$27$0$0$$inlined$items$default$3;
import com.yalantis.ucrop.UCrop;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AlbumMenuKt$$ExternalSyntheticLambda8 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ MutableState f$0;
    public final /* synthetic */ MutableState f$1;

    public /* synthetic */ AlbumMenuKt$$ExternalSyntheticLambda8(MutableState mutableState, MutableState mutableState2, byte b) {
        this.$r8$classId = b;
        this.f$0 = mutableState;
        this.f$1 = mutableState2;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Uri output;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        MutableState mutableState = this.f$1;
        MutableState mutableState2 = this.f$0;
        switch (b) {
            case 0:
                LazyListIntervalContent lazyListIntervalContent = (LazyListIntervalContent) obj;
                lazyListIntervalContent.getClass();
                LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, new ComposableLambdaImpl(true, -888442436, new QueueKt$$ExternalSyntheticLambda21(mutableState2, (byte) 10)), 3);
                List list = (List) mutableState.getValue();
                lazyListIntervalContent.items(list.size(), null, new SongMenuKt$SongMenu$lambda$33$0$$inlined$items$default$3(list, (byte) 6), new ComposableLambdaImpl(true, 802480018, new SongMenuKt$SongMenu$lambda$33$0$$inlined$items$default$4((byte) 1, list)));
                break;
            case 1:
                ((Function2) mutableState2.getValue()).invoke(((List) mutableState.getValue()).get(((Integer) obj).intValue()), Boolean.FALSE);
                break;
            case 2:
                LazyListIntervalContent lazyListIntervalContent2 = (LazyListIntervalContent) obj;
                lazyListIntervalContent2.getClass();
                LazyListIntervalContent.item$default(lazyListIntervalContent2, null, null, new ComposableLambdaImpl(true, 539856123, new QueueKt$$ExternalSyntheticLambda21(mutableState2, (byte) 14)), 3);
                List list2 = (List) mutableState.getValue();
                lazyListIntervalContent2.items(list2.size(), null, new SongMenuKt$SongMenu$lambda$33$0$$inlined$items$default$3(list2, (byte) 12), new ComposableLambdaImpl(true, 802480018, new SongMenuKt$SongMenu$lambda$33$0$$inlined$items$default$4((byte) 2, list2)));
                break;
            case 3:
                ActivityResult activityResult = (ActivityResult) obj;
                activityResult.getClass();
                if (activityResult.resultCode == -1) {
                    Intent intent = activityResult.data;
                    if (intent == null || (output = UCrop.getOutput(intent)) == null) {
                        output = (Uri) mutableState.getValue();
                    }
                    if (output != null) {
                        mutableState2.setValue(output);
                    }
                }
                break;
            case 4:
                String str = (String) obj;
                str.getClass();
                mutableState2.setValue(str);
                mutableState.setValue(Boolean.FALSE);
                break;
            case 5:
                String str2 = (String) obj;
                str2.getClass();
                mutableState2.setValue(str2);
                mutableState.setValue(Boolean.FALSE);
                break;
            case 6:
                String str3 = (String) obj;
                str3.getClass();
                mutableState2.setValue(str3);
                mutableState.setValue(Boolean.FALSE);
                break;
            case 7:
                LazyListIntervalContent lazyListIntervalContent3 = (LazyListIntervalContent) obj;
                lazyListIntervalContent3.getClass();
                LazyListIntervalContent.item$default(lazyListIntervalContent3, null, null, AiSettingsKt.lambda$1502671944, 3);
                LazyListIntervalContent.item$default(lazyListIntervalContent3, null, null, AiSettingsKt.f501lambda$178437313, 3);
                if (((Boolean) mutableState2.getValue()).booleanValue()) {
                    LazyListIntervalContent.item$default(lazyListIntervalContent3, null, null, AiSettingsKt.f519lambda$2022482333, 3);
                } else if (!((List) mutableState.getValue()).isEmpty()) {
                    List list3 = (List) mutableState.getValue();
                    lazyListIntervalContent3.items(list3.size(), null, new AlarmSettingsKt$AlarmEditorDialog$lambda$27$0$0$$inlined$items$default$3(list3, (byte) 14), new ComposableLambdaImpl(true, 802480018, new SongMenuKt$SongMenu$lambda$33$0$$inlined$items$default$4((byte) 3, list3)));
                } else {
                    LazyListIntervalContent.item$default(lazyListIntervalContent3, null, null, AiSettingsKt.lambda$2136086604, 3);
                }
                break;
            case 8:
                String str4 = (String) obj;
                str4.getClass();
                mutableState2.setValue(str4);
                mutableState.setValue(null);
                break;
            default:
                String str5 = (String) obj;
                str5.getClass();
                mutableState2.setValue(str5);
                mutableState.setValue(null);
                break;
        }
        return unit;
    }
}
