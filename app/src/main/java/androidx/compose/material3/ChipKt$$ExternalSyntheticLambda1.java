package androidx.compose.material3;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.os.Build;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement$Horizontal;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.AndroidImageBitmap;
import androidx.compose.ui.graphics.BrushKt$ShaderBrush$1;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.lifecycle.ViewModel;
import coil3.disk.DiskLruCache$$ExternalSyntheticLambda0;
import coil3.network.NetworkFetcher;
import com.metrolist.music.MainActivity;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda17;
import com.metrolist.music.MainActivity$MetrolistApp$$inlined$rememberEnumPreference$4;
import com.metrolist.music.constants.AlbumSortType;
import com.metrolist.music.constants.ArtistSortType;
import com.metrolist.music.constants.LibraryViewType;
import com.metrolist.music.constants.MixSortType;
import com.metrolist.music.constants.PreferenceKeysKt;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.playback.DownloadUtil;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.ui.component.GlassComponentsKt;
import com.metrolist.music.ui.menu.QueueMenuKt$$ExternalSyntheticLambda6;
import com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda16;
import com.metrolist.music.ui.theme.UiStyle;
import com.metrolist.music.ui.theme.UiStyleKt;
import com.metrolist.music.utils.SyncUtils;
import com.metrolist.music.utils.UtilsKt;
import com.metrolist.music.viewmodels.LibraryAlbumsViewModel;
import com.metrolist.music.viewmodels.LibraryArtistsViewModel;
import com.metrolist.music.viewmodels.LibraryMixViewModel;
import com.yalantis.ucrop.view.CropImageView;
import dev.chrisbanes.haze.HazeState;
import io.ktor.http.MimesKt$$ExternalSyntheticLambda0;
import java.util.List;
import java.util.Random;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.JobKt__JobKt$invokeOnCompletion$1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ChipKt$$ExternalSyntheticLambda1 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$10;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ boolean f$3;
    public final /* synthetic */ Object f$5;
    public final /* synthetic */ Object f$6;
    public final /* synthetic */ Object f$7;
    public final /* synthetic */ Object f$8;
    public final /* synthetic */ Object f$9;

    public /* synthetic */ ChipKt$$ExternalSyntheticLambda1(Function0 function0, ComposableLambdaImpl composableLambdaImpl, Modifier modifier, boolean z, Shape shape, ChipColors chipColors, ChipElevation chipElevation, BorderStroke borderStroke, Arrangement$Horizontal arrangement$Horizontal, PaddingValues paddingValues, int i) {
        this.$r8$classId = (byte) 0;
        this.f$0 = function0;
        this.f$1 = composableLambdaImpl;
        this.f$2 = modifier;
        this.f$3 = z;
        this.f$5 = shape;
        this.f$6 = chipColors;
        this.f$7 = chipElevation;
        this.f$8 = borderStroke;
        this.f$9 = arrangement$Horizontal;
        this.f$10 = paddingValues;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        long j;
        Object anonymousClass2;
        GapComposer gapComposer;
        LibraryAlbumsViewModel libraryAlbumsViewModel;
        Object anonymousClass3;
        GapComposer gapComposer2;
        LibraryArtistsViewModel libraryArtistsViewModel;
        byte b = this.$r8$classId;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        Unit unit = Unit.INSTANCE;
        Object obj3 = this.f$10;
        Object obj4 = this.f$9;
        Object obj5 = this.f$8;
        Object obj6 = this.f$7;
        Object obj7 = this.f$6;
        Object obj8 = this.f$5;
        Object obj9 = this.f$2;
        Object obj10 = this.f$1;
        Object obj11 = this.f$0;
        switch (b) {
            case 0:
                ((Integer) obj2).getClass();
                ChipKt.SuggestionChip((Function0) obj11, (ComposableLambdaImpl) obj10, (Modifier) obj9, this.f$3, (Shape) obj8, (ChipColors) obj7, (ChipElevation) obj6, (BorderStroke) obj5, (Arrangement$Horizontal) obj4, (PaddingValues) obj3, (Composer) obj, Stack.updateChangedFlags(49));
                break;
            case 1:
                PlayerConnection playerConnection = (PlayerConnection) obj11;
                MainActivity mainActivity = (MainActivity) obj10;
                MusicDatabase musicDatabase = (MusicDatabase) obj9;
                DownloadUtil downloadUtil = (DownloadUtil) obj8;
                SyncUtils syncUtils = (SyncUtils) obj7;
                MutableState mutableState = (MutableState) obj6;
                MainActivity$MetrolistApp$$inlined$rememberEnumPreference$4 mainActivity$MetrolistApp$$inlined$rememberEnumPreference$4 = (MainActivity$MetrolistApp$$inlined$rememberEnumPreference$4) obj5;
                String str = (String) obj4;
                MutableState mutableState2 = (MutableState) obj3;
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                int i = MainActivity.$r8$clinit;
                GapComposer gapComposer3 = (GapComposer) composer;
                if (gapComposer3.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    int i2 = Build.VERSION.SDK_INT;
                    boolean z = i2 >= 31;
                    Object objRememberedValue = gapComposer3.rememberedValue();
                    if (objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = new HazeState(z);
                        gapComposer3.updateRememberedValue(objRememberedValue);
                    }
                    HazeState hazeState = (HazeState) objRememberedValue;
                    hazeState.blurEnabled$delegate.setValue(Boolean.valueOf(z));
                    boolean z2 = ((Boolean) UtilsKt.rememberPreference(PreferenceKeysKt.GlassBlurKey, Boolean.valueOf(GlassComponentsKt.glassBlurDefault((Context) gapComposer3.consume(AndroidCompositionLocals_androidKt.LocalContext))), gapComposer3, 0).$state.getValue()).booleanValue() && i2 >= 31;
                    FillElement fillElement = SizeKt.FillWholeMaxSize;
                    boolean z3 = this.f$3;
                    if (z3) {
                        gapComposer3.startReplaceGroup(677494352);
                        gapComposer3.end(false);
                        j = -72057594037927936L;
                    } else {
                        gapComposer3.startReplaceGroup(677495538);
                        j = ((MaterialTheme$Values) gapComposer3.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.surface;
                        gapComposer3.end(false);
                    }
                    Modifier modifierM39backgroundbw27NRU = ImageKt.m39backgroundbw27NRU(fillElement, j, ColorKt.RectangleShape);
                    Modifier modifierAmbientGlow = Modifier.Companion.$$INSTANCE;
                    if (z3) {
                        gapComposer3.startReplaceGroup(677497267);
                    } else {
                        gapComposer3.startReplaceGroup(677498455);
                        modifierAmbientGlow = GlassComponentsKt.ambientGlow(gapComposer3, modifierAmbientGlow);
                        modifierAmbientGlow.getClass();
                        gapComposer3.startReplaceGroup(1285681736);
                        if (gapComposer3.consume(UiStyleKt.LocalUiStyle) != UiStyle.GLASS) {
                            boolean z4 = ColorKt.m494luminance8_81llA(((MaterialTheme$Values) gapComposer3.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.surface) < 0.5f;
                            boolean zChanged = gapComposer3.changed(z4);
                            Object objRememberedValue2 = gapComposer3.rememberedValue();
                            if (zChanged || objRememberedValue2 == neverEqualPolicy) {
                                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(128, 128, Bitmap.Config.ARGB_8888);
                                bitmapCreateBitmap.getClass();
                                Random random = new Random(42L);
                                int[] iArr = new int[16384];
                                for (int i3 = 0; i3 < 16384; i3++) {
                                    iArr[i3] = (((int) (random.nextInt(256) * 0.55f)) << 24) | (z4 ? 16777215 : 0);
                                }
                                bitmapCreateBitmap.setPixels(iArr, 0, 128, 0, 0, 128, 128);
                                objRememberedValue2 = new BrushKt$ShaderBrush$1(new BitmapShader(ColorKt.asAndroidBitmap(new AndroidImageBitmap(bitmapCreateBitmap)), ColorKt.m497toAndroidTileMode0vamqd0(1), ColorKt.m497toAndroidTileMode0vamqd0(1)));
                                gapComposer3.updateRememberedValue(objRememberedValue2);
                            }
                            ShaderBrush shaderBrush = (ShaderBrush) objRememberedValue2;
                            boolean zChanged2 = gapComposer3.changed(shaderBrush) | gapComposer3.changed(0.05f);
                            Object objRememberedValue3 = gapComposer3.rememberedValue();
                            if (zChanged2 || objRememberedValue3 == neverEqualPolicy) {
                                objRememberedValue3 = new DiskLruCache$$ExternalSyntheticLambda0((byte) 25, shaderBrush);
                                gapComposer3.updateRememberedValue(objRememberedValue3);
                            }
                            modifierAmbientGlow = ClipKt.drawBehind(modifierAmbientGlow, (Function1) objRememberedValue3);
                        }
                        gapComposer3.end(false);
                    }
                    gapComposer3.end(false);
                    OffsetKt.BoxWithConstraints(modifierM39backgroundbw27NRU.then(modifierAmbientGlow), null, Expect_jvmKt.rememberComposableLambda(-1537737995, new MainActivity$$ExternalSyntheticLambda17(playerConnection, mainActivity, musicDatabase, z3, downloadUtil, syncUtils, mutableState, hazeState, z2, mainActivity$MetrolistApp$$inlined$rememberEnumPreference$4, str, mutableState2), gapComposer3), gapComposer3, 3072, 6);
                } else {
                    gapComposer3.skipToGroupEnd();
                }
                break;
            case 2:
                LibraryAlbumsViewModel libraryAlbumsViewModel2 = (LibraryAlbumsViewModel) obj11;
                MutableState mutableState3 = (MutableState) obj10;
                SoftwareKeyboardController softwareKeyboardController = (SoftwareKeyboardController) obj9;
                MutableState mutableState4 = (MutableState) obj8;
                AlbumSortType albumSortType = (AlbumSortType) obj7;
                Function1 function1 = (Function1) obj6;
                MimesKt$$ExternalSyntheticLambda0 mimesKt$$ExternalSyntheticLambda0 = (MimesKt$$ExternalSyntheticLambda0) obj5;
                List list = (List) obj4;
                MutableState mutableState5 = (MutableState) obj3;
                Composer composer2 = (Composer) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                GapComposer gapComposer4 = (GapComposer) composer2;
                if (gapComposer4.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    boolean zBooleanValue = ((Boolean) mutableState3.getValue()).booleanValue();
                    String str2 = (String) mutableState4.getValue();
                    boolean zChangedInstance = gapComposer4.changedInstance(libraryAlbumsViewModel2);
                    Object objRememberedValue4 = gapComposer4.rememberedValue();
                    if (zChangedInstance || objRememberedValue4 == neverEqualPolicy) {
                        gapComposer = gapComposer4;
                        libraryAlbumsViewModel = libraryAlbumsViewModel2;
                        anonymousClass2 = new NetworkFetcher.AnonymousClass2(1, libraryAlbumsViewModel, LibraryAlbumsViewModel.class, "updateSearchQuery", "updateSearchQuery(Ljava/lang/String;)V", 0, (byte) 28);
                        gapComposer.updateRememberedValue(anonymousClass2);
                    } else {
                        gapComposer = gapComposer4;
                        anonymousClass2 = objRememberedValue4;
                        libraryAlbumsViewModel = libraryAlbumsViewModel2;
                    }
                    Function1 function2 = (Function1) ((KFunction) anonymousClass2);
                    boolean zChanged3 = gapComposer.changed(mutableState3) | gapComposer.changedInstance(libraryAlbumsViewModel);
                    Object objRememberedValue5 = gapComposer.rememberedValue();
                    if (zChanged3 || objRememberedValue5 == neverEqualPolicy) {
                        objRememberedValue5 = new QueueKt$$ExternalSyntheticLambda16(libraryAlbumsViewModel, mutableState3, (byte) 12);
                        gapComposer.updateRememberedValue(objRememberedValue5);
                    }
                    com.metrolist.music.ui.component.MenuKt.LibrarySearchHeader(zBooleanValue, str2, function2, (Function0) objRememberedValue5, softwareKeyboardController, OffsetKt.m139paddingqDBjuR0$default(Modifier.Companion.$$INSTANCE, 16.0f, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 14), Expect_jvmKt.rememberComposableLambda(-1772115650, new QueueMenuKt$$ExternalSyntheticLambda6(albumSortType, this.f$3, function1, mimesKt$$ExternalSyntheticLambda0, list, mutableState3, mutableState5), gapComposer), gapComposer, 1769472);
                } else {
                    gapComposer4.skipToGroupEnd();
                }
                break;
            case 3:
                LibraryArtistsViewModel libraryArtistsViewModel2 = (LibraryArtistsViewModel) obj11;
                MutableState mutableState6 = (MutableState) obj10;
                SoftwareKeyboardController softwareKeyboardController2 = (SoftwareKeyboardController) obj9;
                State state = (State) obj8;
                ArtistSortType artistSortType = (ArtistSortType) obj7;
                Function1 function3 = (Function1) obj6;
                MimesKt$$ExternalSyntheticLambda0 mimesKt$$ExternalSyntheticLambda1 = (MimesKt$$ExternalSyntheticLambda0) obj5;
                MutableState mutableState7 = (MutableState) obj4;
                State state2 = (State) obj3;
                Composer composer3 = (Composer) obj;
                int iIntValue3 = ((Integer) obj2).intValue();
                GapComposer gapComposer5 = (GapComposer) composer3;
                if (gapComposer5.shouldExecute(iIntValue3 & 1, (iIntValue3 & 3) != 2)) {
                    boolean zBooleanValue2 = ((Boolean) mutableState6.getValue()).booleanValue();
                    String str3 = (String) state.getValue();
                    boolean zChangedInstance2 = gapComposer5.changedInstance(libraryArtistsViewModel2);
                    Object objRememberedValue6 = gapComposer5.rememberedValue();
                    if (zChangedInstance2 || objRememberedValue6 == neverEqualPolicy) {
                        gapComposer2 = gapComposer5;
                        libraryArtistsViewModel = libraryArtistsViewModel2;
                        anonymousClass3 = new NetworkFetcher.AnonymousClass2(1, libraryArtistsViewModel, LibraryArtistsViewModel.class, "updateSearchQuery", "updateSearchQuery(Ljava/lang/String;)V", 0, (byte) 29);
                        gapComposer2.updateRememberedValue(anonymousClass3);
                    } else {
                        gapComposer2 = gapComposer5;
                        anonymousClass3 = objRememberedValue6;
                        libraryArtistsViewModel = libraryArtistsViewModel2;
                    }
                    Function1 function4 = (Function1) ((KFunction) anonymousClass3);
                    boolean zChanged4 = gapComposer2.changed(mutableState6) | gapComposer2.changedInstance(libraryArtistsViewModel);
                    Object objRememberedValue7 = gapComposer2.rememberedValue();
                    if (zChanged4 || objRememberedValue7 == neverEqualPolicy) {
                        objRememberedValue7 = new QueueKt$$ExternalSyntheticLambda16(libraryArtistsViewModel, mutableState6, (byte) 13);
                        gapComposer2.updateRememberedValue(objRememberedValue7);
                    }
                    com.metrolist.music.ui.component.MenuKt.LibrarySearchHeader(zBooleanValue2, str3, function4, (Function0) objRememberedValue7, softwareKeyboardController2, OffsetKt.m139paddingqDBjuR0$default(Modifier.Companion.$$INSTANCE, 16.0f, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 14), Expect_jvmKt.rememberComposableLambda(-848144188, new QueueMenuKt$$ExternalSyntheticLambda6(artistSortType, this.f$3, function3, mimesKt$$ExternalSyntheticLambda1, mutableState6, mutableState7, state2, (byte) 5), gapComposer2), gapComposer2, 1769472);
                } else {
                    gapComposer5.skipToGroupEnd();
                }
                break;
            default:
                LibraryMixViewModel libraryMixViewModel = (LibraryMixViewModel) obj11;
                MutableState mutableState8 = (MutableState) obj10;
                SoftwareKeyboardController softwareKeyboardController3 = (SoftwareKeyboardController) obj9;
                MutableState mutableState9 = (MutableState) obj8;
                MixSortType mixSortType = (MixSortType) obj7;
                Function1 function5 = (Function1) obj6;
                Function1 function6 = (Function1) obj5;
                Function1 function7 = (Function1) obj4;
                LibraryViewType libraryViewType = (LibraryViewType) obj3;
                Composer composer4 = (Composer) obj;
                int iIntValue4 = ((Integer) obj2).intValue();
                GapComposer gapComposer6 = (GapComposer) composer4;
                if (gapComposer6.shouldExecute(iIntValue4 & 1, (iIntValue4 & 3) != 2)) {
                    boolean zBooleanValue3 = ((Boolean) mutableState8.getValue()).booleanValue();
                    String str4 = (String) mutableState9.getValue();
                    boolean zChangedInstance3 = gapComposer6.changedInstance(libraryMixViewModel);
                    Object objRememberedValue8 = gapComposer6.rememberedValue();
                    if (zChangedInstance3 || objRememberedValue8 == neverEqualPolicy) {
                        objRememberedValue8 = new JobKt__JobKt$invokeOnCompletion$1(1, libraryMixViewModel, LibraryMixViewModel.class, "updateSearchQuery", "updateSearchQuery(Ljava/lang/String;)V", 0, (byte) 1);
                        gapComposer6.updateRememberedValue(objRememberedValue8);
                    }
                    Function1 function8 = (Function1) ((KFunction) objRememberedValue8);
                    boolean zChanged5 = gapComposer6.changed(mutableState8) | gapComposer6.changedInstance(libraryMixViewModel);
                    Object objRememberedValue9 = gapComposer6.rememberedValue();
                    if (zChanged5 || objRememberedValue9 == neverEqualPolicy) {
                        objRememberedValue9 = new QueueKt$$ExternalSyntheticLambda16(libraryMixViewModel, mutableState8, (byte) 14);
                        gapComposer6.updateRememberedValue(objRememberedValue9);
                    }
                    com.metrolist.music.ui.component.MenuKt.LibrarySearchHeader(zBooleanValue3, str4, function8, (Function0) objRememberedValue9, softwareKeyboardController3, OffsetKt.m139paddingqDBjuR0$default(Modifier.Companion.$$INSTANCE, 16.0f, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 14), Expect_jvmKt.rememberComposableLambda(-1871527450, new QueueMenuKt$$ExternalSyntheticLambda6(mixSortType, this.f$3, function5, function6, mutableState8, function7, libraryViewType, (byte) 6), gapComposer6), gapComposer6, 1769472);
                } else {
                    gapComposer6.skipToGroupEnd();
                }
                break;
        }
        return unit;
    }

    public /* synthetic */ ChipKt$$ExternalSyntheticLambda1(ViewModel viewModel, MutableState mutableState, SoftwareKeyboardController softwareKeyboardController, MutableState mutableState2, Enum r5, boolean z, Function1 function1, Function1 function2, Object obj, Object obj2, byte b) {
        this.$r8$classId = b;
        this.f$0 = viewModel;
        this.f$1 = mutableState;
        this.f$2 = softwareKeyboardController;
        this.f$5 = mutableState2;
        this.f$6 = r5;
        this.f$3 = z;
        this.f$7 = function1;
        this.f$8 = function2;
        this.f$9 = obj;
        this.f$10 = obj2;
    }

    public /* synthetic */ ChipKt$$ExternalSyntheticLambda1(boolean z, PlayerConnection playerConnection, MainActivity mainActivity, MusicDatabase musicDatabase, DownloadUtil downloadUtil, SyncUtils syncUtils, MutableState mutableState, MainActivity$MetrolistApp$$inlined$rememberEnumPreference$4 mainActivity$MetrolistApp$$inlined$rememberEnumPreference$4, String str, MutableState mutableState2) {
        this.$r8$classId = (byte) 1;
        this.f$3 = z;
        this.f$0 = playerConnection;
        this.f$1 = mainActivity;
        this.f$2 = musicDatabase;
        this.f$5 = downloadUtil;
        this.f$6 = syncUtils;
        this.f$7 = mutableState;
        this.f$8 = mainActivity$MetrolistApp$$inlined$rememberEnumPreference$4;
        this.f$9 = str;
        this.f$10 = mutableState2;
    }
}
