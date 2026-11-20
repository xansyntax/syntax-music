package com.metrolist.music.ui.screens.search;

import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.text.input.TextFieldValue;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.music.recognition.MusicRecognitionService;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SearchScreenKt$$ExternalSyntheticLambda0 implements Function0 {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ SearchScreenKt$$ExternalSyntheticLambda0(byte b) {
        this.$r8$classId = b;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                return new ParcelableSnapshotMutableIntState(0);
            case 1:
                return Stack.mutableStateOf$default(Boolean.FALSE);
            case 2:
                return Stack.mutableStateOf$default(Boolean.FALSE);
            case 3:
                return Stack.mutableStateOf$default(Boolean.FALSE);
            case 4:
                return Stack.mutableStateOf$default(Boolean.FALSE);
            case 5:
                return Stack.mutableStateOf$default(Boolean.FALSE);
            case 6:
                return new SnapshotStateList();
            case 7:
                return Stack.mutableStateOf$default(null);
            case 8:
                return Stack.mutableStateOf$default(Boolean.FALSE);
            case 9:
                return Stack.mutableStateOf$default(Boolean.FALSE);
            case 10:
                return new SnapshotStateList();
            case 11:
                return Stack.mutableStateOf$default(null);
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                return Stack.mutableStateOf$default(Boolean.FALSE);
            case 13:
                return Stack.mutableStateOf$default(new TextFieldValue(7, 0L, (String) null));
            case 14:
                return Stack.mutableStateOf$default(Boolean.FALSE);
            case 15:
                return Stack.mutableStateOf$default(new TextFieldValue(7, 0L, (String) null));
            case 16:
                return new SnapshotStateList();
            case 17:
                return Stack.mutableStateOf$default(null);
            case 18:
                return Stack.mutableStateOf$default(Boolean.FALSE);
            case 19:
                return Stack.mutableStateOf$default(Boolean.FALSE);
            case 20:
                return Stack.mutableStateOf$default(new TextFieldValue(7, 0L, (String) null));
            case 21:
                MusicRecognitionService musicRecognitionService = MusicRecognitionService.INSTANCE;
                MusicRecognitionService.reset();
                return unit;
            case 22:
                return new ParcelableSnapshotMutableIntState(0);
            case 23:
            case 24:
                return unit;
            case 25:
                return Stack.mutableStateOf$default(new TextFieldValue(7, 0L, (String) null));
            case 26:
                return Stack.mutableStateOf$default(Boolean.FALSE);
            case 27:
                return Stack.mutableStateOf$default(Boolean.FALSE);
            case 28:
                return Stack.mutableStateOf$default(Boolean.FALSE);
            default:
                return Stack.mutableStateOf$default(Boolean.FALSE);
        }
    }
}
