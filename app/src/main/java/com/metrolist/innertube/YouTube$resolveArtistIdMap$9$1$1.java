package com.metrolist.innertube;

import com.metrolist.innertube.models.ArtistItem;
import com.metrolist.innertube.pages.SearchResult;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.SemaphoreImpl;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class YouTube$resolveArtistIdMap$9$1$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ String $name;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ SemaphoreImpl $semaphore;
    public byte label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ YouTube$resolveArtistIdMap$9$1$1(SemaphoreImpl semaphoreImpl, String str, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$semaphore = semaphoreImpl;
        this.$name = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        String str = this.$name;
        SemaphoreImpl semaphoreImpl = this.$semaphore;
        switch (b) {
            case 0:
                return new YouTube$resolveArtistIdMap$9$1$1(semaphoreImpl, str, continuation, (byte) 0);
            default:
                return new YouTube$resolveArtistIdMap$9$1$1(semaphoreImpl, str, continuation, (byte) 1);
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
        }
        return ((YouTube$resolveArtistIdMap$9$1$1) create(coroutineScope, continuation)).invokeSuspend(unit);
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0065 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:103:0x0097 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:107:0x0112 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:109:0x0104 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:111:0x0136 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:22:0x004d  */
    /* JADX WARN: Code duplicated, block: B:25:0x005a A[Catch: all -> 0x0023, TryCatch #1 {all -> 0x0023, blocks: (B:8:0x001b, B:20:0x0049, B:23:0x004e, B:25:0x005a, B:26:0x0065, B:28:0x006b, B:30:0x0073, B:31:0x0077, B:33:0x007d, B:37:0x0098, B:39:0x009c, B:42:0x00a2, B:17:0x003d), top: B:96:0x0015 }] */
    /* JADX WARN: Code duplicated, block: B:28:0x006b A[Catch: all -> 0x0023, TryCatch #1 {all -> 0x0023, blocks: (B:8:0x001b, B:20:0x0049, B:23:0x004e, B:25:0x005a, B:26:0x0065, B:28:0x006b, B:30:0x0073, B:31:0x0077, B:33:0x007d, B:37:0x0098, B:39:0x009c, B:42:0x00a2, B:17:0x003d), top: B:96:0x0015 }] */
    /* JADX WARN: Code duplicated, block: B:33:0x007d A[Catch: all -> 0x0023, TryCatch #1 {all -> 0x0023, blocks: (B:8:0x001b, B:20:0x0049, B:23:0x004e, B:25:0x005a, B:26:0x0065, B:28:0x006b, B:30:0x0073, B:31:0x0077, B:33:0x007d, B:37:0x0098, B:39:0x009c, B:42:0x00a2, B:17:0x003d), top: B:96:0x0015 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x009c A[Catch: all -> 0x0023, TryCatch #1 {all -> 0x0023, blocks: (B:8:0x001b, B:20:0x0049, B:23:0x004e, B:25:0x005a, B:26:0x0065, B:28:0x006b, B:30:0x0073, B:31:0x0077, B:33:0x007d, B:37:0x0098, B:39:0x009c, B:42:0x00a2, B:17:0x003d), top: B:96:0x0015 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x009f  */
    /* JADX WARN: Code duplicated, block: B:42:0x00a2 A[Catch: all -> 0x0023, TRY_LEAVE, TryCatch #1 {all -> 0x0023, blocks: (B:8:0x001b, B:20:0x0049, B:23:0x004e, B:25:0x005a, B:26:0x0065, B:28:0x006b, B:30:0x0073, B:31:0x0077, B:33:0x007d, B:37:0x0098, B:39:0x009c, B:42:0x00a2, B:17:0x003d), top: B:96:0x0015 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:67:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:70:0x00f9 A[Catch: all -> 0x00c2, TryCatch #0 {all -> 0x00c2, blocks: (B:53:0x00ba, B:65:0x00e8, B:68:0x00ed, B:70:0x00f9, B:71:0x0104, B:73:0x010a, B:75:0x0112, B:76:0x0116, B:78:0x011c, B:82:0x0137, B:84:0x013b, B:87:0x0141, B:62:0x00dc), top: B:94:0x00b4 }] */
    /* JADX WARN: Code duplicated, block: B:73:0x010a A[Catch: all -> 0x00c2, TryCatch #0 {all -> 0x00c2, blocks: (B:53:0x00ba, B:65:0x00e8, B:68:0x00ed, B:70:0x00f9, B:71:0x0104, B:73:0x010a, B:75:0x0112, B:76:0x0116, B:78:0x011c, B:82:0x0137, B:84:0x013b, B:87:0x0141, B:62:0x00dc), top: B:94:0x00b4 }] */
    /* JADX WARN: Code duplicated, block: B:78:0x011c A[Catch: all -> 0x00c2, TryCatch #0 {all -> 0x00c2, blocks: (B:53:0x00ba, B:65:0x00e8, B:68:0x00ed, B:70:0x00f9, B:71:0x0104, B:73:0x010a, B:75:0x0112, B:76:0x0116, B:78:0x011c, B:82:0x0137, B:84:0x013b, B:87:0x0141, B:62:0x00dc), top: B:94:0x00b4 }] */
    /* JADX WARN: Code duplicated, block: B:84:0x013b A[Catch: all -> 0x00c2, TryCatch #0 {all -> 0x00c2, blocks: (B:53:0x00ba, B:65:0x00e8, B:68:0x00ed, B:70:0x00f9, B:71:0x0104, B:73:0x010a, B:75:0x0112, B:76:0x0116, B:78:0x011c, B:82:0x0137, B:84:0x013b, B:87:0x0141, B:62:0x00dc), top: B:94:0x00b4 }] */
    /* JADX WARN: Code duplicated, block: B:85:0x013e  */
    /* JADX WARN: Code duplicated, block: B:87:0x0141 A[Catch: all -> 0x00c2, TRY_LEAVE, TryCatch #0 {all -> 0x00c2, blocks: (B:53:0x00ba, B:65:0x00e8, B:68:0x00ed, B:70:0x00f9, B:71:0x0104, B:73:0x010a, B:75:0x0112, B:76:0x0116, B:78:0x011c, B:82:0x0137, B:84:0x013b, B:87:0x0141, B:62:0x00dc), top: B:94:0x00b4 }] */
    /* JADX WARN: Code duplicated, block: B:89:0x0148  */
    /* JADX WARN: Code duplicated, block: B:99:0x0073 A[SYNTHETIC] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objM1039searchMVsJJCw;
        SearchResult searchResult;
        String string;
        String str;
        Pair pair;
        ArrayList arrayList;
        int size;
        Object obj2;
        ArtistItem artistItem;
        Object objM1039searchMVsJJCw2;
        SearchResult searchResult2;
        String string2;
        String str2;
        Pair pair2;
        ArrayList arrayList2;
        int size2;
        Object obj3;
        ArtistItem artistItem2;
        byte b = this.$r8$classId;
        int i = 0;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        SemaphoreImpl semaphoreImpl = this.$semaphore;
        String str3 = this.$name;
        switch (b) {
            case 0:
                byte b2 = this.label;
                try {
                    if (b2 != 0) {
                        if (b2 == 1) {
                            ResultKt.throwOnFailure(obj);
                        } else {
                            if (b2 != 2) {
                                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                                return null;
                            }
                            ResultKt.throwOnFailure(obj);
                            objM1039searchMVsJJCw = ((Result) obj).value;
                        }
                        if (objM1039searchMVsJJCw instanceof Result.Failure) {
                            objM1039searchMVsJJCw = null;
                        }
                        searchResult = (SearchResult) objM1039searchMVsJJCw;
                        string = StringsKt.trim(str3).toString();
                        if (searchResult != null) {
                            List list = searchResult.items;
                            arrayList = new ArrayList();
                            for (Object obj4 : list) {
                                if (obj4 instanceof ArtistItem) {
                                    arrayList.add(obj4);
                                }
                            }
                            size = arrayList.size();
                            do {
                                if (i < size) {
                                    obj2 = arrayList.get(i);
                                    i++;
                                } else {
                                    obj2 = null;
                                }
                                artistItem = (ArtistItem) obj2;
                                if (artistItem != null) {
                                    str = artistItem.id;
                                } else {
                                    str = null;
                                }
                            } while (!StringsKt__StringsJVMKt.equals(StringsKt.trim(((ArtistItem) obj2).title).toString(), string, true));
                            artistItem = (ArtistItem) obj2;
                            if (artistItem != null) {
                                str = artistItem.id;
                            } else {
                                str = null;
                            }
                        } else {
                            str = null;
                        }
                        if (str != null) {
                            pair = new Pair(str3, str);
                        } else {
                            pair = null;
                        }
                        semaphoreImpl.release();
                        return pair;
                    }
                    ResultKt.throwOnFailure(obj);
                    this.label = (byte) 1;
                    if (semaphoreImpl.acquire(this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    YouTube youTube = YouTube.INSTANCE;
                    this.label = (byte) 2;
                    objM1039searchMVsJJCw = YouTube.INSTANCE.m1039searchMVsJJCw(str3, "EgWKAQIgAWoKEAkQChAFEAMQBA%3D%3D", false, this);
                    if (objM1039searchMVsJJCw == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    if (objM1039searchMVsJJCw instanceof Result.Failure) {
                        objM1039searchMVsJJCw = null;
                    }
                    searchResult = (SearchResult) objM1039searchMVsJJCw;
                    string = StringsKt.trim(str3).toString();
                    if (searchResult != null) {
                        List list2 = searchResult.items;
                        arrayList = new ArrayList();
                        while (r10.hasNext()) {
                            if (obj4 instanceof ArtistItem) {
                                arrayList.add(obj4);
                            }
                        }
                        size = arrayList.size();
                        do {
                            if (i < size) {
                                obj2 = arrayList.get(i);
                                i++;
                            } else {
                                obj2 = null;
                            }
                            artistItem = (ArtistItem) obj2;
                            if (artistItem != null) {
                                str = artistItem.id;
                            } else {
                                str = null;
                            }
                        } while (!StringsKt__StringsJVMKt.equals(StringsKt.trim(((ArtistItem) obj2).title).toString(), string, true));
                        artistItem = (ArtistItem) obj2;
                        if (artistItem != null) {
                            str = artistItem.id;
                        } else {
                            str = null;
                        }
                    } else {
                        str = null;
                    }
                    if (str != null) {
                        pair = new Pair(str3, str);
                    } else {
                        pair = null;
                    }
                    semaphoreImpl.release();
                    return pair;
                } catch (Throwable th) {
                    semaphoreImpl.release();
                    throw th;
                }
            default:
                byte b3 = this.label;
                try {
                    if (b3 != 0) {
                        if (b3 == 1) {
                            ResultKt.throwOnFailure(obj);
                        } else {
                            if (b3 != 2) {
                                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                                return null;
                            }
                            ResultKt.throwOnFailure(obj);
                            objM1039searchMVsJJCw2 = ((Result) obj).value;
                        }
                        if (objM1039searchMVsJJCw2 instanceof Result.Failure) {
                            objM1039searchMVsJJCw2 = null;
                        }
                        searchResult2 = (SearchResult) objM1039searchMVsJJCw2;
                        string2 = StringsKt.trim(str3).toString();
                        if (searchResult2 != null) {
                            List list3 = searchResult2.items;
                            arrayList2 = new ArrayList();
                            for (Object obj5 : list3) {
                                if (obj5 instanceof ArtistItem) {
                                    arrayList2.add(obj5);
                                }
                            }
                            size2 = arrayList2.size();
                            do {
                                if (i < size2) {
                                    obj3 = arrayList2.get(i);
                                    i++;
                                } else {
                                    obj3 = null;
                                }
                                artistItem2 = (ArtistItem) obj3;
                                if (artistItem2 != null) {
                                    str2 = artistItem2.id;
                                } else {
                                    str2 = null;
                                }
                            } while (!StringsKt__StringsJVMKt.equals(StringsKt.trim(((ArtistItem) obj3).title).toString(), string2, true));
                            artistItem2 = (ArtistItem) obj3;
                            if (artistItem2 != null) {
                                str2 = artistItem2.id;
                            } else {
                                str2 = null;
                            }
                        } else {
                            str2 = null;
                        }
                        if (str2 != null) {
                            pair2 = new Pair(str3, str2);
                        } else {
                            pair2 = null;
                        }
                        semaphoreImpl.release();
                        return pair2;
                    }
                    ResultKt.throwOnFailure(obj);
                    this.label = (byte) 1;
                    if (semaphoreImpl.acquire(this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    YouTube youTube2 = YouTube.INSTANCE;
                    this.label = (byte) 2;
                    objM1039searchMVsJJCw2 = YouTube.INSTANCE.m1039searchMVsJJCw(str3, "EgWKAQIgAWoKEAkQChAFEAMQBA%3D%3D", false, this);
                    if (objM1039searchMVsJJCw2 == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    if (objM1039searchMVsJJCw2 instanceof Result.Failure) {
                        objM1039searchMVsJJCw2 = null;
                    }
                    searchResult2 = (SearchResult) objM1039searchMVsJJCw2;
                    string2 = StringsKt.trim(str3).toString();
                    if (searchResult2 != null) {
                        List list4 = searchResult2.items;
                        arrayList2 = new ArrayList();
                        while (r10.hasNext()) {
                            if (obj5 instanceof ArtistItem) {
                                arrayList2.add(obj5);
                            }
                        }
                        size2 = arrayList2.size();
                        do {
                            if (i < size2) {
                                obj3 = arrayList2.get(i);
                                i++;
                            } else {
                                obj3 = null;
                            }
                            artistItem2 = (ArtistItem) obj3;
                            if (artistItem2 != null) {
                                str2 = artistItem2.id;
                            } else {
                                str2 = null;
                            }
                        } while (!StringsKt__StringsJVMKt.equals(StringsKt.trim(((ArtistItem) obj3).title).toString(), string2, true));
                        artistItem2 = (ArtistItem) obj3;
                        if (artistItem2 != null) {
                            str2 = artistItem2.id;
                        } else {
                            str2 = null;
                        }
                    } else {
                        str2 = null;
                    }
                    if (str2 != null) {
                        pair2 = new Pair(str3, str2);
                    } else {
                        pair2 = null;
                    }
                    semaphoreImpl.release();
                    return pair2;
                } catch (Throwable th2) {
                    semaphoreImpl.release();
                    throw th2;
                }
        }
    }
}
