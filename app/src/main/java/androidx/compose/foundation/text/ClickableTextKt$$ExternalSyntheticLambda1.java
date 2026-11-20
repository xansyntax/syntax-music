package androidx.compose.foundation.text;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.input.TextFieldValue;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.music.constants.AddToPlaylistPosition;
import com.metrolist.music.constants.AudioQuality;
import com.metrolist.music.constants.GridItemSize;
import com.metrolist.music.constants.LibraryFilter;
import com.metrolist.music.constants.LoudnessLevel;
import com.metrolist.music.constants.LyricsAnimationStyle;
import com.metrolist.music.constants.MiniPlayerBackgroundStyle;
import com.metrolist.music.constants.PlayerBackgroundStyle;
import com.metrolist.music.constants.PlayerButtonsStyle;
import com.metrolist.music.constants.QuickPicks;
import com.metrolist.music.ui.screens.settings.LyricsPosition;
import com.metrolist.music.ui.screens.settings.NavigationTab;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ClickableTextKt$$ExternalSyntheticLambda1 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ MutableState f$0;
    public final /* synthetic */ Function1 f$1;

    public /* synthetic */ ClickableTextKt$$ExternalSyntheticLambda1(MutableState mutableState, Function1 function1, byte b) {
        this.$r8$classId = b;
        this.f$0 = mutableState;
        this.f$1 = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        MutableState mutableState = this.f$0;
        Function1 function1 = this.f$1;
        switch (b) {
            case 0:
                TextLayoutResult textLayoutResult = (TextLayoutResult) obj;
                mutableState.setValue(textLayoutResult);
                function1.invoke(textLayoutResult);
                break;
            case 1:
                Offset offset = (Offset) obj;
                TextLayoutResult textLayoutResult2 = (TextLayoutResult) mutableState.getValue();
                if (textLayoutResult2 != null) {
                    function1.invoke(Integer.valueOf(textLayoutResult2.multiParagraph.m729getOffsetForPositionk4lQ0M(offset.packedValue)));
                }
                break;
            case 2:
                ((KeyboardActionRunner) obj).getClass();
                function1.invoke(((TextFieldValue) mutableState.getValue()).annotatedString.text);
                break;
            case 3:
                ((KeyboardActionRunner) obj).getClass();
                function1.invoke(((TextFieldValue) mutableState.getValue()).annotatedString.text);
                break;
            case 4:
                LyricsPosition lyricsPosition = (LyricsPosition) obj;
                lyricsPosition.getClass();
                function1.invoke(lyricsPosition);
                mutableState.setValue(Boolean.FALSE);
                break;
            case 5:
                LyricsAnimationStyle lyricsAnimationStyle = (LyricsAnimationStyle) obj;
                lyricsAnimationStyle.getClass();
                function1.invoke(lyricsAnimationStyle);
                mutableState.setValue(Boolean.FALSE);
                break;
            case 6:
                PlayerButtonsStyle playerButtonsStyle = (PlayerButtonsStyle) obj;
                playerButtonsStyle.getClass();
                function1.invoke(playerButtonsStyle);
                mutableState.setValue(Boolean.FALSE);
                break;
            case 7:
                PlayerBackgroundStyle playerBackgroundStyle = (PlayerBackgroundStyle) obj;
                playerBackgroundStyle.getClass();
                function1.invoke(playerBackgroundStyle);
                mutableState.setValue(Boolean.FALSE);
                break;
            case 8:
                MiniPlayerBackgroundStyle miniPlayerBackgroundStyle = (MiniPlayerBackgroundStyle) obj;
                miniPlayerBackgroundStyle.getClass();
                function1.invoke(miniPlayerBackgroundStyle);
                mutableState.setValue(Boolean.FALSE);
                break;
            case 9:
                NavigationTab navigationTab = (NavigationTab) obj;
                navigationTab.getClass();
                function1.invoke(navigationTab);
                mutableState.setValue(Boolean.FALSE);
                break;
            case 10:
                LibraryFilter libraryFilter = (LibraryFilter) obj;
                libraryFilter.getClass();
                function1.invoke(libraryFilter);
                mutableState.setValue(Boolean.FALSE);
                break;
            case 11:
                GridItemSize gridItemSize = (GridItemSize) obj;
                gridItemSize.getClass();
                function1.invoke(gridItemSize);
                mutableState.setValue(Boolean.FALSE);
                break;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                String str = (String) obj;
                str.getClass();
                function1.invoke(str);
                mutableState.setValue(Boolean.FALSE);
                break;
            case 13:
                QuickPicks quickPicks = (QuickPicks) obj;
                quickPicks.getClass();
                function1.invoke(quickPicks);
                mutableState.setValue(Boolean.FALSE);
                break;
            case 14:
                AddToPlaylistPosition addToPlaylistPosition = (AddToPlaylistPosition) obj;
                addToPlaylistPosition.getClass();
                function1.invoke(addToPlaylistPosition);
                mutableState.setValue(Boolean.FALSE);
                break;
            case 15:
                String str2 = (String) obj;
                str2.getClass();
                function1.invoke(str2);
                mutableState.setValue(Boolean.FALSE);
                break;
            case 16:
                String str3 = (String) obj;
                str3.getClass();
                function1.invoke(str3);
                mutableState.setValue(Boolean.FALSE);
                break;
            case 17:
                AudioQuality audioQuality = (AudioQuality) obj;
                audioQuality.getClass();
                function1.invoke(audioQuality);
                mutableState.setValue(Boolean.FALSE);
                break;
            default:
                LoudnessLevel loudnessLevel = (LoudnessLevel) obj;
                loudnessLevel.getClass();
                function1.invoke(loudnessLevel);
                mutableState.setValue(Boolean.FALSE);
                break;
        }
        return unit;
    }

    public /* synthetic */ ClickableTextKt$$ExternalSyntheticLambda1(Function1 function1, MutableState mutableState, byte b) {
        this.$r8$classId = b;
        this.f$1 = function1;
        this.f$0 = mutableState;
    }
}
