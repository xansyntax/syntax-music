package dagger.hilt;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.RulerKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.navigation.NavGraphNavigator$$ExternalSyntheticLambda0;
import androidx.palette.graphics.ColorCutQuantizer;
import com.google.common.base.Splitter;
import com.materialkolor.hct.Hct;
import com.materialkolor.score.Score$ScoredHCT;
import com.metrolist.innertubex.InnerTubeLogEvent;
import com.metrolist.innertubex.InnerTubeLogLevel;
import com.metrolist.innertubex.extraction.PlayabilityFailure;
import com.metrolist.innertubex.extraction.StreamResolveException;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.db.entities.SongEntity;
import com.metrolist.music.discord.DiscordActivity;
import com.metrolist.music.discord.DiscordTemplateRenderer;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.models.PersistQueue;
import com.metrolist.music.models.QueueData;
import com.metrolist.music.models.QueueType;
import com.metrolist.music.playback.queues.ListQueue;
import com.metrolist.music.playback.queues.LocalAlbumRadio;
import com.metrolist.music.playback.queues.Queue;
import com.metrolist.music.playback.queues.YouTubeAlbumRadio;
import com.metrolist.music.playback.queues.YouTubeQueue;
import com.valentinilk.shimmer.ShimmerModifierKt$shimmer$1$1;
import dagger.hilt.EntryPoints;
import dagger.hilt.internal.GeneratedComponent;
import dagger.hilt.internal.GeneratedComponentManager;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Future;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.collections.EmptyMap;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.sequences.SequenceBuilderIterator;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlin.uuid.UuidKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ConflatedBufferedChannel;
import kotlinx.io.Buffer;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.AbstractPolymorphicSerializer;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.internal.CharArrayPoolBatchSize;
import kotlinx.serialization.json.internal.ReaderJsonLexer;
import kotlinx.serialization.json.internal.StreamingJsonDecoder;
import kotlinx.serialization.json.internal.WriteMode;
import kotlinx.serialization.json.internal.WriteModeKt;
import okhttp3.ConnectionPool;
import okhttp3.Headers;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.Okio__OkioKt;
import sh.calvin.reorderable.ReorderableCollectionItemScopeImpl;
import sh.calvin.reorderable.ReorderableLazyCollectionState$onDrag$targetItem$1;
import sh.calvin.reorderable.ReorderableLazyListKt$rememberReorderableLazyListState$1$1;
import sh.calvin.reorderable.ReorderableLazyListState;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class EntryPoints {
    public static final BufferedChannel Channel(int i, BufferOverflow bufferOverflow, NavGraphNavigator$$ExternalSyntheticLambda0 navGraphNavigator$$ExternalSyntheticLambda0) {
        BufferOverflow bufferOverflow2 = BufferOverflow.SUSPEND;
        if (i == -2) {
            if (bufferOverflow != bufferOverflow2) {
                return new ConflatedBufferedChannel(1, bufferOverflow, navGraphNavigator$$ExternalSyntheticLambda0);
            }
            Channel.Factory.getClass();
            return new BufferedChannel(Channel.Factory.CHANNEL_DEFAULT_CAPACITY, navGraphNavigator$$ExternalSyntheticLambda0);
        }
        if (i == -1) {
            if (bufferOverflow == bufferOverflow2) {
                return new ConflatedBufferedChannel(1, BufferOverflow.DROP_OLDEST, navGraphNavigator$$ExternalSyntheticLambda0);
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("CONFLATED capacity cannot be used with non-default onBufferOverflow");
            return null;
        }
        if (i == 0) {
            return bufferOverflow == bufferOverflow2 ? new BufferedChannel(0, navGraphNavigator$$ExternalSyntheticLambda0) : new ConflatedBufferedChannel(1, bufferOverflow, navGraphNavigator$$ExternalSyntheticLambda0);
        }
        if (i != Integer.MAX_VALUE) {
            return bufferOverflow == bufferOverflow2 ? new BufferedChannel(i, navGraphNavigator$$ExternalSyntheticLambda0) : new ConflatedBufferedChannel(i, bufferOverflow, navGraphNavigator$$ExternalSyntheticLambda0);
        }
        return new BufferedChannel(Integer.MAX_VALUE, navGraphNavigator$$ExternalSyntheticLambda0);
    }

    public static /* synthetic */ BufferedChannel Channel$default(int i, int i2, BufferOverflow bufferOverflow) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        if ((i2 & 2) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        return Channel(i, bufferOverflow, null);
    }

    public static final void ReorderableCollectionItem(final ReorderableLazyListState reorderableLazyListState, final Object obj, final Modifier modifier, final boolean z, boolean z2, final ComposableLambdaImpl composableLambdaImpl, Composer composer, final int i) {
        int i2;
        boolean z3;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(1129341741);
        if ((i & 6) == 0) {
            i2 = (gapComposer.changed(reorderableLazyListState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changedInstance(obj) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= gapComposer.changed(modifier) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= gapComposer.changed(z) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            z3 = z2;
            i2 |= gapComposer.changed(z3) ? 16384 : 8192;
        } else {
            z3 = z2;
        }
        if ((196608 & i) == 0) {
            i2 |= gapComposer.changedInstance(composableLambdaImpl) ? 131072 : 65536;
        }
        if ((74899 & i2) == 74898 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
        } else {
            gapComposer.startReplaceGroup(-1931603123);
            Object objRememberedValue = gapComposer.rememberedValue();
            Object obj2 = Composer.Companion.Empty;
            if (objRememberedValue == obj2) {
                objRememberedValue = Stack.mutableStateOf$default(new Offset(0L));
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            MutableState mutableState = (MutableState) objRememberedValue;
            gapComposer.end(false);
            gapComposer.startReplaceGroup(-1931600257);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            byte b = 1;
            if (objRememberedValue2 == obj2) {
                objRememberedValue2 = new ReorderableLazyCollectionState$onDrag$targetItem$1(b, mutableState);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            gapComposer.end(false);
            Modifier modifierOnGloballyPositioned = RulerKt.onGloballyPositioned(modifier, (Function1) objRememberedValue2);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
            int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierOnGloballyPositioned);
            ComposeUiNode.Companion.getClass();
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(LayoutNode.Constructor);
            } else {
                gapComposer.useNode();
            }
            Stack.m390setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            if (gapComposer.inserting || !Intrinsics.areEqual(gapComposer.rememberedValue(), Integer.valueOf(iHashCode))) {
                gapComposer.updateRememberedValue(Integer.valueOf(iHashCode));
                gapComposer.apply(Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
            }
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
            gapComposer.startReplaceGroup(872013070);
            int i3 = i2 & 14;
            boolean zChanged = (i3 == 4) | gapComposer.changed(obj);
            Object objRememberedValue3 = gapComposer.rememberedValue();
            if (zChanged || objRememberedValue3 == obj2) {
                objRememberedValue3 = new ReorderableCollectionItemScopeImpl(reorderableLazyListState, obj, new ReorderableLazyListKt$rememberReorderableLazyListState$1$1((byte) 2, mutableState));
                gapComposer.updateRememberedValue(objRememberedValue3);
            }
            gapComposer.end(false);
            composableLambdaImpl.invoke((ReorderableCollectionItemScopeImpl) objRememberedValue3, Boolean.valueOf(z3), gapComposer, Integer.valueOf((i2 >> 9) & 1008));
            gapComposer.end(true);
            HashSet hashSet = reorderableLazyListState.reorderableKeys;
            Boolean boolValueOf = Boolean.valueOf(z);
            gapComposer.startReplaceGroup(-1931586729);
            boolean zChangedInstance = ((i2 & 7168) == 2048) | (i3 == 4) | gapComposer.changedInstance(obj);
            Object objRememberedValue4 = gapComposer.rememberedValue();
            if (zChangedInstance || objRememberedValue4 == obj2) {
                objRememberedValue4 = new ShimmerModifierKt$shimmer$1$1(z, reorderableLazyListState, obj, (Continuation) null);
                gapComposer.updateRememberedValue(objRememberedValue4);
            }
            gapComposer.end(false);
            Stack.LaunchedEffect(hashSet, boolValueOf, (Function2) objRememberedValue4, gapComposer);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            final boolean z4 = z3;
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: sh.calvin.reorderable.ReorderableLazyCollectionKt$ReorderableCollectionItem$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj3, Object obj4) {
                    ((Number) obj4).intValue();
                    EntryPoints.ReorderableCollectionItem(reorderableLazyListState, obj, modifier, z, z4, composableLambdaImpl, (Composer) obj3, Stack.updateChangedFlags(i | 1));
                    return Unit.INSTANCE;
                }
            };
        }
    }

    /* JADX WARN: Code duplicated, block: B:58:0x00d6  */
    public static DiscordActivity build(Song song, String str, String str2, String str3, String str4, long j, Long l, boolean z, int i, String str5, String str6, String str7, boolean z2, String str8, String str9, boolean z3, String str10, String str11) {
        String strM;
        String str12;
        String str13;
        String str14;
        String str15;
        String strRender;
        String strRender2;
        String strRender3;
        String str16 = str5;
        SongEntity songEntity = song.song;
        str.getClass();
        str4.getClass();
        str6.getClass();
        str7.getClass();
        str8.getClass();
        str9.getClass();
        str10.getClass();
        str11.getClass();
        String strRender4 = "Listen on YouTube Music";
        if (z) {
            List list = DiscordTemplateRenderer.PLACEHOLDERS;
            String str17 = str6.length() == 0 ? "{artist.name}" : str6;
            String str18 = songEntity.id;
            String str19 = songEntity.id;
            String strRender5 = DiscordTemplateRenderer.render(str17, str4, str, str2, str18);
            String strRender6 = DiscordTemplateRenderer.render(str7.length() == 0 ? "{song.name}" : str7, str4, str, str2, str19);
            if (z2) {
                strRender4 = DiscordTemplateRenderer.render(str8.length() != 0 ? str8 : "Listen on YouTube Music", str4, str, str2, str19);
            } else {
                strRender4 = null;
            }
            if (z2) {
                strM = DiscordTemplateRenderer.render(str9.length() == 0 ? "https://music.youtube.com/watch?v={song.id}" : str9, str4, str, str2, str19);
            } else {
                strM = null;
            }
            if (z3) {
                strRender2 = DiscordTemplateRenderer.render(str10.length() != 0 ? str10 : "DAPZ.DEV", str4, str, str2, str19);
            } else {
                strRender2 = null;
            }
            if (z3) {
                strRender3 = DiscordTemplateRenderer.render(str11.length() != 0 ? str11 : "https://www.tiktok.com/@dappxml29", str4, str, str2, str19);
            } else {
                strRender3 = null;
            }
            str12 = strRender3;
            str13 = strRender2;
            str14 = strRender5;
            str15 = strRender6;
        } else {
            strM = Fragment$5$$ExternalSyntheticOutline0.m("https://music.youtube.com/watch?v=", songEntity.id);
            str12 = "https://www.tiktok.com/@dappxml29";
            str13 = "DAPZ.DEV";
            str14 = str;
            str15 = str4;
        }
        String str20 = strRender4;
        String str21 = strM;
        if (z && str16 != null && str16.length() != 0) {
            List list2 = DiscordTemplateRenderer.PLACEHOLDERS;
            strRender = DiscordTemplateRenderer.render(str16, str4, str, str2, songEntity.id);
        } else if (str16 == null) {
            strRender = str;
        } else {
            if (str16.length() <= 0) {
                str16 = null;
            }
            if (str16 == null) {
                strRender = str;
            } else {
                strRender = str16;
            }
        }
        String str22 = songEntity.thumbnailUrl;
        String str23 = strRender;
        DiscordActivity discordActivity = new DiscordActivity(i, str23, str14, str15, j, l, str22, str2, str3, str, str20, str21, str13, str12);
        Timber.Forest.tag("DiscordSvc");
        ConnectionPool.d(str23, Integer.valueOf(i), str14, str15, str20 != null ? StringsKt.take(30, str20) : null, str13 != null ? StringsKt.take(30, str13) : null);
        return discordActivity;
    }

    public static final StreamResolveException.Reason classifyPlayabilityFailures(ArrayList arrayList) {
        if (!arrayList.isEmpty()) {
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                PlayabilityFailure playabilityFailure = (PlayabilityFailure) obj;
                String str = playabilityFailure.status;
                if (str == null) {
                    str = "";
                }
                Locale locale = Locale.ROOT;
                String upperCase = str.toUpperCase(locale);
                upperCase.getClass();
                String str2 = playabilityFailure.reason;
                if (str2 == null) {
                    str2 = "";
                }
                String lowerCase = str2.toLowerCase(locale);
                lowerCase.getClass();
                if (!ArraysKt.toSet(new String[]{"AGE_CHECK_REQUIRED", "AGE_VERIFICATION_REQUIRED", "CONTENT_CHECK_REQUIRED"}).contains(upperCase)) {
                    List listListOf = CollectionsKt__IterablesKt.listOf((Object[]) new String[]{"confirm your age", "age-restricted", "age restricted", "age verification"});
                    if (!listListOf.isEmpty()) {
                        Iterator it = listListOf.iterator();
                        while (it.hasNext()) {
                            if (StringsKt.contains(lowerCase, (CharSequence) it.next(), false)) {
                            }
                        }
                    }
                }
                return StreamResolveException.Reason.AGE_RESTRICTED;
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        int size2 = arrayList.size();
        int i2 = 0;
        while (i2 < size2) {
            Object obj2 = arrayList.get(i2);
            i2++;
            PlayabilityFailure playabilityFailure2 = (PlayabilityFailure) obj2;
            String str3 = playabilityFailure2.status;
            if (str3 == null) {
                str3 = "";
            }
            Locale locale2 = Locale.ROOT;
            String upperCase2 = str3.toUpperCase(locale2);
            upperCase2.getClass();
            String str4 = playabilityFailure2.reason;
            if (str4 == null) {
                str4 = "";
            }
            String lowerCase2 = str4.toLowerCase(locale2);
            lowerCase2.getClass();
            if (!ArraysKt.toSet(new String[]{"UNPLAYABLE", "VIDEO_UNAVAILABLE", "LIVE_STREAM_OFFLINE"}).contains(upperCase2)) {
                List listListOf2 = CollectionsKt__IterablesKt.listOf((Object[]) new String[]{"video unavailable", "not available", "private video", "has been removed"});
                if (!listListOf2.isEmpty()) {
                    Iterator it2 = listListOf2.iterator();
                    while (it2.hasNext()) {
                        if (StringsKt.contains(lowerCase2, (CharSequence) it2.next(), false)) {
                        }
                    }
                }
            }
            return StreamResolveException.Reason.UNAVAILABLE;
        }
        return null;
    }

    public static final void commonAddLenient(Headers.Builder builder, String str, String str2) {
        str.getClass();
        str2.getClass();
        ArrayList arrayList = builder.namesAndValues;
        arrayList.add(str);
        arrayList.add(StringsKt.trim(str2).toString());
    }

    public static final Headers commonBuild(Headers.Builder builder) {
        builder.getClass();
        return new Headers((String[]) builder.namesAndValues.toArray(new String[0]));
    }

    public static final String commonName(Headers headers, int i) {
        headers.getClass();
        String str = (String) ArraysKt.getOrNull(i * 2, headers.namesAndValues);
        if (str != null) {
            return str;
        }
        throw new IndexOutOfBoundsException("name[" + i + ']');
    }

    public static final Headers.Builder commonNewBuilder(Headers headers) {
        headers.getClass();
        Headers.Builder builder = new Headers.Builder((byte) 0);
        String[] strArr = headers.namesAndValues;
        strArr.getClass();
        List listAsList = Arrays.asList(strArr);
        listAsList.getClass();
        builder.namesAndValues.addAll(listAsList);
        return builder;
    }

    public static final String commonValue(Headers headers, int i) {
        headers.getClass();
        String str = (String) ArraysKt.getOrNull((i * 2) + 1, headers.namesAndValues);
        if (str != null) {
            return str;
        }
        throw new IndexOutOfBoundsException("value[" + i + ']');
    }

    public static final long copyTo(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[8192];
        int i = inputStream.read(bArr);
        long j = 0;
        while (i >= 0) {
            outputStream.write(bArr, 0, i);
            j += (long) i;
            i = inputStream.read(bArr);
        }
        return j;
    }

    public static void d$default(PathKt$$ExternalSyntheticBUOutline0 pathKt$$ExternalSyntheticBUOutline0, String str, String str2, Map map, int i) throws IOException {
        if ((i & 8) != 0) {
            map = EmptyMap.INSTANCE;
        }
        pathKt$$ExternalSyntheticBUOutline0.getClass();
        pathKt$$ExternalSyntheticBUOutline0.log(new InnerTubeLogEvent(InnerTubeLogLevel.DEBUG, str, str2, map));
    }

    public static final Object decodeFromSource(Json json, DeserializationStrategy deserializationStrategy, Buffer buffer) {
        json.getClass();
        deserializationStrategy.getClass();
        buffer.getClass();
        ReaderJsonLexer ReaderJsonLexer = WriteModeKt.ReaderJsonLexer(json, new Splitter(buffer), CharArrayPoolBatchSize.INSTANCE.take(16384));
        try {
            Object objDecodeSerializableValue = new StreamingJsonDecoder(json, WriteMode.OBJ, ReaderJsonLexer, deserializationStrategy.getDescriptor(), null).decodeSerializableValue(deserializationStrategy);
            ReaderJsonLexer.expectEof();
            return objDecodeSerializableValue;
        } finally {
            ReaderJsonLexer.release();
        }
    }

    public static final SerializationStrategy findPolymorphicSerializer(AbstractPolymorphicSerializer abstractPolymorphicSerializer, Encoder encoder, Object obj) {
        obj.getClass();
        SerializationStrategy serializationStrategyFindPolymorphicSerializerOrNull = abstractPolymorphicSerializer.findPolymorphicSerializerOrNull(encoder, obj);
        if (serializationStrategyFindPolymorphicSerializerOrNull != null) {
            return serializationStrategyFindPolymorphicSerializerOrNull;
        }
        ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(obj.getClass());
        KClass baseClass = abstractPolymorphicSerializer.getBaseClass();
        baseClass.getClass();
        String simpleName = orCreateKotlinClass.getSimpleName();
        if (simpleName == null) {
            simpleName = String.valueOf(orCreateKotlinClass);
        }
        EnumsKt.throwSubtypeNotRegistered(simpleName, baseClass);
        throw null;
    }

    public static Object get(Object obj, Class cls) {
        if (obj instanceof GeneratedComponent) {
            return cls.cast(obj);
        }
        if (obj instanceof GeneratedComponentManager) {
            return get(((GeneratedComponentManager) obj).generatedComponent(), cls);
        }
        throw new IllegalStateException("Given component holder " + obj.getClass() + " does not implement " + GeneratedComponent.class + " or " + GeneratedComponentManager.class);
    }

    public static Object getUninterruptibly(Future future) {
        Object obj;
        boolean z = false;
        while (true) {
            try {
                obj = future.get();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return obj;
    }

    public static final void headersCheckName(String str) {
        str.getClass();
        if (str.length() <= 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("name is empty");
            return;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if ('!' > cCharAt || cCharAt >= 127) {
                StringBuilder sb = new StringBuilder("Unexpected char 0x");
                CharsKt.checkRadix(16);
                String string = Integer.toString(cCharAt, 16);
                string.getClass();
                if (string.length() < 2) {
                    string = "0".concat(string);
                }
                sb.append(string);
                sb.append(" at ");
                sb.append(i);
                sb.append(" in header name: ");
                sb.append(str);
                throw new IllegalArgumentException(sb.toString().toString());
            }
        }
    }

    public static final void headersCheckValue(String str, String str2) {
        str.getClass();
        str2.getClass();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt != '\t' && (' ' > cCharAt || cCharAt >= 127)) {
                StringBuilder sb = new StringBuilder("Unexpected char 0x");
                CharsKt.checkRadix(16);
                String string = Integer.toString(cCharAt, 16);
                string.getClass();
                if (string.length() < 2) {
                    string = "0".concat(string);
                }
                sb.append(string);
                sb.append(" at ");
                sb.append(i);
                sb.append(" in ");
                sb.append(str2);
                sb.append(" value");
                sb.append(_UtilCommonKt.isSensitiveHeader(str2) ? "" : ": ".concat(str));
                throw new IllegalArgumentException(sb.toString().toString());
            }
        }
    }

    public static void i$default(PathKt$$ExternalSyntheticBUOutline0 pathKt$$ExternalSyntheticBUOutline0, String str, String str2, Map map) throws IOException {
        pathKt$$ExternalSyntheticBUOutline0.log(new InnerTubeLogEvent(InnerTubeLogLevel.INFO, str, str2, map));
    }

    public static SequenceBuilderIterator iterator(Function2 function2) {
        SequenceBuilderIterator sequenceBuilderIterator = new SequenceBuilderIterator();
        sequenceBuilderIterator.nextStep = Okio__OkioKt.createCoroutineUnintercepted(sequenceBuilderIterator, sequenceBuilderIterator, function2);
        return sequenceBuilderIterator;
    }

    public static final byte[] readBytes(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.max(8192, inputStream.available()));
        copyTo(inputStream, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArray.getClass();
        return byteArray;
    }

    public static ArrayList score(Map map, int i, Integer num, boolean z) {
        Object obj;
        map.getClass();
        ArrayList arrayList = new ArrayList();
        int[] iArr = new int[360];
        double d = 0.0d;
        for (Map.Entry entry : map.entrySet()) {
            int iIntValue = ((Number) entry.getKey()).intValue();
            int iIntValue2 = ((Number) entry.getValue()).intValue();
            Hct hct = new Hct(iIntValue);
            arrayList.add(hct);
            int iFloor = (int) Math.floor(hct.hue);
            iArr[iFloor] = iArr[iFloor] + iIntValue2;
            d += (double) iIntValue2;
        }
        double[] dArr = new double[360];
        int i2 = 0;
        for (int i3 = 0; i3 < 360; i3++) {
            double d2 = ((double) iArr[i3]) / d;
            int i4 = i3 + 16;
            for (int i5 = i3 - 14; i5 < i4; i5++) {
                int i6 = i5 % 360;
                if (i6 < 0) {
                    i6 += 360;
                }
                dArr[i6] = dArr[i6] + d2;
            }
        }
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i7 = 0;
        while (i7 < size) {
            Object obj2 = arrayList.get(i7);
            i7++;
            Hct hct2 = (Hct) obj2;
            double d3 = hct2.hue;
            double d4 = hct2.chroma;
            int iRint = ((int) Math.rint(d3)) % 360;
            if (iRint < 0) {
                iRint += 360;
            }
            double d5 = dArr[iRint];
            if (!z || (d4 >= 5.0d && d5 > 0.01d)) {
                arrayList2.add(new Score$ScoredHCT(hct2, ((d4 - 48.0d) * (d4 < 48.0d ? 0.1d : 0.3d)) + (d5 * 100.0d * 0.7d)));
            }
        }
        CollectionsKt__MutableCollectionsJVMKt.sortWith(arrayList2, new ColorCutQuantizer.AnonymousClass1((byte) 6));
        ArrayList arrayList3 = new ArrayList();
        for (int i8 = 90; 14 < i8; i8--) {
            arrayList3.clear();
            int size2 = arrayList2.size();
            int i9 = 0;
            while (i9 < size2) {
                Object obj3 = arrayList2.get(i9);
                i9++;
                Hct hct3 = ((Score$ScoredHCT) obj3).hct;
                int size3 = arrayList3.size();
                int i10 = 0;
                do {
                    if (i10 >= size3) {
                        arrayList3.add(hct3);
                        break;
                    }
                    obj = arrayList3.get(i10);
                    i10++;
                } while (180.0d - Math.abs(Math.abs(hct3.hue - ((Hct) obj).hue) - 180.0d) >= i8);
                if (arrayList3.size() >= i) {
                    break;
                }
            }
            if (arrayList3.size() >= i) {
                break;
            }
        }
        ArrayList arrayList4 = new ArrayList();
        if (arrayList3.isEmpty() && num != null) {
            arrayList4.add(num);
        }
        int size4 = arrayList3.size();
        while (i2 < size4) {
            Object obj4 = arrayList3.get(i2);
            i2++;
            arrayList4.add(Integer.valueOf(((Hct) obj4).argb));
        }
        return arrayList4;
    }

    public static final PersistQueue toPersistQueue(Queue queue, String str, ArrayList arrayList, int i, long j) {
        queue.getClass();
        if (queue instanceof ListQueue) {
            return new PersistQueue(str, arrayList, i, j, QueueType.LIST.INSTANCE, null, 32, null);
        }
        if (queue instanceof YouTubeQueue) {
            return new PersistQueue(str, arrayList, i, j, QueueType.YOUTUBE.INSTANCE, new QueueData.YouTubeData());
        }
        if (queue instanceof YouTubeAlbumRadio) {
            return new PersistQueue(str, arrayList, i, j, QueueType.YOUTUBE_ALBUM_RADIO.INSTANCE, new QueueData.YouTubeAlbumRadioData());
        }
        if (queue instanceof LocalAlbumRadio) {
            return new PersistQueue(str, arrayList, i, j, QueueType.LOCAL_ALBUM_RADIO.INSTANCE, new QueueData.LocalAlbumRadioData());
        }
        return new PersistQueue(str, arrayList, i, j, QueueType.LIST.INSTANCE, null, 32, null);
    }

    public static final ListQueue toQueue(PersistQueue persistQueue) {
        QueueType queueType = persistQueue.getQueueType();
        if (queueType != null) {
            if (queueType instanceof QueueType.LIST) {
                String title = persistQueue.getTitle();
                List<MediaMetadata> items = persistQueue.getItems();
                ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(items, 10));
                Iterator<T> it = items.iterator();
                while (it.hasNext()) {
                    arrayList.add(UuidKt.toMediaItem((MediaMetadata) it.next()));
                }
                return new ListQueue(title, arrayList, persistQueue.getMediaItemIndex(), persistQueue.getPosition());
            }
            if (queueType instanceof QueueType.YOUTUBE) {
                String title2 = persistQueue.getTitle();
                List<MediaMetadata> items2 = persistQueue.getItems();
                ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(items2, 10));
                Iterator<T> it2 = items2.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(UuidKt.toMediaItem((MediaMetadata) it2.next()));
                }
                return new ListQueue(title2, arrayList2, persistQueue.getMediaItemIndex(), persistQueue.getPosition());
            }
            if (queueType instanceof QueueType.YOUTUBE_ALBUM_RADIO) {
                String title3 = persistQueue.getTitle();
                List<MediaMetadata> items3 = persistQueue.getItems();
                ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(items3, 10));
                Iterator<T> it3 = items3.iterator();
                while (it3.hasNext()) {
                    arrayList3.add(UuidKt.toMediaItem((MediaMetadata) it3.next()));
                }
                return new ListQueue(title3, arrayList3, persistQueue.getMediaItemIndex(), persistQueue.getPosition());
            }
            if (queueType instanceof QueueType.LOCAL_ALBUM_RADIO) {
                String title4 = persistQueue.getTitle();
                List<MediaMetadata> items4 = persistQueue.getItems();
                ArrayList arrayList4 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(items4, 10));
                Iterator<T> it4 = items4.iterator();
                while (it4.hasNext()) {
                    arrayList4.add(UuidKt.toMediaItem((MediaMetadata) it4.next()));
                }
                return new ListQueue(title4, arrayList4, persistQueue.getMediaItemIndex(), persistQueue.getPosition());
            }
        }
        PathKt$$ExternalSyntheticBUOutline0.m$1();
        return null;
    }

    public static void w$default(PathKt$$ExternalSyntheticBUOutline0 pathKt$$ExternalSyntheticBUOutline0, String str, String str2, Map map, int i) throws IOException {
        if ((i & 8) != 0) {
            map = EmptyMap.INSTANCE;
        }
        pathKt$$ExternalSyntheticBUOutline0.getClass();
        pathKt$$ExternalSyntheticBUOutline0.log(new InnerTubeLogEvent(InnerTubeLogLevel.WARN, str, str2, map));
    }

    public abstract List clean(String str, List list);

    public static final DeserializationStrategy findPolymorphicSerializer(AbstractPolymorphicSerializer abstractPolymorphicSerializer, CompositeDecoder compositeDecoder, String str) {
        DeserializationStrategy deserializationStrategyFindPolymorphicSerializerOrNull = abstractPolymorphicSerializer.findPolymorphicSerializerOrNull(compositeDecoder, str);
        if (deserializationStrategyFindPolymorphicSerializerOrNull != null) {
            return deserializationStrategyFindPolymorphicSerializerOrNull;
        }
        EnumsKt.throwSubtypeNotRegistered(str, abstractPolymorphicSerializer.getBaseClass());
        throw null;
    }
}
