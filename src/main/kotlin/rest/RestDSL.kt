package rest

import kotlin.reflect.KClass


class RestOperationBuilder {
    lateinit var url: String

    fun request(block: RequestBuilder.() -> Unit) {

    }

    fun response(block: ResponseBuilder.() -> Unit) {

    }

}

class QueryParamsBuilder {
    var queryParamList = mutableListOf<String>()

    operator fun String.unaryPlus() {
        queryParamList.add(this)
    }
}

class HeadersBuilder {
    var headers = mutableListOf<String>()

    operator fun String.unaryPlus() {
        headers.add(this)
    }

}

class RequestBuilder {
    lateinit var body: String
    var queryParamList = mutableListOf<String>()
    var headerList = mutableListOf<String>()

    fun queryParams(block: QueryParamsBuilder.() -> Unit) {
        val queryParamsBuilder = QueryParamsBuilder()
        queryParamsBuilder.block()
        queryParamList = queryParamsBuilder.queryParamList
    }

    fun headers(block: HeadersBuilder.() -> Unit) {
        val headerBuilder = HeadersBuilder()
        headerBuilder.block()
        headerList = headerBuilder.headers
    }

}

class ErrorHandlerBuilder {
    var handlers = mapOf<Int, java.lang.RuntimeException>()

    infix fun Int.doThrow(exception: RuntimeException) {
        handlers.plus(this to exception)
    }
}

class ResponseBuilder {
    var errorHandlers = mapOf<Int, java.lang.RuntimeException>()

    fun errorHandlers(block: ErrorHandlerBuilder.() -> Unit) {
        val errorHandlerBuilder = ErrorHandlerBuilder()
        errorHandlerBuilder.block()
        errorHandlers = errorHandlerBuilder.handlers
    }

    lateinit var wrapper: String
    lateinit var type: KClass<String>
}

object get {
    operator fun invoke(url: String, block: RestOperationBuilder.() -> Unit): RestOperationBuilder {
        val restClientBuilder = RestOperationBuilder()
        restClientBuilder.block()
        restClientBuilder.url = url
        return restClientBuilder
    }
}

class RestDSL {

    companion object {
        @JvmStatic fun main(args: Array<String>) {
            get("www.google.com") {
                request {
                    queryParams {
                        +"param"
                    }
                    headers {
                        +"header"
                    }
                    body = "model"
                }
                response {
                    type = String::class
                    wrapper = "jsonField"
                    errorHandlers {
                        400 doThrow IllegalArgumentException()
                    }
                }
            }
        }
    }
}
