#include <jni.h>
#include <string.h>
#include "CPPClasses/infixToPrefix.cpp"
#include "CPPClasses/postfixToPrefix.cpp"
#include "CPPClasses/postfixToInfix.cpp"
#include "CPPClasses/prefixToInfix.cpp"
#include "CPPClasses/prefixToPostfix.cpp"


extern "C" JNIEXPORT jstring JNICALL
Java_com_example_logicbox_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "By M & N";
    return env->NewStringUTF(hello.c_str());
}

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_logicbox_MainActivity6_infToPostFromJNI(JNIEnv* env,jobject /* this */ ,jstring s) {
    infixToPostfix o;
    std::string str =  env->GetStringUTFChars(s,0);
    std::string infixconversion=o.infToPost(str);
    return env->NewStringUTF(infixconversion.c_str());
}

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_logicbox_MainActivity6_infToPreFromJNI(JNIEnv* env,jobject /* this */ ,jstring s) {
    infixToPrefix o;
    std::string str =  env->GetStringUTFChars(s,0);
    std::string infixconversion=o.infToPre(str);
    return env->NewStringUTF(infixconversion.c_str());
}

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_logicbox_MainActivity7_postToInfFromJNI(JNIEnv* env,jobject /* this */ ,jstring s) {
    postfixToInfix o;
    std::string str =  env->GetStringUTFChars(s,0);
    std::string postfixconversion=o.postToInf(str);
    return env->NewStringUTF(postfixconversion.c_str());
}

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_logicbox_MainActivity7_postToPreFromJNI(JNIEnv* env,jobject /* this */ ,jstring s) {
    postfixToPrefix o;
    std::string str =  env->GetStringUTFChars(s,0);
    std::string postfixconversion=o.postToPre(str);
    return env->NewStringUTF(postfixconversion.c_str());
}

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_logicbox_MainActivity8_preToInfFromJNI(JNIEnv* env,jobject /* this */ ,jstring s) {
    prefixToInfix o;
    std::string str =  env->GetStringUTFChars(s,0);
    std::string prefixconversion=o.preToInfix(str);
    return env->NewStringUTF(prefixconversion.c_str());
}

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_logicbox_MainActivity8_preToPostFromJNI(JNIEnv* env,jobject /* this */ ,jstring s) {
    prefixToPostfix o;
    std::string str =  env->GetStringUTFChars(s,0);
    std::string prefixconversion=o.preToPost(str);
    return env->NewStringUTF(prefixconversion.c_str());
}


