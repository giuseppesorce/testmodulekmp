package com.test.preview

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform