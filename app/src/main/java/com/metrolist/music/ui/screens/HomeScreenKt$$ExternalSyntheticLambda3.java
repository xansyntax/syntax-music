package com.metrolist.music.ui.screens;

import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.PlatformHapticFeedback;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.navigation.NavHostController;
import com.metrolist.innertube.models.YTItem;
import com.metrolist.music.db.entities.Album;
import com.metrolist.music.db.entities.Artist;
import com.metrolist.music.db.entities.LocalItem;
import com.metrolist.music.db.entities.Playlist;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.ui.component.MenuKt;
import com.metrolist.music.ui.component.MenuState;
import com.metrolist.music.ui.menu.AlbumMenuKt;
import com.metrolist.music.ui.menu.SongMenuKt;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda63;
import com.metrolist.music.ui.player.PlayerKt$$ExternalSyntheticLambda37;
import com.metrolist.music.utils.DataStoreKt$rememberPreference$1$1;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class HomeScreenKt$$ExternalSyntheticLambda3 implements Function3 {
    public final /* synthetic */ byte $r8$classId = 1;
    public final /* synthetic */ HapticFeedback f$0;
    public final /* synthetic */ MenuState f$1;
    public final /* synthetic */ boolean f$2;
    public final /* synthetic */ State f$3;
    public final /* synthetic */ PlayerConnection f$4;
    public final /* synthetic */ MutableState f$5;
    public final /* synthetic */ NavHostController f$6;
    public final /* synthetic */ CoroutineScope f$7;
    public final /* synthetic */ State f$8;

    public /* synthetic */ HomeScreenKt$$ExternalSyntheticLambda3(HapticFeedback hapticFeedback, MenuState menuState, CoroutineScope coroutineScope, boolean z, PlayerConnection playerConnection, DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1, NavHostController navHostController, MutableState mutableState, MutableState mutableState2) {
        this.f$0 = hapticFeedback;
        this.f$1 = menuState;
        this.f$7 = coroutineScope;
        this.f$2 = z;
        this.f$4 = playerConnection;
        this.f$5 = dataStoreKt$rememberPreference$1$1;
        this.f$6 = navHostController;
        this.f$3 = mutableState;
        this.f$8 = mutableState2;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        MediaMetadata.Album album;
        State state;
        MediaMetadata.Album album2;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        State state2 = this.f$8;
        final byte b2 = 0;
        switch (b) {
            case 0:
                final LocalItem localItem = (LocalItem) obj;
                Composer composer = (Composer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                localItem.getClass();
                if ((iIntValue & 6) == 0) {
                    iIntValue |= (iIntValue & 8) == 0 ? ((GapComposer) composer).changed(localItem) : ((GapComposer) composer).changedInstance(localItem) ? 4 : 2;
                }
                GapComposer gapComposer = (GapComposer) composer;
                if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 19) != 18)) {
                    boolean z = localItem instanceof Song;
                    final HapticFeedback hapticFeedback = this.f$0;
                    final MenuState menuState = this.f$1;
                    State state3 = this.f$3;
                    if (z) {
                        gapComposer.startReplaceGroup(-20480042);
                        Song song = (Song) localItem;
                        Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
                        int i = iIntValue & 14;
                        boolean zChangedInstance = gapComposer.changedInstance(hapticFeedback) | gapComposer.changed(menuState) | (i == 4 || ((iIntValue & 8) != 0 && gapComposer.changedInstance(localItem)));
                        Object objRememberedValue = gapComposer.rememberedValue();
                        if (zChangedInstance || objRememberedValue == neverEqualPolicy) {
                            objRememberedValue = new Function0() { // from class: com.metrolist.music.ui.screens.HomeScreenKt$$ExternalSyntheticLambda11
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    byte b3 = b2;
                                    Unit unit2 = Unit.INSTANCE;
                                    final LocalItem localItem2 = localItem;
                                    final MenuState menuState2 = menuState;
                                    HapticFeedback hapticFeedback2 = hapticFeedback;
                                    final byte b4 = 1;
                                    final byte b5 = 0;
                                    switch (b3) {
                                        case 0:
                                            ((PlatformHapticFeedback) hapticFeedback2).m578performHapticFeedbackCdsT49E(0);
                                            menuState2.show(new ComposableLambdaImpl(true, 266973342, new Function3() { // from class: com.metrolist.music.ui.screens.HomeScreenKt$$ExternalSyntheticLambda19
                                                @Override // kotlin.jvm.functions.Function3
                                                public final Object invoke(Object obj4, Object obj5, Object obj6) {
                                                    byte b6 = b4;
                                                    Unit unit3 = Unit.INSTANCE;
                                                    NeverEqualPolicy neverEqualPolicy2 = Composer.Companion.Empty;
                                                    LocalItem localItem3 = localItem2;
                                                    switch (b6) {
                                                        case 0:
                                                            Composer composer2 = (Composer) obj5;
                                                            int iIntValue2 = ((Integer) obj6).intValue();
                                                            ((ColumnScopeInstance) obj4).getClass();
                                                            GapComposer gapComposer2 = (GapComposer) composer2;
                                                            if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                                                                gapComposer2.skipToGroupEnd();
                                                            } else {
                                                                Album album3 = (Album) localItem3;
                                                                MenuState menuState3 = menuState2;
                                                                boolean zChanged = gapComposer2.changed(menuState3);
                                                                Object objRememberedValue2 = gapComposer2.rememberedValue();
                                                                if (zChanged || objRememberedValue2 == neverEqualPolicy2) {
                                                                    LoginScreenKt$LoginScreen$1$3$2$1 loginScreenKt$LoginScreen$1$3$2$1 = new LoginScreenKt$LoginScreen$1$3$2$1(0, menuState3, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 2);
                                                                    gapComposer2.updateRememberedValue(loginScreenKt$LoginScreen$1$3$2$1);
                                                                    objRememberedValue2 = loginScreenKt$LoginScreen$1$3$2$1;
                                                                }
                                                                AlbumMenuKt.AlbumMenu(album3, (Function0) ((KFunction) objRememberedValue2), gapComposer2, 0);
                                                            }
                                                            break;
                                                        default:
                                                            Composer composer3 = (Composer) obj5;
                                                            int iIntValue3 = ((Integer) obj6).intValue();
                                                            ((ColumnScopeInstance) obj4).getClass();
                                                            GapComposer gapComposer3 = (GapComposer) composer3;
                                                            if (!gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 17) != 16)) {
                                                                gapComposer3.skipToGroupEnd();
                                                            } else {
                                                                Song song2 = (Song) localItem3;
                                                                MenuState menuState4 = menuState2;
                                                                boolean zChanged2 = gapComposer3.changed(menuState4);
                                                                Object objRememberedValue3 = gapComposer3.rememberedValue();
                                                                if (zChanged2 || objRememberedValue3 == neverEqualPolicy2) {
                                                                    objRememberedValue3 = new LoginScreenKt$LoginScreen$1$3$2$1(0, menuState4, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 1);
                                                                    gapComposer3.updateRememberedValue(objRememberedValue3);
                                                                }
                                                                SongMenuKt.SongMenu(song2, null, null, null, (Function0) ((KFunction) objRememberedValue3), false, gapComposer3, 0, 46);
                                                            }
                                                            break;
                                                    }
                                                    return unit3;
                                                }
                                            }));
                                            break;
                                        default:
                                            ((PlatformHapticFeedback) hapticFeedback2).m578performHapticFeedbackCdsT49E(0);
                                            menuState2.show(new ComposableLambdaImpl(true, -601231405, new Function3() { // from class: com.metrolist.music.ui.screens.HomeScreenKt$$ExternalSyntheticLambda19
                                                @Override // kotlin.jvm.functions.Function3
                                                public final Object invoke(Object obj4, Object obj5, Object obj6) {
                                                    byte b6 = b5;
                                                    Unit unit3 = Unit.INSTANCE;
                                                    NeverEqualPolicy neverEqualPolicy2 = Composer.Companion.Empty;
                                                    LocalItem localItem3 = localItem2;
                                                    switch (b6) {
                                                        case 0:
                                                            Composer composer2 = (Composer) obj5;
                                                            int iIntValue2 = ((Integer) obj6).intValue();
                                                            ((ColumnScopeInstance) obj4).getClass();
                                                            GapComposer gapComposer2 = (GapComposer) composer2;
                                                            if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                                                                gapComposer2.skipToGroupEnd();
                                                            } else {
                                                                Album album3 = (Album) localItem3;
                                                                MenuState menuState3 = menuState2;
                                                                boolean zChanged = gapComposer2.changed(menuState3);
                                                                Object objRememberedValue2 = gapComposer2.rememberedValue();
                                                                if (zChanged || objRememberedValue2 == neverEqualPolicy2) {
                                                                    LoginScreenKt$LoginScreen$1$3$2$1 loginScreenKt$LoginScreen$1$3$2$1 = new LoginScreenKt$LoginScreen$1$3$2$1(0, menuState3, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 2);
                                                                    gapComposer2.updateRememberedValue(loginScreenKt$LoginScreen$1$3$2$1);
                                                                    objRememberedValue2 = loginScreenKt$LoginScreen$1$3$2$1;
                                                                }
                                                                AlbumMenuKt.AlbumMenu(album3, (Function0) ((KFunction) objRememberedValue2), gapComposer2, 0);
                                                            }
                                                            break;
                                                        default:
                                                            Composer composer3 = (Composer) obj5;
                                                            int iIntValue3 = ((Integer) obj6).intValue();
                                                            ((ColumnScopeInstance) obj4).getClass();
                                                            GapComposer gapComposer3 = (GapComposer) composer3;
                                                            if (!gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 17) != 16)) {
                                                                gapComposer3.skipToGroupEnd();
                                                            } else {
                                                                Song song2 = (Song) localItem3;
                                                                MenuState menuState4 = menuState2;
                                                                boolean zChanged2 = gapComposer3.changed(menuState4);
                                                                Object objRememberedValue3 = gapComposer3.rememberedValue();
                                                                if (zChanged2 || objRememberedValue3 == neverEqualPolicy2) {
                                                                    objRememberedValue3 = new LoginScreenKt$LoginScreen$1$3$2$1(0, menuState4, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 1);
                                                                    gapComposer3.updateRememberedValue(objRememberedValue3);
                                                                }
                                                                SongMenuKt.SongMenu(song2, null, null, null, (Function0) ((KFunction) objRememberedValue3), false, gapComposer3, 0, 46);
                                                            }
                                                            break;
                                                    }
                                                    return unit3;
                                                }
                                            }));
                                            break;
                                    }
                                    return unit2;
                                }
                            };
                            gapComposer.updateRememberedValue(objRememberedValue);
                        }
                        Function0 function0 = (Function0) objRememberedValue;
                        boolean z2 = this.f$2;
                        boolean zChanged = (i == 4 || ((iIntValue & 8) != 0 && gapComposer.changedInstance(localItem))) | gapComposer.changed(z2) | gapComposer.changed(state3);
                        PlayerConnection playerConnection = this.f$4;
                        boolean zChangedInstance2 = zChanged | gapComposer.changedInstance(playerConnection);
                        MutableState mutableState = this.f$5;
                        boolean zChanged2 = zChangedInstance2 | gapComposer.changed(mutableState);
                        Object objRememberedValue2 = gapComposer.rememberedValue();
                        if (zChanged2 || objRememberedValue2 == neverEqualPolicy) {
                            state = state3;
                            objRememberedValue2 = new PlayerKt$$ExternalSyntheticLambda37(z2, localItem, playerConnection, state, mutableState);
                            gapComposer.updateRememberedValue(objRememberedValue2);
                        } else {
                            state = state3;
                        }
                        Modifier modifierM48combinedClickablehoGz1lA$default = ImageKt.m48combinedClickablehoGz1lA$default(modifierFillMaxWidth, false, function0, (Function0) objRememberedValue2, 239);
                        String str = song.song.id;
                        MediaMetadata mediaMetadata = (MediaMetadata) state.getValue();
                        MenuKt.SongGridItem(song, modifierM48combinedClickablehoGz1lA$default, false, false, false, null, Intrinsics.areEqual(str, mediaMetadata != null ? mediaMetadata.id : null), ((Boolean) state2.getValue()).booleanValue(), false, gapComposer, i, 316);
                        gapComposer.end(false);
                    } else {
                        boolean z3 = localItem instanceof Album;
                        final NavHostController navHostController = this.f$6;
                        CoroutineScope coroutineScope = this.f$7;
                        if (z3) {
                            gapComposer.startReplaceGroup(-18426695);
                            Album album3 = (Album) localItem;
                            String str2 = album3.album.id;
                            MediaMetadata mediaMetadata2 = (MediaMetadata) state3.getValue();
                            boolean zAreEqual = Intrinsics.areEqual(str2, (mediaMetadata2 == null || (album = mediaMetadata2.album) == null) ? null : album.id);
                            boolean zBooleanValue = ((Boolean) state2.getValue()).booleanValue();
                            Modifier modifierFillMaxWidth2 = SizeKt.fillMaxWidth(companion, 1.0f);
                            int i2 = iIntValue & 14;
                            boolean zChangedInstance3 = gapComposer.changedInstance(hapticFeedback) | gapComposer.changed(menuState) | (i2 == 4 || ((iIntValue & 8) != 0 && gapComposer.changedInstance(localItem)));
                            Object objRememberedValue3 = gapComposer.rememberedValue();
                            if (zChangedInstance3 || objRememberedValue3 == neverEqualPolicy) {
                                final byte b3 = 1;
                                objRememberedValue3 = new Function0() { // from class: com.metrolist.music.ui.screens.HomeScreenKt$$ExternalSyntheticLambda11
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        byte b4 = b3;
                                        Unit unit2 = Unit.INSTANCE;
                                        final LocalItem localItem2 = localItem;
                                        final MenuState menuState2 = menuState;
                                        HapticFeedback hapticFeedback2 = hapticFeedback;
                                        final byte b5 = 1;
                                        final byte b6 = 0;
                                        switch (b4) {
                                            case 0:
                                                ((PlatformHapticFeedback) hapticFeedback2).m578performHapticFeedbackCdsT49E(0);
                                                menuState2.show(new ComposableLambdaImpl(true, 266973342, new Function3() { // from class: com.metrolist.music.ui.screens.HomeScreenKt$$ExternalSyntheticLambda19
                                                    @Override // kotlin.jvm.functions.Function3
                                                    public final Object invoke(Object obj4, Object obj5, Object obj6) {
                                                        byte b7 = b5;
                                                        Unit unit3 = Unit.INSTANCE;
                                                        NeverEqualPolicy neverEqualPolicy2 = Composer.Companion.Empty;
                                                        LocalItem localItem3 = localItem2;
                                                        switch (b7) {
                                                            case 0:
                                                                Composer composer2 = (Composer) obj5;
                                                                int iIntValue2 = ((Integer) obj6).intValue();
                                                                ((ColumnScopeInstance) obj4).getClass();
                                                                GapComposer gapComposer2 = (GapComposer) composer2;
                                                                if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                                                                    gapComposer2.skipToGroupEnd();
                                                                } else {
                                                                    Album album4 = (Album) localItem3;
                                                                    MenuState menuState3 = menuState2;
                                                                    boolean zChanged3 = gapComposer2.changed(menuState3);
                                                                    Object objRememberedValue4 = gapComposer2.rememberedValue();
                                                                    if (zChanged3 || objRememberedValue4 == neverEqualPolicy2) {
                                                                        LoginScreenKt$LoginScreen$1$3$2$1 loginScreenKt$LoginScreen$1$3$2$1 = new LoginScreenKt$LoginScreen$1$3$2$1(0, menuState3, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 2);
                                                                        gapComposer2.updateRememberedValue(loginScreenKt$LoginScreen$1$3$2$1);
                                                                        objRememberedValue4 = loginScreenKt$LoginScreen$1$3$2$1;
                                                                    }
                                                                    AlbumMenuKt.AlbumMenu(album4, (Function0) ((KFunction) objRememberedValue4), gapComposer2, 0);
                                                                }
                                                                break;
                                                            default:
                                                                Composer composer3 = (Composer) obj5;
                                                                int iIntValue3 = ((Integer) obj6).intValue();
                                                                ((ColumnScopeInstance) obj4).getClass();
                                                                GapComposer gapComposer3 = (GapComposer) composer3;
                                                                if (!gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 17) != 16)) {
                                                                    gapComposer3.skipToGroupEnd();
                                                                } else {
                                                                    Song song2 = (Song) localItem3;
                                                                    MenuState menuState4 = menuState2;
                                                                    boolean zChanged4 = gapComposer3.changed(menuState4);
                                                                    Object objRememberedValue5 = gapComposer3.rememberedValue();
                                                                    if (zChanged4 || objRememberedValue5 == neverEqualPolicy2) {
                                                                        objRememberedValue5 = new LoginScreenKt$LoginScreen$1$3$2$1(0, menuState4, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 1);
                                                                        gapComposer3.updateRememberedValue(objRememberedValue5);
                                                                    }
                                                                    SongMenuKt.SongMenu(song2, null, null, null, (Function0) ((KFunction) objRememberedValue5), false, gapComposer3, 0, 46);
                                                                }
                                                                break;
                                                        }
                                                        return unit3;
                                                    }
                                                }));
                                                break;
                                            default:
                                                ((PlatformHapticFeedback) hapticFeedback2).m578performHapticFeedbackCdsT49E(0);
                                                menuState2.show(new ComposableLambdaImpl(true, -601231405, new Function3() { // from class: com.metrolist.music.ui.screens.HomeScreenKt$$ExternalSyntheticLambda19
                                                    @Override // kotlin.jvm.functions.Function3
                                                    public final Object invoke(Object obj4, Object obj5, Object obj6) {
                                                        byte b7 = b6;
                                                        Unit unit3 = Unit.INSTANCE;
                                                        NeverEqualPolicy neverEqualPolicy2 = Composer.Companion.Empty;
                                                        LocalItem localItem3 = localItem2;
                                                        switch (b7) {
                                                            case 0:
                                                                Composer composer2 = (Composer) obj5;
                                                                int iIntValue2 = ((Integer) obj6).intValue();
                                                                ((ColumnScopeInstance) obj4).getClass();
                                                                GapComposer gapComposer2 = (GapComposer) composer2;
                                                                if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                                                                    gapComposer2.skipToGroupEnd();
                                                                } else {
                                                                    Album album4 = (Album) localItem3;
                                                                    MenuState menuState3 = menuState2;
                                                                    boolean zChanged3 = gapComposer2.changed(menuState3);
                                                                    Object objRememberedValue4 = gapComposer2.rememberedValue();
                                                                    if (zChanged3 || objRememberedValue4 == neverEqualPolicy2) {
                                                                        LoginScreenKt$LoginScreen$1$3$2$1 loginScreenKt$LoginScreen$1$3$2$1 = new LoginScreenKt$LoginScreen$1$3$2$1(0, menuState3, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 2);
                                                                        gapComposer2.updateRememberedValue(loginScreenKt$LoginScreen$1$3$2$1);
                                                                        objRememberedValue4 = loginScreenKt$LoginScreen$1$3$2$1;
                                                                    }
                                                                    AlbumMenuKt.AlbumMenu(album4, (Function0) ((KFunction) objRememberedValue4), gapComposer2, 0);
                                                                }
                                                                break;
                                                            default:
                                                                Composer composer3 = (Composer) obj5;
                                                                int iIntValue3 = ((Integer) obj6).intValue();
                                                                ((ColumnScopeInstance) obj4).getClass();
                                                                GapComposer gapComposer3 = (GapComposer) composer3;
                                                                if (!gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 17) != 16)) {
                                                                    gapComposer3.skipToGroupEnd();
                                                                } else {
                                                                    Song song2 = (Song) localItem3;
                                                                    MenuState menuState4 = menuState2;
                                                                    boolean zChanged4 = gapComposer3.changed(menuState4);
                                                                    Object objRememberedValue5 = gapComposer3.rememberedValue();
                                                                    if (zChanged4 || objRememberedValue5 == neverEqualPolicy2) {
                                                                        objRememberedValue5 = new LoginScreenKt$LoginScreen$1$3$2$1(0, menuState4, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 1);
                                                                        gapComposer3.updateRememberedValue(objRememberedValue5);
                                                                    }
                                                                    SongMenuKt.SongMenu(song2, null, null, null, (Function0) ((KFunction) objRememberedValue5), false, gapComposer3, 0, 46);
                                                                }
                                                                break;
                                                        }
                                                        return unit3;
                                                    }
                                                }));
                                                break;
                                        }
                                        return unit2;
                                    }
                                };
                                gapComposer.updateRememberedValue(objRememberedValue3);
                            }
                            Function0 function1 = (Function0) objRememberedValue3;
                            boolean zChangedInstance4 = gapComposer.changedInstance(navHostController) | (i2 == 4 || ((iIntValue & 8) != 0 && gapComposer.changedInstance(localItem)));
                            Object objRememberedValue4 = gapComposer.rememberedValue();
                            if (zChangedInstance4 || objRememberedValue4 == neverEqualPolicy) {
                                objRememberedValue4 = new Function0() { // from class: com.metrolist.music.ui.screens.HomeScreenKt$$ExternalSyntheticLambda14
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        String str3;
                                        String str4;
                                        byte b4 = b2;
                                        Unit unit2 = Unit.INSTANCE;
                                        LocalItem localItem2 = localItem;
                                        NavHostController navHostController2 = navHostController;
                                        switch (b4) {
                                            case 0:
                                                str3 = ((Album) localItem2).album.id;
                                                str4 = "album/";
                                                break;
                                            default:
                                                str3 = ((Artist) localItem2).artist.id;
                                                str4 = "artist/";
                                                break;
                                        }
                                        Format$$ExternalSyntheticOutline0.m(str4, str3, navHostController2);
                                        return unit2;
                                    }
                                };
                                gapComposer.updateRememberedValue(objRememberedValue4);
                            }
                            MenuKt.AlbumGridItem(album3, ImageKt.m48combinedClickablehoGz1lA$default(modifierFillMaxWidth2, false, function1, (Function0) objRememberedValue4, 239), coroutineScope, null, zAreEqual, zBooleanValue, false, gapComposer, i2, 72);
                            gapComposer.end(false);
                        } else if (localItem instanceof Artist) {
                            gapComposer.startReplaceGroup(-17331558);
                            Artist artist = (Artist) localItem;
                            Modifier modifierFillMaxWidth3 = SizeKt.fillMaxWidth(companion, 1.0f);
                            int i3 = iIntValue & 14;
                            boolean zChangedInstance5 = gapComposer.changedInstance(hapticFeedback) | gapComposer.changed(menuState) | (i3 == 4 || ((iIntValue & 8) != 0 && gapComposer.changedInstance(localItem))) | gapComposer.changedInstance(coroutineScope);
                            Object objRememberedValue5 = gapComposer.rememberedValue();
                            if (zChangedInstance5 || objRememberedValue5 == neverEqualPolicy) {
                                objRememberedValue5 = new SongMenuKt$$ExternalSyntheticLambda63(hapticFeedback, menuState, localItem, coroutineScope);
                                gapComposer.updateRememberedValue(objRememberedValue5);
                            }
                            Function0 function2 = (Function0) objRememberedValue5;
                            boolean zChangedInstance6 = gapComposer.changedInstance(navHostController) | (i3 == 4 || ((iIntValue & 8) != 0 && gapComposer.changedInstance(localItem)));
                            Object objRememberedValue6 = gapComposer.rememberedValue();
                            if (zChangedInstance6 || objRememberedValue6 == neverEqualPolicy) {
                                final byte b4 = 1;
                                objRememberedValue6 = new Function0() { // from class: com.metrolist.music.ui.screens.HomeScreenKt$$ExternalSyntheticLambda14
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        String str3;
                                        String str4;
                                        byte b5 = b4;
                                        Unit unit2 = Unit.INSTANCE;
                                        LocalItem localItem2 = localItem;
                                        NavHostController navHostController2 = navHostController;
                                        switch (b5) {
                                            case 0:
                                                str3 = ((Album) localItem2).album.id;
                                                str4 = "album/";
                                                break;
                                            default:
                                                str3 = ((Artist) localItem2).artist.id;
                                                str4 = "artist/";
                                                break;
                                        }
                                        Format$$ExternalSyntheticOutline0.m(str4, str3, navHostController2);
                                        return unit2;
                                    }
                                };
                                gapComposer.updateRememberedValue(objRememberedValue6);
                            }
                            MenuKt.ArtistGridItem(artist, ImageKt.m48combinedClickablehoGz1lA$default(modifierFillMaxWidth3, false, function2, (Function0) objRememberedValue6, 239), null, false, gapComposer, i3, 12);
                            gapComposer.end(false);
                        } else {
                            if (!(localItem instanceof Playlist)) {
                                throw Format$$ExternalSyntheticOutline0.m(gapComposer, -1524680104, false);
                            }
                            gapComposer.startReplaceGroup(-16252355);
                            gapComposer.end(false);
                        }
                    }
                } else {
                    gapComposer.skipToGroupEnd();
                }
                return unit;
            default:
                YTItem yTItem = (YTItem) obj;
                Composer composer2 = (Composer) obj2;
                int iIntValue2 = ((Integer) obj3).intValue();
                yTItem.getClass();
                State state4 = this.f$3;
                MediaMetadata mediaMetadata3 = (MediaMetadata) state4.getValue();
                String str3 = (mediaMetadata3 == null || (album2 = mediaMetadata3.album) == null) ? null : album2.id;
                MediaMetadata mediaMetadata4 = (MediaMetadata) state4.getValue();
                boolean zContains = CollectionsKt__IterablesKt.listOf((Object[]) new String[]{str3, mediaMetadata4 != null ? mediaMetadata4.id : null}).contains(yTItem.getId());
                boolean zBooleanValue2 = ((Boolean) state2.getValue()).booleanValue();
                GapComposer gapComposer2 = (GapComposer) composer2;
                HapticFeedback hapticFeedback2 = this.f$0;
                boolean zChangedInstance7 = gapComposer2.changedInstance(hapticFeedback2);
                MenuState menuState2 = this.f$1;
                boolean zChanged3 = zChangedInstance7 | gapComposer2.changed(menuState2) | gapComposer2.changedInstance(yTItem);
                CoroutineScope coroutineScope2 = this.f$7;
                boolean zChangedInstance8 = zChanged3 | gapComposer2.changedInstance(coroutineScope2);
                Object objRememberedValue7 = gapComposer2.rememberedValue();
                if (zChangedInstance8 || objRememberedValue7 == neverEqualPolicy) {
                    objRememberedValue7 = new HomeScreenKt$$ExternalSyntheticLambda9(hapticFeedback2, menuState2, yTItem, coroutineScope2, (byte) 0);
                    gapComposer2.updateRememberedValue(objRememberedValue7);
                }
                Function0 function3 = (Function0) objRememberedValue7;
                boolean zChangedInstance9 = gapComposer2.changedInstance(yTItem);
                boolean z4 = this.f$2;
                boolean zChanged4 = zChangedInstance9 | gapComposer2.changed(z4);
                PlayerConnection playerConnection2 = this.f$4;
                boolean zChangedInstance10 = zChanged4 | gapComposer2.changedInstance(playerConnection2);
                MutableState mutableState2 = this.f$5;
                boolean zChanged5 = zChangedInstance10 | gapComposer2.changed(mutableState2);
                NavHostController navHostController2 = this.f$6;
                boolean zChangedInstance11 = zChanged5 | gapComposer2.changedInstance(navHostController2);
                Object objRememberedValue8 = gapComposer2.rememberedValue();
                if (zChangedInstance11 || objRememberedValue8 == neverEqualPolicy) {
                    PlayerKt$$ExternalSyntheticLambda37 playerKt$$ExternalSyntheticLambda37 = new PlayerKt$$ExternalSyntheticLambda37(yTItem, z4, playerConnection2, navHostController2, mutableState2);
                    gapComposer2.updateRememberedValue(playerKt$$ExternalSyntheticLambda37);
                    objRememberedValue8 = playerKt$$ExternalSyntheticLambda37;
                }
                MenuKt.YouTubeGridItem(yTItem, ImageKt.m48combinedClickablehoGz1lA$default(companion, false, function3, (Function0) objRememberedValue8, 239), coroutineScope2, null, 1.0f, zContains, zBooleanValue2, false, gapComposer2, (iIntValue2 & 14) | 24576, 136);
                return unit;
        }
    }

    public /* synthetic */ HomeScreenKt$$ExternalSyntheticLambda3(HapticFeedback hapticFeedback, MenuState menuState, boolean z, MutableState mutableState, PlayerConnection playerConnection, DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1, NavHostController navHostController, CoroutineScope coroutineScope, MutableState mutableState2) {
        this.f$0 = hapticFeedback;
        this.f$1 = menuState;
        this.f$2 = z;
        this.f$3 = mutableState;
        this.f$4 = playerConnection;
        this.f$5 = dataStoreKt$rememberPreference$1$1;
        this.f$6 = navHostController;
        this.f$7 = coroutineScope;
        this.f$8 = mutableState2;
    }
}
