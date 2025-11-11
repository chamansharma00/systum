#include<jni.h>
#include<stdio.h>
#include "demo.h"

JNIEXPORT jint JNICALL Java_demo_add(JNIEnv *env,jobject obj,jint a,jint b){
    return a+b;
}