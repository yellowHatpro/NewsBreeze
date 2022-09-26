package org.yellowhatpro.newsbreeze.util

class Resource<T>(val status: Status, val data: T?) {

    enum class Status {
        LOADING, FAILED, SUCCESS
    }

    companion object {
        fun <S> failure(data : S? = null): Resource<S> {
            return Resource(Status.FAILED, data)
        }

        fun <S> loading(data: S? = null): Resource<S> {
            return Resource(Status.LOADING, data)
        }

        fun <S> success(data: S): Resource<S> {
            return Resource(Status.SUCCESS, data = data)
        }
    }
}