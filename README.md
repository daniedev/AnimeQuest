# AnimeQuest 

A basic anime listing app built using Jetpack Compose and the Jikan API. You can browse popular anime, view details, and watch trailers (if available).

---

## Assumptions

- Trailer videos are expected to be from YouTube.
- No local storage or caching is included.
- The app is designed for online use only (needs internet access).

---

## Features

- Clean architecture with `data`, `domain`, and `app` modules
- Hilt for dependency injection
- Uses Jetpack Compose for UI and state management

---

## Known Issues / Limitations

- Only the first page of top anime is loaded (no pagination yet)
- No proper error messages or retry options

---

## To Do

- Add search and pagination
- Show error states and loading indicators
- Add offline support
- Write unit and UI tests

---
