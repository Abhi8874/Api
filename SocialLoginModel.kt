package com.aws.apiproject.model

data class SocialLoginModel(
    var `data`: Data?,
    var message: String?,
    var success: Boolean?
) {
    data class Data(
        var aouth: String?,
        var isAdmin: Int?,
        var key: String?,
        var hello: String = "hello"
    )
}