package androidx.compose.material3;

import androidx.activity.compose.BackHandlerKt$BackHandler$lambda$4$0$$inlined$onDispose$1;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.core.view.MenuHostHelper$$ExternalSyntheticLambda1;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.AlbumWithSongs;
import com.metrolist.music.db.entities.EventWithSong;
import com.metrolist.music.db.entities.Playlist;
import com.metrolist.music.db.entities.PlaylistEntity;
import com.metrolist.music.ui.screens.HomeScreenKt;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class TooltipKt$$ExternalSyntheticLambda5 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ MutableState f$0;

    public /* synthetic */ TooltipKt$$ExternalSyntheticLambda5(MutableState mutableState, byte b) {
        this.$r8$classId = b;
        this.f$0 = mutableState;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        MutableState mutableState = this.f$0;
        switch (b) {
            case 0:
                mutableState.setValue((LayoutCoordinates) obj);
                return unit;
            case 1:
                Float f = (Float) obj;
                f.getClass();
                ((Function1) mutableState.getValue()).invoke(f);
                return unit;
            case 2:
                Float f2 = (Float) obj;
                f2.getClass();
                return Float.valueOf(((Number) ((Function1) mutableState.getValue()).invoke(f2)).floatValue());
            case 3:
                TextAnnotatedStringNode.TextSubstitutionValue textSubstitutionValue = (TextAnnotatedStringNode.TextSubstitutionValue) obj;
                mutableState.setValue(textSubstitutionValue.isShowingSubstitution ? textSubstitutionValue.substitution : textSubstitutionValue.original);
                return unit;
            case 4:
                Object obj2 = (List) obj;
                if (mutableState != null) {
                    mutableState.setValue(obj2);
                }
                return unit;
            case 5:
                ((Function1) mutableState.getValue()).invoke((Offset) obj);
                return unit;
            case 6:
                mutableState.setValue((LayoutCoordinates) obj);
                return unit;
            case 7:
                mutableState.setValue((LayoutCoordinates) obj);
                return unit;
            case 8:
                mutableState.setValue((LayoutCoordinates) obj);
                return unit;
            case 9:
                mutableState.setValue(new Offset(((LayoutCoordinates) obj).mo607localToScreenMKHz9U(0L)));
                return unit;
            case 10:
                Object obj3 = (TextFieldValue) obj;
                obj3.getClass();
                mutableState.setValue(obj3);
                return unit;
            case 11:
                TextLayoutResult textLayoutResult = (TextLayoutResult) obj;
                textLayoutResult.getClass();
                mutableState.setValue(Boolean.valueOf(textLayoutResult.getHasVisualOverflow() || textLayoutResult.multiParagraph.lineCount > 3));
                return unit;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                ReusableGraphicsLayerScope reusableGraphicsLayerScope = (ReusableGraphicsLayerScope) obj;
                reusableGraphicsLayerScope.getClass();
                reusableGraphicsLayerScope.setShadowElevation(reusableGraphicsLayerScope.graphicsDensity.getDensity() * (((Boolean) mutableState.getValue()).booleanValue() ? 6.0f : 3.0f));
                reusableGraphicsLayerScope.setShape(RoundedCornerShapeKt.RoundedCornerShape(50));
                reusableGraphicsLayerScope.setClip(false);
                reusableGraphicsLayerScope.m515setAmbientShadowColor8_81llA(ColorKt.Color(Color.m485getRedimpl(-72057594037927936L), Color.m484getGreenimpl(-72057594037927936L), Color.m482getBlueimpl(-72057594037927936L), 0.25f, Color.m483getColorSpaceimpl(-72057594037927936L)));
                reusableGraphicsLayerScope.m516setSpotShadowColor8_81llA(ColorKt.Color(Color.m485getRedimpl(-72057594037927936L), Color.m484getGreenimpl(-72057594037927936L), Color.m482getBlueimpl(-72057594037927936L), 0.35f, Color.m483getColorSpaceimpl(-72057594037927936L)));
                return unit;
            case 13:
                Boolean bool = (Boolean) obj;
                bool.booleanValue();
                mutableState.setValue(bool);
                return unit;
            case 14:
                Boolean bool2 = (Boolean) obj;
                bool2.booleanValue();
                mutableState.setValue(bool2);
                return unit;
            case 15:
                Boolean bool3 = (Boolean) obj;
                bool3.booleanValue();
                mutableState.setValue(bool3);
                return unit;
            case 16:
                Boolean bool4 = (Boolean) obj;
                bool4.booleanValue();
                mutableState.setValue(bool4);
                return unit;
            case 17:
                Boolean bool5 = (Boolean) obj;
                bool5.booleanValue();
                mutableState.setValue(bool5);
                return unit;
            case 18:
                Object obj4 = (String) obj;
                obj4.getClass();
                mutableState.setValue(obj4);
                return unit;
            case 19:
                String str = (String) obj;
                str.getClass();
                String upperCase = str.toUpperCase(Locale.ROOT);
                upperCase.getClass();
                StringBuilder sb = new StringBuilder();
                int length = upperCase.length();
                for (int i = 0; i < length; i++) {
                    char cCharAt = upperCase.charAt(i);
                    if (Character.isLetterOrDigit(cCharAt)) {
                        sb.append(cCharAt);
                    }
                }
                mutableState.setValue(StringsKt.take(8, sb.toString()));
                return unit;
            case 20:
                MusicDatabase musicDatabase = (MusicDatabase) obj;
                musicDatabase.getClass();
                AlbumWithSongs albumWithSongs = (AlbumWithSongs) mutableState.getValue();
                if (albumWithSongs != null) {
                    musicDatabase.$$delegate_0.update(albumWithSongs.album.toggleLike());
                }
                return unit;
            case 21:
                Object obj5 = (TextLayoutResult) obj;
                obj5.getClass();
                mutableState.setValue(obj5);
                return unit;
            case 22:
                ((DisposableEffectScope) obj).getClass();
                LifecycleRegistry lifecycleRegistry = ProcessLifecycleOwner.newInstance.registry;
                MenuHostHelper$$ExternalSyntheticLambda1 menuHostHelper$$ExternalSyntheticLambda1 = new MenuHostHelper$$ExternalSyntheticLambda1(lifecycleRegistry, mutableState, (byte) 2);
                lifecycleRegistry.addObserver(menuHostHelper$$ExternalSyntheticLambda1);
                return new BackHandlerKt$BackHandler$lambda$4$0$$inlined$onDispose$1(lifecycleRegistry, menuHostHelper$$ExternalSyntheticLambda1, (byte) 15);
            case 23:
                Object obj6 = (TextFieldValue) obj;
                obj6.getClass();
                mutableState.setValue(obj6);
                return unit;
            case 24:
                MusicDatabase musicDatabase2 = (MusicDatabase) obj;
                List list = HomeScreenKt.DailyDiscoverMessages;
                Playlist playlist = (Playlist) mutableState.getValue();
                playlist.getClass();
                PlaylistEntity playlistEntity = playlist.playlist.toggleLike();
                musicDatabase2.getClass();
                musicDatabase2.$$delegate_0.update(playlistEntity);
                return unit;
            case 25:
                Object obj7 = (String) obj;
                obj7.getClass();
                mutableState.setValue(obj7);
                return unit;
            case 26:
                Object obj8 = (String) obj;
                obj8.getClass();
                mutableState.setValue(obj8);
                return unit;
            case 27:
                LocalDateTime localDateTime = (LocalDateTime) obj;
                localDateTime.getClass();
                EventWithSong eventWithSong = (EventWithSong) mutableState.getValue();
                return Boolean.valueOf(localDateTime.isAfter(eventWithSong != null ? eventWithSong.event.timestamp.withDayOfMonth(1) : null));
            case 28:
                LocalDateTime localDateTime2 = (LocalDateTime) obj;
                localDateTime2.getClass();
                EventWithSong eventWithSong2 = (EventWithSong) mutableState.getValue();
                return Boolean.valueOf(localDateTime2.isAfter(eventWithSong2 != null ? eventWithSong2.event.timestamp : null));
            default:
                Object obj9 = (TextFieldValue) obj;
                obj9.getClass();
                mutableState.setValue(obj9);
                return unit;
        }
    }
}
