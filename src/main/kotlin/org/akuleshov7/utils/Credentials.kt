package org.akuleshov7.utils

@Suppress("MULTIPLE_INIT_BLOCKS")
class Credentials(auth: String) {
    val gitHubUserName: String
    val gitHubAuthToken: String

    init {
        val splitAuth = auth.split(":")
        if (splitAuth.size != 2) {
            """Incorrect value is passed with 'auth' property.
                    | It should contain user and auth-token separated by a colon (':').
                    | This option is needed to extend the limit of requests.""".trimMargin() logAndExit 8
        }
        gitHubUserName = splitAuth[0]
        gitHubAuthToken = splitAuth[1]
    }
}
