package developer.abdulaziz.valyutawithservice.Retrofit

object MyCommon {
    private val BASE_URL = "http://cbu.uz/uzc/arkhiv-kursov-valyut/"
    val retrofitService: MyRetrofitInterface
        get() = MyApiClient.getClient(BASE_URL).create(MyRetrofitInterface::class.java)
}