package com.dokar.quickjs;

import android.content.Context;
import android.net.Uri;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.animation.core.Animatable;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.foundation.gestures.AnchoredDraggableState$$ExternalSyntheticLambda1;
import androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDragScope$1;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.State;
import androidx.compose.ui.node.NodeChain;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.navigation.NavDeepLinkRequest;
import androidx.navigation.NavHostController;
import androidx.room.Transactor;
import androidx.room.coroutines.PassthroughConnection;
import coil3.RealImageLoader;
import coil3.disk.DiskLruCache$$ExternalSyntheticLambda0;
import com.dokar.quickjs.binding.AsyncFunctionBinding;
import com.dokar.quickjs.binding.FunctionBinding;
import com.dokar.quickjs.binding.JsFunction;
import com.dokar.quickjs.binding.JsProperty;
import com.dokar.quickjs.binding.ObjectBinding;
import com.dokar.quickjs.converter.TypeConverter;
import com.dokar.quickjs.converter.TypeConverters;
import com.dokar.quickjs.internal.BindingCallbackContext_jniKt;
import com.metrolist.music.db.DatabaseDao;
import com.metrolist.music.db.DatabaseDao$$ExternalSyntheticLambda0;
import com.metrolist.music.db.DatabaseDao_Impl;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.Playlist;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.ui.component.BottomSheetState;
import com.metrolist.music.utils.SyncUtils;
import io.ktor.http.ContentDisposition;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.io.Closeable;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.UByteArray;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.ReversedList;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobImpl;
import kotlinx.coroutines.StandaloneCoroutine;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexImpl;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000¬\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0003\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u0000 \u0085\u00022\u00020\u0001:\b\u0086\u0002\u0087\u0002\u0088\u0002\u0085\u0002B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ)\u0010\u000f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u000b2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00028\u00000\fH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u0012\u001a\u00020\b2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\b0\fH\u0007¢\u0006\u0004\b\u0012\u0010\u0013J1\u0010\u0017\u001a\u00020\b2\"\u0010\u0016\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00150\u0014\"\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0015¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010!\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\b\b\u0002\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J)\u0010!\u001a\u00020\b\"\u0004\b\u0000\u0010\"2\u0006\u0010\u001a\u001a\u00020\u00192\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000#¢\u0006\u0004\b!\u0010$J)\u0010!\u001a\u00020\b\"\u0004\b\u0000\u0010\"2\u0006\u0010\u001a\u001a\u00020\u00192\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000%¢\u0006\u0004\b!\u0010&J\u001d\u0010(\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010'\u001a\u00020\u0019¢\u0006\u0004\b(\u0010)J\u0015\u0010(\u001a\u00020\b2\u0006\u0010+\u001a\u00020*¢\u0006\u0004\b(\u0010,J)\u00100\u001a\u00020*2\u0006\u0010'\u001a\u00020\u00192\b\b\u0002\u0010-\u001a\u00020\u00192\b\b\u0002\u0010/\u001a\u00020.¢\u0006\u0004\b0\u00101J\u001b\u00104\u001a\b\u0012\u0004\u0012\u00020\u0019032\u0006\u00102\u001a\u00020*¢\u0006\u0004\b4\u00105J \u00106\u001a\u00028\u0000\"\u0006\b\u0000\u0010\u000b\u0018\u00012\u0006\u0010+\u001a\u00020*H\u0086H¢\u0006\u0004\b6\u00107J4\u00106\u001a\u00028\u0000\"\u0006\b\u0000\u0010\u000b\u0018\u00012\u0006\u0010'\u001a\u00020\u00192\b\b\u0002\u0010-\u001a\u00020\u00192\b\b\u0002\u0010/\u001a\u00020.H\u0086H¢\u0006\u0004\b6\u00108J\u001a\u00109\u001a\u0004\u0018\u00010\u001d2\u0006\u0010+\u001a\u00020*H\u0081@¢\u0006\u0004\b9\u00107J*\u00109\u001a\u0004\u0018\u00010\u001d2\u0006\u0010'\u001a\u00020\u00192\u0006\u0010-\u001a\u00020\u00192\u0006\u0010/\u001a\u00020.H\u0081@¢\u0006\u0004\b9\u00108J\r\u0010:\u001a\u00020\b¢\u0006\u0004\b:\u0010\nJ\u000f\u0010;\u001a\u00020\bH\u0016¢\u0006\u0004\b;\u0010\nJM\u0010A\u001a\u00020\b2\u000e\u0010<\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u00142,\u0010\u000e\u001a(\b\u0001\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u0014\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u001d0>\u0012\u0006\u0012\u0004\u0018\u00010\u001d0=H\u0000¢\u0006\u0004\b?\u0010@J0\u0010D\u001a\u0004\u0018\u00010\u001d2\u001c\u0010C\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020B0>\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\fH\u0082@¢\u0006\u0004\bD\u0010EJ@\u0010I\u001a\u0004\u0018\u00010\u001d2\u0006\u0010G\u001a\u00020F2\u0006\u0010H\u001a\u00020.2\u001c\u0010C\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020B0>\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\fH\u0082@¢\u0006\u0004\bI\u0010JJ\u000f\u0010K\u001a\u00020\bH\u0002¢\u0006\u0004\bK\u0010\nJ\u0017\u0010M\u001a\u00020\b2\u0006\u0010L\u001a\u00020BH\u0002¢\u0006\u0004\bM\u0010NJ\u000f\u0010O\u001a\u00020.H\u0002¢\u0006\u0004\bO\u0010PJ$\u0010R\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000QH\u0082\b¢\u0006\u0004\bR\u0010SJ(\u0010V\u001a\u00020\b2\u0006\u0010G\u001a\u00020F2\u0006\u0010U\u001a\u00020T2\u0006\u0010H\u001a\u00020.H\u0082@¢\u0006\u0004\bV\u0010WJ'\u0010X\u001a\u00020\b2\u0006\u0010G\u001a\u00020F2\u0006\u0010U\u001a\u00020T2\u0006\u0010H\u001a\u00020.H\u0002¢\u0006\u0004\bX\u0010YJ\u000f\u0010Z\u001a\u00020.H\u0002¢\u0006\u0004\bZ\u0010PJ\u001f\u0010]\u001a\u00020\u00192\u0006\u0010[\u001a\u00020\u00192\u0006\u0010\\\u001a\u00020\u0019H\u0002¢\u0006\u0004\b]\u0010^J\u0019\u0010_\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b_\u0010`J\u0019\u0010b\u001a\u0004\u0018\u00010\u00192\u0006\u0010a\u001a\u00020\u001dH\u0002¢\u0006\u0004\bb\u0010cJ\u0019\u0010d\u001a\u0004\u0018\u00010*2\u0006\u0010a\u001a\u00020\u001dH\u0002¢\u0006\u0004\bd\u0010eJ\u001f\u0010f\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010+\u001a\u00020*H\u0002¢\u0006\u0004\bf\u0010gJ\u0017\u0010h\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\bh\u0010iJ\u0018\u0010j\u001a\u00020\b2\u0006\u0010G\u001a\u00020FH\u0082@¢\u0006\u0004\bj\u0010kJ+\u0010m\u001a\u000e\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020B0l2\u000e\u0010<\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u0014H\u0002¢\u0006\u0004\bm\u0010nJ!\u0010p\u001a\u0004\u0018\u00010\u001d2\u0006\u0010o\u001a\u00020B2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\bp\u0010qJ)\u0010s\u001a\u00020\b2\u0006\u0010o\u001a\u00020B2\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010r\u001a\u0004\u0018\u00010\u001dH\u0002¢\u0006\u0004\bs\u0010tJ1\u0010u\u001a\u0004\u0018\u00010\u001d2\u0006\u0010o\u001a\u00020B2\u0006\u0010\u001a\u001a\u00020\u00192\u000e\u0010<\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u0014H\u0002¢\u0006\u0004\bu\u0010vJ\u0017\u0010y\u001a\u00020\b2\u0006\u0010x\u001a\u00020wH\u0002¢\u0006\u0004\by\u0010zJ!\u0010}\u001a\u00020\b2\u0006\u0010{\u001a\u00020B2\b\u0010|\u001a\u0004\u0018\u00010\u001dH\u0002¢\u0006\u0004\b}\u0010~J\u0017\u0010\u007f\u001a\u00020\b2\u0006\u0010{\u001a\u00020BH\u0002¢\u0006\u0004\b\u007f\u0010NJ7\u0010\u0080\u0001\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u000b2\u0006\u0010G\u001a\u00020F2\u0006\u0010U\u001a\u00020T2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000QH\u0082\b¢\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001J/\u0010\u0082\u0001\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u000b2\u0006\u0010G\u001a\u00020F2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000QH\u0082\b¢\u0006\u0006\b\u0082\u0001\u0010\u0083\u0001J\u0011\u0010\u0084\u0001\u001a\u00020\bH\u0002¢\u0006\u0005\b\u0084\u0001\u0010\nJ\u0011\u0010\u0085\u0001\u001a\u00020\bH\u0002¢\u0006\u0005\b\u0085\u0001\u0010\nJ\u0013\u0010\u0086\u0001\u001a\u00020BH\u0082 ¢\u0006\u0006\b\u0086\u0001\u0010\u0087\u0001J\u001c\u0010\u0089\u0001\u001a\u00020B2\u0007\u0010\u0088\u0001\u001a\u00020BH\u0082 ¢\u0006\u0006\b\u0089\u0001\u0010\u008a\u0001J9\u0010\u008e\u0001\u001a\u00020B2\u0007\u0010\u0088\u0001\u001a\u00020B2\u0012\u0010\u008c\u0001\u001a\r\u0012\t\u0012\u0007\u0012\u0002\b\u00030\u008b\u00010\u00142\u0007\u0010\u008d\u0001\u001a\u00020.H\u0082 ¢\u0006\u0006\b\u008e\u0001\u0010\u008f\u0001J%\u0010\u0092\u0001\u001a\u00020\b2\u0007\u0010\u0090\u0001\u001a\u00020B2\u0007\u0010\u0091\u0001\u001a\u00020BH\u0082 ¢\u0006\u0006\b\u0092\u0001\u0010\u0093\u0001J\u001b\u0010\u0094\u0001\u001a\u00020\b2\u0007\u0010\u0088\u0001\u001a\u00020BH\u0082 ¢\u0006\u0005\b\u0094\u0001\u0010NJ\u001b\u0010\u0095\u0001\u001a\u00020\b2\u0007\u0010\u0090\u0001\u001a\u00020BH\u0082 ¢\u0006\u0005\b\u0095\u0001\u0010NJU\u0010\u009a\u0001\u001a\u00020B2\u0007\u0010\u0091\u0001\u001a\u00020B2\u0007\u0010\u0090\u0001\u001a\u00020B2\u0006\u0010\u001e\u001a\u00020B2\u0006\u0010\u001a\u001a\u00020\u00192\u000e\u0010\u0097\u0001\u001a\t\u0012\u0005\u0012\u00030\u0096\u00010\u00142\u000e\u0010\u0099\u0001\u001a\t\u0012\u0005\u0012\u00030\u0098\u00010\u0014H\u0082 ¢\u0006\u0006\b\u009a\u0001\u0010\u009b\u0001J6\u0010\u009d\u0001\u001a\u00020\b2\u0007\u0010\u0091\u0001\u001a\u00020B2\u0007\u0010\u0090\u0001\u001a\u00020B2\u0006\u0010\u001a\u001a\u00020\u00192\u0007\u0010\u009c\u0001\u001a\u00020.H\u0082 ¢\u0006\u0006\b\u009d\u0001\u0010\u009e\u0001J#\u0010:\u001a\u00020\b2\u0007\u0010\u0088\u0001\u001a\u00020B2\u0007\u0010\u0091\u0001\u001a\u00020BH\u0082 ¢\u0006\u0005\b:\u0010\u0093\u0001J\u0013\u0010\u009f\u0001\u001a\u00020\u0019H\u0082 ¢\u0006\u0006\b\u009f\u0001\u0010 \u0001J.\u0010¢\u0001\u001a\u00020\b2\u0007\u0010\u0088\u0001\u001a\u00020B2\u0007\u0010\u0091\u0001\u001a\u00020B2\u0007\u0010¡\u0001\u001a\u00020BH\u0082 ¢\u0006\u0006\b¢\u0001\u0010£\u0001J.\u0010¤\u0001\u001a\u00020\b2\u0007\u0010\u0088\u0001\u001a\u00020B2\u0007\u0010\u0091\u0001\u001a\u00020B2\u0007\u0010¡\u0001\u001a\u00020BH\u0082 ¢\u0006\u0006\b¤\u0001\u0010£\u0001J\u001c\u0010¥\u0001\u001a\u00020B2\u0007\u0010\u0088\u0001\u001a\u00020BH\u0082 ¢\u0006\u0006\b¥\u0001\u0010\u008a\u0001J%\u0010§\u0001\u001a\u00020\b2\u0007\u0010\u0088\u0001\u001a\u00020B2\u0007\u0010¦\u0001\u001a\u00020BH\u0082 ¢\u0006\u0006\b§\u0001\u0010\u0093\u0001J\u001b\u0010¨\u0001\u001a\u00020\b2\u0007\u0010¦\u0001\u001a\u00020BH\u0082 ¢\u0006\u0005\b¨\u0001\u0010NJ\u001b\u0010©\u0001\u001a\u00020\b2\u0007\u0010\u0088\u0001\u001a\u00020BH\u0082 ¢\u0006\u0005\b©\u0001\u0010NJ$\u0010ª\u0001\u001a\u00020\b2\u0007\u0010¦\u0001\u001a\u00020B2\u0006\u0010L\u001a\u00020BH\u0082 ¢\u0006\u0006\bª\u0001\u0010\u0093\u0001J\u001a\u0010O\u001a\u00020.2\u0007\u0010¦\u0001\u001a\u00020BH\u0082 ¢\u0006\u0005\bO\u0010«\u0001J&\u0010\u00ad\u0001\u001a\u00030¬\u00012\u0007\u0010\u0088\u0001\u001a\u00020B2\u0007\u0010\u0091\u0001\u001a\u00020BH\u0082 ¢\u0006\u0006\b\u00ad\u0001\u0010®\u0001J;\u00100\u001a\u00020*2\u0007\u0010\u0090\u0001\u001a\u00020B2\u0007\u0010\u0091\u0001\u001a\u00020B2\u0006\u0010-\u001a\u00020\u00192\u0006\u0010'\u001a\u00020\u00192\u0006\u0010/\u001a\u00020.H\u0082 ¢\u0006\u0005\b0\u0010¯\u0001J-\u0010°\u0001\u001a\u00020\u00192\u0007\u0010\u0088\u0001\u001a\u00020B2\u0007\u0010\u0091\u0001\u001a\u00020B2\u0006\u0010+\u001a\u00020*H\u0082 ¢\u0006\u0006\b°\u0001\u0010±\u0001J;\u00106\u001a\u00020B2\u0007\u0010\u0090\u0001\u001a\u00020B2\u0007\u0010\u0091\u0001\u001a\u00020B2\u0006\u0010-\u001a\u00020\u00192\u0006\u0010'\u001a\u00020\u00192\u0006\u0010/\u001a\u00020.H\u0082 ¢\u0006\u0005\b6\u0010²\u0001J.\u0010´\u0001\u001a\u00020B2\u0007\u0010\u0090\u0001\u001a\u00020B2\u0007\u0010\u0091\u0001\u001a\u00020B2\u0007\u0010³\u0001\u001a\u00020*H\u0082 ¢\u0006\u0006\b´\u0001\u0010µ\u0001J?\u0010¶\u0001\u001a\u00020\b2\u0007\u0010\u0090\u0001\u001a\u00020B2\u0007\u0010\u0091\u0001\u001a\u00020B2\u0006\u0010o\u001a\u00020B2\u0010\u0010<\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001d\u0018\u00010\u0014H\u0082 ¢\u0006\u0006\b¶\u0001\u0010·\u0001J%\u0010¸\u0001\u001a\u00020.2\u0007\u0010\u0090\u0001\u001a\u00020B2\u0007\u0010\u0091\u0001\u001a\u00020BH\u0082 ¢\u0006\u0006\b¸\u0001\u0010¹\u0001J/\u0010º\u0001\u001a\u0004\u0018\u00010\u001d2\u0007\u0010\u0090\u0001\u001a\u00020B2\u0007\u0010\u0091\u0001\u001a\u00020B2\u0006\u0010o\u001a\u00020BH\u0082 ¢\u0006\u0006\bº\u0001\u0010»\u0001J-\u0010¼\u0001\u001a\u00020.2\u0007\u0010\u0090\u0001\u001a\u00020B2\u0007\u0010\u0091\u0001\u001a\u00020B2\u0006\u0010o\u001a\u00020BH\u0082 ¢\u0006\u0006\b¼\u0001\u0010½\u0001J-\u0010¾\u0001\u001a\u00020B2\u0007\u0010\u0090\u0001\u001a\u00020B2\u0007\u0010\u0091\u0001\u001a\u00020B2\u0006\u0010o\u001a\u00020BH\u0082 ¢\u0006\u0006\b¾\u0001\u0010¿\u0001J-\u0010À\u0001\u001a\u00020\b2\u0007\u0010\u0090\u0001\u001a\u00020B2\u0007\u0010\u0091\u0001\u001a\u00020B2\u0006\u0010o\u001a\u00020BH\u0082 ¢\u0006\u0006\bÀ\u0001\u0010£\u0001R\u0015\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0003\u0010Á\u0001R\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0005\u0010Â\u0001R\u001a\u0010Ä\u0001\u001a\u0005\u0018\u00010Ã\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÄ\u0001\u0010Å\u0001R\u0019\u0010\u0091\u0001\u001a\u00020B8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0091\u0001\u0010Æ\u0001R\u0019\u0010\u0088\u0001\u001a\u00020B8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0088\u0001\u0010Æ\u0001R\u0019\u0010\u0090\u0001\u001a\u00020B8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0090\u0001\u0010Æ\u0001R\u0019\u0010Ç\u0001\u001a\u00020B8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÇ\u0001\u0010Æ\u0001R$\u0010É\u0001\u001a\u000f\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020\u001b0È\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÉ\u0001\u0010Ê\u0001R$\u0010Ë\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001d0È\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bË\u0001\u0010Ê\u0001R*\u0010Í\u0001\u001a\u0015\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\b0\f0Ì\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÍ\u0001\u0010Î\u0001R\u001e\u0010Ï\u0001\u001a\t\u0012\u0004\u0012\u00020*0Ì\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÏ\u0001\u0010Î\u0001R/\u0010Ò\u0001\u001a\u0018\u0012\u0004\u0012\u00020\u0019\u0018\u00010Ð\u0001j\u000b\u0012\u0004\u0012\u00020\u0019\u0018\u0001`Ñ\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÒ\u0001\u0010Ó\u0001R\u001b\u0010Ô\u0001\u001a\u0004\u0018\u00010w8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÔ\u0001\u0010Õ\u0001R\u001b\u0010Ö\u0001\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÖ\u0001\u0010×\u0001R\u001b\u0010Ø\u0001\u001a\u0004\u0018\u00010T8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bØ\u0001\u0010Ù\u0001R\u0018\u0010Û\u0001\u001a\u00030Ú\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÛ\u0001\u0010Ü\u0001R\u0018\u0010Þ\u0001\u001a\u00030Ý\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÞ\u0001\u0010ß\u0001R\u0018\u0010á\u0001\u001a\u00030à\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bá\u0001\u0010â\u0001R\u0018\u0010ã\u0001\u001a\u00030à\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bã\u0001\u0010â\u0001R\u0018\u0010ä\u0001\u001a\u00030à\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bä\u0001\u0010â\u0001R\u001e\u0010æ\u0001\u001a\t\u0012\u0004\u0012\u00020B0å\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bæ\u0001\u0010ç\u0001R\u0018\u0010è\u0001\u001a\u00030à\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bè\u0001\u0010â\u0001R\u001f\u0010ê\u0001\u001a\n\u0012\u0005\u0012\u00030é\u00010Ì\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bê\u0001\u0010Î\u0001R\u001e\u0010ì\u0001\u001a\t\u0012\u0004\u0012\u00020B0ë\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bì\u0001\u0010í\u0001R'\u0010ï\u0001\u001a\u00030î\u00018\u0000X\u0081\u0004¢\u0006\u0017\n\u0006\bï\u0001\u0010ð\u0001\u0012\u0005\bó\u0001\u0010\n\u001a\u0006\bñ\u0001\u0010ò\u0001R\u0018\u0010õ\u0001\u001a\u00030ô\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bõ\u0001\u0010ö\u0001R0\u0010÷\u0001\u001a\u00020B2\u0006\u0010r\u001a\u00020B8\u0006@FX\u0086\u000e¢\u0006\u0017\n\u0006\b÷\u0001\u0010Æ\u0001\u001a\u0006\bø\u0001\u0010\u0087\u0001\"\u0005\b¢\u0001\u0010NR0\u0010ù\u0001\u001a\u00020B2\u0006\u0010r\u001a\u00020B8\u0006@FX\u0086\u000e¢\u0006\u0017\n\u0006\bù\u0001\u0010Æ\u0001\u001a\u0006\bú\u0001\u0010\u0087\u0001\"\u0005\b¤\u0001\u0010NR(\u0010û\u0001\u001a\u00020B8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\bû\u0001\u0010Æ\u0001\u001a\u0006\bü\u0001\u0010\u0087\u0001\"\u0005\bý\u0001\u0010NR(\u0010þ\u0001\u001a\u00020.2\u0006\u0010r\u001a\u00020.8F@BX\u0086\u000e¢\u0006\u000f\u001a\u0005\bþ\u0001\u0010P\"\u0006\bÿ\u0001\u0010\u0080\u0002R\u0014\u0010\u0082\u0002\u001a\u00020\u00198F¢\u0006\b\u001a\u0006\b\u0081\u0002\u0010 \u0001R\u0015\u0010\u0084\u0002\u001a\u00030¬\u00018F¢\u0006\b\u001a\u0006\b\u00ad\u0001\u0010\u0083\u0002¨\u0006\u0089\u0002"}, d2 = {"Lcom/dokar/quickjs/QuickJs;", "Ljava/io/Closeable;", "Lkotlinx/coroutines/CoroutineDispatcher;", "jobDispatcher", "Lcom/dokar/quickjs/ModuleLoader;", "moduleLoader", "<init>", "(Lkotlinx/coroutines/CoroutineDispatcher;Lcom/dokar/quickjs/ModuleLoader;)V", "", "interruptEvaluation", "()V", "T", "Lkotlin/Function1;", "Lcom/dokar/quickjs/NativeLibraryLoader;", "block", "withNativeContext", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "cleanup", "onNativeClose", "(Lkotlin/jvm/functions/Function1;)V", "", "Lcom/dokar/quickjs/converter/TypeConverter;", "converters", "addTypeConverters", "([Lcom/dokar/quickjs/converter/TypeConverter;)V", "", ContentDisposition.Parameters.Name, "Lcom/dokar/quickjs/binding/ObjectBinding;", "binding", "", "parent", "defineBinding-NW8rdx8", "(Ljava/lang/String;Lcom/dokar/quickjs/binding/ObjectBinding;J)J", "defineBinding", "R", "Lcom/dokar/quickjs/binding/FunctionBinding;", "(Ljava/lang/String;Lcom/dokar/quickjs/binding/FunctionBinding;)V", "Lcom/dokar/quickjs/binding/AsyncFunctionBinding;", "(Ljava/lang/String;Lcom/dokar/quickjs/binding/AsyncFunctionBinding;)V", "code", "addModule", "(Ljava/lang/String;Ljava/lang/String;)V", "", "bytecode", "([B)V", ContentDisposition.Parameters.FileName, "", "asModule", "compile", "(Ljava/lang/String;Ljava/lang/String;Z)[B", "entryBytecode", "", "resolveModuleGraph", "([B)Ljava/util/Set;", "evaluate", "([BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Ljava/lang/String;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "evaluateInternal", "gc", "close", "args", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "invokeAsyncFunction$quickjs_kt_quickjs_release", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "invokeAsyncFunction", "", "evalBlock", "evalAndAwait", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/dokar/quickjs/QuickJs$EvaluationSession;", "session", "isRoot", "evalInSession", "(Lcom/dokar/quickjs/QuickJs$EvaluationSession;ZLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestInterruptIfOpen", "timeoutMillis", "resetInterruptState", "(J)V", "wasInterrupted", "()Z", "Lkotlin/Function0;", "withJsLockSync", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Lcom/dokar/quickjs/QuickJs$EvaluationState;", "evaluation", "awaitEvaluateResult", "(Lcom/dokar/quickjs/QuickJs$EvaluationSession;Lcom/dokar/quickjs/QuickJs$EvaluationState;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleException", "(Lcom/dokar/quickjs/QuickJs$EvaluationSession;Lcom/dokar/quickjs/QuickJs$EvaluationState;Z)V", "hasModuleNormalizer", "baseName", "requestedName", "normalizeModule", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "loadModule", "(Ljava/lang/String;)Ljava/lang/Object;", "content", "getModuleSource", "(Ljava/lang/Object;)Ljava/lang/String;", "getModuleBytecode", "(Ljava/lang/Object;)[B", "onModuleCompiled", "(Ljava/lang/String;[B)V", "onModuleLoadFailed", "(Ljava/lang/String;)V", "loadModules", "(Lcom/dokar/quickjs/QuickJs$EvaluationSession;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Pair;", "promiseHandlesFromArgs", "([Ljava/lang/Object;)Lkotlin/Pair;", "handle", "onCallGetter", "(JLjava/lang/String;)Ljava/lang/Object;", "value", "onCallSetter", "(JLjava/lang/String;Ljava/lang/Object;)V", "onCallFunction", "(JLjava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;", "", "exception", "setEvalException", "(Ljava/lang/Throwable;)V", "promiseId", "reason", "setUnhandledPromiseRejection", "(JLjava/lang/Object;)V", "clearHandledPromiseRejection", "withEvaluation", "(Lcom/dokar/quickjs/QuickJs$EvaluationSession;Lcom/dokar/quickjs/QuickJs$EvaluationState;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "withEvaluationSession", "(Lcom/dokar/quickjs/QuickJs$EvaluationSession;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "signalRuntimeProgress", "ensureNotClosed", "newRuntime", "()J", "runtime", "newContext", "(J)J", "Ljava/lang/Class;", "classes", "enableModuleLoader", "initGlobals", "(J[Ljava/lang/Class;Z)J", "context", "globals", "releaseGlobals", "(JJ)V", "releaseRuntime", "releaseContext", "Lcom/dokar/quickjs/binding/JsProperty;", "properties", "Lcom/dokar/quickjs/binding/JsFunction;", "functions", "defineObject", "(JJJLjava/lang/String;[Lcom/dokar/quickjs/binding/JsProperty;[Lcom/dokar/quickjs/binding/JsFunction;)J", "isAsync", "defineFunction", "(JJLjava/lang/String;Z)V", "nativeGetVersion", "()Ljava/lang/String;", "byteCount", "setMemoryLimit", "(JJJ)V", "setMaxStackSize", "installInterrupt", "state", "freeInterrupt", "requestInterrupt", "updateStackTop", "resetInterrupt", "(J)Z", "Lcom/dokar/quickjs/MemoryUsage;", "getMemoryUsage", "(JJ)Lcom/dokar/quickjs/MemoryUsage;", "(JJLjava/lang/String;Ljava/lang/String;Z)[B", "resolveModuleGraphBytecode", "(JJ[B)Ljava/lang/String;", "(JJLjava/lang/String;Ljava/lang/String;Z)J", "buffer", "evaluateBytecode", "(JJ[B)J", "invokeJsFunction", "(JJJ[Ljava/lang/Object;)V", "executePendingJob", "(JJ)Z", "getEvaluateResult", "(JJJ)Ljava/lang/Object;", "isEvaluateResultPending", "(JJJ)Z", "getEvaluateResultPromiseId", "(JJJ)J", "releaseEvaluateResult", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lcom/dokar/quickjs/ModuleLoader;", "Lcom/dokar/quickjs/ModuleNormalizer;", "moduleNormalizer", "Lcom/dokar/quickjs/ModuleNormalizer;", "J", "interruptState", "", "objectBindings", "Ljava/util/Map;", "globalFunctions", "", "nativeCloseHandlers", "Ljava/util/List;", "modules", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "resolvingModuleNames", "Ljava/util/LinkedHashSet;", "evalException", "Ljava/lang/Throwable;", "currentEvaluationSession", "Lcom/dokar/quickjs/QuickJs$EvaluationSession;", "currentEvaluation", "Lcom/dokar/quickjs/QuickJs$EvaluationState;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/sync/Mutex;", "jsMutex", "Lkotlinx/coroutines/sync/Mutex;", "interruptMutex", "rootEvaluationMutex", "Lkotlinx/coroutines/flow/MutableStateFlow;", "runtimeProgress", "Lkotlinx/coroutines/flow/MutableStateFlow;", "jobsMutex", "Lcom/dokar/quickjs/QuickJs$AsyncJob;", "asyncJobs", "", "activeEvaluateResults", "Ljava/util/Set;", "Lcom/dokar/quickjs/converter/TypeConverters;", "typeConverters", "Lcom/dokar/quickjs/converter/TypeConverters;", "getTypeConverters", "()Lcom/dokar/quickjs/converter/TypeConverters;", "getTypeConverters$annotations", "Lkotlin/concurrent/atomics/AtomicBoolean;", "closed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "memoryLimit", "getMemoryLimit", "maxStackSize", "getMaxStackSize", "evaluationTimeoutMillis", "getEvaluationTimeoutMillis", "setEvaluationTimeoutMillis", "isClosed", "setClosed", "(Z)V", "getVersion", "version", "()Lcom/dokar/quickjs/MemoryUsage;", "memoryUsage", "Companion", "AsyncJob", "EvaluationState", "EvaluationSession", "quickjs-kt:quickjs_release"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class QuickJs implements Closeable {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    private final Set<Long> activeEvaluateResults;
    private final List<AsyncJob> asyncJobs;
    private final AtomicBoolean closed;
    private long context;
    private final CoroutineScope coroutineScope;
    private EvaluationState currentEvaluation;
    private EvaluationSession currentEvaluationSession;
    private Throwable evalException;
    private long evaluationTimeoutMillis;
    private final CoroutineExceptionHandler exceptionHandler;
    private final Map<String, Object> globalFunctions;
    private long globals;
    private final Mutex interruptMutex;
    private long interruptState;
    private final CoroutineDispatcher jobDispatcher;
    private final Mutex jobsMutex;
    private final Mutex jsMutex;
    private long maxStackSize;
    private long memoryLimit;
    private final ModuleLoader moduleLoader;
    private final ModuleNormalizer moduleNormalizer;
    private final List<byte[]> modules;
    private final List<Function1> nativeCloseHandlers;
    private final Map<Long, ObjectBinding> objectBindings;
    private LinkedHashSet<String> resolvingModuleNames;
    private final Mutex rootEvaluationMutex;
    private long runtime;
    private final MutableStateFlow runtimeProgress;
    private final TypeConverters typeConverters;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AsyncJob {
        public final StandaloneCoroutine job;
        public final EvaluationSession session;

        public AsyncJob(StandaloneCoroutine standaloneCoroutine, EvaluationSession evaluationSession) {
            evaluationSession.getClass();
            this.job = standaloneCoroutine;
            this.session = evaluationSession;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AsyncJob)) {
                return false;
            }
            AsyncJob asyncJob = (AsyncJob) obj;
            return this.job.equals(asyncJob.job) && Intrinsics.areEqual(this.session, asyncJob.session);
        }

        public final int hashCode() {
            return this.session.hashCode() + (this.job.hashCode() * 31);
        }

        public final String toString() {
            return "AsyncJob(job=" + this.job + ", session=" + this.session + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Companion {
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class EvaluationSession extends AbstractCoroutineContextElement {
        public static final NativeLibraryLoader Key = new NativeLibraryLoader();
        public final LinkedHashMap evaluations;
        public final LinkedHashMap unhandledRejections;

        public EvaluationSession() {
            super(Key);
            this.evaluations = new LinkedHashMap();
            this.unhandledRejections = new LinkedHashMap();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class EvaluationState {
        public Throwable exception;
        public long handle;
        public long promiseId;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof EvaluationState)) {
                return false;
            }
            EvaluationState evaluationState = (EvaluationState) obj;
            return this.handle == evaluationState.handle && this.promiseId == evaluationState.promiseId && Intrinsics.areEqual(this.exception, evaluationState.exception);
        }

        public final int hashCode() {
            int iM = IntIntPair$$ExternalSyntheticOutline0.m(Long.hashCode(this.handle) * 31, 31, this.promiseId);
            Throwable th = this.exception;
            return iM + (th == null ? 0 : th.hashCode());
        }

        public final String toString() {
            long j = this.handle;
            long j2 = this.promiseId;
            Throwable th = this.exception;
            StringBuilder sbM = Fragment$5$$ExternalSyntheticOutline0.m(j, "EvaluationState(handle=", ", promiseId=");
            sbM.append(j2);
            sbM.append(", exception=");
            sbM.append(th);
            sbM.append(")");
            return sbM.toString();
        }
    }

    /* JADX INFO: renamed from: com.dokar.quickjs.QuickJs$awaitEvaluateResult$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public long J$0;
        public EvaluationSession L$0;
        public EvaluationState L$1;
        public Object L$2;
        public Mutex L$3;
        public boolean Z$0;
        public boolean Z$1;
        public boolean Z$2;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return QuickJs.this.awaitEvaluateResult(null, null, false, this);
        }
    }

    /* JADX INFO: renamed from: com.dokar.quickjs.QuickJs$awaitEvaluateResult$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass4 extends SuspendLambda implements Function2 {
        public final /* synthetic */ long $observedProgress;
        public /* synthetic */ long J$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(long j, Continuation continuation) {
            super(2, continuation);
            this.$observedProgress = j;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass4 anonymousClass4 = new AnonymousClass4(this.$observedProgress, continuation);
            anonymousClass4.J$0 = ((Number) obj).longValue();
            return anonymousClass4;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass4) create(Long.valueOf(((Number) obj).longValue()), (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            long j = this.J$0;
            ResultKt.throwOnFailure(obj);
            return Boolean.valueOf(j != this.$observedProgress);
        }
    }

    /* JADX INFO: renamed from: com.dokar.quickjs.QuickJs$evalAndAwait$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C00571 extends ContinuationImpl {
        public Function1 L$0;
        public Mutex L$2;
        public JobImpl L$3;
        public int label;
        public /* synthetic */ Object result;

        public C00571(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return QuickJs.this.evalAndAwait(null, this);
        }
    }

    /* JADX INFO: renamed from: com.dokar.quickjs.QuickJs$evalInSession$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C00581 extends ContinuationImpl {
        public long J$0;
        public EvaluationSession L$0;
        public Function1 L$1;
        public EvaluationSession L$11;
        public Ref$ObjectRef L$12;
        public Ref$ObjectRef L$2;
        public EvaluationState L$3;
        public Object L$4;
        public Object L$5;
        public Ref$ObjectRef L$7;
        public EvaluationState L$8;
        public QuickJs L$9;
        public boolean Z$0;
        public int label;
        public /* synthetic */ Object result;

        public C00581(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return QuickJs.this.evalInSession(null, false, null, this);
        }
    }

    /* JADX INFO: renamed from: com.dokar.quickjs.QuickJs$evaluateInternal$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass2 extends SuspendLambda implements Function1 {
        public final /* synthetic */ Object $bytecode;
        public final /* synthetic */ byte $r8$classId;
        public final /* synthetic */ Object this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass2(Object obj, Object obj2, Continuation continuation, byte b) {
            super(1, continuation);
            this.$r8$classId = b;
            this.this$0 = obj;
            this.$bytecode = obj2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            byte b = this.$r8$classId;
            Object obj = this.$bytecode;
            Object obj2 = this.this$0;
            switch (b) {
                case 0:
                    return new AnonymousClass2((QuickJs) obj2, (byte[]) obj, continuation, (byte) 0);
                case 1:
                    return new AnonymousClass2((Animatable) obj2, obj, continuation, (byte) 1);
                default:
                    return new AnonymousClass2((List) obj2, (MusicDatabase) obj, continuation, (byte) 2);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            byte b = this.$r8$classId;
            Unit unit = Unit.INSTANCE;
            Continuation continuation = (Continuation) obj;
            switch (b) {
                case 0:
                    return ((AnonymousClass2) create(continuation)).invokeSuspend(unit);
                case 1:
                    ((AnonymousClass2) create(continuation)).invokeSuspend(unit);
                    return unit;
                default:
                    return ((AnonymousClass2) create(continuation)).invokeSuspend(unit);
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            byte b = this.$r8$classId;
            Object obj2 = this.$bytecode;
            Object obj3 = this.this$0;
            switch (b) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    QuickJs quickJs = (QuickJs) obj3;
                    return new Long(quickJs.evaluateBytecode(quickJs.context, quickJs.globals, (byte[]) obj2));
                case 1:
                    ResultKt.throwOnFailure(obj);
                    Animatable animatable = (Animatable) obj3;
                    animatable.endAnimation();
                    Object objClampToBounds = animatable.clampToBounds(obj2);
                    animatable.internalState.value$delegate.setValue(objClampToBounds);
                    animatable.targetValue$delegate.setValue(objClampToBounds);
                    return Unit.INSTANCE;
                default:
                    ResultKt.throwOnFailure(obj);
                    List<MediaMetadata> list = (List) obj3;
                    MusicDatabase musicDatabase = (MusicDatabase) obj2;
                    ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
                    for (MediaMetadata mediaMetadata : list) {
                        musicDatabase.insert(mediaMetadata, new DatabaseDao$$ExternalSyntheticLambda0((byte) 0));
                        arrayList.add(mediaMetadata.id);
                    }
                    return arrayList;
            }
        }
    }

    /* JADX INFO: renamed from: com.dokar.quickjs.QuickJs$loadModules$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C00601 extends ContinuationImpl {
        public EvaluationSession L$0;
        public Mutex L$1;
        public int label;
        public /* synthetic */ Object result;

        public C00601(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return QuickJs.this.loadModules(null, this);
        }
    }

    static {
        synchronized (NativeLibraryLoader.INSTANCE) {
            String property = System.getProperty("com.dokar.quickjs.library.path");
            String property2 = System.getProperty("com.dokar.quickjs.library.name");
            if (property == null || property2 == null) {
                System.loadLibrary("quickjs");
                return;
            }
            File file = new File(property, property2);
            if (file.exists()) {
                System.load(file.getAbsolutePath());
                return;
            }
            throw new IllegalStateException(("Cannot find a suitable QuickJS binary at the configured path (com.dokar.quickjs.library.path = " + property + "). File " + file + " does not exist.").toString());
        }
    }

    private QuickJs(CoroutineDispatcher coroutineDispatcher, ModuleLoader moduleLoader) throws QuickJsException {
        this.jobDispatcher = coroutineDispatcher;
        this.objectBindings = new LinkedHashMap();
        this.globalFunctions = new LinkedHashMap();
        this.nativeCloseHandlers = new ArrayList();
        this.modules = new ArrayList();
        QuickJs$special$$inlined$CoroutineExceptionHandler$1 quickJs$special$$inlined$CoroutineExceptionHandler$1 = new QuickJs$special$$inlined$CoroutineExceptionHandler$1(this);
        this.exceptionHandler = quickJs$special$$inlined$CoroutineExceptionHandler$1;
        this.coroutineScope = AwaitKt.CoroutineScope(coroutineDispatcher.plus(quickJs$special$$inlined$CoroutineExceptionHandler$1));
        this.jsMutex = new MutexImpl();
        this.interruptMutex = new MutexImpl();
        this.rootEvaluationMutex = new MutexImpl();
        this.runtimeProgress = StateFlowKt.MutableStateFlow(0L);
        this.jobsMutex = new MutexImpl();
        this.asyncJobs = new ArrayList();
        this.activeEvaluateResults = new LinkedHashSet();
        this.typeConverters = new TypeConverters();
        this.closed = new AtomicBoolean(false);
        this.memoryLimit = -1L;
        this.maxStackSize = 262144L;
        this.evaluationTimeoutMillis = -1L;
        try {
            long jNewRuntime = newRuntime();
            this.runtime = jNewRuntime;
            this.interruptState = installInterrupt(jNewRuntime);
            this.context = newContext(this.runtime);
            try {
                this.globals = initGlobals(this.runtime, new Class[]{Unit.class, UByteArray.class}, false);
            } catch (Throwable th) {
                close();
                throw th;
            }
        } catch (QuickJsException e) {
            close();
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:111:0x021a A[LOOP:0: B:122:0x00c2->B:111:0x021a, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:129:0x00d6 A[EDGE_INSN: B:129:0x00d6->B:34:0x00d6 BREAK  A[LOOP:0: B:122:0x00c2->B:111:0x021a], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:29:0x00ce A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:32:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:94:0x01de -> B:95:0x01e1). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:99:0x0208 -> B:100:0x020a). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:122:0x00c2
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object awaitEvaluateResult(com.dokar.quickjs.QuickJs.EvaluationSession r21, com.dokar.quickjs.QuickJs.EvaluationState r22, boolean r23, kotlin.coroutines.Continuation r24) {
        /*
            Method dump skipped, instruction units count: 562
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dokar.quickjs.QuickJs.awaitEvaluateResult(com.dokar.quickjs.QuickJs$EvaluationSession, com.dokar.quickjs.QuickJs$EvaluationState, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void clearHandledPromiseRejection(long promiseId) {
        if (this.closed.get()) {
            return;
        }
        EvaluationSession evaluationSession = this.currentEvaluationSession;
        Mutex mutex = this.jobsMutex;
        while (!mutex.tryLock()) {
            try {
                Thread.yield();
            } catch (Throwable th) {
                mutex.unlock(null);
                throw th;
            }
        }
        if (evaluationSession == null) {
            this.evalException = null;
        } else {
            EvaluationState evaluationState = (EvaluationState) evaluationSession.evaluations.get(Long.valueOf(promiseId));
            if (evaluationState != null) {
                evaluationState.exception = null;
            }
            evaluationSession.unhandledRejections.remove(Long.valueOf(promiseId));
        }
        mutex.unlock(null);
    }

    private final native byte[] compile(long context, long globals, String filename, String code, boolean asModule);

    public static /* synthetic */ byte[] compile$default(QuickJs quickJs, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "main.js";
        }
        if ((i & 4) != 0) {
            z = false;
        }
        return quickJs.compile(str, str2, z);
    }

    /* JADX INFO: renamed from: defineBinding-NW8rdx8$default, reason: not valid java name */
    public static long m893defineBindingNW8rdx8$default(QuickJs quickJs, String str, ObjectBinding objectBinding, long j, int i, Object obj) {
        if ((i & 4) != 0) {
            j = -1;
        }
        return quickJs.m894defineBindingNW8rdx8(str, objectBinding, j);
    }

    private final native void defineFunction(long globals, long context, String name, boolean isAsync);

    private final native long defineObject(long globals, long context, long parent, String name, JsProperty[] properties, JsFunction[] functions);

    private final void ensureNotClosed() throws QuickJsException {
        if (this.closed.get() || this.runtime == 0 || this.context == 0 || this.globals == 0) {
            throw new QuickJsException("Already closed.", null, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:51:0x00d4 A[Catch: all -> 0x0035, TryCatch #1 {all -> 0x0035, blocks: (B:14:0x0030, B:49:0x00c5, B:51:0x00d4, B:53:0x00da, B:54:0x00e3, B:55:0x00e4, B:56:0x00e5, B:57:0x00ec), top: B:62:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:53:0x00da A[Catch: all -> 0x0035, TryCatch #1 {all -> 0x0035, blocks: (B:14:0x0030, B:49:0x00c5, B:51:0x00d4, B:53:0x00da, B:54:0x00e3, B:55:0x00e4, B:56:0x00e5, B:57:0x00ec), top: B:62:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:55:0x00e4 A[Catch: all -> 0x0035, TryCatch #1 {all -> 0x0035, blocks: (B:14:0x0030, B:49:0x00c5, B:51:0x00d4, B:53:0x00da, B:54:0x00e3, B:55:0x00e4, B:56:0x00e5, B:57:0x00ec), top: B:62:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:56:0x00e5 A[Catch: all -> 0x0035, TryCatch #1 {all -> 0x0035, blocks: (B:14:0x0030, B:49:0x00c5, B:51:0x00d4, B:53:0x00da, B:54:0x00e3, B:55:0x00e4, B:56:0x00e5, B:57:0x00ec), top: B:62:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [com.dokar.quickjs.QuickJs, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v0, types: [kotlin.jvm.functions.Function1] */
    /* JADX WARN: Type inference failed for: r13v1, types: [kotlinx.coroutines.JobImpl] */
    /* JADX WARN: Type inference failed for: r13v10 */
    /* JADX WARN: Type inference failed for: r13v2, types: [kotlin.jvm.functions.Function1] */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v8 */
    /* JADX WARN: Type inference failed for: r1v0, types: [int, kotlinx.coroutines.sync.Mutex] */
    public final Object evalAndAwait(Function1 function1, Continuation continuation) throws QuickJsException {
        C00571 c00571;
        Mutex mutex;
        ?? r13;
        JobImpl jobImpl;
        JobImpl jobImpl2;
        if (continuation instanceof C00571) {
            c00571 = (C00571) continuation;
            int i = c00571.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00571.label = i - Integer.MIN_VALUE;
            } else {
                c00571 = new C00571(continuation);
            }
        } else {
            c00571 = new C00571(continuation);
        }
        Object objEvalInSession = c00571.result;
        ?? r1 = c00571.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            try {
                try {
                    if (r1 == 0) {
                        ResultKt.throwOnFailure(objEvalInSession);
                        ensureNotClosed();
                        EvaluationSession evaluationSession = (EvaluationSession) c00571.getContext().get(EvaluationSession.Key);
                        if (evaluationSession != null) {
                            c00571.L$0 = null;
                            c00571.label = 1;
                            Object objEvalInSession2 = evalInSession(evaluationSession, false, function1, c00571);
                            if (objEvalInSession2 != coroutineSingletons) {
                                return objEvalInSession2;
                            }
                        } else {
                            Mutex mutex2 = this.rootEvaluationMutex;
                            c00571.L$0 = function1;
                            c00571.L$2 = mutex2;
                            c00571.label = 2;
                            if (mutex2.lock(c00571) != coroutineSingletons) {
                                mutex = mutex2;
                                r13 = function1;
                            }
                        }
                        return coroutineSingletons;
                    }
                    if (r1 == 1) {
                        ResultKt.throwOnFailure(objEvalInSession);
                        return objEvalInSession;
                    }
                    if (r1 != 2) {
                        if (r1 != 3) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        jobImpl2 = c00571.L$3;
                        mutex = c00571.L$2;
                        try {
                            ResultKt.throwOnFailure(objEvalInSession);
                            jobImpl2.complete$1();
                            resetInterruptState(0L);
                            mutex.unlock(null);
                            return objEvalInSession;
                        } catch (QuickJsException e) {
                            e = e;
                            AwaitKt.ensureActive(c00571.getContext());
                            if (!this.closed.get()) {
                                throw new CancellationException("Already closed.");
                            }
                            if (wasInterrupted()) {
                                throw new QuickJsInterruptedException(e.getMessage(), null, 2, null);
                            }
                            throw e;
                        }
                    }
                    Mutex mutex3 = c00571.L$2;
                    Function1 function2 = c00571.L$0;
                    ResultKt.throwOnFailure(objEvalInSession);
                    mutex = mutex3;
                    r13 = function2;
                    EvaluationSession evaluationSession2 = new EvaluationSession();
                    c00571.L$0 = null;
                    c00571.L$2 = mutex;
                    c00571.L$3 = jobImpl;
                    c00571.label = 3;
                    objEvalInSession = evalInSession(evaluationSession2, true, r13, c00571);
                    if (objEvalInSession != coroutineSingletons) {
                        jobImpl2 = jobImpl;
                        jobImpl2.complete$1();
                        resetInterruptState(0L);
                        mutex.unlock(null);
                        return objEvalInSession;
                    }
                    return coroutineSingletons;
                } catch (QuickJsException e2) {
                    e = e2;
                    AwaitKt.ensureActive(c00571.getContext());
                    if (!this.closed.get()) {
                        throw new CancellationException("Already closed.");
                    }
                    if (wasInterrupted()) {
                        throw new QuickJsInterruptedException(e.getMessage(), null, 2, null);
                    }
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    function1 = jobImpl;
                    function1.complete$1();
                    resetInterruptState(0L);
                    throw th;
                }
                this.evalException = null;
                resetInterruptState(this.evaluationTimeoutMillis);
                jobImpl = new JobImpl(AwaitKt.getJob(c00571.getContext()));
                jobImpl.invokeOnCompletion(new DiskLruCache$$ExternalSyntheticLambda0((byte) 18, this));
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            r1.unlock(null);
            throw th3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit evalAndAwait$lambda$0$0(QuickJs quickJs, Throwable th) {
        if (th instanceof CancellationException) {
            quickJs.requestInterruptIfOpen();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 10261. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    public final java.lang.Object evalInSession(com.dokar.quickjs.QuickJs.EvaluationSession r22, boolean r23, kotlin.jvm.functions.Function1 r24, kotlin.coroutines.Continuation r25) {
        /*
            Method dump skipped, instruction units count: 1026
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dokar.quickjs.QuickJs.evalInSession(com.dokar.quickjs.QuickJs$EvaluationSession, boolean, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final native long evaluate(long context, long globals, String filename, String code, boolean asModule);

    public static Object evaluate$default(QuickJs quickJs, String str, String str2, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "main.js";
        }
        if ((i & 4) != 0) {
            z = false;
        }
        quickJs.evaluateInternal(str, str2, z, continuation);
        Intrinsics.throwUndefinedForReified();
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final native long evaluateBytecode(long context, long globals, byte[] buffer);

    private final native boolean executePendingJob(long context, long globals);

    private final native void freeInterrupt(long runtime, long state);

    private final native void gc(long runtime, long globals);

    private final native Object getEvaluateResult(long context, long globals, long handle);

    private final native long getEvaluateResultPromiseId(long context, long globals, long handle);

    private final native MemoryUsage getMemoryUsage(long runtime, long globals);

    private final byte[] getModuleBytecode(Object content) {
        return null;
    }

    private final String getModuleSource(Object content) {
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0038  */
    private final void handleException(EvaluationSession session, EvaluationState evaluation, boolean isRoot) throws Throwable {
        Mutex mutex = this.jobsMutex;
        while (!mutex.tryLock()) {
            try {
                Thread.yield();
            } catch (Throwable th) {
                mutex.unlock(null);
                throw th;
            }
        }
        Throwable th2 = evaluation.exception;
        evaluation.exception = null;
        if (th2 == null) {
            if (isRoot) {
                Set setEntrySet = session.unhandledRejections.entrySet();
                setEntrySet.getClass();
                Map.Entry entry = (Map.Entry) CollectionsKt.firstOrNull(setEntrySet);
                if (entry != null) {
                    th2 = (Throwable) session.unhandledRejections.remove(entry.getKey());
                } else {
                    th2 = null;
                }
            } else {
                th2 = null;
            }
            if (th2 == null) {
                th2 = this.evalException;
                this.evalException = null;
            }
        }
        mutex.unlock(null);
        if (th2 != null) {
            throw th2;
        }
    }

    private final boolean hasModuleNormalizer() {
        return false;
    }

    private final native long initGlobals(long runtime, Class<?>[] classes, boolean enableModuleLoader);

    private final native long installInterrupt(long runtime);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeAsyncFunction$lambda$1(QuickJs quickJs, Job job, Throwable th) {
        Mutex mutex = quickJs.jobsMutex;
        while (!mutex.tryLock()) {
            try {
                Thread.yield();
            } catch (Throwable th2) {
                mutex.unlock(null);
                throw th2;
            }
        }
        CollectionsKt__MutableCollectionsKt.removeAll(quickJs.asyncJobs, new DiskLruCache$$ExternalSyntheticLambda0((byte) 19, job));
        mutex.unlock(null);
        quickJs.signalRuntimeProgress();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invokeAsyncFunction$lambda$1$0$0(Job job, AsyncJob asyncJob) {
        asyncJob.getClass();
        return asyncJob.job.equals(job);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final native void invokeJsFunction(long context, long globals, long handle, Object[] args);

    private final native boolean isEvaluateResultPending(long context, long globals, long handle);

    private final Object loadModule(String name) {
        LinkedHashSet<String> linkedHashSet = this.resolvingModuleNames;
        if (linkedHashSet == null) {
            return null;
        }
        linkedHashSet.add(name);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object loadModules(EvaluationSession evaluationSession, Continuation continuation) {
        C00601 c00601;
        Mutex mutex;
        EvaluationSession evaluationSession2;
        if (continuation instanceof C00601) {
            c00601 = (C00601) continuation;
            int i = c00601.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00601.label = i - Integer.MIN_VALUE;
            } else {
                c00601 = new C00601(continuation);
            }
        } else {
            c00601 = new C00601(continuation);
        }
        Object obj = c00601.result;
        int i2 = c00601.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            mutex = this.jsMutex;
            c00601.L$0 = evaluationSession;
            c00601.L$1 = mutex;
            c00601.label = 1;
            Object objLock = mutex.lock(c00601);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objLock == coroutineSingletons) {
                return coroutineSingletons;
            }
            evaluationSession2 = evaluationSession;
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            mutex = c00601.L$1;
            EvaluationSession evaluationSession3 = c00601.L$0;
            ResultKt.throwOnFailure(obj);
            evaluationSession2 = evaluationSession3;
        }
        Mutex mutex2 = mutex;
        try {
            ensureNotClosed();
            EvaluationSession evaluationSession4 = this.currentEvaluationSession;
            this.currentEvaluationSession = evaluationSession2;
            try {
                Iterator<byte[]> it = this.modules.iterator();
                while (it.hasNext()) {
                    releaseEvaluateResult(this.context, this.globals, evaluateBytecode(this.context, this.globals, it.next()));
                }
                this.modules.clear();
                this.currentEvaluationSession = evaluationSession4;
                Unit unit = Unit.INSTANCE;
                mutex2.unlock(null);
                return unit;
            } catch (Throwable th) {
                this.currentEvaluationSession = evaluationSession4;
                throw th;
            }
        } catch (Throwable th2) {
            mutex2.unlock(null);
            throw th2;
        }
    }

    private final native String nativeGetVersion();

    private final native long newContext(long runtime);

    private final native long newRuntime();

    private final String normalizeModule(String baseName, String requestedName) {
        throw new IllegalArgumentException("A module normalizer is not configured.");
    }

    private final Object onCallFunction(long handle, String name, Object[] args) {
        ThreadLocal threadLocal = BindingCallbackContext_jniKt.bindingCallbackStack;
        ArrayDeque arrayDeque = (ArrayDeque) threadLocal.get();
        if (arrayDeque == null) {
            arrayDeque = new ArrayDeque();
            threadLocal.set(arrayDeque);
        }
        arrayDeque.addLast(this);
        try {
            onCallFunction$lambda$0(this, handle, name, args);
            throw null;
        } catch (Throwable th) {
            arrayDeque.removeLast();
            if (arrayDeque.isEmpty()) {
                threadLocal.remove();
            }
            throw th;
        }
    }

    private static final Object onCallFunction$lambda$0(QuickJs quickJs, long j, String str, Object[] objArr) throws QuickJsException {
        quickJs.ensureNotClosed();
        if (j == -1) {
            if (quickJs.globalFunctions.get(str) == null) {
                throw new QuickJsException(IntIntPair$$ExternalSyntheticOutline0.m("'", str, "()' does not found in global functions."), null, 2, null);
            }
            throw new ClassCastException();
        }
        if (quickJs.objectBindings.get(Long.valueOf(j)) == null) {
            throw new QuickJsException(IntIntPair$$ExternalSyntheticOutline0.m("JavaScript called function '", str, "' on an unknown binding"), null, 2, null);
        }
        throw new ClassCastException();
    }

    private final Object onCallGetter(long handle, String name) {
        ThreadLocal threadLocal = BindingCallbackContext_jniKt.bindingCallbackStack;
        ArrayDeque arrayDeque = (ArrayDeque) threadLocal.get();
        if (arrayDeque == null) {
            arrayDeque = new ArrayDeque();
            threadLocal.set(arrayDeque);
        }
        arrayDeque.addLast(this);
        try {
            onCallGetter$lambda$0(this, handle, name);
            throw null;
        } catch (Throwable th) {
            arrayDeque.removeLast();
            if (arrayDeque.isEmpty()) {
                threadLocal.remove();
            }
            throw th;
        }
    }

    private static final Object onCallGetter$lambda$0(QuickJs quickJs, long j, String str) throws QuickJsException {
        quickJs.ensureNotClosed();
        if (quickJs.objectBindings.get(Long.valueOf(j)) == null) {
            throw new QuickJsException(IntIntPair$$ExternalSyntheticOutline0.m("JavaScript called getter of '", str, "' on an unknown binding"), null, 2, null);
        }
        throw new ClassCastException();
    }

    private final void onCallSetter(long handle, String name, Object value) {
        ThreadLocal threadLocal = BindingCallbackContext_jniKt.bindingCallbackStack;
        ArrayDeque arrayDeque = (ArrayDeque) threadLocal.get();
        if (arrayDeque == null) {
            arrayDeque = new ArrayDeque();
            threadLocal.set(arrayDeque);
        }
        arrayDeque.addLast(this);
        try {
            onCallSetter$lambda$0(this, handle, name, value);
            throw null;
        } catch (Throwable th) {
            arrayDeque.removeLast();
            if (arrayDeque.isEmpty()) {
                threadLocal.remove();
            }
            throw th;
        }
    }

    private static final Unit onCallSetter$lambda$0(QuickJs quickJs, long j, String str, Object obj) throws QuickJsException {
        quickJs.ensureNotClosed();
        if (quickJs.objectBindings.get(Long.valueOf(j)) == null) {
            throw new QuickJsException(IntIntPair$$ExternalSyntheticOutline0.m("JavaScript called setter of '", str, "' on an unknown binding"), null, 2, null);
        }
        throw new ClassCastException();
    }

    private final Pair promiseHandlesFromArgs(Object[] args) {
        if (args.length < 2) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Invoking async functions requires resolve and reject handles.");
            return null;
        }
        Object obj = args[0];
        if (!(obj instanceof Long)) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) IntIntPair$$ExternalSyntheticOutline0.m("Unexpected resolve handle type ", obj != null ? Reflection.getOrCreateKotlinClass(obj.getClass()).getQualifiedName() : null, ", expected: Long"));
            return null;
        }
        Object obj2 = args[1];
        if (obj2 instanceof Long) {
            return new Pair(obj, obj2);
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) IntIntPair$$ExternalSyntheticOutline0.m("Unexpected reject handle type ", obj2 != null ? Reflection.getOrCreateKotlinClass(obj2.getClass()).getQualifiedName() : null, ", expected: Long"));
        return null;
    }

    private final native void releaseContext(long context);

    /* JADX INFO: Access modifiers changed from: private */
    public final native void releaseEvaluateResult(long context, long globals, long handle);

    private final native void releaseGlobals(long context, long globals);

    private final native void releaseRuntime(long runtime);

    private final native void requestInterrupt(long state);

    private final void requestInterruptIfOpen() {
        Mutex mutex = this.interruptMutex;
        while (!mutex.tryLock()) {
            try {
                Thread.yield();
            } catch (Throwable th) {
                mutex.unlock(null);
                throw th;
            }
        }
        long j = this.interruptState;
        if (j != 0) {
            requestInterrupt(j);
        }
        mutex.unlock(null);
    }

    private final native void resetInterrupt(long state, long timeoutMillis);

    private final void resetInterruptState(long timeoutMillis) {
        Mutex mutex = this.interruptMutex;
        while (!mutex.tryLock()) {
            try {
                Thread.yield();
            } catch (Throwable th) {
                mutex.unlock(null);
                throw th;
            }
        }
        long j = this.interruptState;
        if (j != 0) {
            resetInterrupt(j, timeoutMillis);
        }
        mutex.unlock(null);
    }

    private final native String resolveModuleGraphBytecode(long runtime, long globals, byte[] bytecode);

    private final void setClosed(boolean z) {
        this.closed.set(z);
    }

    private final void setEvalException(Throwable exception) throws QuickJsException {
        ensureNotClosed();
        Mutex mutex = this.jobsMutex;
        while (!mutex.tryLock()) {
            try {
                Thread.yield();
            } catch (Throwable th) {
                mutex.unlock(null);
                throw th;
            }
        }
        EvaluationState evaluationState = this.currentEvaluation;
        if (evaluationState != null) {
            if (evaluationState.exception == null) {
                evaluationState.exception = exception;
            }
        } else if (this.evalException == null) {
            this.evalException = exception;
        }
        mutex.unlock(null);
    }

    private final native void setMaxStackSize(long runtime, long globals, long byteCount);

    private final native void setMemoryLimit(long runtime, long globals, long byteCount);

    private final void setUnhandledPromiseRejection(long promiseId, Object reason) {
        if (this.closed.get()) {
            return;
        }
        Throwable quickJsException = reason instanceof Throwable ? (Throwable) reason : null;
        if (quickJsException == null) {
            quickJsException = new QuickJsException(String.valueOf(reason), null, 2, null);
        }
        EvaluationSession evaluationSession = this.currentEvaluationSession;
        Mutex mutex = this.jobsMutex;
        while (!mutex.tryLock()) {
            try {
                Thread.yield();
            } catch (Throwable th) {
                mutex.unlock(null);
                throw th;
            }
        }
        if (evaluationSession != null) {
            EvaluationState evaluationState = (EvaluationState) evaluationSession.evaluations.get(Long.valueOf(promiseId));
            if (evaluationState == null) {
                evaluationSession.unhandledRejections.putIfAbsent(Long.valueOf(promiseId), quickJsException);
            } else if (evaluationState.exception == null) {
                evaluationState.exception = quickJsException;
            }
        } else if (this.evalException == null) {
            this.evalException = quickJsException;
        }
        mutex.unlock(null);
        signalRuntimeProgress();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void signalRuntimeProgress() {
        StateFlowImpl stateFlowImpl;
        Object value;
        MutableStateFlow mutableStateFlow = this.runtimeProgress;
        do {
            stateFlowImpl = (StateFlowImpl) mutableStateFlow;
            value = stateFlowImpl.getValue();
        } while (!stateFlowImpl.compareAndSet(value, Long.valueOf(((Number) value).longValue() + 1)));
    }

    private final native void updateStackTop(long runtime);

    private final boolean wasInterrupted() {
        Mutex mutex = this.interruptMutex;
        while (true) {
            try {
                if (mutex.tryLock()) {
                    break;
                }
                Thread.yield();
            } finally {
                mutex.unlock(null);
            }
        }
        long j = this.interruptState;
        return j != 0 && wasInterrupted(j);
    }

    private final native boolean wasInterrupted(long state);

    private final <T> T withEvaluation(EvaluationSession session, EvaluationState evaluation, Function0 block) {
        EvaluationState evaluationState = this.currentEvaluation;
        this.currentEvaluation = evaluation;
        try {
            EvaluationSession evaluationSession = this.currentEvaluationSession;
            this.currentEvaluationSession = session;
            try {
                T t = (T) block.invoke();
                this.currentEvaluationSession = evaluationSession;
                this.currentEvaluation = evaluationState;
                return t;
            } catch (Throwable th) {
                this.currentEvaluationSession = evaluationSession;
                throw th;
            }
        } catch (Throwable th2) {
            this.currentEvaluation = evaluationState;
            throw th2;
        }
    }

    private final <T> T withEvaluationSession(EvaluationSession session, Function0 block) {
        EvaluationSession evaluationSession = this.currentEvaluationSession;
        this.currentEvaluationSession = session;
        try {
            return (T) block.invoke();
        } finally {
            this.currentEvaluationSession = evaluationSession;
        }
    }

    private final <T> T withJsLockSync(Function0 block) {
        if (BindingCallbackContext_jniKt.isInBindingCallback(this)) {
            return (T) block.invoke();
        }
        Mutex mutex = this.jsMutex;
        while (!mutex.tryLock()) {
            try {
                Thread.yield();
            } catch (Throwable th) {
                mutex.unlock(null);
                throw th;
            }
        }
        T t = (T) block.invoke();
        mutex.unlock(null);
        return t;
    }

    public final void addModule(String name, String code) throws QuickJsException {
        name.getClass();
        code.getClass();
        if (BindingCallbackContext_jniKt.isInBindingCallback(this)) {
            ensureNotClosed();
            this.modules.add(compile(this.context, this.globals, name, code, true));
            return;
        }
        Mutex mutex = this.jsMutex;
        while (!mutex.tryLock()) {
            try {
                Thread.yield();
            } catch (Throwable th) {
                mutex.unlock(null);
                throw th;
            }
        }
        ensureNotClosed();
        this.modules.add(compile(this.context, this.globals, name, code, true));
        mutex.unlock(null);
    }

    public final void addTypeConverters(TypeConverter... converters) {
        converters.getClass();
        TypeConverters typeConverters = this.typeConverters;
        TypeConverter[] typeConverterArr = (TypeConverter[]) Arrays.copyOf(converters, converters.length);
        typeConverters.getClass();
        ArrayList arrayList = typeConverters.converters;
        List listAsList = Arrays.asList(typeConverterArr);
        listAsList.getClass();
        arrayList.addAll(listAsList);
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            it.next().getClass();
            PathKt$$ExternalSyntheticBUOutline0.m();
        }
    }

    /* JADX WARN: Code duplicated, block: B:38:0x00aa  */
    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        Throwable th;
        if (BindingCallbackContext_jniKt.isInBindingCallback(this)) {
            throw new QuickJsException("Cannot close QuickJs from within a binding callback.", null, 2, null);
        }
        if (this.closed.compareAndSet(false, true)) {
            requestInterruptIfOpen();
            signalRuntimeProgress();
            Mutex mutex = this.jobsMutex;
            while (!mutex.tryLock()) {
                try {
                    Thread.yield();
                } catch (Throwable th2) {
                    mutex.unlock(null);
                    throw th2;
                }
            }
            Iterator<T> it = this.asyncJobs.iterator();
            while (it.hasNext()) {
                ((AsyncJob) it.next()).job.cancel(null);
            }
            this.asyncJobs.clear();
            this.activeEvaluateResults.clear();
            mutex.unlock(null);
            Mutex mutex2 = this.jsMutex;
            while (!mutex2.tryLock()) {
                try {
                    Thread.yield();
                } catch (Throwable th3) {
                    mutex2.unlock(null);
                    throw th3;
                }
            }
            if (this.context != 0) {
                long j = this.runtime;
                if (j != 0) {
                    updateStackTop(j);
                    List<Function1> list = this.nativeCloseHandlers;
                    list.getClass();
                    Iterator it2 = new ReversedList(list).iterator();
                    th = null;
                    while (((ListIterator) ((ReversedList.AnonymousClass1) it2).delegateIterator).hasPrevious()) {
                        try {
                            ((Function1) ((ListIterator) ((ReversedList.AnonymousClass1) it2).delegateIterator).previous()).invoke(new NativeLibraryLoader());
                        } catch (Throwable th4) {
                            if (th == null) {
                                th = th4;
                            }
                        }
                    }
                    this.nativeCloseHandlers.clear();
                } else {
                    th = null;
                }
            } else {
                th = null;
            }
            this.objectBindings.clear();
            this.globalFunctions.clear();
            this.modules.clear();
            long j2 = this.globals;
            if (j2 != 0) {
                releaseGlobals(this.context, j2);
                this.globals = 0L;
            }
            long j3 = this.context;
            if (j3 != 0) {
                releaseContext(j3);
                this.context = 0L;
            }
            if (this.runtime != 0) {
                Mutex mutex3 = this.interruptMutex;
                while (!mutex3.tryLock()) {
                    try {
                        Thread.yield();
                    } catch (Throwable th5) {
                        mutex3.unlock(null);
                        throw th5;
                    }
                }
                long j4 = this.interruptState;
                if (j4 != 0) {
                    freeInterrupt(this.runtime, j4);
                    this.interruptState = 0L;
                }
                mutex3.unlock(null);
                releaseRuntime(this.runtime);
                this.runtime = 0L;
            }
            mutex2.unlock(null);
            if (th != null) {
                throw th;
            }
        }
    }

    public final byte[] compile(String code, String filename, boolean asModule) throws QuickJsException {
        code.getClass();
        filename.getClass();
        if (BindingCallbackContext_jniKt.isInBindingCallback(this)) {
            ensureNotClosed();
            return compile(this.context, this.globals, filename, code, asModule);
        }
        Mutex mutex = this.jsMutex;
        while (!mutex.tryLock()) {
            try {
                Thread.yield();
            } catch (Throwable th) {
                mutex.unlock(null);
                throw th;
            }
        }
        ensureNotClosed();
        byte[] bArrCompile = compile(this.context, this.globals, filename, code, asModule);
        mutex.unlock(null);
        return bArrCompile;
    }

    public final <R> void defineBinding(String name, FunctionBinding binding) throws QuickJsException {
        name.getClass();
        binding.getClass();
        if (BindingCallbackContext_jniKt.isInBindingCallback(this)) {
            ensureNotClosed();
            defineFunction(this.globals, this.context, name, false);
            this.globalFunctions.put(name, binding);
            return;
        }
        Mutex mutex = this.jsMutex;
        while (!mutex.tryLock()) {
            try {
                Thread.yield();
            } catch (Throwable th) {
                mutex.unlock(null);
                throw th;
            }
        }
        ensureNotClosed();
        defineFunction(this.globals, this.context, name, false);
        this.globalFunctions.put(name, binding);
        mutex.unlock(null);
    }

    /* JADX INFO: renamed from: defineBinding-NW8rdx8, reason: not valid java name */
    public final long m894defineBindingNW8rdx8(String name, ObjectBinding binding, long parent) throws QuickJsException {
        name.getClass();
        binding.getClass();
        if (BindingCallbackContext_jniKt.isInBindingCallback(this)) {
            ensureNotClosed();
            long jDefineObject = defineObject(this.globals, this.context, parent, name, (JsProperty[]) binding.getProperties().toArray(new JsProperty[0]), (JsFunction[]) binding.getFunctions().toArray(new JsFunction[0]));
            if (jDefineObject < 0) {
                throw new QuickJsException(IntIntPair$$ExternalSyntheticOutline0.m("Failed to define object '", name, "'."), null, 2, null);
            }
            this.objectBindings.put(Long.valueOf(jDefineObject), binding);
            return jDefineObject;
        }
        Mutex mutex = this.jsMutex;
        while (!mutex.tryLock()) {
            try {
                Thread.yield();
            } catch (Throwable th) {
                mutex.unlock(null);
                throw th;
            }
        }
        ensureNotClosed();
        long jDefineObject2 = defineObject(this.globals, this.context, parent, name, (JsProperty[]) binding.getProperties().toArray(new JsProperty[0]), (JsFunction[]) binding.getFunctions().toArray(new JsFunction[0]));
        if (jDefineObject2 >= 0) {
            this.objectBindings.put(Long.valueOf(jDefineObject2), binding);
            mutex.unlock(null);
            return jDefineObject2;
        }
        throw new QuickJsException("Failed to define object '" + name + "'.", null, 2, null);
    }

    public final <T> Object evaluate(byte[] bArr, Continuation continuation) {
        evaluateInternal(bArr, continuation);
        Intrinsics.throwUndefinedForReified();
        throw null;
    }

    public final Object evaluateInternal(String str, String str2, boolean z, Continuation continuation) {
        return evalAndAwait(new C00594(this, str2, str, z, (Continuation) null), continuation);
    }

    public final void gc() throws QuickJsException {
        if (BindingCallbackContext_jniKt.isInBindingCallback(this)) {
            ensureNotClosed();
            gc(this.runtime, this.globals);
            return;
        }
        Mutex mutex = this.jsMutex;
        while (!mutex.tryLock()) {
            try {
                Thread.yield();
            } catch (Throwable th) {
                mutex.unlock(null);
                throw th;
            }
        }
        ensureNotClosed();
        gc(this.runtime, this.globals);
        mutex.unlock(null);
    }

    public final long getEvaluationTimeoutMillis() {
        return this.evaluationTimeoutMillis;
    }

    public final long getMaxStackSize() {
        return this.maxStackSize;
    }

    public final long getMemoryLimit() {
        return this.memoryLimit;
    }

    public final MemoryUsage getMemoryUsage() throws QuickJsException {
        if (BindingCallbackContext_jniKt.isInBindingCallback(this)) {
            ensureNotClosed();
            getMemoryUsage(this.runtime, this.globals);
            return null;
        }
        Mutex mutex = this.jsMutex;
        while (!mutex.tryLock()) {
            try {
                Thread.yield();
            } catch (Throwable th) {
                mutex.unlock(null);
                throw th;
            }
        }
        ensureNotClosed();
        getMemoryUsage(this.runtime, this.globals);
        mutex.unlock(null);
        return null;
    }

    public final TypeConverters getTypeConverters() {
        return this.typeConverters;
    }

    public final String getVersion() {
        return nativeGetVersion();
    }

    public final void interruptEvaluation() {
        Mutex mutex = this.interruptMutex;
        while (!mutex.tryLock()) {
            try {
                Thread.yield();
            } catch (Throwable th) {
                mutex.unlock(null);
                throw th;
            }
        }
        ensureNotClosed();
        requestInterrupt(this.interruptState);
        mutex.unlock(null);
    }

    public final void invokeAsyncFunction$quickjs_kt_quickjs_release(Object[] args, Function2 block) throws QuickJsException {
        args.getClass();
        block.getClass();
        if (this.closed.get()) {
            return;
        }
        EvaluationSession evaluationSession = this.currentEvaluationSession;
        if (evaluationSession == null) {
            throw new QuickJsException("Async function was invoked outside an evaluation.", null, 2, null);
        }
        Pair pairPromiseHandlesFromArgs = promiseHandlesFromArgs(args);
        long jLongValue = ((Number) pairPromiseHandlesFromArgs.first).longValue();
        long jLongValue2 = ((Number) pairPromiseHandlesFromArgs.second).longValue();
        StandaloneCoroutine standaloneCoroutineLaunch = AwaitKt.launch(this.coroutineScope, evaluationSession, CoroutineStart.LAZY, new QuickJs$invokeAsyncFunction$job$1(block, args, this, evaluationSession, jLongValue, jLongValue2, null));
        Mutex mutex = this.jobsMutex;
        while (!mutex.tryLock()) {
            try {
                Thread.yield();
            } catch (Throwable th) {
                mutex.unlock(null);
                throw th;
            }
        }
        this.asyncJobs.add(new AsyncJob(standaloneCoroutineLaunch, evaluationSession));
        mutex.unlock(null);
        standaloneCoroutineLaunch.invokeOnCompletion(new QuickJs$$ExternalSyntheticLambda1(this, standaloneCoroutineLaunch, (byte) 0));
        standaloneCoroutineLaunch.start();
    }

    public final boolean isClosed() {
        return this.closed.get();
    }

    public final void onNativeClose(Function1 cleanup) throws QuickJsException {
        cleanup.getClass();
        if (BindingCallbackContext_jniKt.isInBindingCallback(this)) {
            ensureNotClosed();
            this.nativeCloseHandlers.add(cleanup);
            return;
        }
        Mutex mutex = this.jsMutex;
        while (!mutex.tryLock()) {
            try {
                Thread.yield();
            } catch (Throwable th) {
                mutex.unlock(null);
                throw th;
            }
        }
        ensureNotClosed();
        this.nativeCloseHandlers.add(cleanup);
        mutex.unlock(null);
    }

    public final Set<String> resolveModuleGraph(byte[] entryBytecode) throws Throwable {
        QuickJs quickJs;
        entryBytecode.getClass();
        if (!BindingCallbackContext_jniKt.isInBindingCallback(this)) {
            Mutex mutex = this.jsMutex;
            while (!mutex.tryLock()) {
                try {
                    Thread.yield();
                } catch (Throwable th) {
                    mutex.unlock(null);
                    throw th;
                }
            }
            ensureNotClosed();
            LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
            this.resolvingModuleNames = linkedHashSet;
            try {
                linkedHashSet.add(resolveModuleGraphBytecode(this.runtime, this.globals, entryBytecode));
                this.resolvingModuleNames = null;
                mutex.unlock(null);
                return linkedHashSet;
            } catch (Throwable th2) {
                this.resolvingModuleNames = null;
                throw th2;
            }
        }
        ensureNotClosed();
        LinkedHashSet<String> linkedHashSet2 = new LinkedHashSet<>();
        this.resolvingModuleNames = linkedHashSet2;
        try {
            quickJs = this;
            try {
                linkedHashSet2.add(quickJs.resolveModuleGraphBytecode(this.runtime, this.globals, entryBytecode));
                quickJs.resolvingModuleNames = null;
                return linkedHashSet2;
            } catch (Throwable th3) {
                th = th3;
                Throwable th4 = th;
                quickJs.resolvingModuleNames = null;
                throw th4;
            }
        } catch (Throwable th5) {
            th = th5;
            quickJs = this;
        }
    }

    public final void setEvaluationTimeoutMillis(long j) {
        this.evaluationTimeoutMillis = j;
    }

    public final void setMaxStackSize(long j) {
        if (BindingCallbackContext_jniKt.isInBindingCallback(this)) {
            ensureNotClosed();
            this.maxStackSize = j;
            setMaxStackSize(this.runtime, this.globals, j);
            return;
        }
        Mutex mutex = this.jsMutex;
        while (!mutex.tryLock()) {
            try {
                Thread.yield();
            } catch (Throwable th) {
                mutex.unlock(null);
                throw th;
            }
        }
        ensureNotClosed();
        this.maxStackSize = j;
        setMaxStackSize(this.runtime, this.globals, j);
        mutex.unlock(null);
    }

    public final void setMemoryLimit(long j) {
        if (BindingCallbackContext_jniKt.isInBindingCallback(this)) {
            ensureNotClosed();
            this.memoryLimit = j;
            setMemoryLimit(this.runtime, this.globals, j);
            return;
        }
        Mutex mutex = this.jsMutex;
        while (!mutex.tryLock()) {
            try {
                Thread.yield();
            } catch (Throwable th) {
                mutex.unlock(null);
                throw th;
            }
        }
        ensureNotClosed();
        this.memoryLimit = j;
        setMemoryLimit(this.runtime, this.globals, j);
        mutex.unlock(null);
    }

    public final <T> T withNativeContext(Function1 block) throws QuickJsException {
        block.getClass();
        if (BindingCallbackContext_jniKt.isInBindingCallback(this)) {
            ensureNotClosed();
            updateStackTop(this.runtime);
            return (T) block.invoke(new NativeLibraryLoader());
        }
        Mutex mutex = this.jsMutex;
        while (!mutex.tryLock()) {
            try {
                Thread.yield();
            } catch (Throwable th) {
                mutex.unlock(null);
                throw th;
            }
        }
        ensureNotClosed();
        updateStackTop(this.runtime);
        T t = (T) block.invoke(new NativeLibraryLoader());
        mutex.unlock(null);
        return t;
    }

    public final <T> Object evaluate(String str, String str2, boolean z, Continuation continuation) {
        evaluateInternal(str, str2, z, continuation);
        Intrinsics.throwUndefinedForReified();
        throw null;
    }

    /* JADX INFO: renamed from: com.dokar.quickjs.QuickJs$evaluateInternal$4, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C00594 extends SuspendLambda implements Function1 {
        public boolean $asModule;
        public final /* synthetic */ Object $code;
        public final /* synthetic */ Object $filename;
        public final /* synthetic */ byte $r8$classId;
        public final /* synthetic */ Object this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C00594(QuickJs quickJs, String str, String str2, boolean z, Continuation continuation) {
            super(1, continuation);
            this.$r8$classId = (byte) 0;
            this.this$0 = quickJs;
            this.$filename = str;
            this.$code = str2;
            this.$asModule = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            byte b = this.$r8$classId;
            Object obj = this.$filename;
            Object obj2 = this.$code;
            Object obj3 = this.this$0;
            switch (b) {
                case 0:
                    return new C00594((QuickJs) obj3, (String) obj, (String) obj2, this.$asModule, continuation);
                case 1:
                    return new C00594(obj3, this.$filename, obj2, continuation, (byte) 1);
                case 2:
                    return new C00594(obj3, obj, obj2, continuation, (byte) 2);
                case 3:
                    return new C00594(obj3, obj, obj2, continuation, (byte) 3);
                default:
                    return new C00594(obj3, obj, obj2, continuation, (byte) 4);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            byte b = this.$r8$classId;
            Unit unit = Unit.INSTANCE;
            Continuation continuation = (Continuation) obj;
            switch (b) {
                case 0:
                    break;
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
            }
            return ((C00594) create(continuation)).invokeSuspend(unit);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            byte b = this.$r8$classId;
            Unit unit = Unit.INSTANCE;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            Object obj2 = this.$code;
            Object obj3 = this.$filename;
            Object obj4 = this.this$0;
            Continuation continuation = null;
            switch (b) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    QuickJs quickJs = (QuickJs) obj4;
                    return new Long(quickJs.evaluate(quickJs.context, quickJs.globals, (String) obj3, (String) obj2, this.$asModule));
                case 1:
                    NodeChain nodeChain = (NodeChain) obj4;
                    boolean z = this.$asModule;
                    if (!z) {
                        ResultKt.throwOnFailure(obj);
                        ((ParcelableSnapshotMutableState) nodeChain.buffers).setValue(obj3);
                        AnchoredDraggableState$$ExternalSyntheticLambda1 anchoredDraggableState$$ExternalSyntheticLambda1 = new AnchoredDraggableState$$ExternalSyntheticLambda1(nodeChain, (byte) 2);
                        RealImageLoader.AnonymousClass2 anonymousClass2 = new RealImageLoader.AnonymousClass2((Function4) obj2, nodeChain, continuation, (byte) 9);
                        this.$asModule = true;
                        if (ScrollableKt.restartable(anchoredDraggableState$$ExternalSyntheticLambda1, anonymousClass2, this) == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    } else {
                        if (!z) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    if (!((Boolean) ((Function1) nodeChain.layoutNode).invoke(obj3)).booleanValue()) {
                        return unit;
                    }
                    ((AnchoredDraggableState$anchoredDragScope$1) nodeChain.cachedDiffer).dragTo(nodeChain.getAnchors().positionOf(obj3), ((ParcelableSnapshotMutableFloatState) nodeChain.current).getFloatValue());
                    ((ParcelableSnapshotMutableState) nodeChain.outerCoordinator).setValue(obj3);
                    ((ParcelableSnapshotMutableState) nodeChain.innerCoordinator).setValue(obj3);
                    return unit;
                case 2:
                    boolean z2 = this.$asModule;
                    if (!z2) {
                        ResultKt.throwOnFailure(obj);
                        this.$asModule = true;
                        Object objTransaction = ((PassthroughConnection) obj4).transaction((Transactor.SQLiteTransactionType) obj3, (Function2) obj2, this);
                        return objTransaction == coroutineSingletons ? coroutineSingletons : objTransaction;
                    }
                    if (z2) {
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 3:
                    boolean z3 = this.$asModule;
                    if (!z3) {
                        ResultKt.throwOnFailure(obj);
                        this.$asModule = true;
                        return DatabaseDao.transferSongStats$suspendImpl((DatabaseDao_Impl) obj4, (String) obj3, (String) obj2, this) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (z3) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                default:
                    boolean z4 = this.$asModule;
                    if (!z4) {
                        ResultKt.throwOnFailure(obj);
                        this.$asModule = true;
                        int i = SyncUtils.$r8$clinit;
                        return ((SyncUtils) obj4).m1521executeSyncPlaylist0E7RQCE((String) obj3, (String) obj2, this) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (!z4) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    Object obj5 = ((Result) obj).value;
                    return unit;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ C00594(Object obj, Object obj2, Object obj3, Continuation continuation, byte b) {
            super(1, continuation);
            this.$r8$classId = b;
            this.this$0 = obj;
            this.$filename = obj2;
            this.$code = obj3;
        }
    }

    public final Object evaluateInternal(byte[] bArr, Continuation continuation) {
        return evalAndAwait(new AnonymousClass2(this, bArr, null, (byte) 0), continuation);
    }

    public static /* synthetic */ void getTypeConverters$annotations() {
    }

    /* JADX INFO: renamed from: com.dokar.quickjs.QuickJs$evalInSession$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass3 extends SuspendLambda implements Function2 {
        public final /* synthetic */ Object $evaluation;
        public Object $handle;
        public final /* synthetic */ byte $r8$classId;
        public Object $session;
        public Object L$0;
        public Object L$1;
        public Object L$2;
        public Object L$3;
        public Object L$4;
        public byte label;
        public Object this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(Function1 function1, List list, NavDeepLinkRequest navDeepLinkRequest, BottomSheetState bottomSheetState, NavHostController navHostController, State state, MutableState mutableState, String str, Function1 function2, Continuation continuation) {
            super(2, continuation);
            this.$r8$classId = (byte) 2;
            this.L$0 = function1;
            this.L$1 = list;
            this.L$2 = navDeepLinkRequest;
            this.L$3 = bottomSheetState;
            this.this$0 = navHostController;
            this.L$4 = state;
            this.$handle = mutableState;
            this.$session = str;
            this.$evaluation = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            byte b = this.$r8$classId;
            Object obj2 = this.$evaluation;
            switch (b) {
                case 0:
                    return new AnonymousClass3((QuickJs) this.this$0, (EvaluationSession) this.$session, (EvaluationState) obj2, (Long) this.$handle, continuation);
                case 1:
                    AnonymousClass3 anonymousClass3 = new AnonymousClass3((MutatePriority) this.L$4, (MutatorMutex) this.$handle, (Function2) this.$session, this.$evaluation, continuation, (byte) 1);
                    anonymousClass3.this$0 = obj;
                    return anonymousClass3;
                case 2:
                    return new AnonymousClass3((Function1) this.L$0, (List) this.L$1, (NavDeepLinkRequest) this.L$2, (BottomSheetState) this.L$3, (NavHostController) this.this$0, (State) this.L$4, (MutableState) this.$handle, (String) this.$session, (Function1) obj2, continuation);
                case 3:
                    return new AnonymousClass3((Playlist) this.L$2, (MutableState) this.L$3, (Uri) this.this$0, (Ref$BooleanRef) this.L$4, (MusicDatabase) this.$handle, (Context) this.$session, (SnackbarHostState) obj2, continuation);
                case 4:
                    return new AnonymousClass3((SyncUtils) obj2, continuation);
                default:
                    return new AnonymousClass3((List) this.L$4, (SyncUtils) this.$handle, (String) this.$session, (String) obj2, continuation, (byte) 5);
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            byte b = this.$r8$classId;
            Unit unit = Unit.INSTANCE;
            CoroutineScope coroutineScope = (CoroutineScope) obj;
            Continuation continuation = (Continuation) obj2;
            switch (b) {
                case 0:
                    break;
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
            }
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(unit);
        }

        /* JADX WARN: Code duplicated, block: B:120:0x02c9 A[Catch: Exception -> 0x035e, TRY_LEAVE, TryCatch #13 {Exception -> 0x035e, blocks: (B:118:0x02c3, B:120:0x02c9, B:144:0x034e, B:147:0x0361), top: B:371:0x02c3 }] */
        /* JADX WARN: Code duplicated, block: B:123:0x02ee  */
        /* JADX WARN: Code duplicated, block: B:124:0x02ef A[Catch: Exception -> 0x00ea, PHI: r0 r1 r2 r3 r4 r6 r7 r14
          0x02ef: PHI (r0v64 ??) = (r0v94 ??), (r0v95 ??) binds: [B:122:0x02ec, B:49:0x012a] A[DONT_GENERATE, DONT_INLINE]
          0x02ef: PHI (r1v83 ??) = (r1v147 ??), (r1v148 ??) binds: [B:122:0x02ec, B:49:0x012a] A[DONT_GENERATE, DONT_INLINE]
          0x02ef: PHI (r2v28 ??) = (r2v56 ??), (r2v57 ??) binds: [B:122:0x02ec, B:49:0x012a] A[DONT_GENERATE, DONT_INLINE]
          0x02ef: PHI (r3v32 ??) = (r3v64 ??), (r3v65 ??) binds: [B:122:0x02ec, B:49:0x012a] A[DONT_GENERATE, DONT_INLINE]
          0x02ef: PHI (r4v45 ??) = (r4v72 ??), (r4v73 ??) binds: [B:122:0x02ec, B:49:0x012a] A[DONT_GENERATE, DONT_INLINE]
          0x02ef: PHI (r6v50 java.lang.Object) = (r6v59 java.lang.Object), (r6v75 java.lang.Object) binds: [B:122:0x02ec, B:49:0x012a] A[DONT_GENERATE, DONT_INLINE]
          0x02ef: PHI (r7v14 ??) = (r7v34 ??), (r7v35 ??) binds: [B:122:0x02ec, B:49:0x012a] A[DONT_GENERATE, DONT_INLINE]
          0x02ef: PHI (r14v6 kotlin.coroutines.Continuation) = (r14v8 kotlin.coroutines.Continuation), (r14v4 kotlin.coroutines.Continuation) binds: [B:122:0x02ec, B:49:0x012a] A[DONT_GENERATE, DONT_INLINE], TryCatch #7 {Exception -> 0x00ea, blocks: (B:41:0x00e4, B:121:0x02cf, B:124:0x02ef, B:126:0x02f6, B:130:0x0306, B:45:0x0107, B:48:0x0127), top: B:362:0x00c1 }] */
        /* JADX WARN: Code duplicated, block: B:126:0x02f6 A[Catch: Exception -> 0x00ea, TryCatch #7 {Exception -> 0x00ea, blocks: (B:41:0x00e4, B:121:0x02cf, B:124:0x02ef, B:126:0x02f6, B:130:0x0306, B:45:0x0107, B:48:0x0127), top: B:362:0x00c1 }] */
        /* JADX WARN: Code duplicated, block: B:128:0x0301 A[PHI: r6
          0x0301: PHI (r6v52 java.lang.String) = (r6v51 java.lang.String), (r6v55 java.lang.String) binds: [B:125:0x02f4, B:127:0x02ff] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:129:0x0304  */
        /* JADX WARN: Code duplicated, block: B:138:0x032e  */
        /* JADX WARN: Code duplicated, block: B:139:0x032f A[Catch: Exception -> 0x034e, PHI: r0 r1 r2 r3 r4 r7 r8
          0x032f: PHI (r0v63 ??) = (r0v96 ??), (r0v97 ??) binds: [B:137:0x032c, B:46:0x010a] A[DONT_GENERATE, DONT_INLINE]
          0x032f: PHI (r1v81 ??) = (r1v149 ??), (r1v150 ??) binds: [B:137:0x032c, B:46:0x010a] A[DONT_GENERATE, DONT_INLINE]
          0x032f: PHI (r2v27 ??) = (r2v58 ??), (r2v59 ??) binds: [B:137:0x032c, B:46:0x010a] A[DONT_GENERATE, DONT_INLINE]
          0x032f: PHI (r3v31 ??) = (r3v66 ??), (r3v67 ??) binds: [B:137:0x032c, B:46:0x010a] A[DONT_GENERATE, DONT_INLINE]
          0x032f: PHI (r4v44 ??) = (r4v74 ??), (r4v75 ??) binds: [B:137:0x032c, B:46:0x010a] A[DONT_GENERATE, DONT_INLINE]
          0x032f: PHI (r7v13 ??) = (r7v36 ??), (r7v37 ??) binds: [B:137:0x032c, B:46:0x010a] A[DONT_GENERATE, DONT_INLINE]
          0x032f: PHI (r8v9 kotlin.coroutines.Continuation) = (r8v11 kotlin.coroutines.Continuation), (r8v30 kotlin.coroutines.Continuation) binds: [B:137:0x032c, B:46:0x010a] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #0 {Exception -> 0x034e, blocks: (B:136:0x0315, B:139:0x032f), top: B:350:0x0315 }] */
        /* JADX WARN: Code duplicated, block: B:147:0x0361 A[Catch: Exception -> 0x035e, TRY_LEAVE, TryCatch #13 {Exception -> 0x035e, blocks: (B:118:0x02c3, B:120:0x02c9, B:144:0x034e, B:147:0x0361), top: B:371:0x02c3 }] */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v55, types: [com.metrolist.music.utils.SyncUtils, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r0v56 */
        /* JADX WARN: Type inference failed for: r0v62 */
        /* JADX WARN: Type inference failed for: r0v63, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r0v64, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r0v65, types: [java.lang.Object, java.util.List] */
        /* JADX WARN: Type inference failed for: r0v67 */
        /* JADX WARN: Type inference failed for: r0v89 */
        /* JADX WARN: Type inference failed for: r0v90 */
        /* JADX WARN: Type inference failed for: r0v91 */
        /* JADX WARN: Type inference failed for: r0v92 */
        /* JADX WARN: Type inference failed for: r0v93 */
        /* JADX WARN: Type inference failed for: r0v94 */
        /* JADX WARN: Type inference failed for: r0v95 */
        /* JADX WARN: Type inference failed for: r0v96 */
        /* JADX WARN: Type inference failed for: r0v97 */
        /* JADX WARN: Type inference failed for: r11v0, types: [java.lang.Object, kotlin.coroutines.Continuation] */
        /* JADX WARN: Type inference failed for: r11v1, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r11v18 */
        /* JADX WARN: Type inference failed for: r11v19 */
        /* JADX WARN: Type inference failed for: r11v20, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r11v21, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r11v22 */
        /* JADX WARN: Type inference failed for: r11v23 */
        /* JADX WARN: Type inference failed for: r11v24 */
        /* JADX WARN: Type inference failed for: r11v25 */
        /* JADX WARN: Type inference failed for: r16v0, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r1v147 */
        /* JADX WARN: Type inference failed for: r1v148 */
        /* JADX WARN: Type inference failed for: r1v149 */
        /* JADX WARN: Type inference failed for: r1v150 */
        /* JADX WARN: Type inference failed for: r1v151 */
        /* JADX WARN: Type inference failed for: r1v152 */
        /* JADX WARN: Type inference failed for: r1v7, types: [kotlinx.coroutines.sync.Mutex] */
        /* JADX WARN: Type inference failed for: r1v74 */
        /* JADX WARN: Type inference failed for: r1v78, types: [com.metrolist.innertube.models.ArtistItem] */
        /* JADX WARN: Type inference failed for: r1v81, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r1v83, types: [com.metrolist.innertube.models.ArtistItem, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r1v84 */
        /* JADX WARN: Type inference failed for: r1v85 */
        /* JADX WARN: Type inference failed for: r1v89, types: [com.metrolist.innertube.models.ArtistItem, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object, kotlinx.coroutines.sync.Mutex] */
        /* JADX WARN: Type inference failed for: r2v10, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r2v21, types: [byte] */
        /* JADX WARN: Type inference failed for: r2v22 */
        /* JADX WARN: Type inference failed for: r2v23 */
        /* JADX WARN: Type inference failed for: r2v24 */
        /* JADX WARN: Type inference failed for: r2v25, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r2v26 */
        /* JADX WARN: Type inference failed for: r2v27, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r2v28, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r2v29, types: [java.lang.Object, java.util.Iterator] */
        /* JADX WARN: Type inference failed for: r2v30 */
        /* JADX WARN: Type inference failed for: r2v31 */
        /* JADX WARN: Type inference failed for: r2v32 */
        /* JADX WARN: Type inference failed for: r2v36 */
        /* JADX WARN: Type inference failed for: r2v41 */
        /* JADX WARN: Type inference failed for: r2v42 */
        /* JADX WARN: Type inference failed for: r2v52 */
        /* JADX WARN: Type inference failed for: r2v53 */
        /* JADX WARN: Type inference failed for: r2v54 */
        /* JADX WARN: Type inference failed for: r2v55 */
        /* JADX WARN: Type inference failed for: r2v56 */
        /* JADX WARN: Type inference failed for: r2v57 */
        /* JADX WARN: Type inference failed for: r2v58 */
        /* JADX WARN: Type inference failed for: r2v59 */
        /* JADX WARN: Type inference failed for: r2v60 */
        /* JADX WARN: Type inference failed for: r2v61 */
        /* JADX WARN: Type inference failed for: r2v62 */
        /* JADX WARN: Type inference failed for: r2v63 */
        /* JADX WARN: Type inference failed for: r2v64 */
        /* JADX WARN: Type inference failed for: r2v65 */
        /* JADX WARN: Type inference failed for: r3v0 */
        /* JADX WARN: Type inference failed for: r3v29 */
        /* JADX WARN: Type inference failed for: r3v30 */
        /* JADX WARN: Type inference failed for: r3v31, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r3v32, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r3v33, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r3v34 */
        /* JADX WARN: Type inference failed for: r3v36 */
        /* JADX WARN: Type inference failed for: r3v37 */
        /* JADX WARN: Type inference failed for: r3v38 */
        /* JADX WARN: Type inference failed for: r3v41 */
        /* JADX WARN: Type inference failed for: r3v42, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r3v46, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r3v59 */
        /* JADX WARN: Type inference failed for: r3v60 */
        /* JADX WARN: Type inference failed for: r3v61 */
        /* JADX WARN: Type inference failed for: r3v62 */
        /* JADX WARN: Type inference failed for: r3v63 */
        /* JADX WARN: Type inference failed for: r3v64 */
        /* JADX WARN: Type inference failed for: r3v65 */
        /* JADX WARN: Type inference failed for: r3v66 */
        /* JADX WARN: Type inference failed for: r3v67 */
        /* JADX WARN: Type inference failed for: r3v68 */
        /* JADX WARN: Type inference failed for: r3v69 */
        /* JADX WARN: Type inference failed for: r3v70 */
        /* JADX WARN: Type inference failed for: r4v0, types: [byte, int] */
        /* JADX WARN: Type inference failed for: r4v12, types: [kotlin.jvm.functions.Function2] */
        /* JADX WARN: Type inference failed for: r4v19 */
        /* JADX WARN: Type inference failed for: r4v38 */
        /* JADX WARN: Type inference failed for: r4v39 */
        /* JADX WARN: Type inference failed for: r4v40 */
        /* JADX WARN: Type inference failed for: r4v41, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r4v42 */
        /* JADX WARN: Type inference failed for: r4v43 */
        /* JADX WARN: Type inference failed for: r4v44, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r4v45, types: [com.metrolist.music.utils.SyncUtils, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r4v46, types: [com.metrolist.music.utils.SyncUtils, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r4v47 */
        /* JADX WARN: Type inference failed for: r4v48 */
        /* JADX WARN: Type inference failed for: r4v49 */
        /* JADX WARN: Type inference failed for: r4v52 */
        /* JADX WARN: Type inference failed for: r4v53 */
        /* JADX WARN: Type inference failed for: r4v55 */
        /* JADX WARN: Type inference failed for: r4v56, types: [com.metrolist.music.utils.SyncUtils, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r4v57 */
        /* JADX WARN: Type inference failed for: r4v59, types: [com.metrolist.music.utils.SyncUtils] */
        /* JADX WARN: Type inference failed for: r4v66 */
        /* JADX WARN: Type inference failed for: r4v67 */
        /* JADX WARN: Type inference failed for: r4v68 */
        /* JADX WARN: Type inference failed for: r4v69 */
        /* JADX WARN: Type inference failed for: r4v70 */
        /* JADX WARN: Type inference failed for: r4v71 */
        /* JADX WARN: Type inference failed for: r4v72 */
        /* JADX WARN: Type inference failed for: r4v73 */
        /* JADX WARN: Type inference failed for: r4v74 */
        /* JADX WARN: Type inference failed for: r4v75 */
        /* JADX WARN: Type inference failed for: r4v76 */
        /* JADX WARN: Type inference failed for: r4v77 */
        /* JADX WARN: Type inference failed for: r4v78 */
        /* JADX WARN: Type inference failed for: r4v79 */
        /* JADX WARN: Type inference failed for: r4v80 */
        /* JADX WARN: Type inference failed for: r4v81 */
        /* JADX WARN: Type inference failed for: r4v82 */
        /* JADX WARN: Type inference failed for: r4v83 */
        /* JADX WARN: Type inference failed for: r4v84 */
        /* JADX WARN: Type inference failed for: r4v85 */
        /* JADX WARN: Type inference failed for: r7v0 */
        /* JADX WARN: Type inference failed for: r7v11 */
        /* JADX WARN: Type inference failed for: r7v12 */
        /* JADX WARN: Type inference failed for: r7v13, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r7v14, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r7v15, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r7v16 */
        /* JADX WARN: Type inference failed for: r7v17 */
        /* JADX WARN: Type inference failed for: r7v30 */
        /* JADX WARN: Type inference failed for: r7v31 */
        /* JADX WARN: Type inference failed for: r7v32 */
        /* JADX WARN: Type inference failed for: r7v33 */
        /* JADX WARN: Type inference failed for: r7v34 */
        /* JADX WARN: Type inference failed for: r7v35 */
        /* JADX WARN: Type inference failed for: r7v36 */
        /* JADX WARN: Type inference failed for: r7v37 */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:110:0x02a3 -> B:114:0x02ab). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:140:0x0346 -> B:145:0x035b). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:144:0x034e -> B:145:0x035b). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0084 -> B:26:0x0087). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:123:0x02ee
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r31) {
            /*
                Method dump skipped, instruction units count: 1930
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.dokar.quickjs.QuickJs.AnonymousClass3.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(Playlist playlist, MutableState mutableState, Uri uri, Ref$BooleanRef ref$BooleanRef, MusicDatabase musicDatabase, Context context, SnackbarHostState snackbarHostState, Continuation continuation) {
            super(2, continuation);
            this.$r8$classId = (byte) 3;
            this.L$2 = playlist;
            this.L$3 = mutableState;
            this.this$0 = uri;
            this.L$4 = ref$BooleanRef;
            this.$handle = musicDatabase;
            this.$session = context;
            this.$evaluation = snackbarHostState;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(SyncUtils syncUtils, Continuation continuation) {
            super(2, continuation);
            this.$r8$classId = (byte) 4;
            this.$evaluation = syncUtils;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass3(Object obj, Object obj2, Object obj3, Object obj4, Continuation continuation, byte b) {
            super(2, continuation);
            this.$r8$classId = b;
            this.L$4 = obj;
            this.$handle = obj2;
            this.$session = obj3;
            this.$evaluation = obj4;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(QuickJs quickJs, EvaluationSession evaluationSession, EvaluationState evaluationState, Long l, Continuation continuation) {
            super(2, continuation);
            this.$r8$classId = (byte) 0;
            this.this$0 = quickJs;
            this.$session = evaluationSession;
            this.$evaluation = evaluationState;
            this.$handle = l;
        }
    }

    private final void onModuleLoadFailed(String name) {
    }

    private final void onModuleCompiled(String name, byte[] bytecode) {
    }

    public final <R> void defineBinding(String name, AsyncFunctionBinding binding) throws QuickJsException {
        name.getClass();
        binding.getClass();
        if (BindingCallbackContext_jniKt.isInBindingCallback(this)) {
            ensureNotClosed();
            defineFunction(this.globals, this.context, name, true);
            this.globalFunctions.put(name, binding);
            return;
        }
        Mutex mutex = this.jsMutex;
        while (!mutex.tryLock()) {
            try {
                Thread.yield();
            } catch (Throwable th) {
                mutex.unlock(null);
                throw th;
            }
        }
        ensureNotClosed();
        defineFunction(this.globals, this.context, name, true);
        this.globalFunctions.put(name, binding);
        mutex.unlock(null);
    }

    public final void addModule(byte[] bytecode) throws QuickJsException {
        bytecode.getClass();
        if (BindingCallbackContext_jniKt.isInBindingCallback(this)) {
            ensureNotClosed();
            this.modules.add(bytecode);
            return;
        }
        Mutex mutex = this.jsMutex;
        while (!mutex.tryLock()) {
            try {
                Thread.yield();
            } catch (Throwable th) {
                mutex.unlock(null);
                throw th;
            }
        }
        ensureNotClosed();
        this.modules.add(bytecode);
        mutex.unlock(null);
    }

    public /* synthetic */ QuickJs(CoroutineDispatcher coroutineDispatcher, ModuleLoader moduleLoader, DefaultConstructorMarker defaultConstructorMarker) {
        this(coroutineDispatcher, moduleLoader);
    }
}
