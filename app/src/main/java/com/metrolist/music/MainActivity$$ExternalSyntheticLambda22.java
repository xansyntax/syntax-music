package com.metrolist.music;

import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.foundation.text.selection.SelectionMagnifierKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDestination;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.music.db.entities.LyricsEntity;
import com.metrolist.music.db.entities.Song;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MainActivity$$ExternalSyntheticLambda22 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ State f$0;

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda22(State state, byte b) {
        this.$r8$classId = b;
        this.f$0 = state;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        NavDestination navDestination;
        byte b = this.$r8$classId;
        boolean z = false;
        float fFloatValue = CropImageView.DEFAULT_ASPECT_RATIO;
        State state = this.f$0;
        switch (b) {
            case 0:
                int i = MainActivity.$r8$clinit;
                NavBackStackEntry navBackStackEntry = (NavBackStackEntry) state.getValue();
                if (navBackStackEntry == null || (navDestination = navBackStackEntry.destination) == null) {
                    return null;
                }
                return (String) navDestination.impl.layoutNodes;
            case 1:
                Offset offset = (Offset) state.getValue();
                long j = offset.packedValue;
                return offset;
            case 2:
                AnimationVector2D animationVector2D = SelectionMagnifierKt.UnspecifiedAnimationVector2D;
                Offset offset2 = (Offset) state.getValue();
                long j2 = offset2.packedValue;
                return offset2;
            case 3:
                return Float.valueOf(((Number) state.getValue()).floatValue());
            case 4:
                return Float.valueOf(((Number) state.getValue()).floatValue());
            case 5:
                return Float.valueOf(((Number) state.getValue()).floatValue());
            case 6:
                return Boolean.valueOf((state != null ? ((Number) state.getValue()).floatValue() : 0.0f) > CropImageView.DEFAULT_ASPECT_RATIO);
            case 7:
                return Float.valueOf(state != null ? ((Number) state.getValue()).floatValue() : 1.0f);
            case 8:
                if (state != null) {
                    fFloatValue = ((Number) state.getValue()).floatValue();
                }
                return Float.valueOf(fFloatValue);
            case 9:
                if (state != null) {
                    fFloatValue = ((Number) state.getValue()).floatValue();
                }
                return Float.valueOf(fFloatValue);
            case 10:
                return Boolean.valueOf((state != null ? ((Number) state.getValue()).floatValue() : 0.0f) > CropImageView.DEFAULT_ASPECT_RATIO);
            case 11:
                List list = (List) state.getValue();
                ArrayList arrayList = new ArrayList();
                for (Object obj : list) {
                    if (Intrinsics.areEqual(((NavBackStackEntry) obj).destination.navigatorName, "composable")) {
                        arrayList.add(obj);
                    }
                }
                return arrayList;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                int i2 = MainActivity.$r8$clinit;
                String str = (String) state.getValue();
                if (str != null && StringsKt__StringsJVMKt.startsWith(str, "search/", false)) {
                    z = true;
                }
                return Boolean.valueOf(z);
            case 13:
                return Long.valueOf(((Number) state.getValue()).longValue());
            case 14:
                return Long.valueOf(((Number) state.getValue()).longValue());
            case 15:
                return Long.valueOf(((Number) state.getValue()).longValue());
            case 16:
                return (LyricsEntity) state.getValue();
            case 17:
                Song song = (Song) state.getValue();
                if (song != null) {
                    return song.song;
                }
                return null;
            case 18:
                Song song2 = (Song) state.getValue();
                if (song2 != null) {
                    return song2.song;
                }
                return null;
            case 19:
                return Float.valueOf(((Number) state.getValue()).floatValue());
            default:
                return Float.valueOf(((Number) state.getValue()).floatValue());
        }
    }
}
