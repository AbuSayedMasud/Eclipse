package com.leadsoft.ziskapharma

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform