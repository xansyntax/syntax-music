package com.metrolist.innertubex.cipher;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.collections.ReversedListReadOnly;
import kotlin.text.HexFormatKt;
import kotlin.text.MatcherMatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.uuid.UuidKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;
import okhttp3.Headers;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class RemotePlayerConfigParser {
    public static final Regex SIG_RE = new Regex("^[A-Za-z0-9$_]{1,8}\\(\\d+,\\d+,INPUT\\)$");
    public static final Regex NCLASS_RE = new Regex("^[A-Za-z0-9$_]{1,8}$");
    public static final Regex HASH_RE = new Regex("^[a-f0-9]{8}$");
    public static final List PLAYER_HASH_PATTERNS = CollectionsKt__IterablesKt.listOf((Object[]) new Regex[]{new Regex("/player/([a-f0-9]{8})/"), new Regex("player_ias\\.vflset/[^/]+/([a-f0-9]{8})/"), new Regex("/s/player/([a-f0-9]{8})/")});

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class HardcodedPlayerConfig {
        public final String nJsExpression;
        public final String sigJsExpression;
        public final int signatureTimestamp;

        public HardcodedPlayerConfig(String str, String str2, int i) {
            this.sigJsExpression = str;
            this.nJsExpression = str2;
            this.signatureTimestamp = i;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof HardcodedPlayerConfig)) {
                return false;
            }
            HardcodedPlayerConfig hardcodedPlayerConfig = (HardcodedPlayerConfig) obj;
            return this.sigJsExpression.equals(hardcodedPlayerConfig.sigJsExpression) && this.nJsExpression.equals(hardcodedPlayerConfig.nJsExpression) && this.signatureTimestamp == hardcodedPlayerConfig.signatureTimestamp;
        }

        public final int hashCode() {
            return Integer.hashCode(this.signatureTimestamp) + Fragment$5$$ExternalSyntheticOutline0.m((((this.sigJsExpression.hashCode() + ((-998193190) * 31 * 29791)) * 31) + 1419319747) * 29791, 31, this.nJsExpression);
        }

        public final String toString() {
            return Fragment$5$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m("HardcodedPlayerConfig(sigFuncName=_expr_sig, sigConstantArg=null, sigConstantArgs=null, sigPreprocessFunc=null, sigPreprocessArgs=null, sigJsExpression=", this.sigJsExpression, ", nFuncName=_expr_n, nArrayIndex=null, nConstantArgs=null, nJsExpression=", this.nJsExpression, ", signatureTimestamp="), this.signatureTimestamp, ")");
        }
    }

    public static String extractPlayerHash(String str) {
        str.getClass();
        Iterator it = PLAYER_HASH_PATTERNS.iterator();
        while (it.hasNext()) {
            MatcherMatchResult matcherMatchResultFind$default = Regex.find$default((Regex) it.next(), str);
            if (matcherMatchResultFind$default != null) {
                return (String) ((ReversedListReadOnly) matcherMatchResultFind$default.getGroupValues()).get(1);
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:65:0x00e5  */
    public static HexFormatKt parse(String str) {
        String content;
        Integer intOrNull;
        Pair pair;
        Object obj;
        Object next;
        String content2;
        String content3;
        Integer intOrNull2;
        int iIntValue;
        Object obj2;
        String content4;
        str.getClass();
        try {
            JsonElement toJsonElement = Json.Default.parseToJsonElement(str);
            JsonObject jsonObject = toJsonElement instanceof JsonObject ? (JsonObject) toJsonElement : null;
            if (jsonObject == null) {
                return new RemotePlayerConfigParser$ParseResult$Failure("root is not a JSON object");
            }
            Object obj3 = jsonObject.get("schemaVersion");
            JsonPrimitive jsonPrimitive = obj3 instanceof JsonPrimitive ? (JsonPrimitive) obj3 : null;
            if (jsonPrimitive != null) {
                if (jsonPrimitive.isString()) {
                    jsonPrimitive = null;
                }
                if (jsonPrimitive != null && (content = jsonPrimitive.getContent()) != null && (intOrNull = StringsKt__StringsJVMKt.toIntOrNull(10, content)) != null) {
                    int iIntValue2 = intOrNull.intValue();
                    if (iIntValue2 <= 0) {
                        return new RemotePlayerConfigParser$ParseResult$Failure("schemaVersion must be positive");
                    }
                    if (iIntValue2 > 1) {
                        return new RemotePlayerConfigParser$ParseResult$Failure(IntIntPair$$ExternalSyntheticOutline0.m(iIntValue2, "unsupported schemaVersion ", " (supported: 1)"));
                    }
                    Object obj4 = jsonObject.get("players");
                    JsonObject jsonObject2 = obj4 instanceof JsonObject ? (JsonObject) obj4 : null;
                    if (jsonObject2 == null) {
                        return new RemotePlayerConfigParser$ParseResult$Failure("players missing or not an object");
                    }
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    ArrayList arrayList = new ArrayList();
                    for (Map.Entry entry : jsonObject2.content.entrySet()) {
                        String str2 = (String) entry.getKey();
                        JsonElement jsonElement = (JsonElement) entry.getValue();
                        JsonObject jsonObject3 = jsonElement instanceof JsonObject ? (JsonObject) jsonElement : null;
                        if (jsonObject3 != null) {
                            Regex regex = HASH_RE;
                            if (regex.matches(str2)) {
                                Object obj5 = jsonObject3.get("sig");
                                JsonPrimitive jsonPrimitive2 = obj5 instanceof JsonPrimitive ? (JsonPrimitive) obj5 : null;
                                if (jsonPrimitive2 == null) {
                                    pair = null;
                                } else {
                                    if (!jsonPrimitive2.isString()) {
                                        jsonPrimitive2 = null;
                                    }
                                    if (jsonPrimitive2 == null || (content2 = jsonPrimitive2.getContent()) == null || !SIG_RE.matches(content2)) {
                                        pair = null;
                                    } else {
                                        Object obj6 = jsonObject3.get("nClass");
                                        JsonPrimitive jsonPrimitive3 = obj6 instanceof JsonPrimitive ? (JsonPrimitive) obj6 : null;
                                        if (jsonPrimitive3 == null) {
                                            pair = null;
                                        } else {
                                            if (!jsonPrimitive3.isString()) {
                                                jsonPrimitive3 = null;
                                            }
                                            if (jsonPrimitive3 == null || (content3 = jsonPrimitive3.getContent()) == null || !NCLASS_RE.matches(content3)) {
                                                pair = null;
                                            } else {
                                                Object obj7 = jsonObject3.get("sts");
                                                JsonPrimitive jsonPrimitive4 = obj7 instanceof JsonPrimitive ? (JsonPrimitive) obj7 : null;
                                                if (jsonPrimitive4 == null) {
                                                    pair = null;
                                                } else {
                                                    if (jsonPrimitive4.isString()) {
                                                        jsonPrimitive4 = null;
                                                    }
                                                    if (jsonPrimitive4 == null || (intOrNull2 = StringsKt__StringsJVMKt.toIntOrNull(jsonPrimitive4.getContent())) == null || (iIntValue = intOrNull2.intValue()) <= 0) {
                                                        pair = null;
                                                    } else {
                                                        JsonElement jsonElement2 = (JsonElement) jsonObject3.get("aliases");
                                                        if (jsonElement2 == null) {
                                                            obj2 = EmptyList.INSTANCE;
                                                        } else {
                                                            try {
                                                                JsonArray jsonArray = JsonElementKt.getJsonArray(jsonElement2);
                                                                ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(jsonArray, 10));
                                                                Iterator it = jsonArray.content.iterator();
                                                                while (true) {
                                                                    if (it.hasNext()) {
                                                                        JsonElement jsonElement3 = (JsonElement) it.next();
                                                                        JsonPrimitive jsonPrimitive5 = jsonElement3 instanceof JsonPrimitive ? (JsonPrimitive) jsonElement3 : null;
                                                                        if (jsonPrimitive5 != null) {
                                                                            if (!jsonPrimitive5.isString()) {
                                                                                jsonPrimitive5 = null;
                                                                            }
                                                                            if (jsonPrimitive5 != null && (content4 = jsonPrimitive5.getContent()) != null && regex.matches(content4)) {
                                                                                arrayList2.add(content4);
                                                                            }
                                                                        }
                                                                        pair = null;
                                                                    } else {
                                                                        obj2 = arrayList2;
                                                                    }
                                                                }
                                                            } catch (Exception unused) {
                                                            }
                                                        }
                                                        pair = new Pair(new HardcodedPlayerConfig(content2, IntIntPair$$ExternalSyntheticOutline0.m("(function(n){try{var u=new g.", content3, "('https://x.googlevideo.com/videoplayback?n='+n,true);var t=u.get('n');return(t&&t!==n)?t:n;}catch(e){return n;}})(INPUT)"), iIntValue), obj2);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            } else {
                                pair = null;
                            }
                        } else {
                            pair = null;
                        }
                        if (pair == null) {
                            arrayList.add(str2);
                        } else {
                            HardcodedPlayerConfig hardcodedPlayerConfig = (HardcodedPlayerConfig) pair.first;
                            List list = (List) pair.second;
                            ArrayList arrayListPlus = CollectionsKt.plus((Iterable) list, (Collection) CollectionsKt__IterablesKt.listOf(str2));
                            int size = arrayListPlus.size();
                            int i = 0;
                            do {
                                if (i >= size) {
                                    obj = null;
                                    break;
                                }
                                obj = arrayListPlus.get(i);
                                i++;
                            } while (!linkedHashMap.containsKey((String) obj));
                            String str3 = (String) obj;
                            if (str3 == null) {
                                Iterator it2 = UuidKt.eachCount(new Headers.Builder(arrayListPlus, (byte) 2)).entrySet().iterator();
                                do {
                                    if (!it2.hasNext()) {
                                        next = null;
                                        break;
                                    }
                                    next = it2.next();
                                } while (((Number) ((Map.Entry) next).getValue()).intValue() <= 1);
                                Map.Entry entry2 = (Map.Entry) next;
                                str3 = entry2 != null ? (String) entry2.getKey() : null;
                            }
                            if (str3 != null) {
                                return new RemotePlayerConfigParser$ParseResult$Failure(Fragment$5$$ExternalSyntheticOutline0.m("duplicate hash/alias '", str3, "' (entry ", str2, ")"));
                            }
                            linkedHashMap.put(str2, hardcodedPlayerConfig);
                            Iterator it3 = list.iterator();
                            while (it3.hasNext()) {
                                linkedHashMap.put((String) it3.next(), hardcodedPlayerConfig);
                            }
                        }
                    }
                    return new RemotePlayerConfigParser$ParseResult$Success(linkedHashMap, arrayList);
                }
            }
            return new RemotePlayerConfigParser$ParseResult$Failure("schemaVersion missing or not an int");
        } catch (Exception unused2) {
            return new RemotePlayerConfigParser$ParseResult$Failure("malformed JSON");
        }
    }

    public static Integer parseLegacySignatureTimestamp$com_github_MetrolistGroup_innertubex(String str, String str2) {
        Object failure;
        str.getClass();
        str2.getClass();
        try {
            Object toJsonElement = Json.Default.parseToJsonElement(str);
            failure = toJsonElement instanceof JsonObject ? (JsonObject) toJsonElement : null;
        } catch (Throwable th) {
            failure = new Result.Failure(th);
        }
        if (failure instanceof Result.Failure) {
            failure = null;
        }
        JsonObject jsonObject = (JsonObject) failure;
        if (jsonObject != null) {
            Object obj = jsonObject.get("playerHash");
            JsonPrimitive jsonPrimitive = obj instanceof JsonPrimitive ? (JsonPrimitive) obj : null;
            String content = jsonPrimitive != null ? jsonPrimitive.getContent() : null;
            if (content == null || content.equals(str2)) {
                Object obj2 = jsonObject.get("player");
                JsonObject jsonObject2 = obj2 instanceof JsonObject ? (JsonObject) obj2 : null;
                Integer numPositiveInt = positiveInt(jsonObject, "signatureTimestamp");
                if (numPositiveInt != null) {
                    return numPositiveInt;
                }
                Integer numPositiveInt2 = positiveInt(jsonObject, "sts");
                if (numPositiveInt2 == null) {
                    numPositiveInt2 = jsonObject2 != null ? positiveInt(jsonObject2, "signatureTimestamp") : null;
                    if (numPositiveInt2 == null) {
                        if (jsonObject2 != null) {
                            return positiveInt(jsonObject2, "sts");
                        }
                        return null;
                    }
                }
                return numPositiveInt2;
            }
        }
        return null;
    }

    public static Integer positiveInt(JsonObject jsonObject, String str) {
        String content;
        Integer intOrNull;
        Object obj = jsonObject.get(str);
        JsonPrimitive jsonPrimitive = obj instanceof JsonPrimitive ? (JsonPrimitive) obj : null;
        if (jsonPrimitive == null || (content = jsonPrimitive.getContent()) == null || (intOrNull = StringsKt__StringsJVMKt.toIntOrNull(10, content)) == null || intOrNull.intValue() <= 0) {
            return null;
        }
        return intOrNull;
    }
}
