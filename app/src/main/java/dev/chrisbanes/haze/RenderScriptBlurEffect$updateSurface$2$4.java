package dev.chrisbanes.haze;

import android.graphics.Bitmap;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.AndroidImageBitmap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.PlatformHapticFeedback;
import coil3.util.LifecyclesKt;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.SearchHistory;
import com.metrolist.music.ui.screens.playlist.LocalPlaylistScreenKt$LocalPlaylistScreen$$inlined$rememberEnumPreference$2;
import com.metrolist.music.ui.screens.search.SearchScreenKt$SearchScreen$$inlined$rememberEnumPreference$2;
import com.metrolist.music.ui.screens.settings.AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$10;
import com.metrolist.music.ui.screens.settings.AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$12;
import com.metrolist.music.ui.screens.settings.AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$14;
import com.metrolist.music.ui.screens.settings.AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$16;
import com.metrolist.music.ui.screens.settings.AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$18;
import com.metrolist.music.ui.screens.settings.AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$2;
import com.metrolist.music.ui.screens.settings.AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$20;
import com.metrolist.music.ui.screens.settings.AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$4;
import com.metrolist.music.ui.screens.settings.AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$6;
import com.metrolist.music.ui.screens.settings.AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$8;
import com.metrolist.music.ui.screens.settings.ContentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$2;
import com.metrolist.music.ui.screens.settings.ContentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$4;
import com.metrolist.music.ui.screens.settings.ContentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$6;
import com.metrolist.music.ui.screens.settings.PlayerSettingsKt$PlayerSettings$$inlined$rememberEnumPreference$2;
import com.metrolist.music.ui.screens.settings.PlayerSettingsKt$PlayerSettings$$inlined$rememberEnumPreference$4;
import com.metrolist.music.ui.screens.settings.ThemeScreenKt$ThemeScreen$$inlined$rememberEnumPreference$2;
import com.metrolist.music.ui.utils.ShowMediaInfoKt$ShowMediaInfo$$inlined$rememberEnumPreference$2;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.AwaitKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class RenderScriptBlurEffect$updateSurface$2$4 implements Function1 {
    public final /* synthetic */ Object $content;
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ RenderScriptBlurEffect$updateSurface$2$4(byte b, Object obj) {
        this.$r8$classId = b;
        this.$content = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Object obj2 = this.$content;
        switch (b) {
            case 0:
                DrawScope drawScope = (DrawScope) obj;
                drawScope.getClass();
                LifecyclesKt.drawLayer(drawScope, (GraphicsLayer) obj2);
                break;
            case 1:
                Enum r7 = (Enum) obj;
                r7.getClass();
                LocalPlaylistScreenKt$LocalPlaylistScreen$$inlined$rememberEnumPreference$2 localPlaylistScreenKt$LocalPlaylistScreen$$inlined$rememberEnumPreference$2 = (LocalPlaylistScreenKt$LocalPlaylistScreen$$inlined$rememberEnumPreference$2) obj2;
                AwaitKt.launch$default(localPlaylistScreenKt$LocalPlaylistScreen$$inlined$rememberEnumPreference$2.$coroutineScope, null, null, new SearchScreenKt$SearchScreen$$inlined$rememberEnumPreference$2.AnonymousClass1(localPlaylistScreenKt$LocalPlaylistScreen$$inlined$rememberEnumPreference$2.$context, localPlaylistScreenKt$LocalPlaylistScreen$$inlined$rememberEnumPreference$2.$key, r7, null, (byte) 22), 3);
                break;
            case 2:
                MusicDatabase musicDatabase = (MusicDatabase) obj;
                musicDatabase.getClass();
                musicDatabase.$$delegate_0.delete((SearchHistory) obj2);
                break;
            case 3:
                Enum r8 = (Enum) obj;
                r8.getClass();
                SearchScreenKt$SearchScreen$$inlined$rememberEnumPreference$2 searchScreenKt$SearchScreen$$inlined$rememberEnumPreference$2 = (SearchScreenKt$SearchScreen$$inlined$rememberEnumPreference$2) obj2;
                AwaitKt.launch$default(searchScreenKt$SearchScreen$$inlined$rememberEnumPreference$2.$coroutineScope, null, null, new SearchScreenKt$SearchScreen$$inlined$rememberEnumPreference$2.AnonymousClass1(searchScreenKt$SearchScreen$$inlined$rememberEnumPreference$2.$context, searchScreenKt$SearchScreen$$inlined$rememberEnumPreference$2.$key, r8, null, (byte) 0), 3);
                break;
            case 4:
                long j = ((Offset) obj).packedValue;
                ((PlatformHapticFeedback) ((HapticFeedback) obj2)).m578performHapticFeedbackCdsT49E(0);
                break;
            case 5:
                Enum r17 = (Enum) obj;
                r17.getClass();
                AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$10 appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$10 = (AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$10) obj2;
                AwaitKt.launch$default(appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$10.$coroutineScope, null, null, new SearchScreenKt$SearchScreen$$inlined$rememberEnumPreference$2.AnonymousClass1(appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$10.$context, appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$10.$key, r17, null, (byte) 23), 3);
                break;
            case 6:
                Enum r12 = (Enum) obj;
                r12.getClass();
                AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$12 appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$12 = (AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$12) obj2;
                AwaitKt.launch$default(appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$12.$coroutineScope, null, null, new SearchScreenKt$SearchScreen$$inlined$rememberEnumPreference$2.AnonymousClass1(appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$12.$context, appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$12.$key, r12, null, (byte) 24), 3);
                break;
            case 7:
                Enum r9 = (Enum) obj;
                r9.getClass();
                AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$14 appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$14 = (AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$14) obj2;
                AwaitKt.launch$default(appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$14.$coroutineScope, null, null, new SearchScreenKt$SearchScreen$$inlined$rememberEnumPreference$2.AnonymousClass1(appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$14.$context, appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$14.$key, r9, null, (byte) 25), 3);
                break;
            case 8:
                Enum r18 = (Enum) obj;
                r18.getClass();
                AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$16 appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$16 = (AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$16) obj2;
                AwaitKt.launch$default(appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$16.$coroutineScope, null, null, new SearchScreenKt$SearchScreen$$inlined$rememberEnumPreference$2.AnonymousClass1(appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$16.$context, appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$16.$key, r18, null, (byte) 26), 3);
                break;
            case 9:
                Enum r13 = (Enum) obj;
                r13.getClass();
                AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$18 appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$18 = (AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$18) obj2;
                AwaitKt.launch$default(appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$18.$coroutineScope, null, null, new SearchScreenKt$SearchScreen$$inlined$rememberEnumPreference$2.AnonymousClass1(appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$18.$context, appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$18.$key, r13, null, (byte) 27), 3);
                break;
            case 10:
                Enum r10 = (Enum) obj;
                r10.getClass();
                AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$2 appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$2 = (AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$2) obj2;
                AwaitKt.launch$default(appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$2.$coroutineScope, null, null, new SearchScreenKt$SearchScreen$$inlined$rememberEnumPreference$2.AnonymousClass1(appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$2.$context, appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$2.$key, r10, null, (byte) 28), 3);
                break;
            case 11:
                Enum r19 = (Enum) obj;
                r19.getClass();
                AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$20 appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$20 = (AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$20) obj2;
                AwaitKt.launch$default(appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$20.$coroutineScope, null, null, new SearchScreenKt$SearchScreen$$inlined$rememberEnumPreference$2.AnonymousClass1(appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$20.$context, appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$20.$key, r19, null, (byte) 29), 3);
                break;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                Enum r14 = (Enum) obj;
                r14.getClass();
                AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$4 appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$4 = (AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$4) obj2;
                AwaitKt.launch$default(appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$4.$coroutineScope, null, null, new ShowMediaInfoKt$ShowMediaInfo$$inlined$rememberEnumPreference$2.AnonymousClass1(appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$4.$context, appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$4.$key, r14, null, (byte) 1), 3);
                break;
            case 13:
                Enum r11 = (Enum) obj;
                r11.getClass();
                AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$6 appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$6 = (AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$6) obj2;
                AwaitKt.launch$default(appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$6.$coroutineScope, null, null, new ShowMediaInfoKt$ShowMediaInfo$$inlined$rememberEnumPreference$2.AnonymousClass1(appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$6.$context, appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$6.$key, r11, null, (byte) 2), 3);
                break;
            case 14:
                Enum r110 = (Enum) obj;
                r110.getClass();
                AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$8 appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$8 = (AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$8) obj2;
                AwaitKt.launch$default(appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$8.$coroutineScope, null, null, new ShowMediaInfoKt$ShowMediaInfo$$inlined$rememberEnumPreference$2.AnonymousClass1(appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$8.$context, appearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$8.$key, r110, null, (byte) 3), 3);
                break;
            case 15:
                Enum r15 = (Enum) obj;
                r15.getClass();
                ContentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$2 contentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$2 = (ContentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$2) obj2;
                AwaitKt.launch$default(contentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$2.$coroutineScope, null, null, new ShowMediaInfoKt$ShowMediaInfo$$inlined$rememberEnumPreference$2.AnonymousClass1(contentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$2.$context, contentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$2.$key, r15, null, (byte) 4), 3);
                break;
            case 16:
                Enum r16 = (Enum) obj;
                r16.getClass();
                ContentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$4 contentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$4 = (ContentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$4) obj2;
                AwaitKt.launch$default(contentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$4.$coroutineScope, null, null, new ShowMediaInfoKt$ShowMediaInfo$$inlined$rememberEnumPreference$2.AnonymousClass1(contentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$4.$context, contentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$4.$key, r16, null, (byte) 5), 3);
                break;
            case 17:
                Enum r111 = (Enum) obj;
                r111.getClass();
                ContentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$6 contentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$6 = (ContentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$6) obj2;
                AwaitKt.launch$default(contentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$6.$coroutineScope, null, null, new ShowMediaInfoKt$ShowMediaInfo$$inlined$rememberEnumPreference$2.AnonymousClass1(contentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$6.$context, contentSettingsKt$ContentSettings$$inlined$rememberEnumPreference$6.$key, r111, null, (byte) 6), 3);
                break;
            case 18:
                Enum r112 = (Enum) obj;
                r112.getClass();
                PlayerSettingsKt$PlayerSettings$$inlined$rememberEnumPreference$2 playerSettingsKt$PlayerSettings$$inlined$rememberEnumPreference$2 = (PlayerSettingsKt$PlayerSettings$$inlined$rememberEnumPreference$2) obj2;
                AwaitKt.launch$default(playerSettingsKt$PlayerSettings$$inlined$rememberEnumPreference$2.$coroutineScope, null, null, new ShowMediaInfoKt$ShowMediaInfo$$inlined$rememberEnumPreference$2.AnonymousClass1(playerSettingsKt$PlayerSettings$$inlined$rememberEnumPreference$2.$context, playerSettingsKt$PlayerSettings$$inlined$rememberEnumPreference$2.$key, r112, null, (byte) 7), 3);
                break;
            case 19:
                Enum r20 = (Enum) obj;
                r20.getClass();
                PlayerSettingsKt$PlayerSettings$$inlined$rememberEnumPreference$4 playerSettingsKt$PlayerSettings$$inlined$rememberEnumPreference$4 = (PlayerSettingsKt$PlayerSettings$$inlined$rememberEnumPreference$4) obj2;
                AwaitKt.launch$default(playerSettingsKt$PlayerSettings$$inlined$rememberEnumPreference$4.$coroutineScope, null, null, new ShowMediaInfoKt$ShowMediaInfo$$inlined$rememberEnumPreference$2.AnonymousClass1(playerSettingsKt$PlayerSettings$$inlined$rememberEnumPreference$4.$context, playerSettingsKt$PlayerSettings$$inlined$rememberEnumPreference$4.$key, r20, null, (byte) 8), 3);
                break;
            case 20:
                Enum r113 = (Enum) obj;
                r113.getClass();
                ThemeScreenKt$ThemeScreen$$inlined$rememberEnumPreference$2 themeScreenKt$ThemeScreen$$inlined$rememberEnumPreference$2 = (ThemeScreenKt$ThemeScreen$$inlined$rememberEnumPreference$2) obj2;
                AwaitKt.launch$default(themeScreenKt$ThemeScreen$$inlined$rememberEnumPreference$2.$coroutineScope, null, null, new ShowMediaInfoKt$ShowMediaInfo$$inlined$rememberEnumPreference$2.AnonymousClass1(themeScreenKt$ThemeScreen$$inlined$rememberEnumPreference$2.$context, themeScreenKt$ThemeScreen$$inlined$rememberEnumPreference$2.$key, r113, null, (byte) 9), 3);
                break;
            case 21:
                Enum r21 = (Enum) obj;
                r21.getClass();
                ShowMediaInfoKt$ShowMediaInfo$$inlined$rememberEnumPreference$2 showMediaInfoKt$ShowMediaInfo$$inlined$rememberEnumPreference$2 = (ShowMediaInfoKt$ShowMediaInfo$$inlined$rememberEnumPreference$2) obj2;
                AwaitKt.launch$default(showMediaInfoKt$ShowMediaInfo$$inlined$rememberEnumPreference$2.$coroutineScope, null, null, new ShowMediaInfoKt$ShowMediaInfo$$inlined$rememberEnumPreference$2.AnonymousClass1(showMediaInfoKt$ShowMediaInfo$$inlined$rememberEnumPreference$2.$context, showMediaInfoKt$ShowMediaInfo$$inlined$rememberEnumPreference$2.$key, r21, null, (byte) 0), 3);
                break;
            default:
                DrawScope drawScope2 = (DrawScope) obj;
                drawScope2.getClass();
                DrawScope.m545drawImagegbVJVH8$default(drawScope2, new AndroidImageBitmap((Bitmap) obj2), null, 62);
                break;
        }
        return unit;
    }
}
