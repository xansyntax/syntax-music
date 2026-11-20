package coil3.disk;

import android.content.Context;
import android.os.Bundle;
import android.os.CancellationSignal;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsModifierNode$$ExternalSyntheticLambda1;
import androidx.compose.foundation.text.KeyboardActionRunner;
import androidx.compose.foundation.text.input.internal.RecordingInputConnection;
import androidx.compose.material3.SliderState;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.LinearGradient;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.WeakReference;
import androidx.compose.ui.platform.DelegatingSoftwareKeyboardController;
import androidx.compose.ui.platform.GlobalSnapshotManager;
import androidx.compose.ui.platform.GraphicsLayerOwnerLayer;
import androidx.compose.ui.platform.InputMethodSession;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.font.FontFamilyResolverImpl;
import androidx.compose.ui.text.font.TypefaceRequest;
import androidx.compose.ui.text.input.CommitTextCommand;
import androidx.compose.ui.text.input.DeleteAllCommand;
import androidx.compose.ui.text.input.DeleteSurroundingTextCommand;
import androidx.compose.ui.text.input.DeleteSurroundingTextInCodePointsCommand;
import androidx.compose.ui.text.input.EditCommand;
import androidx.compose.ui.text.input.FinishComposingTextCommand;
import androidx.compose.ui.text.input.NullableInputConnectionWrapperApi25;
import androidx.compose.ui.text.input.SetComposingRegionCommand;
import androidx.compose.ui.text.input.SetComposingTextCommand;
import androidx.compose.ui.text.input.SetSelectionCommand;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.viewinterop.BringIntoViewNode;
import androidx.datastore.core.DataStoreImpl;
import androidx.datastore.core.FileStorageConnection;
import androidx.datastore.core.Final;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavBackStackEntryState;
import androidx.navigation.NavDestination;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigator;
import androidx.navigation.internal.NavBackStackEntryImpl;
import androidx.navigation.internal.NavControllerImpl;
import androidx.room.BindOnlySQLiteStatement;
import androidx.room.RoomDatabase$$ExternalSyntheticLambda0;
import androidx.room.RoomSQLiteQuery;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;
import coil3.util.FileSystemsKt;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.dokar.quickjs.QuickJs;
import com.metrolist.innertubex.InnerTube;
import com.metrolist.innertubex.models.YouTubeClient;
import com.metrolist.innertubex.models.YouTubeLocale;
import com.metrolist.music.MainActivity;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.Artist;
import com.metrolist.music.db.entities.PlaylistEntity;
import com.metrolist.music.listentogether.proto.Listentogether;
import com.metrolist.music.playback.MusicService;
import com.metrolist.music.playback.VoiceSearchMatcher;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpHeaders;
import io.ktor.sse.ServerSentEventKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import kotlin.SynchronizedLazyImpl;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt;
import kotlin.text.CharsKt;
import kotlin.time.InstantJvmKt;
import kotlin.uuid.UuidKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.flow.StateFlowImpl;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.FileMetadata;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class DiskLruCache$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ DiskLruCache$$ExternalSyntheticLambda0(byte b, Object obj) {
        this.$r8$classId = b;
        this.f$0 = obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r16v2, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r16v6 */
    /* JADX WARN: Type inference failed for: r16v7 */
    /* JADX WARN: Type inference failed for: r5v22, types: [java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r5v23 */
    /* JADX WARN: Type inference failed for: r5v32 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        String strConcat;
        int length;
        int i;
        String str;
        Bundle bundle;
        ?? r16;
        byte b = this.$r8$classId;
        int i2 = 0;
        zContains = false;
        boolean zContains = false;
        Continuation continuation = null;
        String string = null;
        continuation = null;
        continuation = null;
        Unit unit = Unit.INSTANCE;
        Object obj2 = this.f$0;
        switch (b) {
            case 0:
                ((DiskLruCache) obj2).hasJournalErrors = true;
                return unit;
            case 1:
                BufferedChannel bufferedChannel = (BufferedChannel) obj2;
                if (GlobalSnapshotManager.sent.compareAndSet(false, true)) {
                    bufferedChannel.mo1712trySendJP2dKIU(unit);
                }
                return unit;
            case 2:
                DrawScope drawScope = (DrawScope) obj;
                Canvas canvas = drawScope.getDrawContext().getCanvas();
                Function2 function2 = ((GraphicsLayerOwnerLayer) obj2).drawBlock;
                if (function2 != null) {
                    function2.invoke(canvas, (GraphicsLayer) drawScope.getDrawContext().mMetadataRepo);
                }
                return unit;
            case 3:
                InputMethodSession inputMethodSession = (InputMethodSession) obj2;
                NullableInputConnectionWrapperApi25 nullableInputConnectionWrapperApi25 = (NullableInputConnectionWrapperApi25) obj;
                RecordingInputConnection recordingInputConnection = nullableInputConnectionWrapperApi25.delegate;
                if (recordingInputConnection != null) {
                    recordingInputConnection.closeConnection();
                    nullableInputConnectionWrapperApi25.delegate = null;
                }
                MutableVector mutableVector = inputMethodSession.connections;
                Object[] objArr = mutableVector.content;
                int i3 = mutableVector.size;
                while (true) {
                    if (i2 >= i3) {
                        i2 = -1;
                    } else if (!Intrinsics.areEqual((WeakReference) objArr[i2], nullableInputConnectionWrapperApi25)) {
                        i2++;
                    }
                }
                if (i2 >= 0) {
                    mutableVector.removeAt(i2);
                }
                if (mutableVector.size == 0) {
                    inputMethodSession.onAllConnectionsClosed.invoke();
                }
                return unit;
            case 4:
                CancellationSignal cancellationSignal = (CancellationSignal) obj2;
                if (((Throwable) obj) != null) {
                    cancellationSignal.cancel();
                }
                return unit;
            case 5:
                SemanticsPropertiesKt.m718setRolekuIjeqM((SemanticsPropertyReceiver) obj, ((Role) obj2).value);
                return unit;
            case 6:
                ((List) obj).add((Float) ((LazyLayoutSemanticsModifierNode$$ExternalSyntheticLambda1) obj2).invoke());
                return true;
            case 7:
                TypefaceRequest typefaceRequest = (TypefaceRequest) obj;
                return ((FontFamilyResolverImpl) obj2).resolve(new TypefaceRequest(null, typefaceRequest.fontWeight, typefaceRequest.fontStyle, typefaceRequest.fontSynthesis, typefaceRequest.resourceLoaderCacheKey)).getValue();
            case 8:
                EditCommand editCommand = (EditCommand) obj;
                String str2 = ((EditCommand) obj2) == editCommand ? " > " : "   ";
                if (!(editCommand instanceof CommitTextCommand)) {
                    if (editCommand instanceof SetComposingTextCommand) {
                        SetComposingTextCommand setComposingTextCommand = (SetComposingTextCommand) editCommand;
                        length = setComposingTextCommand.annotatedString.text.length();
                        i = setComposingTextCommand.newCursorPosition;
                        str = "SetComposingTextCommand(text.length=";
                    } else if (editCommand instanceof SetComposingRegionCommand) {
                        strConcat = ((SetComposingRegionCommand) editCommand).toString();
                    } else if (editCommand instanceof DeleteSurroundingTextCommand) {
                        strConcat = ((DeleteSurroundingTextCommand) editCommand).toString();
                    } else if (editCommand instanceof DeleteSurroundingTextInCodePointsCommand) {
                        strConcat = ((DeleteSurroundingTextInCodePointsCommand) editCommand).toString();
                    } else if (editCommand instanceof SetSelectionCommand) {
                        strConcat = ((SetSelectionCommand) editCommand).toString();
                    } else if (editCommand instanceof FinishComposingTextCommand) {
                        strConcat = "FinishComposingTextCommand()";
                    } else if (editCommand instanceof DeleteAllCommand) {
                        strConcat = "DeleteAllCommand()";
                    } else {
                        String simpleName = Reflection.getOrCreateKotlinClass(editCommand.getClass()).getSimpleName();
                        if (simpleName == null) {
                            simpleName = "{anonymous EditCommand}";
                        }
                        strConcat = "Unknown EditCommand: ".concat(simpleName);
                    }
                    return str2.concat(strConcat);
                }
                CommitTextCommand commitTextCommand = (CommitTextCommand) editCommand;
                length = commitTextCommand.annotatedString.text.length();
                i = commitTextCommand.newCursorPosition;
                str = "CommitTextCommand(text.length=";
                strConcat = IntIntPair$$ExternalSyntheticOutline0.m(length, str, ", newCursorPosition=", i, ")");
                return str2.concat(strConcat);
            case 9:
                ((LayoutNode) obj2).setDensity((Density) obj);
                return unit;
            case 10:
                BringIntoViewNode bringIntoViewNode = (BringIntoViewNode) obj2;
                Rect rect = (Rect) obj;
                if (bringIntoViewNode.isAttached) {
                    AwaitKt.launch$default(bringIntoViewNode.getCoroutineScope(), null, null, new SliderState.AnonymousClass2(bringIntoViewNode, rect, continuation, (byte) 29), 3);
                }
                return unit;
            case 11:
                DataStoreImpl dataStoreImpl = (DataStoreImpl) obj2;
                SynchronizedLazyImpl synchronizedLazyImpl = dataStoreImpl.storageConnectionDelegate;
                Throwable th = (Throwable) obj;
                if (th != null) {
                    dataStoreImpl.inMemoryCache.tryUpdate(new Final(th));
                }
                if (synchronizedLazyImpl.isInitialized()) {
                    ((FileStorageConnection) synchronizedLazyImpl.getValue()).close();
                }
                return unit;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                Navigator navigator = (Navigator) obj2;
                NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj;
                navBackStackEntry.getClass();
                NavBackStackEntryImpl navBackStackEntryImpl = navBackStackEntry.impl;
                NavDestination navDestination = navBackStackEntry.destination;
                if (navDestination == null) {
                    navDestination = null;
                }
                if (navDestination != null) {
                    navBackStackEntryImpl.getArguments$navigation_common_release();
                    NavDestination navDestinationNavigate = navigator.navigate(navDestination);
                    if (navDestinationNavigate != null) {
                        return navDestinationNavigate.equals(navDestination) ? navBackStackEntry : navigator.getState().createBackStackEntry(navDestinationNavigate, navDestinationNavigate.addInDefaultArgs(navBackStackEntryImpl.getArguments$navigation_common_release()));
                    }
                }
                return null;
            case 13:
                Bundle bundle2 = (Bundle) obj;
                NavHostController navHostControllerCreateNavController$NavHostControllerKt__NavHostController_androidKt = MathKt.createNavController$NavHostControllerKt__NavHostController_androidKt((Context) obj2);
                if (bundle2 != null) {
                    bundle2.setClassLoader(navHostControllerCreateNavController$NavHostControllerKt__NavHostController_androidKt.context.getClassLoader());
                }
                NavControllerImpl navControllerImpl = navHostControllerCreateNavController$NavHostControllerKt__NavHostController_androidKt.impl;
                LinkedHashMap linkedHashMap = navControllerImpl.backStackStates;
                if (bundle2 == null) {
                    r16 = 0;
                } else {
                    if (bundle2.containsKey("android-support-nav:controller:navigatorState")) {
                        bundle = bundle2.getBundle("android-support-nav:controller:navigatorState");
                        if (bundle == null) {
                            FileSystemsKt.keyOrValueNotFoundError("android-support-nav:controller:navigatorState");
                            throw null;
                        }
                    } else {
                        bundle = null;
                    }
                    navControllerImpl.navigatorStateToRestore = bundle;
                    navControllerImpl.backStackToRestore = bundle2.containsKey("android-support-nav:controller:backStack") ? (Bundle[]) MathKt.m1877getSavedStateListimpl("android-support-nav:controller:backStack", bundle2).toArray(new Bundle[0]) : null;
                    linkedHashMap.clear();
                    if (bundle2.containsKey("android-support-nav:controller:backStackDestIds") && bundle2.containsKey("android-support-nav:controller:backStackIds")) {
                        int[] intArray = bundle2.getIntArray("android-support-nav:controller:backStackDestIds");
                        if (intArray == null) {
                            FileSystemsKt.keyOrValueNotFoundError("android-support-nav:controller:backStackDestIds");
                            throw null;
                        }
                        ArrayList<String> stringArrayList = bundle2.getStringArrayList("android-support-nav:controller:backStackIds");
                        if (stringArrayList == null) {
                            FileSystemsKt.keyOrValueNotFoundError("android-support-nav:controller:backStackIds");
                            throw null;
                        }
                        int length2 = intArray.length;
                        int i4 = 0;
                        int i5 = 0;
                        while (i4 < length2) {
                            int i6 = i5 + 1;
                            Continuation continuation2 = continuation;
                            navControllerImpl.backStackMap.put(Integer.valueOf(intArray[i4]), !Intrinsics.areEqual(stringArrayList.get(i5), "") ? (String) stringArrayList.get(i5) : continuation2);
                            i4++;
                            i5 = i6;
                            continuation = continuation2;
                        }
                    }
                    r16 = continuation;
                    if (bundle2.containsKey("android-support-nav:controller:backStackStates")) {
                        ArrayList<String> stringArrayList2 = bundle2.getStringArrayList("android-support-nav:controller:backStackStates");
                        if (stringArrayList2 == null) {
                            FileSystemsKt.keyOrValueNotFoundError("android-support-nav:controller:backStackStates");
                            throw r16;
                        }
                        int size = stringArrayList2.size();
                        int i7 = 0;
                        while (i7 < size) {
                            String str3 = stringArrayList2.get(i7);
                            i7++;
                            String str4 = str3;
                            if (bundle2.containsKey("android-support-nav:controller:backStackStates:" + str4)) {
                                ArrayList arrayListM1877getSavedStateListimpl = MathKt.m1877getSavedStateListimpl("android-support-nav:controller:backStackStates:" + str4, bundle2);
                                ArrayDeque arrayDeque = new ArrayDeque(arrayListM1877getSavedStateListimpl.size());
                                int size2 = arrayListM1877getSavedStateListimpl.size();
                                int i8 = 0;
                                while (i8 < size2) {
                                    Object obj3 = arrayListM1877getSavedStateListimpl.get(i8);
                                    i8++;
                                    arrayDeque.addLast(new NavBackStackEntryState((Bundle) obj3));
                                }
                                linkedHashMap.put(str4, arrayDeque);
                            }
                        }
                    }
                }
                if (bundle2 != null) {
                    boolean z = bundle2.getBoolean("android-support-nav:controller:deepLinkHandled", false);
                    ?? ValueOf = (z || !bundle2.getBoolean("android-support-nav:controller:deepLinkHandled", true)) ? Boolean.valueOf(z) : r16;
                    navHostControllerCreateNavController$NavHostControllerKt__NavHostController_androidKt.deepLinkHandled = ValueOf != 0 ? ValueOf.booleanValue() : false;
                }
                return navHostControllerCreateNavController$NavHostControllerKt__NavHostController_androidKt;
            case 14:
                FrameworkSQLiteDatabase frameworkSQLiteDatabase = (FrameworkSQLiteDatabase) obj;
                frameworkSQLiteDatabase.getClass();
                ((FileMetadata) obj2).extras = frameworkSQLiteDatabase;
                return unit;
            case 15:
                ((SQLiteConnection) obj).getClass();
                ((RoomDatabase$$ExternalSyntheticLambda0) obj2).invoke();
                return unit;
            case 16:
                SQLiteStatement sQLiteStatement = (SQLiteStatement) obj;
                sQLiteStatement.getClass();
                ((DiskLruCache$$ExternalSyntheticLambda0) obj2).invoke(new BindOnlySQLiteStatement(sQLiteStatement, (byte) 0));
                return unit;
            case 17:
                RoomSQLiteQuery roomSQLiteQuery = (RoomSQLiteQuery) obj2;
                SQLiteStatement sQLiteStatement2 = (SQLiteStatement) obj;
                sQLiteStatement2.getClass();
                int i9 = roomSQLiteQuery.argCount;
                if (1 <= i9) {
                    int i10 = 1;
                    while (true) {
                        int i11 = roomSQLiteQuery.bindingTypes[i10];
                        if (i11 == 1) {
                            sQLiteStatement2.bindNull(i10);
                        } else if (i11 == 2) {
                            sQLiteStatement2.bindLong(i10, roomSQLiteQuery.longBindings[i10]);
                        } else if (i11 == 3) {
                            sQLiteStatement2.bindDouble(i10, roomSQLiteQuery.doubleBindings[i10]);
                        } else if (i11 == 4) {
                            String str5 = roomSQLiteQuery.stringBindings[i10];
                            if (str5 == null) {
                                _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Required value was null.");
                                return null;
                            }
                            sQLiteStatement2.bindText(i10, str5);
                        } else if (i11 == 5) {
                            byte[] bArr = roomSQLiteQuery.blobBindings[i10];
                            if (bArr == null) {
                                _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Required value was null.");
                                return null;
                            }
                            sQLiteStatement2.bindBlob(bArr, i10);
                        }
                        if (i10 != i9) {
                            i10++;
                        }
                    }
                }
                return unit;
            case 18:
                QuickJs.evalAndAwait$lambda$0$0((QuickJs) obj2, (Throwable) obj);
                return unit;
            case 19:
                return Boolean.valueOf(QuickJs.invokeAsyncFunction$lambda$1$0$0((Job) obj2, (QuickJs.AsyncJob) obj));
            case 20:
                InnerTube.SessionSnapshot sessionSnapshot = (InnerTube.SessionSnapshot) obj2;
                HeadersBuilder headersBuilder = (HeadersBuilder) obj;
                headersBuilder.getClass();
                headersBuilder.append("X-Goog-Api-Format-Version", "1");
                YouTubeClient.INSTANCE.getClass();
                YouTubeClient youTubeClient = YouTubeClient.WEB_REMIX;
                headersBuilder.append("X-YouTube-Client-Name", youTubeClient.clientId);
                headersBuilder.append("X-YouTube-Client-Version", youTubeClient.clientVersion);
                headersBuilder.append(HttpHeaders.Origin, "https://music.youtube.com");
                headersBuilder.append("X-Origin", "https://music.youtube.com");
                headersBuilder.append(HttpHeaders.Referrer, "https://music.youtube.com/");
                headersBuilder.append("X-Goog-AuthUser", sessionSnapshot.authUser);
                YouTubeLocale youTubeLocale = sessionSnapshot.locale;
                headersBuilder.append(HttpHeaders.AcceptLanguage, youTubeLocale.acceptLanguageHeader$com_github_MetrolistGroup_innertubex());
                String str6 = sessionSnapshot.visitorData;
                if (str6 != null) {
                    headersBuilder.append("X-Goog-Visitor-Id", str6);
                }
                headersBuilder.append(HttpHeaders.Cookie, UuidKt.injectPrefCookie(sessionSnapshot.cookie, youTubeLocale.hl, youTubeLocale.gl));
                String str7 = sessionSnapshot.sapisid;
                if (str7 != null) {
                    long epochMilliseconds = InstantJvmKt.systemClock.now().toEpochMilliseconds() / 1000;
                    String strSha1 = CharsKt.sha1(epochMilliseconds + ServerSentEventKt.SPACE + str7 + " https://music.youtube.com");
                    StringBuilder sb = new StringBuilder("SAPISIDHASH ");
                    sb.append(epochMilliseconds);
                    sb.append("_");
                    sb.append(strSha1);
                    string = sb.toString();
                }
                if (string != null) {
                    headersBuilder.append(HttpHeaders.Authorization, string);
                }
                return unit;
            case 21:
                String str8 = (String) obj;
                int i12 = MainActivity.$r8$clinit;
                str8.getClass();
                ((MainActivity) obj2).latestVersionName$delegate.setValue(str8);
                return unit;
            case 22:
                Listentogether.TrackInfo trackInfo = (Listentogether.TrackInfo) obj;
                trackInfo.getClass();
                return Boolean.valueOf(!Intrinsics.areEqual(trackInfo.getId(), ((Listentogether.TrackInfo) obj2).getId()));
            case 23:
                Float f = (Float) obj;
                f.getClass();
                StateFlowImpl stateFlowImpl = ((MusicService) obj2).sleepTimerVolumeMultiplier;
                stateFlowImpl.getClass();
                stateFlowImpl.updateState(null, f);
                return unit;
            case 24:
                Set set = (Set) obj2;
                String str9 = (String) obj;
                str9.getClass();
                if (str9.length() < 4) {
                    zContains = set.contains(str9);
                } else {
                    Set set2 = set;
                    if (!(set2 instanceof Collection) || !set2.isEmpty()) {
                        Iterator it = set2.iterator();
                        while (it.hasNext()) {
                            if (VoiceSearchMatcher.jaroWinkler$app(str9, (String) it.next()) >= 0.85d) {
                                zContains = true;
                            }
                        }
                    }
                }
                return Boolean.valueOf(zContains);
            case 25:
                DrawScope drawScope2 = (DrawScope) obj;
                drawScope2.getClass();
                DrawScope.m549drawRectAsUm42w$default(drawScope2, (ShaderBrush) obj2, 0L, 0L, 0.05f, null, null, 0, 118);
                return unit;
            case 26:
                DrawScope drawScope3 = (DrawScope) obj;
                drawScope3.getClass();
                DrawScope.m549drawRectAsUm42w$default(drawScope3, (LinearGradient) obj2, 0L, 0L, CropImageView.DEFAULT_ASPECT_RATIO, null, null, 0, 126);
                return unit;
            case 27:
                SoftwareKeyboardController softwareKeyboardController = (SoftwareKeyboardController) obj2;
                ((KeyboardActionRunner) obj).getClass();
                if (softwareKeyboardController != null) {
                    ((DelegatingSoftwareKeyboardController) softwareKeyboardController).hide();
                }
                return unit;
            case 28:
                MusicDatabase musicDatabase = (MusicDatabase) obj;
                musicDatabase.getClass();
                musicDatabase.$$delegate_0.update(((Artist) obj2).artist.toggleLike());
                return unit;
            default:
                MusicDatabase musicDatabase2 = (MusicDatabase) obj;
                musicDatabase2.getClass();
                musicDatabase2.$$delegate_0.insert((PlaylistEntity) obj2);
                return unit;
        }
    }

    public /* synthetic */ DiskLruCache$$ExternalSyntheticLambda0(Object obj, Object obj2, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
    }
}
