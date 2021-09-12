[![Build](https://github.com/ImnIrdst/ii4sq/actions/workflows/build.yml/badge.svg)](https://github.com/ImnIrdst/ii4sq/actions/workflows/build.yml)
[![Test](https://github.com/ImnIrdst/ii4sq/actions/workflows/test.yml/badge.svg)](https://github.com/ImnIrdst/ii4sq/actions/workflows/test.yml)
[![Detekt](https://github.com/ImnIrdst/ii4sq/actions/workflows/detekt-analysis.yml/badge.svg?branch=main)](https://github.com/ImnIrdst/ii4sq/actions/workflows/detekt-analysis.yml)

# ii4sq
A playground android app, showcasing the latest technologies and architecture patterns using the [Foursquare APIs](https://developer.foursquare.com/).

# Demo
<span><img src="https://github.com/ImnIrdst/ii4sq/raw/main/demo/demo.gif" width="170" height="350"></span>

# Build
Clone the repository and get an [API key](https://developers.google.com/maps/documentation/android-sdk/start) for the Google Maps API and [Client Id & Secret](https://developer.foursquare.com/) for the 4Square API and put them in the `local.properties` file as below:

```properties
MAPS_API_KEY=YOUR_API_KEY
FOURSQUARE_CLIENT_ID="YOUR_FOURSQUARE_CLIENT_ID"
FOURSQUARE_CLIENT_SECRET="YOUR_FOURSQUARE_CLIENT_SECRET"
```

# Technologies

- Kotlin 
- Coroutines
- Koin
- Navigation Component
- LiveData
- ViewModel
- Room
- Retrofit
- OkHttp3
- jUnit
- Mockk

# Architecture
A custom architecture inspired by the [Google MVVM](https://developer.android.com/jetpack/guide) and the [Clean architecture](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html).

This architecture allows app to be offline first. It gets data from the network if it doesn't exist in the local database and persists it. Local database is the single source of truth of the app and after its data changes, it notifies other layers using coroutines. 
