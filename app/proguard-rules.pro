# Proguard rules for Retrofit, SimpleXML, and Gson
-keepattributes Signature, InnerClasses, EnclosingMethod
-keepattributes RuntimeVisibleAnnotations, RuntimeVisibleParameterAnnotations
-keepattributes AnnotationDefault

# Retrofit
-dontwarn retrofit2.**
-keep class retrofit2.** { *; }

# Gson
-keepclassmembers class * {
    @com.google.gson.annotations.SerializedName <fields>;
}

# SimpleXML
-dontwarn org.simpleframework.xml.**
-keep class org.simpleframework.xml.** { *; }
-keep @org.simpleframework.xml.Root class * { *; }
-keepclassmembers class * {
    @org.simpleframework.xml.* <fields>;
    @org.simpleframework.xml.* <methods>;
}

# Entités
-keep class ma.projet.restclient.entities.** { *; }

