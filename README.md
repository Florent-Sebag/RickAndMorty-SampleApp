# Marvel-Sample-App

A sample app in a modulable MVVM/Clean architecture

## Description 

This app uses the MVVM pattern combined with the clean architecture.
The 3 parts of this architecture presenter/domain/data are in a different module, in order to get more independent layers.

To sum up : 
- The data layer implements the domain but does not know the presenter 
- The domain layer does not know any layer 
- The presenter layer implements the domain and does not know the data one

There is also an app module that contains the Application class.

## How to run it

This project uses the secrets-gradle-plugin library in order to get the ApiKey.
To run the project, you have to write on 

>local.properties 

your publicKey & privateKey of the Marvel API, like this :

```
sdk.dir=..........

publicKey=[yourpublickey]
privateKey=[yourprivatekey]
```

## Flavors

You will find on this app 2 flavors :
- Mock : In order to get mocked data
- Prod : In order to get data from API

The mocked data is sent thanks to a OkHttp Interceptor, implementing an entire framework (mockito) for only 2 calls would have been too heavy.

## Libraries used 

- Moshi - handling JSON files
- Okhttp - For adding the Authtoken & MockInterceptor
- Retrofit - For API Calls

- Rxjava - for reactive programming 
- Dagger2 - for dependency injection

- Secret-Gradle-Plugin - For hiding apikeys 
- Paging 3 - for infinite scroll (Implemented with RxJava) 
- Material design - Front elements
- Glide - For printing images
