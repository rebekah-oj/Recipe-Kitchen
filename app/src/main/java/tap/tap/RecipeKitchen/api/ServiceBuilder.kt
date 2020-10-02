package tap.tap.RecipeKitchen.api

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response

object ServiceBuilder {

    var client: OkHttpClient = OkHttpClient()

    var request: Request = Builder()
        .url("https://tasty.p.rapidapi.com/recipes/list?tags=under_30_minutes&from=0&sizes=20")
        .get()
        .addHeader("x-rapidapi-host", "tasty.p.rapidapi.com")
        .addHeader("x-rapidapi-key", "f5e2b27717mshabeae9ae50962e2p13110djsn019ee0510122")
        .build()

    var response: Response = client.newCall(request).execute()
}