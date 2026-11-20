package coil3;

import android.view.View;
import androidx.activity.OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0;
import androidx.compose.foundation.gestures.PressGestureScopeImpl;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1;
import androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1;
import androidx.compose.foundation.interaction.DragInteraction$Cancel;
import androidx.compose.foundation.interaction.DragInteraction$Start;
import androidx.compose.foundation.interaction.DragInteraction$Stop;
import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.HoverInteraction$Enter;
import androidx.compose.foundation.interaction.HoverInteraction$Exit;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.foundation.relocation.BringIntoViewRequesterImpl;
import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.TextDelegate;
import androidx.compose.foundation.text.TextFieldDelegateKt;
import androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.foundation.text.handwriting.StylusHandwriting_androidKt;
import androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter;
import androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter$startInput$2$1$request$1;
import androidx.compose.foundation.text.input.internal.LegacyAdaptingPlatformTextInputModifierNode;
import androidx.compose.foundation.text.input.internal.LegacyPlatformTextInputServiceAdapter_androidKt;
import androidx.compose.foundation.text.input.internal.LegacyPlatformTextInputServiceAdapter_androidKt$inputMethodManagerFactory$1;
import androidx.compose.foundation.text.input.internal.LegacyTextInputMethodRequest;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.material3.TooltipKt$$ExternalSyntheticLambda5;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$$ExternalSyntheticLambda0;
import androidx.compose.runtime.CompositionImpl;
import androidx.compose.runtime.MonotonicFrameClock;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Recomposer;
import androidx.compose.runtime.Recomposer$runRecomposeAndApplyChanges$2;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedSet.PersistentOrderedSet;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.platform.AndroidPlatformTextInputSession;
import androidx.compose.ui.platform.DelegatingSoftwareKeyboardController;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.platform.WeakCache;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextInputService;
import androidx.compose.ui.unit.Density;
import androidx.datastore.core.SimpleActor$offer$2;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.compose.ComposeNavigator;
import androidx.room.TriggerBasedInvalidationTracker$createFlow$1$2;
import coil3.intercept.RealInterceptorChain;
import coil3.network.HttpException;
import coil3.request.ImageRequest;
import coil3.size.Size;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.innertube.YouTube;
import com.metrolist.innertube.YouTube$$ExternalSyntheticLambda2;
import com.metrolist.innertubex.InnerTube;
import com.metrolist.innertubex.models.YouTubeClient;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda29;
import com.metrolist.music.constants.AddToPlaylistPosition;
import com.metrolist.music.db.DatabaseDao$$ExternalSyntheticLambda0;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.LyricsEntity;
import com.metrolist.music.db.entities.Playlist;
import com.metrolist.music.db.entities.PlaylistSongMap;
import com.metrolist.music.db.entities.PodcastEntity;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda4;
import com.metrolist.music.ui.menu.SongMenuKt$SongMenu$14$1$5$1$8$4$1$1$$ExternalSyntheticLambda0;
import com.metrolist.music.utils.DataStoreKt$get$2;
import com.metrolist.music.utils.ReleaseInfo;
import com.metrolist.music.utils.SyncUtils;
import com.metrolist.music.utils.Updater;
import com.metrolist.music.viewmodels.BackupPreviewInfo;
import com.metrolist.music.viewmodels.BackupRestoreViewModel;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.client.HttpClient;
import io.ktor.client.HttpClient$$ExternalSyntheticLambda1;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.request.UtilsKt;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.ContentType;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpMethod;
import io.ktor.http.content.NullBody;
import io.ktor.http.content.OutgoingContent;
import io.ktor.sse.ServerSentEventKt;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Function;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeReference;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt__IndentKt;
import kotlin.uuid.UuidKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CompletableDeferredImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt__LimitKt$take$2$1;
import kotlinx.coroutines.flow.SafeFlow;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import kotlinx.coroutines.sync.MutexImpl;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonObject;
import okhttp3.ConnectionPool;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.RequestBody$Companion$toRequestBody$3;
import okhttp3.ResponseBody;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okhttp3.internal.connection.RealCall;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class RealImageLoader$execute$result$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ Object $cachedPlaceholder;
    public final /* synthetic */ Object $eventListener;
    public final /* synthetic */ byte $r8$classId;
    public Object $request;
    public Object $size;
    public boolean label;
    public Object this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RealImageLoader$execute$result$1(boolean z, PlayerConnection playerConnection, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, State state, Continuation continuation) {
        super(2, continuation);
        this.$r8$classId = (byte) 13;
        this.label = z;
        this.$request = playerConnection;
        this.this$0 = mutableState;
        this.$size = mutableState2;
        this.$eventListener = mutableState3;
        this.$cachedPlaceholder = state;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0038  */
    private final Object invokeSuspend$com$metrolist$music$ui$screens$settings$BackupAndRestoreKt$BackupAndRestore$restoreLauncher$1$1$1(Object obj) {
        Object failure;
        String strString;
        JsonElement jsonElement;
        JsonElement jsonElement2;
        JsonElement jsonElement3;
        JsonElement jsonElement4;
        JsonElement jsonElement5;
        JsonElement jsonElement6;
        JsonElement jsonElement7;
        JsonElement jsonElement8;
        JsonElement jsonElement9;
        JsonElement jsonElement10;
        JsonElement jsonElement11;
        JsonElement jsonElement12;
        JsonElement jsonElement13;
        JsonElement jsonElement14;
        JsonElement jsonElement15;
        boolean z = this.label;
        byte b = 1;
        if (!z) {
            ResultKt.throwOnFailure(obj);
            BackupRestoreViewModel backupRestoreViewModel = (BackupRestoreViewModel) this.$request;
            String str = ((BackupPreviewInfo) this.this$0).cookie;
            this.label = true;
            backupRestoreViewModel.getClass();
            try {
                String str2 = (String) StringsKt__IndentKt.parseCookieString(str).get("SAPISID");
                if (str2 == null) {
                    failure = null;
                } else {
                    long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
                    String str3 = jCurrentTimeMillis + ServerSentEventKt.SPACE + str2 + " https://music.youtube.com";
                    MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
                    byte[] bytes = str3.getBytes(Charsets.UTF_8);
                    bytes.getClass();
                    byte[] bArrDigest = messageDigest.digest(bytes);
                    bArrDigest.getClass();
                    String str4 = "SAPISIDHASH " + jCurrentTimeMillis + "_" + ArraysKt.joinToString$default(bArrDigest, "", new YouTube$$ExternalSyntheticLambda2((byte) 8), 30);
                    OkHttpClient okHttpClient = new OkHttpClient();
                    RequestBody.Companion companion = RequestBody.Companion;
                    Regex regex = MediaType.TYPE_SUBTYPE;
                    MediaType mediaType = CollectionsKt__IterablesKt.get("application/json");
                    companion.getClass();
                    RequestBody$Companion$toRequestBody$3 requestBody$Companion$toRequestBody$3Create = RequestBody.Companion.create("{\"context\":{\"client\":{\"clientName\":\"WEB_REMIX\",\"clientVersion\":\"1.20240101.01.00\"}}}", mediaType);
                    Request.Builder builder = new Request.Builder();
                    builder.url("https://music.youtube.com/youtubei/v1/account/account_menu?prettyPrint=false");
                    builder.method("POST", requestBody$Companion$toRequestBody$3Create);
                    builder.header(HttpHeaders.Cookie, str);
                    builder.header(HttpHeaders.Authorization, str4);
                    builder.header(HttpHeaders.Origin, "https://music.youtube.com");
                    builder.header(HttpHeaders.Referrer, "https://music.youtube.com/");
                    builder.header("X-Origin", "https://music.youtube.com");
                    builder.header(HttpHeaders.UserAgent, "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36");
                    ResponseBody responseBody = new RealCall(okHttpClient, new Request(builder), false).execute().body;
                    if (responseBody == null || (strString = responseBody.string()) == null) {
                        failure = null;
                    } else {
                        JsonElement jsonElement16 = (JsonElement) JsonElementKt.getJsonObject(UuidKt.Json$default(new HttpClient$$ExternalSyntheticLambda1(b)).parseToJsonElement(strString)).get("actions");
                        JsonObject jsonObject = (jsonElement16 == null || (jsonElement10 = (JsonElement) CollectionsKt.getOrNull(0, JsonElementKt.getJsonArray(jsonElement16))) == null || (jsonElement11 = (JsonElement) JsonElementKt.getJsonObject(jsonElement10).get("openPopupAction")) == null || (jsonElement12 = (JsonElement) JsonElementKt.getJsonObject(jsonElement11).get("popup")) == null || (jsonElement13 = (JsonElement) JsonElementKt.getJsonObject(jsonElement12).get("multiPageMenuRenderer")) == null || (jsonElement14 = (JsonElement) JsonElementKt.getJsonObject(jsonElement13).get("header")) == null || (jsonElement15 = (JsonElement) JsonElementKt.getJsonObject(jsonElement14).get("activeAccountHeaderRenderer")) == null) ? null : JsonElementKt.getJsonObject(jsonElement15);
                        if (jsonObject != null) {
                            JsonElement jsonElement17 = (JsonElement) jsonObject.get("accountName");
                            String content = (jsonElement17 == null || (jsonElement7 = (JsonElement) JsonElementKt.getJsonObject(jsonElement17).get("runs")) == null || (jsonElement8 = (JsonElement) CollectionsKt.getOrNull(0, JsonElementKt.getJsonArray(jsonElement7))) == null || (jsonElement9 = (JsonElement) JsonElementKt.getJsonObject(jsonElement8).get(ContentType.Text.TYPE)) == null) ? null : JsonElementKt.getJsonPrimitive(jsonElement9).getContent();
                            JsonElement jsonElement18 = (JsonElement) jsonObject.get("email");
                            String content2 = (jsonElement18 == null || (jsonElement4 = (JsonElement) JsonElementKt.getJsonObject(jsonElement18).get("runs")) == null || (jsonElement5 = (JsonElement) CollectionsKt.getOrNull(0, JsonElementKt.getJsonArray(jsonElement4))) == null || (jsonElement6 = (JsonElement) JsonElementKt.getJsonObject(jsonElement5).get(ContentType.Text.TYPE)) == null) ? null : JsonElementKt.getJsonPrimitive(jsonElement6).getContent();
                            JsonElement jsonElement19 = (JsonElement) jsonObject.get("accountPhoto");
                            String content3 = (jsonElement19 == null || (jsonElement = (JsonElement) JsonElementKt.getJsonObject(jsonElement19).get("thumbnails")) == null || (jsonElement2 = (JsonElement) CollectionsKt.getOrNull(0, JsonElementKt.getJsonArray(jsonElement))) == null || (jsonElement3 = (JsonElement) JsonElementKt.getJsonObject(jsonElement2).get("url")) == null) ? null : JsonElementKt.getJsonPrimitive(jsonElement3).getContent();
                            if (content != null) {
                                failure = new BackupPreviewInfo(content, content2, content3, str, true);
                            } else {
                                failure = null;
                            }
                        } else {
                            failure = null;
                        }
                    }
                }
            } catch (Throwable th) {
                failure = new Result.Failure(th);
            }
            if (Result.m1866exceptionOrNullimpl(failure) == null) {
                obj = failure;
            } else {
                Timber.Forest.tag("BACKUP_PREVIEW");
                ConnectionPool.e$1(new Object[0]);
                obj = null;
            }
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (obj == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (!z) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
        }
        BackupPreviewInfo backupPreviewInfo = (BackupPreviewInfo) obj;
        if (backupPreviewInfo != null) {
            ((MutableState) this.$size).setValue(backupPreviewInfo);
        } else {
            ((MutableState) this.$eventListener).setValue(Boolean.TRUE);
        }
        ((MutableState) this.$cachedPlaceholder).setValue(Boolean.FALSE);
        return Unit.INSTANCE;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        Object obj2 = this.$cachedPlaceholder;
        Object obj3 = this.$eventListener;
        switch (b) {
            case 0:
                return new RealImageLoader$execute$result$1(this.$request, this.this$0, this.$size, obj3, obj2, continuation, (byte) 0);
            case 1:
                RealImageLoader$execute$result$1 realImageLoader$execute$result$1 = new RealImageLoader$execute$result$1((PointerInputScope) this.this$0, (TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1.AnonymousClass1) this.$size, (TooltipKt$$ExternalSyntheticLambda5) obj3, (PressGestureScopeImpl) obj2, continuation, (byte) 1);
                realImageLoader$execute$result$1.$request = obj;
                return realImageLoader$execute$result$1;
            case 2:
                RealImageLoader$execute$result$1 realImageLoader$execute$result$2 = new RealImageLoader$execute$result$1((PointerInputScope) this.this$0, (Function1) this.$size, (Function3) obj3, (Function1) obj2, continuation, (byte) 2);
                realImageLoader$execute$result$2.$request = obj;
                return realImageLoader$execute$result$2;
            case 3:
                return new RealImageLoader$execute$result$1(this.$request, this.this$0, this.$size, obj3, obj2, continuation, (byte) 3);
            case 4:
                return new RealImageLoader$execute$result$1(this.$request, this.this$0, this.$size, obj3, obj2, continuation, (byte) 4);
            case 5:
                RealImageLoader$execute$result$1 realImageLoader$execute$result$3 = new RealImageLoader$execute$result$1((AndroidPlatformTextInputSession) this.this$0, (Function1) this.$size, (AndroidLegacyPlatformTextInputServiceAdapter) obj3, (LegacyAdaptingPlatformTextInputModifierNode) obj2, continuation, (byte) 5);
                realImageLoader$execute$result$3.$request = obj;
                return realImageLoader$execute$result$3;
            case 6:
                return new RealImageLoader$execute$result$1(this.$request, this.this$0, this.$size, obj3, obj2, continuation, (byte) 6);
            case 7:
                RealImageLoader$execute$result$1 realImageLoader$execute$result$4 = new RealImageLoader$execute$result$1((Recomposer) this.$size, (Recomposer$runRecomposeAndApplyChanges$2) obj3, (MonotonicFrameClock) obj2, continuation);
                realImageLoader$execute$result$4.this$0 = obj;
                return realImageLoader$execute$result$4;
            case 8:
                RealImageLoader$execute$result$1 realImageLoader$execute$result$5 = new RealImageLoader$execute$result$1((ComposeNavigator) this.this$0, (MutableState) this.$size, (ParcelableSnapshotMutableFloatState) obj3, (MutableState) obj2, continuation, (byte) 8);
                realImageLoader$execute$result$5.$request = obj;
                return realImageLoader$execute$result$5;
            case 9:
                return new RealImageLoader$execute$result$1((InnerTube) obj3, (CompletableDeferredImpl) obj2, continuation);
            case 10:
                RealImageLoader$execute$result$1 realImageLoader$execute$result$6 = new RealImageLoader$execute$result$1((InnerTube) this.this$0, (YouTubeClient) this.$size, (String) obj3, (byte[]) obj2, continuation, (byte) 10);
                realImageLoader$execute$result$6.$request = obj;
                return realImageLoader$execute$result$6;
            case 11:
                return new RealImageLoader$execute$result$1(this.$request, this.this$0, this.$size, obj3, obj2, continuation, (byte) 11);
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                return new RealImageLoader$execute$result$1((String) this.this$0, (MusicDatabase) this.$size, (MutableState) obj3, (Song) obj2, continuation, (byte) 12);
            case 13:
                return new RealImageLoader$execute$result$1(this.label, (PlayerConnection) this.$request, (MutableState) this.this$0, (MutableState) this.$size, (MutableState) obj3, (State) obj2, continuation);
            case 14:
                return new RealImageLoader$execute$result$1(this.$request, this.this$0, this.$size, obj3, obj2, continuation, (byte) 14);
            case 15:
                return new RealImageLoader$execute$result$1(this.$request, this.this$0, this.$size, obj3, obj2, continuation, (byte) 15);
            case 16:
                return new RealImageLoader$execute$result$1(this.$request, this.this$0, this.$size, obj3, obj2, continuation, (byte) 16);
            case 17:
                return new RealImageLoader$execute$result$1(this.$request, this.this$0, this.$size, obj3, obj2, continuation, (byte) 17);
            default:
                return new RealImageLoader$execute$result$1(this.$request, this.this$0, this.$size, obj3, obj2, continuation, (byte) 18);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) throws Throwable {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                return ((RealImageLoader$execute$result$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 1:
                return ((RealImageLoader$execute$result$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 2:
                return ((RealImageLoader$execute$result$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 3:
                return ((RealImageLoader$execute$result$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 4:
                return ((RealImageLoader$execute$result$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 5:
                ((RealImageLoader$execute$result$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                return CoroutineSingletons.COROUTINE_SUSPENDED;
            case 6:
                return ((RealImageLoader$execute$result$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 7:
                return ((RealImageLoader$execute$result$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 8:
                return ((RealImageLoader$execute$result$1) create((Flow) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 9:
                return ((RealImageLoader$execute$result$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 10:
                return ((RealImageLoader$execute$result$1) create((InnerTube.SessionSnapshot) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 11:
                return ((RealImageLoader$execute$result$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                return ((RealImageLoader$execute$result$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 13:
                ((RealImageLoader$execute$result$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                return unit;
            case 14:
                return ((RealImageLoader$execute$result$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 15:
                return ((RealImageLoader$execute$result$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 16:
                return ((RealImageLoader$execute$result$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 17:
                return ((RealImageLoader$execute$result$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            default:
                return ((RealImageLoader$execute$result$1) create((MusicDatabase) obj, (Continuation) obj2)).invokeSuspend(unit);
        }
    }

    /* JADX WARN: Code duplicated, block: B:249:0x05c6 A[Catch: all -> 0x05ec, TryCatch #5 {all -> 0x05ec, blocks: (B:243:0x05b3, B:244:0x05b9, B:246:0x05be, B:247:0x05bf, B:249:0x05c6, B:251:0x05d4, B:253:0x05da, B:256:0x05e0, B:257:0x05e3, B:258:0x05e6, B:262:0x05ee, B:287:0x064c, B:288:0x064d, B:245:0x05ba), top: B:443:0x05b3, inners: #4 }] */
    /* JADX WARN: Code duplicated, block: B:251:0x05d4 A[Catch: all -> 0x05ec, TryCatch #5 {all -> 0x05ec, blocks: (B:243:0x05b3, B:244:0x05b9, B:246:0x05be, B:247:0x05bf, B:249:0x05c6, B:251:0x05d4, B:253:0x05da, B:256:0x05e0, B:257:0x05e3, B:258:0x05e6, B:262:0x05ee, B:287:0x064c, B:288:0x064d, B:245:0x05ba), top: B:443:0x05b3, inners: #4 }] */
    /* JADX WARN: Code duplicated, block: B:253:0x05da A[Catch: all -> 0x05ec, TryCatch #5 {all -> 0x05ec, blocks: (B:243:0x05b3, B:244:0x05b9, B:246:0x05be, B:247:0x05bf, B:249:0x05c6, B:251:0x05d4, B:253:0x05da, B:256:0x05e0, B:257:0x05e3, B:258:0x05e6, B:262:0x05ee, B:287:0x064c, B:288:0x064d, B:245:0x05ba), top: B:443:0x05b3, inners: #4 }] */
    /* JADX WARN: Code duplicated, block: B:254:0x05dd  */
    /* JADX WARN: Code duplicated, block: B:256:0x05e0 A[Catch: all -> 0x05ec, TryCatch #5 {all -> 0x05ec, blocks: (B:243:0x05b3, B:244:0x05b9, B:246:0x05be, B:247:0x05bf, B:249:0x05c6, B:251:0x05d4, B:253:0x05da, B:256:0x05e0, B:257:0x05e3, B:258:0x05e6, B:262:0x05ee, B:287:0x064c, B:288:0x064d, B:245:0x05ba), top: B:443:0x05b3, inners: #4 }] */
    /* JADX WARN: Code duplicated, block: B:264:0x0607  */
    /* JADX WARN: Code duplicated, block: B:265:0x0609  */
    /* JADX WARN: Code duplicated, block: B:270:0x0619 A[Catch: all -> 0x061c, TryCatch #11 {all -> 0x061c, blocks: (B:268:0x0615, B:270:0x0619, B:273:0x061e, B:275:0x0624), top: B:453:0x0615 }] */
    /* JADX WARN: Code duplicated, block: B:275:0x0624 A[Catch: all -> 0x061c, TRY_LEAVE, TryCatch #11 {all -> 0x061c, blocks: (B:268:0x0615, B:270:0x0619, B:273:0x061e, B:275:0x0624), top: B:453:0x0615 }] */
    /* JADX WARN: Code duplicated, block: B:280:0x0640  */
    /* JADX WARN: Code duplicated, block: B:293:0x065c A[Catch: all -> 0x065f, TryCatch #13 {all -> 0x065f, blocks: (B:291:0x0658, B:293:0x065c, B:296:0x0661, B:298:0x0667), top: B:457:0x0658 }] */
    /* JADX WARN: Code duplicated, block: B:298:0x0667 A[Catch: all -> 0x065f, TRY_LEAVE, TryCatch #13 {all -> 0x065f, blocks: (B:291:0x0658, B:293:0x065c, B:296:0x0661, B:298:0x0667), top: B:457:0x0658 }] */
    /* JADX WARN: Code duplicated, block: B:303:0x0683  */
    /* JADX WARN: Code duplicated, block: B:441:0x05ba A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:453:0x0615 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:457:0x0658 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:464:0x0646 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:468:0x068a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:474:0x05e3 A[SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:249:0x05c6, please report this as an issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [java.lang.Object, kotlin.coroutines.Continuation] */
    /* JADX WARN: Type inference failed for: r10v13 */
    /* JADX WARN: Type inference failed for: r10v45 */
    /* JADX WARN: Type inference failed for: r15v4, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r1v39 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        StateFlowImpl stateFlowImpl;
        PersistentOrderedSet persistentOrderedSet;
        PersistentOrderedSet persistentOrderedSetAdd;
        Job job;
        OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0 onBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0;
        Recomposer recomposer;
        List listKnownCompositionsLocked;
        int size;
        int i;
        RealImageLoader.AnonymousClass2 anonymousClass2;
        int i2;
        RecomposeScopeImpl recomposeScopeImpl;
        Recomposer recomposer2;
        NeverEqualPolicy neverEqualPolicy;
        StateFlowImpl stateFlowImpl2;
        PersistentOrderedSet persistentOrderedSet2;
        PersistentOrderedSet persistentOrderedSetRemove;
        Recomposer recomposer3;
        NeverEqualPolicy neverEqualPolicy2;
        StateFlowImpl stateFlowImpl3;
        PersistentOrderedSet persistentOrderedSet3;
        PersistentOrderedSet persistentOrderedSetRemove2;
        NavBackStackEntry navBackStackEntry;
        InnerTube innerTube;
        ?? r1;
        CompletableDeferredImpl completableDeferredImpl;
        TypeReference typeReferenceTypeOf;
        TypeReference typeReferenceTypeOf2;
        PodcastEntity podcastEntity;
        Object obj2;
        Object obj3;
        byte b = 5;
        byte b2 = 3;
        int i3 = 0;
        boolean z = false;
        ?? r10 = 0;
        NavBackStackEntry navBackStackEntry2 = null;
        switch (this.$r8$classId) {
            case 0:
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                boolean z2 = this.label;
                if (z2) {
                    if (z2) {
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                ImageRequest imageRequest = (ImageRequest) this.$request;
                RealInterceptorChain realInterceptorChain = new RealInterceptorChain(imageRequest, ((RealImageLoader) this.this$0).components.interceptors, 0, imageRequest, (Size) this.$size, (EventListener$Companion$NONE$1) this.$eventListener, ((Image) this.$cachedPlaceholder) != null);
                this.label = true;
                Object objProceed = realInterceptorChain.proceed(this);
                return objProceed == coroutineSingletons ? coroutineSingletons : objProceed;
            case 1:
                CoroutineSingletons coroutineSingletons2 = CoroutineSingletons.COROUTINE_SUSPENDED;
                boolean z3 = this.label;
                if (!z3) {
                    ResultKt.throwOnFailure(obj);
                    CoroutineScope coroutineScope = (CoroutineScope) this.$request;
                    PointerInputScope pointerInputScope = (PointerInputScope) this.this$0;
                    TapGestureDetectorKt$detectTapAndPress$2$1 tapGestureDetectorKt$detectTapAndPress$2$1 = new TapGestureDetectorKt$detectTapAndPress$2$1((Object) coroutineScope, (Function) this.$size, (Function) this.$eventListener, this.$cachedPlaceholder, (Continuation) null, (byte) 0);
                    this.label = true;
                    if (ScrollableKt.awaitEachGesture(pointerInputScope, tapGestureDetectorKt$detectTapAndPress$2$1, this) == coroutineSingletons2) {
                        return coroutineSingletons2;
                    }
                } else {
                    if (!z3) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            case 2:
                PointerInputScope pointerInputScope2 = (PointerInputScope) this.this$0;
                CoroutineSingletons coroutineSingletons3 = CoroutineSingletons.COROUTINE_SUSPENDED;
                boolean z4 = this.label;
                if (!z4) {
                    ResultKt.throwOnFailure(obj);
                    TapGestureDetectorKt$detectTapGestures$2$1 tapGestureDetectorKt$detectTapGestures$2$1 = new TapGestureDetectorKt$detectTapGestures$2$1((CoroutineScope) this.$request, new PressGestureScopeImpl(pointerInputScope2), (Function1) this.$size, (Function3) this.$eventListener, (Function1) this.$cachedPlaceholder, null);
                    this.label = true;
                    if (ScrollableKt.awaitEachGesture(pointerInputScope2, tapGestureDetectorKt$detectTapGestures$2$1, this) == coroutineSingletons3) {
                        return coroutineSingletons3;
                    }
                } else {
                    if (!z4) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            case 3:
                LegacyTextFieldState legacyTextFieldState = (LegacyTextFieldState) this.$request;
                CoroutineSingletons coroutineSingletons4 = CoroutineSingletons.COROUTINE_SUSPENDED;
                boolean z5 = this.label;
                try {
                    if (!z5) {
                        ResultKt.throwOnFailure(obj);
                        SafeFlow safeFlowSnapshotFlow = Stack.snapshotFlow(new MainActivity$$ExternalSyntheticLambda29((MutableState) this.this$0, (byte) 5));
                        TriggerBasedInvalidationTracker$createFlow$1$2 triggerBasedInvalidationTracker$createFlow$1$2 = new TriggerBasedInvalidationTracker$createFlow$1$2(legacyTextFieldState, (TextInputService) this.$size, (TextFieldSelectionManager) this.$eventListener, (ImeOptions) this.$cachedPlaceholder, (byte) 2);
                        this.label = true;
                        if (safeFlowSnapshotFlow.collect(triggerBasedInvalidationTracker$createFlow$1$2, this) == coroutineSingletons4) {
                            return coroutineSingletons4;
                        }
                    } else {
                        if (!z5) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    BasicTextKt.endInputSession(legacyTextFieldState);
                    return Unit.INSTANCE;
                } catch (Throwable th) {
                    BasicTextKt.endInputSession(legacyTextFieldState);
                    throw th;
                }
            case 4:
                Unit unit = Unit.INSTANCE;
                CoroutineSingletons coroutineSingletons5 = CoroutineSingletons.COROUTINE_SUSPENDED;
                boolean z6 = this.label;
                if (!z6) {
                    ResultKt.throwOnFailure(obj);
                    BringIntoViewRequesterImpl bringIntoViewRequesterImpl = (BringIntoViewRequesterImpl) this.$request;
                    TextFieldValue textFieldValue = (TextFieldValue) this.this$0;
                    TextDelegate textDelegate = ((LegacyTextFieldState) this.$size).textDelegate;
                    TextLayoutResult textLayoutResult = ((TextLayoutResultProxy) this.$eventListener).value;
                    OffsetMapping offsetMapping = (OffsetMapping) this.$cachedPlaceholder;
                    this.label = true;
                    int iOriginalToTransformed = offsetMapping.originalToTransformed(TextRange.m743getMaximpl(textFieldValue.selection));
                    Object objBringIntoView = bringIntoViewRequesterImpl.bringIntoView(iOriginalToTransformed < textLayoutResult.layoutInput.text.text.length() ? textLayoutResult.getBoundingBox(iOriginalToTransformed) : iOriginalToTransformed != 0 ? textLayoutResult.getBoundingBox(iOriginalToTransformed - 1) : new Rect(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f, (int) (TextFieldDelegateKt.computeSizeForDefaultText$default((TextStyle) textDelegate.style, (Density) textDelegate.density, (FontFamily.Resolver) textDelegate.fontFamilyResolver) & 4294967295L)), this);
                    if (objBringIntoView != coroutineSingletons5) {
                        objBringIntoView = unit;
                    }
                    if (objBringIntoView == coroutineSingletons5) {
                        return coroutineSingletons5;
                    }
                } else {
                    if (!z6) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return unit;
            case 5:
                AndroidLegacyPlatformTextInputServiceAdapter androidLegacyPlatformTextInputServiceAdapter = (AndroidLegacyPlatformTextInputServiceAdapter) this.$eventListener;
                AndroidPlatformTextInputSession androidPlatformTextInputSession = (AndroidPlatformTextInputSession) this.this$0;
                CoroutineSingletons coroutineSingletons6 = CoroutineSingletons.COROUTINE_SUSPENDED;
                boolean z7 = this.label;
                try {
                    if (z7) {
                        if (!z7) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ResultKt.throwOnFailure(obj);
                        throw new HttpException();
                    }
                    ResultKt.throwOnFailure(obj);
                    CoroutineScope coroutineScope2 = (CoroutineScope) this.$request;
                    LegacyPlatformTextInputServiceAdapter_androidKt$inputMethodManagerFactory$1 legacyPlatformTextInputServiceAdapter_androidKt$inputMethodManagerFactory$1 = LegacyPlatformTextInputServiceAdapter_androidKt.inputMethodManagerFactory;
                    View view = androidPlatformTextInputSession.view;
                    legacyPlatformTextInputServiceAdapter_androidKt$inputMethodManagerFactory$1.getClass();
                    WeakCache weakCache = new WeakCache(view);
                    LegacyTextInputMethodRequest legacyTextInputMethodRequest = new LegacyTextInputMethodRequest(androidPlatformTextInputSession.view, new AndroidLegacyPlatformTextInputServiceAdapter$startInput$2$1$request$1((LegacyAdaptingPlatformTextInputModifierNode) this.$cachedPlaceholder), weakCache);
                    if (StylusHandwriting_androidKt.isStylusHandwritingSupported) {
                        AwaitKt.launch$default(coroutineScope2, null, null, new SimpleActor$offer$2(androidLegacyPlatformTextInputServiceAdapter, weakCache, r10, b), 3);
                    }
                    Function1 function1 = (Function1) this.$size;
                    if (function1 != null) {
                        function1.invoke(legacyTextInputMethodRequest);
                    }
                    androidLegacyPlatformTextInputServiceAdapter.currentRequest = legacyTextInputMethodRequest;
                    this.label = true;
                    androidPlatformTextInputSession.startInputMethod(legacyTextInputMethodRequest, this);
                    return coroutineSingletons6;
                } catch (Throwable th2) {
                    androidLegacyPlatformTextInputServiceAdapter.currentRequest = null;
                    throw th2;
                }
            case 6:
                CoroutineSingletons coroutineSingletons7 = CoroutineSingletons.COROUTINE_SUSPENDED;
                boolean z8 = this.label;
                if (!z8) {
                    ResultKt.throwOnFailure(obj);
                    final ArrayList arrayList = ((MutableState) this.$request) != null ? new ArrayList() : null;
                    final ArrayList arrayList2 = ((MutableState) this.this$0) != null ? new ArrayList() : null;
                    final ArrayList arrayList3 = ((MutableState) this.$size) != null ? new ArrayList() : null;
                    final ?? arrayList4 = ((MutableState) this.$eventListener) != null ? new ArrayList() : 0;
                    Flow interactions = ((InteractionSource) this.$cachedPlaceholder).getInteractions();
                    final MutableState mutableState = (MutableState) this.$request;
                    final MutableState mutableState2 = (MutableState) this.this$0;
                    final MutableState mutableState3 = (MutableState) this.$size;
                    final MutableState mutableState4 = (MutableState) this.$eventListener;
                    FlowCollector flowCollector = new FlowCollector() { // from class: androidx.compose.material3.ListItemKt$CollectInteractionsAsState$2$1$1
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public final Object emit(Object obj4, Continuation continuation) {
                            Interaction interaction = (Interaction) obj4;
                            boolean z9 = interaction instanceof PressInteraction.Press;
                            List list = arrayList3;
                            List list2 = arrayList2;
                            List list3 = arrayList4;
                            List list4 = arrayList;
                            if (z9) {
                                if (list4 != null) {
                                    list4.add(interaction);
                                }
                            } else if (interaction instanceof PressInteraction.Release) {
                                if (list4 != null) {
                                    list4.remove(((PressInteraction.Release) interaction).press);
                                }
                            } else if (interaction instanceof PressInteraction.Cancel) {
                                if (list4 != null) {
                                    list4.remove(((PressInteraction.Cancel) interaction).press);
                                }
                            } else if (interaction instanceof FocusInteraction.Focus) {
                                if (list2 != null) {
                                    list2.add(interaction);
                                }
                            } else if (interaction instanceof FocusInteraction.Unfocus) {
                                if (list2 != null) {
                                    list2.remove(((FocusInteraction.Unfocus) interaction).focus);
                                }
                            } else if (interaction instanceof HoverInteraction$Enter) {
                                if (list != null) {
                                    list.add(interaction);
                                }
                            } else if (interaction instanceof HoverInteraction$Exit) {
                                if (list != null) {
                                    list.remove(((HoverInteraction$Exit) interaction).enter);
                                }
                            } else if (interaction instanceof DragInteraction$Start) {
                                if (list3 != null) {
                                    list3.add(interaction);
                                }
                            } else if (interaction instanceof DragInteraction$Stop) {
                                if (list3 != null) {
                                    list3.remove(((DragInteraction$Stop) interaction).start);
                                }
                            } else if ((interaction instanceof DragInteraction$Cancel) && list3 != null) {
                                list3.remove(((DragInteraction$Cancel) interaction).start);
                            }
                            MutableState mutableState5 = mutableState;
                            if (mutableState5 != null && list4 != null) {
                                mutableState5.setValue(Boolean.valueOf(!list4.isEmpty()));
                            }
                            MutableState mutableState6 = mutableState2;
                            if (mutableState6 != null && list2 != null) {
                                mutableState6.setValue(Boolean.valueOf(!list2.isEmpty()));
                            }
                            MutableState mutableState7 = mutableState3;
                            if (mutableState7 != null && list != null) {
                                mutableState7.setValue(Boolean.valueOf(!list.isEmpty()));
                            }
                            MutableState mutableState8 = mutableState4;
                            if (mutableState8 != null && list3 != null) {
                                mutableState8.setValue(Boolean.valueOf(!list3.isEmpty()));
                            }
                            return Unit.INSTANCE;
                        }
                    };
                    this.label = true;
                    if (interactions.collect(flowCollector, this) == coroutineSingletons7) {
                        return coroutineSingletons7;
                    }
                } else {
                    if (!z8) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            case 7:
                CoroutineSingletons coroutineSingletons8 = CoroutineSingletons.COROUTINE_SUSPENDED;
                boolean z9 = this.label;
                if (z9) {
                    if (!z9) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    onBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0 = (OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0) this.$request;
                    job = (Job) this.this$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        onBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0.dispose();
                        recomposer3 = (Recomposer) this.$size;
                        synchronized (recomposer3.stateLock) {
                            try {
                                if (recomposer3.runnerJob == job) {
                                    recomposer3.runnerJob = null;
                                }
                                if (recomposer3.deriveStateLocked() != null) {
                                    ComposerKt.composeImmediateRuntimeError("called outside of runRecomposeAndApplyChanges");
                                }
                            } catch (Throwable th3) {
                                throw th3;
                            }
                            break;
                        }
                        StateFlowImpl stateFlowImpl4 = Recomposer._runningRecomposers;
                        neverEqualPolicy2 = ((Recomposer) this.$size).recomposerInfo;
                        do {
                            stateFlowImpl3 = Recomposer._runningRecomposers;
                            persistentOrderedSet3 = (PersistentOrderedSet) stateFlowImpl3.getValue();
                            persistentOrderedSetRemove2 = persistentOrderedSet3.remove((Object) neverEqualPolicy2);
                            if (persistentOrderedSet3 != persistentOrderedSetRemove2) {
                            }
                            return Unit.INSTANCE;
                        } while (!stateFlowImpl3.compareAndSet(persistentOrderedSet3, persistentOrderedSetRemove2));
                        return Unit.INSTANCE;
                    } catch (Throwable th4) {
                        th = th4;
                        onBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0.dispose();
                        recomposer2 = (Recomposer) this.$size;
                        synchronized (recomposer2.stateLock) {
                            try {
                                if (recomposer2.runnerJob == job) {
                                    recomposer2.runnerJob = null;
                                }
                                if (recomposer2.deriveStateLocked() != null) {
                                    ComposerKt.composeImmediateRuntimeError("called outside of runRecomposeAndApplyChanges");
                                    break;
                                }
                                StateFlowImpl stateFlowImpl5 = Recomposer._runningRecomposers;
                                neverEqualPolicy = ((Recomposer) this.$size).recomposerInfo;
                                do {
                                    stateFlowImpl2 = Recomposer._runningRecomposers;
                                    persistentOrderedSet2 = (PersistentOrderedSet) stateFlowImpl2.getValue();
                                    persistentOrderedSetRemove = persistentOrderedSet2.remove((Object) neverEqualPolicy);
                                    if (persistentOrderedSet2 != persistentOrderedSetRemove) {
                                    }
                                    throw th;
                                } while (!stateFlowImpl2.compareAndSet(persistentOrderedSet2, persistentOrderedSetRemove));
                                throw th;
                            } catch (Throwable th5) {
                                throw th5;
                            }
                        }
                    }
                }
                ResultKt.throwOnFailure(obj);
                Job job2 = AwaitKt.getJob(((CoroutineScope) this.this$0).getCoroutineContext());
                Recomposer recomposer4 = (Recomposer) this.$size;
                StateFlowImpl stateFlowImpl6 = Recomposer._runningRecomposers;
                synchronized (recomposer4.stateLock) {
                    Throwable th6 = recomposer4.closeCause;
                    if (th6 != null) {
                        throw th6;
                    }
                    if (((Recomposer.State) recomposer4._state.getValue()).compareTo(Recomposer.State.ShuttingDown) <= 0) {
                        throw new IllegalStateException("Recomposer shut down");
                    }
                    if (recomposer4.runnerJob != null) {
                        throw new IllegalStateException("Recomposer already running");
                    }
                    recomposer4.runnerJob = job2;
                    if (recomposer4.deriveStateLocked() != null) {
                        ComposerKt.composeImmediateRuntimeError("called outside of runRecomposeAndApplyChanges");
                    }
                }
                byte b3 = 21;
                ComposerKt$$ExternalSyntheticLambda0 composerKt$$ExternalSyntheticLambda0 = new ComposerKt$$ExternalSyntheticLambda0(b3, (Recomposer) this.$size);
                SnapshotKt.advanceGlobalSnapshot(SnapshotKt.emptyLambda);
                synchronized (SnapshotKt.lock) {
                    SnapshotKt.applyObservers = CollectionsKt.plus(composerKt$$ExternalSyntheticLambda0, SnapshotKt.applyObservers);
                }
                OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0 onBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda1 = new OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0(b2, composerKt$$ExternalSyntheticLambda0);
                NeverEqualPolicy neverEqualPolicy3 = ((Recomposer) this.$size).recomposerInfo;
                try {
                    do {
                        stateFlowImpl = Recomposer._runningRecomposers;
                        persistentOrderedSet = (PersistentOrderedSet) stateFlowImpl.getValue();
                        persistentOrderedSetAdd = persistentOrderedSet.add((Object) neverEqualPolicy3);
                        if (persistentOrderedSet != persistentOrderedSetAdd) {
                        }
                        recomposer = (Recomposer) this.$size;
                        synchronized (recomposer.stateLock) {
                            listKnownCompositionsLocked = recomposer.knownCompositionsLocked();
                        }
                        size = listKnownCompositionsLocked.size();
                        for (i = 0; i < size; i++) {
                            for (Object obj4 : ((CompositionImpl) listKnownCompositionsLocked.get(i)).slotStorage.slots) {
                                if (obj4 instanceof RecomposeScopeImpl) {
                                    recomposeScopeImpl = (RecomposeScopeImpl) obj4;
                                } else {
                                    recomposeScopeImpl = null;
                                }
                                if (recomposeScopeImpl != null) {
                                    recomposeScopeImpl.invalidate();
                                }
                            }
                        }
                        anonymousClass2 = new RealImageLoader.AnonymousClass2((Recomposer$runRecomposeAndApplyChanges$2) this.$eventListener, (MonotonicFrameClock) this.$cachedPlaceholder, r10, b3);
                        this.this$0 = job2;
                        this.$request = onBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda1;
                        this.label = true;
                        if (AwaitKt.coroutineScope(anonymousClass2, this) == coroutineSingletons8) {
                            return coroutineSingletons8;
                        }
                        job = job2;
                        onBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0 = onBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda1;
                        onBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0.dispose();
                        recomposer3 = (Recomposer) this.$size;
                        synchronized (recomposer3.stateLock) {
                            if (recomposer3.runnerJob == job) {
                                recomposer3.runnerJob = null;
                            }
                            if (recomposer3.deriveStateLocked() != null) {
                                ComposerKt.composeImmediateRuntimeError("called outside of runRecomposeAndApplyChanges");
                                break;
                            }
                            StateFlowImpl stateFlowImpl7 = Recomposer._runningRecomposers;
                            neverEqualPolicy2 = ((Recomposer) this.$size).recomposerInfo;
                            do {
                                stateFlowImpl3 = Recomposer._runningRecomposers;
                                persistentOrderedSet3 = (PersistentOrderedSet) stateFlowImpl3.getValue();
                                persistentOrderedSetRemove2 = persistentOrderedSet3.remove((Object) neverEqualPolicy2);
                                if (persistentOrderedSet3 != persistentOrderedSetRemove2) {
                                }
                                return Unit.INSTANCE;
                            } while (!stateFlowImpl3.compareAndSet(persistentOrderedSet3, persistentOrderedSetRemove2));
                            return Unit.INSTANCE;
                        }
                    } while (!stateFlowImpl.compareAndSet(persistentOrderedSet, persistentOrderedSetAdd));
                    recomposer = (Recomposer) this.$size;
                    synchronized (recomposer.stateLock) {
                        listKnownCompositionsLocked = recomposer.knownCompositionsLocked();
                        size = listKnownCompositionsLocked.size();
                        while (i < size) {
                            while (i2 < r12) {
                                if (obj4 instanceof RecomposeScopeImpl) {
                                    recomposeScopeImpl = (RecomposeScopeImpl) obj4;
                                } else {
                                    recomposeScopeImpl = null;
                                }
                                if (recomposeScopeImpl != null) {
                                    recomposeScopeImpl.invalidate();
                                }
                            }
                        }
                        anonymousClass2 = new RealImageLoader.AnonymousClass2((Recomposer$runRecomposeAndApplyChanges$2) this.$eventListener, (MonotonicFrameClock) this.$cachedPlaceholder, r10, b3);
                        this.this$0 = job2;
                        this.$request = onBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda1;
                        this.label = true;
                        if (AwaitKt.coroutineScope(anonymousClass2, this) == coroutineSingletons8) {
                            return coroutineSingletons8;
                        }
                        job = job2;
                        onBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0 = onBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda1;
                        onBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0.dispose();
                        recomposer3 = (Recomposer) this.$size;
                        synchronized (recomposer3.stateLock) {
                            if (recomposer3.runnerJob == job) {
                                recomposer3.runnerJob = null;
                            }
                            if (recomposer3.deriveStateLocked() != null) {
                                ComposerKt.composeImmediateRuntimeError("called outside of runRecomposeAndApplyChanges");
                                break;
                            }
                            StateFlowImpl stateFlowImpl8 = Recomposer._runningRecomposers;
                            neverEqualPolicy2 = ((Recomposer) this.$size).recomposerInfo;
                            do {
                                stateFlowImpl3 = Recomposer._runningRecomposers;
                                persistentOrderedSet3 = (PersistentOrderedSet) stateFlowImpl3.getValue();
                                persistentOrderedSetRemove2 = persistentOrderedSet3.remove((Object) neverEqualPolicy2);
                                if (persistentOrderedSet3 != persistentOrderedSetRemove2) {
                                }
                                return Unit.INSTANCE;
                            } while (!stateFlowImpl3.compareAndSet(persistentOrderedSet3, persistentOrderedSetRemove2));
                            return Unit.INSTANCE;
                        }
                    }
                } catch (Throwable th7) {
                    th = th7;
                    job = job2;
                    onBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0 = onBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda1;
                    onBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0.dispose();
                    recomposer2 = (Recomposer) this.$size;
                    synchronized (recomposer2.stateLock) {
                        if (recomposer2.runnerJob == job) {
                            recomposer2.runnerJob = null;
                        }
                        if (recomposer2.deriveStateLocked() != null) {
                            ComposerKt.composeImmediateRuntimeError("called outside of runRecomposeAndApplyChanges");
                        }
                        break;
                    }
                    StateFlowImpl stateFlowImpl9 = Recomposer._runningRecomposers;
                    neverEqualPolicy = ((Recomposer) this.$size).recomposerInfo;
                    do {
                        stateFlowImpl2 = Recomposer._runningRecomposers;
                        persistentOrderedSet2 = (PersistentOrderedSet) stateFlowImpl2.getValue();
                        persistentOrderedSetRemove = persistentOrderedSet2.remove((Object) neverEqualPolicy);
                        if (persistentOrderedSet2 != persistentOrderedSetRemove) {
                        }
                        throw th;
                    } while (!stateFlowImpl2.compareAndSet(persistentOrderedSet2, persistentOrderedSetRemove));
                    throw th;
                }
            case 8:
                ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState = (ParcelableSnapshotMutableFloatState) this.$eventListener;
                MutableState mutableState5 = (MutableState) this.$cachedPlaceholder;
                ComposeNavigator composeNavigator = (ComposeNavigator) this.this$0;
                MutableState mutableState6 = (MutableState) this.$size;
                CoroutineSingletons coroutineSingletons9 = CoroutineSingletons.COROUTINE_SUSPENDED;
                boolean z10 = this.label;
                try {
                    if (!z10) {
                        ResultKt.throwOnFailure(obj);
                        Flow flow = (Flow) this.$request;
                        if (((List) mutableState6.getValue()).size() > 1) {
                            parcelableSnapshotMutableFloatState.setFloatValue(CropImageView.DEFAULT_ASPECT_RATIO);
                            navBackStackEntry2 = (NavBackStackEntry) CollectionsKt.lastOrNull((List) mutableState6.getValue());
                            navBackStackEntry2.getClass();
                            composeNavigator.prepareForTransition(navBackStackEntry2);
                            composeNavigator.prepareForTransition((NavBackStackEntry) ((List) mutableState6.getValue()).get(((List) mutableState6.getValue()).size() - 2));
                        }
                        FlowKt__LimitKt$take$2$1 flowKt__LimitKt$take$2$1 = new FlowKt__LimitKt$take$2$1(mutableState6, mutableState5, parcelableSnapshotMutableFloatState, (byte) 4);
                        this.$request = navBackStackEntry2;
                        this.label = true;
                        if (flow.collect(flowKt__LimitKt$take$2$1, this) == coroutineSingletons9) {
                            return coroutineSingletons9;
                        }
                        navBackStackEntry = navBackStackEntry2;
                    } else {
                        if (!z10) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        navBackStackEntry = (NavBackStackEntry) this.$request;
                        ResultKt.throwOnFailure(obj);
                    }
                    if (((List) mutableState6.getValue()).size() > 1) {
                        mutableState5.setValue(Boolean.FALSE);
                        navBackStackEntry.getClass();
                        composeNavigator.popBackStack(navBackStackEntry, false);
                    }
                    break;
                } catch (CancellationException unused) {
                    if (((List) mutableState6.getValue()).size() > 1) {
                        mutableState5.setValue(Boolean.FALSE);
                    }
                }
                return Unit.INSTANCE;
            case 9:
                CoroutineSingletons coroutineSingletons10 = CoroutineSingletons.COROUTINE_SUSPENDED;
                boolean z11 = this.label;
                if (!z11) {
                    ResultKt.throwOnFailure(obj);
                    innerTube = (InnerTube) this.$eventListener;
                    MutexImpl mutexImpl = innerTube.visitorDataFetchMutex;
                    CompletableDeferredImpl completableDeferredImpl2 = (CompletableDeferredImpl) this.$cachedPlaceholder;
                    this.$request = mutexImpl;
                    this.this$0 = innerTube;
                    this.$size = completableDeferredImpl2;
                    this.label = true;
                    if (mutexImpl.lock(this) == coroutineSingletons10) {
                        return coroutineSingletons10;
                    }
                    r1 = mutexImpl;
                    completableDeferredImpl = completableDeferredImpl2;
                } else {
                    if (!z11) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    completableDeferredImpl = (CompletableDeferredImpl) this.$size;
                    innerTube = (InnerTube) this.this$0;
                    MutexImpl mutexImpl2 = (MutexImpl) this.$request;
                    ResultKt.throwOnFailure(obj);
                    r1 = mutexImpl2;
                }
                try {
                    InnerTube.VisitorDataFlight visitorDataFlight = innerTube.visitorDataFlight;
                    if ((visitorDataFlight != null ? visitorDataFlight.result : null) == completableDeferredImpl) {
                        innerTube.visitorDataFlight = null;
                        break;
                    }
                    return Unit.INSTANCE;
                } finally {
                    r1.unlock(null);
                }
            case 10:
                InnerTube.SessionSnapshot sessionSnapshot = (InnerTube.SessionSnapshot) this.$request;
                CoroutineSingletons coroutineSingletons11 = CoroutineSingletons.COROUTINE_SUSPENDED;
                boolean z12 = this.label;
                if (z12) {
                    if (z12) {
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                InnerTube innerTube2 = (InnerTube) this.this$0;
                HttpClient httpClient = innerTube2.httpClient;
                YouTubeClient youTubeClient = (YouTubeClient) this.$size;
                String str = (String) this.$eventListener;
                byte[] bArr = (byte[]) this.$cachedPlaceholder;
                HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
                httpRequestBuilder.setMethod(HttpMethod.Post);
                HttpRequestKt.url(httpRequestBuilder, "https://music.youtube.com/playlist_image_upload/playlist_custom_thumbnail");
                InnerTube.ytClient$default(innerTube2, httpRequestBuilder, youTubeClient, sessionSnapshot, true, null, false, 24);
                UtilsKt.parameter(httpRequestBuilder, "upload_id", str);
                UtilsKt.parameter(httpRequestBuilder, "upload_protocol", "resumable");
                UtilsKt.header(httpRequestBuilder, "X-Goog-Upload-Command", "upload, finalize");
                UtilsKt.header(httpRequestBuilder, "X-Goog-Upload-Offset", "0");
                if (bArr != null) {
                    if (bArr instanceof OutgoingContent) {
                        httpRequestBuilder.setBody(bArr);
                        httpRequestBuilder.setBodyType(null);
                    } else {
                        httpRequestBuilder.setBody(bArr);
                        ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(byte[].class);
                        try {
                            typeReferenceTypeOf = Reflection.typeOf(byte[].class);
                        } catch (Throwable unused2) {
                            typeReferenceTypeOf = null;
                        }
                        Format$$ExternalSyntheticOutline0.m(orCreateKotlinClass, false, typeReferenceTypeOf, httpRequestBuilder);
                    }
                    break;
                } else {
                    httpRequestBuilder.setBody(NullBody.INSTANCE);
                    ClassReference orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(byte[].class);
                    try {
                        typeReferenceTypeOf2 = Reflection.typeOf(byte[].class);
                    } catch (Throwable unused3) {
                        typeReferenceTypeOf2 = null;
                    }
                    Format$$ExternalSyntheticOutline0.m(orCreateKotlinClass2, false, typeReferenceTypeOf2, httpRequestBuilder);
                    break;
                }
                HttpStatement httpStatementM = Format$$ExternalSyntheticOutline0.m(httpRequestBuilder, HttpMethod.Post, httpRequestBuilder, httpClient);
                this.$request = null;
                this.label = true;
                Object objExecute = httpStatementM.execute(this);
                return objExecute == coroutineSingletons11 ? coroutineSingletons11 : objExecute;
            case 11:
                CoroutineSingletons coroutineSingletons12 = CoroutineSingletons.COROUTINE_SUSPENDED;
                boolean z13 = this.label;
                if (!z13) {
                    ResultKt.throwOnFailure(obj);
                    MusicDatabase musicDatabase = (MusicDatabase) this.$request;
                    Playlist playlist = (Playlist) ((MutableState) this.$eventListener).getValue();
                    playlist.getClass();
                    List list = (List) ((MutableState) this.$cachedPlaceholder).getValue();
                    list.getClass();
                    ArrayList arrayList5 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        arrayList5.add(new Pair((String) it.next(), null));
                    }
                    boolean z14 = ((AddToPlaylistPosition) this.this$0).prepend;
                    this.label = true;
                    if (musicDatabase.$$delegate_0.addSongsToPlaylist(playlist, arrayList5, z14, this) == coroutineSingletons12) {
                        return coroutineSingletons12;
                    }
                } else {
                    if (!z13) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                ((Function0) this.$size).invoke();
                return Unit.INSTANCE;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                MusicDatabase musicDatabase2 = (MusicDatabase) this.$size;
                String str2 = (String) this.this$0;
                CoroutineSingletons coroutineSingletons13 = CoroutineSingletons.COROUTINE_SUSPENDED;
                boolean z15 = this.label;
                if (!z15) {
                    ResultKt.throwOnFailure(obj);
                    PodcastEntity podcastEntity2 = (PodcastEntity) ((MutableState) this.$eventListener).getValue();
                    boolean z16 = (podcastEntity2 != null ? podcastEntity2.bookmarkedAt : null) != null;
                    this.$request = podcastEntity2;
                    this.label = true;
                    Object objM1037savePodcast0E7RQCE = YouTube.INSTANCE.m1037savePodcast0E7RQCE(str2, !z16, this);
                    if (objM1037savePodcast0E7RQCE == coroutineSingletons13) {
                        return coroutineSingletons13;
                    }
                    podcastEntity = podcastEntity2;
                    obj2 = objM1037savePodcast0E7RQCE;
                } else {
                    if (!z15) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    podcastEntity = (PodcastEntity) this.$request;
                    ResultKt.throwOnFailure(obj);
                    obj2 = ((Result) obj).value;
                }
                if (!(obj2 instanceof Result.Failure)) {
                    Timber.Forest.getClass();
                    ConnectionPool.d(new Object[0]);
                }
                if (Result.m1866exceptionOrNullimpl(obj2) != null) {
                    Timber.Forest.getClass();
                    ConnectionPool.e$1(new Object[0]);
                }
                if (podcastEntity != null) {
                    Timber.Forest.getClass();
                    ConnectionPool.d(new Object[0]);
                    musicDatabase2.query(new SongMenuKt$SongMenu$14$1$5$1$8$4$1$1$$ExternalSyntheticLambda0(podcastEntity, z ? 1 : 0));
                } else {
                    Timber.Forest.getClass();
                    ConnectionPool.d(new Object[0]);
                    musicDatabase2.query(new SongMenuKt$$ExternalSyntheticLambda4((Song) this.$cachedPlaceholder, str2));
                }
                return Unit.INSTANCE;
            case 13:
                MutableState mutableState7 = (MutableState) this.$size;
                ResultKt.throwOnFailure(obj);
                MediaMetadata mediaMetadata = (MediaMetadata) ((MutableState) this.this$0).getValue();
                String str3 = mediaMetadata != null ? mediaMetadata.id : null;
                if (str3 != null && !str3.equals((String) mutableState7.getValue()) && ((String) mutableState7.getValue()) != null && ((Number) ((MutableState) this.$eventListener).getValue()).intValue() == 4 && ((Number) ((State) this.$cachedPlaceholder).getValue()).intValue() == 1 && !this.label) {
                    ((PlayerConnection) this.$request).getPlayerSafe().setRepeatMode(2);
                }
                mutableState7.setValue(str3);
                return Unit.INSTANCE;
            case 14:
                MediaMetadata mediaMetadata2 = (MediaMetadata) this.$request;
                CoroutineSingletons coroutineSingletons14 = CoroutineSingletons.COROUTINE_SUSPENDED;
                boolean z17 = this.label;
                if (!z17) {
                    ResultKt.throwOnFailure(obj);
                    if (mediaMetadata2 != null && ((LyricsEntity) ((MutableState) this.$size).getValue()) == null) {
                        this.label = true;
                        if (AwaitKt.delay(500L, this) == coroutineSingletons14) {
                            return coroutineSingletons14;
                        }
                    }
                    return Unit.INSTANCE;
                }
                if (!z17) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope3 = (CoroutineScope) this.this$0;
                DefaultScheduler defaultScheduler = Dispatchers.Default;
                AwaitKt.launch$default(coroutineScope3, DefaultIoScheduler.INSTANCE, null, new DataStoreKt$get$2(this.$eventListener, (Object) mediaMetadata2, this.$cachedPlaceholder, (Continuation) null, (byte) 12), 2);
                return Unit.INSTANCE;
            case 15:
                ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState = (ParcelableSnapshotMutableIntState) this.$eventListener;
                MutableState mutableState8 = (MutableState) this.$size;
                CoroutineSingletons coroutineSingletons15 = CoroutineSingletons.COROUTINE_SUSPENDED;
                boolean z18 = this.label;
                try {
                    if (!z18) {
                        ResultKt.throwOnFailure(obj);
                        if (((Number) mutableState8.getValue()).intValue() > parcelableSnapshotMutableIntState.getIntValue()) {
                            parcelableSnapshotMutableIntState.setIntValue(((Number) mutableState8.getValue()).intValue());
                            this.label = true;
                            if (AwaitKt.delay(100L, this) == coroutineSingletons15) {
                                return coroutineSingletons15;
                            }
                        }
                        return Unit.INSTANCE;
                    }
                    if (!z18) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    FocusRequester.m415requestFocus3ESFkO8$default((FocusRequester) this.$request);
                    SoftwareKeyboardController softwareKeyboardController = (SoftwareKeyboardController) this.this$0;
                    if (softwareKeyboardController != null) {
                        ((DelegatingSoftwareKeyboardController) softwareKeyboardController).show();
                    }
                    break;
                } catch (Exception unused4) {
                }
                ((MutableState) this.$cachedPlaceholder).setValue(Boolean.TRUE);
                return Unit.INSTANCE;
            case 16:
                return invokeSuspend$com$metrolist$music$ui$screens$settings$BackupAndRestoreKt$BackupAndRestore$restoreLauncher$1$1$1(obj);
            case 17:
                CoroutineSingletons coroutineSingletons16 = CoroutineSingletons.COROUTINE_SUSPENDED;
                boolean z19 = this.label;
                if (!z19) {
                    ResultKt.throwOnFailure(obj);
                    Updater updater = Updater.INSTANCE;
                    this.label = true;
                    Object objM1523checkForUpdategIAlus = updater.m1523checkForUpdategIAlus(true, this);
                    if (objM1523checkForUpdategIAlus == coroutineSingletons16) {
                        return coroutineSingletons16;
                    }
                    obj3 = objM1523checkForUpdategIAlus;
                } else {
                    if (!z19) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    obj3 = ((Result) obj).value;
                }
                MutableState mutableState9 = (MutableState) this.$request;
                MutableState mutableState10 = (MutableState) this.this$0;
                MutableState mutableState11 = (MutableState) this.$size;
                if (!(obj3 instanceof Result.Failure)) {
                    Pair pair = (Pair) obj3;
                    ReleaseInfo releaseInfo = (ReleaseInfo) pair.first;
                    Boolean bool = (Boolean) pair.second;
                    bool.booleanValue();
                    if (releaseInfo != null) {
                        mutableState9.setValue(releaseInfo.versionName);
                        mutableState10.setValue(bool);
                        mutableState11.setValue(releaseInfo.description);
                    }
                }
                String str4 = (String) this.$eventListener;
                MutableState mutableState12 = (MutableState) this.$cachedPlaceholder;
                Throwable thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(obj3);
                if (thM1866exceptionOrNullimpl != null) {
                    String message = thM1866exceptionOrNullimpl.getMessage();
                    if (message == null) {
                        message = "Unknown error";
                    }
                    mutableState12.setValue(String.format(str4, Arrays.copyOf(new Object[]{message}, 1)));
                }
                return new Result(obj3);
            default:
                List<MediaMetadata> list2 = (List) this.$eventListener;
                String str5 = (String) this.this$0;
                MusicDatabase musicDatabase3 = ((SyncUtils) this.$request).database;
                CoroutineSingletons coroutineSingletons17 = CoroutineSingletons.COROUTINE_SUSPENDED;
                boolean z20 = this.label;
                if (!z20) {
                    ResultKt.throwOnFailure(obj);
                    musicDatabase3.clearPlaylist(str5);
                    ArrayList arrayList6 = (ArrayList) this.$size;
                    int size2 = arrayList6.size();
                    int i4 = 0;
                    while (i4 < size2) {
                        Object obj5 = arrayList6.get(i4);
                        i4++;
                        musicDatabase3.insert((MediaMetadata) obj5, new DatabaseDao$$ExternalSyntheticLambda0((byte) 0));
                    }
                    musicDatabase3.getClass();
                    Playlist playlistPlaylistBlocking = musicDatabase3.$$delegate_0.playlistBlocking(str5);
                    if (playlistPlaylistBlocking != null) {
                        ArrayList arrayList7 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10));
                        for (MediaMetadata mediaMetadata3 : list2) {
                            arrayList7.add(new Pair(mediaMetadata3.id, mediaMetadata3.setVideoId));
                        }
                        this.label = true;
                        if (musicDatabase3.addSongsToPlaylist(playlistPlaylistBlocking, arrayList7, false, this) == coroutineSingletons17) {
                            return coroutineSingletons17;
                        }
                    }
                } else {
                    if (!z20) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                ArrayList arrayList8 = (ArrayList) this.$cachedPlaceholder;
                int size3 = arrayList8.size();
                int i5 = 0;
                while (i5 < size3) {
                    Object obj6 = arrayList8.get(i5);
                    i5++;
                    int i6 = i3 + 1;
                    if (i3 < 0) {
                        CollectionsKt__IterablesKt.throwIndexOverflow();
                        throw null;
                    }
                    PlaylistSongMap playlistSongMapCopy$default = PlaylistSongMap.copy$default((PlaylistSongMap) obj6, list2.size() + i3, null, 22);
                    musicDatabase3.getClass();
                    musicDatabase3.$$delegate_0.insert(playlistSongMapCopy$default);
                    i3 = i6;
                }
                return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RealImageLoader$execute$result$1(InnerTube innerTube, CompletableDeferredImpl completableDeferredImpl, Continuation continuation) {
        super(2, continuation);
        this.$r8$classId = (byte) 9;
        this.$eventListener = innerTube;
        this.$cachedPlaceholder = completableDeferredImpl;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RealImageLoader$execute$result$1(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$request = obj;
        this.this$0 = obj2;
        this.$size = obj3;
        this.$eventListener = obj4;
        this.$cachedPlaceholder = obj5;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RealImageLoader$execute$result$1(Object obj, Object obj2, Object obj3, Object obj4, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.this$0 = obj;
        this.$size = obj2;
        this.$eventListener = obj3;
        this.$cachedPlaceholder = obj4;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RealImageLoader$execute$result$1(Recomposer recomposer, Recomposer$runRecomposeAndApplyChanges$2 recomposer$runRecomposeAndApplyChanges$2, MonotonicFrameClock monotonicFrameClock, Continuation continuation) {
        super(2, continuation);
        this.$r8$classId = (byte) 7;
        this.$size = recomposer;
        this.$eventListener = recomposer$runRecomposeAndApplyChanges$2;
        this.$cachedPlaceholder = monotonicFrameClock;
    }
}
