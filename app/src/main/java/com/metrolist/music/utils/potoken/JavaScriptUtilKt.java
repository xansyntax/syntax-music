package com.metrolist.music.utils.potoken;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import com.metrolist.music.utils.InnerTubeXPlayer$$ExternalSyntheticLambda3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonDecodingException;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import okio.ByteString;
import okio.Okio__OkioKt;
import okio.Path;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u0012\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0001\u001a\u000e\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0001\u001a\u000e\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u0001\u001a\u0010\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u0001H\u0002\u001a\u0010\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u0001H\u0002\u001a\u0010\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0011H\u0002\u001a\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u0001H\u0002¨\u0006\u0013"}, d2 = {"parseChallengeData", "", "rawChallengeData", "parseIntegrityTokenData", "Lkotlin/Pair;", "", "rawIntegrityTokenData", "stringToU8", "identifier", "u8ToBase64", "poToken", "descramble", "scrambledChallenge", "base64ToU8", "base64", "newUint8Array", "contents", "", "base64ToByteString", "app"}, k = 2, mv = {2, 4, 0}, xi = 48)
public final class JavaScriptUtilKt {
    private static final byte[] base64ToByteString(String str) throws PoTokenException {
        String strReplace = StringsKt__StringsJVMKt.replace$default(str, '-', '+').replace('_', '/');
        strReplace.getClass();
        String strReplace2 = strReplace.replace('.', '=');
        strReplace2.getClass();
        ByteString byteString = ByteString.EMPTY;
        ByteString byteStringDecodeBase64 = Path.Companion.decodeBase64(strReplace2);
        if (byteStringDecodeBase64 != null) {
            return byteStringDecodeBase64.toByteArray();
        }
        throw new PoTokenException("Cannot base64 decode");
    }

    private static final String base64ToU8(String str) {
        return newUint8Array(base64ToByteString(str));
    }

    private static final String descramble(String str) throws PoTokenException {
        byte[] bArrBase64ToByteString = base64ToByteString(str);
        ArrayList arrayList = new ArrayList(bArrBase64ToByteString.length);
        for (byte b : bArrBase64ToByteString) {
            arrayList.add(Byte.valueOf((byte) (b + 97)));
        }
        return StringsKt__StringsJVMKt.decodeToString(CollectionsKt.toByteArray(arrayList));
    }

    private static final String newUint8Array(byte[] bArr) {
        return IntIntPair$$ExternalSyntheticOutline0.m("new Uint8Array([", ArraysKt.joinToString$default(bArr, ",", new InnerTubeXPlayer$$ExternalSyntheticLambda3((byte) 29), 30), "])");
    }

    public static final String parseChallengeData(String str) {
        JsonElement jsonElement;
        Object next;
        str.getClass();
        Json.Default r0 = Json.Default;
        JsonArray jsonArray = JsonElementKt.getJsonArray(r0.parseToJsonElement(str));
        JsonArray jsonArray2 = (jsonArray.content.size() <= 1 || !JsonElementKt.getJsonPrimitive(jsonArray.get(1)).isString()) ? JsonElementKt.getJsonArray(jsonArray.get(0)) : JsonElementKt.getJsonArray(r0.parseToJsonElement(descramble(JsonElementKt.getJsonPrimitive(jsonArray.get(1)).getContent())));
        String content = JsonElementKt.getJsonPrimitive(jsonArray2.get(0)).getContent();
        String content2 = JsonElementKt.getJsonPrimitive(jsonArray2.get(3)).getContent();
        String content3 = JsonElementKt.getJsonPrimitive(jsonArray2.get(4)).getContent();
        String content4 = JsonElementKt.getJsonPrimitive(jsonArray2.get(5)).getContent();
        String content5 = JsonElementKt.getJsonPrimitive(jsonArray2.get(7)).getContent();
        JsonElement jsonElement2 = jsonArray2.get(1);
        Object obj = null;
        if (jsonElement2 instanceof JsonNull) {
            jsonElement2 = null;
        }
        if (jsonElement2 != null) {
            Iterator it = JsonElementKt.getJsonArray(jsonElement2).content.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!JsonElementKt.getJsonPrimitive((JsonElement) next).isString());
            jsonElement = (JsonElement) next;
        } else {
            jsonElement = null;
        }
        JsonElement jsonElement3 = jsonArray2.get(2);
        if (jsonElement3 instanceof JsonNull) {
            jsonElement3 = null;
        }
        if (jsonElement3 != null) {
            for (Object obj2 : JsonElementKt.getJsonArray(jsonElement3).content) {
                if (JsonElementKt.getJsonPrimitive((JsonElement) obj2).isString()) {
                    obj = obj2;
                    break;
                }
            }
            obj = (JsonElement) obj;
        }
        Json.Default r15 = Json.Default;
        KSerializer kSerializerSerializer = JsonObject.INSTANCE.serializer();
        Pair pair = new Pair("messageId", JsonElementKt.JsonPrimitive(content));
        if (jsonElement == null) {
            jsonElement = JsonNull.INSTANCE;
        }
        Pair pair2 = new Pair("privateDoNotAccessOrElseSafeScriptWrappedValue", jsonElement);
        if (obj == null) {
            obj = JsonNull.INSTANCE;
        }
        return r15.encodeToString(kSerializerSerializer, new JsonObject(MapsKt__MapsKt.mapOf(pair, new Pair("interpreterJavascript", new JsonObject(MapsKt__MapsKt.mapOf(pair2, new Pair("privateDoNotAccessOrElseTrustedResourceUrlWrappedValue", obj)))), new Pair("interpreterHash", JsonElementKt.JsonPrimitive(content2)), new Pair("program", JsonElementKt.JsonPrimitive(content3)), new Pair("globalName", JsonElementKt.JsonPrimitive(content4)), new Pair("clientExperimentsStateBlob", JsonElementKt.JsonPrimitive(content5)))));
    }

    public static final Pair parseIntegrityTokenData(String str) {
        str.getClass();
        JsonArray jsonArray = JsonElementKt.getJsonArray(Json.Default.parseToJsonElement(str));
        try {
            return new Pair(base64ToU8(JsonElementKt.getJsonPrimitive(jsonArray.get(0)).getContent()), Long.valueOf(JsonElementKt.parseLongImpl(JsonElementKt.getJsonPrimitive(jsonArray.get(1)))));
        } catch (JsonDecodingException e) {
            throw new NumberFormatException(e.message);
        }
    }

    public static final String stringToU8(String str) {
        str.getClass();
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        bytes.getClass();
        return newUint8Array(bytes);
    }

    public static final String u8ToBase64(String str) {
        str.getClass();
        ByteString byteString = ByteString.EMPTY;
        List listSplit$default = StringsKt.split$default(str, new String[]{","}, 0, 6);
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(listSplit$default, 10));
        Iterator it = listSplit$default.iterator();
        while (it.hasNext()) {
            arrayList.add(Byte.valueOf(Okio__OkioKt.toUByte((String) it.next())));
        }
        return StringsKt__StringsJVMKt.replace(StringsKt__StringsJVMKt.replace(Path.Companion.of$default(CollectionsKt.toByteArray(arrayList)).base64(), "+", "-", false), "/", "_", false);
    }
}
