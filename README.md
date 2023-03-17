# RickAndMorty-SampleApp

A sample app in a modulable MVVM/Clean architecture

## Description 

This app uses the MVVM pattern combined with the clean architecture.
The 3 parts of this architecture presenter/domain/data are in a different module, in order to get more independent layers.

To sum up : 
- The data layer implements the domain but does not know the presenter 
- The domain layer does not know any layer 
- The presenter layer implements the domain and does not know the data one

There is also an app module that contains the Application class.

## Flavors

You will find on this app 2 flavors :
- Mock : In order to get mocked data
- Prod : In order to get data from API

The mocked data is sent thanks to a OkHttp Interceptor.
## Libraries used 

- Moshi - handling JSON files
- Okhttp - For adding the Authtoken & MockInterceptor
- Retrofit - For API Calls

- Rxjava - Reactive programming 
- Dagger2 - Dependency injection
 
- Paging 3 - Infinite scroll (Implemented with RxJava) 
- Material design - Front elements
- Glide - Printing & cache images

- Junit - Unit testing
- Mockito - Mocking data in unit tests 
