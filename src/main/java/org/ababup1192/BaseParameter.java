package org.ababup1192;

import org.mongodb.morphia.annotations.Embedded;

// 直接ジェネリクスを持たせるのではなく、このようにラップしたクラスを用意する, valueを必ず持たせるように
// Morphia の filterメソッドでバリデーションエラーを起こす
@Embedded
abstract class BaseParameter<T> {
    T value;

    BaseParameter() {
    }

    BaseParameter(T value){
        this.value = value;
    }
}
