package com.metrolist.music.ui.component;

import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.ui.Modifier;
import androidx.navigation.NavHostController;
import com.metrolist.music.MainActivityKt;
import com.metrolist.music.db.entities.Album;
import com.metrolist.music.db.entities.Artist;
import com.metrolist.music.db.entities.Playlist;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class LibraryKt {
    public static final void LibraryAlbumGridItem(final Modifier modifier, final MenuState menuState, final CoroutineScope coroutineScope, final Album album, final boolean z, final boolean z2, Composer composer, final int i) {
        int i2;
        menuState.getClass();
        coroutineScope.getClass();
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-325615830);
        if ((i & 6) == 0) {
            i2 = i | (gapComposer.changed(modifier) ? 4 : 2);
        } else {
            i2 = i;
        }
        int i3 = i2 | (gapComposer.changed(menuState) ? 32 : 16) | (gapComposer.changed(coroutineScope) ? 256 : 128) | (gapComposer.changed(album) ? 2048 : 1024) | (gapComposer.changed(z) ? 16384 : 8192) | (gapComposer.changed(z2) ? 131072 : 65536);
        if (gapComposer.shouldExecute(i3 & 1, (74899 & i3) != 74898)) {
            NavHostController navHostController = (NavHostController) gapComposer.consume(MainActivityKt.LocalNavController);
            Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(modifier, 1.0f);
            int i4 = i3 & 7168;
            boolean z3 = ((i3 & 112) == 32) | (i4 == 2048);
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (z3 || objRememberedValue == neverEqualPolicy) {
                objRememberedValue = new LibraryKt$$ExternalSyntheticLambda0((byte) 0, album, menuState);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            Function0 function0 = (Function0) objRememberedValue;
            boolean zChangedInstance = gapComposer.changedInstance(navHostController) | (i4 == 2048);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = new LibraryKt$$ExternalSyntheticLambda1(navHostController, album, (byte) 0);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            MenuKt.AlbumGridItem(album, ImageKt.m48combinedClickablehoGz1lA$default(modifierFillMaxWidth, false, function0, (Function0) objRememberedValue2, 239), coroutineScope, null, z, z2, true, gapComposer, ((i3 >> 9) & 14) | 1572864 | (i3 & 896) | (57344 & i3) | (i3 & 458752), 8);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.metrolist.music.ui.component.LibraryKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    LibraryKt.LibraryAlbumGridItem(modifier, menuState, coroutineScope, album, z, z2, (Composer) obj, Stack.updateChangedFlags(i | 1));
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public static final void LibraryAlbumListItem(Modifier modifier, MenuState menuState, Album album, boolean z, boolean z2, Composer composer, int i) {
        menuState.getClass();
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-953537730);
        int i2 = i | (gapComposer.changed(modifier) ? 4 : 2) | (gapComposer.changed(menuState) ? 32 : 16) | (gapComposer.changed(album) ? 256 : 128) | (gapComposer.changed(z) ? 2048 : 1024) | (gapComposer.changed(z2) ? 16384 : 8192);
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 9363) != 9362)) {
            NavHostController navHostController = (NavHostController) gapComposer.consume(MainActivityKt.LocalNavController);
            Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(modifier, 1.0f);
            boolean zChangedInstance = ((i2 & 896) == 256) | gapComposer.changedInstance(navHostController);
            Object objRememberedValue = gapComposer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.Companion.Empty) {
                objRememberedValue = new LibraryKt$$ExternalSyntheticLambda1(navHostController, album, (byte) 1);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            int i3 = ((i2 >> 6) & 14) | 1572864;
            int i4 = i2 << 3;
            MenuKt.AlbumListItem(album, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth, false, null, (Function0) objRememberedValue, 15), false, null, z, z2, Expect_jvmKt.rememberComposableLambda(-501934459, new LibraryKt$$ExternalSyntheticLambda3(menuState, album), gapComposer), gapComposer, i3 | (57344 & i4) | (i4 & 458752), 12);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new LibraryKt$$ExternalSyntheticLambda6(modifier, menuState, album, z, z2, i);
        }
    }

    public static final void LibraryArtistGridItem(MenuState menuState, CoroutineScope coroutineScope, Artist artist, Modifier modifier, Composer composer, int i) {
        menuState.getClass();
        coroutineScope.getClass();
        artist.getClass();
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-1535863918);
        int i2 = i | (gapComposer.changed(menuState) ? 4 : 2) | (gapComposer.changed(coroutineScope) ? 32 : 16) | (gapComposer.changed(artist) ? 256 : 128) | (gapComposer.changed(modifier) ? 2048 : 1024);
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 1171) != 1170)) {
            NavHostController navHostController = (NavHostController) gapComposer.consume(MainActivityKt.LocalNavController);
            Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(modifier, 1.0f);
            int i3 = i2 & 896;
            boolean z = ((i2 & 14) == 4) | (i3 == 256) | ((i2 & 112) == 32);
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (z || objRememberedValue == neverEqualPolicy) {
                objRememberedValue = new LibraryKt$$ExternalSyntheticLambda10((byte) 0, artist, menuState, coroutineScope);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            Function0 function0 = (Function0) objRememberedValue;
            boolean zChangedInstance = gapComposer.changedInstance(navHostController) | (i3 == 256);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = new LibraryKt$$ExternalSyntheticLambda11(navHostController, artist, (byte) 0);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            MenuKt.ArtistGridItem(artist, ImageKt.m48combinedClickablehoGz1lA$default(modifierFillMaxWidth, false, function0, (Function0) objRememberedValue2, 239), null, true, gapComposer, ((i2 >> 6) & 14) | 3072, 4);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new LibraryKt$$ExternalSyntheticLambda12(menuState, coroutineScope, artist, modifier, i, (byte) 0);
        }
    }

    public static final void LibraryArtistListItem(MenuState menuState, CoroutineScope coroutineScope, Artist artist, Modifier modifier, Composer composer, int i) {
        menuState.getClass();
        coroutineScope.getClass();
        artist.getClass();
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-969123014);
        int i2 = i | (gapComposer.changed(menuState) ? 4 : 2) | (gapComposer.changed(coroutineScope) ? 32 : 16) | (gapComposer.changed(artist) ? 256 : 128) | (gapComposer.changed(modifier) ? 2048 : 1024);
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 1171) != 1170)) {
            NavHostController navHostController = (NavHostController) gapComposer.consume(MainActivityKt.LocalNavController);
            Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(modifier, 1.0f);
            boolean zChangedInstance = ((i2 & 896) == 256) | gapComposer.changedInstance(navHostController);
            Object objRememberedValue = gapComposer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.Companion.Empty) {
                objRememberedValue = new LibraryKt$$ExternalSyntheticLambda11(navHostController, artist, (byte) 1);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            MenuKt.ArtistListItem(artist, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth, false, null, (Function0) objRememberedValue, 15), null, Expect_jvmKt.rememberComposableLambda(-685759158, new LibraryKt$$ExternalSyntheticLambda17(menuState, artist, coroutineScope), gapComposer), gapComposer, ((i2 >> 6) & 14) | 3072, 4);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new LibraryKt$$ExternalSyntheticLambda12(menuState, coroutineScope, artist, modifier, i, (byte) 1);
        }
    }

    public static final void LibraryPlaylistGridItem(MenuState menuState, CoroutineScope coroutineScope, Playlist playlist, Modifier modifier, Composer composer, int i) {
        menuState.getClass();
        coroutineScope.getClass();
        playlist.getClass();
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-1606465924);
        int i2 = i | (gapComposer.changed(menuState) ? 4 : 2) | (gapComposer.changed(coroutineScope) ? 32 : 16) | (gapComposer.changed(playlist) ? 256 : 128) | (gapComposer.changed(modifier) ? 2048 : 1024);
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 1171) != 1170)) {
            NavHostController navHostController = (NavHostController) gapComposer.consume(MainActivityKt.LocalNavController);
            Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(modifier, 1.0f);
            int i3 = i2 & 896;
            boolean z = ((i2 & 14) == 4) | (i3 == 256) | ((i2 & 112) == 32);
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (z || objRememberedValue == neverEqualPolicy) {
                objRememberedValue = new LibraryKt$$ExternalSyntheticLambda7((byte) 0, playlist, menuState, coroutineScope);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            Function0 function0 = (Function0) objRememberedValue;
            boolean zChangedInstance = gapComposer.changedInstance(navHostController) | (i3 == 256);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = new LibraryKt$$ExternalSyntheticLambda8((byte) 0, navHostController, playlist);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            MenuKt.PlaylistGridItem(playlist, ImageKt.m48combinedClickablehoGz1lA$default(modifierFillMaxWidth, false, function0, (Function0) objRememberedValue2, 239), false, null, true, gapComposer, ((i2 >> 6) & 14) | 24576, 12);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new LibraryKt$$ExternalSyntheticLambda9(menuState, coroutineScope, playlist, modifier, i, (byte) 0);
        }
    }

    public static final void LibraryPlaylistListItem(MenuState menuState, CoroutineScope coroutineScope, Playlist playlist, Modifier modifier, Composer composer, int i) {
        menuState.getClass();
        coroutineScope.getClass();
        playlist.getClass();
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(1865663524);
        int i2 = i | (gapComposer.changed(menuState) ? 4 : 2) | (gapComposer.changed(coroutineScope) ? 32 : 16) | (gapComposer.changed(playlist) ? 256 : 128) | (gapComposer.changed(modifier) ? 2048 : 1024);
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 1171) != 1170)) {
            NavHostController navHostController = (NavHostController) gapComposer.consume(MainActivityKt.LocalNavController);
            Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(modifier, 1.0f);
            boolean zChangedInstance = ((i2 & 896) == 256) | gapComposer.changedInstance(navHostController);
            Object objRememberedValue = gapComposer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.Companion.Empty) {
                objRememberedValue = new LibraryKt$$ExternalSyntheticLambda8((byte) 1, navHostController, playlist);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            MenuKt.PlaylistListItem(playlist, ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth, false, null, (Function0) objRememberedValue, 15), false, null, Expect_jvmKt.rememberComposableLambda(-1712603992, new LibraryKt$$ExternalSyntheticLambda14(menuState, playlist, coroutineScope), gapComposer), gapComposer, ((i2 >> 6) & 14) | 24576, 12);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new LibraryKt$$ExternalSyntheticLambda9(menuState, coroutineScope, playlist, modifier, i, (byte) 1);
        }
    }
}
