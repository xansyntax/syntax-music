package kotlinx.serialization.internal;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.ResultKt;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.StructureKind$MAP;
import okio.Okio__OkioKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public class PluginGeneratedSerialDescriptor implements SerialDescriptor, CachedNames {
    public final Lazy _hashCode$delegate;
    public int added = -1;
    public final Lazy childSerializers$delegate;
    public final int elementsCount;
    public final boolean[] elementsOptionality;
    public final GeneratedSerializer generatedSerializer;
    public Map indices;
    public final String[] names;
    public final List[] propertiesAnnotations;
    public final String serialName;
    public final Lazy typeParameterDescriptors$delegate;

    public PluginGeneratedSerialDescriptor(String str, GeneratedSerializer generatedSerializer, int i) {
        this.serialName = str;
        this.generatedSerializer = generatedSerializer;
        this.elementsCount = i;
        String[] strArr = new String[i];
        final byte b = 0;
        for (int i2 = 0; i2 < i; i2++) {
            strArr[i2] = "[UNINITIALIZED]";
        }
        this.names = strArr;
        int i3 = this.elementsCount;
        this.propertiesAnnotations = new List[i3];
        this.elementsOptionality = new boolean[i3];
        this.indices = EmptyMap.INSTANCE;
        Function0 function0 = new Function0(this) { // from class: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor$$ExternalSyntheticLambda0
            public final /* synthetic */ PluginGeneratedSerialDescriptor f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KSerializer[] kSerializerArrChildSerializers;
                ArrayList arrayList;
                KSerializer[] kSerializerArrTypeParametersSerializers;
                byte b2 = b;
                PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = this.f$0;
                switch (b2) {
                    case 0:
                        GeneratedSerializer generatedSerializer2 = pluginGeneratedSerialDescriptor.generatedSerializer;
                        return (generatedSerializer2 == null || (kSerializerArrChildSerializers = generatedSerializer2.childSerializers()) == null) ? EnumsKt.EMPTY_SERIALIZER_ARRAY : kSerializerArrChildSerializers;
                    case 1:
                        GeneratedSerializer generatedSerializer3 = pluginGeneratedSerialDescriptor.generatedSerializer;
                        if (generatedSerializer3 == null || (kSerializerArrTypeParametersSerializers = generatedSerializer3.typeParametersSerializers()) == null) {
                            arrayList = null;
                        } else {
                            arrayList = new ArrayList(kSerializerArrTypeParametersSerializers.length);
                            for (KSerializer kSerializer : kSerializerArrTypeParametersSerializers) {
                                arrayList.add(kSerializer.getDescriptor());
                            }
                        }
                        return EnumsKt.compactArray(arrayList);
                    default:
                        return Integer.valueOf(EnumsKt.hashCodeImpl(pluginGeneratedSerialDescriptor, (SerialDescriptor[]) pluginGeneratedSerialDescriptor.typeParameterDescriptors$delegate.getValue()));
                }
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
        this.childSerializers$delegate = ResultKt.lazy(lazyThreadSafetyMode, function0);
        final byte b2 = 1;
        this.typeParameterDescriptors$delegate = ResultKt.lazy(lazyThreadSafetyMode, new Function0(this) { // from class: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor$$ExternalSyntheticLambda0
            public final /* synthetic */ PluginGeneratedSerialDescriptor f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KSerializer[] kSerializerArrChildSerializers;
                ArrayList arrayList;
                KSerializer[] kSerializerArrTypeParametersSerializers;
                byte b3 = b2;
                PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = this.f$0;
                switch (b3) {
                    case 0:
                        GeneratedSerializer generatedSerializer2 = pluginGeneratedSerialDescriptor.generatedSerializer;
                        return (generatedSerializer2 == null || (kSerializerArrChildSerializers = generatedSerializer2.childSerializers()) == null) ? EnumsKt.EMPTY_SERIALIZER_ARRAY : kSerializerArrChildSerializers;
                    case 1:
                        GeneratedSerializer generatedSerializer3 = pluginGeneratedSerialDescriptor.generatedSerializer;
                        if (generatedSerializer3 == null || (kSerializerArrTypeParametersSerializers = generatedSerializer3.typeParametersSerializers()) == null) {
                            arrayList = null;
                        } else {
                            arrayList = new ArrayList(kSerializerArrTypeParametersSerializers.length);
                            for (KSerializer kSerializer : kSerializerArrTypeParametersSerializers) {
                                arrayList.add(kSerializer.getDescriptor());
                            }
                        }
                        return EnumsKt.compactArray(arrayList);
                    default:
                        return Integer.valueOf(EnumsKt.hashCodeImpl(pluginGeneratedSerialDescriptor, (SerialDescriptor[]) pluginGeneratedSerialDescriptor.typeParameterDescriptors$delegate.getValue()));
                }
            }
        });
        final byte b3 = 2;
        this._hashCode$delegate = ResultKt.lazy(lazyThreadSafetyMode, new Function0(this) { // from class: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor$$ExternalSyntheticLambda0
            public final /* synthetic */ PluginGeneratedSerialDescriptor f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KSerializer[] kSerializerArrChildSerializers;
                ArrayList arrayList;
                KSerializer[] kSerializerArrTypeParametersSerializers;
                byte b4 = b3;
                PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = this.f$0;
                switch (b4) {
                    case 0:
                        GeneratedSerializer generatedSerializer2 = pluginGeneratedSerialDescriptor.generatedSerializer;
                        return (generatedSerializer2 == null || (kSerializerArrChildSerializers = generatedSerializer2.childSerializers()) == null) ? EnumsKt.EMPTY_SERIALIZER_ARRAY : kSerializerArrChildSerializers;
                    case 1:
                        GeneratedSerializer generatedSerializer3 = pluginGeneratedSerialDescriptor.generatedSerializer;
                        if (generatedSerializer3 == null || (kSerializerArrTypeParametersSerializers = generatedSerializer3.typeParametersSerializers()) == null) {
                            arrayList = null;
                        } else {
                            arrayList = new ArrayList(kSerializerArrTypeParametersSerializers.length);
                            for (KSerializer kSerializer : kSerializerArrTypeParametersSerializers) {
                                arrayList.add(kSerializer.getDescriptor());
                            }
                        }
                        return EnumsKt.compactArray(arrayList);
                    default:
                        return Integer.valueOf(EnumsKt.hashCodeImpl(pluginGeneratedSerialDescriptor, (SerialDescriptor[]) pluginGeneratedSerialDescriptor.typeParameterDescriptors$delegate.getValue()));
                }
            }
        });
    }

    public final void addElement(String str, boolean z) {
        str.getClass();
        int i = this.added + 1;
        this.added = i;
        String[] strArr = this.names;
        strArr[i] = str;
        this.elementsOptionality[i] = z;
        this.propertiesAnnotations[i] = null;
        if (i == this.elementsCount - 1) {
            HashMap map = new HashMap();
            int length = strArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                map.put(strArr[i2], Integer.valueOf(i2));
            }
            this.indices = map;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PluginGeneratedSerialDescriptor) {
            SerialDescriptor serialDescriptor = (SerialDescriptor) obj;
            if (this.serialName.equals(serialDescriptor.getSerialName()) && Arrays.equals((SerialDescriptor[]) this.typeParameterDescriptors$delegate.getValue(), (SerialDescriptor[]) ((PluginGeneratedSerialDescriptor) obj).typeParameterDescriptors$delegate.getValue())) {
                int elementsCount = serialDescriptor.getElementsCount();
                int i = this.elementsCount;
                if (i == elementsCount) {
                    for (int i2 = 0; i2 < i; i2++) {
                        if (Intrinsics.areEqual(getElementDescriptor(i2).getSerialName(), serialDescriptor.getElementDescriptor(i2).getSerialName()) && Intrinsics.areEqual(getElementDescriptor(i2).getKind(), serialDescriptor.getElementDescriptor(i2).getKind())) {
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final List getAnnotations() {
        return EmptyList.INSTANCE;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final List getElementAnnotations(int i) {
        List list = this.propertiesAnnotations[i];
        return list == null ? EmptyList.INSTANCE : list;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public SerialDescriptor getElementDescriptor(int i) {
        return ((KSerializer[]) this.childSerializers$delegate.getValue())[i].getDescriptor();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final int getElementIndex(String str) {
        str.getClass();
        Integer num = (Integer) this.indices.get(str);
        if (num != null) {
            return num.intValue();
        }
        return -3;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final String getElementName(int i) {
        return this.names[i];
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final int getElementsCount() {
        return this.elementsCount;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public Okio__OkioKt getKind() {
        return StructureKind$MAP.INSTANCE$1;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final String getSerialName() {
        return this.serialName;
    }

    @Override // kotlinx.serialization.internal.CachedNames
    public final Set getSerialNames() {
        return this.indices.keySet();
    }

    public int hashCode() {
        return ((Number) this._hashCode$delegate.getValue()).intValue();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final boolean isElementOptional(int i) {
        return this.elementsOptionality[i];
    }

    public final void pushAnnotation(Annotation annotation) {
        annotation.getClass();
        int i = this.added;
        List[] listArr = this.propertiesAnnotations;
        List arrayList = listArr[i];
        if (arrayList == null) {
            arrayList = new ArrayList(1);
            listArr[this.added] = arrayList;
        }
        arrayList.add(annotation);
    }

    public String toString() {
        return EnumsKt.toStringImpl(this);
    }
}
