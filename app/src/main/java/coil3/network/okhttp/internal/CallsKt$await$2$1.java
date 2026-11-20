package coil3.network.okhttp.internal;

import androidx.compose.animation.EnterExitState;
import androidx.compose.animation.VeilConfig;
import androidx.compose.animation.VeilModifierNode;
import androidx.compose.animation.core.AnimationVector4D;
import androidx.compose.runtime.CancellationHandle;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.input.pointer.PointerInteropFilter;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.RulerKt;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.music.MainActivity$MetrolistApp$$inlined$rememberEnumPreference$2;
import com.metrolist.music.MainActivity$MetrolistApp$$inlined$rememberEnumPreference$4;
import com.metrolist.music.MainActivity$onCreate$lambda$3$$inlined$rememberEnumPreference$2;
import com.metrolist.music.MainActivity$onCreate$lambda$3$$inlined$rememberEnumPreference$4;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.ui.component.ExperimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$2;
import com.metrolist.music.ui.component.ExperimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$4;
import com.metrolist.music.ui.component.ItemsKt$currentGridThumbnailHeight$$inlined$rememberEnumPreference$2;
import com.metrolist.music.ui.component.OriginalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$2;
import com.metrolist.music.ui.component.OriginalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$4;
import com.metrolist.music.ui.component.OriginalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$6;
import com.metrolist.music.ui.component.OriginalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$8;
import com.metrolist.music.ui.component.shimmer.GridItemPlaceholderKt$GridItemPlaceHolder$$inlined$rememberEnumPreference$2;
import com.metrolist.music.ui.menu.AddToPlaylistDialogKt$AddToPlaylistDialog$$inlined$rememberEnumPreference$2;
import com.metrolist.music.ui.menu.AddToPlaylistDialogKt$AddToPlaylistDialog$$inlined$rememberEnumPreference$4;
import com.metrolist.music.ui.menu.AddToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$$inlined$rememberEnumPreference$2;
import com.metrolist.music.ui.menu.AddToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$$inlined$rememberEnumPreference$4;
import com.metrolist.music.ui.player.MiniPlayerKt$NewMiniPlayer$$inlined$rememberEnumPreference$2;
import com.metrolist.music.ui.player.PlayerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$2;
import com.metrolist.music.ui.player.PlayerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$4;
import com.metrolist.music.ui.player.ThumbnailKt$Thumbnail$$inlined$rememberEnumPreference$2;
import com.metrolist.music.ui.screens.AccountScreenKt$AccountScreen$$inlined$rememberEnumPreference$2;
import com.metrolist.music.utils.ArtistNameAliases;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import okhttp3.internal.connection.RealCall;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class CallsKt$await$2$1 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public Object $this_await;

    public /* synthetic */ CallsKt$await$2$1(byte b, Object obj) {
        this.$r8$classId = b;
        this.$this_await = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                ((RealCall) this.$this_await).cancel();
                return unit;
            case 1:
                AnimationVector4D animationVector4D = (AnimationVector4D) obj;
                float f = animationVector4D.v2;
                float f2 = CropImageView.DEFAULT_ASPECT_RATIO;
                if (f < CropImageView.DEFAULT_ASPECT_RATIO) {
                    f = 0.0f;
                }
                if (f > 1.0f) {
                    f = 1.0f;
                }
                float f3 = animationVector4D.v3;
                if (f3 < -0.5f) {
                    f3 = -0.5f;
                }
                if (f3 > 0.5f) {
                    f3 = 0.5f;
                }
                float f4 = animationVector4D.v4;
                float f5 = f4 >= -0.5f ? f4 : -0.5f;
                float f6 = f5 <= 0.5f ? f5 : 0.5f;
                float f7 = animationVector4D.v1;
                if (f7 >= CropImageView.DEFAULT_ASPECT_RATIO) {
                    f2 = f7;
                }
                return new Color(Color.m479convertvNxB06k(ColorKt.Color(f, f3, f6, f2 <= 1.0f ? f2 : 1.0f, ColorSpaces.Oklab), (ColorSpace) this.$this_await));
            case 2:
                VeilModifierNode veilModifierNode = (VeilModifierNode) this.$this_await;
                int iOrdinal = ((EnterExitState) obj).ordinal();
                long j = 0;
                if (iOrdinal == 0) {
                    VeilConfig veilConfig = veilModifierNode.enter.config.veil;
                    if (veilConfig != null) {
                        j = veilConfig.initialColor;
                    }
                } else if (iOrdinal == 1) {
                    VeilConfig veilConfig2 = veilModifierNode.enter.config.veil;
                    if (veilConfig2 != null) {
                        j = veilConfig2.targetColor;
                    } else {
                        VeilConfig veilConfig3 = veilModifierNode.exit.config.veil;
                        if (veilConfig3 != null) {
                            j = veilConfig3.initialColor;
                        }
                    }
                } else {
                    if (iOrdinal != 2) {
                        PathKt$$ExternalSyntheticBUOutline0.m$1();
                        return null;
                    }
                    VeilConfig veilConfig4 = veilModifierNode.exit.config.veil;
                    if (veilConfig4 != null) {
                        j = veilConfig4.targetColor;
                    }
                }
                return new Color(j);
            case 3:
                float[] fArr = ((Matrix) obj).values;
                LayoutCoordinates layoutCoordinates = (LayoutCoordinates) this.$this_await;
                if (layoutCoordinates.isAttached$1()) {
                    RulerKt.findRootCoordinates(layoutCoordinates).mo610transformFromEL8BTi8(layoutCoordinates, fArr);
                }
                return unit;
            case 4:
                ((CancellationHandle) this.$this_await).cancel();
                return unit;
            case 5:
                boolean zBooleanValue = ((Boolean) obj).booleanValue();
                PointerInteropFilter pointerInteropFilter = (PointerInteropFilter) this.$this_await;
                if (pointerInteropFilter != null) {
                    pointerInteropFilter.disallowIntercept = zBooleanValue;
                }
                return unit;
            case 6:
                Throwable th = (Throwable) obj;
                SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine pointerEventHandlerCoroutine = (SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine) this.$this_await;
                CancellableContinuationImpl cancellableContinuationImpl = pointerEventHandlerCoroutine.pointerAwaiter;
                if (cancellableContinuationImpl != null) {
                    cancellableContinuationImpl.cancel(th);
                }
                pointerEventHandlerCoroutine.pointerAwaiter = null;
                return unit;
            case 7:
                Placeable.PlacementScope.placeRelative$default((Placeable.PlacementScope) obj, (Placeable) this.$this_await, 0, 0);
                return unit;
            case 8:
                Enum r8 = (Enum) obj;
                r8.getClass();
                MainActivity$MetrolistApp$$inlined$rememberEnumPreference$2 mainActivity$MetrolistApp$$inlined$rememberEnumPreference$2 = (MainActivity$MetrolistApp$$inlined$rememberEnumPreference$2) this.$this_await;
                AwaitKt.launch$default(mainActivity$MetrolistApp$$inlined$rememberEnumPreference$2.$coroutineScope, null, null, new MainActivity$MetrolistApp$$inlined$rememberEnumPreference$2.AnonymousClass1(mainActivity$MetrolistApp$$inlined$rememberEnumPreference$2.$context, mainActivity$MetrolistApp$$inlined$rememberEnumPreference$2.$key, r8, null, (byte) 0), 3);
                return unit;
            case 9:
                Enum r18 = (Enum) obj;
                r18.getClass();
                MainActivity$MetrolistApp$$inlined$rememberEnumPreference$4 mainActivity$MetrolistApp$$inlined$rememberEnumPreference$4 = (MainActivity$MetrolistApp$$inlined$rememberEnumPreference$4) this.$this_await;
                AwaitKt.launch$default(mainActivity$MetrolistApp$$inlined$rememberEnumPreference$4.$coroutineScope, null, null, new MainActivity$MetrolistApp$$inlined$rememberEnumPreference$2.AnonymousClass1(mainActivity$MetrolistApp$$inlined$rememberEnumPreference$4.$context, mainActivity$MetrolistApp$$inlined$rememberEnumPreference$4.$key, r18, null, (byte) 1), 3);
                return unit;
            case 10:
                Enum r13 = (Enum) obj;
                r13.getClass();
                MainActivity$onCreate$lambda$3$$inlined$rememberEnumPreference$2 mainActivity$onCreate$lambda$3$$inlined$rememberEnumPreference$2 = (MainActivity$onCreate$lambda$3$$inlined$rememberEnumPreference$2) this.$this_await;
                AwaitKt.launch$default(mainActivity$onCreate$lambda$3$$inlined$rememberEnumPreference$2.$coroutineScope, null, null, new MainActivity$MetrolistApp$$inlined$rememberEnumPreference$2.AnonymousClass1(mainActivity$onCreate$lambda$3$$inlined$rememberEnumPreference$2.$context, mainActivity$onCreate$lambda$3$$inlined$rememberEnumPreference$2.$key, r13, null, (byte) 2), 3);
                return unit;
            case 11:
                Enum r9 = (Enum) obj;
                r9.getClass();
                MainActivity$onCreate$lambda$3$$inlined$rememberEnumPreference$4 mainActivity$onCreate$lambda$3$$inlined$rememberEnumPreference$4 = (MainActivity$onCreate$lambda$3$$inlined$rememberEnumPreference$4) this.$this_await;
                AwaitKt.launch$default(mainActivity$onCreate$lambda$3$$inlined$rememberEnumPreference$4.$coroutineScope, null, null, new MainActivity$MetrolistApp$$inlined$rememberEnumPreference$2.AnonymousClass1(mainActivity$onCreate$lambda$3$$inlined$rememberEnumPreference$4.$context, mainActivity$onCreate$lambda$3$$inlined$rememberEnumPreference$4.$key, r9, null, (byte) 3), 3);
                return unit;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                Enum r19 = (Enum) obj;
                r19.getClass();
                ExperimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$2 experimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$2 = (ExperimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$2) this.$this_await;
                AwaitKt.launch$default(experimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$2.$coroutineScope, null, null, new MainActivity$MetrolistApp$$inlined$rememberEnumPreference$2.AnonymousClass1(experimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$2.$context, experimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$2.$key, r19, null, (byte) 4), 3);
                return unit;
            case 13:
                Enum r14 = (Enum) obj;
                r14.getClass();
                ExperimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$4 experimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$4 = (ExperimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$4) this.$this_await;
                AwaitKt.launch$default(experimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$4.$coroutineScope, null, null, new MainActivity$MetrolistApp$$inlined$rememberEnumPreference$2.AnonymousClass1(experimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$4.$context, experimentalLyricsKt$ExperimentalLyrics$$inlined$rememberEnumPreference$4.$key, r14, null, (byte) 5), 3);
                return unit;
            case 14:
                Enum r10 = (Enum) obj;
                r10.getClass();
                ItemsKt$currentGridThumbnailHeight$$inlined$rememberEnumPreference$2 itemsKt$currentGridThumbnailHeight$$inlined$rememberEnumPreference$2 = (ItemsKt$currentGridThumbnailHeight$$inlined$rememberEnumPreference$2) this.$this_await;
                AwaitKt.launch$default(itemsKt$currentGridThumbnailHeight$$inlined$rememberEnumPreference$2.$coroutineScope, null, null, new MainActivity$MetrolistApp$$inlined$rememberEnumPreference$2.AnonymousClass1(itemsKt$currentGridThumbnailHeight$$inlined$rememberEnumPreference$2.$context, itemsKt$currentGridThumbnailHeight$$inlined$rememberEnumPreference$2.$key, r10, null, (byte) 6), 3);
                return unit;
            case 15:
                Enum r110 = (Enum) obj;
                r110.getClass();
                OriginalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$2 originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$2 = (OriginalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$2) this.$this_await;
                AwaitKt.launch$default(originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$2.$coroutineScope, null, null, new MainActivity$MetrolistApp$$inlined$rememberEnumPreference$2.AnonymousClass1(originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$2.$context, originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$2.$key, r110, null, (byte) 7), 3);
                return unit;
            case 16:
                Enum r15 = (Enum) obj;
                r15.getClass();
                OriginalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$4 originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$4 = (OriginalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$4) this.$this_await;
                AwaitKt.launch$default(originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$4.$coroutineScope, null, null, new MainActivity$MetrolistApp$$inlined$rememberEnumPreference$2.AnonymousClass1(originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$4.$context, originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$4.$key, r15, null, (byte) 8), 3);
                return unit;
            case 17:
                Enum r11 = (Enum) obj;
                r11.getClass();
                OriginalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$6 originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$6 = (OriginalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$6) this.$this_await;
                AwaitKt.launch$default(originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$6.$coroutineScope, null, null, new MainActivity$MetrolistApp$$inlined$rememberEnumPreference$2.AnonymousClass1(originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$6.$context, originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$6.$key, r11, null, (byte) 9), 3);
                return unit;
            case 18:
                Enum r111 = (Enum) obj;
                r111.getClass();
                OriginalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$8 originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$8 = (OriginalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$8) this.$this_await;
                AwaitKt.launch$default(originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$8.$coroutineScope, null, null, new MainActivity$MetrolistApp$$inlined$rememberEnumPreference$2.AnonymousClass1(originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$8.$context, originalLyricsKt$OriginalLyrics$$inlined$rememberEnumPreference$8.$key, r111, null, (byte) 10), 3);
                return unit;
            case 19:
                Enum r16 = (Enum) obj;
                r16.getClass();
                GridItemPlaceholderKt$GridItemPlaceHolder$$inlined$rememberEnumPreference$2 gridItemPlaceholderKt$GridItemPlaceHolder$$inlined$rememberEnumPreference$2 = (GridItemPlaceholderKt$GridItemPlaceHolder$$inlined$rememberEnumPreference$2) this.$this_await;
                AwaitKt.launch$default(gridItemPlaceholderKt$GridItemPlaceHolder$$inlined$rememberEnumPreference$2.$coroutineScope, null, null, new MainActivity$MetrolistApp$$inlined$rememberEnumPreference$2.AnonymousClass1(gridItemPlaceholderKt$GridItemPlaceHolder$$inlined$rememberEnumPreference$2.$context, gridItemPlaceholderKt$GridItemPlaceHolder$$inlined$rememberEnumPreference$2.$key, r16, null, (byte) 11), 3);
                return unit;
            case 20:
                Enum r12 = (Enum) obj;
                r12.getClass();
                AddToPlaylistDialogKt$AddToPlaylistDialog$$inlined$rememberEnumPreference$2 addToPlaylistDialogKt$AddToPlaylistDialog$$inlined$rememberEnumPreference$2 = (AddToPlaylistDialogKt$AddToPlaylistDialog$$inlined$rememberEnumPreference$2) this.$this_await;
                AwaitKt.launch$default(addToPlaylistDialogKt$AddToPlaylistDialog$$inlined$rememberEnumPreference$2.$coroutineScope, null, null, new MainActivity$MetrolistApp$$inlined$rememberEnumPreference$2.AnonymousClass1(addToPlaylistDialogKt$AddToPlaylistDialog$$inlined$rememberEnumPreference$2.$context, addToPlaylistDialogKt$AddToPlaylistDialog$$inlined$rememberEnumPreference$2.$key, r12, null, (byte) 12), 3);
                return unit;
            case 21:
                Enum r112 = (Enum) obj;
                r112.getClass();
                AddToPlaylistDialogKt$AddToPlaylistDialog$$inlined$rememberEnumPreference$4 addToPlaylistDialogKt$AddToPlaylistDialog$$inlined$rememberEnumPreference$4 = (AddToPlaylistDialogKt$AddToPlaylistDialog$$inlined$rememberEnumPreference$4) this.$this_await;
                AwaitKt.launch$default(addToPlaylistDialogKt$AddToPlaylistDialog$$inlined$rememberEnumPreference$4.$coroutineScope, null, null, new MainActivity$MetrolistApp$$inlined$rememberEnumPreference$2.AnonymousClass1(addToPlaylistDialogKt$AddToPlaylistDialog$$inlined$rememberEnumPreference$4.$context, addToPlaylistDialogKt$AddToPlaylistDialog$$inlined$rememberEnumPreference$4.$key, r112, null, (byte) 13), 3);
                return unit;
            case 22:
                Enum r17 = (Enum) obj;
                r17.getClass();
                AddToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$$inlined$rememberEnumPreference$2 addToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$$inlined$rememberEnumPreference$2 = (AddToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$$inlined$rememberEnumPreference$2) this.$this_await;
                AwaitKt.launch$default(addToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$$inlined$rememberEnumPreference$2.$coroutineScope, null, null, new MainActivity$MetrolistApp$$inlined$rememberEnumPreference$2.AnonymousClass1(addToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$$inlined$rememberEnumPreference$2.$context, addToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$$inlined$rememberEnumPreference$2.$key, r17, null, (byte) 14), 3);
                return unit;
            case 23:
                Enum r20 = (Enum) obj;
                r20.getClass();
                AddToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$$inlined$rememberEnumPreference$4 addToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$$inlined$rememberEnumPreference$4 = (AddToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$$inlined$rememberEnumPreference$4) this.$this_await;
                AwaitKt.launch$default(addToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$$inlined$rememberEnumPreference$4.$coroutineScope, null, null, new MainActivity$MetrolistApp$$inlined$rememberEnumPreference$2.AnonymousClass1(addToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$$inlined$rememberEnumPreference$4.$context, addToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$$inlined$rememberEnumPreference$4.$key, r20, null, (byte) 15), 3);
                return unit;
            case 24:
                MediaMetadata.Artist artist = (MediaMetadata.Artist) obj;
                artist.getClass();
                ArtistNameAliases artistNameAliases = ArtistNameAliases.INSTANCE;
                return ArtistNameAliases.resolve(artist.id, artist.name, (Map) this.$this_await);
            case 25:
                Enum r113 = (Enum) obj;
                r113.getClass();
                MiniPlayerKt$NewMiniPlayer$$inlined$rememberEnumPreference$2 miniPlayerKt$NewMiniPlayer$$inlined$rememberEnumPreference$2 = (MiniPlayerKt$NewMiniPlayer$$inlined$rememberEnumPreference$2) this.$this_await;
                AwaitKt.launch$default(miniPlayerKt$NewMiniPlayer$$inlined$rememberEnumPreference$2.$coroutineScope, null, null, new MainActivity$MetrolistApp$$inlined$rememberEnumPreference$2.AnonymousClass1(miniPlayerKt$NewMiniPlayer$$inlined$rememberEnumPreference$2.$context, miniPlayerKt$NewMiniPlayer$$inlined$rememberEnumPreference$2.$key, r113, null, (byte) 16), 3);
                return unit;
            case 26:
                Enum r21 = (Enum) obj;
                r21.getClass();
                PlayerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$2 playerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$2 = (PlayerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$2) this.$this_await;
                AwaitKt.launch$default(playerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$2.$coroutineScope, null, null, new MainActivity$MetrolistApp$$inlined$rememberEnumPreference$2.AnonymousClass1(playerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$2.$context, playerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$2.$key, r21, null, (byte) 17), 3);
                return unit;
            case 27:
                Enum r114 = (Enum) obj;
                r114.getClass();
                PlayerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$4 playerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$4 = (PlayerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$4) this.$this_await;
                AwaitKt.launch$default(playerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$4.$coroutineScope, null, null, new MainActivity$MetrolistApp$$inlined$rememberEnumPreference$2.AnonymousClass1(playerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$4.$context, playerKt$BottomSheetPlayer$$inlined$rememberEnumPreference$4.$key, r114, null, (byte) 18), 3);
                return unit;
            case 28:
                Enum r115 = (Enum) obj;
                r115.getClass();
                ThumbnailKt$Thumbnail$$inlined$rememberEnumPreference$2 thumbnailKt$Thumbnail$$inlined$rememberEnumPreference$2 = (ThumbnailKt$Thumbnail$$inlined$rememberEnumPreference$2) this.$this_await;
                AwaitKt.launch$default(thumbnailKt$Thumbnail$$inlined$rememberEnumPreference$2.$coroutineScope, null, null, new MainActivity$MetrolistApp$$inlined$rememberEnumPreference$2.AnonymousClass1(thumbnailKt$Thumbnail$$inlined$rememberEnumPreference$2.$context, thumbnailKt$Thumbnail$$inlined$rememberEnumPreference$2.$key, r115, null, (byte) 19), 3);
                return unit;
            default:
                Enum r22 = (Enum) obj;
                r22.getClass();
                AccountScreenKt$AccountScreen$$inlined$rememberEnumPreference$2 accountScreenKt$AccountScreen$$inlined$rememberEnumPreference$2 = (AccountScreenKt$AccountScreen$$inlined$rememberEnumPreference$2) this.$this_await;
                AwaitKt.launch$default(accountScreenKt$AccountScreen$$inlined$rememberEnumPreference$2.$coroutineScope, null, null, new MainActivity$MetrolistApp$$inlined$rememberEnumPreference$2.AnonymousClass1(accountScreenKt$AccountScreen$$inlined$rememberEnumPreference$2.$context, accountScreenKt$AccountScreen$$inlined$rememberEnumPreference$2.$key, r22, null, (byte) 20), 3);
                return unit;
        }
    }

    public /* synthetic */ CallsKt$await$2$1() {
        this.$r8$classId = (byte) 5;
    }
}
