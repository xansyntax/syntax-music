package kotlin.uuid;

import android.net.Uri;
import android.os.Bundle;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.Dp;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.media3.common.MediaItem;
import androidx.sqlite.SQLite;
import com.google.common.util.concurrent.ImmediateFuture;
import com.materialkolor.hct.Hct;
import com.metrolist.innertube.models.Album;
import com.metrolist.innertube.models.AlbumItem;
import com.metrolist.innertube.models.Artist;
import com.metrolist.innertube.models.ArtistItem;
import com.metrolist.innertube.models.EpisodeItem;
import com.metrolist.innertube.models.PlaylistItem;
import com.metrolist.innertube.models.PodcastItem;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.innertube.models.YTItem;
import com.metrolist.music.db.DatabaseDao_Impl$$ExternalSyntheticLambda7;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.db.entities.SpeedDialItem;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.ui.theme.UiStyleKt;
import com.metrolist.music.utils.ArtistNameAliases;
import com.yalantis.ucrop.view.CropImageView;
import dagger.hilt.EntryPoints;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.Grouping;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.jvm.internal.markers.KMutableMap;
import kotlin.random.AbstractPlatformRandom;
import kotlin.random.Random;
import kotlin.ranges.ClosedFloatRange;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.text.Charsets;
import kotlin.text.HexExtensionsKt;
import kotlin.text.HexFormatKt;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.uuid.UuidKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonConfiguration;
import kotlinx.serialization.json.JsonImpl;
import kotlinx.serialization.modules.SerializersModule;
import kotlinx.serialization.modules.SerializersModuleKt;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.UnreadableResponseBody;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.ByteString;

/* JADX INFO: loaded from: classes.dex */
public abstract class UuidKt {
    public static JsonImpl Json$default(Function1 function1) {
        Json.Default r0 = Json.Default;
        r0.getClass();
        JsonBuilder jsonBuilder = new JsonBuilder();
        JsonConfiguration jsonConfiguration = r0.configuration;
        jsonBuilder.encodeDefaults = jsonConfiguration.encodeDefaults;
        jsonBuilder.explicitNulls = jsonConfiguration.explicitNulls;
        jsonBuilder.ignoreUnknownKeys = jsonConfiguration.ignoreUnknownKeys;
        jsonBuilder.isLenient = jsonConfiguration.isLenient;
        jsonBuilder.prettyPrint = jsonConfiguration.prettyPrint;
        String str = jsonConfiguration.prettyPrintIndent;
        jsonBuilder.prettyPrintIndent = str;
        jsonBuilder.classDiscriminator = jsonConfiguration.classDiscriminator;
        jsonBuilder.classDiscriminatorMode = jsonConfiguration.classDiscriminatorMode;
        jsonBuilder.useAlternativeNames = jsonConfiguration.useAlternativeNames;
        jsonBuilder.allowSpecialFloatingPointValues = jsonConfiguration.allowSpecialFloatingPointValues;
        jsonBuilder.allowStructuredMapKeys = jsonConfiguration.allowStructuredMapKeys;
        jsonBuilder.serializersModule = r0.serializersModule;
        jsonBuilder.exceptionsWithDebugInfo = jsonConfiguration.exceptionsWithDebugInfo;
        function1.invoke(jsonBuilder);
        if (jsonBuilder.prettyPrint) {
            if (!str.equals("    ")) {
                for (int i = 0; i < str.length(); i++) {
                    char cCharAt = str.charAt(i);
                    if (cCharAt != ' ' && cCharAt != '\t' && cCharAt != '\r' && cCharAt != '\n') {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) "Only whitespace, tab, newline and carriage return are allowed as pretty print symbols. Had ".concat(str));
                        return null;
                    }
                }
            }
        } else if (!str.equals("    ")) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Indent should not be specified when default printing mode is used");
            return null;
        }
        JsonConfiguration jsonConfiguration2 = new JsonConfiguration(jsonBuilder.encodeDefaults, jsonBuilder.ignoreUnknownKeys, jsonBuilder.isLenient, jsonBuilder.allowStructuredMapKeys, jsonBuilder.prettyPrint, jsonBuilder.explicitNulls, jsonBuilder.prettyPrintIndent, jsonBuilder.classDiscriminator, jsonBuilder.allowSpecialFloatingPointValues, jsonBuilder.useAlternativeNames, jsonBuilder.classDiscriminatorMode, jsonBuilder.exceptionsWithDebugInfo);
        SerializersModule serializersModule = jsonBuilder.serializersModule;
        serializersModule.getClass();
        JsonImpl jsonImpl = new JsonImpl(jsonConfiguration2, serializersModule);
        serializersModule.equals(SerializersModuleKt.EmptySerializersModule);
        return jsonImpl;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0049  */
    /* JADX WARN: Code duplicated, block: B:28:0x0051  */
    /* JADX WARN: Code duplicated, block: B:29:0x0054  */
    /* JADX WARN: Code duplicated, block: B:33:0x0061  */
    /* JADX WARN: Code duplicated, block: B:34:0x0063  */
    /* JADX WARN: Code duplicated, block: B:37:0x006b  */
    /* JADX WARN: Code duplicated, block: B:39:0x0073  */
    /* JADX WARN: Code duplicated, block: B:43:0x0080 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:44:0x0082  */
    /* JADX WARN: Code duplicated, block: B:45:0x0085  */
    /* JADX WARN: Code duplicated, block: B:47:0x0088  */
    /* JADX WARN: Code duplicated, block: B:48:0x008b  */
    /* JADX WARN: Code duplicated, block: B:51:0x0090  */
    /* JADX WARN: Code duplicated, block: B:54:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:57:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:60:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:62:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: TextPlaceholder-uFdPcIQ, reason: not valid java name */
    public static final void m1896TextPlaceholderuFdPcIQ(Modifier modifier, float f, RoundedCornerShape roundedCornerShape, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        float f2;
        RoundedCornerShape roundedCornerShapeM185RoundedCornerShape0680j_4;
        int i4;
        boolean z;
        final Modifier modifier3;
        final float f3;
        final RoundedCornerShape roundedCornerShape2;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        Modifier modifier4;
        float f4;
        Object objRememberedValue;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(1013371479);
        int i5 = i2 & 1;
        if (i5 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = i | (gapComposer.changed(modifier2) ? 4 : 2);
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        int i6 = i2 & 2;
        if (i6 == 0) {
            if ((i & 48) == 0) {
                f2 = f;
                i3 |= gapComposer.changed(f2) ? 32 : 16;
            }
            if ((i2 & 4) == 0) {
                roundedCornerShapeM185RoundedCornerShape0680j_4 = roundedCornerShape;
                int i7 = gapComposer.changed(roundedCornerShapeM185RoundedCornerShape0680j_4) ? 256 : 128;
                i4 = i3 | i7;
                if ((i4 & 147) != 146) {
                    z = true;
                } else {
                    z = false;
                }
                if (gapComposer.shouldExecute(i4 & 1, z)) {
                    gapComposer.startDefaults();
                    if ((i & 1) != 0 || gapComposer.getDefaultsInvalid()) {
                        if (i5 != 0) {
                            modifier4 = Modifier.Companion.$$INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i6 != 0) {
                            f4 = 16.0f;
                        } else {
                            f4 = f2;
                        }
                        if ((i2 & 4) != 0) {
                            roundedCornerShapeM185RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(UiStyleKt.m1516styledRadiusi1RSzL4(8.0f, CropImageView.DEFAULT_ASPECT_RATIO, gapComposer));
                        }
                    } else {
                        gapComposer.skipToGroupEnd();
                        modifier4 = modifier2;
                        f4 = f2;
                    }
                    gapComposer.endDefaults();
                    Modifier modifierM145height3ABfNKs = SizeKt.m145height3ABfNKs(OffsetKt.m137paddingVpY3zN4$default(modifier4, CropImageView.DEFAULT_ASPECT_RATIO, 4.0f, 1), f4);
                    objRememberedValue = gapComposer.rememberedValue();
                    if (objRememberedValue == Composer.Companion.Empty) {
                        AbstractPlatformRandom abstractPlatformRandom = Random.defaultRandom;
                        objRememberedValue = Float.valueOf((Random.defaultRandom.getImpl().nextFloat() * 0.5f) + 0.25f);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    BoxKt.Box(ImageKt.m39backgroundbw27NRU(ClipKt.clip(SizeKt.fillMaxWidth(modifierM145height3ABfNKs, ((Number) objRememberedValue).floatValue()), roundedCornerShapeM185RoundedCornerShape0680j_4), ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.surfaceContainerHigh, ColorKt.RectangleShape), gapComposer, 0);
                    modifier3 = modifier4;
                    f3 = f4;
                } else {
                    gapComposer.skipToGroupEnd();
                    modifier3 = modifier2;
                    f3 = f2;
                }
                roundedCornerShape2 = roundedCornerShapeM185RoundedCornerShape0680j_4;
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.metrolist.music.ui.component.shimmer.TextPlaceholderKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            ((Integer) obj2).getClass();
                            UuidKt.m1896TextPlaceholderuFdPcIQ(modifier3, f3, roundedCornerShape2, (Composer) obj, Stack.updateChangedFlags(i | 1), i2);
                            return Unit.INSTANCE;
                        }
                    };
                }
            }
            roundedCornerShapeM185RoundedCornerShape0680j_4 = roundedCornerShape;
            i4 = i3 | i7;
            if ((i4 & 147) != 146) {
                z = true;
            } else {
                z = false;
            }
            if (gapComposer.shouldExecute(i4 & 1, z)) {
                gapComposer.startDefaults();
                if ((i & 1) != 0) {
                    if (i5 != 0) {
                        modifier4 = Modifier.Companion.$$INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i6 != 0) {
                        f4 = 16.0f;
                    } else {
                        f4 = f2;
                    }
                    if ((i2 & 4) != 0) {
                        roundedCornerShapeM185RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(UiStyleKt.m1516styledRadiusi1RSzL4(8.0f, CropImageView.DEFAULT_ASPECT_RATIO, gapComposer));
                    }
                } else {
                    if (i5 != 0) {
                        modifier4 = Modifier.Companion.$$INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i6 != 0) {
                        f4 = 16.0f;
                    } else {
                        f4 = f2;
                    }
                    if ((i2 & 4) != 0) {
                        roundedCornerShapeM185RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(UiStyleKt.m1516styledRadiusi1RSzL4(8.0f, CropImageView.DEFAULT_ASPECT_RATIO, gapComposer));
                    }
                }
                gapComposer.endDefaults();
                Modifier modifierM145height3ABfNKs2 = SizeKt.m145height3ABfNKs(OffsetKt.m137paddingVpY3zN4$default(modifier4, CropImageView.DEFAULT_ASPECT_RATIO, 4.0f, 1), f4);
                objRememberedValue = gapComposer.rememberedValue();
                if (objRememberedValue == Composer.Companion.Empty) {
                    AbstractPlatformRandom abstractPlatformRandom2 = Random.defaultRandom;
                    objRememberedValue = Float.valueOf((Random.defaultRandom.getImpl().nextFloat() * 0.5f) + 0.25f);
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                BoxKt.Box(ImageKt.m39backgroundbw27NRU(ClipKt.clip(SizeKt.fillMaxWidth(modifierM145height3ABfNKs2, ((Number) objRememberedValue).floatValue()), roundedCornerShapeM185RoundedCornerShape0680j_4), ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.surfaceContainerHigh, ColorKt.RectangleShape), gapComposer, 0);
                modifier3 = modifier4;
                f3 = f4;
            } else {
                gapComposer.skipToGroupEnd();
                modifier3 = modifier2;
                f3 = f2;
            }
            roundedCornerShape2 = roundedCornerShapeM185RoundedCornerShape0680j_4;
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.metrolist.music.ui.component.shimmer.TextPlaceholderKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        ((Integer) obj2).getClass();
                        UuidKt.m1896TextPlaceholderuFdPcIQ(modifier3, f3, roundedCornerShape2, (Composer) obj, Stack.updateChangedFlags(i | 1), i2);
                        return Unit.INSTANCE;
                    }
                };
            }
        }
        i3 |= 48;
        f2 = f;
        if ((i2 & 4) == 0) {
            roundedCornerShapeM185RoundedCornerShape0680j_4 = roundedCornerShape;
            if (gapComposer.changed(roundedCornerShapeM185RoundedCornerShape0680j_4)) {
            }
            i4 = i3 | i7;
            if ((i4 & 147) != 146) {
                z = true;
            } else {
                z = false;
            }
            if (gapComposer.shouldExecute(i4 & 1, z)) {
                gapComposer.startDefaults();
                if ((i & 1) != 0) {
                    if (i5 != 0) {
                        modifier4 = Modifier.Companion.$$INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i6 != 0) {
                        f4 = 16.0f;
                    } else {
                        f4 = f2;
                    }
                    if ((i2 & 4) != 0) {
                        roundedCornerShapeM185RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(UiStyleKt.m1516styledRadiusi1RSzL4(8.0f, CropImageView.DEFAULT_ASPECT_RATIO, gapComposer));
                    }
                } else {
                    if (i5 != 0) {
                        modifier4 = Modifier.Companion.$$INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i6 != 0) {
                        f4 = 16.0f;
                    } else {
                        f4 = f2;
                    }
                    if ((i2 & 4) != 0) {
                        roundedCornerShapeM185RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(UiStyleKt.m1516styledRadiusi1RSzL4(8.0f, CropImageView.DEFAULT_ASPECT_RATIO, gapComposer));
                    }
                }
                gapComposer.endDefaults();
                Modifier modifierM145height3ABfNKs3 = SizeKt.m145height3ABfNKs(OffsetKt.m137paddingVpY3zN4$default(modifier4, CropImageView.DEFAULT_ASPECT_RATIO, 4.0f, 1), f4);
                objRememberedValue = gapComposer.rememberedValue();
                if (objRememberedValue == Composer.Companion.Empty) {
                    AbstractPlatformRandom abstractPlatformRandom3 = Random.defaultRandom;
                    objRememberedValue = Float.valueOf((Random.defaultRandom.getImpl().nextFloat() * 0.5f) + 0.25f);
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                BoxKt.Box(ImageKt.m39backgroundbw27NRU(ClipKt.clip(SizeKt.fillMaxWidth(modifierM145height3ABfNKs3, ((Number) objRememberedValue).floatValue()), roundedCornerShapeM185RoundedCornerShape0680j_4), ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.surfaceContainerHigh, ColorKt.RectangleShape), gapComposer, 0);
                modifier3 = modifier4;
                f3 = f4;
            } else {
                gapComposer.skipToGroupEnd();
                modifier3 = modifier2;
                f3 = f2;
            }
            roundedCornerShape2 = roundedCornerShapeM185RoundedCornerShape0680j_4;
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.metrolist.music.ui.component.shimmer.TextPlaceholderKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        ((Integer) obj2).getClass();
                        UuidKt.m1896TextPlaceholderuFdPcIQ(modifier3, f3, roundedCornerShape2, (Composer) obj, Stack.updateChangedFlags(i | 1), i2);
                        return Unit.INSTANCE;
                    }
                };
            }
        }
        roundedCornerShapeM185RoundedCornerShape0680j_4 = roundedCornerShape;
        i4 = i3 | i7;
        if ((i4 & 147) != 146) {
            z = true;
        } else {
            z = false;
        }
        if (gapComposer.shouldExecute(i4 & 1, z)) {
            gapComposer.startDefaults();
            if ((i & 1) != 0) {
                if (i5 != 0) {
                    modifier4 = Modifier.Companion.$$INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i6 != 0) {
                    f4 = 16.0f;
                } else {
                    f4 = f2;
                }
                if ((i2 & 4) != 0) {
                    roundedCornerShapeM185RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(UiStyleKt.m1516styledRadiusi1RSzL4(8.0f, CropImageView.DEFAULT_ASPECT_RATIO, gapComposer));
                }
            } else {
                if (i5 != 0) {
                    modifier4 = Modifier.Companion.$$INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i6 != 0) {
                    f4 = 16.0f;
                } else {
                    f4 = f2;
                }
                if ((i2 & 4) != 0) {
                    roundedCornerShapeM185RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(UiStyleKt.m1516styledRadiusi1RSzL4(8.0f, CropImageView.DEFAULT_ASPECT_RATIO, gapComposer));
                }
            }
            gapComposer.endDefaults();
            Modifier modifierM145height3ABfNKs4 = SizeKt.m145height3ABfNKs(OffsetKt.m137paddingVpY3zN4$default(modifier4, CropImageView.DEFAULT_ASPECT_RATIO, 4.0f, 1), f4);
            objRememberedValue = gapComposer.rememberedValue();
            if (objRememberedValue == Composer.Companion.Empty) {
                AbstractPlatformRandom abstractPlatformRandom4 = Random.defaultRandom;
                objRememberedValue = Float.valueOf((Random.defaultRandom.getImpl().nextFloat() * 0.5f) + 0.25f);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            BoxKt.Box(ImageKt.m39backgroundbw27NRU(ClipKt.clip(SizeKt.fillMaxWidth(modifierM145height3ABfNKs4, ((Number) objRememberedValue).floatValue()), roundedCornerShapeM185RoundedCornerShape0680j_4), ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.surfaceContainerHigh, ColorKt.RectangleShape), gapComposer, 0);
            modifier3 = modifier4;
            f3 = f4;
        } else {
            gapComposer.skipToGroupEnd();
            modifier3 = modifier2;
            f3 = f2;
        }
        roundedCornerShape2 = roundedCornerShapeM185RoundedCornerShape0680j_4;
        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.metrolist.music.ui.component.shimmer.TextPlaceholderKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    UuidKt.m1896TextPlaceholderuFdPcIQ(modifier3, f3, roundedCornerShape2, (Composer) obj, Stack.updateChangedFlags(i | 1), i2);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public static String binarySearch(ByteString byteString, ByteString[] byteStringArr, int i) {
        int i2;
        boolean z;
        int i3;
        int i4;
        int size$okio = byteString.getSize$okio();
        int i5 = 0;
        while (i5 < size$okio) {
            int i6 = (i5 + size$okio) / 2;
            while (i6 > -1 && byteString.internalGet$okio(i6) != 10) {
                i6--;
            }
            int i7 = i6 + 1;
            int i8 = 1;
            while (true) {
                i2 = i7 + i8;
                if (byteString.internalGet$okio(i2) == 10) {
                    break;
                }
                i8++;
            }
            int i9 = i2 - i7;
            int i10 = i;
            boolean z2 = false;
            int i11 = 0;
            int i12 = 0;
            while (true) {
                if (z2) {
                    i3 = 46;
                    z = false;
                } else {
                    byte bInternalGet$okio = byteStringArr[i10].internalGet$okio(i11);
                    byte[] bArr = _UtilCommonKt.EMPTY_BYTE_ARRAY;
                    int i13 = bInternalGet$okio & 255;
                    z = z2;
                    i3 = i13;
                }
                byte bInternalGet$okio2 = byteString.internalGet$okio(i7 + i12);
                byte[] bArr2 = _UtilCommonKt.EMPTY_BYTE_ARRAY;
                i4 = i3 - (bInternalGet$okio2 & 255);
                if (i4 != 0) {
                    break;
                }
                i12++;
                i11++;
                if (i12 == i9) {
                    break;
                }
                if (byteStringArr[i10].getSize$okio() != i11) {
                    z2 = z;
                } else {
                    if (i10 == byteStringArr.length - 1) {
                        break;
                    }
                    i10++;
                    i11 = -1;
                    z2 = true;
                }
            }
            if (i4 >= 0) {
                if (i4 <= 0) {
                    int i14 = i9 - i12;
                    int size$okio2 = byteStringArr[i10].getSize$okio() - i11;
                    int length = byteStringArr.length;
                    for (int i15 = i10 + 1; i15 < length; i15++) {
                        size$okio2 += byteStringArr[i15].getSize$okio();
                    }
                    if (size$okio2 >= i14) {
                        if (size$okio2 <= i14) {
                            return byteString.substring(i7, i9 + i7).string(Charsets.UTF_8);
                        }
                    }
                }
                i5 = i2 + 1;
            }
            size$okio = i6;
        }
        return null;
    }

    public static Comparable coerceAtLeast(Dp dp, Dp dp2) {
        return dp.compareTo(dp2) < 0 ? dp2 : dp;
    }

    public static Comparable coerceIn(Float f, ClosedFloatRange closedFloatRange) {
        closedFloatRange.getClass();
        float f2 = closedFloatRange._endInclusive;
        float f3 = closedFloatRange._start;
        if (f3 <= f2) {
            if (!ClosedFloatRange.lessThanOrEquals(f, Float.valueOf(f3)) || ClosedFloatRange.lessThanOrEquals(Float.valueOf(f3), f)) {
                return (!ClosedFloatRange.lessThanOrEquals(Float.valueOf(f2), f) || ClosedFloatRange.lessThanOrEquals(f, Float.valueOf(f2))) ? f : Float.valueOf(f2);
            }
            return Float.valueOf(f3);
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + closedFloatRange + '.');
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0044 A[PHI: r6
      0x0044: PHI (r6v32 int) = (r6v4 int), (r6v18 int), (r6v18 int), (r6v20 int), (r6v28 int), (r6v28 int), (r6v33 int), (r6v39 int) binds: [B:91:0x014f, B:61:0x00d0, B:63:0x00d6, B:55:0x00bd, B:38:0x007d, B:40:0x0083, B:30:0x0060, B:21:0x0040] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:29:0x005e A[PHI: r6
      0x005e: PHI (r6v29 int) = (r6v5 int), (r6v18 int), (r6v18 int), (r6v21 int), (r6v28 int), (r6v37 int), (r6v38 int) binds: [B:90:0x0149, B:65:0x00da, B:67:0x00e0, B:54:0x00b8, B:40:0x0083, B:28:0x0058, B:27:0x0053] A[DONT_GENERATE, DONT_INLINE]] */
    public static final String commonToUtf8String(byte[] bArr, int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6 = i;
        if (i6 < 0 || i2 > bArr.length || i6 > i2) {
            throw new IndexOutOfBoundsException("size=" + bArr.length + " beginIndex=" + i6 + " endIndex=" + i2);
        }
        char[] cArr = new char[i2 - i6];
        int i7 = 0;
        while (i6 < i2) {
            byte b = bArr[i6];
            if (b >= 0) {
                int i8 = i7 + 1;
                cArr[i7] = (char) b;
                i6++;
                while (i6 < i2) {
                    byte b2 = bArr[i6];
                    if (b2 < 0) {
                        break;
                    }
                    i6++;
                    cArr[i8] = (char) b2;
                    i8++;
                }
                i7 = i8;
            } else {
                if ((b >> 5) == -2) {
                    int i9 = i6 + 1;
                    if (i2 <= i9) {
                        i3 = i7 + 1;
                        cArr[i7] = 65533;
                    } else {
                        byte b3 = bArr[i9];
                        if ((b3 & 192) == 128) {
                            int i10 = (b << 6) ^ (b3 ^ 3968);
                            if (i10 < 128) {
                                i3 = i7 + 1;
                                cArr[i7] = 65533;
                            } else {
                                cArr[i7] = (char) i10;
                                i3 = i7 + 1;
                            }
                            i5 = 2;
                            i6 += i5;
                        } else {
                            i3 = i7 + 1;
                            cArr[i7] = 65533;
                        }
                    }
                    i5 = 1;
                    i6 += i5;
                } else if ((b >> 4) == -2) {
                    int i11 = i6 + 2;
                    if (i2 <= i11) {
                        i3 = i7 + 1;
                        cArr[i7] = 65533;
                        int i12 = i6 + 1;
                        if (i2 <= i12 || (bArr[i12] & 192) != 128) {
                            i5 = 1;
                        } else {
                            i5 = 2;
                        }
                    } else {
                        byte b4 = bArr[i6 + 1];
                        if ((b4 & 192) == 128) {
                            byte b5 = bArr[i11];
                            if ((b5 & 192) == 128) {
                                int i13 = (b << 12) ^ ((b5 ^ (-123008)) ^ (b4 << 6));
                                if (i13 < 2048) {
                                    i3 = i7 + 1;
                                    cArr[i7] = 65533;
                                } else if (55296 > i13 || i13 >= 57344) {
                                    cArr[i7] = (char) i13;
                                    i3 = i7 + 1;
                                } else {
                                    i3 = i7 + 1;
                                    cArr[i7] = 65533;
                                }
                                i5 = 3;
                            } else {
                                i3 = i7 + 1;
                                cArr[i7] = 65533;
                                i5 = 2;
                            }
                        } else {
                            i3 = i7 + 1;
                            cArr[i7] = 65533;
                            i5 = 1;
                        }
                    }
                    i6 += i5;
                } else if ((b >> 3) == -2) {
                    int i14 = i6 + 3;
                    if (i2 <= i14) {
                        i3 = i7 + 1;
                        cArr[i7] = 65533;
                        int i15 = i6 + 1;
                        if (i2 <= i15 || (bArr[i15] & 192) != 128) {
                            i5 = 1;
                        } else {
                            int i16 = i6 + 2;
                            if (i2 <= i16 || (bArr[i16] & 192) != 128) {
                                i5 = 2;
                            } else {
                                i5 = 3;
                            }
                        }
                    } else {
                        byte b6 = bArr[i6 + 1];
                        if ((b6 & 192) == 128) {
                            byte b7 = bArr[i6 + 2];
                            if ((b7 & 192) == 128) {
                                byte b8 = bArr[i14];
                                if ((b8 & 192) == 128) {
                                    int i17 = (b << 18) ^ (((b8 ^ 3678080) ^ (b7 << 6)) ^ (b6 << 12));
                                    if (i17 > 1114111) {
                                        i3 = i7 + 1;
                                        cArr[i7] = 65533;
                                    } else if ((55296 > i17 || i17 >= 57344) && i17 >= 65536) {
                                        if (i17 != 65533) {
                                            cArr[i7] = (char) ((i17 >>> 10) + 55232);
                                            i4 = i7 + 2;
                                            cArr[i7 + 1] = (char) ((i17 & 1023) + 56320);
                                        } else {
                                            cArr[i7] = 65533;
                                            i4 = i7 + 1;
                                        }
                                        i3 = i4;
                                    } else {
                                        i3 = i7 + 1;
                                        cArr[i7] = 65533;
                                    }
                                    i5 = 4;
                                } else {
                                    i3 = i7 + 1;
                                    cArr[i7] = 65533;
                                    i5 = 3;
                                }
                            } else {
                                i3 = i7 + 1;
                                cArr[i7] = 65533;
                                i5 = 2;
                            }
                        } else {
                            i3 = i7 + 1;
                            cArr[i7] = 65533;
                            i5 = 1;
                        }
                    }
                    i6 += i5;
                } else {
                    i3 = i7 + 1;
                    cArr[i7] = 65533;
                    i6++;
                }
                i7 = i3;
            }
        }
        return StringsKt__StringsJVMKt.concatToString(cArr, 0, i7);
    }

    public static Map eachCount(Grouping grouping) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator itSourceIterator = grouping.sourceIterator();
        while (itSourceIterator.hasNext()) {
            String strKeyOf = grouping.keyOf(itSourceIterator.next());
            Object ref$IntRef = linkedHashMap.get(strKeyOf);
            if (ref$IntRef == null && !linkedHashMap.containsKey(strKeyOf)) {
                ref$IntRef = new Ref$IntRef();
            }
            Ref$IntRef ref$IntRef2 = (Ref$IntRef) ref$IntRef;
            ref$IntRef2.element++;
            linkedHashMap.put(strKeyOf, ref$IntRef2);
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            entry.getClass();
            if ((entry instanceof KMappedMarker) && !(entry instanceof KMutableMap.Entry)) {
                TypeIntrinsics.throwCce(entry, "kotlin.collections.MutableMap.MutableEntry");
                throw null;
            }
            entry.setValue(Integer.valueOf(((Ref$IntRef) entry.getValue()).element));
        }
        return TypeIntrinsics.asMutableMap(linkedHashMap);
    }

    public static final void formatBytesInto(long j, byte[] bArr, int i, int i2, int i3) {
        int i4 = 7 - i2;
        int i5 = 8 - i3;
        if (i5 > i4) {
            return;
        }
        while (true) {
            int i6 = HexExtensionsKt.BYTE_TO_LOWER_CASE_HEX_DIGITS[(int) ((j >> (i4 << 3)) & 255)];
            int i7 = i + 1;
            bArr[i] = (byte) (i6 >> 8);
            i += 2;
            bArr[i7] = (byte) i6;
            if (i4 == i5) {
                return;
            } else {
                i4--;
            }
        }
    }

    public static SpeedDialItem fromYTItem(YTItem yTItem) throws IOException {
        yTItem.getClass();
        if (yTItem instanceof SongItem) {
            SongItem songItem = (SongItem) yTItem;
            String str = songItem.id;
            String str2 = songItem.title;
            String strJoinToString$default = CollectionsKt.joinToString$default(songItem.artists, ", ", null, null, new DatabaseDao_Impl$$ExternalSyntheticLambda7((byte) 7), 30);
            String strJoinToString$default2 = CollectionsKt.joinToString$default(songItem.artists, ", ", null, null, new DatabaseDao_Impl$$ExternalSyntheticLambda7((byte) 8), 30);
            String str3 = songItem.thumbnail;
            boolean z = songItem.explicit;
            Album album = songItem.album;
            return new SpeedDialItem(str, (String) null, str2, strJoinToString$default, strJoinToString$default2, str3, "SONG", z, album != null ? album.id : null, album != null ? album.name : null, 258);
        }
        if (yTItem instanceof AlbumItem) {
            AlbumItem albumItem = (AlbumItem) yTItem;
            List list = albumItem.artists;
            return new SpeedDialItem(albumItem.browseId, albumItem.playlistId, albumItem.title, list != null ? CollectionsKt.joinToString$default(list, ", ", null, null, new DatabaseDao_Impl$$ExternalSyntheticLambda7((byte) 9), 30) : null, list != null ? CollectionsKt.joinToString$default(list, ", ", null, null, new DatabaseDao_Impl$$ExternalSyntheticLambda7((byte) 10), 30) : null, albumItem.thumbnail, "ALBUM", albumItem.explicit, (String) null, (String) null, 1792);
        }
        if (yTItem instanceof ArtistItem) {
            ArtistItem artistItem = (ArtistItem) yTItem;
            return new SpeedDialItem(artistItem.id, (String) null, artistItem.title, (String) null, (String) null, artistItem.thumbnail, "ARTIST", false, (String) null, (String) null, 1946);
        }
        if (yTItem instanceof PlaylistItem) {
            PlaylistItem playlistItem = (PlaylistItem) yTItem;
            String str4 = playlistItem.id;
            String str5 = playlistItem.title;
            Artist artist = playlistItem.author;
            return new SpeedDialItem(str4, (String) null, str5, artist != null ? artist.name : null, artist != null ? artist.id : null, playlistItem.thumbnail, "PLAYLIST", false, (String) null, (String) null, 1922);
        }
        if (yTItem instanceof PodcastItem) {
            PodcastItem podcastItem = (PodcastItem) yTItem;
            String str6 = podcastItem.id;
            String str7 = podcastItem.title;
            Artist artist2 = podcastItem.author;
            return new SpeedDialItem(str6, (String) null, str7, artist2 != null ? artist2.name : null, artist2 != null ? artist2.id : null, podcastItem.thumbnail, "PLAYLIST", false, (String) null, (String) null, 1922);
        }
        if (!(yTItem instanceof EpisodeItem)) {
            PathKt$$ExternalSyntheticBUOutline0.m$1();
            return null;
        }
        EpisodeItem episodeItem = (EpisodeItem) yTItem;
        String str8 = episodeItem.id;
        String str9 = episodeItem.title;
        Artist artist3 = episodeItem.author;
        String str10 = artist3 != null ? artist3.name : null;
        String str11 = artist3 != null ? artist3.id : null;
        String str12 = episodeItem.thumbnail;
        boolean z2 = episodeItem.explicit;
        Album album2 = episodeItem.podcast;
        return new SpeedDialItem(str8, (String) null, str9, str10, str11, str12, "SONG", z2, album2 != null ? album2.id : null, album2 != null ? album2.name : null, 258);
    }

    public static Object getDone(Future future) {
        if (future.isDone()) {
            return EntryPoints.getUninterruptibly(future);
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$2(SQLite.lenientFormat("Future was expected to be done: %s", future));
        return null;
    }

    public static final MediaMetadata getMetadata(MediaItem mediaItem) {
        mediaItem.getClass();
        MediaItem.LocalConfiguration localConfiguration = mediaItem.localConfiguration;
        Object obj = localConfiguration != null ? localConfiguration.tag : null;
        if (obj instanceof MediaMetadata) {
            return (MediaMetadata) obj;
        }
        return null;
    }

    public static final int getProgressionLastElement(int i, int i2, int i3) {
        if (i3 > 0) {
            if (i < i2) {
                int i4 = i2 % i3;
                if (i4 < 0) {
                    i4 += i3;
                }
                int i5 = i % i3;
                if (i5 < 0) {
                    i5 += i3;
                }
                int i6 = (i4 - i5) % i3;
                if (i6 < 0) {
                    i6 += i3;
                }
                return i2 - i6;
            }
        } else {
            if (i3 >= 0) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Step is zero.");
                return 0;
            }
            if (i > i2) {
                int i7 = -i3;
                int i8 = i % i7;
                if (i8 < 0) {
                    i8 += i7;
                }
                int i9 = i2 % i7;
                if (i9 < 0) {
                    i9 += i7;
                }
                int i10 = (i8 - i9) % i7;
                if (i10 < 0) {
                    i10 += i7;
                }
                return i10 + i2;
            }
        }
        return i2;
    }

    public static double getRotatedHue(Hct hct, double[] dArr, double[] dArr2) {
        double d;
        int iMin = Math.min(dArr.length - 1, dArr2.length);
        double d2 = hct.hue;
        int i = 0;
        while (true) {
            if (i >= iMin) {
                d = d2;
                break;
            }
            if (d2 >= dArr[i] && d2 < dArr[i + 1]) {
                d = dArr2[i] % 360.0d;
                if (d >= 0.0d) {
                    break;
                }
                d += 360.0d;
                break;
            }
            i++;
        }
        if (Math.min(dArr.length - 1, dArr2.length) <= 0) {
            d = 0.0d;
        }
        double d3 = (d2 + d) % 360.0d;
        return d3 < 0.0d ? d3 + 360.0d : d3;
    }

    public static ImmediateFuture immediateFuture(Object obj) {
        return new ImmediateFuture(obj);
    }

    public static final String injectPrefCookie(String str, String str2, String str3) {
        if (str == null || StringsKt.isBlank(str)) {
            return "PREF=hl=" + str2 + "&gl=" + str3;
        }
        List listSplit$default = StringsKt.split$default(str, new String[]{";"}, 0, 6);
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(listSplit$default, 10));
        Iterator it = listSplit$default.iterator();
        while (it.hasNext()) {
            arrayList.add(StringsKt.trim((String) it.next()).toString());
        }
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            if (((String) obj).length() > 0) {
                arrayList2.add(obj);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        int size2 = arrayList2.size();
        int i2 = 0;
        while (i2 < size2) {
            Object obj2 = arrayList2.get(i2);
            i2++;
            String str4 = (String) obj2;
            if (StringsKt__StringsJVMKt.startsWith(str4, "PREF=", true)) {
                for (Object obj3 : StringsKt.split$default(StringsKt.substringAfter(str4, "=", str4), new String[]{"&"}, 0, 6)) {
                    String str5 = (String) obj3;
                    if (!StringsKt__StringsJVMKt.startsWith(str5, "hl=", false) && !StringsKt__StringsJVMKt.startsWith(str5, "gl=", false)) {
                        arrayList3.add(obj3);
                    }
                }
            } else {
                arrayList4.add(str4);
            }
        }
        arrayList3.add(0, "hl=" + str2);
        arrayList3.add(1, "gl=" + str3);
        return CollectionsKt.joinToString$default(CollectionsKt.plus("PREF=".concat(CollectionsKt.joinToString$default(arrayList3, "&", null, null, null, 62)), arrayList4), "; ", null, null, null, 62);
    }

    public static final String logType(Exception exc) {
        String strM = Format$$ExternalSyntheticOutline0.m(exc);
        return strM == null ? "Exception" : strM;
    }

    public static final long mediaRangeChunkSize(String str) {
        str.getClass();
        return usesChunkedMediaRanges(str) ? 524288L : 1048576L;
    }

    public static final boolean requiresBoundedMediaRange(String str) {
        str.getClass();
        return str.equals("ANDROID_VR") || str.equals("IOS") || str.equals("TVHTML5_SIMPLY");
    }

    public static IntProgression step(IntRange intRange, int i) {
        intRange.getClass();
        boolean z = i > 0;
        Integer numValueOf = Integer.valueOf(i);
        if (!z) {
            throw new IllegalArgumentException("Step must be positive, was: " + numValueOf + '.');
        }
        int i2 = intRange.first;
        int i3 = intRange.last;
        if (intRange.step <= 0) {
            i = -i;
        }
        return new IntProgression(i2, i3, i);
    }

    public static final Response stripBody(Response response) {
        response.getClass();
        Response.Builder builderNewBuilder = response.newBuilder();
        ResponseBody responseBody = response.body;
        builderNewBuilder.body = new UnreadableResponseBody(responseBody.contentType(), responseBody.contentLength());
        return builderNewBuilder.build();
    }

    public static final MediaItem toMediaItem(MediaMetadata mediaMetadata) throws IOException {
        mediaMetadata.getClass();
        MediaMetadata mediaMetadataWithResolvedArtistNameAliases = withResolvedArtistNameAliases(mediaMetadata);
        String strJoinToString$default = CollectionsKt.joinToString$default(mediaMetadataWithResolvedArtistNameAliases.artists, null, null, null, new DatabaseDao_Impl$$ExternalSyntheticLambda7((byte) 11), 31);
        MediaItem.Builder builder = new MediaItem.Builder();
        String str = mediaMetadataWithResolvedArtistNameAliases.id;
        str.getClass();
        builder.mediaId = str;
        builder.uri = Uri.parse(str);
        builder.customCacheKey = str;
        builder.tag = mediaMetadataWithResolvedArtistNameAliases;
        androidx.media3.common.MediaMetadata.Builder builder2 = new androidx.media3.common.MediaMetadata.Builder();
        String str2 = mediaMetadataWithResolvedArtistNameAliases.title;
        builder2.title = str2;
        builder2.subtitle = strJoinToString$default;
        builder2.artist = strJoinToString$default;
        String str3 = mediaMetadataWithResolvedArtistNameAliases.thumbnailUrl;
        builder2.artworkUri = str3 != null ? Uri.parse(str3) : null;
        MediaMetadata.Album album = mediaMetadataWithResolvedArtistNameAliases.album;
        builder2.albumTitle = album != null ? album.title : null;
        MediaMetadata.Artist artist = (MediaMetadata.Artist) CollectionsKt.firstOrNull(mediaMetadataWithResolvedArtistNameAliases.artists);
        builder2.albumArtist = artist != null ? artist.name : null;
        builder2.displayTitle = str2;
        builder2.mediaType = 1;
        builder2.isBrowsable = Boolean.FALSE;
        builder2.isPlayable = Boolean.TRUE;
        Bundle bundle = new Bundle();
        if (str3 != null) {
            bundle.putString("artwork_uri", str3);
        }
        if (mediaMetadataWithResolvedArtistNameAliases.explicit) {
            bundle.putLong("android.media.IS_EXPLICIT", 1L);
        }
        builder2.extras = bundle;
        builder.mediaMetadata = new androidx.media3.common.MediaMetadata(builder2);
        return builder.build();
    }

    public static IntRange until(int i, int i2) {
        if (i2 > Integer.MIN_VALUE) {
            return new IntRange(i, i2 - 1, 1);
        }
        IntRange intRange = IntRange.EMPTY;
        return IntRange.EMPTY;
    }

    public static final boolean usesChunkedMediaRanges(String str) {
        str.getClass();
        return str.equals("ANDROID_VR") || str.equals("TVHTML5_SIMPLY");
    }

    public static final void uuidThrowUnexpectedCharacterException(int i, String str, String str2) {
        str.getClass();
        throw new IllegalArgumentException("Expected " + str2 + " at index " + i + ", but was '" + str.charAt(i) + '\'');
    }

    public static final MediaMetadata withResolvedArtistNameAliases(MediaMetadata mediaMetadata) {
        mediaMetadata.getClass();
        List<MediaMetadata.Artist> list = mediaMetadata.artists;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        for (MediaMetadata.Artist artist : list) {
            ArtistNameAliases artistNameAliases = ArtistNameAliases.INSTANCE;
            arrayList.add(new MediaMetadata.Artist(artist.id, ArtistNameAliases.resolve(artist.id, artist.name)));
        }
        return arrayList.equals(list) ? mediaMetadata : MediaMetadata.copy$default(mediaMetadata, arrayList, 0, null, 131067);
    }

    public static int coerceIn(int i, int i2, int i3) {
        if (i2 <= i3) {
            if (i < i2) {
                return i2;
            }
            return i > i3 ? i3 : i;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i3 + " is less than minimum " + i2 + '.');
    }

    public static long coerceIn(long j, long j2, long j3) {
        if (j2 <= j3) {
            if (j < j2) {
                return j2;
            }
            return j > j3 ? j3 : j;
        }
        StringBuilder sbM = Fragment$5$$ExternalSyntheticOutline0.m(j3, "Cannot coerce value to an empty range: maximum ", " is less than minimum ");
        sbM.append(j2);
        sbM.append('.');
        throw new IllegalArgumentException(sbM.toString());
    }

    public static float coerceIn(float f, float f2, float f3) {
        if (f2 <= f3) {
            if (f < f2) {
                return f2;
            }
            return f > f3 ? f3 : f;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + f3 + " is less than minimum " + f2 + '.');
    }

    public static double coerceIn(double d, double d2, double d3) {
        if (d2 <= d3) {
            if (d < d2) {
                return d2;
            }
            return d > d3 ? d3 : d;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + d3 + " is less than minimum " + d2 + '.');
    }

    public static final MediaItem toMediaItem(SongItem songItem) {
        songItem.getClass();
        return toMediaItem(HexFormatKt.toMediaMetadata(songItem));
    }

    public static final MediaItem toMediaItem(Song song) {
        song.getClass();
        return toMediaItem(HexFormatKt.toMediaMetadata(song));
    }
}
